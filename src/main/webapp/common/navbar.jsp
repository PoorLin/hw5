<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand fs-3" href="<%=request.getContextPath()%>/index">
            精誠娛樂城
        </a>
         <div class="d-flex">
            <!-- 使用 JSTL 顯示 session 中的 name -->
            <c:if test="${not empty sessionScope.user.name}">
                <span class="navbar-text fs-5 me-3">
                    歡迎, ${sessionScope.user.name}
                </span>
              <a href="<%=request.getContextPath()%>/user/logout" class="btn btn-outline-danger btn-sm d-flex align-items-center justify-content-center" style="height: 40px; width: 100px;">
    登出
</a>
            </c:if>
        </div>
    </div>
</nav>
</header>

