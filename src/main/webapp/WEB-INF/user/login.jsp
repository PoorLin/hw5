
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/bootstrap.jsp" %>
<%@ include file="/common/navbar.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>精誠娛樂城</title>

</head>
<body class="d-flex flex-column min-vh-100">

    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form:form method="POST" action="${pageContext.request.contextPath}/user/login"  modelAttribute="loginForm">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <form:label class="form-label" path="email" >信箱</form:label>
                        <form:input type="email"  class="form-control form-control-lg" path="email"
                               placeholder="輸入信箱" id="email" />
                        <form:errors path="email" class="text-danger" />

                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <form:label class="form-label" path="password">密碼</form:label>
                        <form:input type="password"  class="form-control form-control-lg"
                               placeholder="輸入密碼" path="password" id="password"/>
<form:errors path="password" class="text-danger" />
                    </div>
  <%-- 記得我和忘記密碼區塊  --%>
<%--                    <div class="d-flex justify-content-between align-items-center">--%>
<%--                        <!-- Checkbox -->--%>
<%--                        <div class="form-check mb-0">--%>
<%--                            <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />--%>
<%--                            <label class="form-check-label" for="form2Example3">--%>
<%--                                Remember me--%>
<%--                            </label>--%>
<%--                        </div>--%>
<%--                        <a href="#!" class="text-body">Forgot password?</a>--%>
<%--                    </div>--%>

                    <div class="text-center text-lg-start mt-4 pt-2">
                       <input  type="button"  class="btn btn-primary btn-lg" value="登入" id="login"/>
                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="<%=request.getContextPath()%>/user/register"
                                                                                          class="link-danger">現在註冊</a></p>
                    </div>

                </form:form>
            </div>
        </div>
    </div>


<%@ include file="/common/footer.jsp" %>



     <script type="module">
         import { loginAPI } from '<%=request.getContextPath()%>/js/userAPI.js';
       document.getElementById("login").addEventListener("click",async (e)=>{
         const email = document.getElementById("email").value;
         const password = document.getElementById("password").value;
         const res = await loginAPI({email:email,password:password})
           document.write(res.data);


       })

     </script>
</body>
</html>