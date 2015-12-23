<?php
/**
 * @name UploadController
 * @author xuebingwang
 * @desc 默认控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class UploadController extends MemberController {

    /**
     *上传图片
     */
    public function pictureAction(){
        $file = $this->getRequest()->getFiles('file');
        if(empty($file)){
            $this->error('上传图片失败，图片为空！');
        }

        $driver = $this->config->upload->driver;
        $config = $this->config->get($driver)->toArray();
        $config = array_merge($config,$config['picture']);
        $Upload = new Upload($this->config->upload->pic->toArray(), $driver, $config);
        $info   = $Upload->uploadOne($file);
        $width = I('width');
        $height = I('height');

        if(is_array($info) && isset($info['url'])){
            $this->ajaxReturn(
                                [
                                    'status'=>0,
                                    'msg'=>'上传成功',
                                    'url'=>$info['url'],
                                    'src'=>imageView2($info['url'],$width,$height)
                                ]
                            );
        }else{
            $msg = $Upload->getError();
            $this->error(empty($msg) ? '上传失败，请重新再试！' : $msg);
        }
    }

    /**
     *上传文件
     */
    public function fileAction(){
        $file = $this->getRequest()->getFiles('file');

        $driver = $this->config->upload->driver;

        $config = $this->config->get($driver)->toArray();
        $config = array_merge($config,$config['file']);
        $Upload = new Upload($this->config->upload->file->toArray(), $driver, $config);
        $info   = $Upload->uploadOne($file);
        if(is_array($info) && isset($info['url'])){
            $this->ajaxReturn(
                                [
                                    'status'=>0,
                                    'msg'=>'上传成功',
                                    'url'=>$info['url'],
                                    'src'=>get_qiniu_file_durl($info['url'])
                                ]
                            );
        }else{
            $this->error('上传失败，请重新再试！');
        }
    }
}
