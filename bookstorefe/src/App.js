import { BrowserRouter, Route, Routes } from "react-router-dom";

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
  const [role, setRole] = useState('Customer');
  const [isLogin, setIsLogin] = useState(false);
  useEffect(()=>{
    console.log("aa");
  },[]);
  function handleLoginChange(role, isLogin){
    console.log(isLogin);
    setRole(role);
    setIsLogin(isLogin);
  }
    return (
      <BrowserRouter>
        <Header isLogin = {isLogin} role = {role} onLoginChange = {handleLoginChange}/>
        <Routes >
          
          <Route path="/"element = {<Home cloudName = "duku7fuxt" />} />
          <Route path='/books' element= {<Books />} />
          <Route path="/login-register" element= {<Login onLoginChange = {handleLoginChange}/>} />
          <Route path="/books/:id" element= {<SingleBook />} />
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
    );
  
  
}

export default App;
