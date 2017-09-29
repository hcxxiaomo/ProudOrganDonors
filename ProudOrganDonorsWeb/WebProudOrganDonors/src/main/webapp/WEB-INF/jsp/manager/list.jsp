<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="/WebProudOrganDonors/startbootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/WebProudOrganDonors/startbootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/WebProudOrganDonors/startbootstrap/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/WebProudOrganDonors/startbootstrap/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/WebProudOrganDonors/startbootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/WebProudOrganDonors/startbootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.dataTables.min.css"/>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">ProudOrganDonors</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">ProudOrganDonors</a>
            </div>
            <!-- /.navbar-header -->

            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                 <div class="panel panel-default">
                        <div class="panel-heading">
                            Visit <a href="https://www.codr.gov.hk/codr/CInternet.jsf" target="_blank"> CInternet.jsf </a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        ${obj.connectUrlCount }
                        </div>
                
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Email Register Data
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table style="width:100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Email</th>
                                        <th>Register Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                <c:forEach var="email" items="${obj.email }">
                                	 <tr >
                                        <td>${email.email }</td>
                                        <td><fmt:formatDate value="${email.createTime}" pattern="yyyy-MM-dd hh:mm:ss" type="date" dateStyle="long" /> </td>
<%--                                         <td>${email.createTime }</td> --%>
                                    </tr>
                                </c:forEach>
                                
                                  <!--   <tr class="gradeU">
                                        <td>Other browsers</td>
                                        <td>All others</td>
                                        <td>-</td>
                                        <td class="center">-</td>
                                        <td class="center">U</td>
                                    </tr> -->
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <!-- /.row -->
            <!-- /.row -->
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/WebProudOrganDonors/startbootstrap/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/WebProudOrganDonors/startbootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/WebProudOrganDonors/startbootstrap/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/WebProudOrganDonors/startbootstrap/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/WebProudOrganDonors/startbootstrap/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/WebProudOrganDonors/startbootstrap/vendor/datatables-responsive/dataTables.responsive.js"></script>
<script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"  charset="UTF-8"></script>
    <!-- Custom Theme JavaScript -->
    <script src="/WebProudOrganDonors/startbootstrap/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
            ,"order": []
        ,dom: 'Bfrtip',
        buttons: [ {
            extend: 'excelHtml5',
            text:'Export Email',
            filename:'Export_Email',
            customize: function( xlsx ) {
                var sheet = xlsx.xl.worksheets['sheet1.xml'];
//                    $('row c[r^="C"]', sheet).attr( 's', '2' );
            }
        } ]
        });
    });
    </script>

</body>
</html>