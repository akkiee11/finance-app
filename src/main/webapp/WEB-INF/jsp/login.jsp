<script>localStorage.clear();
sessionStorage.clear();</script>
<!DOCTYPE html>
<html lang="en">

<head>
    <style>
        <%@include file="/WEB-INF/styles/login.css" %>
    </style>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="login-form">
    <form>
        <h1>Login</h1>
        <div class="form-group">
            <input type="email" name="email" placeholder="E-mail Address">
            <span class="input-icon"><i class="fa fa-envelope"></i></span>
        </div>
        <div class="form-group">
            <input type="password" name="psw" placeholder="Password">
            <span class="input-icon"><i class="fa fa-lock"></i></span>
        </div>
        <button class="login-btn">Login</button>
        <a class="reset-psw" href="#">Forgot your password?</a>
        <div class="seperator"><b>or</b></div>
        <p>Sign in with your social media account</p>

        <!-- Social login buttons -->
        <div class="col">
        </div>
    </form>
</div>
</body>
</html>