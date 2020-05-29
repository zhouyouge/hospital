<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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



</head>
<body>

<table class="layui-hide" id="test"></table>



<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'../../../sicker/querySicker'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'name', width:80, title: '用户名'}
                ,{field:'sex', width:80, title: '性别', sort: true}
               ,{field:'cardid', width:80, title: '身份证号'}
                ,{field:'balance', title: '余额', sort: true} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'sbid', title: '社保', }
                ,{field:'tel', title: '手机号', }

            ]]
        });
    });
</script>

</body>
</html>
