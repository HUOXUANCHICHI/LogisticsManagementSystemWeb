<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <meta name="author" content="${username}" />

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

<!-- Page Wrapper -->
<div id="wrapper">

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
    <c:if test="${role==0 || role==1 || role==2}">
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
    </c:if>
    <c:if test="${role==1}">
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
    </c:if>
    <c:if test="${role==1 || role==2}">
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
    </c:if>
    <c:if test="${role==0 || role==1 || role==2}">
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
    </c:if>
    <c:if test="${role==0 || role==1 || role==2}">
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
            <a class="collapse-item" href="goodsStateStock.jsp" target="right">货物库存</a>
            <a class="collapse-item" href="goodsStateProgress.jsp" target="right">货物运输</a>
            <a class="collapse-item" href="goodsStateArrive.jsp" target="right">货物送达</a>
            <a class="collapse-item" href="goodsStateOver.jsp" target="right">货物验收</a>
            <a class="collapse-item" href="goodsStateStop.jsp" target="right">货物中断</a>
          </div>
        </div>
      </li>
    </c:if>
    <c:if test="${role==1 || role==2}">
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
    </c:if>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block" />

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
  </ul>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav class="
              navbar navbar-expand navbar-light
              bg-white
              topbar
              mb-4
              static-top
              shadow
            ">
        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>

        <!-- Topbar Search -->
        <form class="
                d-none d-sm-inline-block
                form-inline
                mr-auto
                ml-md-3
                my-2 my-md-0
                mw-100
                navbar-search
              ">
          <div class="input-group">
            <input type="text" class="form-control bg-light border-0 small" placeholder="搜索..."
                   aria-label="Search" aria-describedby="basic-addon2"/>
            <div class="input-group-append">
              <button class="btn btn-primary" type="button">
                <i class="fas fa-search fa-sm"></i>
              </button>
            </div>
          </div>
        </form>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">
          <!-- Nav Item - Search Dropdown (Visible Only XS) -->
          <li class="nav-item dropdown no-arrow d-sm-none">
            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-search fa-fw"></i>
            </a>
            <!-- Dropdown - Messages -->
            <div class="
                    dropdown-menu dropdown-menu-right
                    p-3
                    shadow
                    animated--grow-in
                  " aria-labelledby="searchDropdown">
              <form class="form-inline mr-auto w-100 navbar-search">
                <div class="input-group">
                  <input type="text" class="form-control bg-light border-0 small"
                         placeholder="Search for..." aria-label="Search"
                         aria-describedby="basic-addon2"/>
                  <div class="input-group-append">
                    <button class="btn btn-primary" type="button">
                      <i class="fas fa-search fa-sm"></i>
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </li>

          <!-- Nav Item - Alerts -->
          <li class="nav-item dropdown no-arrow mx-1">
            <a
                    class="nav-link dropdown-toggle"
                    href="#"
                    id="alertsDropdown"
                    role="button"
                    data-toggle="dropdown"
                    aria-haspopup="true"
                    aria-expanded="false"
            >
              <i class="fas fa-bell fa-fw"></i>
              <!-- Counter - Alerts -->
              <span class="badge badge-danger badge-counter">3+</span>
            </a>
            <!-- Dropdown - Alerts -->
            <div
                    class="
                    dropdown-list dropdown-menu dropdown-menu-right
                    shadow
                    animated--grow-in
                  "
                    aria-labelledby="alertsDropdown"
            >
              <h6 class="dropdown-header">通知中心</h6>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="mr-3">
                  <div class="icon-circle bg-primary">
                    <i class="fas fa-file-alt text-white"></i>
                  </div>
                </div>
                <div>
                  <div class="small text-gray-500">2022年05月30日</div>
                  <span class="font-weight-bold"
                  >一个新的月度报告可供下载！</span
                  >
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="mr-3">
                  <div class="icon-circle bg-success">
                    <i class="fas fa-donate text-white"></i>
                  </div>
                </div>
                <div>
                  <div class="small text-gray-500">2022年05月30日</div>
                  1000￥已打入您的账户！
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="mr-3">
                  <div class="icon-circle bg-warning">
                    <i class="fas fa-exclamation-triangle text-white"></i>
                  </div>
                </div>
                <div>
                  <div class="small text-gray-500">2022年05月30日</div>
                  支出提醒：我们注意到您帐号的支出异常高。
                </div>
              </a>
              <a
                      class="dropdown-item text-center small text-gray-500"
                      href="#"
              >显示所有</a
              >
            </div>
          </li>

          <!-- Nav Item - Messages -->
          <li class="nav-item dropdown no-arrow mx-1">
            <a
                    class="nav-link dropdown-toggle"
                    href="#"
                    id="messagesDropdown"
                    role="button"
                    data-toggle="dropdown"
                    aria-haspopup="true"
                    aria-expanded="false"
            >
              <i class="fas fa-envelope fa-fw"></i>
              <!-- Counter - Messages -->
              <span class="badge badge-danger badge-counter">7</span>
            </a>
            <!-- Dropdown - Messages -->
            <div
                    class="
                    dropdown-list dropdown-menu dropdown-menu-right
                    shadow
                    animated--grow-in
                  "
                    aria-labelledby="messagesDropdown"
            >
              <h6 class="dropdown-header">消息中心</h6>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img
                          class="rounded-circle"
                          src="img/undraw_profile_1.svg"
                          alt="..."
                  />
                  <div class="status-indicator bg-success"></div>
                </div>
                <div class="font-weight-bold">
                  <div class="text-truncate">
                    您好！希望您可以解决我的问题！
                  </div>
                  <div class="small text-gray-500">Emily Fowler · 58m</div>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img
                          class="rounded-circle"
                          src="img/undraw_profile_2.svg"
                          alt="..."
                  />
                  <div class="status-indicator"></div>
                </div>
                <div>
                  <div class="text-truncate">
                    我这里有上个月支出的照片，需要我发给您吗？
                  </div>
                  <div class="small text-gray-500">Jae Chun · 1d</div>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img
                          class="rounded-circle"
                          src="img/undraw_profile_3.svg"
                          alt="..."
                  />
                  <div class="status-indicator bg-warning"></div>
                </div>
                <div>
                  <div class="text-truncate">
                    上个月报告看起来很不错！
                  </div>
                  <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                </div>
              </a>
              <a
                      class="dropdown-item text-center small text-gray-500"
                      href="#"
              >显示所有</a
              >
            </div>
          </li>

          <div class="topbar-divider d-none d-sm-block"></div>

          <!-- Nav Item - User Information -->
          <li class="nav-item dropdown no-arrow">
            <a
                    class="nav-link dropdown-toggle"
                    href="#"
                    id="userDropdown"
                    role="button"
                    data-toggle="dropdown"
                    aria-haspopup="true"
                    aria-expanded="false"
            >
                  <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                    ${username}
                  </span>
              <img
                      class="img-profile rounded-circle"
                      src="img/undraw_profile.svg"
              />
            </a>
            <!-- Dropdown - User Information -->
            <div
                    class="
                    dropdown-menu dropdown-menu-right
                    shadow
                    animated--grow-in
                  "
                    aria-labelledby="userDropdown"
            >
              <a class="dropdown-item" href="#">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                个人信息
              </a>
              <a class="dropdown-item" href="#">
                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                设置
              </a>
              <a class="dropdown-item" href="#">
                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                活动日志
              </a>
              <div class="dropdown-divider"></div>
              <a
                      class="dropdown-item"
                      href="#"
                      data-toggle="modal"
                      data-target="#logoutModal"
              >
                <i
                        class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"
                ></i>
                登出
              </a>
            </div>
          </li>
        </ul>
      </nav>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="embed-responsive embed-responsive-16by9">
        <iframe class="embed-responsive-item" src="start.jsp" allowfullscreen  name="right"></iframe>
      </div>
    </div>
    <!-- End of Main Content -->

    <!-- Footer -->
    <footer class="sticky-footer bg-white">
      <div class="container my-auto">
        <div class="copyright text-center my-auto">
          <span>Copyright &copy; ablaze 2022</span>
        </div>
      </div>
    </footer>
    <!-- End of Footer -->

  </div>
  <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div
        class="modal fade"
        id="logoutModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
>
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">确定离开吗？</h5>
        <button
                class="close"
                type="button"
                data-dismiss="modal"
                aria-label="Close"
        >
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">
        选择登出会退出当前账号。
      </div>
      <div class="modal-footer">
        <button
                class="btn btn-secondary"
                type="button"
                data-dismiss="modal"
        >
          取消
        </button>
        <a class="btn btn-primary" href="login.jsp">登出</a>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

</body>

</html>
