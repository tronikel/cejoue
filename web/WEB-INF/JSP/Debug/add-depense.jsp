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
        <title>Ajouter une dépense</title>

        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/Debug/" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" media="screen" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link href="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" rel="stylesheet"/>
        <link href="../../../CSS/full.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css" />
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
        <script src="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>
        <script src="../../../JS/validator.min.js"></script>
    </head>
    <body>
        <!-- Navigation -->
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
                            <a href="#" class="list-group-item"><i class="fa fa-info-circle" aria-hidden="true"></i> Mes info</a>
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
                            <a data-target="#m-DPlantation" data-toggle="tab" class="list-group-item active"><i class="fa fa-tree" aria-hidden="true"></i> Plantation</a>
                            <a data-target="#m-DMaison" data-toggle="tab" class="list-group-item"><i class="fa fa-home" aria-hidden="true"></i> Maison</a>
                            <a data-target="#m-DAutres" data-toggle="tab" class="list-group-item">Autres</a>

                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="/Debug/show60DepenseAndRecettes"><i class="fa fa-hourglass-half" aria-hidden="true"></i> Historique</a>
                            </h4>
                        </div>
                        <div id="collapseFour" class="panel-collapse collapse  panel-body list-group" style="padding:0px 15px !important;">

                        </div>
                    </div>
                </div>
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <div class="container-fluid formWrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class ="m-title1"><i class="fa fa-sign-out" aria-hidden="true"></i>Depense</h1>


                            <!-- Nav tabs -->

                            <ul class="nav nav-tabs" id="myTab">

                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane active" id="m-DPlantation">
                                    <h2 class ="m-title2"><i class="fa fa-tree" aria-hidden="true"></i>Plantation</h2>
                                    <div class="formWrapper" style="width:60%; margin: 2px auto; padding: 10px 40px">

                                        <spring:url value="/Debug/sendDepenseP" var="userActionUrlP" />

                                        <form:form id ="myFormPlantation" class=" myForm form-horizontal myForm" method="post"
                                                   modelAttribute="depensePForm" action="${userActionUrlP}" data-toggle="validator" role="form">

                                            <spring:bind path="type">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Type de recette</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                                        <form:input path="type" type="text" class="form-control"
                                                                    id="type" readonly="true" placeholder=""/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="rapporteur">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Rapportée par</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                                        <form:input path="rapporteur" type="text" class="form-control" maxlength="15"  pattern="^[_A-z0-9]{2,}$"  required="true" data-error="Nom du rapporteur incorrect!"
                                                                    id="rapporteur" readonly="true" placeholder="rapporteur"/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>


                                            <spring:bind path="montant">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Montant de la dépense</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon">FCFA </span>
                                                        <form:input path="montant" type="number" class="form-control"   required="true" data-error="Montant incorrect!"
                                                                    id="montant" placeholder="0"/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>



                                            <spring:bind path="dateEffective">
                                                <div class="form-group has-feedback" >
                                                    <label class="control-label">Date d'émission</label>
                                                    <div class="col-sm-12 input-group date" data-provide="datepicker" id='datetimepicker2'>
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>

                                                        <form:input path="dateEffective"  type="date" class="form-control" pattern="^[_0-9]{4}/[_0-9]{2}/[_0-9]{2}$"    data-error="Date d'émission incorrecte!"
                                                                    id="dateEffective"  />
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                    <script type="text/javascript">
                                                        $(function () {
                                                        $('#datetimepicker2').datetimepicker({
                                                        locale:'fr',
                                                        defaultDate: new Date(),
                                                        format: 'YYYY/MM/DD',
                                                        allowInputToggle:true
                                                        });
                                                        });
                                                    </script>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="emetteur">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Dépense émise par</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                                        <form:input path="emetteur" type="text" class="form-control" maxlength="15"  pattern="^[_A-z0-9]{2,}$"  required="true" data-error="Nom du rapporteur incorrect!"
                                                                    id="emetteur" readonly="true" placeholder="emetteur"/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="commentaire">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Commentaire</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-comments-o" aria-hidden="true"></i></span>

                                                        <form:textarea path="commentaire"  class="form-control" maxlength="300"  required="true" data-error="Commentaire incorrect!" rows="5"   id="commentaire" placeholder="commentaire" />

                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>

                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">

                                                    <button id="Psubmit" type="submit" class="btn-lg btn-primary pull-right">Envoyer
                                                    </button>

                                                </div>
                                            </div>
                                        </form:form>
                                    </div>



                                </div>
                                <div class="tab-pane" id="m-DMaison">
                                    <h2 class ="m-title2"><i class="fa fa-home" aria-hidden="true"></i>Maison</h2>
                                    <div class="formWrapper" style="width:60%; margin: 2px auto; padding: 10px 40px">

                                        <spring:url value="/Debug/sendDepenseM" var="userActionUrlM" />

                                        <form:form id ="myFormPlantation" class=" myForm form-horizontal myForm" method="post"
                                                   modelAttribute="depenseMForm" action="${userActionUrlM}" data-toggle="validator" role="form">

                                            <spring:bind path="type">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Type de recette</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                                        <form:input path="type" type="text" class="form-control"
                                                                    id="Mtype" readonly="true" placeholder=""/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="rapporteur">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Rapportée par</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                                        <form:input path="rapporteur" type="text" class="form-control" maxlength="15"  pattern="^[_A-z0-9]{2,}$"  required="true" data-error="Nom du rapporteur incorrect!"
                                                                    id="Mrapporteur" readonly="true" placeholder="rapporteur"/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>


                                            <spring:bind path="montant">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Montant de la dépense</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon">FCFA </span>
                                                        <form:input path="montant" type="number" class="form-control"   required="true" data-error="Montant incorrect!"
                                                                    id="Mmontant" placeholder="0"/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>



                                            <spring:bind path="dateEffective">
                                                <div class="form-group has-feedback" >
                                                    <label class="control-label">Date d'émission</label>
                                                    <div class="col-sm-12 input-group date" data-provide="datepicker" id='datetimepicker4'>
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>

                                                        <form:input path="dateEffective"  type="date" class="form-control" pattern="^[_0-9]{4}/[_0-9]{2}/[_0-9]{2}$"    data-error="Date d'émission incorrecte!"
                                                                    id="MdateEffective"  />
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                    <script type="text/javascript">
                                                        $(function () {
                                                        $('#datetimepicker4').datetimepicker({
                                                        locale:'fr',
                                                        defaultDate: new Date(),
                                                        format: 'YYYY/MM/DD',
                                                        allowInputToggle:true
                                                        });
                                                        });
                                                    </script>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="emetteur">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Dépense émise par</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                                        <form:input path="emetteur" type="text" class="form-control" maxlength="15"  pattern="^[_A-z0-9]{2,}$"  required="true" data-error="Nom du rapporteur incorrect!"
                                                                    id="Memetteur" readonly="true" placeholder="rapporteur"/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="commentaire">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Commentaire</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-comments-o" aria-hidden="true"></i></span>

                                                        <form:textarea path="commentaire"  class="form-control" maxlength="300"  required="true" data-error="Commentaire incorrect!" rows="5"   id="Mcommentaire" placeholder="Ajoutez un commentaire" />

                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>

                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">

                                                    <button id="Msubmit" type="submit" class="btn-lg btn-primary pull-right">Envoyer
                                                    </button>

                                                </div>
                                            </div>
                                        </form:form>
                                    </div>

                                </div>
                                <div class="tab-pane" id="m-DAutres">
                                    <h2 class ="m-title2">Autres</h2>
                                    <div class="formWrapper" style="width:60%; margin: 2px auto; padding: 10px 40px">

                                        <spring:url value="/Debug/sendDepenseA" var="userActionUrlA" />

                                        <form:form id ="myFormAutres" class=" myForm form-horizontal myForm" method="post"
                                                   modelAttribute="depenseAForm" action="${userActionUrlA}" data-toggle="validator" role="form">



                                            <spring:bind path="type">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Type de recette</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                                        <form:input path="type" type="text" class="form-control"
                                                                    id="Atype" readonly="true" placeholder=""/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="rapporteur">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Rapportée par</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                                        <form:input path="rapporteur" type="text" class="form-control" maxlength="15"  pattern="^[_A-z0-9]{2,}$"  required="true" data-error="Nom du rapporteur incorrect!"
                                                                    id="Arapporteur" readonly="true" placeholder="rapporteur"/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>


                                            <spring:bind path="montant">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Montant de la dépense</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon">FCFA </span>
                                                        <form:input path="montant" type="number" class="form-control"   required="true" data-error="Montant incorrect!"
                                                                    id="Amontant" placeholder="0"/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>



                                            <spring:bind path="dateEffective">
                                                <div class="form-group has-feedback" >
                                                    <label class="control-label">Date d'émission</label>
                                                    <div class="col-sm-12 input-group date" data-provide="datepicker" id='datetimepicker6'>
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>

                                                        <form:input path="dateEffective"  type="date" class="form-control" pattern="^[_0-9]{4}/[_0-9]{2}/[_0-9]{2}$"    data-error="Date d'émission incorrecte!"
                                                                    id="AdateEffective"  />
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                    <script type="text/javascript">
                                                        $(function () {
                                                        $('#datetimepicker6').datetimepicker({
                                                        locale:'fr',
                                                        format: 'YYYY/MM/DD',
                                                        defaultDate: new Date(),

                                                        });
                                                        });
                                                    </script>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="emetteur">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Dépense émise par</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                                        <form:input path="emetteur" type="text" class="form-control" maxlength="15"  pattern="^[_A-z0-9]{2,}$"  required="true" data-error="Nom du rapporteur incorrect!"
                                                                    id="Aemetteur" readonly="true" placeholder="rapporteur"/>
                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="commentaire">
                                                <div class="form-group has-feedback">
                                                    <label class="control-label">Commentaire</label>
                                                    <div class="col-sm-12 input-group">
                                                        <span class="input-group-addon"><i class="fa fa-comments-o" aria-hidden="true"></i></span>

                                                        <form:textarea path="commentaire"  class="form-control" maxlength="300"  required="true" data-error="Commentaire incorrect!" rows="5"   id="Acommentaire" placeholder="Ajoutez un commentaire" />

                                                    </div>
                                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </spring:bind>

                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">

                                                    <button id="Asubmit" type="submit" class="btn-lg btn-primary pull-right">Envoyer
                                                    </button>

                                                </div>
                                            </div>
                                        </form:form>
                                    </div>






                                </div>
                            </div>



                        </div>
                    </div>
                </div>
            </div>
            <!-- /#page-content-wrapper -->

        </div>
        <script>
            $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
            });
            $("#collapseTree a").click(function(e) {
            console.log("OK");
            $("#collapseTree a").removeClass("active");
            $(e.target).addClass("active");
            });
            var url = document.location.toString();
            if (url.match('#')) {
            $('.nav-tabs a[href="#'+url.split('#')[1]+'"]').tab('show') ;
            console.log(url.split('#')[1]);
            }

            // With HTML5 history API, we can easily prevent scrolling!
            $('.nav-tabs a').on('shown.bs.tab', function (e) {
            if(history.pushState) {
            history.pushState(null, null, e.target.hash);
            } else {
            window.location.hash = e.target.hash; //Polyfill for old browsers
            }
            })
        </script>

        <script>
            $('#myForm').validator();
        </script>

    </body>
</html>

