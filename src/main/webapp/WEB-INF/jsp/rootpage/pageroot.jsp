<%-- 
    Document   : pageroot
    Created on : Oct 22, 2017, 8:52:59 AM
    Author     : java-spring
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<spring:url var="css"value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="image" value="/resources/img"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC - ${title}</title>
        <!--CSS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' 
              rel='stylesheet' type='text/css' />
        <link rel="stylesheet" href="${css}/bootstrap.min.css"/>
        <link rel="stylesheet" href="${css}/bootstrap.css"/>
        <link rel="stylesheet" href="${css}/custom.css"/>
        <link rel="stylesheet" href="${css}/font-awesome.css"/>
        <link rel="stylesheet" href="${css}/bootstrapValidator.min.css"/>
        <link rel="stylesheet" href="${css}/morris-0.4.3.min.css"/>
         <link href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/3.2.2/sweetalert2.css" rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/3.2.2/sweetalert2.min.css" rel="stylesheet"/>
    </head>

    <div id="wrapper">

        <!--NAVIGATION BAR HEADER-->
        <%@include file="../shared/navbar.jsp" %>
        <!--NAVIGATION BAR HEADER-->

        <!--NAVIGATION SIDEBAR ACCORDION MENU-->
        <%@include file="../shared/accordion.jsp" %>
        <!--NAVIGATION SIDEBAR ACCORDION MENU-->        
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">

                        <!--PAGES KATEGORI-->
                        <c:if test="${eventClickKategori == true}">
                            <%@include file="../views/kategori.jsp"%>
                        </c:if>
                        <!--PAGES KATEGORI-->

                        <!--PAGES MOBIL-->
                        <c:if test="${eventClickMobil == true}">
                            <%@include file="../views/mobil.jsp" %>
                        </c:if>
                        <!--PAGES MOBIL-->
                        
                        <!--PAGES HOME-->
                        <c:if test="${eventClickHome == true}">
                            <%@include file="../views/home.jsp" %>
                        </c:if>
                        <!--PAGES HOME-->
                    </div>
                </div>
            </div>
        </div>

    </div>
    <body>
        <!--JS-->

        <script src="${js}/jQuery.js"></script>
        <script src="${js}/jquery.dataTables.js"></script>
        <script src="${js}/jquery.dataTables.min.js"></script>
        <script src="${js}/jquery.metisMenu.js"></script>
        <script src="${js}/dataTables.bootstrap.js"></script>
        <script src="${js}/dataTables.bootstrap.min.js"></script>
        <script src="${js}/raphael-2.1.0.min.js"></script>
        <script src="${js}/bootstrap.js"></script>
        <script src="${js}/app/myapp.js"></script>
        <script src="${js}/custom.js"></script>
        <script src="${js}/bootstrapvalidator.min.js"></script>
        <script src="${js}/bootstrap.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/3.2.2/sweetalert2.min.js"></script>
    </body>
</html>
