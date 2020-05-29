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
    <legend>修改药品交易记录信息</legend>
</fieldset>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">typeID：</label>
        <div class="layui-input-block">
            <input name="typeid" id="typeid" class="layui-input" type="text" placeholder="请输入药品ID" autocomplete="off" lay-verify="title">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">drugID：</label>
        <div class="layui-input-block">
            <input name="drugid" id="drugid" class="layui-input" type="text" placeholder="请输入药品名称" autocomplete="off" lay-verify="title">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">number：</label>
        <div class="layui-input-block">
            <input name="number" id="number" class="layui-input" type="text" placeholder="请输入药品类型" autocomplete="off" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">unitid：</label>
        <div class="layui-input-block">
            <input name="unitid" id="unitid" class="layui-input" type="text" placeholder="请输入药品数量" autocomplete="off" lay-verify="required">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">supplierid：</label>
        <div class="layui-input-block">
            <input name="supplierid" id="supplierid" class="layui-input" type="text" placeholder="请输入供应商编号" autocomplete="off" lay-verify="required">
        </div>
    </div>

    <div>
        <button class="layui-btn layui-btn-primary" type="button" onclick="update()">保存</button>
    </div>
</form>

<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>


<script>
    function update(){
        var param={};
        param.typeid=$("#typeid").val();
        param.drugid=$("#drugid").val();
        param.number=$("#number").val();
        param.unitid=$("#batch").val();
        param.supplierid=$("#supplierid").val();
        $.ajax({
            url:"../../../DRUG/update",
            type:"get",
            data:param,
            dataType:"json",
            success:function (result) {
                if (result!=""){
                    if (result.result==true) {
                        alert(result);
                        alert(JSON.stringify(result));
                    }
                }
            }
        })
    }
    function cherkParam(typeid,drugid,number,unitid,supplierid) {
        if (typeid=="" && typeid<=0){
            alert("请输入正确的药品ID！");
            return false;
        }
        if (drugid==""){
            alert("药品名字不能为空！");
            return false;
        }
        if (number=="" && number<=0){
            alert("请输入正确的药品单位！");
            return false;
        }
        if (unitid=="" && unitid<0){
            alert("请输入正确的药品库存！");
            return false;
        }
        if (supplierid=="" && supplierid<=0){
            alert("请输入正确的药品供应商ID！");
            return false;
        }
        return true;
    }
</script>

</body>
</html>

