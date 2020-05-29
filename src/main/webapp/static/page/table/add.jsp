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


            layui.use('table', function () {
                var table = layui.table;

                var $ = layui.$, active = {
                    parseTable: function () {
                        table.init('parse-table-demo', { //转化静态表格
                            //height: 'full-500'
                        });
                    }
                };

            });


            $.getJSON("../../../departments/queryDepartments", null, function (result) {
                $("#stufftype").html("<option value=''>请选择部门</option>");
                $("#stuff").html("<option value=''>请选择科室</option>");
                $(result).each(function () {
                    $("#stufftype").append("<option value='" + this.id + "'>" + this.name + "</option>")
                })


                layui.use(['form'], function () {
                    var form = layui.form
                    form.render('select');
                    form.render('radio');
                })
            })

            $.getJSON("../../../rank/queryRank", null, function (result) {
                $("#stuffRank").html("<option value=''>请选择职称</option>");
                $(result).each(function () {
                    $("#stuffRank").append("<option value='" + this.id + "'>" + this.name + "</option>")
                })

            })
        })


    </script>
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required" lay-reqtext="姓名不能为空" placeholder="请输入姓名" value=""
                   class="layui-input">
            <tip>填写自己姓名。</tip>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">年龄</label>
        <div class="layui-input-block">
            <input type="number" name="age" lay-verify="required" lay-reqtext="年龄不能为空" placeholder="请输入年龄" value=""
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="1" title="男" checked="">
            <input type="radio" name="sex" value="0" title="女">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">入职日期</label>
        <div class="layui-input-inline">
            <input type="text" name="hiredate" class="layui-input" lay-verify="required" lay-reqtext="入职日期不能为空"
                   id="test1" placeholder="yyyy-MM-dd">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">职位信息</label>
        <div class="layui-input-inline">
            <select name="departmentsId" id="stufftype" lay-filter="stuff" class="select">

            </select>
        </div>
        <div class="layui-input-inline">
            <select name="departmentid" id="stuff">

            </select>
        </div>
        <div class="layui-input-inline">
            <select name="rankid" id="stuffRank">

            </select>
        </div>
        <%-- <div class="layui-form-mid layui-word-aux">此处只是演示联动排版，并未做联动交互</div>--%>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label required">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="title" autocomplete="off" lay-verify="required"
                   lay-reqtext="用户名不能为空" placeholder="请输入用户名"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">密码框</label>
        <div class="layui-input-block">
            <input type="password" name="password" placeholder="请输入密码" lay-verify="required" lay-reqtext="密码不能为空"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>


</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;


        form.on('select(stuff)', function () {
            var departmentsId = $("#stufftype").val();
            $.getJSON("../../../department/queryDepartment/" + departmentsId, function (result) {
                $("#stuff").html("<option value=''>请选择科室</option>");
                $(result).each(function () {
                    $("#stuff").append("<option value='" + this.id + "'>" + this.name + "</option>")
                })
                form.render('select');
            })
        })


        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var index = layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            }, function () {
                // ajax方式添加用户
                $.ajax({
                    url: "/user/addStuff",
                    type: "POST",
                    data: JSON.stringify(data.field),
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        if (data.code == 200) {
                            layer.alert("添加成功", {icon: 6}, function () {
                                // 获得frame索引
                                var index = parent.layer.getFrameIndex(window.name);
                                //关闭当前frame
                                parent.layer.close(index);
                                //修改成功后刷新父界面
                                window.parent.location.reload();
                            });

                        } else {
                            layer.msg('添加失败');
                        }
                    },
                    error: function () {
                        console.log("ajax error");
                    }
                });

            });

        });

    });
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#test1'
        });
    });
</script>
</body>
</html>