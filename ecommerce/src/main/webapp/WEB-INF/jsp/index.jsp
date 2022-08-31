<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Commerce Tech Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .color-second-bg{ background: #00A5C4}
        .card-body{ 
            background: #00A5C4;
            border-radius: 10px;}
        body{
            background-color: #808080;
        }
        nav .navbar-nav li a{
  color: white !important;
  } 
  .navbar-brand{
  color: white !important;
  } 
    </style>
</head>

<body>
    <!-- start #header -->
    <!--start #nav-bar -->
    <nav class="navbar navbar-expand-lg color-second-bg">
        <div class="container-fluid">
            
            <a class="navbar-brand" href="index.html">Tech Fun House</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!--Start search -->

            <form method="get">
                <div class="input-group">
                    <input class="form-control" placeholder="Search for..." type="text" name="name">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i></button>
                    </div>
                </div>
            </form>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav m-auto ">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <!-- type Select -->
                    <li class="nav-item">
                        <a class="nav-link" id="Samsung-submit" type="submit" name="type-select"
                            value="Laptops">Laptops</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" id="Samsung-submit" type="submit" name="type-select"
                        value="Cellphones">Cellphones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="Microsoft-submit" type="submit" name="type-select"
                            value="Microsoft">Headphones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="Microsoft-submit" type="submit" name="type-select"
                            value="Accessories">Accessories</a>
                    </li>
                    <c:choose>
                    <c:when test="${LoggedIn == false}">
                        <li class="nav-item"><a class="nav-link" href="signup">Sign up</a></li>
                    <li class="nav-item"><a class="nav-link" href="login">Log In</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="cart">Cart</a></li>
                        <li class="nav-item"><a class="nav-link" href="logout">Log out</a></li>
                    </c:otherwise>
                    </c:choose>
                </ul>
                </a>
            </div>
        </div>
    </nav>
    <div id="main-content" class="container">
        <div class="row text-center py-5">
        <div class="col-md-3 col-sm-6 my-3 my-md-0">
          <form action="/" method="post">
          <div class="card shadow">
          <div>
          <img src="img/product0.png" class= "img-fluid card-img-top" style="height:400px;">
          </div>
          <div class= "card-body">
          <h5 class="card-title">Bose Noise Cancelling Headphones 700</h5>
          <h5>
              <span class="price">$379</span>
          </h5>
      <button type="submit" class="btn btn-warning my-3" name="add"> Add to Cart<i class="fas fa=shopping-cart"></i></button>
      <input type='hidden' name='product_id' value=1>
      <input type='hidden' name='product_price' value=379>
          </div>
          </div>
          </form>
      </div>
      <div class="col-md-3 col-sm-6 my-3 my-md-0">
        <form action="/" method="post">
        <div class="card shadow">
        <div>
        <img src="./upload/product1.png" class= "img-fluid card-img-top" style="height:400px;">
        </div>
        <div class= "card-body">
        <h5 class="card-title">Beats Solo</h5>
        <h5>
            <span class="price">$199</span>
        </h5>
    <button type="submit" class="btn btn-warning my-3" name="add"> Add to Cart<i class="fas fa=shopping-cart"></i></button>
    <input type='hidden' name='product_id' value=2>
    <input type='hidden' name='product_price' value=199>
        </div>
        </div>
        </form>
    </div>
    <div class="col-md-3 col-sm-6 my-3 my-md-0">
        <form action="/" method="post">
        <div class="card shadow">
        <div>
        <img src="./upload/product1.png" class= "img-fluid card-img-top" style="height:400px;">
        </div>
        <div class= "card-body">
        <h5 class="card-title">Airpod Max</h5>
        <h5>
            <span class="price">$549</span>
        </h5>
    <button type="submit" class="btn btn-warning my-3" name="add"> Add to Cart<i class="fas fa=shopping-cart"></i></button>
    <input type='hidden' name='product_id' value=3>
    <input type='hidden' name='product_price' value=549>
        </div>
        </div>
        </form>
    </div>
  </div>
    </div>
</body>

</html>