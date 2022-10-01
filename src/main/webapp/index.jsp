<%@ page import="homework.webapp.beans.Manufacturer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Производитель ноутбуков</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<script src="js/bootstrap.bundle.min.js"></script>
<main>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-7 bg-light">
                <nav>
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <button class="nav-link active" id="nav-common-tab" data-bs-toggle="tab"
                                data-bs-target="#nav-common"
                                type="button" role="tab" aria-controls="nav-common" aria-selected="true">Общая
                            информация
                        </button>
                        <button class="nav-link" id="nav-history-tab" data-bs-toggle="tab" data-bs-target="#nav-history"
                                type="button" role="tab" aria-controls="nav-history" aria-selected="false">История
                            развития производителя
                        </button>
                        <button class="nav-link" id="nav-news-tab" data-bs-toggle="tab" data-bs-target="#nav-news"
                                type="button" role="tab" aria-controls="nav-news" aria-selected="false">Новости
                        </button>
                        <button class="nav-link" id="nav-models-tab" data-bs-toggle="tab"
                                data-bs-target="#nav-models"
                                type="button" role="tab" aria-controls="nav-models" aria-selected="false">Модели
                            ноутбуков
                        </button>
                    </div>
                </nav>
                <div class="tab-content m-3" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-common" role="tabpanel"
                         aria-labelledby="nav-common-tab"
                         tabindex="0">
                        <p>Производитель: <c:out value="${manufacturer.name}"/></p>
                        <p>Страна штаб-квартиры производиетля: <c:out value="${manufacturer.countryName}"/></p>
                        <p>Логотип: <img class="logo" src="<c:url value="${manufacturer.logo}"/>" alt="logo"></p>
                        <p>Количество сотрудников: <c:out value="${manufacturer.employeesNumber}"/></p>
                        <p>Краткая информация о производителе: <c:out value="${manufacturer.briefInformation}"/></p>
                    </div>
                    <div class="tab-pane fade" id="nav-history" role="tabpanel" aria-labelledby="nav-history-tab"
                         tabindex="0">
                        <c:forEach var="contentElement" items="${histories}">
                            <c:if test="${contentElement.type == 'isP'}">
                                <p>${contentElement.content}</p>
                            </c:if>
                            <c:if test="${contentElement.type == 'isLink'}">
                                <div><a href="https://${contentElement.content}">${contentElement.content}</a></div>
                            </c:if>
                            <c:if test="${contentElement.type == 'isImg'}">
                                <div class="text-lg-center mb-3 mt-3"><img src="${contentElement.content}"
                                                                           alt="" class="img-fluid"></div>
                            </c:if>
                            <c:if test="${contentElement.type == 'isSpan'}">
                                <span>${contentElement.content}</span>
                            </c:if>
                        </c:forEach>
                    </div>
                    <div class="tab-pane fade" id="nav-news" role="tabpanel" aria-labelledby="nav-news-tab"
                         tabindex="0">
                        <c:forEach var="contentElement" items="${newsHeaders}">
                            <a href="NewsServlet?selectId=${contentElement.id}" class="btn btn-light">
                                <div class="row">
                                    <div class="col-9 d-flex align-items-center">
                                        <p><c:out value="${contentElement.content}"/></p></div>
                                    <div class="col-3">
                                        <img class="img-thumbnail" src="${contentElement.pic}"
                                             alt="">
                                    </div>
                                </div>
                            </a>
                            <hr>
                        </c:forEach>
                    </div>
                    <div class="tab-pane fade" id="nav-models" role="tabpanel" aria-labelledby="nav-models-tab"
                         tabindex="0">
                        Не реализовано
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
