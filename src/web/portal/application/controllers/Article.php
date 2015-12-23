<?php
/**
 * @name ArticleController
 * @author xuebingwang
 * @desc 文章控制器
 * @see http://www.php.net/manual/en/class.yaf-controller-abstract.php
*/
class ArticleController extends MallController {

    public function infoAction($id=0){

        $model = new Model('t_document_article');
        $item = $model->get(['[><]t_document'=>['id'=>'id']],['t_document.title','t_document_article.content'],['t_document.id'=>$id]);
        $this->getView()->assign('item',$item);
    }

    public function listAction($cate_id=0){

        $cate_id = intval($cate_id);
        $this->getView()->assign('cate_name',M('t_category')->get('title',['id'=>$cate_id]));
        $model = new Model('t_document');
        $list = $model->select(
                                ['t_document.id','title','description','t_document.update_time'],
                                ['AND'=>['category_id'=>$cate_id,'t_document.status'=>1]]
                            );

        $this->getView()->assign('list',$list);
    }
}
