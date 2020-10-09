<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<base href="<%=path%>">
<%--代表HTML5--%>
<!DOCTYPE html>
<html>

<head>
	<title>评论信息 | Comment</title>
	<jsp:include page="../../includes/header.jsp"/>
</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
	<%--顶部导航--%>
	<jsp:include page="../../includes/top_navigate_backstage.jsp"/>
	<%--侧边菜单--%>
	<jsp:include page="../../includes/leftside_menu_navigate.jsp"/>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				<br>
				评论信息|
				<small>操作</small>
			</h1>

			<ol class="breadcrumb">
				<br>
				<li><a href="#"><i class="fa fa-users"></i> Comment </a></li>
				<li class="active">列表</li>
			</ol>
		</section>

		<br/><br/>
		<div class="col-xs-12">

			<%--Denger alert--%>
			<c:if test="${msg.msg != null}">
				<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<%--${msg}--%>
					<h4>${msg.msg}</h4>
				</div>
			</c:if>
			<%--/.alert--%>

			<div class="box">
				<div class="box-header">
					<h3 class="box-title">评论列表</h3>
					<div class="row" style="padding-left: 12px; padding-top: 10px;">
						<span style="cursor: pointer" type="button" class="btn-primary btn-sm usersectiondelete"><i
								class="fa fa-trash-o"></i>批量删除</span>&nbsp;&nbsp;
					</div>
					<div class="box-tools">
						<%--模糊搜索框--%>
						<form action="admin/usersearch" method="get">
							<div class="input-group input-group-sm" style="width: 150px;">
								<input type="text" name="keyword" class="form-control pull-right" placeholder="模糊搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<table id="myuserstable" class="table table-bordered table-striped">

					<thead>
					<tr>
						<th>
							<label>
								<input type="checkbox" class="minimal icheck_master">
							</label>
						</th>
						<th>编码</th>
						<th>留言人</th>
						<th>日期</th>
						<th>内容</th>
						<th>给谁留言</th>
						<th>留言景点</th>
						<th>留言论坛</th>
						<th>留言酒店</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>

					<c:forEach items="${byWords}" var="byWord">
						<tr>
							<td>
								<label>
									<input name="lw_id" value="${byWord.lw_id}" type="checkbox"
									       class="minimal minimal-myminor">
								</label>
							</td>
							<td>${byWord.lw_id}</td>
							<td><span class="label label-primary">${byWord.lw_name}</span></td>
							<td>${byWord.lw_date}</td>
							<td>${byWord.lw_content}</td>
							<td>${byWord.lw_for_name}</td>
							<td>${byWord.lw_for_article_id}</td>
							<td>${byWord.lw_forumId}</td>
							<td>${byWord.lw_hotel_id}</td>
							<td>
								<a href="admin/wordsDelete?lw_id=${byWord.lw_id}" class="btn btn-danger  btn-xs"><i
										class="fa fa-trash"></i>删除
								</a>
							</td>
						</tr>
					</c:forEach>

					</tbody>
				</table>
				<br>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
	</div>
	<!-- /.content-wrapper -->
</div>
<%--版权--%>
<jsp:include page="../../includes/copyright.jsp"/>
<%--css--%>
<jsp:include page="../../includes/footer.jsp"/>
<!-- page script -->
<script>
    $(function () {
        $('#myuserstable').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': false,
            'ordering': true,
            'info': true,
            'autoWidth': true
        });

        var _checkbox = App.getCheckbox();

        $(".usersectiondelete").click(function () {
            var lw_ids = [];
            var seletes = $(".minimal-myminor");
            for (var i = 0; i < seletes.length; i++) {
                if ($(seletes[i]).prop("checked")) {
                    lw_ids.push($(seletes[i]).val());
                }
            }

            $.ajax({
                url: "admin/wordsMutiDelete",
                type: "GET",
                data: {
                    "lw_ids": lw_ids
                },
                traditional: true,
                success: function (message) {
                    if (message == "1") {
                        window.location.href = "admin/wordsList";
                    }
                }
            });
        });
    })
</script>
</body>
</html>
