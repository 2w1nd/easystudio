<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/5/4
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/upload.css" type="text/css">
    <title>Upload</title>
</head>

<body>
<div class="wrapper">
    <form class="form" action="${pageContext.request.contextPath}/view/upload.do?method=upload" enctype="multipart/form-data" method="post">
        <input type="hidden" name="method" value="upload">
        <div class="pageTitle title">Upload </div>
        <div class="secondaryTitle title">Please fill this form to upload.</div>
        <input type="text" name="name" placeholder="电影名字" class="text formEntry" required/>
        <input type="number" name="years" placeholder="电影上映日期" class="text formEntry" required>
        <input type="file" accept="image/*" class="poster formEntry" placeholder="poster_image" name="poster" multiple="multiple" required/>
        <input type="file" accept="image/*" class="back formEntry" placeholder="back_image" name="back" multiple="multiple" required/>
        <input type="file" accept="video/mp4" class="movie formEntry" placeholder="movie_url" name="movie" multiple="multiple" required/>
        <input type="checkbox" class="termsConditions" value="Term">
        <label style="color: grey" > I Accept the <span style="color: #0e3721">Terms of Use</span> & <span style="color: #0e3721">Privacy Policy</span>.</label><br>
        <button type="submit" class="submit formEntry" >Submit</button>
        <div class="error">${error}</div>
    </form>
</div>
</body>
</html>