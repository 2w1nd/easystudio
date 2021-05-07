<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/5/2
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>视频在线播放</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/video-js.min.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/video.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/video.css" type="text/css">
</head>
<body oncontextmenu="self.event.returnValue=false" onselectstart="return false" >
<div>
    <video id="myVideo" class="video-js vjs-big-play-centered"
           controls preload="auto" width="800" height="500"
           poster= '${pageContext.request.contextPath}/static/images/${movie.getPoster()}'
           data-setup='{"example_option":true}'>
        <source src='${pageContext.request.contextPath}/static/video/${movie.getUrl()}' type='video/mp4' />
    </video>
</div>
</body>
</html>
