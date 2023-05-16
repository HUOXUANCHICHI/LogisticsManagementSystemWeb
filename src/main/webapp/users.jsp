<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${usersList==null}">
    <c:redirect url="/UsersSelectServlet"/>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content="A project modified by a SIT student."/>
    <meta name="author" content="${username}"/>

    <title>物流信息管理系统-用户信息管理</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
    <!-- <link
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet"
    /> -->

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet"/>

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet"/>
</head>

<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">


    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->

            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">用户信息管理</h1>
            </div>
            <!-- Custom -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">导入用户信息</h6>
                    </div>
                    <form name="form" action="UserInsertServlet" method="post">
                        <div class="card-body">
                                <div class="form-group">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="userId"
                                               name="userId"
                                               aria-describedby="emailHelp" placeholder="用户id"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="username"
                                               name="username"
                                               aria-describedby="emailHelp" placeholder="用户名"/>
                                    </div>
                                </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" id="userPwd"
                                           name="userPwd"
                                           aria-describedby="emailHelp" placeholder="用户密码"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" id="userContact"
                                           name="userContact"
                                           aria-describedby="emailHelp" placeholder="用户联系方式"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="accountRole" id="inlineRadio1" value="0" checked>
                                    <label class="form-check-label" for="inlineRadio1">用户</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="accountRole" id="inlineRadio2" value="1">
                                    <label class="form-check-label" for="inlineRadio2">管理员</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="accountRole" id="inlineRadio3" value="2">
                                    <label class="form-check-label" for="inlineRadio3">员工</label>
                                </div>
                                    </div>
                            </div>

                            <div class="col-sm-3 mb-3 mb-sm-0">
                                <button class="btn btn-primary btn-user btn-block">
                                    导入
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">用户信息</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>用户编号</th>
                                    <th>用户名</th>
                                    <th>用户密码</th>
                                    <th>用户联系方式</th>
                                    <th>权限</th>
                                    <th>修改</th>
                                    <th>删除</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${usersList}">
                                    <tr>
                                        <td>${user.userId}</td>
                                        <td>${user.username}</td>
                                        <td>${user.userPwd}</td>
                                        <td>${user.userContact}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${user.accountRole==0}">用户</c:when>
                                                <c:when test="${user.accountRole==1}">管理员</c:when>
                                                <c:when test="${user.accountRole==2}">员工</c:when>
                                                <c:otherwise>${user.accountRole}</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <a href="UsersDispatcherServlet?userId=${user.userId}">
                                                <button class="btn btn-primary btn-user btn-block">
                                                    修改
                                                </button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="UsersDeleteServlet?userId=${user.userId}" onclick="if(!confirm('确认要删除这条用户信息吗？'))
                                            window.event.returnValue = false;">
                                                <button class="btn btn-primary btn-user btn-block">
                                                    删除
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End of Custom -->
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->

        <!-- Footer -->

        <!-- End of Footer -->
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>


<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>
<script src="js/demo/datatables-demo.js"></script>
</body>

</html>
