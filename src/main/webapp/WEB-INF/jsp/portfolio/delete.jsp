<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <title>Delete Record</title>    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">    <style>      .wrapper {        width: 600px;        margin: 0 auto;      }    </style></head><body><div class="wrapper">    <div class="container-fluid">        <div class="row">            <div class="col-md-12">                <h2 class="mt-5 mb-3">Delete Record</h2>                <form action="${pageContext.request.contextPath}/portfolio/delete" method="post">                    <div class="alert alert-danger">                        <input type="hidden" name="trade_id" value="${trade_id}"/>                        <p>Are you sure you want to delete this stock record?</p>                        <p>                            <input type="submit" value="Yes" class="btn btn-danger">                            <input type="button" value="No" class="btn btn-secondary" onclick="history.back()">                        </p>                    </div>                </form>            </div>        </div>    </div></div></body></html>