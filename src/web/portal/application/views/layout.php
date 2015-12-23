<!DOCTYPE HTML>
<html>
<head>
    <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>基建PAAS<?=isset($meta_title) ? '|'.$meta_title : ''?></title>
    <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <meta name="Author" Content="" />
    <meta name="Copyright" Content="深圳麦圈互动技术有限公司。All Rights Reserved" />

    <link href="/css/index.css?<?=md5_file('css/index.css')?>" rel="stylesheet" type="text/css" />
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <![endif]-->
    <block name="style"></block>
</head>
<body>
<div class="pg-container">
    <!--fly-html-->
    <!--header-->
    <block name="header">
    <header class="header ">
        <div class="top-txt clear">
            <div class="cent">
                <p class="left">您好，欢迎访问大力99！</p>
                <div class="right">
                    <?php if(empty($user)):?>
                    <a href="<?=U('/public/register')?>" class="blue">快速注册</a>
                    <a href="<?=U('/public/login')?>"  class="blue2 marl20">立即登录</a>
                    <?php else:?>
                    <a href="<?=U('/member/info/index')?>"  class="blue"><?=$user['nickname']?></a>你好
                    <a href="<?=U('/public/logout')?>"  class="blue2 marl20">[退出]</a>
                    <?php endif;?>
                    <a href="#" class="colorf marl20">帮助</a>
                </div>
            </div>
        </div>
        <div class="head-cont ">
            <div class="cent  clear">
                <div class="logo left"><a class="blue" href="/">大力99</a></div>
                <div class="right menu">
                    <ul>
                        <li><a href="<?=U('/')?>">首页</a></li>
                        <li><a href="<?=U('/member/tender/baseinfo')?>">我要招标</a></li>
                        <li><a href="<?=U('/project/list')?>">我要投标</a></li>
                        <li><a href="#">新手指引</a></li>
                        <li  class="submenu">
                            <span>会员服务 <i class="i-down"></i></span>
                            <dl>
                                <dd><a href="<?=U('/member/vip/terIndex')?>">招标人会员</a></dd>
                                <dd><a href="<?=U('/member/vip/bidIndex')?>">投标人会员</a></dd>
                            </dl>
                        </li>
                        <li><a href="#">关于我们</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </header>
    </block>
    <!--wrap-->
    <section class="wrap">
        <?php echo $content?>
    </section>

    <footer class="footer">
        <div class="cent">
            <div class="clear foot-cont">
                <div class="left">
                    <div class="footnav">
                        <a href="#">公司介绍</a>
                        <a href="#">安全保障</a>
                        <a href="#">媒体报道</a>
                        <a href="#">社会责任</a>
                        <a href="#">招贤纳士</a>
                        <a href="#">帮助中心</a>
                        <a href="#">联系我们</a>
                    </div>
                    <div class="footer-link">
                        <a href="#">客服电话</a>
                        <span class="tel">400-555-8888 </span>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</div>
<script src="/js/jquery-1.9.1.min.js"></script>
<script src="/js/jquery.SuperSlide.2.1.1.js"></script>
<script src="/js/common.js?<?=md5_file('js/common.js')?>"></script>
<script type="text/javascript" src="/js/layer/layer.min.js"></script>
<block name="script">

</block>
</body>
</html>
