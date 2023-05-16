<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${arriveCollect==null}">
    <c:redirect url="/GoodsSelectServletByArrive"/>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content="A project modified by a SIT student."/>
    <meta name="author" content="${username}"/>

    <title>物流信息管理系统-货物运输信息管理</title>

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
                <h1 class="h3 mb-4 text-gray-800">货物管理</h1>
            </div>
            <!-- Custom -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">导入货物信息</h6>
                    </div>
                    <form name="form" action="GoodsInsertServlet" method="post">
                        <div class="card-body">
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="goodsId"
                                           aria-describedby="emailHelp" placeholder="货物编号"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="goodsName"
                                           aria-describedby="emailHelp" placeholder="货物名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="goodsAddress"
                                           aria-describedby="emailHelp" placeholder="货物地址"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="goodsWeight"
                                           aria-describedby="emailHelp" placeholder="货物重量"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <div class="dropdown">
                                        <select
                                                id="carNumber"
                                                class="form-control
                                            form-control-placeholder"
                                                name="carNumber">
                                            <option value="-1" disabled selected hidden>车辆</option>
                                            <c:forEach var="vehicles" items="${vehicleList}">
                                                <option value="${vehicles.carNumber}" style="color: black;">${vehicles.carNumber}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <div class="dropdown">
                                        <select
                                                id="driverName"
                                                class="form-control
                                            form-control-placeholder"
                                                name="driverName">
                                            <option value="-1" disabled selected hidden>司机</option>
                                            <c:forEach var="drivers" items="${driverList}">
                                                <option value="${drivers.driverName}" style="color: black;">${drivers.driverName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="range"
                                           aria-describedby="emailHelp" placeholder="范围"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="customName"
                                           aria-describedby="emailHelp" placeholder="客户"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <div class="dropdown">
                                        <select
                                                id="state"
                                                class="form-control
                                            form-control-placeholder"
                                                name="state">
                                            <option value="-1" disabled selected hidden>送达</option>
                                            <c:forEach var="goods1" items="${goodsListByState}">
                                                <option value="${goods1.state}" style="color: black;">${goods1.state}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="date"
                                           aria-describedby="emailHelp" placeholder="时间"/>
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
                        <h6 class="m-0 font-weight-bold text-primary">货物信息</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>货物编号</th>
                                    <th>货物名称</th>
                                    <th>货物地址</th>
                                    <th>货物重量</th>
                                    <th>车辆</th>
                                    <th>司机</th>
                                    <th>运送范围</th>
                                    <th>客户</th>
                                    <th>状态</th>
                                    <th>时间</th>
                                    <th>修改</th>
                                    <th>删除</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="arrivegoods" items="${arriveCollect}">
                                    <tr>
                                        <td>${arrivegoods.goodsId}</td>
                                        <td>${arrivegoods.goodsName}</td>
                                        <td>${arrivegoods.goodsAddress}</td>
                                        <td>${arrivegoods.goodsWeight}</td>
                                        <td>${arrivegoods.carNumber}</td>
                                        <td>${arrivegoods.driverName}</td>
                                        <td>${arrivegoods.range}</td>
                                        <td>${arrivegoods.customName}</td>
                                        <td>${arrivegoods.state}</td>
                                        <td>${arrivegoods.date}</td>
                                        <td>
                                            <a href="GoodsDispatcherServlet?goodsId=${arrivegoods.goodsId}">
                                                <button class="btn btn-primary btn-user btn-block">
                                                    修改
                                                </button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="GoodsDeleteServlet?goodsId=${arrivegoods.goodsId}" onclick="if(!confirm('确认要删除这条货物信息吗？'))
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

    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->

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
