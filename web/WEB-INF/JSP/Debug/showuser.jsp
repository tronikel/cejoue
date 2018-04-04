<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType=" text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="full" lang="fr" xmlns:c="http://www.w3.org/1999/XSL/Transform">
    <head>
        <title>Show user details </title>


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
                    <a class="navbar-brand" href="/Debug/"><i class="fa fa-pie-chart" aria-hidden="true"></i>
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


                        <h1> Show user details </h1>
                        <c:if test="${not empty msg}">
                            <div class="alert alert-${css} alert-dismissible" role="alert">
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
                                        <tr> <th scope="row">Nom</th> <td>${userForm.nom} </td>   </tr>
                                        <tr> <th scope="row">Prenom</th> <td>${userForm.prenom}</td>   </tr>
                                        <tr> <th scope="row">Pseudo</th> <td>${userForm.username}</td>  </tr>
                                        <tr> <th scope="row">Email</th> <td>${userForm.email}</td>  </tr>
                                        <tr> <th scope="row">Mot de passe</th> <td>${userForm.password}</td>  </tr>
                                        <tr> <th scope="row">Confirmation du Mot de passe</th> <td>${userForm.matchingPassword}</td>  </tr>
                                        <tr> <th scope="row">Date de creation</th> <td>${userForm.creationDate}</td>  </tr>
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
        <script src="../../../JS/validator.min.js"></script>
        <script>
            $('#myForm').validator();
        </script>

    </body>
</html>

