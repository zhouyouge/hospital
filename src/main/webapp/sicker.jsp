<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="static/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="static/css/layuimini.css?v=2.0.0" media="all">
    <link rel="stylesheet" href="static/lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style id="layuimini-bg-color">
    </style>
    <script src="static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <script src="static/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
    <script src="static/js/jquery-1.12.4.js"></script>
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
                url: "sicker/addSicker",
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

    姓名<input type="text" id="name" >
    年龄<input type="text" id="age">
    性别<input type="text" id="sex">
    身份证号<input type="text" id="cardid">
    余额<input type="text" id="balance">
    社保<input type="text" id="sbid">
    电话号<input type="text" id="tel">
    <input type="button" onclick="dianji()" value="按钮">

</body>
</html>
