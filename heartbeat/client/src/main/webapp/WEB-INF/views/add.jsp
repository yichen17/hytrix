<%--
  Created by IntelliJ IDEA.
  User: E480
  Date: 2021/9/9
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <meta http-equiv="content-type" content="multipart/form-data" charset="utf-8">--%>
    <title>添加视频</title>
</head>
<body>
<form action="/cook/save" method="post" enctype="multipart/form-data">
    <label>食物名称</label>
    <input type="text" placeholder="请输入食物名称" id="foodName" name="foodName" value="" />
    <label>图片</label>
    <input type="file" placeholder="请选择图片" id="image" name="image" value=""/>
    <button type="submit" >提交</button>
</form>
</body>
</html>
