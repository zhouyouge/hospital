<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/1 0001
  Time: 16:05
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
        function showhistory() {
            var param = {};
            var sicker = {};
            var start = $("#start").val();
            var end = $("#end").val();
            var name = $("#sicker").val();
            if(start!=null && start!=''){
                param.startTime = start+" 00:00:00";
            }
            if(end!=null && end!=''){
                param.endTime = end+" 23:59:59";
            }
            if(name!=null && name!=''){

                param['sicker.name'] = name;
            }

            //var date = new Date();
            //var ceshi = date.toLocaleDateString();

            layui.use('table', function(){
                var table = layui.table;

                //温馨提示：默认由前端自动合计当前行数据。从 layui 2.5.6 开始： 若接口直接返回了合计行数据，则优先读取接口合计行数据。
                //详见：https://www.layui.com/doc/modules/table.html#totalRow
                var date = new Date();
                table.render({
                    elem: '#test'
                    ,url:'../../../pre/showMySickerCured'
                    ,where:param
                    ,toolbar: '#toolbarDemo'
                    ,title: '用户数据表'
                    ,totalRow: true
                    ,page: true
                    ,cols: [[
                        {type: 'checkbox', fixed: 'left'}
                        ,{field:'zizeng', width:80, title: '计数',fixed: 'left',templet:'#zizeng'}
                        ,{field:'id', title:'挂号编码', width:120, fixed: 'left', unresize: true, sort: true, totalRowText: '合计'}
                        ,{field:'typename', title:'治疗方式', width:120}
                        ,{title:'患者姓名', width:120,templet:  '<div>{{d.sicker==null?null:d.sicker.name}}</div>'}
                        ,{field:'sex', width:80, title: '性别', templet: '<div>{{d.sicker==null?null:(d.sicker.sex==1?\'男\':\'女\')}}</div>'}
                        ,{width:80, title: '年龄', templet: '<div>{{d.sicker==null?null:d.sicker.age}}</div>'}
                        ,{width:180, title: '患者电话', templet: '<div>{{d.sicker==null?null:d.sicker.tel}}</div>'}
                        ,{field:'curedate', title:'治疗时间', width:200,sort: true, templet: function (d) {
                                date.setTime(d.curedate);
                                return date.Format("yyyy-MM-dd hh:mm:ss");}}
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100}
                    ]]

                });



            })
        }


        //(new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
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
    <legend><strong>历史已经就诊</strong></legend>
</fieldset>

<div class="layui-form">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">起始时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="start" placeholder="yyyy-MM-dd">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="end" placeholder="yyyy-MM-dd">
            </div>
        </div>

    </div>
</div>

<div class="layui-form-item">

    <div class="layui-inline">
        <label class="layui-form-label">患者姓名</label>
        <div class="layui-input-inline">
            <input type="text"  id="sicker" autocomplete="off" class="layui-input">
        </div>
    </div>
    &emsp;
    <button type="button" class="layui-btn layui-btn-normal" onclick="showhistory()">确定</button>

</div>


<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="zizeng">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    </div>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="showPre" >查看详情</a>
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        var date = new Date();
        table.render({
            elem: '#test'
            ,url:'../../../pre/showMySickerCured'
            ,toolbar: '#toolbarDemo'
            ,title: '用户数据表'
            ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'zizeng', width:80, title: '计数',fixed: 'left',templet:'#zizeng'}
                ,{field:'id', title:'挂号编码', width:120, fixed: 'left', unresize: true, sort: true, totalRowText: '合计'}
                ,{field:'typename', title:'治疗方式', width:120}
                ,{title:'患者姓名', width:120,templet:  '<div>{{d.sicker==null?null:d.sicker.name}}</div>'}
                ,{field:'sex', width:80, title: '性别', templet: '<div>{{d.sicker==null?null:(d.sicker.sex==1?\'男\':\'女\')}}</div>'}
                ,{width:80, title: '年龄', templet: '<div>{{d.sicker==null?null:d.sicker.age}}</div>'}
                ,{width:180, title: '患者电话', templet: '<div>{{d.sicker==null?null:d.sicker.tel}}</div>'}
                ,{field:'curedate', title:'治疗时间', width:200,sort: true, templet: function (d) {
                        date.setTime(d.curedate);
                        return date.Format("yyyy-MM-dd hh:mm:ss");}}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100}
            ]]
            ,page: true
            ,done: function (res, curr, count) {
                $('th').css({'background-color': '#009688', 'color': '#fff','font-weight':'bold','font-size':'15px'});
            }
        });

        //展示处方详细信息
        table.on('tool(test)',function(obj){
            var data = obj.data;
            if(obj.event =='showPre'){
                layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['600px', '320px'], //宽高
                    content: '<p>患者姓名：'+data.sicker.name+'&emsp;&emsp;患者年龄：'+data.sicker.age+'&emsp;&emsp;性别：'+((data.sicker.sex==1)?'男':'女')+'</p>' +
                    '<p>诊断结果：'+data.illnessName+'</p>' +
                    '<p>处方医生：'+data.stuff.name+'</p>' +
                    '<table class="layui-hide" id="showCure" lay-filter="showCure"></table>'
                });
                table.render({
                    elem: '#showCure'
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




            //工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    //layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选')
                    break;
            };
        });
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#start'
        });
        laydate.render({
            elem: '#end'
        });
    })




</script>
</body>
</html>
