
<%--
  Created by IntelliJ IDEA.
  User: liuzhenjiu
  Date: 2021-01-25
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
        /******登录功能*****/
        $(function(){
            //给登录按钮添加事件
            $("#login").click(
                function () {
                    //获取表单对象
                    var loginForm = $("#loginForm");
                    //提交表单
                    loginForm.submit();
                })
        })
    </script>
</head>
<body>
<%--  创建登陆页面 --%>

<%--  创建面板组件  --%>
    <div style="margin:auto;margin-top:120px;width:402px;">
        <%--判断是否是登录失败重定向过来的，是则显示提示语--%>
        <c:if test="${sessionScope.flag=='loginFail'}">
            <font color="red" size="20px">用户名或密码错误</font>
        </c:if>
        <%--清除session中的登录失败的标记(使用一次后，标记应当失效)--%>
        <c:remove var="flag" scope="session"></c:remove>

        <%--判断是否是登录失败重定向过来的，是则显示提示语--%>
        <c:if test="${sessionScope.flag=='loginFail'}">
            <font color="red" size="20px">用户名或密码错误</font>
        </c:if>
        <%--清除session中的登录失败的标记--%>
        <c:remove var="flag" scope="session"></c:remove>

        <%--      在form表单中书写table>tr*3>tb*2,之后按Tab键      --%>
        <form action="">
            <table>
                <tr>
                    <tb></tb>
                    <tb></tb>
                </tr>
                <tr>
                    <tb></tb>
                    <tb></tb>
                </tr>
                <tr>
                    <tb></tb>
                    <tb></tb>
                </tr>
            </table>
        </form>


        <form id="loginForm" action="admin/userLogin" method="post">
            <div class="easyui-panel" style="width:400px;padding:50px 60px" title="欢迎登录项目后台管理系统">
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" name="aname" prompt="请输入用户名" iconWidth="28" style="width:100%;height:34px;padding:10px;">
                </div>
                <div style="margin-bottom:20px">
                    <input id="pass" class="easyui-passwordbox" name="apwd" prompt="请输入密码" iconWidth="28" style="width:100%;height:34px;padding:10px">
                </div>
                <div style="margin-bottom:20px">
                    <a href="javascript:void(0)" id="login" class="easyui-linkbutton c8" style="width:120px">点击登录</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="easyui-checkbox" name="fruit" value="Apple" label="记住密码" labelPosition="after">
                </div>
            </div>
        </form>
        <div id="viewer"></div>
    </div>


<script type="text/javascript">
    $('#pass').passwordbox({
        inputEvents: $.extend({}, $.fn.passwordbox.defaults.inputEvents, {
            keypress: function(e){
                var char = String.fromCharCode(e.which);
                $('#viewer').html(char).fadeIn(200, function(){
                    $(this).fadeOut();
                });
            }
        })
    })
</script>
<style>
    #viewer{
        position: relative;
        padding: 0 60px;
        top: -70px;
        font-size: 54px;
        line-height: 60px;
    }
</style>



</body>
<body>

</body>
</html>
