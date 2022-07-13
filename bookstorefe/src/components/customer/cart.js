import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { getwithAuthtication, putWithAuth } from "../../callApi";
import { fomatMoney } from "./single-book";
import { Link } from "react-router-dom";
export default function Cart(){
    const [cart, setCart] = useState([]);
    const navigate = useNavigate();
    const getCart = ()=>{
        getwithAuthtication("/customers/"+JSON.parse(localStorage.getItem('information')).customerId+"/cart")
        .then(function (response) {
            if(response.data.length===0){
                alert("Cart is empty");
                navigate('/books');
            }
            setCart(response.data);
          })
          .catch(function (error) {
            let message = "Can't get Cart !";
            if (!error.response) {
              message = error.response.data.message;
            }
                  //else message = "Connection failed ! Please try again later";
            alert(message);	
        });
        
    }

    useEffect(()=>{
        if(localStorage.getItem('token') === null){
            navigate('/');
        }
        getCart();
        
    },[cart]);
    function updateCart(cart){
        putWithAuth("/customers/cart", cart)
        .then(function (response) {
            console.log(response.data.message);
          })
          .catch(function (error) {
            console.error(error);
            let message = "Can't update Cart !";
            if (!error.response) {
              message = error.response.data.message;
            }
                  //else message = "Connection failed ! Please try again later";
            alert(message);	
        });
    }
    const handleUpdateQuantity = (index, e) =>{
        
        if(localStorage.getItem('token') === null) return;
        var cartUpdate ={};
        cartUpdate = cart[index];
        if(e.target.value === undefined) cartUpdate.quantity = 0;
        else cartUpdate.quantity = e.target.value;
        console.log(cartUpdate)
        updateCart(cartUpdate);
        getCart();
    }
    return (
        <div>
            <section class="product-area cart-page-area">
                <div class="container">
                    <div class="row">
                    <div class="col-lg-6 m-auto">
                        <div class="section-title text-center">
                        <h2 class="title">Cart</h2>
                        </div>
                    </div>
                    </div>
                    <div class="row">
                    <div class="col-lg-12">
                        <div class="cart-table-wrap">
                        <div class="cart-table table-responsive">
                            <table>
                            <thead>
                                <tr>
                                <th class="width-thumbnail"></th>
                                <th class="width-name">Product</th>
                                <th class="width-price"> Price</th>
                                <th class="width-quantity">Quantity</th>
                                <th class="width-subtotal">Subtotal</th>
                                <th class="width-remove"></th>
                                </tr>
                            </thead>
                            <tbody>
                                {cart.map((obj,index) => (

                                <tr>
                                <td class="product-thumbnail">
                                    <a href="shop-single-product.html"><img src={obj.bookEntity.image} alt="Image"/></a>
                                </td>
                                <td class="product-name">
                                    <h5><a href="shop-single-product.html">{obj.bookEntity.bookTitle}</a></h5>
                                </td>
                                <td class="product-price"><span class="amount">{fomatMoney(obj.bookEntity.price)}</span></td>
                                <td class="cart-quality">
                                    <div class="product-details-quality">
                                    <input type="number" class="input-text qty text" step="1" min="1" max="100" defaultValue={obj.quantity} title="Qty" 
                                        onChange={(e)=>handleUpdateQuantity(index, e)}/>
                                    </div>
                                </td>
                                <td class="product-total"><span>{fomatMoney(obj.quantity*obj.bookEntity.price)}</span></td>
                                <td class="product-remove"><a onClick={(e)=>handleUpdateQuantity(index, e)}><i class="ion-ios-trash-outline"></i></a></td>
                                </tr>

                                ))}
                            </tbody>
                        </table>
                        </div>
                        </div>
                        <div class="cart-shiping-update-wrapper">
                        <div class="cart-shiping-btn continure-btn">
                            <Link class="btn btn-link" to="/books"><i class="ion-ios-arrow-left"></i> Back To Shop</Link>
                        </div>
                        
                        </div>
                    </div>
                    <div class="col-lg-4">
                    </div>
                    </div>
                    <div class="row">
                    <div class="col-md-6 col-lg-4">
                        
                    </div>
                    <div class="col-md-6 col-lg-4">
                        
                    </div>
                    <div class="col-md-12 col-lg-4">
                        <div class="grand-total-wrap">
                        
                        <div class="grand-total-btn">
                            <Link class="btn btn-link" to="/checkout">Proceed to checkout</Link>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
                </section>
        </div>
    );
}