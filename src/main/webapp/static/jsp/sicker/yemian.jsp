<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<style>
    h1{
        position: absolute;
        left: 200px;
        top: 30px;
        font-size: 40px;
        color: white;
    }
    .for h2{
        background: rgb(154,203,111);
        border-radius: 10px;
        width: 350px;
        height: 50px;
        text-align: center;
        line-height: 50px;
        color: white;
    }
    .there{
        background: rgb(154,203,111);
        border-radius: 10px;
        width: 350px;
        height: 500px;
    }
    .there input{
        border-radius: 10px;
        width: 250px;
        height: 50px;
        font-size: 20px;
        color: white;
        background-color: rgb(253,160,0);
        margin-left: 50px;
        margin-top: 130px;
    }
    .for h4{
        margin-left: 20px;
        padding-top: 20px;
    }
    .for{
        position: absolute;
        left: 650px;
        top: 100px;
    }
    .liu{

        background: rgb(247,180,109);
        border-radius: 10px;
        width: 350px;
        height: 500px;
    }
    .wu{
        position: absolute;
        left: 1050px;
        top: 100px;
    }
    .wu h2{
        background: rgb(247,180,109);
        border-radius: 10px;
        width: 350px;
        height: 50px;
        text-align: center;
        line-height: 50px;
        color: white;
    }
    .wu h4{
        margin-left: 20px;
        padding-top: 20px;
    }
    .liu input{
        border-radius: 10px;
        width: 250px;
        height: 50px;
        font-size: 20px;
        color: white;
        background-color: rgb(30,145,215);
        margin-left: 50px;
        margin-top: 130px;
    }
    .two{
        position: absolute;
        top: 40px;
        right: 60px;
    }
    .two input{
        width: 100px;
        height: 30px;
        background-color: #eb7350;
        border-radius: 10px;
        color: white;
    }
    .qi{
    position: absolute;
        left: 50px;
        top:180px;
    }
</style>
</head>
<script>
    function dianji() {
        location.href="cardid.jsp";//连接到cardid.jsp页面 不传入任何参数
    }
</script>
<body>
<div class="one">
        <h1>门诊自助系统</h1>
        <img src="../../images/1425441047858.jpg" width="1525" height="725">

    <div>
        <div class="for">
            <h2>在线挂号</h2>
            <div class="there">
                <h4>在线自助挂号</h4>
                <input type="button" onclick="dianji()" value="挂号入口">
            </div>
        </div>
        <div class="wu">
            <h2>在线充值</h2>
            <div class="liu">
                <h4>在线充值</h4>
                <input type="button" onclick="dianji()" value="充值入口">
            </div>
        </div>
        <div class="two">
            <input type="button" onclick="dianji()" value="退出">
        </div>
    <h2 class="qi">
        <p>   欢迎使用门诊自助挂号系统,我们将为您</br>提供优质的服务</p>
        <p>
              温馨提示：<br><br>
            （1）自助系统适用于病人挂号，预约挂号，缴费等。<br><br><br>
            （2）初次就趁，请根据选项填写信息即可。
        </p>
    </h2>
    </div>
</div>


</body>
</html>
