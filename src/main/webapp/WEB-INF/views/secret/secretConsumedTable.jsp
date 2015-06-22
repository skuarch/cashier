<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="cons" class="model.logic.Constants" />
<c:choose>
    <c:when test="${fn:length(cashierSecretConsumeds) <= 0}">
        <div class="alert alert-warning">
            <spring:message code="text226"/>
        </div>
    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                                <th>
                                    <spring:message code="text350" />
                                </th>
                                <th>
                                    <spring:message code="text351" />
                                </th>                                
                                <th>
                                    <spring:message code="text356" />
                                </th>                                
                            </tr>
                        </thead>
                        <tbody>  
                            <c:forEach var="c" items="${cashierSecretConsumeds}">
                                <tr>
                                    <td>                                        
                                        ${c.getId()}                                        
                                    </td>
                                    <td>
                                        ${c.getAmount()}
                                    </td>                                    
                                    <td>
                                        ${c.getConsumedDate()}
                                    </td>        
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>

<div class="modal fade" id="DetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">                    
                    <spring:message code="text357" />
                </h4>
            </div>
            <div class="modal-body" id="outputDetail">
                <ul class="list-group">
                    <li class="list-group-item"><spring:message code="text78" />: <strong><span id="addressSpan"></span></strong></li>
                    <li class="list-group-item"><spring:message code="text82" />: <strong><span id="countrySpan"></span></strong></li>
                    <li class="list-group-item"><spring:message code="text121" />: <strong><span id="stateSpan"></span></strong></li>
                    <li class="list-group-item"><spring:message code="text84" />: <strong><span id="citySpan"></span></strong></li>
                    <li class="list-group-item"><spring:message code="text80" />: <strong><span id="zipCodeSpan"></span></strong></li>
                    <li class="list-group-item"><spring:message code="text86" />: <strong><span id="genderSpan"></span></strong></li>
                    <li class="list-group-item"><spring:message code="text359" />: <strong><span id="lastLoginSpan"></span></strong></li>
                </ul>
                
            </div>
            <div class="modal-footer">                
                <button type="button" class="btn btn-primary" data-dismiss="modal">                    
                    <spring:message code="text248" />
                </button>
            </div>
        </div>
    </div>                
</div>

<script type="text/javascript">eval("${js}");</script>        
