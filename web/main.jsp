<%--
  Created by IntelliJ IDEA.
  User: liuzhenjiu
  Date: 2021-01-27
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=basePath %>"/>
    <title>Title</title>
    <%--  引入easyui的资源  注意"第一个/"表示服务器根目录--%>
    <link rel="stylesheet" type="text/css" href="static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="static/themes/demo.css">
    <link rel="stylesheet" type="text/css" href="static/themes/color.css">
    <script type="text/javascript" src="static/jquery.min.js"></script>
    <script type="text/javascript" src="static/jquery.easyui.min.js"></script>
    <%--  声明js代码域  --%>
    <script type="text/javascript">
        /**菜单和选项卡的联动效果实现**/
        $(function(){
            //给菜单添加单击事件
            $("#menuTree").tree({
                onClick:function(node){
                    //判断当前菜单是否为上级菜单,是则获取其子菜单资源;不是则新增选项卡显示资源
                    console.log(node);
                    if(node.attributes.isparent==1){
                        return;
                    }else{
                        //判断当前选项卡是否存在--存在则选中;不存在则新增
                        var flag = $("#menuTabs").tabs("exists",node.text);
                        if(flag){
                            flag = $("#menuTabs").tabs("select",node.text);
                        }else{
                            //点击选项卡后新增资源页面
                            $("#menuTabs").tabs("add",{
                                title:node.text,
                                closable:true,
                                content:"<iframe src='"+node.attributes.url+"' width='99%' height='99%'></iframe>"
                            });
                        }


                    }
                    //console.log(node);
                    //lert("qqqqqq");
                }
            })
        })
    </script>
</head>
<%--布置主页面布局--%>
<body class="easyui-layout">
<%--布局:网站头部 split:false分隔框不可拖动;注意data-options用,对各项进行分隔--%>
<div data-options="region:'north',title:'',split:false" style="height:75px;">
    <%--使用layout嵌套布局,分为西中东三部分 fit:true表示与父容器自适应--%>
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',border:false"
             style="width:20%;text-align:center;background-image: url('static/images/bg.png')">
            <%-- 显示网站logo 居中text-align:center--%>
            <img src="static/images/logo.png" style="margin-top: 16px"/>
        </div>
        <div data-options="region:'center',border:false"
             style="background-image: url('static/images/bg.png');text-align: center">
            <%--网站标题--%>
            <span style="color:white;font-size: 30px;position: relative;top:17px;">
                    后&nbsp;&nbsp;台&nbsp;&nbsp;管&nbsp;&nbsp;理&nbsp;&nbsp;系&nbsp;&nbsp;统
                </span>
        </div>
        <div data-options="region:'east',border:false" style="width:25%;background-image: url('static/images/bg.png')">
            <%--设置网站登录信息--%>
            <span style="position: relative;top:40px;font-size: 15px;">
                    <span style="color:white;">您好,${sessionScope.admin.aname}</span>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <span><a href="#" style="color:white">退出</a> </span>
                </span>
        </div>
    </div>
</div>
<%--布局:网站底部--%>
<div data-options="region:'south',title:'',split:false" style="height:50px;"></div>
<%--布局:不需要--%>
<%--<div data-options="region:'east',title:'East',split:true" style="width:100px;"></div>--%>
<%--布局:网站菜单--%>
<div data-options="region:'west',title:'系统菜单',collapsible:false,split:false" style="width:150px;">
    <%--声明菜单异步树--%>
    <ul id="menuTree" class="easyui-tree" data-options="url:'menu/menuInfo'">

    </ul>
</div>
<%--布局:网站中心区域(内容区域)--%>
<div data-options="region:'center',title:''" style="padding:5px;background:#eee;">
    <%--使用选项卡组件显示菜单资源--%>
    <div id="menuTabs" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">
        <div title="首页" style="padding:20px;display:none;"> tab1</div>

    </div>
</div>
</body>

</html>
