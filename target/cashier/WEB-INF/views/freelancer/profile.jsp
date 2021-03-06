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
                <br/>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <spring:message code="text73" />
                            </div>
                            <div class="panel-body">
                                <div id="message" class="alert alert-warning">
                                    <spring:message code="text100" />
                                </div> 
                                <div id="message" class="alert alert-danger display-none"></div> 
                                <form action="updateProfile.html" role="form" method="post" id="profileFreelancerForm" name="profileFreelancerForm">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text90" /></label>
                                                <input name="email" id="email" value="${personBasicInformation.email}" placeholder="<spring:message code="text91" />" maxlength="50" class="form-control" type="email" required="required" tabindex="1" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text74" /></label>
                                                <input name="name" id="name" value="${personBasicInformation.name}" placeholder="<spring:message code="text75" />" maxlength="60" class="form-control" type="text" required="required" tabindex="2"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text76" /></label>
                                                <input name="lastName" id="lastName" value="${personBasicInformation.lastName}" placeholder="<spring:message code="text77"/>" maxlength="60" class="form-control" type="text" required="required" tabindex="3"/>
                                            </div> 
                                        </div>                                                                                                                        
                                        <div class="col-lg-6">
                                            <div class="form-group">                                                 
                                                <label><spring:message code="text86" /></label>
                                                <select id="gender" name="gender" class="form-control" tabindex="11">                                                                                                        
                                                    <option value="1" ${personBasicInformation.gender == "1" ? "selected='selected'": ""}><spring:message code="text97" /></option>
                                                    <option value="2" ${personBasicInformation.gender == "2" ? "selected='selected'": ""}><spring:message code="text98" /></option>
                                                </select>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text88" /></label>
                                                <input name="phone" id="phone" value="${personBasicInformation.phone}" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="12" />
                                            </div> 
                                        </div>                                                                                                            
                                        <div class="col-lg-12">
                                            <button id="saveButton" class="btn btn-block btn-lg btn-success">
                                                <spring:message code="text143"/>
                                            </button>
                                        </div>
                                    </div>
                                </form>                            
                            </div>
                        </div>
                    </div>
                </div>            
            </div>   
        </div><!-- /#wrapper -->        
        <script src="scriptI18N.html" type="text/javascript"></script>
        <jsp:include page="../application/scripts.jsp"/>
        <script type="text/javascript">eval("${js}");</script>        
    </body>
</html>