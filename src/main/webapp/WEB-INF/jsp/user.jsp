<!DOCTYPE html><html><head>    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    <style>      .card {        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);        max-width: 350px;        margin: 60px 150px 80px 580px;        text-align: center;        font-family: arial;      }      .title {        color: grey;        font-size: 20px;      }      .user {        border: none;        outline: 0;        display: inline-block;        padding: 10px;        color: white;        background-color: #000;        text-align: center;        cursor: pointer;        width: 100%;        font-size: 20px;      }      .adec {        text-decoration: none;        font-size: 22px;        color: black;      }      .user:hover, a:hover {        opacity: 0.7;      }    </style>    <title>User Details</title></head><body><jsp:include page="home.jsp"/><div class="card">    <h2 style="text-align:center">Profile Card</h2>    <%-- TODO: Fix image. --%>    <%--  <img src="${pageContext.request.contextPath}/WEB-INF/images/user.png" alt="John" style="width:100%"/>--%>    <h1>${userName}</h1>    <p class="title">Financial Dashboard User</p>    <p><b>Name:</b> ${userName}</p>    <p><b>Email Id:</b> ${emailId}</p>    <a class="adec" href="${pageContext.request.contextPath}/dashboard">        <p>            <button class="user">Go To Financial Dashboard</button>        </p>    </a></div></body></html>