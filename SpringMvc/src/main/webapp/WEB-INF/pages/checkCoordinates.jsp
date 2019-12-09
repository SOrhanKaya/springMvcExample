<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Check Coordinates</title>
</head>
<body>

<form:form action="saveCoordinates"  method="post" modelAttribute="getForm">


<table cellpadding="5" cellspacing="10" >
  <tr align="right">
    <td> X Coordinate </td>
    <td> <input type="text" id="CoordinateX" name="CoordinateX" value="${xCoor}" path="CoordinateX" onkeypress='return event.keyCode >= 48 && event.keyCode <= 57' required></td>
  </tr>
  <tr align="right">
    <td> Y Coordinate </td>
    <td> <input type="text" id="CoordinateY" name="CoordinateY" value="${yCoor}" path="CoordinateY" onkeypress='return event.keyCode >= 48 && event.keyCode <= 57' required></td>
  </tr>
  <tr>
    <td align="right"> TCKN </td>
    <td> <input type="text" id="PersonTc" name="PersonTc" value="${personTc}" path="PersonTc" onkeypress='return event.keyCode >= 48 && event.keyCode <= 57' minlength="11" maxlength="11" required></td>
  </tr>
  <tr>
    <td> <input type="submit" id="add_data" value="Save" style="width: 100%"></td>
    </form:form>

    <form:form action="savedCoordinates" method="get">
      <td> <input type="submit" id="added_data" value="Saved Coordinates" style="width: 100%"> </td>
    </form:form>
  </tr>
</table>
<table cellspacing="3" cellpadding="2" frame="box">
  <c:forEach var="person" items="${personList}">
    <tr>
      <td>X: <c:out value="${person.coordinateX}"/>  ,</td>
      <td>Y: <c:out value="${person.coordinateY}"/></td>
    </tr>
  </c:forEach>
</table>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>
  $(document).ready(function() {

    $("#add_data").click(function () {
      $.ajax({
        url: "saveCoordinates",
        type: "post",
        data: {
          CoordinateX: $('#CoordinateX').val(),
          CoordinateY: $('#CoordinateY').val(),
          PersonTc: $('#PersonTc').val(),
          success: function (data) {
          }
        }
      });
    });
    $("#added_data").click(function() {
      $.ajax({
        url: 'savedCoordinates',
        type: "get",
        data: {"type":"check"},
        success: function(response){
        }
      });
    });
  });

</script>
</html>