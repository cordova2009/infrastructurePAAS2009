<?php
class OrderModel extends Model{

    public $table = 't_orders';

    /**
     * 已删除
     * @var int
     */
    const STATUS_DELETED    = 'DEL';

    /**
     * 已取消
     * @var int
     */
    const STATUS_CANCELLED  = 'YQX';

    /**
     * 待付款
     * @var unknown
     */
    const STATUS_WATI_PAY   = 'CRT';

    /**
     * 待付款
     * @var unknown
     */
    const STATUS_WATI_ACTIVE   = 'DJH';


    /**
     * 已完成
     * @var int
     */
    const STATUS_COMPLETED  = 'OK#';

    /**
     * 未付款
     * @var int
     */
    const PAY_STATUS_NO_PAY = 1;

    /**
     * 已付款
     * @var int
     */
    const PAY_STATUS_PAYD   = 2;

    public static $status_text = array(
        'YQX'=>'已关闭',
        'CRT'=>'等待付款',
        'DJH'=>'待激活',
        'OK#'=>'已完成',
        'DEL'=>'已删除',
    );

    public static $pay_status_text = array(
        '',
        '未付款',
        '已付款',
    );
}