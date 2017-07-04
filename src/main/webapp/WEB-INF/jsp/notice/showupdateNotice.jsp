<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<style>
.center {
	width: auto;
	display: table;
	margin-left: auto;
	margin-right: auto;
}
</style>
<html>
<head>
<meta charset="utf-8">
<title>人事管理系统</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">

				<a class="navbar-brand">人事管理系统</a>
			</div>

		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">

				<br />
				<br />
				<br /> <a class="list-group-item active">用户管理</a> <a
					href="${ctx }/user/selectUser" class="list-group-item">用户查询</a> <a
					href="${ctx }/user/insertUser?flag=1" class="list-group-item">添加用户</a>
				<a href="" class="list-group-item active">部门管理</a> <a
					href="${ctx }/dept/selectDept" class="list-group-item">部门查询</a> <a
					href="${ctx }/dept/insertDept?flag=1" class="list-group-item">添加部门</a>
				<a href="#" class="list-group-item active">职位管理</a> <a
					href="${ctx }/job/selectJob" class="list-group-item">职位查询</a> <a
					href="${ctx }/job/insertJob?flag=1" class="list-group-item">添加职位</a>
				<a href="#" class="list-group-item active">员工管理</a> <a
					href="${ctx }/employee/selectEmployee" class="list-group-item">员工查询</a>
				<a href="${ctx }/employee/insertEmployee?flag=1"
					class="list-group-item">添加员工</a> <a href="#"
					class="list-group-item active">公告管理</a> <a
					href="${ctx }/notice/selectNotice" class="list-group-item">公告查询</a>
				<a href="${ctx }/notice/insertNotice?flag=1" class="list-group-item">添加公告</a>
				<a href="#" class="list-group-item active">下载中心</a> <a
					href="${ctx }/document/selectDocument" class="list-group-item">文件查询</a>
				<a href="${ctx }/document/insertDocument?flag=1"
					class="list-group-item">上传文件</a>
			</div>

			<h2 class="sub-header">Section title</h2>
			<div class="table-responsive">
				<form class="form-horizontal" role="form"
					action="${ctx}/notice/updateNotice" method="post">
					<input type="hidden" name="flag" value="2"> <input
						type="hidden" name="id" value="${notice.id }">
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">题目</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="title" name="title"
								placeholder="请输入标题" value="${requestScope.notice.title}">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-2 control-label">内容</label>
						<div class="col-xs-10">
							<textarea class="form-control" name="content" id="content">${requestScope.notice.content}</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">更新</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>