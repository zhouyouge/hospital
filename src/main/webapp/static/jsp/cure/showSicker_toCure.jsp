<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/3 0003
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
    <script src="../../js/jquery-1.12.4.js"></script>
    <script>
        function addPre(id) {
            location.href = "addPrescription.jsp?" + id;
        }
        Date.prototype.Format = function (fmt) { //author: meizz
            var o = {
                "M+": this.getMonth() + 1, //月份
                "d+": this.getDate(), //日
                "h+": this.getHours(), //小时
                "m+": this.getMinutes(), //分
                "s+": this.getSeconds(), //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds() //毫秒
            };
            if (/(y+)/.test(fmt))
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        }

    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend><strong>今日待就诊患者</strong></legend>
</fieldset>

<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="zizeng">
    {{d.LAY_TABLE_INDEX+1}}
</script>

<script type="text/html" id="barDemo">
    &emsp;
    <button type="button" class="layui-btn layui-btn-sm" lay-event="handle">处理</button>
    &emsp;&emsp;<button type="button" class="layui-btn layui-btn-sm" lay-event="showhistory">查看病人历史</button>
</script>
<script type="text/html" id="showCureList">
    <a class="layui-btn layui-btn-xs" lay-event="showPre">查看详情</a>
</script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        var date = new Date();
        var qdate = (new Date()).Format("MMdd").toString();
        table.render({
            elem: '#test'
            , url: '../../../Register/getList'
            , where: { "qdate" : qdate}
            , toolbar: '#toolbarDemo'
            , title: '用户数据表'
            , totalRow: true
            , cols: [[
                {field: 'zizeng', width: 80, title: '计数', fixed: 'left', templet: '#zizeng'}
                , {field: 'toseedoctor', title: '序号', width: 160}
                , {field: 'name', title: '患者姓名', width: 120, templet: '<div>{{d.sicker==null?null:d.sicker.name}}</div>'}
                ,{ width:80, title: '性别', templet: '<div>{{d.sicker==null?null:(d.sicker.sex==1?\'男\':\'女\')}}</div>'}
                , {width: 100, title: '年龄', templet: '<div>{{d.sicker==null?null:d.sicker.age}}</div>'}
                , {width: 180, title: '患者电话', templet: '<div>{{d.sicker==null?null:d.sicker.tel}}</div>'}
                , {field: 'balance', title: '余额（元）', width: 120, templet: '<div>{{d.sicker==null?null:d.sicker.balance}}</div>'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 230}
            ]]
            , page: true
        });

        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'handle'){
               location.href = "addPrescription.jsp?" + data.sicker.id;
            }else if(obj.event == 'showhistory'){
                var param = {};
                param.sickerid = data.sicker.id;
                layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['800px', '420px'], //宽高
                    content:
                    '<table class="layui-hide" id="showCure" lay-filter="showCure"></table>'
                });
                table.render({
                    elem: '#showCure'
                    ,url:'../../../pre/showMySickerCured'
                    ,title: '用户数据表'
                    ,totalRow: true
                    ,where:param
                    ,cols: [[
                        {field:'zizeng', width:80, title: '计数',fixed: 'left',templet:'#zizeng'}
                        ,{title:'患者姓名', width:120,templet:  '<div>{{d.sicker==null?null:d.sicker.name}}</div>'}
                        ,{title:'治疗医生', width:120,templet:  '<div>{{d.stuff==null?null:d.stuff.name}}</div>'}
                        ,{field:'illnessName', width:80, title: '诊断结果', templet: '<div>{{d.sicker==null?null:(d.sicker.sex==1?\'男\':\'女\')}}</div>'}
                        ,{field:'curedate', title:'就诊时间', width:200,sort: true, templet: function (d) {
                                date.setTime(d.curedate);
                                return date.Format("yyyy-MM-dd hh:mm:ss");}}
                        ,{fixed: 'right', title:'查看', toolbar: '#showCureList', width:100}
                    ]]
                    ,page: true
                    ,done: function (res, curr, count) {
                        $('th').css({'background-color': '#009688', 'color': '#fff','font-weight':'bold','font-size':'15px'});
                    }
                });
            }
        });

        table.on('tool(showCure)', function(obj){
            var data = obj.data;

            if(obj.event =='showPre'){
                layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['600px', '320px'], //宽高
                    content: '<p>患者姓名：'+data.sicker.name+'&emsp;&emsp;患者年龄：'+data.sicker.age+'&emsp;&emsp;性别：'+((data.sicker.sex==1)?'男':'女')+'</p>' +
                    '<p>诊断结果：'+data.illnessName+'</p>' +
                    '<p>处方医生：'+data.stuff.name+'</p>' +
                    '<table class="layui-hide" id="showCureList1" lay-filter="showCureList1"></table>'
                });
                table.render({
                    elem: '#showCureList1'
                    ,cols: [[ //标题栏
                        {field:'zizeng', width:80, title: '序号', sort: true,fixed: 'left',templet:'#zizeng'}
                        ,{field: 'drugName', title: '药名', width: 180, sort: true}
                        ,{field: 'useageName', title: '用法', width: 80, sort: true}
                        ,{field:'dosageid',title: '用量', width: 80, sort: true}
                        ,{field:'unitName',title: '单位', width: 80, sort: true}
                        ,{field:'bill',title: '单品总价', width: 80}
                    ]]
                    ,data:data.cureList
                    ,done: function (res, curr, count) {
                        $('th').css({'background-color': '#009688', 'color': '#fff','font-weight':'bold','font-size':'15px'});
                    }

                })
            }
        })
    })
</script>
</body>
</html>
