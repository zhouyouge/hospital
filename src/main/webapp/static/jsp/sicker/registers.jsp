<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
    <script src="../../js/jquery-1.12.4.js"></script>
    <script>

        $(function () {


            $.getJSON("../../../department/queryAllDepartment", null, function (result) {
                $("#departmentType").html("<option value=''>请选择科室</option>");
                $("#stuffName").html("<option value=''>请选择医生</option>");
                $(result).each(function () {
                    $("#departmentType").append("<option value='" + this.id + "'>" + this.name + "</option>")
                })


                layui.use(['form'], function () {
                    var form = layui.form
                    form.render('select');
                    form.render('radio');
                })
            })

        })
    </script>
</head>
<body>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<div class="layui-form layuimini-form">


        <div class="layui-form-item">
            <label class="layui-form-label">请选择科室</label>
            <div class="layui-input-inline">
                <select name="departmentName" id="departmentType" lay-filter="stuffName" class="select">

                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">请选择医生</label>
            <div class="layui-input-inline">
                <select name="doctorid" id="stuffName">

                </select>
            </div>
        </div>

        <div class="layui-form-item">
                <label class="layui-form-label">预约时间</label>
                <div class="layui-input-inline">
                    <input type="text" name ="registerData"  class="layui-input" id="test-limit1" placeholder="请选择预约时间">
                </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="saveBtn">挂号/预约</button>
            </div>
        </div>



</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            laydate = layui.laydate;
        $ = layui.$;

        form.on('select(stuffName)', function () {
            var departmentId = $("#departmentType").val();
            $.getJSON("../../../user/queryDoctorStuff/" + departmentId, function (result) {
                $("#stuffName").html("<option value=''>请选择医生</option>");
                $(result).each(function () {
                    $("#stuffName").append("<option value='" + this.id + "'>" + this.name + "</option>")
                })
                form.render('select');
            })
        })

        //限定可选日期
        laydate.render({
            elem: '#test-limit1'
            , min: 0
            , max: 5
        });

        //监听提交
        form.on('submit(saveBtn)', function (data) {
                // ajax方式添加用户
                $.ajax({
                    url: "/user/yyRegister",
                    type: "POST",
                    data: JSON.stringify(data.field),
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        layer.msg(data.msg, {icon:1,time:2000},function(){
                            setTimeout('window.location.reload()',0);
                        });

                    },

                });

             /*   var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);*/
                // 阻止表单跳转
              //  return false;

        });
    });


</script>
</body>
</html>