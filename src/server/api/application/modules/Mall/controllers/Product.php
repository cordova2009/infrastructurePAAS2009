<?php
/**
 * Created by PhpStorm.
 * User: xuebin<406964108@qq.com>
 * Date: 2014/12/27
 * Time: 14:27
 * @copyright Copyright (c) 2014
 */

use Core\ServiceApi;

class ProductController extends ServiceApi
{

    public function getModuleProductsAction(){

       $products =  M('t_product_module')
            ->select(
                [
                    '[><]t_product(c)'=>['product_id'=>'id'],
                    '[><]t_picture(p)'=>['c.pic'=>'id']
                ],
                ['c.id','c.title','c.price','p.url(pic)'],
                ['module_id'=>$this->request_data['module_id'],'ORDER'=>'ordering']
            );

//        var_dump($modules);

        if(empty($products))
        {
            $this->sendError('内容为空！','1001');
        }
        $this->sendOutPut(['list'=>$products]);
    }

    public function getAMProductsAction(){

        $modules = M('t_page_modules')
                    ->select('*',['ORDER'=>'ordering','position'=>$this->request_data['position']]);

//        var_dump(M('t_page_modules')->last_query());
        foreach($modules as &$mo){
           $mo['products'] =  M('t_product_module')
                ->select(
                    [
                        '[><]t_product(c)'=>['product_id'=>'id'],
                    ],
                    ['c.id','c.title','c.price','product_pic'],
                    ['module_id'=>$mo['id'],'ORDER'=>'ordering','LIMIT'=>4]
                );

//            var_dump(M()->last_query());
        }

//        var_dump($modules);

        if(empty($modules))
        {
            $this->sendError('内容为空！','1001');
        }
        $this->sendOutPut(['list'=>$modules]);
    }

    public function getListAction(){

//        $sql = "SELECT
//                    a.id,
//                    title,
//                    price,
//                    url AS pic
//                FROM
//                    t_product a
//                LEFT JOIN t_picture b ON a.pic = b.id
//                WHERE
//                    a.status = '1'";
//        if(isset($this->request_data['category'])){
//            $category = $this->request_data['category'];
//            $sql .= " AND a.category_id = ".$category;
//        }
//
//        $sql .= ' order by update_time desc';
//
//
//        $model = new Model();
//        $query = $model->query($sql);
//
//        $data = $query ? $query->fetchAll(PDO::FETCH_ASSOC) : false;
//
        $model = M('t_product');

        $where = ['AND'=>['t_product.status'=>'1']];
        if(!empty($this->request_data['category'])){
            $where['AND']['category_id'] = $this->request_data['category'];
        }

        $where['ORDER'] = 'sort asc';
        $data = $model->select(
                                    ['[><]t_picture'=>['pic'=>'id']],
                                    [
                                    't_product.id',
                                    'title',
                                    'price',
                                    'url(pic)',
                                    ],
                                    $where
                                );
//        echo $model->last_query();

        if(empty($data))
        {
            $this->sendError('内容为空！','1001');
        }
        $this->sendOutPut(['list'=>$data]);
    }

    public function getDetailAction(){
        $id = $this->request_data['id'];
        if(empty($id)){
            $this->sendError('产品ID不能为空！','1001');
        }
        $model = new Model('t_product');
        $data = $model->get(
                            [
                                'id','title','price','earning',
                                'market_price','stock','meta_keyword',
                                'meta_description','description','sales_num',
                                'third_product_id'
                            ],
                            ['AND'=>['status'=>1,'id'=>$id]]
                        );
        $pic = new Model('t_picture');
        $pics = $pic->select(['[><]t_product_picture'=>['id'=>'picture_id']],'url(pic)',['AND'=>['status'=>'1','product_id'=>$id]]);
        if(empty($data))
        {
            $this->sendError('内容为空！','1001');
        }

        $where  = [
            'AND'=>
                [
                    'status'=>'1',
                    'product_id'=>$id
                ],
        ];

        $data['comment_total']  = M('t_product_comment')->count(['AND'=>$where]);//总数

        $data['pic'] = $pics;
        $this->sendOutPut(['info'=>$data]);
    }

    public function getInfoAction(){
        $id = $this->request_data['id'];
        $model = new Model('t_product');

        $data = $model->get(['description'],['AND'=>['status'=>'1','id'=>$id]]);
        if(empty($data)){
            $this->sendError("内容为空");
        }
        $this->sendOutPut($data);
    }

    public function getCommentsAction(){

        $pagenum    = intval($this->request_data['pagenum']);
        $limit      = intval($this->request_data['page']-1)*$pagenum;

        $where  = [
                    'AND'=>
                        [
                            't_product_comment.status'=>'1',
                            'product_id'=>$this->request_data['id']
                        ],
                 ];

        $total  = M('t_product_comment')->count($where);//总数

        $where['LIMIT'] = [$limit,$pagenum];
        $where['ORDER'] = 't_product_comment.create_time DESC';

        $list   = M('t_product_comment')->select(
                                                ['[><]t_ucenter_member(m)'=>['userid'=>'id']],
                                                ['mobile','content','rate','t_product_comment.create_time'],
                                                $where
                                            );


//        echo M('t_product_comment')->last_query();
//        echo PHP_EOL;
        if(empty($list)){

            $this->sendError('数据为空!');
        }else{
            $this->sendOutPut(['list'=>$list,'total'=>$total]);
        }
    }
}
