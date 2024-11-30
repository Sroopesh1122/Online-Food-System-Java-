<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.nav-bar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 5px 20px;
	max-width: 1800px;
	background: #e63946;
	color: white;
	font-family: "outfit", sans-serif;
	width: 100%;
	position: relative;
}

.nav-bar .brand img {
	width: 40px;
	height: 40px;
	border-radius: 50%;
}

.nav-bar .brand span {
	font-size: 1.2rem;
	font-weight: 600;
	margin-left: 4px;
}

.nav-bar .menu {
	gap: 10px;
}

.nav-bar .menu button {
	padding: 5px;
	border-radius: 8px;
	border: none;
	background: white;
}

.nav-bar .menu ul {
	margin-bottom: 0px;
	gap: 10px;
}

.nav-bar .menu ul li {
	list-style: none;
	padding: 2px 5px;
	border-radius: 8px;
	cursor: pointer;
}

.nav-bar .menu ul .active {
	background: white;
	color: #e63946;
}


.desktop-nav {
	display: flex;
}

.mobile-nav {
    width: 0vw;
	height: 100vh;
	position: absolute;
	top: 0;
	right: 0vw;
	background: #e63946;
	color: white;
	display: none;
}
.fa-bars{
	 display: none;
	 
 }

@media ( max-width :768px) {
	.desktop-nav {
		display:none;
	}
	.mobile-nav{
	 display: block;
	 overflow: hidden;
	 transition :width 0.3s;
	 padding: 20px 0px;
	 z-index: 999;
	}
	.mobile-nav .menu-list{
	 width: 100%;
	 height: 100%;
	 padding: 30px;
	 display: flex;
	 flex-direction: column;
	 align-items: center;
	}
	.mobile-nav .menu-list button {
	  background: white;
	  margin:10px auto;
	  padding: 4px 8px;
	  width:70%;
	  border-radius: 10px;
	  border: none;
	  font-size: 0.96rem;
	}
	.mobile-nav .menu-list ul{
	 padding: 0px;
	}
	.mobile-nav .menu-list ul li{
	 list-style: none;
	 margin: 10px 0px;
	 padding: 4px 8px;
	 white-space:nowrap;
	 text-align: center;
	}
	.mobile-nav .menu-list ul .active{
	 background: white;
	 border-radius: 10px;
	 color:  #e63946;
	 
	}
	
	.fa-arrow-right{
	  cursor: pointer;
	}
	
	.fa-bars{
	 display: block;
	 cursor: pointer;
	}
	.open-mobile-nav{
	 width: 50vw;
	}
}

</style>

<nav class="nav-bar">
	<div class="brand">
		<img alt="logo"
			src="<%=request.getContextPath() + "/images/Img1.webp"%>"> <span>FOS</span>
	</div>

	<div class="menu center desktop-nav">
		<ul class="center">
			<li class="<%= request.getAttribute("menu").toString().equalsIgnoreCase("Home") ? "active":"" %>">Home</li>
			<li class="<%= request.getAttribute("menu").toString().equalsIgnoreCase("Food Menu") ? "active":"" %>" >Food Menu</li>
			<li class="<%= request.getAttribute("menu").toString().equalsIgnoreCase("Orders") ? "active":"" %>">Orders</li>
			<li class="<%= request.getAttribute("menu").toString().equalsIgnoreCase("Reviews") ? "active":"" %>">Reviews</li>
		</ul>

		<button type="button" class="custom-btn">Logout</button>
	</div>
	
	<i class="fa-solid fa-bars" id="menu-icon"></i>
	
	<div class="mobile-nav ">
	 <span class="p-2"><i class="fa-solid fa-arrow-right" id="menu-close-icon"></i></span>
	 <div class="menu-list">
	     
	     <ul>
	       <a href=""><li class="<%= request.getAttribute("menu").toString().equalsIgnoreCase("Home") ? "active":"" %>">Home</li></a>
			<a href=""><li class="<%= request.getAttribute("menu").toString().equalsIgnoreCase("Food Menu") ? "active":"" %>" >Food Menu</li></a>
			<a href=""><li class="<%= request.getAttribute("menu").toString().equalsIgnoreCase("Orders") ? "active":"" %>">Orders</li></a>
			<a href=""><li class="<%= request.getAttribute("menu").toString().equalsIgnoreCase("Reviews") ? "active":"" %>">Reviews</li></a>
	     </ul>
	     <button type="button">Logout</button>
	 </div>
	</div>
</nav>
<script type="text/javascript">
 let openMenu = false;

  $("#menu-icon").on('click',function(){
	$(".mobile-nav").addClass("open-mobile-nav")  
	  
  })
  
  $("#menu-close-icon").on('click',function(){
		$(".mobile-nav").removeClass("open-mobile-nav")  
		  
	  })

</script>




