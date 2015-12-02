<?php
/**
 * @name UploadController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class UploadController extends MemberController {

    /**
     *上传头像
     */
    public function pictureAction(){
        $file = $this->getRequest()->getFiles('file');

        $driver = $this->config->upload->driver;
        $Upload = new Upload($this->config->upload->pic->toArray(), $driver, $this->config->get($driver)->toArray());
        $info   = $Upload->uploadOne($file);
        if(is_array($info) && isset($info['url'])){
            $this->ajaxReturn(
                                ['status'=>0,
                                    'msg'=>'上传成功',
                                    'url'=>$info['url'],
                                    'src'=>imageView2($info['url'])
                                ]
                            );
        }else{
            $this->error('上传失败，请重新再试！');
        }
    }
}
