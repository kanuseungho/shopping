<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Tilt+Warp&family=Vina+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
  <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <script src="https://kit.fontawesome.com/f31f2dda49.js" crossorigin="anonymous"></script>
  <style type="text/css">
  	:root {
	    --text-color: #f0f4f5;
	    --background-color: #263343;
	    --accent-color: rgb(87, 170, 166)
		}      
		body {
	    margin : 0;
	    font-family: 'Source Sans Pro';
		}
		a {
	    text-decoration: none;
	    color: #4A5544;
		}
		.navbar {
	    display: flex;
	    justify-content: space-between;
	    align-items: center;
	    background-color: white;
	    padding: 8px 12px;
			font-family: 'Vina Sans', cursive;
			font-size: 25px; 
		}
		
		.navbar__logo {
	    font-size: 24px;
	    color: cadetblue;
	    margin-left: 20px;
		}
		
		.navbar__menu li {
		    padding: 10px 20px;
		}
		
		.navbar__icons {
		    list-style: none;
		    display :flex;
		    color:white;
		    padding-left: 0px;
		}
		
		.navbar__icons li {
		    /* padding: 8px 12px; */
		}
		
		.navbar__menu {
		    display: flex;
		    list-style: none;
		    padding-left: 0px;
		    gap: 50px;
		}
		
		.navbar__menu li {
		    padding: 8px 13px;
		}
		
		.navbar__menu li:hover {
		    background-color : rgb(87, 170, 166);
		    border-radius: 5px;
		}
		
		.navbar__icons li {
		    padding : 10px;
		}
		
		.navbar__toggleBtn {
		    display: none;
		}
		
		@media screen and (max-width: 768px) {
		    .navbar {
		        flex-direction: column;
		        align-items: flex-start;
		        padding : 10px 24px;
		    }
		    
		    .navbar__menu {
		        display: none;
		        flex-direction: column;
		        align-items: center;
		        width: 100%;
		    }
		
		    .navbar__menu li {
		        width: 100%;
		        text-align: center;
		    }
		
		    .navbar__icons{
		        display: none;
		        width: 100%;
		        justify-content: center;
		    }
		
		    .navbar__toggleBtn {
		        display: block;
		        position: absolute;
		        right : 20px;
		        font-size: 24px;
		        color :rgb(87, 170, 166);
		    }
		
		    .navbar__menu.active,
		    .navbar__icons.active {
		        display: flex;
		        transition: 1s ease-out;
		    }
		}
		
		.submenu {
		  display: none;
		  top: 100%;
		  left: 0;
		  transform: translateY(-10px); /* 초기에는 약간 위로 숨겨진 상태 */
		  transition: transform 0.3s ease-in-out;
		}
		
		.navbar__submenu.active .submenu {
		  display: block; /* 활성화된 경우 하위 메뉴를 보이게 함 */
		  transform: translateY(0); /* 아래로 이동하여 표시 */
		}
	
		.material-symbols-outlined {
		  font-variation-settings:
		  'FILL' 0,
		  'wght' 400,
		  'GRAD' 0,
		  'opsz' 48
		}
	
  </style>
  <script type="text/javascript">
  document.addEventListener("DOMContentLoaded", () => {
	  const submenuItems = document.querySelectorAll(".navbar__submenu");

	  submenuItems.forEach((submenu) => {
	    const submenuLink = submenu.querySelector("a");

	    submenuLink.addEventListener("click", (e) => {
	      e.preventDefault();
	      submenu.classList.toggle("active");
	    });
	  });
	});


  </script>
</head>
<body>
 	<nav class="navbar"> 
    <div class="navbar__logo">        
        <a href="${ctp}/main/main">FoW-J</a>
    </div>
    
    <ul class="navbar__menu">		  
			<li><a href="">MADE</a></li>
			<li><a href="">NEW</a></li>
    	<li><a href="">BEST</a></li>
    	<li><a href="">CODY SET</a></li>
		  <li class="navbar__submenu">
		      <a href="">OUTER</a>
		      <ul class="submenu">
		          <li><a href="">Submenu 1</a></li>
		          <li><a href="">Submenu 2</a></li>
		          <li><a href="">Submenu 3</a></li>
		      </ul>
		  </li>
		 	<li><a href="">SHIRTS</a></li>
		  <li class="navbar__submenu">
		      <a href="">KNIT</a>
		      <ul class="submenu">
		          <li><a href="">Submenu 1</a></li>
		          <li><a href="">Submenu 2</a></li>
		          <li><a href="">Submenu 3</a></li>
		      </ul>
		  </li>
		  <li class="navbar__submenu">
		      <a href="">TOP</a>
		      <ul class="submenu">
		          <li><a href="">Submenu 1</a></li>
		          <li><a href="">Submenu 2</a></li>
		          <li><a href="">Submenu 3</a></li>
		      </ul>
		  </li>
		  <li class="navbar__submenu">
		      <a href="">BOTTOM</a>
		      <ul class="submenu">
		          <li><a href="">Submenu 1</a></li>
		          <li><a href="">Submenu 2</a></li>
		          <li><a href="">Submenu 3</a></li>
		      </ul>
		  </li>
		  <li class="navbar__submenu">
		      <a href="">SET-UP</a>
		      <ul class="submenu">
		          <li><a href="">Submenu 1</a></li>
		          <li><a href="">Submenu 2</a></li>
		          <li><a href="">Submenu 3</a></li>
		      </ul>
		  </li>
		  <li class="navbar__submenu">
		      <a href="">ECT</a>
		      <ul class="submenu">
		          <li><a href="">Submenu 1</a></li>
		          <li><a href="">Submenu 2</a></li>
		          <li><a href="">Submenu 3</a></li>
		      </ul>
		  </li>
		  <li class="navbar__submenu">
		      <a href="">COMMUNITY</a>
		      <ul class="submenu">
		          <li><a href="">Submenu 1</a></li>
		          <li><a href="">Submenu 2</a></li>
		          <li><a href="">Submenu 3</a></li>
		      </ul>
		  </li>
		</ul>
		<div class="right-icon">
			<ul class="navbar__menu" style="margin-right: 20px;">
				<li><i class="fa-solid fa-magnifying-glass"></i></li>
				<li><i class="fa-solid fa-cart-shopping"></i></li>
			</ul>
		</div>
    <a href="#" class="navbar__toggleBtn">
        <i class="fas fa-bars"></i>
    </a>
  </nav>
  
  <!-- 스크립트를 위에 썼더니 이벤트 리스너가 먼저 발생되어서 언캐치오류가 발생했었다. -->
  <script type="text/javascript">
	  let toggleBtn = document.querySelector(".navbar__toggleBtn");
	  let menu = document.querySelector(".navbar__menu");
	  let icons = document.querySelector(".navbar__icons");
	
	  toggleBtn.addEventListener("click", () => {
	      menu.classList.toggle('active');
	      icons.classList.toggle('active');
	  });
  </script>
</body>
</html>