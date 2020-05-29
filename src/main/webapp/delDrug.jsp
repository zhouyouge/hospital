<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除药品页面</title>
    <script src="static/js/jquery-1.12.4.js"></script>
    <script>
        $(document).ready(function () {
            $("#delete").click(function () {
                var id=$("#id").val();
                if (cherkParam(id)){
                    var param={};
                    param.id=id;
                    $.ajax({
                        url:"DRUG/del",
                        type:"get",
                        data:param,
                        dataType:"json",
                        success:function (result) {
                            if (result!=""){
                                alert(result);
                                alert(JSON.stringify(result));
                                if (result.result==false) {
                                    alert(result.data);
                                    alert(JSON.stringify(result));
                                }
                            }
                        }
                    })
                }
            })
        })

        function cherkParam(id) {
            if (id==""){
                alert("药品ID不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <div id="delModel">
        <h1>删除药品信息</h1>
        <div>
            药品ID：
            <input id="id">
        </div>

        <input type="button" id="delete" value="提交">
    </div>
</body>

</html>