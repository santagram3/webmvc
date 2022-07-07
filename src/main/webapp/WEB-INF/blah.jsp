<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>

<body>

    <h1>blah.jsp입니다 ~ 이 파일은 서버에서만 접근 가능합니다.</h1>


    <p>
        <!-- 서버에서 온 메세지 : <%= request.getAttribute("msg")%> -->
        서버에서 온 메세지 : ${msg}
        <br>
        서버에서 온 메세지 : ${number}
        <br>
        서버에서 온 리스트 : ${hobbys}
        <br>
        서버에서 온 리스트 중 하나 : ${hobbys.get(0)}
        <br>
        서버에서 온 리스트 중 길이 : ${hobbys.size()}
        <br>

        <!-- jstl을 이용한 반복문  -->
        <!-- 포문을 태그화 시킨거 -->
        <!-- iter 문  -->
        <!-- for (String h : hobbys) {} -->
        <c:forEach var="h" items="${hobbys}">
            # 취미 : ${h} <br>
        </c:forEach>

        <!-- fori 문  -->
        <!-- for(int i = 0 ; i<=10 ; i++) -->
        <c:forEach var="i" begin="1" end="10" step="1">
            ${i}!!
        </c:forEach>

        <!-- if문 -->
        <c:if test="${number == 100}">
            서버에서 온 숫자는 100과 같습니다!!
            <br>
        </c:if>
        
        <c:choose>
            <c:when test="${1 > hobbys2.size()}">
                빈 리스트 입니다.
                <br>
            </c:when>
        </c:choose>
        


   
        <br>

     

        <!-- 다중 if문 -->
        <c:choose>
            <c:when test="${hobbys.size() > 0}">
                취미가 있습니다~~~
            </c:when>

            <c:when test="${hobbys.size() > 1}">
                취미가 1개 있습니다~~~
            </c:when>

            <%-- else --%>
            <c:otherwise>
                취미가 없습니다~~~
            </c:otherwise>
        </c:choose>

        


    </p>


</body>

</html>