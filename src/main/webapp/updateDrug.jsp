<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新药品信息</title>
</head>
<script src="static/js/jquery-1.12.4.js"></script>
<script>
    $(document).ready(function () {
        $("#update").click(function () {
            var id=$("#id").val();
            var batch=$("#batch").val();
            if (cherkParam(id,batch)){
                var param={};
                param.id=id;
                param.batch=batch;
                $.ajax({
                    url:"DRUG/update",
                    type:"get",
                    data:param,
                    dataType:"json",
                    success:function (result) {
                        if (result!=""){
                            if (result.result==false) {
                                alert(result);
                                alert(JSON.stringify(result));
                            }
                        }
                    }
                })
            }
        })
    })

    function cherkParam(id,batch) {
        if (id==""){
            alert("药品ID不能为空！");
            return false;
        }
        if (batch==""){
            alert("药品库存不能为空！");
            return false;
        }
        return true;
    }
</script>

<body>
    <div id="delModel">
        <h1>修改药品信息</h1>
        <div>
            药品ID：
            <input id="id">
        </div>
        <div>
            药品库存：
            <input batch="batch">
        </div>


        <input type="button" id="update" value="提交">
    </div>
</body>
</html>