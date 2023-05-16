<%@ page import="model.Manufacturer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    <title>物流信息管理系统-司机信息修改</title>

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
                <h1 class="h3 mb-4 text-gray-800">司机信息修改</h1>
            </div>
            <!-- Custom -->
            <div class="justify-content-center">
                <form name="form" action="DriverUpdateServlet" method="post">
                    <div class="user">
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="driverId"
                                        aria-describedby="emailHelp"
                                        placeholder="司机编号"
                                        value=""
                                        name="driverId"
                                        readonly
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="driverName"
                                        aria-describedby="emailHelp"
                                        placeholder="司机名称"
                                        name="driverName"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="telephone"
                                        aria-describedby="emailHelp"
                                        placeholder="司机电话"
                                        name="telephone"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="driverAddress"
                                        aria-describedby="emailHelp"
                                        placeholder="司机地址"
                                        name="driverAddress"
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
    document.getElementById("driverId").value = getUrlVariable("driverId");
</script>
</body>
</html>
