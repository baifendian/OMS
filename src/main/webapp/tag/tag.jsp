<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path"  value="${pageContext.request.contextPath}" scope="session"></c:set>
<c:set var="JSpath"  value="${pageContext.request.contextPath}/js"  scope="session"></c:set>
<!--jQuery js-->
<script src="${JSpath}/jquery-2.1.3.min.js" charset="utf-8" type="text/javascript"></script>
<!--MiniUI-->
<script src="${JSpath}/miniui/miniui.js" charset="utf-8" type="text/javascript"></script>
<link href="${JSpath}/miniui/themes/default/miniui.css"  rel="stylesheet"
	type="text/css" />
<link href="${JSpath}/miniui/themes/icons.css" rel="stylesheet" type="text/css"/>
