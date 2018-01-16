<%--
  Created by IntelliJ IDEA.
  User: hrist
  Date: 1/16/2018
  Time: 3:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="./styles/searchItem.css" rel="stylesheet">
    <script src="./JS/SearchItems.js"></script>
    <title>SHOP</title>
</head>
<body style="background: #282828;">
<jsp:include page="navigation.jsp" />
<div class="search-edit">
    <div id="search-item" class="form-style-4">
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

        <button class="submit-button" onClick="searchItem()">FILTER</button>

    </div>

    <div id="update-item" class="form-style-4">
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

        <button class="submit-button" onClick="updateItem()">UPDATE</button>
    </div>
</div>

<div class="table">
    <table>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Color</th>
            <th>Discount</th>
            <th>Brand</th>
            <th>Publish Date</th>
            <th>Score</th>
            <th>Tags</th>
            <th>Availability</th>
            <th>City</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <tbody id="response-table">

        </tbody>
    </table>
</div>
</body>
</html>
