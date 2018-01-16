<%--
  Created by IntelliJ IDEA.
  User: hrist
  Date: 1/16/2018
  Time: 3:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="./JS/AddNewItem.js"></script>
    <link href="./styles/searchItem.css" rel="stylesheet">
</head>
<body style="background: #282828;">
    <jsp:include page="navigation.jsp" />
<div id="insert-item" class="form-style-4">
    <label>Name</label>
    <input type="text" name="name">
    <br>

    <label>Price</label>
    <input type="text" name="price">
    <br>

    <label>Description</label>
    <input type="text" name="description">
    <br>

    <label>Color</label>
    <input type="text" name="color">
    <br>

    <label>Discount</label>
    <input type="text" name="discount">
    <br>

    <label>Brand</label>
    <input type="text" name="brand">
    <br>

    <label>Score</label>
    <input type="text" name="score">
    <br>

    <label>Tags</label>
    <input type="text" name="tags">
    <br>

    <label>Availability</label>
    <input type="text" name="availability">
    <br>

    <label>City</label>
    <input type="text" name="city">
    <br>

    <button class="submit-button" onClick="createNewItem()">CREATE NEW ITEM</button>

</div>
</body>
</html>
