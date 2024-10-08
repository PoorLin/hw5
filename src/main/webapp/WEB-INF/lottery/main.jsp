
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/bootstrap.jsp" %>
<%@ include file="/common/navbar.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>lottery</title>
</head>
<body class="d-flex flex-column min-vh-100">
<div class="justify-content-center flex-column text-center mt-3">
    <h1>樂透</h1>
</div>

<div class="container flex-grow-1 d-flex flex-column justify-content-center align-items-center">
    <form:form action="${pageContext.request.contextPath}/lottery/generateLottery" method="post" modelAttribute="lotteryForm">
    <!-- 輸入要出的樂透組數 -->
    <div class="mb-3">
        <form:label  class="form-label" path="lotteryCount">輸入要出的樂透組數</form:label>
        <form:input type="number" class="form-control"  min="1" placeholder="例如: 5" path="lotteryCount" />
          <form:errors path="lotteryCount" class="text-danger" />
    </div>
    <!-- 輸入排除的數字 -->
    <div class="mb-3">
        <form:label path="excludedNumbers" class="form-label">輸入排除的數字(用空白隔開) </form:label>
        <form:input type="text" class="form-control"  path="excludedNumbers" placeholder="例如: 3 5 7" />
             <form:errors path="excludedNumbers" class="text-danger" />
    </div>
    <!-- 送出按鈕 -->
     <input  type="submit"  class="btn btn-primary btn-lg" value="猜這個"/>


    </form:form>

</div>

<%@ include file="/common/footer.jsp" %>


</body>
</html>