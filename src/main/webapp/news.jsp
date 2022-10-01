<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>News</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<main>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-7 bg-light p-3">
                <h4><c:out value="${newsHeader.content}"/></h4>
                <div>
                    <c:forEach var="contentElement" items="${newsContents}">
                        <c:if test="${contentElement.contentType == 'isP'}">
                            <p>${contentElement.content}</p>
                        </c:if>
                        <c:if test="${contentElement.contentType == 'isLink'}">
                            <div><a href="${contentElement.content}">${contentElement.content}</a></div>
                        </c:if>
                        <c:if test="${contentElement.contentType == 'isImg'}">
                            <div class="text-lg-center mb-3 mt-3"><img src="${contentElement.content}" alt=""
                                                                       class="img-fluid"></div>
                        </c:if>
                        <c:if test="${contentElement.contentType == 'isSpan'}">
                            <span>${contentElement.content}</span>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="text-center">
                    <button onclick='history.back()' class="btn btn-secondary">На главную</button>
                </div>
            </div>

        </div>
    </div>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
