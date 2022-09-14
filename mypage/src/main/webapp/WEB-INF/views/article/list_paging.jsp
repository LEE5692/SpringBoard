<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<%@ include file = "../include/head.jsp" %>

<body class="hold-transition sidebar-mini">
<div class="wrapper">


  <!-- Navbar -->
  <%@ include file = "../include/main_header.jsp" %>

  <!-- Main Sidebar Container -->
  <%@ include file= "../include/left_column.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
       <div class="col-lg-12">
    <div class="card">
        <div class="card-header">
            <h3 class="card-title">게시글 목록</h3>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <th style="width: 30px">#</th>
                    <th>제목</th>
                    <th style="width: 100px">작성자</th>
                    <th style="width: 150px">작성시간</th>
                    <th style="width: 60px">조회</th>
                </tr>
                <c:forEach items="${articles}" var="article">
                <tr>
                    <td>${article.article_no}</td>
                    <td><a href="${path}/article/read?article_no=${article.article_no}">${article.title}</a></td>
                    <td>${article.writer}</td>
                    <td><fmt:formatDate value="${article.regdate}" pattern="yyyy-MM-dd a HH:mm"/></td>
                    <td><span class="badge bg-red">${article.viewcnt}</span></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="card-footer">
            <div class="float-right">
                <button type="button" class="btn btn-success btn-flat" id="writeBtn">
                    <i class="fa fa-pencil"></i> 글쓰기
                </button>
            </div>
        </div>
        <div class="card-footer">
  <nav aria-label="Contacts Page Navigation">
    <ul class="pagination justify-content-center m-0">
      <c:if test="${PageMaker.prev}">
        <li class="page-item"><a class="page-link"
        href="${path}/article/listPaging?page=${PageMaker.startPage - 1}">이전</a></li>
      </c:if>
      <c:forEach begin="${PageMaker.startPage}"
        end="${PageMaker.endPage}" var="idx">
        <li class="page-item"
        <c:out value="${PageMaker.criteria.page == idx ? 'class=active' : ''}"/>>
        <a class="page-link" href="${path}/article/listPaging?page=${idx}">${idx}</a>
        </li>
      </c:forEach>
      <c:if test="${PageMaker.next && pageMaker.endPage > 0}">
        <li class="page-item"><a class="page-link"
        href="${path}/article/listPaging?page=${PageMaker.endPage + 1}">다음</a></li>
      </c:if>
    </ul>
  </nav>
</div>

    </div>
</div>

       </div>
       </div>
       </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <%@ include file= "../include/main_footer.jsp" %>
<!-- REQUIRED SCRIPTS -->

<%@ include file= "../include/plugin_js.jsp" %>
</body>
</html>
