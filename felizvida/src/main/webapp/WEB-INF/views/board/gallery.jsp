<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>QnA</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/felizvida/resources/assets/css/main.css" />
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="/felizvida/board/main" class="logo"> <strong>물어</strong>
						보세요
					</a>
					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span
								class="label">Snapchat</span></a></li>
						<li><a href="#" class="icon brands fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span
								class="label">Medium</span></a></li>
					</ul>
				</header>

				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<
						<header>
							<h1>안녕하세요, 질문하는 게시판입니다.</h1>
							<p>HTML5와 CSS3으로 제작하였습니다.</p>
						</header>
						<table class="table-wrapper">
							<thead>
								<tr>
									<th>글번호</th>
									<th>제목</th>
									<th>작성날짜</th>
									<th>작성자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="dto">
									<tr>
										<td><c:if test="${dto.idx ne '0'}">${dto.idx}</c:if></td>
										<td>${dto.title}</td>
										<td>${dto.wdate}</td>
										<td>${dto.name}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</article>
						<article>
							<div>
								<a href="/felizvida/board/main">더보기</a>
							</div>
							<table class="table-wrapper">
								<thead>
									<tr>
										<th>글번호</th>
										<th>제목</th>
										<th>작성날짜</th>
										<th>작성자</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="dto">
										<tr>
											<td><c:if test="${dto.idx ne '0'}">${dto.idx}</c:if></td>
											<td>${dto.title}</td>
											<td>${dto.wdate}</td>
											<td>${dto.name}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</article>
					</div>
				</section>


				<!-- Sidebar -->
				<div id="sidebar">
					<div class="inner">

						<!-- Search -->
						<section id="search" class="alt">
							<form method="post" action="#">
								<input type="text" name="query" id="query" placeholder="Search" />
							</form>
						</section>

						<!-- Menu -->
						<nav id="menu">
							<header class="major">
								<h2>Menu</h2>
							</header>
							<ul>
								<li><a href="/felizvida/board/main">Homepage</a></li>
								<li><a href="/felizvida/board/qna">Q&A</a></li>
								<li><a href="/felizvida/board/gallery">Gallery</a></li>
								<li><span class="opener">Submenu</span>
									<ul>
										<li><a href="#">Lorem Dolor</a></li>
										<li><a href="#">Ipsum Adipiscing</a></li>
										<li><a href="#">Tempus Magna</a></li>
										<li><a href="#">Feugiat Veroeros</a></li>
									</ul></li>
								<li><a href="#">Etiam Dolore</a></li>
								<li><a href="#">Adipiscing</a></li>
								<li><span class="opener">Another Submenu</span>
									<ul>
										<li><a href="#">Lorem Dolor</a></li>
										<li><a href="#">Ipsum Adipiscing</a></li>
										<li><a href="#">Tempus Magna</a></li>
										<li><a href="#">Feugiat Veroeros</a></li>
									</ul></li>
								<li><a href="#">Maximus Erat</a></li>
								<li><a href="#">Sapien Mauris</a></li>
								<li><a href="#">Amet Lacinia</a></li>
							</ul>
						</nav>

						<!-- Footer -->
						<footer id="footer">
							<p class="copyright">
								&copy; Untitled. All rights reserved. Demo Images: <a
									href="https://unsplash.com">Unsplash</a>. Design: <a
									href="https://html5up.net">HTML5 UP</a>.
							</p>
						</footer>

					</div>
				</div>

			</div>

			<!-- Scripts -->
			<script src="/felizvida/resources/assets/js/jquery.min.js"></script>
			<script src="/felizvida/resources/assets/js/browser.min.js"></script>
			<script src="/felizvida/resources/assets/js/breakpoints.min.js"></script>
			<script src="/felizvida/resources/assets/js/util.js"></script>
			<script src="/felizvida/resources/assets/js/main.js"></script>
</body>
</html>