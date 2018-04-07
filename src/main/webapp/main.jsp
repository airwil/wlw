<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>系统主页</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script src="${pageContext.request.contextPath}/js/common.js"></script>
    <script type="text/javascript">
        checkCookie();
        var url;

        function addTab(url, text, iconCls) {
            var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/views/"
                + url + "'></iframe>";
            $("#tabs").tabs("add", {
                title: text,
                iconCls: iconCls,
                closable: true,
                content: content
            });
        }

        function openTab(text, url, iconCls) {
            if ($("#tabs").tabs("exists", text)) {
                $("#tabs").tabs("close", text);
                addTab(url, text, iconCls);
                $("#tabs").tabs("select", text);
            } else {
                addTab(url, text, iconCls);
            }
        }

        function logout() {
            $.messager
                .confirm(
                    "系统提示",
                    "您确定要退出系统吗",
                    function (r) {
                        if (r) {
                            clearCookie();
                        }
                    });
        }
    </script>
<body class="easyui-layout">
<div region="north" style="height: 48px;background-color: #ffff">

    <table width="100%">
        <tr>

            <td valign="bottom"
                style="font-size: 20px;color:#8B8B8B;font-family: '楷体';"
                align="left" width="50%"><font size="3">&nbsp;&nbsp;<strong>当前用户：</strong>
                admin</font>【管理员】
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 20px;"><a href="https://github.com/ZHENFENG13/perfect-ssm"
                                                              target="_blank"
                                                              style="font-size: 20px;"></a></div>
            <div align="center" style="padding-top: 50px">
                <font color="grey" size="10">物联网及泛在工程技术研究中心</font>
            </div>
        </div>
    </div>
</div>
<div region="west" style="width: 200px;height:500px;" title="导航菜单"
     split="true">
    <div class="easyui-accordion">
        <%--<div title="资讯管理"
             data-options="selected:true,iconCls:'icon-wenzhangs'"
             style="padding: 10px;height:10px;">
            <a
                    href="javascript:openTab(' 文章管理-ue','articleManage-ue.jsp','icon-wenzhang')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-wenzhang'"
                    style="width: 150px;"> UEditor</a>
            <a
                    href="javascript:openTab(' 文章管理-ke','articleManage-ke.jsp','icon-wenzhang')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-wenzhang'"
                    style="width: 150px;"> kindEditor(推荐)</a>
        </div>--%>
        <div title="内容管理" data-options="iconCls:'icon-shouye'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 中心介绍','IntroductManage.jsp','icon-tupians')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-kaoyan'"
                    style="width: 150px;"> 中心介绍</a>
            <a
                    href="javascript:openTab(' 产品中心','proManage.jsp?type=1&grade=1','icon-tupians')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-sushe'"
                    style="width: 150px;"> 产品中心</a>
            <a
                    href="javascript:openTab(' 解决方案','solutionManage.jsp','icon-tupians')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-tupian'"
                    style="width: 150px;">解决方案</a>
            <a
                    href="javascript:openTab(' 新闻资讯','articleManage-ke.jsp','icon-wenzhang')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-wenzhang'"
                    style="width: 150px;"> 新闻资讯</a>
        </div>
        <div title="资源管理" data-options="iconCls:'icon-order'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 文件管理','resourceManage.jsp','icon-tupians')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-tupian'"
                    style="width: 150px;"> 文件列表</a>
        </div>
        <div title="联系我们" data-options="iconCls:'icon-tip'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 更新信息','cotactManage.jsp','icon-tupians')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-tip'"
                    style="width: 150px;"> 更新信息</a>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
            <%--<a href="javascript:openTab(' 管理员列表','userManage.jsp','icon-lxr')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-lxr'" style="width: 150px;">
                管理员列表</a>--%>
            <a href="javascript:logout()"
                            class="easyui-linkbutton"
                            data-options="plain:true,iconCls:'icon-exit'"
                            style="width: 150px;">
            安全退出</a>
        </div>
    </div>
</div>
</body>
</html>