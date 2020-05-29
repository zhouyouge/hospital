<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--需要--%>
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<table class="layui-hide" id="test" />

<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script type="text/html" id="search">
    <div class="layui-btn-group">
        <a href="addDrug.jsp"><button class="layui-btn layui-btn-sm" type="button"><i class="layui-icon" ></i></button></a>
        <a href="updateDrug.jsp"><button class="layui-btn layui-btn-sm" type="button"><i class="layui-icon"></i></button></a>
        <a href="delDrug.jsp"><button class="layui-btn layui-btn-sm" type="button"><i class="layui-icon"></i></button></a>
    </div>
    <%--<a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit" href="updateDrug.jsp">编辑</a>--%>
    <%--<a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete" href="delDrug.jsp">删除</a>--%>
</script>

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'../../../DRUG/list/'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', width:100, title: 'ID',sort:true}
                ,{field:'name', width:100, title: '药品名称'}
                ,{field:'formid', width:100, title: '药品类型', sort: true}
                ,{field:'batch', width:100, title: '药品数量',sort: true}
                ,{field:'supplier', title: '供应商编号', width: 100}
                ,{field:'bprice', width:100,title: '药品进价', sort: true}
                ,{field:'sprice', width:100,title: '药品售价', sort: true}
                ,{field:'totalprice', width:100,title: '药品总价',sort: true}
                // ,{fixed:'right',title:'操做', toolbar:'#search',width:120}
                ,{title: '操作', width:150,templet: '#search', fixed: "right", align: "center"}
            ]]
        });
    });
</script>

</body>
</html>