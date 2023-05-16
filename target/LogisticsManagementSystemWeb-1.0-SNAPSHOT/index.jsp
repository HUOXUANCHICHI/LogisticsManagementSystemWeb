<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="A project modified by a SIT student." />
    <meta name="author" content="Soldier_RMB" />

    <title>物流信息管理系统</title>

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
    <link href="css/sb-admin-2.min.css" rel="stylesheet" />

  </head>

  <body id="page-top">
    <!-- 跨域侧边栏 -->
    <div id="wrapper" class="leftnav">
      <!-- Sidebar -->
      <ul
        class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
        id="accordionSidebar"
      >
        <!-- Sidebar - Brand -->
        <a
          class="sidebar-brand d-flex align-items-center justify-content-center"
          href="index.jsp"
        >
          <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
          </div>
          <div class="sidebar-brand-text mx-3">LMS <sup>2</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0" />

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
          <a class="nav-link" href="index.jsp">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>主页</span></a
          >
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider" />

        <!-- Heading -->
        <div class="sidebar-heading">功能</div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
          <a
            class="nav-link collapsed"
            href="#"
            data-toggle="collapse"
            data-target="#collapsePages"
            aria-expanded="true"
            aria-controls="collapsePages"
          >
            <i class="fas fa-fw fa-folder"></i>
            <span>登录相关</span>
          </a>
          <div
            id="collapsePages"
            class="collapse"
            aria-labelledby="headingPages"
            data-parent="#accordionSidebar"
          >
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">登录相关：</h6>
              <a class="collapse-item" href="login.jsp">登录</a>
              <a class="collapse-item" href="register.jsp">注册</a>
              <a class="collapse-item" href="forgotPassword.jsp">忘记密码</a>
            </div>
          </div>
        </li>

        <li class="nav-item">
          <a
            class="nav-link collapsed"
            href="#"
            data-toggle="collapse"
            data-target="#managePages"
            aria-expanded="true"
            aria-controls="managePages"
          >
            <i class="fas fa-fw fa-folder"></i>
            <span>管理相关</span>
          </a>
          <div
            id="managePages"
            class="collapse"
            aria-labelledby="headingPages"
            data-parent="#accordionSidebar"
          >
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">管理相关：</h6>
              <a class="collapse-item" href="manufacturer.jsp" target="right">制造商信息管理</a>
              <a class="collapse-item" href="retailer.jsp" target="right">零售商信息管理</a>
              <a class="collapse-item" href="products.jsp" target="right">产品信息管理</a>
              <a class="collapse-item" href="logisticsCenter.jsp" target="right">物流中心信息管理</a>
              <a class="collapse-item" href="warehouse.jsp" target="right">仓库信息管理</a>
              <a class="collapse-item" href="users.jsp" target="right">用户信息管理</a>
              <a class="collapse-item" href="logManage.jsp" target="right">登录日志管理</a>
            </div>
          </div>
        </li>

        <li class="nav-item">
          <a
                  class="nav-link collapsed"
                  href="#"
                  data-toggle="collapse"
                  data-target="#basePages"
                  aria-expanded="true"
                  aria-controls="basePages"
          >
            <i class="fas fa-fw fa-folder"></i>
            <span>基础信息</span>
          </a>
          <div
                  id="basePages"
                  class="collapse"
                  aria-labelledby="headingPages"
                  data-parent="#accordionSidebar"
          >
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">基础信息：</h6>
              <a class="collapse-item" href="driver.jsp" target="right">司机信息管理</a>
              <a class="collapse-item" href="vehicle.jsp" target="right">车辆信息管理</a>
            </div>
          </div>
        </li>
        <li class="nav-item">
          <a
                  class="nav-link collapsed"
                  href="#"
                  data-toggle="collapse"
                  data-target="#goodsPages"
                  aria-expanded="true"
                  aria-controls="goodsPages"
          >
            <i class="fas fa-fw fa-folder"></i>
            <span>货物信息</span>
          </a>
          <div
                  id="goodsPages"
                  class="collapse"
                  aria-labelledby="headingPages"
                  data-parent="#accordionSidebar"
          >
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">货物信息：</h6>
              <a class="collapse-item" href="goods.jsp" target="right">货物信息管理</a>
            </div>
          </div>
        </li>
        <li class="nav-item">
          <a
                  class="nav-link collapsed"
                  href="#"
                  data-toggle="collapse"
                  data-target="#goodsProgressPages"
                  aria-expanded="true"
                  aria-controls="goodsProgressPages"
          >
            <i class="fas fa-fw fa-folder"></i>
            <span>货物运输</span>
          </a>
          <div
                  id="goodsProgressPages"
                  class="collapse"
                  aria-labelledby="headingPages"
                  data-parent="#accordionSidebar"
          >
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">货物运输：</h6>
              <a class="collapse-item" href="goodsStateProgress.jsp" target="right">货物运输</a>
              <a class="collapse-item" href="goodsStateArrive.jsp" target="right">货物送达</a>
              <a class="collapse-item" href="goodsStateOver.jsp" target="right">货物验收</a>
              <a class="collapse-item" href="goodsStateStop.jsp" target="right">货物中断</a>
            </div>
          </div>
        </li>
        <li class="nav-item">
          <a
            class="nav-link collapsed"
            href="#"
            data-toggle="collapse"
            data-target="#otherPages"
            aria-expanded="true"
            aria-controls="otherPages"
          >
            <i class="fas fa-fw fa-folder"></i>
            <span>其它页面</span>
          </a>
          <div
            id="otherPages"
            class="collapse"
            aria-labelledby="headingPages"
            data-parent="#accordionSidebar"
          >
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">其它页面：</h6>
              <a class="collapse-item" href="404.jsp">404 Page</a>
              <a class="collapse-item" href="500.jsp">500 Page</a>
              <a class="collapse-item" href="blank.jsp">Blank Page</a>
            </div>
          </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block" />

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
          <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>
      </ul>
      <!-- End of Sidebar -->

      <div id="content-wrapper" class="d-flex flex-column">
  <iframe src="start.jsp" width="100%" height="100%" name="right">
  </iframe>
	</div>
 </div>
 <!-- 跨域侧边栏end -->



      <!-- End of Content Wrapper -->

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

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>


  </body>
</html>
