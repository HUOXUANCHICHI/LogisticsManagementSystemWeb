<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${driverList==null}">
    <c:redirect url="/DriverSelectServlet"/>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content="A project modified by a SIT student."/>
    <meta name="author" content="${username}"/>

    <title>物流信息管理系统-物流中心信息管理</title>

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

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">司机管理</h1>
            </div>
            <!-- Custom -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">导入司机信息</h6>
                    </div>
                    <form name="form" action="DriverInsertServlet" method="post">
                        <div class="card-body">
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="driverId"
                                           aria-describedby="emailHelp" placeholder="司机编号"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="driverName"
                                           aria-describedby="emailHelp" placeholder="司机名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="telephone"
                                           aria-describedby="emailHelp" placeholder="司机电话"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="driverAddress"
                                           aria-describedby="emailHelp" placeholder="司机地址"/>
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
                        <h6 class="m-0 font-weight-bold text-primary">司机信息</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>司机编号</th>
                                    <th>司机名称</th>
                                    <th>司机电话</th>
                                    <th>司机地址</th>
                                    <th>修改</th>
                                    <th>删除</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="driver" items="${driverList}">
                                    <tr>
                                        <td>${driver.driverId}</td>
                                        <td>${driver.driverName}</td>
                                        <td>${driver.telephone}</td>
                                        <td>${driver.driverAddress}</td>
                                        <td>
                                            <a href="DriverDispatcherServlet?driverId=${driver.driverId}">
                                                <button class="btn btn-primary btn-user btn-block">
                                                    修改
                                                </button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="DriverDeleteServlet?driverId=${driver.driverId}" onclick="if(!confirm('确认要删除这条司机信息吗？'))
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
