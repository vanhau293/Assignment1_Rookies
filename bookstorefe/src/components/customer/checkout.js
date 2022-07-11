import React from "react";

export default function Checkout(){
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
                <div class="col-lg-12">
                    <div class="checkout-coupon-wrap mb-65 mb-md-40">
                    <p class="cart-page-title"><i class="ion-ios-pricetag-outline"></i> Have a coupon? <a class="checkout-coupon-active" href="#/">Click here to enter your code</a></p>
                    <div class="checkout-coupon-content">
                        <form action="#">
                        <p>If you have a coupon code, please apply it below.</p>
                        <input type="text" placeholder="Coupon code"/>
                        <button type="submit">Apply coupon</button>
                        </form>
                    </div>
                    </div>
                </div>
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
                            <label>Company name (optional) <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                        </div>
                        </div>
                        <div class="col-12">
                        <div class="billing-select mb-20">
                            <label>Country / Region <abbr class="required" title="required">*</abbr></label>
                            <div class="select-style">
                            <select class="select-active">
                                <option>Bangladesh</option>
                                <option>Bahrain</option>
                                <option>Azerbaijan</option>
                                <option>Barbados</option>
                                <option>Barbados</option>
                            </select>
                            </div>
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
                            <label>Town / City <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                        </div>
                        </div>
                        <div class="col-12">
                        <div class="billing-select mb-20">
                            <label>District <abbr class="required" title="required">*</abbr></label>
                            <div class="select-style">
                            <select class="select-active">
                                <option>Select an option…</option>
                                <option>Barguna</option>
                                <option>Bandarban</option>
                                <option>Barbados</option>
                                <option>Barbados</option>
                            </select>
                            </div>
                        </div>
                        </div>
                        <div class="col-12">
                        <div class="billing-info mb-20">
                            <label>Postcode / ZIP (optional) <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                        </div>
                        </div>
                        <div class="col-12">
                        <div class="billing-info mb-20">
                            <label>Phone <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                        </div>
                        </div>
                        <div class="col-12">
                        <div class="billing-info mb-20">
                            <label>Email Address <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                        </div>
                        </div>
                    </div>
                    <div class="checkout-account">
                        <input class="checkout-toggle" type="checkbox"/>
                        <span>Ship to a different address?</span>
                    </div>
                    <div class="different-address open-toggle mt-30">
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
                            <label>Company name (optional) <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="billing-select mb-20">
                            <label>Country / Region <abbr class="required" title="required">*</abbr></label>
                            <div class="select-style">
                                <select class="select-active">
                                <option>Bangladesh</option>
                                <option>Bahrain</option>
                                <option>Azerbaijan</option>
                                <option>Barbados</option>
                                <option>Barbados</option>
                                </select>
                            </div>
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
                            <label>Town / City <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="billing-select mb-20">
                            <label>District <abbr class="required" title="required">*</abbr></label>
                            <div class="select-style">
                                <select class="select-active">
                                <option>Select an option…</option>
                                <option>Barguna</option>
                                <option>Bandarban</option>
                                <option>Barbados</option>
                                <option>Barbados</option>
                                </select>
                            </div>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="billing-info mb-20">
                            <label>Postcode / ZIP (optional) <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="billing-info mb-20">
                            <label>Phone <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="billing-info mb-20">
                            <label>Email Address <abbr class="required" title="required">*</abbr></label>
                            <input type="text"/>
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="additional-info-wrap">
                        <label>Order notes (optional)</label>
                        <textarea placeholder="Notes about your order, e.g. special notes for delivery. " name="message"></textarea>
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
                            <li>Brother Hoodies in Grey × 4 <span>$140.00 </span></li>
                            <li>Enjoy The Rest T-Shirt × 1 <span>$39.59 </span></li>
                            </ul>
                        </div>
                        <div class="your-order-subtotal">
                            <h3>Subtotal <span>$617.59</span></h3>
                        </div>
                        <div class="your-order-shipping">
                            <span>Shipping</span>
                            <ul>
                            <li><input type="radio" name="shipping" value="info" checked="checked"/><label>Free shipping</label></li>
                            <li><input type="radio" name="shipping" value="info" checked="checked"/><label>Flat rate: <span>$100.00</span></label></li>
                            <li><input type="radio" name="shipping" value="info" checked="checked"/><label>Local pickup: <span>$120.00</span></label></li>
                            </ul>
                        </div>
                        <div class="your-order-total">
                            <h3>Total <span>$617.59 </span></h3>
                        </div>
                        </div>
                        <div class="payment-method">
                        <div class="pay-top sin-payment">
                            <input id="payment_method_1" class="input-radio" type="radio" value="cheque" checked="checked" name="payment_method"/>
                            <label for="payment_method_1"> Direct Bank Transfer </label>
                            <div class="payment-box payment_method_bacs">
                            <p>Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order will not be shipped until the funds have cleared in our account.</p>
                            </div>
                        </div>
                        <div class="pay-top sin-payment">
                            <input id="payment-method-2" class="input-radio" type="radio" value="cheque" name="payment_method"/>
                            <label for="payment-method-2">Check payments</label>
                            <div class="payment-box payment_method_bacs">
                            <p>Please send a check to Store Name, Store Street, Store Town, Store State / County, Store Postcode.</p>
                            </div>
                        </div>
                        <div class="pay-top sin-payment">
                            <input id="payment-method-3" class="input-radio" type="radio" value="cheque" name="payment_method"/>
                            <label for="payment-method-3">Cash on delivery </label>
                            <div class="payment-box payment_method_bacs">
                            <p>Pay with cash upon delivery. </p>
                            </div>
                        </div>
                        <div class="pay-top sin-payment sin-payment-3">
                            <input id="payment-method-4" class="input-radio" type="radio" value="cheque" name="payment_method"/>
                            <label for="payment-method-4">PayPal <img alt="" src="assets/img/icons/payment-3.png"/><a href="#">What is PayPal?</a></label>
                            <div class="payment-box payment_method_bacs">
                            <p>Pay via PayPal; you can pay with your credit card if you don’t have a PayPal account.</p>
                            </div>
                        </div>
                        </div>
                        <div class="payment-condition">
                        <p>Your personal data will be used to process your order, support your experience throughout this website, and for other purposes described in our <a href="#">privacy policy</a>.</p>
                        </div>
                        <div class="payment-checkbox">
                        <input class="checkout-toggle" type="checkbox"/>
                        <span>Ship to a different address? <a href="#">terms and conditions *</a></span>
                        </div>
                    </div>
                    <div class="place-order">
                        <a href="#/">Place Order</a>
                    </div>
                    </div>
                </div>
                </div>
            </div>
            </section>
        </div>
    );
}