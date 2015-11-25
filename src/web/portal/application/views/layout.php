<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>基建PAAS<?=isset($meta_title) ? '|'.$meta_title : ''?></title>
    <meta name="Author" Content="" />
    <meta name="Copyright" Content="深圳麦圈互动技术有限公司。All Rights Reserved" />

    <link href="/css/index.css?<?=md5_file('css/index.css')?>" rel="stylesheet" type="text/css" />
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/jquery.SuperSlide.2.1.1.js"></script>
    <script src="/js/common.js?<?=md5_file('/js/common.js')?>"></script>
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <![endif]-->
    <?php if(isset($block['style'])) echo $block['style']; ?>
</head>
<body>
<!--fly-html-->
<!--header-->
<header class="header ">
    <div class="top-txt clear">
        <div class="cent">
            <p class="left">您好，欢迎访问大力99！</p>
            <div class="right"><a href="#" class="blue">快速注册</a> <a href="#"  class="blue">立即登录</a> <a href="#" class="colorf">帮助</a></div>
        </div>
    </div>
    <div class="head-cont ">
        <div class="cent  clear">
            <div class="logo blue  left">大力99</div>
            <div class="right menu">
                <ul>
                    <li><a href="#">首页</a></li>
                    <li><a href="#">我要招标</a></li>
                    <li><a href="#">我要投标</a></li>
                    <li><a href="#">新手指引</a></li>
                    <li  class="submenu">
                        <span>会员服务 <i class="i-down"></i></span>
                        <dl>
                            <dd><a href="#">招标人会员</a></dd>
                            <dd><a href="#">投标人会员</a></dd>
                        </dl>
                    </li>
                    <li><a href="#">关于我们</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>

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
                    <a href="#">网站地图</a>
                    <a href="#">帮助中心</a>
                    <a href="#">联系我们</a>
                </div>
                <div class="footer-link">
                    <a href="#">客户服务</a>
                    <a href="#"><i class="footico fwb"></i> 新浪微博</a>
                    <a href="#" class="fz24"><i class="footico wx"></i> 微信</a>
                    <a href="#" class="fz24"><i class="footico kefu"></i> 在线客服</a>
                </div>
            </div>
            <div class="right foot-right">
                客服电话<br><span class="tel">400-555-8888 </span><br>9:00 - 21:00
            </div>
        </div>
    </div>
</footer>
<?php if(isset($block['script'])) echo $block['script']; ?>
</body>
</html>
