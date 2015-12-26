<?php
/**
 * @name ProjectController
 * @author libaoling
 * @desc 招标项目控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class ProjectController extends MallController
{
    private $pageSize = 2;
    
    public function init(){
        parent::init();
    }

    /**
     * 举报
     */
    public function reportAction(){
        if(IS_POST)
        {
            $data = ['token'=>$this->user['token']];
            $data['reportType'] = I('reportType');
            $data['refType'] ='TER';
            $data['refId']=I('objectId');
            $data['reportContent']=I('reportContent');
            $curl = new Curl($this->config->url->api->paas);
            $resp = $curl->setData($data)->send('report/submitReport');
            if(check_resp($resp)) {
                $this->success('保存成功！',U('/project/list'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '数据保存失败，请重新再试！');
            }
        }
    }

    /**
     * 招标项目列表
     */
    public function listAction(){
        $curl = new Curl($this->config->url->api->paas);
        $resp = $curl->setData(new stdClass())->send('tender/getIndustryList');
        if(!check_resp($resp)) {
            $this->error($resp['errmsg']);
        }
        $industry_list = [];
        foreach($resp['list'] as $v){
            $industry_list[$v['industryId']] = $v['industryIcon'];
        }
        $this->assign('industry_list',$industry_list);

        $keyword    = $this->getRequest()->getQuery('keyword');
        $pageIndex  = $this->getRequest()->getQuery('page', 0);

        $tmp        = str_replace(array(',', '、', ' '), ',', $keyword);
        $keywords   = explode(',', $tmp);

        $curl       = new Curl();
        $resp       = $curl->setData([
                                'keywords'  => $keywords,
                                'pageIndex' => $pageIndex,
                                'pageSize'  =>  $this->pageSize
                            ])->send('tender/queryObjectList_homepage');

        $list = [];
        if(check_resp($resp)){
            $list = $resp['list'];
            $page = $this->getPagination($resp['total'], $this->pageSize);
            $this->assign('page', $page);
        }

        $this->assign('list', $list);
        $this->layout->meta_title = '招标项目列表';
    }

    /**
     * 中标结果列表
     */
    public function bidlistAction() {
        $pageSize = 10;
        $pageIndex = $this->getRequest()->getQuery('page', 0);

        $curl = new Curl();
        $resp = $curl->setData([
            'pageIndex' => $pageIndex,
            'pageSize'=>  $pageSize
        ])->send('tender/queryBidIndexList');
        
        $list = [];
        if(check_resp($resp)){
            $list = $resp['list'];
            $page = $this->getPagination($resp['total'], $pageSize);
            $this->assign('page', $page);
        }
        $this->assign('list', $list);
        $this->layout->meta_title = "中标结果列表";
    }

    /**
     * 招标详情
     */
    public function detailAction(){

        if(empty($this->user)){
            $this->redirect(U('/login'));
        }
        $objectId =I('objectId');

        $curl = new Curl();
        $resp = $curl->setData([
                                            'token' => $this->user['token'],
                                            'objectId'=> $objectId
                                        ])
                            ->send('bid/queryObjectDetail');


        if(!check_resp($resp)) {
            $this->error('项目不存在！');
        }
        $info                   = $resp['body'];
        $survey                 = $resp['body']['survey'];
        $baseInfo               = $resp['body']['detail']['baseInfo'];
        $projectInfo            = $resp['body']['detail']['projectInfo'];
        $constructionInfo       = $resp['body']['detail']['constructionInfo'];
        $projectRequirementInfo = $resp['body']['detail']['projectRequirementInfo'];
        $bondInfo               = $resp['body']['detail']['bondInfo'];
        $bidderCertificationInfo= $resp['body']['detail']['bidderCertificationInfo'];
        $bidFileTypeInfo        = $resp['body']['detail']['bidFileTypeInfo'];
        $objectMethodInfo       = $resp['body']['detail']['objectMethodInfo'];
        $answerQuestion         = $resp['body']['detail']['answerQuestion'];
        $dateRequirementInfo    = $resp['body']['detail']['dateRequirementInfo'];
        $bidEvaluationTypeInfo  = $resp['body']['detail']['bidEvaluationTypeInfo'];
        //倒计时
        $date1                  = strtotime($survey['biddingEndTime']);  //把日期转换成时间戳
        $date2                  = time(); //取当前时间的时间戳
        $days                   = floor(($date1-$date2)/3600/24)<0?0:floor(($date1-$date2)/3600/24);  //四舍五入
        $hours                  = ((floor(($date1-$date2)/3600))%24)<0?0:(floor(($date1-$date2)/3600))%24;
        $mins                   = floor(($date1-$date2)/60)%60<0?0:floor(($date1-$date2)/60)%60;

        $daojishi               = $days.'天'.$hours.'时'.$mins.'分';
        $this->assign('daojishi', $daojishi);
        $this->assign('survey', $survey);
        $this->assign('info', $info);
        $this->assign('baseInfo', $baseInfo);
        $this->assign('projectInfo', $projectInfo);
        $this->assign('constructionInfo', $constructionInfo);
        $this->assign('projectRequirementInfo', $projectRequirementInfo);
        $this->assign('bondInfo', $bondInfo);
        $this->assign('bidderCertificationInfo', $bidderCertificationInfo);
        $this->assign('bidFileTypeInfo', $bidFileTypeInfo);
        $this->assign('objectMethodInfo', $objectMethodInfo);
        $this->assign('answerQuestion', $answerQuestion);
        $this->assign('dateRequirementInfo', $dateRequirementInfo);
        $this->assign('bidEvaluationTypeInfo', $bidEvaluationTypeInfo);
    }
    public function informationListAction(){
        /*"body":{
            "token":"12345",
            "pageIndex":1,
            "pageSize":10,
            "status":"CRT"
        }*/
        $pageSize = 10;
        $status = 'OK#';
        $curl1 = new Curl($this->config->url->api->paas);
        $pageIndex = $this->getRequest()->getQuery('page', 0);
        $resp2 = $curl1->setData([
            'pageSize'=> $pageSize,
            'pageIndex' => ($pageIndex==0?1:$pageIndex),
            'status'=> $status
        ])->send('userInformation/queryUserInformationIndexPage');

        if(check_resp($resp2)) {
            $list = $resp2['list'];
            $page = $this->getPagination($resp2['total'], $pageSize);
            $this->assign('page', $page);
        }
        $this->assign('list',$list);
        $this->meta_title = '项目信息列表';
    }
}
