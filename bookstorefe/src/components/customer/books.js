import React, { useEffect, useState } from "react";
import { get } from "../../callApi";
import { Link } from "react-router-dom";
import Star from "../star-rating";
import { addCart, fomatMoney } from "./single-book";
export default function Books(){
  const [books, setBooks] = useState([]);
  const [categories, setCategories] = useState([]);
  let [authors, setAuthors] = useState([]);
  useEffect( () => {
    getAllBooks();
    getListAuthors();
    getListCategories();
  },[]);
  function getAllBooks(){
    get("/books")
    .then(function (response) {
      setBooks(response.data);
    })
    .catch(function (error) {
      let message = "Can't get list Book !";
        if (error.response) {
          message = error.response.data.message;
        }
        //else message = "Connection failed ! Please try again later";
      alert(message);	
    });
  }
  function getListCategories(){
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
  function getListAuthors(){
    get("/authors")
    .then(function (response) {
      setAuthors(response.data);
    })
    .catch(function (error) {
      let message = "Can't get list Author !";
            if (error.response) {
                message = error.response.data.message;
      }
            //else message = "Connection failed ! Please try again later";
      alert(message);	
    });
  }
  const getBooksByAuthor = (authorId) => {
    get("/authors/"+authorId+"/books")
    .then(function (response) {
      
      console.log(response.data);
      setBooks(response.data);
    })
    .catch(function (error) {
      let message = "Can't get books by Author !";
            if (error.response) {
                message = error.response.data.message;
      }
            //else message = "Connection failed ! Please try again later";
      alert(message);	
    });
  }
  const getBooksByCategory = (categoryId) => {
    get("/categories/"+categoryId+"/books")
    .then(function (response) {
      setBooks(response.data);
    })
    .catch(function (error) {
      let message = "Can't get books by Category !";
      if (error.response) {
        message = error.response.data.message;
      }
            //else message = "Connection failed ! Please try again later";
      alert(message);	
    });
  }
  const handleAddtoCart = (index) =>{
    if(localStorage.getItem('token') === null) return;
    var cart = {};
    var cartPK= {};
    cartPK.bookId = books[index].bookId;
    cartPK.customerId = JSON.parse(localStorage.getItem('information')).customerId;
    cart.cartPK = cartPK;
    cart.quantity = 1;
    addCart(cart);
  }
    return (
        <main class="main-content">
    <div class="product-area product-grid-area">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 order-0 order-lg-1">
           
            <div class="tab-content" id="nav-tabContent">
              <div class="tab-pane fade show active" id="column-three" role="tabpanel" aria-labelledby="column-three-tab">
                <div class="row">
                  {books.map((obj, index) => (
                    <div class="col-sm-6 col-md-4">
                    <div class="product-item">
                      <div class="product-thumb">
                      <img src = {obj.image} alt="Image"/>
                        <div class="product-action">
                          <a class="action-quick-view" onClick={() => handleAddtoCart(index)}><i class="ion-ios-cart"></i></a>
                          <Link class="action-quick-view" to={"/books/"+ obj.bookId}><i class="ion-arrow-expand"></i></Link>
                        </div>
                      </div>
                      <div class="product-info">
                        <div class="rating">
                          <Star star = {obj.avgRating}/>
                        </div>
                        <h4 class="title"><Link to={"/books/"+ obj.bookId}>{obj.bookTitle}</Link></h4>
                        <div class="prices">
                          <span class="price">{fomatMoney(obj.price)}</span>
                        </div>
                      </div>
                    </div>
                  </div>
                  ))}
                  
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-3 order-1 order-lg-0">
            <div class="sidebar-area shop-sidebar-area">
              <div class="widget-item">
                <div class="widget-title">
                  <h3 class="title">Categories</h3>
                </div>
                <div class="widget-body">
                  <div class="widget-categories">
                    <ul>
                      {categories.map((obj, index) => (
                        <li><a onClick={()=> getBooksByCategory(obj.categoryId)}>{obj.categoryName} </a></li>
                      ))}
                    </ul>
                  </div>
                </div>
              </div>
              
              <div class="widget-item mb-md-0">
                <div class="widget-title">
                  <h3 class="title">Authors</h3>
                </div>
                <div class="widget-body">
                  <div class="widget-size">
                  <ul>
                    {authors.map((obj, index) => (
                      <div class="form-check">
                      <input class="form-check-input black" type="checkbox" name="colorRadio2" id="colorRadio8" checked/>
                      <li><a onClick={()=> getBooksByAuthor(obj.authorId)}>{obj.authorName} </a></li>
                    </div>
                    ))}
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
    );
}