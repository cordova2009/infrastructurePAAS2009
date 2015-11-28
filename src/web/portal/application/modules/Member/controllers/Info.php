<?php
/**
 * @name IndexController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class InfoController extends MemberController {

    public function safeAction(){

        $this->meta_title = '安全信息';
        $curl = new Curl($this->config->url->api->user);

        $resp = $curl->setData(['token'=>$this->user['token']])
                        ->send('userSecurity/getUserSecurityInfo');

        if(check_resp($resp)) {
            
        }
        $this->getView()->assign('user',$this->user);
    }
    /**
     * 默认动作，首页
     * Yaf支持直接把Yaf\Request_Abstract::getParam()得到的同名参数作为Action的形参
     * 对于如下的例子, 当访问http://yourhost/y/index/index/index/name/yantze 的时候, 你就会发现不同
     */
    public function indexAction(){

        $this->meta_title = '基本信息';
        $this->getView()->assign('user',$this->user);
    }

    public function editAction(){
        if(IS_POST){
            $data = ['token'=>$this->user['token']];
            $data['nickname'] = I('nickname');
            if(empty($data['nickname'])){
                $this->error('昵称不能为空！');
            }
            $data['email'] = I('email');
//            if(empty($data['email'])){
//                $this->error('邮箱不能为空！');
//            }
            $data['address'] = I('address');
//            if(empty($data['address'])){
//                $this->error('联系地址不能为空！');
//            }

            $curl = new Curl($this->config->url->api->user);

            $resp = $curl->setData($data)->send('userCenter/updateUserInfo');

            if(check_resp($resp)) {

                session('user_auth',array_merge($this->user,$data));
                $this->success('保存成功！',U('/member/info/index'));
            }else{
                $this->error(isset($resp['errmsg']) ? $resp['errmsg'] : '登录失败，请重新再试！');
            }

            $this->error(var_export($data,true));
        }

        $this->meta_title = '基本信息';
        $this->getView()->assign('user',$this->user);
    }
}
