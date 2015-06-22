<%-- 
    Document   : index
    Created on : Oct 19, 2014, 6:12:09 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../application/noCache.jsp"/>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="../application/head.jsp"/>        
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <jsp:include page="../application/topmenu.jsp" />
                <jsp:include page="../application/sidemenu.jsp" />
            </nav>
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <spring:message code="text366"/>
                        </h1>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Consumir clave
                            </div>
                            <div class="panel-body">

                                <form action="" name="cashierChargeKeyForm" id="cashierChargeKeyForm" method="post">

                                    <div class="col-lg-12">
                                        <div class="form-group"> 
                                            <label for="secret">Clave:</label>
                                            <input id="secret" name="secret" value="" maxlength="8" required title="la clave debe de ser de 8 caracters alfanumericos" placeholder="clave a cobrar" aria-required="true" aria-describedby="secret-format" style="text-transform:uppercase;" class="form-control">                                                        
                                        </div> 
                                    </div>

                                    <div class="col-lg-12">
                                        <div class="form-group"> 
                                            <label for="amount">Monto:</label>
                                            <input id="amount" name="amount" type="number" max="10000" required title="el monto no puede ser mayor a $10000" aria-required="true" aria-describedby="amount-format" class="form-control">                            
                                            <span id="amount-format" style="display: none">Format: solo numeros son aceptados</span>                                                                                   
                                        </div> 
                                    </div>
                                    <div class="col-lg-12">
                                        <input class="btn btn-success btn-block btn-lg" type="submit" id="submitForm" name="submitForm" value="cobrar clave" maxlength="8"/>
                                        <br/>
                                        <div id="message" class="alert alert-info display-none"></div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div><!-- /#page-wrapper -->            
                <script src="scriptI18N.html" type="text/javascript"></script>
                <jsp:include page="../application/scripts.jsp"/>
                </body>
                </html>