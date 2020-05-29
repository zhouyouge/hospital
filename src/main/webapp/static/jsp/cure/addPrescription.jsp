<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/1 0001
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
    <script src="../../js/jquery-1.12.4.js"></script>
    <script>

        $(function () {


            layui.use('table', function(){
                var table = layui.table;

                var $ = layui.$, active = {
                    parseTable: function(){
                        table.init('parse-table-demo', { //转化静态表格
                            //height: 'full-500'
                        });
                    }
                };

            });


            $.getJSON("../../../pre/cureInti",null,function (result) {
                $("#illnesstype").html("<option value=''>请选择疾病分类</option>");
                $("#cureType").html("<input type=\"radio\" name=\"typeid\" value=\"1\" title=\"用药（西药）\" checked=\"\">")
                $("#useage").html("<option value=\"\">直接选择或搜索选择</option>")
                $("#drugList").html("<option value=\"\">直接选择或搜索选择</option>");
                $(result.data.illnessTypeList).each(function () {
                    $("#illnesstype").append("<option value='"+this.id+"'>"+this.name+"</option>")
                })
                $(result.data.cureTypeList).each(function () {
                    if (this.typeid!=1){
                        $("#cureType").append("<input type=\"radio\" name=\"typeid\" value=\""+this.typeid+"\" title=\""+this.typename+"\">")
                    }
                })
                $(result.data.useageList).each(function () {
                    $("#useage").append("<option value='"+this.useageid+"'>"+this.useageName+"</option>")
                })
                $(result.data.drugList).each(function () {
                    $("#drugList").append("<option value=\""+this.id+","+this.unitid+","+this.sprice+"\">"+this.name+"</option>")
                })
                layui.use(['form'], function () {
                    var form = layui.form
                    form.render('select');
                    form.render('radio');
                })
            })
        })

        function addPre() {
            var drug = $("#drugList option:selected").text();
            var useage = $("#useage option:selected").text();
            var dosage = $("#dosage").val();
            var unit = $("#unit").html();
            var remark = $("#remark").val();
            var unitid = $("#drugList").val();
            var param = new Array();
            var param = unitid.split(",");
            var total = param[2]*dosage;
            var drugNum = $("#preTable tbody tr").size();
            drugNum++;
            $("#preTable tbody").append("<tr><td>"+drugNum+"</td><td>"+drug+"</td><td>"+useage+"</td><td>"+dosage+" </td><td>"+unit+" </td><td>"+total+" </td><td>"+remark+" </td><td><button onclick=delPre("+drugNum+") type=\"button\" class=\"layui-btn layui-btn-sm layui-btn-normal\"><i class=\"layui-icon\"></i> 删除</button></td></tr>")
        }

        function delPre(id) {
            $("#preTable").find("tr:nth-of-type("+id+")").remove();
            refrashtable($("#preTable tbody"));

        }

        function refrashtable(table){
            var id = 0;
            $(table).find("tr").each(function () {
                id++;
                $(this).find("td:nth-of-type(1)").html(id);
                $(this).find("td:last-of-type").html("<button onclick=delPre("+id+") type=\"button\" class=\"layui-btn layui-btn-sm layui-btn-normal\"><i class=\"layui-icon\"></i> 删除</button>")
            })
        }

        function addPrescription() {
            var param ={};
            param.typeid = $("input[name='typeid']:checked").val();
            var url = window.location.href;
            var surl = url.split("?");
            param.sickerid= surl[1];
            param.illnessid = $("#illness").val();
            param.cureList = new  Array();
            param.mainsuit = $("#mainsuit").val();
            $('#preTable tbody tr').each(function(index){
                var cure = {};
                param['cureList[' + index +'].drugName'] = $(this).find('td:nth-of-type(2)').text(); // 获取要素值
                param['cureList[' + index +'].useageName'] = $(this).find('td:nth-of-type(3)').text();
                param['cureList[' + index +'].dosageid'] = $(this).find('td:nth-of-type(4)').text();
                param['cureList[' + index +'].unitName'] = $(this).find('td:nth-of-type(5)').text();
                param['cureList[' + index +'].bill']=$(this).find('td:nth-of-type(6)').text();
                param['cureList[' + index +'].remark'] = $(this).find('td:nth-of-type(7)').text();
                param.cureList.push(cure);
            })

            $.ajax({
                type:"get",
                dataType:"json",
                contentType:"application/json",
                url:"../../../pre/addPrescript",
                data:param,
                success:function (result) {
                    layer.alert('处方添加成功', {
                        skin: 'layui-layer-molv' //样式类名
                        ,closeBtn: 0
                    }, function(){
                        location.href = "showSicker_toCure.jsp";
                    })
                }
            })

        }
        function retu() {
            location.href='showSicker_toCure.jsp'
        }

    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend><strong>处方添加页面</strong></legend>
</fieldset>

<div class="layuimini-container">
    <div class="layuimini-main">
        <button type="button" class="layui-btn" onclick="retu()"><i class="layui-icon"></i></button>
        <form class="layui-form" action="">

            <div class="layui-form-item">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">主诉</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" class="layui-textarea" id="mainsuit"></textarea>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">疾病诊断</label>
                <div class="layui-input-inline">
                    <select name="quiz1" id="illnesstype" lay-filter="illness" class="select">

                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="quiz2" id="illness" >

                    </select>
                </div>
            </div>

            <div class="layui-form-item" pane="">
                <label class="layui-form-label">处理方案</label>
                <div class="layui-input-block" id="cureType">

                </div>
            </div>



            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">用药</label>
                    <div class="layui-input-inline">
                        <select name="modules" lay-filter="drug" lay-verify="required" lay-search="" id="drugList">

                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">用法</label>
                    <div class="layui-input-inline">
                        <select name="modules" lay-verify="required" lay-search="" id="useage">

                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <div class="layui-inline">
                        <label class="layui-form-label">用量</label>
                        <div class="layui-input-inline" >
                            <input type="text" name="number" autocomplete="off" class="layui-input" id="dosage">
                        </div>
                        <label class="layui-form-label" id="unit"></label>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">

                </label>
                <div class="layui-input-block">
                    <span id="price" style="font-size:20px;font-weight:bold"></span>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                           class="layui-input" id="remark">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" type="button" lay-submit="" lay-filter="demo1">立即提交</button>
                    <button type="button" class="layui-btn layui-btn-normal" onclick="addPre()">添加</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="layui-form" id="preTable" lay-filter="preTable">
    <table class="layui-table">
        <colgroup>
            <col width="50">
            <col width="100">
            <col width="50">
            <col width="50">
            <col width="40">
            <col width="50">
            <col width="50">
            <col width="50">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>编号</th>
            <th>药名</th>
            <th>用法</th>
            <th>用量</th>
            <th>单位</th>
            <th>账单</th>
            <th>备注</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>

<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //监听指定开关
        form.on('switch(switchTest)', function (data) {
            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听下拉列表用药
        form.on('select(drug)', function (data) {
            var unitid = $("#drugList").val();
            var param = new Array();
            var param = unitid.split(",");
            $("#price").html("单价:"+param[2]+"元");
            $.getJSON("../../../unit/getUnitById","id="+param[1],function(result){
                $("#unit").html(result.data.name);
                var x= $("#unitid").val(param[1]);
            })
            form.render('select');
        })

        form.on('select(illness)', function (data) {
            var typeid = $("#illnesstype").val();
            $.getJSON("../../../pre/getIllness","id="+typeid,function (result) {
                $("#illness").html("<option value=''>请选择疾病名称</option>");
                $(result.data).each(function () {
                    $("#illness").append("<option value='"+this.id+"'>"+this.name+"</option>")
                })
                form.render('select');
            })
        })


        //监听提交
        form.on('submit(demo1)', function (data) {
            layer.open({
                type: 1
                ,title: false //不显示标题栏
                ,closeBtn: false
                ,area: '300px;'
                ,shade: 0.8
                ,id: 'demo11' //设定一个id，防止重复弹出
                ,btn: ['确定', '取消']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' +
                '是否确认' +
                '</div>'
                ,success: function(layero){
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn0').attr({
                        href: 'javascript:addPrescription()'
                        ,target: '_blank'
                    });
                }
             });
        })
    });

</script>

</body>
</html>