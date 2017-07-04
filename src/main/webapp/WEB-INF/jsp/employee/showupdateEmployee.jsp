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
				<br /> 
				<a class="list-group-item active">用户管理</a> <a
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
					action="${ctx}/employee/selectEmployee" method="post"
					enctype="mutipart/form-data">
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">职位</label>
						<div class="col-xs-3">
							<select class="form-control" name="job_id">
								<option value="0">--请选择职位</option>
								<c:forEach items="${requestScope.jobs}" var="job">
									<option value="${job.id}">${job.name}</option>
								</c:forEach>
							</select>

						</div>
						<label for="firstname" class="col-sm-2 control-label">名字</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="请输入名字" value="${request.employee.name}">
						</div>

					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">部门</label>
						<div class="col-xs-3">
							<select class="form-control" name="dept_id">
								<option value="0">--请选择职位</option>
								<c:forEach items="${requestScope.depts}" var="dept">
									<option value="${dept.id}">${dept.name}</option>
								</c:forEach>
							</select>

						</div>
						<label for="firstname" class="col-sm-2 control-label">手机</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="phone" name="phone"
								placeholder="请输入电话" value="${request.employee.phone}">
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">性别</label>
						<div class="col-xs-3">
							<select class="form-control" name="sex">
								<option value="0">--请选择职位</option>
								<option value="1">男</option>
								<option value="2">女</option>
							</select>

						</div>
						<label for="firstname" class="col-sm-2 control-label">身份证</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="card_id"
								name="card_id" placeholder="请输入名字"
								value="${requestScope.employee.card_id}">
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">学历</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="education"
								name="education" placeholder="请输入学历"
								value="${requestScope.employee.education}">

						</div>
						<label for="firstname" class="col-sm-2 control-label">邮箱</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="请输入邮箱" value="${requestScope.employee.email}">
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">电话</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="tel" name="tel"
								placeholder="请输入电话" value="${requestScope.employee.tel}">

						</div>
						<label for="firstname" class="col-sm-2 control-label">政治面貌</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="party" name="party"
								placeholder="请输入政治面貌" value="${requestScope.employee.party}">
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">qq</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="qq_num" name="qq_num"
								placeholder="请输入qq" value="${requestScope.employee.qq_num}">

						</div>
						<label for="firstname" class="col-sm-2 control-label">联系地址</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="address"
								name="address" placeholder="请输入联系地址"
								value="${requestScope.employee.address}">
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">邮政编码</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="post_code"
								name="post_code" placeholder="请输入名字"
								value="${requestScope.employee.post_code}">

						</div>
						<label for="firstname" class="col-sm-2 control-label">出生日期</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="birthday"
								name="birthday" placeholder="请输入出生日期"
								value="${requestScope.employee.birthday}">
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">名族</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="race" name="race"
								placeholder="请输入民族" value="${requestScope.employee.race}">

						</div>
						<label for="firstname" class="col-sm-2 control-label">所学专业</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="speciality"
								name="speciality" placeholder="请输入专业"
								value="${requestScope.employee.speciality}">
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">爱好</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="hobby" name="hobby"
								placeholder="请输入爱好" value="${requestScope.employee.hobby}">

						</div>
						<label for="firstname" class="col-sm-2 control-label">备注</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="remarks"
								name="remarks" placeholder="请输入备注"
								value="${requestScope.employee.remarks}">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">添加</button>


							<button type="button" class="btn btn-default" id="delete">删除</button>
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
	<script>
		window.jQuery|| document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>