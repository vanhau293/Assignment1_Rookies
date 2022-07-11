import React from "react";

export default function Cart(){
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
                                <tr>
                                <td class="product-thumbnail">
                                    <a href="shop-single-product.html"><img src="assets/img/shop/details/nav1.jpg" alt="Image"/></a>
                                </td>
                                <td class="product-name">
                                    <h5><a href="shop-single-product.html">Jigsaw Puzzles For Kids</a></h5>
                                </td>
                                <td class="product-price"><span class="amount">$120.00</span></td>
                                <td class="cart-quality">
                                    <div class="product-details-quality">
                                    <input type="number" class="input-text qty text" step="1" min="1" max="100" name="quantity" value="1" title="Qty" placeholder=""/>
                                    </div>
                                </td>
                                <td class="product-total"><span>$120.00</span></td>
                                <td class="product-remove"><a href="#"><i class="ion-ios-trash-outline"></i></a></td>
                                </tr>
                                <tr>
                                <td class="product-thumbnail">
                                    <a href="shop-single-product.html"><img src="assets/img/shop/details/nav2.jpg" alt="Image"/></a>
                                </td>
                                <td class="product-name">
                                    <h5><a href="shop-single-product.html">Bruder Toys Mini Ships</a></h5>
                                </td>
                                <td class="product-price"><span class="amount">$120.00</span></td>
                                <td class="cart-quality">
                                    <div class="product-details-quality">
                                    <input type="number" class="input-text qty text" step="1" min="1" max="100" name="quantity" value="1" title="Qty" placeholder=""/>
                                    </div>
                                </td>
                                <td class="product-total"><span>$120.00</span></td>
                                <td class="product-remove"><a href="#"><i class="ion-ios-trash-outline"></i></a></td>
                                </tr>
                                <tr>
                                <td class="product-thumbnail">
                                    <a href="shop-single-product.html"><img src="assets/img/shop/details/nav3.jpg" alt="Image"/></a>
                                </td>
                                <td class="product-name">
                                    <h5><a href="shop-single-product.html">Sassy Crib and Floor Mirror</a></h5>
                                </td>
                                <td class="product-price"><span class="amount">$120.00</span></td>
                                <td class="cart-quality">
                                    <div class="product-details-quality">
                                    <input type="number" class="input-text qty text" step="1" min="1" max="100" name="quantity" value="1" title="Qty" placeholder=""/>
                                    </div>
                                </td>
                                <td class="product-total"><span>$120.00</span></td>
                                <td class="product-remove"><a href="#"><i class="ion-ios-trash-outline"></i></a></td>
                                </tr>
                            </tbody>
                        </table>
                        </div>
                        </div>
                        <div class="cart-shiping-update-wrapper">
                        <div class="cart-shiping-btn continure-btn">
                            <a class="btn btn-link" href="shop.html"><i class="ion-ios-arrow-left"></i> Back To Shop</a>
                        </div>
                        <div class="cart-shiping-btn update-btn">
                            <a class="btn btn-link" href="shop.html"><i class="ion-ios-reload"></i> Back To Shop</a>
                        </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                    </div>
                    </div>
                    <div class="row">
                    <div class="col-md-6 col-lg-4">
                        <div class="cart-calculate-discount-wrap mb-40">
                        <h4>Calculate shipping </h4>
                        <div class="calculate-discount-content">
                            <div class="select-style">
                            <select class="select-active">
                                <option>Bangladesh</option>
                                <option>Bahrain</option>
                                <option>Azerbaijan</option>
                                <option>Barbados</option>
                                <option>Barbados</option>
                            </select>
                            </div>
                            <div class="select-style">
                            <select class="select-active">
                                <option>State / County</option>
                                <option>Bahrain</option>
                                <option>Azerbaijan</option>
                                <option>Barbados</option>
                                <option>Barbados</option>
                            </select>
                            </div>
                            <div class="input-style">
                            <input type="text" placeholder="Town / City"/>
                            </div>
                            <div class="input-style">
                            <input type="text" placeholder="Postcode / ZIP"/>
                            </div>
                            <div class="calculate-discount-btn">
                            <a class="btn btn-link" href="#/">Update</a>
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="cart-calculate-discount-wrap mb-40">
                        <h4>Coupon Discount </h4>
                        <div class="calculate-discount-content">
                            <p>Enter your coupon code if you have one.</p>
                            <div class="input-style">
                            <input type="text" placeholder="Coupon code"/>
                            </div>
                            <div class="calculate-discount-btn">
                            <a class="btn btn-link" href="#/">Apply Coupon</a>
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="col-md-12 col-lg-4">
                        <div class="grand-total-wrap">
                        <div class="grand-total-content">
                            <h3>Subtotal <span>$180.00</span></h3>
                            <div class="grand-shipping">
                            <span>Shipping</span>
                            <ul>
                                <li><input type="radio" name="shipping" value="info" checked="checked"/><label>Free shipping</label></li>
                                <li><input type="radio" name="shipping" value="info" checked="checked"/><label>Flat rate: <span>$100.00</span></label></li>
                                <li><input type="radio" name="shipping" value="info" checked="checked"/><label>Local pickup: <span>$120.00</span></label></li>
                            </ul>
                            </div>
                            <div class="shipping-country">
                            <p>Shipping to Bangladesh</p>
                            </div>
                            <div class="grand-total">
                            <h4>Total <span>$185.00</span></h4>
                            </div>
                        </div>
                        <div class="grand-total-btn">
                            <a class="btn btn-link" href="shop-checkout.html">Proceed to checkout</a>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
                </section>
        </div>
    );
}