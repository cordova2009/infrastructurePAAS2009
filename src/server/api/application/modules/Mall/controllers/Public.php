<?php
/**
 * Created by PhpStorm.
 * User: xuebin<406964108@qq.com>
 * Date: 2014/12/27
 * Time: 14:27
 * @copyright Copyright (c) 2014
 */

use Core\ServiceApi;

class PublicController extends ServiceApi
{
    /**
     * 登录接口
     * @author xuebing
     */
    public function getBannerListAction(){
        $model = new Model('t_banner');
        $data = $model->select(['id','name','link','pic','type'],['t_banner.status'=>'1']);
        if(empty($data))
        {
            $this->sendError('内容为空！','1001');
        }
        $this->sendOutPut(['list'=>$data]);

    }

    public function getOrderAction(){
        $model = new Model('t_orders');
        $column = ['sn','t_orders.userid','status','pay_code','pay_status','amount','add_ip','create_time','product_desc'];
        $order = $model->get($column,['sn'=>$this->request_data['sn']]);

        if(empty($order)){
            $this->sendError('数据为空!');
        }else{
            $this->sendOutPut($order);
        }
    }

    /**
     * 获取油站经纬度列表
     * @author xuebing
     */
    public function getStationMapListAction(){
        $a = $this->request_data['latitude'];
        if(empty($a)){
            $this->sendError('纬度不能为空!');
        }
        $b = $this->request_data['longitude'];
        if(empty($b)){
            $this->sendError('经度不能为空!');
        }

        $distance = 20000;
        if(isset($this->request_data['distance'])){
            $distance = $this->request_data['distance'];
        }

        $keyword = $this->request_data['keyword'];
        if(!empty($keyword)){
            $sql = "SELECT oil_station_name name,address,latitude,longitude from t_smjy_oil_station where name like '%$keyword%' or shot_name like '%$keyword%' or address like '%$keyword%'";
        }else{
            $sql = "SELECT oil_station_name name,address,latitude,longitude from t_smjy_oil_station where ROUND(6378.138*2*ASIN(SQRT(POW(SIN(($b*PI()/180-latitude*PI()/180)/2),2)+COS($b*PI()/180)*COS(latitude*PI()/180)*POW(SIN(($a*PI()/180-longitude*PI()/180)/2),2)))*1000) <= $distance  ";
        }

        $data = M()->query($sql)->fetchAll(PDO::FETCH_ASSOC);
        /*
                if(empty($data))
                {
                    $this->sendError('内容为空！','1001');
                }
        */
        $this->sendOutPut(['list'=>$data]);
    }

}
