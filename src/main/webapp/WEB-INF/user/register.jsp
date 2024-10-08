
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

<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">註冊</p>


                                <form:form class="mx-1 mx-md-4" method="POST" action="${pageContext.request.contextPath}/user/addUser"  modelAttribute="userForm">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label class="form-label" for="form3Example1c" path="name">姓名</form:label>
                                            <form:input type="text" id="form3Example1c" class="form-control" path="name"/>
                                            <form:errors path="name" class="text-danger" />
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">

                                            <div>
                                                <form:label class="form-label" path="gender">性別</form:label>
                                                <br>
                                                <form:label class="form-label"  path="gender">男</form:label>
                                                <form:radiobutton  class="form-radio-input" path="gender" value="0"/>
                                                <form:label class="form-label"  path="gender">女</form:label>
                                                <form:radiobutton  class="form-radio-input" name="gender" path="gender" value="1"/>
                                                <form:label class="form-label"  path="gender">不透露</form:label>
                                                <form:radiobutton  class="form-radio-input" name="gender" path="gender" value="2"/>
                                                <form:errors path="gender" class="text-danger" />
                                            </div>

                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div  class="form-outline flex-fill mb-0">
                                            <form:label class="form-label" for="form3Example3c" path="email">信箱</form:label>
                                            <form:input type="email" id="form3Example3c" class="form-control" path="email" />
<form:errors path="email" class="text-danger" />
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label class="form-label" path="password1">密碼</form:label>
                                            <form:input type="password"  class="form-control" path="password1"/>
                                            <form:errors path="password1" class="text-danger" />
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div  class="form-outline flex-fill mb-0">
                                            <form:label class="form-label"  path="password2" >再次輸入密碼</form:label>
                                            <form:input type="password"  class="form-control"  path="password2"/>
                                            <form:errors path="password2" class="text-danger" />
                                        </div>
                                    </div>


                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <input  type="submit"  class="btn btn-primary btn-lg" value="註冊"/>
                                    </div>

                                </form:form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<%@ include file="/common/footer.jsp" %>


</body>
</html>