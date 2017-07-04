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


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<title>人事管理系统</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
		$(function(){

	 	   /** 获取上一次选中的部门数据 */
	 	   var boxs  = $("input[type='checkbox'][id^='box_']");
	 	   /** 删除员工绑定点击事件 */
	 	   $("#delete").click(function(){
	 		   /** 获取到用户选中的复选框  */
	 		   var checkedBoxs = boxs.filter(":checked");
	 		   if(checkedBoxs.length < 1){
	 			  alert("请选择一个需要删除的用户！");
	 		   }else{
	 			   /** 得到用户选中的所有的需要删除的ids */
	 			   var ids = checkedBoxs.map(function(){
	 				   return this.value;
	 			   })
	 					   window.location = "${ctx }/dept/deleteDept?ids=" + ids.get();
	 		   }
	 	   })
	    })
	</script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">

				<a class="navbar-brand" href="#">人事管理系统</a>
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
					action="${ctx}/dept/selectDept" method="post"
					enctype="mutipart/form-data">
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">名字</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="请输入名字" value="${requestScope.dept.name }">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">查询</button>


							<button type="button" class="btn btn-default" id="delete">删除</button>
						</div>
					</div>
				</form>
				<table class="table table-striped">

					<thead>
						<tr>
							<th><input type="checkbox" id="checkAll" name="checkAll" /></th>
							<th>部门名</th>
							<th>备注</th>

							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.depts}" var="dept"
							varStatus="stat">
							<tr id="data_${stat.index}" class="main_trbg"
								onMouseOver="move(this);" onMouseOut="out(this);">
								<td><input type="checkbox" id="box_${stat.index}"
									value="${dept.id}"></td>
								<td>${dept.name }</td>
								<td>${dept.remarks }</td>

								<td><a href="${ctx}/dept/updateDept?flag=1&id=${dept.id}">修改
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<table class="center">
				<tr>
					<td>
						<!-- 分页标签 -->
				<tr valign="top">
					<td align="center" class="font3"><fkjava:pager
							pageIndex="${requestScope.pageModel.pageIndex}"
							pageSize="${requestScope.pageModel.pageSize}"
							recordCount="${requestScope.pageModel.recordCount}" style="digg"
							submitUrl="${ctx}/dept/selectDept?pageIndex={0}&name=${requestScope.dept.name}" />
					</td>
				</tr>
			</table>
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