import React from "react";
import { Link} from "react-router-dom";
import { Input } from "reactstrap";
import { useEffect, useState } from 'react';
import { get } from "../callApi";
export default function Header(props){
	const [categories, setCategories] = useState([]);
	const [role, setRole] = useState(props.role);
	const [isLogin, setIsLogin] = useState(props.isLogin);
	let buttonAcc;
	const listItems = (
		<ul class="submenu-nav">
			{categories.map( (category) =>
			<li key = {category.categoryId}>
				<Link to={`categories/${category.categoryId}`}>{category.categoryName}</Link>
			</li>
			)}
		</ul>
	);
	const handleLogout = (e) =>{
		localStorage.removeItem('user');
		localStorage.removeItem('token');
		localStorage.removeItem('information');
		localStorage.setItem('isLogin', 'false');
		localStorage.setItem('role', 'Customer');
		props.onLoginChange('Customer', false);
	}
	if(isLogin === 'true'){
		buttonAcc = <a href="/" onClick={handleLogout}><i class="fa fa-user" ></i> Logout</a>
	} 
	else{
		console.log(props.isLogin);
		buttonAcc = <Link to="/login-register"><i class="fa fa-user"></i> Login-Register</Link>
	}
	let toolbar;
	if(role === 'Customer'){
		
		toolbar = (
			<ul class="main-menu nav position-relative">
				<li ><a class="ml--2" href="/">Home</a></li>
				<li class="ml--2"><Link to="/books">Books</Link>
					
				</li>
			</ul>
		);
	}
	else{
		toolbar = (
			<ul class="main-menu nav position-relative">
				<li ><Link class="ml--2" to="/manage/orders">Orders</Link></li>
				<li class="has-submenu"><Link to="manage/books">Manage Product</Link>
					<ul class="submenu-nav">
						<li ><Link to="manage/authors">Authors</Link></li>
						<li ><Link to="/manage/categories">Categoris</Link></li>
						<li ><Link to="/manage/books">Books</Link></li>
					</ul>
				</li>
			</ul>
		);
	}
	
  	function getListCategory(){
    	get("/categories")
		.then(function (response) {
			setCategories(response.data);
		})
		.catch(function (error) {
			let message = "Can't get list Category !";
            if (error.response) {
                message = error.response.data.message;
			}
            //else message = "Connection failed ! Please try again later";
			alert(message);	
		});
    }
	
  
  useEffect( () => {
		getListCategory();
	},[]);
//	const [countcart, setCountCart] = useState();
	
	
		return (
			<div >
				<header class="header-wrapper">
					<div class="header-top">
					<div class="container">
						<div class="row">
						<div class="col-xs-12 col-sm-5 col-md-4 col-lg-6">
							
						</div>
						<div class="col-xs-12 col-sm-7 col-md-8 col-lg-6 sm-pl-0 xs-pl-15 header-top-right">
							<div class="header-info">
							<a href="tel://+00123456789"><i class="fa fa-phone"></i> +00 123 456 789</a>
							<a href="mailto://demo@example.com"><i class="fa fa-envelope"></i> demo@example.com</a>
							{buttonAcc}
							</div>
						</div>
						</div>
					</div>
					</div>
					<div class="header-middle">
					<div class="container">
						<div class="row row-gutter-0 align-items-center">
						<div class="col-12">
							<div class="header-align">
							<div class="header-align-left">
								<div class="header-logo-area">
								<a href="/">
									<img class="logo-main" src="assets/img/logo.png" alt="Logo" />
								</a>
								</div>
							</div>
							<div class="header-align-center">
								<div class="header-search-box">
								<form action="#" method="post">
									<div class="form-input-item">
									<label for="search" class="sr-only">Search</label>
									<Input type="text" id="search" placeholder="Search Everything"/>
									<button type="submit" class="btn-src">
										<i class="pe-7s-search"></i>
									</button>
									</div>
								</form>
								</div>
							</div>
							<div class="header-align-right">
								<div class="header-action-area">
								<div class="header-action-cart">
									<Link class="btn-cart cart-icon" to="/cart">
									
									<i class="pe-7s-shopbag"></i>
									</Link>
								</div>
								<button class="btn-menu d-md-none">
									<i class="ion-navicon"></i>
								</button>
								</div>
							</div>
							</div>
						</div>
						</div>
					</div>
					</div>
					<div class="header-area header-default sticky-header">
					<div class="container">
						<div class="row row-gutter-0 align-items-center">
						<div class="col-4 col-sm-6 col-lg-2">
							<div class="header-logo-area">
							<Link to="/">
								<img class="logo-main" src="assets/img/logo.png" alt="Logo" />
							</Link>
							</div>
						</div>
						<div class="col-lg-8 sticky-md-none">
							<div class="header-navigation-area d-none d-md-block">
								{toolbar}
							</div>
						</div>
						<div class="col-8 col-sm-6 col-lg-2">
							<div class="header-action-area">
							
							<div class="header-action-login">
								<Link class="btn-login" to ="/login-register">
								<i class="pe-7s-users"></i>
								</Link>
							</div>
							<div class="header-action-wishlist">
								<button class="btn-wishlist" onclick="window.location.href='shop-wishlist.html'">
								
								</button>
							</div>
							<div class="header-action-cart">
								<Link class="btn-cart cart-icon" to = "/cart">
								<i class="pe-7s-shopbag"></i>
								</Link>
							</div>
							<button class="btn-menu d-lg-none">
								<i class="ion-navicon"></i>
							</button>
							</div>
						</div>
						</div>
					</div>
					</div>
				</header>
				 
				{/* <div class="w3-sidebar w3-bar-block" style="display:none;z-index:5" id="mySidebar">
					<button class="w3-bar-item w3-button w3-xxlarge" onclick="w3_close()">Close &times;</button>
					<a href="#" class="w3-bar-item w3-button">Link 1</a>
					<a href="#" class="w3-bar-item w3-button">Link 2</a>
					<a href="#" class="w3-bar-item w3-button">Link 3</a>
					</div> */}
	 
			</div>
		);
	
    
}