<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

<style>
    .one{
        background-color: rgb(0,150,136);
        border: 1px black solid;
        width: 1520px;
        height: 730px;
    }
    .one h1{
        position: absolute;
        top: 100px;
        left: 650px;
    }
    .two{
        width: 280px;
        height: 100px;
        position: absolute;
        bottom: 100px;
        left: 670px;
    }

</style>
    <script>
        function dianji() {
            var param={}
            param.cardid=$("#cardid").val();
            location.href="register.jsp?cardid="+param.cardid;//
            location.href="registers.jsp";/*跳转页面 没有传入数据*/
        }


    </script>
</head>
<body>
<div class="one">
    <img src="../../images/1425441047858.jpg" width="1525" height="725">
    <h1>请输入身份证号</h1>
    <div class="two">
        <input type="text" id="cardid">
        
        <input type="button" value="确认" onclick="dianji()">
    </div>
</div>
</body>
</html>
