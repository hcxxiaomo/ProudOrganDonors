<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="zh">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap Core CSS -->
    <link href="/WebProudOrganDonors/startbootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/WebProudOrganDonors/startbootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/WebProudOrganDonors/startbootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/WebProudOrganDonors/startbootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<title>Login</title>
	
</head>
<body>
  <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" id="loginForm" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="username" id="username" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="password" id="password" name="password" type="password" value="">
                                </div>
<!--                                 <div class="checkbox"> -->
<!--                                     <label> -->
<!--                                         <input name="remember" type="checkbox" value="Remember Me">Remember Me -->
<!--                                     </label> -->
<!--                                 </div> -->
                                <!-- Change this to a button or input when using this as a form -->
                                <button onclick="login()" class="btn btn-lg btn-success btn-block">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
    <!-- jQuery -->
    <script src="/WebProudOrganDonors/startbootstrap/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/WebProudOrganDonors/startbootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/WebProudOrganDonors/startbootstrap/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/WebProudOrganDonors/startbootstrap/dist/js/sb-admin-2.js"></script>
    
    <script type="text/javascript">
    function login(){
    	var me = '<%=session.getAttribute("me") %>';
        var base = '${base}';
                $.ajax({
                    url : base + "/login",
                    type: "POST",
                    data:$('#loginForm').serialize(),
                    error: function(request) {
                        alert("Connection error");
                    },
                    dataType:"json",
                    success: function(data) {
                        alert(data);
//                         if (data == true) {
//                             alert("登陆成功");
//                             location.reload();
//                         } else {
//                             alert("登陆失败,请检查账号密码")
//                         }
                    }
                });
                return false;
//             if (me != "null") {
//                 $("#login_div").hide();
//                 $("#userInfo").html("您的Id是" + me);
//                 $("#user_info_div").show();
//             } else {
//                 $("#login_div").show();
//                 $("#user_info_div").hide();
//             }
//         });
    }
    </script>
</html>
