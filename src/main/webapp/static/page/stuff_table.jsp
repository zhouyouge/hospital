<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>员工列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../css/public.css" media="all">
    <script src="../js/jquery-1.12.4.js"></script>
    <script>

    </script>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">员工姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" id="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary" lay-submit
                                    lay-filter="data-search-btn" ><i class="layui-icon"></i> 搜 索
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm data-add-btn" lay-event="add"> 添加用户</button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除用户
                </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

    </div>
</div>
<script src="../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '/user/queryAllStuff',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50, fixed: "left"},
                /*{field: 'id', width: 80, title: 'ID', sort: true},*/
                {field: 'name', width: 80, title: '姓名'},
                {field: 'age', width: 80, title: '年龄'},
                {field: 'sex', width: 80, title: '性别', sort: true},
                {field: 'hiredate', title: '受雇时间',width: 150},// minWidth: 50
                {field: 'departmentName', width: 100, title: '科室', sort: true},
                {field: 'rankName', width: 110, title: '职称', sort: true},
                {field: 'username', width: 120, title: '账号'},
                /*   {field: 'password', width: 135, title: '密码', sort: true},*/
                {field: 'status', width: 135, title: '状态', sort: true},
                {title: '操作', minWidth: 50, templet: '#currentTableBar', fixed: "right", align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            page: true
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function () {
           var name =  $("#username").val();
        /*    layer.alert(name, {
                title: '最终的搜索信息'
            });*/

            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    stuffName: name
                }
            }, 'data');

            return false;
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加用户',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'table/add.jsp',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                //批量删除
                    //获取选中状态            
                    var checkStatus = table.checkStatus('currentTableId');
                    //获取选中数量
                    var selectCount = checkStatus.data.length;
                    if(selectCount == 0){
                        layer.msg('批量删除至少选中一项数据',function(){});
                        return false;
                    }
                    layer.confirm('真的要删除选中的项吗？',function(index){
                        layer.close(index);
                        index = layer.load(1, {shade: [0.1,'#fff']});

                        var isStr="";
                        for(var i=0; i<selectCount; i++){
                            isStr = isStr + "," + checkStatus.data[i].id;
                        }
                        $.ajax({
                            type:'post',
                            data:{"isStr":isStr},
                            url: '/user/deleteStuffByIds',
                            success:function(data){
                                if(data.code==200){
                                    $('#seach').click();
                                }
                                layer.close(index);
                                layer.msg(data.msg);
                                location.reload();
                            },error:function(code){
                                parent.layer.msg('操作失败!',{icon: 5,time:1000});
                            }
                        });
                    })

            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            localStorage.setItem("id",data.id);
           /* console.table(localStorage);*/
            if (obj.event === 'edit') {
                var index = layer.open({
                    title: '编辑用户',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'table/edit.jsp',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {
                // 获取当前行数据和lay-event的值
                layer.confirm('真的删除行么', function (index) {
                    // ajax方式删除用户
                    $.ajax({
                        url: '/user/deleteStuffById/' + data.id,
                        type: "DELETE",
                        dataType: 'json',
                        success: function (data) {
                            if (data.status == 1) {
                                layer.msg('删除成功');
                                table.reload('user-tbl');
                            } else {
                                layer.msg('删除失败');
                            }
                        },
                        error: function () {
                            console.log("ajax error");
                        }
                    });
                    layer.close(index);
                    location.reload()
                });
            }
        });

    });
</script>
<script>

</script>

</body>
</html>
