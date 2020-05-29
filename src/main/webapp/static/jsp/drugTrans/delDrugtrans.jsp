<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/layuimini.css?v=2.0.0" media="all">
    <link rel="stylesheet" href="../../lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <style id="layuimini-bg-color">
    </style>
    <script src="../../js/jquery-1.12.4.js" charset="utf-8"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>删除药品交易信息</legend>
</fieldset>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">药品交易ID：</label>
        <div class="layui-input-block">
            <input name="id" id="id" class="layui-input" type="text" placeholder="请输入药品交易ID" autocomplete="off" lay-verify="title">
        </div>
    </div>
    <div>
        <button class="layui-btn layui-btn-primary" type="button" onclick="del()">提交</button>
    </div>
</form>

<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>

<script>
    function del(){
        var param={};
        param.id=id;
        $.ajax({
            url:"../../../DRUGTRANS/delDrugtrans",
            type:"get",
            data:param,
            dataType:"json",
            success:function (result) {
                if (result!=""){
                    alert(1111111111111);
                    if (result.result==true) {
                        alert(result);
                        alert(JSON.stringify(result));
                    }
                }
            }
        })
    }

    function cherkParam(id) {
        if (id == "" && id<=0) {
            alert("请输正确的ID！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>

