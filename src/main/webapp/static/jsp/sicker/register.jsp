<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .yi{
            background-color: #00b7ee;
            border: 1px black solid;
            width: 1530px;
            height: 720px;
        }
        .one{
            border-radius: 15px;
            background-color: #ffb800;
            position: absolute;
            left: 250px;
            top: 50px;
            border: 1px black solid;
            width: 430px;
            height: 600px;

        }
        .two{
            border-radius: 15px;
            background-color: #bd3004;
            position: absolute;
            left: 800px;
            top: 50px;
            border: 1px black solid;
            width: 430px;
            height: 600px;
        }
        .one img{
            margin-top: 70px;
          margin-left: 100px;
        }
        .one input{
            background-color: #00FF00;
            width: 100px;
            height: 20px;
            margin-top: 200px;
            margin-left: 150px;

        }
        .two img{
            margin-top: 70px;
            margin-left: 120px;
        }
        .two input{
            background-color: #00FF00;
            width: 100px;
            height: 20px;
            margin-top: 200px;
            margin-left: 170px;
        }
    </style>
    <script>
        function dianji() {
        location.href="cardid.jsp";//连接到cardid.jsp页面 不传入任何参数
}
    </script>
</head>
<body>
<div class="yi">
    <div class="one">

        <img src="../../images/menzhenguahao.png">

            <input type="button" onclick="dianji()" value="预约挂号">

    </div>
    <div class="two">

        <img src="../../images/chongzhi.png">
        <input type="button" onclick="dianji()" value="充值">
    </div>
</div>
</body>
</html>
