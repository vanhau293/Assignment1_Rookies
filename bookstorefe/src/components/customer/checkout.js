import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { getwithAuthtication, postWithAuth } from "../../callApi";
import { fomatMoney } from "./single-book";

export default function Checkout(){
    const [cart, setCart] = useState([]);
    const navigate = useNavigate();
    const [total, setTotal] = useState(0);
    const getCart = ()=>{
        getwithAuthtication("/customers/"+JSON.parse(localStorage.getItem('information')).customerId+"/cart")
        .then(function (response) {
            if(response.data.length===0){
                navigate('/');
            }
            setTotal(0);
            Object.keys(response.data).forEach( function(key) {
                setTotal(total + (response.data[key].quantity*response.data[key].bookEntity.price));
            })
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
    const addOrder = (order)=>{
        postWithAuth('/orders', order)
        .then(function (response) {
            alert(response.data.message);
          })
          .catch(function (error) {
            let message = "Can't add Order !";
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
        
    },[]);
    const handleClickOrder = ()=> {
        var order = {};
        var customerId = {};
        customerId.customerId = JSON.parse(localStorage.getItem('information')).customerId;
        order.listCart = cart;
        order.customerId = customerId;
        addOrder(order);
        navigate('/books');
    }
    return (
        <div>
            <section class="product-area shop-checkout-area">
            <div class="container">
                <div class="row">
                <div class="col-lg-6 m-auto">
                    <div class="section-title text-center">
                    <h2 class="title">Checkout</h2>
                    </div>
                </div>
                </div>
                <div class="row">
                
                </div>
                <div class="row">
                <div class="col-lg-7">
                    <div class="billing-info-wrap">
                    <h3>Billing Details</h3>
                    <div class="row">
                        <div class="col-12">
                        <div class="billing-info mb-20">
                            <label>First name <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                        </div>
                        </div>
                        <div class="col-12">
                        <div class="billing-info mb-20">
                            <label>Last name <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                        </div>
                        </div>
                        <div class="col-12">
                        <div class="billing-info mb-20">
                            <label>Street Address <abbr class="required" title="required">*</abbr></label>
                            <input class="billing-address" placeholder="House number and street name" type="text"/>
                            <input placeholder="Apartment, suite, unit, etc. (optional)" type="text"/>
                        </div>
                        </div>
                        <div class="col-12">
                        <div class="billing-info mb-20">
                            <label>Phone <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                        </div>
                        </div>
                       
                    </div>
                    
                    </div>
                    </div>
                <div class="col-lg-5">
                    <div class="your-order-area">
                    <h3>Your order</h3>
                    <div class="your-order-wrap">
                        <div class="your-order-info-wrap">
                        <div class="your-order-title">
                            <h4>Product <span>Subtotal</span></h4>
                        </div>
                        <div class="your-order-product">
                            <ul>
                                {cart.map((obj,index) => (
                                    <li>{obj.bookEntity.bookTitle} x{obj.quantity}<span>{fomatMoney(obj.bookEntity.price*obj.quantity)} </span></li>
                                ))}
                            
                            </ul>
                        </div>
                        
                        <div class="your-order-total">
                            <h3>Total <span>{fomatMoney(total)} </span></h3>
                        </div>
                        </div>
                        
                    </div>
                    <div class="place-order">
                        <a onClick={handleClickOrder}>Place Order</a>
                    </div>
                    </div>
                </div>
                </div>
            </div>
            </section>
        </div>
    );
}