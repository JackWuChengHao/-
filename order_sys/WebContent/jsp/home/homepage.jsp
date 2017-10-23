<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/csslib.jsp"%>
<%@ include file="/jsp/jslib.jsp"%>
	<div class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<a href="/spring/jsp/home/homepage.jsp" class="navbar-brand">主页</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active dropdown"><a href="##" data-toggle="dropdown"
				class="dropdown-toggle">人员信息<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="/spring/jsp/userlist.jsp">查看人员信息</a></li>
				</ul></li>
		</ul>
		<ul class="nav  navbar-nav navbar-right">
			<li><a href="##">注销</a></li>
		</ul>
	</div>

