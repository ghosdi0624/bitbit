<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/70213049c5.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">
<title>댓글</title>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-8">
      <h2 class="page-header">댓글</h2>
        <section class="comment-list">
					<c:forEach var="cmt" items="${cmtList }">
						<!-- First Comment -->
						<article class="row">
							<div class="col-md-2 col-sm-2 hidden-xs">
								<figure class="thumbnail">
									<img class="img-responsive"
										src="http://www.keita-gaming.com/assets/profile/default-avatar-c5d8ec086224cb6fc4e395f4ba3018c2.jpg" />
									<figcaption class="text-center">
										<c:out value="${cmt.writer }" />
									</figcaption>
								</figure>
							</div>
							<div class="col-md-10 col-sm-10">
								<div class="panel panel-default arrow left">
									<div class="panel-body">
										<header class="text-left">
											<div class="comment-user">
												<i class="fa fa-user"></i> <c:out value="${cmt.writer }" />
											</div>
											<time class="comment-date" datetime="16-12-2014 01:05">
												<i class="fa fa-clock-o"></i>
												<c:out value="${cmt.regDate }" />
											</time>
										</header>
										<div class="comment-post">
											<p>
												<c:out value="${cmt.coment }" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</article>
					</c:forEach>
        </section>
    </div>
  </div>
</div>

</body>
</html>