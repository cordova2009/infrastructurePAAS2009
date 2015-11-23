<?php
/**
 * Created by PhpStorm.
 * User: xuebin<406964108@qq.com>
 * Date: 2014/12/27
 * Time: 14:27
 * @copyright Copyright (c) 2014
 */

class OrderController extends ServerController
{

    public function activateAction(){

        $userid = $this->user['userid'];

        $order = M('t_orders')->get(['sn','status'],['AND'=>['sn'=>$this->request_data['sn'],'userid'=>$userid,'status'=>OrderModel::STATUS_WATI_ACTIVE]]);

        if(empty($order)) {
            $this->sendError('订单不存在或已激活!');
        }

        $address_id = $this->request_data['address_id'];

        $address = [
            'consignee'=>$this->request_data['consignee'],
            'mobile'=>$this->request_data['mobile'],
            'idnum'=>$this->request_data['idnum']
        ];
        $model = new Model('t_user_address');
        if(empty($address_id)){
            $model->insert($address+['userid'=>$userid,'create_time'=>time_format()]);
        }else{
            $model->update($address,['id'=>$address_id]);
        }

        $address['sn'] = $order['sn'];

        $item = M('t_order_product')->get(
            ['[><]t_product'=>['product_id'=>'id'],],
            ['third_product_id','category_id','param1'],
            ['sn'=>$order['sn']]
        );

        if(empty($item)){
            $this->sendError('订单产品没有找到!');
        }

        $model = new Model('t_order_address');
        $oaf = $model->insert($address);

        $of = M('t_orders')->update(['status'=>OrderModel::STATUS_COMPLETED],['sn'=>$order['sn']]);

        if($oaf && $of){

            $this->sendSuccess('订单激活成功!');
        }else{
            $this->sendError('订单激活失败!');
        }
    }

    /**
     * 订单生成接口
     * @throws Exception
     */
    public function generateAction(){

        $userid = $this->user['userid'];
        $order  = [];
        $order['sn']            = gen_order_no();
        $order['amount']        = 0;
        $order['count_num']     = 0;

        $products = [];
        foreach($this->request_data['products'] as $product){
            $order['amount']    += $product['num'] * $product['price'];
            $order['count_num'] += $product['num'];

            $product['sn']           = $order['sn'];
            $product['priceall']     = $product['num'] * $product['price'];

            $products[]         = $product;
        }
        $order['userid']        = $userid;
        $order['add_ip']        = $this->request_data['add_ip'];
        $order['product_desc']  = $product['product_name'];

        $order['create_time']   = time_format();

        $model = new Model('t_orders');
        try{
            $model->getPDO()->beginTransaction();//开启事务处理
            $of = $model->insert($order,true);

            $model = new Model('t_order_product');
            $opf = $model->insert($products);

            $model = new Model('t_order_logs');
            $olf = $model->insert(['sn'=>$order['sn'],'userid'=>$userid,'comment'=>time_format().' '.$userid.'提交了订单!','create_time'=>time_format()]);

            $model->getPDO()->commit();
            if($of && $opf && $olf){

                $this->sendOutPut(['errmsg'=>'订单创建成功!','order_sn'=>$order['sn']]);
            }else{
                $model->getPDO()->rollback();
                $this->sendError('创建订单失败,未知错误!');
            }
        }catch(Exception $e){
            $this->sendError($e->getMessage());
            $model->getPDO()->rollback();
            $this->sendError('创建订单失败,未知错误!');
        }
    }

    public function getListAction(){

        $model      = new Model('t_orders');
        $where      = ['userid'=>$this->user['userid'],'status[>]'=>OrderModel::STATUS_DELETED];
        $pagenum    = intval($this->request_data['pagenum']);
        $limit      = intval($this->request_data['page']-1)*$pagenum;

        if($this->request_data['type'] == 'wait'){

            $where['status'] = OrderModel::STATUS_WATI_PAY;
            $where['pay_status'] = OrderModel::PAY_STATUS_NO_PAY;
        }elseif($this->request_data['type'] == 'comment'){

            $where['status'] = OrderModel::STATUS_COMPLETED;
            $where['pay_status'] = OrderModel::PAY_STATUS_PAYD;
            $where['has_remark'] = 0;
        }elseif($this->request_data['type'] == 'activate'){
            $where['status'] = OrderModel::STATUS_WATI_ACTIVE;
            $where['pay_status'] = OrderModel::PAY_STATUS_PAYD;
        }

        $list = $model->select('*',['AND'=>$where,'LIMIT'=>[$limit,$pagenum],'ORDER'=>'create_time DESC']);
//        echo $model->last_query();
        $model = new Model('t_order_product');
        foreach($list as &$item){
            $item['products'] = $model->select('*',['sn'=>$item['sn']]);
        }

        $this->request_data+= ['wait'=>1,'comment'=>1,'activate'=>1];
        if(empty($list)){
            $this->sendOutPut(['list'=>[],'total'=>$this->_total()]);
        }else{
            $this->sendOutPut(['list'=>$list,'total'=>$this->_total()]);
        }
    }

    private function _total(){
        $model      = new Model('t_orders');
        $where      = ['userid'=>$this->user['userid'],'status[>]'=>OrderModel::STATUS_DELETED];

        $total['all'] = $model->count(['AND'=>$where]);
        if(isset($this->request_data['wait']) && $this->request_data['wait']){

            $where['status'] = OrderModel::STATUS_WATI_PAY;
            $where['pay_status'] = OrderModel::PAY_STATUS_NO_PAY;
            $total['wait'] = $model->count(['AND'=>$where]);//待支付订单总数
        }

        if(isset($this->request_data['comment']) && $this->request_data['comment']){

            $where['status'] = OrderModel::STATUS_COMPLETED;
            $where['pay_status'] = OrderModel::PAY_STATUS_PAYD;
            $where['has_remark'] = 0;
            $total['comment'] = $model->count(['AND'=>$where]);//待支付订单总数
        }

        if(isset($this->request_data['activate']) && $this->request_data['activate']){

            $where['status'] = OrderModel::STATUS_WATI_ACTIVE;
            $where['pay_status'] = OrderModel::PAY_STATUS_PAYD;;
            $total['activate'] = $model->count(['AND'=>$where]);//待支付订单总数
        }

        return $total;
    }

    public function getTotalAction(){

        $this->sendOutPut($this->_total());
    }

    public function getDetailAction(){

        $model = new Model('t_orders');
        $where = ['sn'=>$this->request_data['sn'],'userid'=>$this->user['userid'],'status[>]'=>OrderModel::STATUS_DELETED];

        $order = $model->get('*',['AND'=>$where]);

        if(empty($order)){
            $this->sendError('数据为空!');
        }else{
            if(isset($this->request_data['need_p']) && $this->request_data['need_p']){
                $model = new Model('t_order_product');
                $order['products'] = $model->select('*',['sn'=>$order['sn']]);
            }
            if(isset($this->request_data['need_a']) && $this->request_data['need_a']){
                $model = new Model('t_order_address');
                $order['address'] = $model->get('*',['sn'=>$order['sn']]);
            }
            $this->sendOutPut($order);
        }
    }

    public function getAddressAction(){

        $model = new Model('t_orders');
        $order = $model->get('sn',['AND'=>['sn'=>$this->request_data['sn'],'userid'=>$this->user['userid'],'status[>]'=>OrderModel::STATUS_DELETED]]);

        if(empty($order)) {
            $this->sendError('订单不存在!');
        }

        $model = new Model('t_order_address');
        $address = $model->get('*',['sn'=>$this->request_data['sn']]);
        if(empty($address)){
            $this->sendError('数据为空!');
        }else{
            $this->sendOutPut($address);
        }
    }

    public function remarkAction(){

        //判断订单是否是当前用户所有
        $order = M('t_orders')->get(
            ['[><]t_order_product(p)'=>['sn'=>'sn']],
            ['t_orders.sn','t_orders.has_remark'],
            ['AND'=>[
                't_orders.sn'=>$this->request_data['sn'],
                'userid'=>$this->user['userid'],
                't_orders.status[>]'=>OrderModel::STATUS_DELETED,
                'p.product_id'=>$this->request_data['product_id']
            ]
            ]
        );

        if(empty($order)) {
            $this->sendError('订单不存在!');
        }

        //判断订单是否已经评论过
        if($order['has_remark'] || M('t_product_comment')->get('id',['AND'=>[
                                                    'userid'=>$this->user['userid'],
                                                    'sn'=>$this->request_data['sn'],
                                                    'product_id'=>$this->request_data['product_id'],
                                                    ]
                                            ]
                                    )){
            $this->sendError('您已经评价过此订单商品了!');
        }

        //插入评论内容
        $data = [
                    'product_id'=>$this->request_data['product_id'],
                    'userid'=>$this->user['userid'],
                    'sn'=>$this->request_data['sn'],
                    'content'=>$this->request_data['remark'],
                    'rate'=>$this->request_data['rate'],
                    'create_time'=>time_format(),
                ];
        if(M('t_product_comment')->insert($data)){
            //修改订单表的评论标志
            M('t_orders')->update(['has_remark'=>1],['AND'=>['sn'=>$this->request_data['sn']]]);

            $this->sendSuccess('评价成功,感谢您的评价!');
        }else{
            $this->sendError('评价失败,请重新再试!');
        }
    }

    public function deleteAction(){

        $where = [
            'AND'=>[
                'sn'=>$this->request_data['sn'],
                'userid'=>$this->user['userid'],
                'status[>]'=>OrderModel::STATUS_DELETED
            ]
        ];
        //判断订单是否是当前用户所有
        $order = M('t_orders')->get(['sn','status','pay_status'],$where);

        if(empty($order)){
            $this->sendError('订单不存在!');
        }elseif($order['status'] != OrderModel::STATUS_CANCELLED){
            $this->sendError('订单状态不允许删除!');
        }

        if(M('t_orders')->update(['status'=>OrderModel::STATUS_DELETED],$where)){
            $this->sendSuccess('取消订单成功!');
        }else{
            $this->sendError('取消订单失败,请重新再试!');
        }
    }

    public function closeAction(){

        $where = [
            'AND'=>[
                'sn'=>$this->request_data['sn'],
                'userid'=>$this->user['userid'],
                'status[>]'=>OrderModel::STATUS_DELETED
            ]
        ];
        //判断订单是否是当前用户所有
        $order = M('t_orders')->get(['sn','status','pay_status'],$where);

        if(empty($order)){
            $this->sendError('订单不存在!');
        }elseif($order['status'] != OrderModel::STATUS_WATI_PAY || $order['pay_status'] != OrderModel::PAY_STATUS_NO_PAY){
            $this->sendError('订单状态不允许取消!');
        }

        if(M('t_orders')->update(['status'=>OrderModel::STATUS_CANCELLED],$where)){
            $this->sendSuccess('取消订单成功!');
        }else{
            $this->sendError('取消订单失败,请重新再试!');
        }
    }
}
