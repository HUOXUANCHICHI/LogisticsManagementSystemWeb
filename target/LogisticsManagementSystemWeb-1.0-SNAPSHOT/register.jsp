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
    <meta name="author" content="Soldier_RMB"/>

    <title>物流信息管理系统-注册</title>

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

<body class="bg-gradient-primary">
<div class="container">
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">创建一个账户！</h1>
                        </div>
                        <form class="user" name="form" action="UserRegisterServlet" method="post" novalidate>
                            <div class="form-group">
                                <!-- <div class="col-sm-6 mb-3 mb-sm-0"> -->
                                <input
                                        type="text"
                                        class="form-control form-control-user"
                                        id="exampleFirstName"
                                        placeholder="登录名"
                                        name="username"
                                        required
                                />
                                <div class="invalid-feedback">登录名不能为空！</div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input
                                            type="password"
                                            class="form-control form-control-user"
                                            id="Password"
                                            placeholder="密码"
                                            pattern="[A-Za-z0-9]{5,30}"
                                            name="userPwd"
                                            required
                                    />
                                    <div class="invalid-feedback">密码长度至少为五位！</div>
                                </div>
                                <div class="col-sm-6">
                                    <input
                                            type="password"
                                            class="form-control form-control-user"
                                            id="RepeatPassword"
                                            placeholder="确认密码"
                                            required
                                    />
                                    <div class="invalid-feedback">
                                        请检查密码格式是否正确！
                                    </div>
                                </div>
                            </div>
                            <%--<div class="form-group">
                              <p style="display: inline-block">性别：</p>
                              <div
                                class="custom-control custom-radio small"
                                style="display: inline"
                              >
                                <input
                                  type="radio"
                                  class="custom-control-input"
                                  id="female"
                                  name="gender"
                                  value="female"
                                  style="margin-left: 50px"
                                />
                                <label class="custom-control-label" for="female">
                                  <p style="margin: 2px 5px 0px 0px">女</p>
                                </label>
                              </div>
                              <div
                                class="custom-control custom-radio small"
                                style="display: inline"
                              >
                                <input
                                  type="radio"
                                  class="custom-control-input"
                                  id="male"
                                  name="gender"
                                  value="male"
                                />
                                <label class="custom-control-label" for="male">
                                  <p style="margin-top: 2px">男</p>
                                </label>
                              </div>
                            </div>--%>
                            <%--<div class="form-group">
                              <div class="date" style="margin-top: -16px">
                                <input type="date" class="form-control" />
                              </div>
                            </div>
                            <div class="form-group">
                              <p style="display: inline-block">兴趣：</p>
                              <div
                                class="custom-control custom-checkbox small"
                                style="display: inline"
                              >
                                <input
                                  type="checkbox"
                                  class="custom-control-input"
                                  id="1"
                                />
                                <label class="custom-control-label" for="1"
                                  ><p style="margin: 1px 5px 0px 0px">马术</p></label
                                >
                              </div>
                              <div
                                class="custom-control custom-checkbox small"
                                style="display: inline"
                              >
                                <input
                                  type="checkbox"
                                  class="custom-control-input"
                                  id="2"
                                />
                                <label class="custom-control-label" for="2"
                                  ><p style="margin: 1px 5px 0px 0px">击剑</p></label
                                >
                              </div>
                              <div
                                class="custom-control custom-checkbox small"
                                style="display: inline"
                              >
                                <input
                                  type="checkbox"
                                  class="custom-control-input"
                                  id="3"
                                />
                                <label class="custom-control-label" for="3"
                                  ><p style="margin: 1px 5px 16px 0px">潜水</p></label
                                >
                              </div>
                              <div class="col-sm-14">
                                <select class="custom-select">
                                  <option value="painting">绘画</option>
                                  <option value="reading">阅读</option>
                                  <option value="playing">演奏</option>
                                </select>
                              </div><br />--%>
                            <div class="form-group row">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input
                                            type="text"
                                            class="form-control form-control-user"
                                            id="Phone"
                                            placeholder="电话"
                                            name="userContact"
                                            required
                                    />
                                    <div class="invalid-feedback">
                                        请输入正确的电话号码！
                                    </div>
                                </div>
                            </div>

                            <div class="col">
                                <div class="form-group row">
                                    <div class="col">
                                        <button class="btn btn-primary btn-user btn-block">
                                            注册
                                        </button>
                                        <br/>
                                        <button class="btn btn-primary btn-user btn-block" onclick="this.form.reset()">
                                            重置
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <hr/>
                        <div class="text-center">
                            <a class="small" href="forgotPassword.jsp">忘记密码？</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="login.jsp">已经注册？登录！</a>
                        </div>
                    </div>
                </div>
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

<script>
    //自定义提交
    $(function () {
        $("form").submit(function (event) {
            if ($(this)[0].checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
            }
            $(this).addClass("was-validated");
        });
    });

    //验证密码是否一致
    $(function () {
        var Password = $.trim($("#Password"));
        var RepetPassword = $.trim($("#RepetPassword"));
        if (Password != RepetPassword) {
            alert();
        }
    });
</script>
</body>
</html>
