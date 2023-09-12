
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Main css -->
<link href=" <c:url value="/css/style.css" /> " rel="stylesheet" />
<c:url value="/login" var="action" />

<section class="sign-in">

    <div class="signin-content">     
        <div class="signin-image">
            <figure>
                <img src="<c:url value="/images/signin-image.jpg" />" alt="sign up image">
            </figure>
        </div>

        <div class="signin-form">

            <h2 class="form-title">Sign in</h2>
            
            <form method="post" action="${action}">
                <div class="form-group">
                    <label class="icon" for="username"><i class="fas fa-user"></i></label> 
                    <input type="text" name="username" id="username" placeholder="Username" />
                </div>
                <div class="form-group">
                    <label class="icon" for="password"><i class="fas fa-key"></i></label> 
                    <input type="password" name="password" id="password" placeholder="Password" />
                </div>
                <div class="form-group form-button">
                    <input type="submit" name="signin" id="signin" class="form-submit" value="Log in" />
                </div>
            </form>


            <div class="social-login">
                <span class="social-label">Or login with</span>
                <ul class="socials">
                    <li><a href="#"><i class="display-flex-center  fab fa-facebook-f"></i></a></li>
                    <li><a href="#"><i class="display-flex-center  fab fa-twitter"></i></a></li>
                    <li><a href="#"><i class="display-flex-center  fab fa-google"></i></a></li>
                </ul>
            </div>

        </div>
    </div>

</section>


