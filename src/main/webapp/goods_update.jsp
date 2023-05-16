<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="A project modified by a SIT student."/>
    <meta name="author" content="${username}"/>

    <title>物流信息管理系统-货物信息修改</title>

    <!-- Custom fonts for this template-->
    <link
            href="vendor/fontawesome-free/css/all.min.css"
            rel="stylesheet"
            type="text/css"
    />
    <!-- <link
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet"
    /> -->

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet"/>
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
                <h1 class="h3 mb-4 text-gray-800">货物信息修改</h1>
            </div>
            <!-- Custom -->
            <div class="justify-content-center">
                <form name="form" action="GoodsUpdateServlet" method="post">
                    <div class="user">
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="goodsId"
                                        aria-describedby="emailHelp"
                                        placeholder="货物编号"
                                        value="${goods.goodsId}"
                                        name="goodsId"
                                        readonly
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="goodsName"
                                        aria-describedby="emailHelp"
                                        placeholder="货物名称"
                                        name="goodsName"
                                        value="${goods.goodsName}"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="goodsAddress"
                                        aria-describedby="emailHelp"
                                        placeholder="货物地址"
                                        name="goodsAddress"
                                        value="${goods.goodsAddress}"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="goodsWeight"
                                        aria-describedby="emailHelp"
                                        placeholder="货物重量"
                                        name="goodsWeight"
                                        value="${goods.goodsWeight}"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <div class="dropdown">
                                    <select
                                            id="carNumber"
                                            class="form-control
                                            form-control-placeholder"
                                            placeholder="车牌号"
                                            name="carNumber"
                                    >
<%--                                        <option value="-1">${vehicle.carNumber}</option>--%>
                                        <c:forEach var="vehicle" items="${vehicleList}">
                                            <c:choose>
                                                <c:when test="${vehicle.carNumber==goods.carNumber}">
                                                    <option value="${vehicle.carNumber}" selected>${vehicle.carNumber}</option>
                                                </c:when>
                                            </c:choose>
                                            <option value="${vehicle.carNumber}" style="color: black;">${vehicle.carNumber}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <div class="dropdown">
                                    <select
                                            id="driverName"
                                            class="form-control
                                            form-control-placeholder"
                                            placeholder="司机"
                                            name="driverName"
                                    >
                                        <c:forEach var="driver" items="${driverList}">
                                            <c:choose>
                                                <c:when test="${driver.driverName==goods.driverName}">
                                                    <option value="${driver.driverName}" selected>${driver.driverName}</option>
                                                </c:when>
                                            </c:choose>
                                            <option value="${driver.driverName}" style="color: black;">${driver.driverName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="range"
                                        aria-describedby="emailHelp"
                                        placeholder="运送范围"
                                        name="range"
                                        value="${goods.range}"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="customName"
                                        aria-describedby="emailHelp"
                                        placeholder="客户"
                                        name="customName"
                                        value="${goods.customName}"
                                />
                            </div>
                        </div>
<%--                        <div class="form-group">--%>
<%--                            <div class="col-sm-6 mb-3 mb-sm-0">--%>
<%--                                <input--%>
<%--                                        type="text"--%>
<%--                                        class="form-control form-control-user"--%>
<%--                                        id="state"--%>
<%--                                        aria-describedby="emailHelp"--%>
<%--                                        placeholder="状态"--%>
<%--                                        name="state"--%>
<%--                                        value="${goods.state}"--%>
<%--                                />--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <div class="dropdown">
                                    <select
                                            id="state"
                                            class="form-control
                                            form-control-placeholder"
                                            name="state">
                                        <c:forEach var="goods1" items="${goodsListByState}">
                                            <c:choose>
                                                <c:when test="${goods1.state==goods.state}">
                                                    <option value="${goods1.state}" selected>${goods1.state}</option>
                                                </c:when>
                                            </c:choose>
                                            <option value="${goods1.state}" style="color: black;">${goods1.state}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="date"
                                        aria-describedby="emailHelp"
                                        placeholder="时间"
                                        name="date"
                                        value="${goods.date}"
                                />
                            </div>
                        </div>
                        <div class="col-sm-3 mb-3 mb-sm-0">
                            <button class="btn btn-primary btn-user btn-block">
                                更新
                            </button>
                        </div>
                    </div>
                </form>
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

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>
<script src="js/getUrlVariable.js"></script>
<script>
    document.getElementById("goodsId").value = getUrlVariable("goodsId");
</script>
</body>
</html>
