import { BrowserRouter, Route, Routes, useNavigate } from "react-router-dom";

import './App.css';
import Home from './components/home';
import Header from './components/header';
import Books from './components/customer/books';
import Login from './components/login-register';
import NotFound from './components/notfound';
import SingleBook from './components/customer/single-book';
import MyAccount from './components/customer/my-account';
import Cart from './components/customer/cart';
import Checkout from './components/customer/checkout';
import { useEffect, useState } from "react";
import ManageOrders from "./components/admin/manage-orders";
import ManageBooks from "./components/admin/manage-books";
import ManageAuthors from "./components/admin/manage-authors";
import ManageCategories from "./components/admin/manage-categories";



function App() {
  const [role, setRole] = useState(localStorage.getItem('role'));
  const [isLogin, setIsLogin] = useState(localStorage.getItem('isLogin'));
  
  function handleLoginChange(role, isLogin){
    setRole(role);
    setIsLogin(isLogin);
  }
  useEffect(()=>{
    if(localStorage.getItem('role') === null) setRole('Customer');
    if(localStorage.getItem('isLogin') === null) setIsLogin('false');
  },[])
    return (
      <>
      
      <BrowserRouter>
        <Header isLogin = {isLogin} role = {role} onLoginChange = {handleLoginChange}/>
        <Routes >
          
          <Route path="/"element = {<Home />} />
          <Route path='/books' element= {<Books />} />
          <Route path="/login-register" element= {<Login onLoginChange = {handleLoginChange}/>} />
          <Route path='/books/:id' element= {<SingleBook />} />
          <Route path="/my-account" element= {<MyAccount />} />
          <Route path="/cart" element= {<Cart />} />
          <Route path="/checkout" element= {<Checkout />} />

          <Route path="/manage/orders" element = {<ManageOrders />}/>
          <Route path="/manage/books" element = {<ManageBooks />}/>
          <Route path="/manage/authors" element = {<ManageAuthors />}/>
          <Route path="/manage/categories" element = {<ManageCategories />}/>

          <Route path="/*"element = {<NotFound/>} />
                     
        </Routes>
      </BrowserRouter>
      </>
    );
  
  
}

export default App;
