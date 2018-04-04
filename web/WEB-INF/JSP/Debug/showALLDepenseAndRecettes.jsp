<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType=" text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html class="full" lang="fr" xmlns:c="http://www.w3.org/1999/XSL/Transform">
    <c:set var="req" value="${pageContext.request}" />
    <c:set var="url">${req.requestURL}</c:set>
    <c:set var="uri" value="${req.requestURI}" />
    <c:set var="BaseUrl" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/Debug/" />
    <head>
        <title>Les 60 dernières dépenses et recettes </title>

        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/Debug/" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" media="screen" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link href="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" rel="stylesheet"/>
        <link href="../../../CSS/full.css" rel="stylesheet"/>
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->


    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a href="#menu-toggle" style="position: absolute; right : 10px; top: 7px" class="btn btn-default" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i>

                        Menu</a>

                    <a class="navbar-brand" href="/Debug/"><i class="fa fa-pie-chart" aria-hidden="true"></i>
                        ManagerApp</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->

                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <div id="sidebar-wrapper">
                <div class="panel-group sidebar-nav" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><i class="fa fa-user" aria-hidden="true"></i> Mon Compte</a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse  panel-body list-group" style="padding:0px 15px !important;">
                            <a href="#" class="list-group-item "><i class="fa fa-info-circle" aria-hidden="true"></i> Mes info</a>
                            <a href="#" class="list-group-item"><i class="fa fa-key" aria-hidden="true"></i> Changer mot de passe </a>
                            <a href="#" class="list-group-item"><i class="fa fa-ban" aria-hidden="true"></i> Deconnection</a>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"><i class="fa fa-sign-out"  style="color:green"aria-hidden="true"></i> Recette</a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse in  panel-body list-group" style="padding:0px 15px !important;">
                            <a href="/Debug/add-recette#m-RCoupe"  class="list-group-item" ><i class="fa fa-scissors" aria-hidden="true"></i> Coupe</a>
                            <a href="/Debug/add-recette#m-RLoyer"  class="list-group-item"><i class="fa fa-bed" aria-hidden="true"></i> Loyer</a>
                            <a href="/Debug/add-recette#m-RAutres" class="list-group-item">Autres</a>

                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTree"><i class="fa fa-sign-in"  style="color:red"aria-hidden="true"></i> Depense</a>
                            </h4>
                        </div>
                        <div id="collapseTree" class="panel-collapse collapse in panel-body list-group" style="padding:0px 15px !important;">
                            <a href="/Debug/add-depense#m-DPlantation"  class="list-group-item"><i class="fa fa-tree" aria-hidden="true"></i> Plantation</a>
                            <a href="/Debug/add-depense#m-DMaison" class="list-group-item"><i class="fa fa-home" aria-hidden="true"></i> Maison</a>
                            <a href="/Debug/add-depense#m-DAutres" class="list-group-item">Autres</a>

                        </div>
                    </div>
                    <div class="panel panel-default ">
                        <div class="panel-heading ">
                            <h4 class="panel-title ">
                                <a class="" data-toggle="collapse" data-parent="#accordion" href="#"><i class="fa fa-hourglass-half" aria-hidden="true"></i> Historique</a>
                            </h4>
                        </div>
                        <div id="collapseFour" class="panel-collapse collapse  panel-body list-group" style="padding:0px 15px !important;">

                        </div>
                    </div>
                </div>
            </div>

            <div id="page-content-wrapper">
                <div class="container-fluid m-main">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h1> Les 60 dernières dépenses et recettes </h1>
                            <c:if test="${not empty msg}">
                                <div class="alert alert-info alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert"
                                            aria-label="Close">
                                        <span aria-hidden="true">×</span>
                                    </button>
                                    <strong>${msg}</strong>
                                </div>
                            </c:if>


                            <div class="formWrapper" style="width:90%; margin: 2px auto; padding: 20px 20px">

                                <div class="table-responsive">
                                    <table id="m-itemlist" class="table table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>Identifiant</th>
                                                <th>Type</th>
                                                <th>Montant</th>
                                                <th>Date Effective</th>
                                                <th>Date de la Soumission</th>
                                                <th>Nom du rapporteur</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <c:forEach var="item" items="${recetteAndDepenseList}">
                                            <tr class="${item.type}">
                                                <td>${item.id}</td>
                                                <td>${item.type}</td>
                                                <td>${item.montant}</td>
                                                <fmt:formatDate value="${item.dateEffective}" pattern="dd MMMM YYYY" var="date1"/>
                                                <td>${date1}</td>
                                                <fmt:formatDate value="${item.dateSoumission}" pattern="dd MMMM YYYY" var="date2"/>
                                                <td>${date2}</td>
                                                <td>${item.rapporteur}</td>
                                                <td>

                                                    <spring:url value="#" var="itemUrl" />
                                                    <spring:url value="#" var="deleteUrl" />
                                                    <spring:url value="#" var="updateUrl" />

                                                    <button class="btn btn-info"
                                                            onclick="location.href='${itemUrl}'">Query</button>
                                                    <button class="btn btn-primary"
                                                            onclick="location.href='${updateUrl}'">Update</button>
                                                    <button class="btn btn-danger"
                                                            onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                                                </td>
                                            </tr>
                                        </c:forEach>


                                    </table>
                                </div>


                            </div>
                        </div>



                    </div>

                </div>
            </div>

        </div>


        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
        <script src="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>
        <script src="../../../JS/validator.min.js"></script>
        <script>
            $('#myForm').validator();
        </script>

    </body>
</html>

