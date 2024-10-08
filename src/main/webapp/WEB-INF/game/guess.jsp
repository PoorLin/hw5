<%@ page import="com.systex.hwspring.model.guess.GuessGame" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/bootstrap.jsp" %>
<%@ include file="/common/navbar.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>guess</title>
</head>
<body class="d-flex flex-column min-vh-100">
<div class="justify-content-center flex-column text-center mt-3">
    <h1>猜數字</h1>
</div>

<div class="container flex-grow-1 d-flex flex-column justify-content-center align-items-center">
    <form:form action="${pageContext.request.contextPath}/game/guess"  method="post" modelAttribute="guessForm">
        <input type="hidden" class="form-control" id="action" name="action" value="guess">
        <!-- 顯示當前遊戲狀態 -->
        <div class="form-group">
            <h3>遊戲狀態:</h3>
            <c:set var="guessGame" value="${sessionScope.guessGame}" />
<c:if test="${not empty guessGame}">
    <c:set var="remainingTries" value="${guessGame.remains}" />
    剩餘嘗試次數: ${remainingTries} 次<br />

    <c:if test="${remainingTries != 3}">
        <h2 class="text-danger">您猜錯了</h2>
    </c:if>
</c:if>
<c:if test="${empty guessGame}">
    剩餘嘗試次數: 3 次<br />
</c:if>

        </div>
        <!-- 猜數字區塊 -->
        <div class="mb-3">
            <div class="form-group">
                <h2>數字範圍 (1~10):</h2>
            </div>

            <!-- 輸入猜的數字 -->
            <div class="form-group">
                <form:label for="guessNumber" path="guessNumber">輸入你猜的數字:</form:label>
                <form:input type="number" class="form-control" path="guessNumber" name="guessNumber" min="1" max="10"/>
                   <form:errors path="guessNumber" class="text-danger"/>
            </div>
        </div>

        <!-- 送出按鈕 -->
        <button type="submit" class="btn btn-primary">送出</button>
    </form:form>

</div>

<%@ include file="/common/footer.jsp" %>
</body>
</html>