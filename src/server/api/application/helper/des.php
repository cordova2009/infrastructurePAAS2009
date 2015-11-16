<?php

function encrypt($data,$key=''){
    $size       = mcrypt_get_block_size(MCRYPT_DES, MCRYPT_MODE_CBC);
    $data       = pkcs5Pad($data, $size);
    $iv         = substr(strrev($key),0,8);
    $passcrypt  = mcrypt_encrypt(MCRYPT_DES ,substr($key,0,8), $data, MCRYPT_MODE_CBC,$iv);
    return base64_encode($passcrypt);
}

function decrypt($data,$key='')
{
    $iv     = substr(strrev($key),0,8);
    $str    = mcrypt_decrypt(MCRYPT_DES,substr($key,0,8),base64_decode($data),MCRYPT_MODE_CBC,$iv);
    return pkcs5Unpad($str);
}

function pkcs5Unpad($text)
{
    $pad = ord($text[strlen($text)-1]);
    if($pad >strlen($text))
    {
        return false;
    }
    if($pad >strlen($text))
    {
        return false;
    }
    if(strspn($text,chr($pad),strlen($text)-$pad)!=$pad)
    {
        return false;
    }
    return substr($text,0,-1*$pad);
}

function pkcs5Pad($text,$blocksize)
{
    $pad = $blocksize - (strlen($text) % $blocksize);
    return $text . str_repeat(chr($pad), $pad);
}

function array_value_sort_to_str(Array $array=array()){
    asort($array,SORT_STRING);
    $str = '';
    foreach ($array as $tmp){
        $str .= $tmp;
    }
    return $str;
}
