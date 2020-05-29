
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="static/js/jquery-1.12.4.js"></script>
    <script>
        $(document).ready(function () {
            $("#delete").click(function () {
                var name=$("#name").val();
                if (cherkParam(name)){
                    var param={};
                    param.name=name;
                    $.ajax({
                        url:"del",
                        type:"get",
                        data:param,
                        dataType:"json",
                        success:function (result) {
                            if (result!=""){
                                alert(result);
                                alert(JSON.stringify(result));
                                if (result.result==true) {
                                    alert(result);
                                    alert(JSON.stringify(result));
                                }
                            }
                        }
                    })
                }
            })
        })



        function cherkParam(name) {
            if (name==""){
                alert("药品名不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div id="addModel">
    <h1>添加药品信息</h1>
    <div>
        药品名称：
        <input id="name">
    </div>
    <input type="button" id="delete" value="提交">
</div>

</body>
</html>
