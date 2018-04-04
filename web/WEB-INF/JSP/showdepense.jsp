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
    <c:set var="BaseUrl" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
    <head>
        <title>Show depense details </title>

        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" media="screen" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link href="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" rel="stylesheet"/>
        <link href="../../CSS/full.css" rel="stylesheet"/>
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
                    <a class="navbar-brand" href="/add-recette"><i class="fa fa-pie-chart" aria-hidden="true"></i>
                        ManagerApp</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->

                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <div id="page-content-wrapper">
            <div class="container-fluid ">
                <div class="row">
                    <div class="col-lg-12 text-center">


                        <h1> Show depense details </h1>
                        <c:if test="${not empty msg}">
                            <div class="alert alert-info alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert"
                                        aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                                <strong>${msg}</strong>
                            </div>
                        </c:if>


                        <div class="formWrapper" style="width:60%; margin: 2px auto; padding: 10px 40px">

                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead> </thead>
                                    <tbody>
                                        <tr> <th scope="row">Identifiant</th> <td>${depenseForm.id} </td>   </tr>
                                        <tr> <th scope="row">Type</th> <td>${depenseForm.type} </td>   </tr>
                                        <fmt:formatDate value="${depenseForm.dateEffective}" pattern="EEEE dd MMMM YYYY" var="date1"/>
                                        <tr> <th scope="row">Date effective </th> <td>${date1}</td>   </tr>
                                        <fmt:formatDate value="${depenseForm.dateSoumission}" pattern="EEEE dd MMMM YYYY hh:mm:ss" var="date2"/>
                                        <tr> <th scope="row">Date de soumission</th> <td>${date2}</td>  </tr>
                                        <tr> <th scope="row">Montant </th> <td>${depenseForm.montant}</td>  </tr>
                                        <tr> <th scope="row">Nom du rapporteur</th> <td>${depenseForm.rapporteur}</td>  </tr>
                                        <tr> <th scope="row">Nom de l'emetteur</th> <td>${depenseForm.emetteur}</td>  </tr>
                                        <tr> <th scope="row">Commentaire</th> <td>${depenseForm.commentaire}</td>  </tr>
                                    </tbody>
                                </table>
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
        <script src="../../JS/validator.min.js"></script>
        <script>
            $('#myForm').validator();
        </script>

    </body>
</html>

