<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <c:if test="${not(requestScope.ServerError eq null)}">
            <div class="msg_container">
                <div class="msg msg_default">
                    <div class="msg_header">Somsthing went wrong!</div>
                    <div class="msg_body">
                        <c:out value="${requestScope.ServerError}" />
                    </div>
                    <button class="msg_close" type="button"></button>
                </div>
            </div>
        </c:if>

        <c:if test="${not(requestScope.access eq null)}">

            <div class="msg_container">
                <div class="msg msg_default">
                    <div class="msg_header">Request executed!</div>
                    <div class="msg_body">
                        <c:out value="${requestScope.access}" />
                    </div>
                    <button class="msg_close" type="button"></button>
                </div>
            </div>
        </c:if>