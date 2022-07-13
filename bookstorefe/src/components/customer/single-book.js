import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { get, postWithAuth} from "../../callApi";
import Star from "../star-rating";
export function fomatMoney(n){
    if(n<1000) return n+' VND';
    if(n>=1000){
      if(n%1000 >=100) return Math.floor(n/1000) +' '+n%1000 +' VND';
      else if (n%1000 >= 10) return Math.floor(n/1000) +' 0'+n%1000+' VND';
      else return Math.floor(n/1000) +' 00'+n%1000+' VND';
    }
}
export function addCart(cart){
    postWithAuth("/customers/cart", cart)
    .then(function (response) {
        alert(response.data.message);
      })
      .catch(function (error) {
        let message = "Can't add Cart !";
        if (!error.response) {
          message = error.response.data.message;
        }
              //else message = "Connection failed ! Please try again later";
        alert(message);	
      });
    }
export default function SingleBook(){
    const [book, setBook] = useState([]);
    let {id} = useParams();
    const [reviews, setReviews] = useState([]);
    const [categoryName, setCategoryName]= useState("");
    const [star, setStar] = useState(5);
    let quantity = 1;
    function getBook(id){
        get("/books/"+id)
        .then(function (response) {
          setBook(response.data);
          setReviews(response.data.reviewsCollection);
          setCategoryName(response.data.categoryId.categoryName);
          
          setStar(response.data.avgRating);
        })
        .catch(function (error) {
          let message = "Can't get Book !";
          if (error.response) {
            message = error.response.data.message;
          }
                //else message = "Connection failed ! Please try again later";
          alert(message);	
        });
      }
    useEffect(()=>{
        getBook(id);
        //console.log(Object.keys(book.reviewsCollection).length);
    },[id])
    
    
    
    const handleAddtoCart = () => {
        if(localStorage.getItem('token') === null) return;
      
        var cart = {};
        var cartPK= {};
        cartPK.bookId = id;
        cartPK.customerId = JSON.parse(localStorage.getItem('information')).customerId;
        cart.cartPK = cartPK;
        cart.quantity = quantity;
        console.log(cart);
        addCart(cart);
    }
    return (
        <main class = "main-content">
            
            <section class="product-single-area">
                <div class="container">
                    <div class="row">
                    <div class="col-sm-12 col-md-8 offset-md-2 col-lg-6 offset-lg-0">
                        <div class="single-product-slider">
                        <div class="single-product-thumb">
                            <div class="swiper-container single-product-thumb-slider">
                            <div class="swiper-wrapper">
                                <div class="swiper-slide zoom zoom-hover">
                                <div class="thumb-item">
                                    <a class="lightbox-image" data-fancybox="gallery" href="assets/img/shop/details/1.jpg">
                                    <img src={book.image} alt="Image-HasTech"/>
                                    </a>
                                </div>
                                </div>
                            </div>
                            </div>
                        </div>
                        
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="single-product-info">
                        <h4 class="title">{book.bookTitle}</h4>
                        <div class="prices">
                            <span class="price">{fomatMoney(book.price)}</span>
                        </div> 
                        <div class="product-rating">
                            <div class="rating">
                                <Star star = {star}/>
                            </div>
                            <div class="review">
                            <a >({reviews.length} Customer Review)</a>
                            </div>
                        </div>
                        <div class="single-product-featured">
                            <ul>
                            <li><i class="fa fa-check"></i> Free Shipping</li>
                            <li><i class="fa fa-check"></i> Support 24/7</li>
                            <li><i class="fa fa-check"></i> Money Return</li>
                            </ul>
                        </div>
                        <p class="product-desc">{(book.description)}</p>
                        <div class="quick-product-action">
                            <div class="action-top">
                            <div class="pro-qty">
                                <input type="number" id="quantity" title="Quantity" defaultValue={1} onChange={event => (quantity = event.target.value)} min="1" />
                            </div>
                            <button class="btn btn-theme" onClick={()=> handleAddtoCart()}>Add to Cart</button>
                            
                            </div>
                        </div>
                        <div class="widget">
                            <h3 class="title">Publisher:</h3>
                            <div class="widget-tags">
                            <span> {book.publisher}</span>
                            </div>
                        </div>
                        <div class="widget">
                            <h3 class="title">Categories:</h3>
                            <div class="widget-tags">
                            <a > {categoryName}</a>
                            </div>
                        </div>
                        <div class="widget">
                            <h3 class="title">Total Page:</h3>
                            <div class="widget-tags">
                            <a > {book.totalPage}</a>
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                        <div class="product-description-review">
                            <ul class="nav nav-tabs product-description-tab-menu" id="myTab" role="tablist">
                            
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active" id="product-desc-tab" data-bs-toggle="tab" data-bs-target="#productDesc" type="button" role="tab" aria-controls="productDesc" aria-selected="true">Description</button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="product-review-tab" data-bs-toggle="tab" data-bs-target="#productReview" type="button" role="tab" aria-controls="productReview" aria-selected="false">Reviews ({reviews.length})</button>
                            </li>
                            </ul>
                            <div class="tab-content product-description-tab-content" id="myTabContent">
                            
                            <div class="tab-pane fade show active" id="productDesc" role="tabpanel" aria-labelledby="product-desc-tab">
                                <div class="product-desc">
                                <p>{book.description}</p>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="productReview" role="tabpanel" aria-labelledby="product-review-tab">
                                <div class="product-review">
                                <div class="review-header">
                                    <h4 class="title">Write a review</h4>
                                </div>
                                    
                                    <form action="#" method="post">
                                    <div class="review-form-content">
                                        <div class="row">
                                        
                                        <div class="col-md-12">
                                            <div class="rating">
                                            <span class="rating-title">Rating</span>
                                            <span>
                                                <a class="fa fa-star-o" href="#/"></a>
                                                <a class="fa fa-star-o" href="#/"></a>
                                                <a class="fa fa-star-o" href="#/"></a>
                                                <a class="fa fa-star-o" href="#/"></a>
                                                <a class="fa fa-star-o" href="#/"></a>
                                            </span>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-12">
                                            <div class="form-group">
                                            <label for="reviewFormTextarea">Body of Review </label>
                                            <textarea class="form-control textarea" id="reviewFormTextarea" name="comment" rows="7" placeholder="Write your comments here" required=""></textarea>
                                            </div>
                                        </div>
                                        </div>
                                        <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group pull-right">
                                            <button class="btn btn-theme" type="submit">Submit Review</button>
                                            </div>
                                        </div>
                                        </div>
                                    </div>
                                    </form>
                                    {reviews.map((obj, index) => (
                                        <div class="review-content">
                                            <div class="review-item">
                                            <ul class="review-rating">
                                                <Star star = {obj.starRating}/>
                                            </ul>
                                            <h4 class="review-date"><span>{obj.customerEntity.name}</span> on <span>{obj.createdDate}</span></h4>
                                            <p>{obj.comment}</p>
                                            </div>
                                        </div>
                                    ))}
                                
                                
                                </div>
                            </div>
                            </div>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
                </section>
        </main>
    );
}