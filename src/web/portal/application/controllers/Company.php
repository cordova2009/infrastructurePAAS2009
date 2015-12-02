<?php
/**
 * @name CompanyController
 * @author libaoling
 * @desc 公司控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class CompanyController extends MallController
{
    
    public function indexAction()
    {
        
        $companyId = $this->getRequest()->get('company_id', 0);
        $type = $this->getRequest()->get('type', '');
        
        if(empty($companyId) || empty($type)){
            $this->error('参数错误！');
        }
        
        $curl = new Curl();
        $resp = $curl->setData([
                'companyId' => $companyId,
                'type' => $type
        ])->send('/queryCompanyInfo');
        $info = [];
        if(check_resp($resp)){
            $info = $resp['info'];
        }
        
        $this->assign('info', $info);
        
    }
    
}
