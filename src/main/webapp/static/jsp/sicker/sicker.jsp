<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/layuimini.css?v=2.0.0" media="all">
    <link rel="stylesheet" href="../../lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style id="layuimini-bg-color">
    </style>
    <script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <script src="../../js/lay-config.js?v=2.0.0" charset="utf-8"></script>
    <script src="../../js/jquery-1.12.4.js"></script>

    <script>
        function dianji(){
            alert("fffff");
            var param={}
            param.name=$("#name").val();
            param.age=$("#age").val();
            param.sex=$("#sex").val();
            param.cardid=$("#cardid").val();
            param.balance=$("#balance").val();
            param.sbid=$("#sbid").val();
            param.tel=$("#tel").val();

            $.ajax({
                url: "../../../sicker/addSicker",
                type: "post",
                data: param,
                success:function (result) {
                    alert("添加成功")
                }
            })
        }
    </script>

</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>添加患者信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" id="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-inline">
            <input type="text" id="age" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-inline">
            <input type="text" id="sex" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-inline">
            <input type="text" id="cardid" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">余额</label>
        <div class="layui-input-inline">
            <input type="text" id="balance" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">社保</label>
        <div class="layui-input-inline">
            <input type="text" id="sbid" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-inline">
            <input type="text" id="tel" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <button type="button" class="layui-btn layui-btn-sm" onclick="dianji()">提交</button>
</form>

</body>

</html>
