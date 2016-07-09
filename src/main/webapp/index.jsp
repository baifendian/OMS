<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  <title>百分点调休管理系统</title>
</head>
<body>
  <script>
  window.user = ${contextMap.user}
  window.now = "${contextMap.now}"
  window._csrf = "${_csrf.token}"
  
  </script>
  <div id="app"></div>
    <script src="/build/app.b5587d0dc24788840683.js"></script>
</body>
</html>