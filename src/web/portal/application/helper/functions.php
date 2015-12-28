<?php
// +----------------------------------------------------------------------
// | Copyright (c) 2006-2014 All rights reserved.
// +----------------------------------------------------------------------
// | Licensed ( http://www.apache.org/licenses/LICENSE-2.0 )
// +----------------------------------------------------------------------
// | Author: xuebing <406964108@qq.com>
// +----------------------------------------------------------------------

/**
 * 系统函数库
 */

/**
 * 使用正则验证数据
 * @access public
 * @param string $value  要验证的数据
 * @param string $rule 验证规则
 * @return boolean
 */
function regex($value,$rule) {
    $validate = array(
        'chinese'   =>  '/^[\x7f-\xff]+$/',
        'require'   =>  '/\S+/',
        'email'     =>  '/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/',
        'url'       =>  '/^http(s?):\/\/(?:[A-za-z0-9-]+\.)+[A-za-z]{2,4}(:\d+)?(?:[\/\?#][\/=\?%\-&~`@[\]\':+!\.#\w]*)?$/',
        'currency'  =>  '/^\d+(\.\d+)?$/',
        'number'    =>  '/^\d+$/',
        'zip'       =>  '/^\d{6}$/',
        'integer'   =>  '/^[-\+]?\d+$/',
        'double'    =>  '/^[-\+]?\d+(\.\d+)?$/',
        'english'   =>  '/^[A-Za-z]+$/',
	    'mobile'   =>  '/^(1[0-9])\d{9}$/',
        'telephone'   =>  '/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/',
    );
    // 检查是否有内置的正则表达式
    if(isset($validate[strtolower($rule)]))
        $rule       =   $validate[strtolower($rule)];
    return preg_match($rule,$value)===1;
}

function encrypt($data,$key=''){
    $size       = mcrypt_get_block_size(MCRYPT_DES, MCRYPT_MODE_CBC);
    $data       = pkcs5Pad($data, $size);
    $iv         = substr(strrev($key),0,8);
    $passcrypt  = @mcrypt_encrypt(MCRYPT_DES ,$key, $data, MCRYPT_MODE_CBC,$iv);
    return base64_encode($passcrypt);
}

function decrypt($data,$key=''){
    $iv     = substr(strrev($key),0,8);
    $str    = @mcrypt_decrypt(MCRYPT_DES,$key,base64_decode($data),MCRYPT_MODE_CBC,$iv);
    return pkcs5Unpad($str);
}

function pkcs5Unpad($text){
    $pad = ord($text[strlen($text)-1]);
    if($pad >strlen($text)){
        return false;
    }
    if($pad >strlen($text)){
        return false;
    }
    if(strspn($text,chr($pad),strlen($text)-$pad)!=$pad){
        return false;
    }
    return substr($text,0,-1*$pad);
}

function pkcs5Pad($text,$blocksize){
    $pad = $blocksize - (strlen($text) % $blocksize);
    return $text . str_repeat(chr($pad), $pad);
}

/**
 * 获取输入参数 支持过滤和默认值
 * 使用方法:
 * <code>
 * I('id',0); 获取id参数 自动判断get或者post
 * I('post.name','','htmlspecialchars'); 获取$_POST['name']
 * I('get.'); 获取$_GET
 * </code>
 * @param string $name 变量的名称 支持指定类型
 * @param mixed $default 不存在的时候默认值
 * @param mixed $filter 参数过滤方法
 * @param mixed $datas 要获取的额外数据源
 * @return mixed
 */
function I($name,$default='',$filter=null,$datas=null) {
    $app = Yaf\Application::app();

    if(strpos($name,'.')) { // 指定参数来源
        list($method,$name) =   explode('.',$name,2);
    }else{ // 默认为自动判断
        $method =   'param';
    }
    switch(strtolower($method)) {
        case 'get'     :   $input =& $_GET;break;
        case 'post'    :   $input =& $_POST;break;
        case 'put'     :   parse_str(file_get_contents('php://input'), $input);break;
        case 'param'   :
            switch($_SERVER['REQUEST_METHOD']) {
                case 'POST':
                    $input  = & $_POST;
                    break;
                case 'PUT':
                    parse_str(file_get_contents('php://input'), $input);
                    break;
                default:
                    $input  = & $_GET;
            }
            break;
        case 'path'    :
            $input  =   array();
            if(!empty($_SERVER['PATH_INFO'])){
                $input  =   explode('/',trim($_SERVER['PATH_INFO'],'/'));
            }
            break;
        case 'request' :   $input =& $_REQUEST;   break;
        case 'session' :   $input =& $_SESSION;   break;
        case 'cookie'  :   $input =& $_COOKIE;    break;
        case 'server'  :   $input =& $_SERVER;    break;
        case 'globals' :   $input =& $GLOBALS;    break;
        case 'data'    :   $input =& $datas;      break;
        default:
            return NULL;
    }

    if(''==$name) { // 获取全部变量
        $data       =   $input;
        $filters    =   isset($filter)?$filter:$app->getConfig()->get('default_filter');
        if($filters) {
            if(is_string($filters)){
                $filters    = explode(',',$filters);
            }
            foreach($filters as $filter){
                $data   = array_map_recursive($filter,$data); // 参数过滤
            }
        }
    }elseif(isset($input[$name])) { // 取值操作
        $data       =  $input[$name];
        $filters    =  isset($filter)?$filter:$app->getConfig()->get('application')->get('default_filter');
        if($filters) {
            if(is_string($filters)){
                $filters    = explode(',',$filters);
            }elseif(is_int($filters)){
                $filters    = array($filters);
            }

            foreach($filters as $filter){
                if(function_exists($filter)) {
                    $data  = is_array($data) ? array_map_recursive($filter,$data) : $filter($data); // 参数过滤
                }else{
                    $data = filter_var($data,is_int($filter)?$filter:filter_id($filter));
                    if(false === $data) {
                        return isset($default)?$default:NULL;
                    }
                }
            }
        }
    }else{ // 变量默认值
        $data       =    isset($default)?$default:NULL;
    }
    is_array($data) && array_walk_recursive($data,'think_filter');
    return $data;
}

function array_map_recursive($filter, $data) {
    $result = array();
    foreach ($data as $key => $val) {
        $result[$key] = is_array($val)
            ? array_map_recursive($filter, $val)
            : call_user_func($filter, $val);
    }
    return $result;
}

function think_filter(&$value){
    // TODO 其他安全过滤

    // 过滤查询特殊字符
    if(preg_match('/^(EXP|NEQ|GT|EGT|LT|ELT|OR|LIKE|NOTLIKE|BETWEEN|IN)$/i',$value)){
        $value .= ' ';
    }
}

function cms_url($path=''){
    return U($path,[],false,Yaf\Registry::get('config')->url->api->cms);
}
/**
 * URL组装 支持不同URL模式
 * @param string $url URL表达式，格式：'[模块/控制器/操作#锚点@域名]?参数1=值1&参数2=值2...'
 * @param string|array $vars 传入的参数，支持数组和字符串
 * @param string|boolean $suffix 伪静态后缀，默认为true表示获取配置值
 * @param boolean $domain 是否显示域名
 * @return string
 */
function U($url='',$vars='',$suffix=true,$domain=false) {

    if(!empty($url) && $suffix){
        $suffix = Yaf\Registry::get('config')->application->url_suffix;

        if($suffix && '/' != substr($url,-1)){
            $url  .=  '.'.ltrim($suffix,'.');
        }
    }

    // 解析参数
    if(is_string($vars)) { // aaa=1&bbb=2 转换成数组
        parse_str($vars,$vars);
    }elseif(!is_array($vars)){
        $vars = array();
    }

    if(!empty($vars)) {
        $vars   =   http_build_query($vars);
        $url   .=   '?'.$vars;
    }

    if($domain) {
        $url   =  $domain.$url;
    }
    return $url;
}

/**
 * @param $resp
 * @return bool
 */
function check_resp($resp){
    return !empty($resp) && $resp['errcode'] == '0';
}
/**
 * @param $mobile
 * @param $content
 * @return bool
 */
function send_sms($mobile){

    $config = Yaf\Registry::get('config');
    $curl = new Curl($config->url->api->user);
    $resp = $curl->setData(['mobileNum'=>$mobile])->send('userSecurity/getSmsCode');

    $return = false;
    if(!empty($resp) && $resp['errcode'] == 0){
        $return = true;
    }

    return $return;
}
/**
 * 获取配置中的app信息
 * @return array
 */
function get_app(){
    $app = Yaf\Registry::get('config')->api->app->toArray();
    $app['nonce'] = mt_rand(100000, 999999);
    $app['timeStamp'] = time();
    $app['signature'] = md5(array_value_sort_to_str($app));

    unset($app['appKey']);

    return $app;
}

function array_value_sort_to_str(Array $array=array()){
    asort($array,SORT_STRING);
    $str = '';
    foreach ($array as $tmp){
        $str .= $tmp;
    }

//    SeasLog::debug('签名明文:'.$str);
    return $str;
}

/**
 * @param $mobile
 * @param $sms_code
 * @return array
 */
function test_mobile_sms($mobile,$sms_code){

    $config = Yaf\Registry::get('config');
    $curl = new Curl($config->url->api->user);
    $resp = $curl->setData(['mobileNum'=>$mobile,'smsCode'=>$sms_code])
                ->send('userSecurity/verifySmsCodeOnly');

    if(!empty($resp) && $resp['errcode'] == 0){
        $return = true;
    }else{
        $return = isset($resp['errmsg']) ? $resp['errmsg'] : '验证码与手机号码不匹配！';
    }

    return $return;
}

/**
 * 检测用户是否登录
 * @return integer 0-未登录，大于0-当前登录用户ID
 * @author xuebingwang<406964108@qq.com>
 */
function is_login(){
    $user = session('user_auth');
    if (empty($user)) {
        return 0;
    } else {
        return isset($user['mobileNum']) ? $user['mobileNum'] : 0;
    }
}

/**
 * 获取客户端IP地址
 * @param integer $type 返回类型 0 返回IP地址 1 返回IPV4地址数字
 * @param boolean $adv 是否进行高级模式获取（有可能被伪装）
 * @return mixed
 */
function get_client_ip($type = 0,$adv=false) {
    $type       =  $type ? 1 : 0;
    static $ip  =   NULL;
    if ($ip !== NULL) return $ip[$type];
    if($adv){
        if (isset($_SERVER['HTTP_X_FORWARDED_FOR'])) {
            $arr    =   explode(',', $_SERVER['HTTP_X_FORWARDED_FOR']);
            $pos    =   array_search('unknown',$arr);
            if(false !== $pos) unset($arr[$pos]);
            $ip     =   trim($arr[0]);
        }elseif (isset($_SERVER['HTTP_CLIENT_IP'])) {
            $ip     =   $_SERVER['HTTP_CLIENT_IP'];
        }elseif (isset($_SERVER['REMOTE_ADDR'])) {
            $ip     =   $_SERVER['REMOTE_ADDR'];
        }
    }elseif (isset($_SERVER['REMOTE_ADDR'])) {
        $ip     =   $_SERVER['REMOTE_ADDR'];
    }
    // IP地址合法验证
    $long = sprintf("%u",ip2long($ip));
    $ip   = $long ? array($ip, $long) : array('0.0.0.0', 0);
    return $ip[$type];
}

/**
 * 裁剪正中部分，等比缩小生成缩略图
 * @param $url
 * @param int $w
 * @param int $h
 * @return string
 */
function imageView2($url,$w=null,$h=null){
    if(empty($w) || empty($h)){
        $url = $url.'?e='.(time()+3600);
    }else{
        $url = $url.'?imageView2/1/w/'.$w.'/h/'.$h.'/interlace/1&e='.(time()+3600);
    }

    $config = Yaf\Registry::get('config');
    $sign = hash_hmac('sha1', $url, $config->qiniu->secrectKey, true);
    return $url.'&token='.$config->qiniu->accessKey.':'.urlsafe_base64_encode($sign);
}

/**
 * 获取7牛下载链接
 * @param $url
 * @return string
 */
function get_qiniu_file_durl($url){
    $url = $url.'?attname=&e='.(time()+3600);

    $config = Yaf\Registry::get('config');
    $sign = hash_hmac('sha1', $url, $config->qiniu->secrectKey, true);
    return $url.'&token='.$config->qiniu->accessKey.':'.urlsafe_base64_encode($sign);
}

function urlsafe_base64_encode($str) // URLSafeBase64Encode
{
    $find = array("+","/");
    $replace = array("-", "_");
    return str_replace($find, $replace, base64_encode($str));
}

/**
 * @param $name
 * @param string $value
 * @return bool|mixed|\Yaf\Session
 */
function session($name,$value=''){
    static $session;
    
    if(empty($session)){
        
        $session = Yaf\Session::getInstance();
    }
    
    $f = false;
    switch (true){
        
    	case '' === $value:
    	    //获取
//     	    SeasLog::debug('session get');
    	    $f = $session->get($name);
    	    break;
    	case is_null($value):
            //删除
//             SeasLog::debug('session delete');
            $f = $session->del($name);
    	    break;
    	default :
    	    //设置
//     	    SeasLog::debug('session set');
    	    $f = $session->set($name, $value);
    	    break;
    }
    
    return $f;
}
/**
 * 对所有价格入库统一乘以100，转化成单位为分的格式
 * @param float $price
 * @param int $dividend
 * @return number
 */
function price_dispose($price,$dividend=100){

    return intval(floatval(str_replace(',','',$price))*$dividend);
}
/**
 * 金额格式化方法
 * @param int $price 单位为分
 * @param int $num
 * @param boolean $need_format
 * @param string $format
 * @return string
 */
function price_format($price,$num=100,$need_format=true,$format=''){
    $price = price_convert($price,$num);
    $surfix = '';
    //
    if($num == 100){
        if($price >= 100000000){
            $price = $price / 100000000;
            $surfix = '亿';
        }elseif($price >= 10000){
            $price = $price / 10000;
            $surfix = '万';
        }
    }

    if($need_format){

        return number_format($price).$surfix;
    }elseif(!empty($format)) {
        return sprintf($format,number_format($price,1,'.',''),$surfix);
    }else{
        return round($price,1).$surfix;
    }
}
/**
 * 金额转换方法
 * @param int $price 单位为分
 * @param int $num
 * @return string
 */
function price_convert($price,$num=100){
    return intval($price)/$num;
}
/**
 * CURL发送请求
 * @param $url
 * @param string $data
 * @param string $method
 * @param string $cookieFile
 * @param array $headers
 * @param int $connectTimeout
 * @param int $readTimeout
 * @return mixed|string
 */
function curlRequest($url, $data = '', $method = 'POST', $cookieFile = '', $headers = ["Content-Type:application/json;charset=UTF-8"], $connectTimeout = 30, $readTimeout = 30) {

    SeasLog::debug('发送URL:'.$url);
    SeasLog::debug('发送数据:'.$data);

    $method = strtoupper ( $method );

    $option = array (
        CURLOPT_URL => $url,
        CURLOPT_HEADER => 0,
        CURLOPT_RETURNTRANSFER => 1,
        CURLOPT_CONNECTTIMEOUT => $connectTimeout,
        CURLOPT_TIMEOUT => $readTimeout
    );

    if ($headers) {
        $option [CURLOPT_HTTPHEADER] = $headers;
    }

    if ($cookieFile) {
        $option [CURLOPT_COOKIEJAR] = $cookieFile;
        $option [CURLOPT_COOKIEFILE] = $cookieFile;
    }

    if ($data && $method == 'POST') {
        $option [CURLOPT_POST] = 1;
        $option [CURLOPT_POSTFIELDS] = $data;
    }
    $ch = curl_init ();
    curl_setopt ( $ch, CURLOPT_SSL_VERIFYPEER, FALSE );
    curl_setopt_array ( $ch, $option );
    $response = curl_exec ( $ch );

    if (curl_errno ( $ch ) > 0) {
        return curl_error ( $ch );
    }
    curl_close ( $ch );
    SeasLog::debug('收到数据:'.$response);
    return $response;
}

/**
 * 时间戳格式化
 * @param int $time
 * @return string 完整的时间显示
 * @author xuebing <406964108@qq.com>
 */
function time_format($time = NULL,$format='Y-m-d H:i:s'){
    $time = $time === NULL ? time() : intval($time);
    return date($format, $time);
}

/**
 * JSON转数组，始终返回一个数组
 * @param $json
 * @return array
 */
function json_to_array($json){
    if (!is_string($json)) {
        return array();
    }
    $value = json_decode($json,TRUE);
    return $value ? $value : array();
}

/**
 * 实例化一个没有模型文件的Model
 * @param string $name Model名称 支持指定基础模型 例如 User
 * @return Model
 */
function M($name = '')
{
    static $_model = array();
    $class = '\Model';
    $guid = $name . '_' . $class;
    if (!isset($_model[$guid])){
        $_model[$guid] = new $class($name);
    }
    return $_model[$guid];
}



function IdentityCodeValid($code) 
{
	$city=[11=>"北京",12=>"天津",13=>"河北",14=>"山西",15=>"内蒙古",21=>"辽宁",22=>"吉林",23=>"黑龙江 ",31=>"上海",32=>"江苏",33=>"浙江",34=>"安徽",35=>"福建",36=>"江西",37=>"山东",41=>"河南",42=>"湖北 ",43=>"湖南",44=>"广东",45=>"广西",46=>"海南",50=>"重庆",51=>"四川",52=>"贵州",53=>"云南",54=>"西藏 ",61=>"陕西",62=>"甘肃",63=>"青海",64=>"宁夏",65=>"新疆",71=>"台湾",81=>"香港",82=>"澳门",91=>"国外 "];
	$pass= true;
	$reg = "/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[012]\d|3[01])\d{3}(\d|X)$/i";
	if(!$code || preg_match($reg,$code)!==1){
		$pass = false;
	}
	elseif(empty($city[substr($code,0,2)])){
		$pass = false;
	}
	else{
		//18位身份证需要验证最后一位校验位
		if(sizeof($code) == 18){
			//∑(ai×Wi)(mod 11)
			//加权因子
			$factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
			//校验位
			$parity = [ 0=>1,1=> 0, 2=>'X', 3=>9, 4=>8, 5=>7, 6=>6, 7=>5, 8=>4, 9=>3, 10=>2 ];
			$sum = 0;
			$ai = 0;
			$wi = 0;
			for ($i = 0; $i < 17; $i++)
			{
				$ai = $code[$i];
				$wi = $factor[$i];
				$sum += $ai * $wi;
			}
			if($parity[$sum % 11] != strtoupper($code[17])){
				$pass =false;
			}
		}
	}
	return $pass;
}

function newBusinessLicenseNumValid($code)
{
	if(sizeof($code)!= 18){
		return false;
	}
	$reg = "/^([0-9ABCDEFGHJKLMNPQRTUWXY]{2})([0-9]{6})([0-9ABCDEFGHJKLMNPQRTUWXY]{9})([0-9Y])$/";
	if(!$code || preg_match($reg,$code)!==1){
		$pass = false;
	}
	$str = '0123456789ABCDEFGHJKLMNPQRTUWXY';
	$ws =[1,3,9,27,19,26,16,17,20,29,25,13,8,24,10,30,28];
	$codes  = [];
	$codes[0] = substr($code,0,17);
	$codes[1] = substr($code,17);	
	
	$sum = 0;
	for($i=0;$i<17;$i++){
		$sum += $str[$codes[0]][$i] * $ws[$i];
	}	
	
	$c18 = 31 - ($sum % 31);
	if($c18 == 31){
		$c18 = 'Y';
	}else if($c18 == 30){
		$c18 = '0';
	}
	
	if($c18 != $codes[1]){
		return false;
	}
	return true;
}

function orgCodeValid($orgCode){
	if(""==$orgCode || sizeof($orgCode)!==10)
	{
		return false;
	}
	$ret=false;
	$codeVal = ["0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
	$intVal =    [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35];
	$crcs =[3,7,9,10,5,8,4,2];
	if(!(""==$orgCode) && sizeof($orgCode)==10){
		$sum=0;
		for($i=0;$i<8;$i++){
			$codeI=substr($orgCode,$i,1);
			$valI=-1;
			for($j=0;$j<sizeof($codeVal);$j++){
				if($codeI==$codeVal[$j]){
					$valI=$intVal[$j];
					break;
				}
			}
			$sum+=$valI*$crcs[$i];
		}
		$crc=11- ($sum %  11);
		switch ($crc){
			case 10:
				$crc="X";
				break;
			case 11:
				$crc="0";
				break;
			default:
				break;
		}
		if($crc==substr($orgCode,0,-1)){
			$ret=true;
		}
	}
	return $ret;
}

function busCodeValid($busCode){
	$ret=false;
	if(empty($busCode)||sizeof($$busCode)!=15)
	{
		return false;
	}
	$sum=0;
	$s=[];
	$p=[];
	$a=[];
	$m=10;
	$p[0]=10;
	for($i=0;$i<sizeof($busCode);$i++)
	{
		$a[$i]=(int)substr($busCode,$i,1);
		$s[$i]=($p[$i]%11)+$a[$i];
		if(0==$s[$i]%11){
			$p[$i+1]=20;
		}else{
			$p[$i+1]=($s[$i]%10)*2;
		}    
	}                                       
	if(1==($s[14]%10)){
		$ret=true;
	}
	return $ret;
}
