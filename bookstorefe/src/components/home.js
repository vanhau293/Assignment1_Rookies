import React, { useEffect } from "react";
import { Image } from "cloudinary-react";
import { Link } from "react-router-dom";
export default function Home(props){
    return (
        <main class="main-content">
           <section class="category-area product-category2-area" data-aos="fade-up" data-aos-duration="1000">
                <div class="container">
                    <div class="row category-items2">
                    <div class="col-md-6">
                        <div class="category-item">
                        <div class="thumb">
                            <img src = "https://res.cloudinary.com/duku7fuxt/image/upload/v1657302137/books/books_1200_lqej2t.jpg"/>
                            <div class="content">
                            <div class="contact-info">
                                <h2 class="title text-white">BOOKs</h2>
                            </div>
                            <Link class="btn-theme" to ="/books">Shop Now</Link>
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="category-item mt-sm-50">
                        <div class="thumb">
                            <img src = "https://res.cloudinary.com/duku7fuxt/image/upload/v1657302136/books/cf929df3b4640fa9e3893c370d8448cf0ffe7fbf_uipkeb.jpg"/>
                            <div class="content">
                            <div class="contact-info">
                                <h2 class="title">BOOKs</h2>
                                <h4 class="price">Sale up to <span>30%</span> Off</h4>
                            </div>
                            <Link class="btn-theme" to ="/books">Shop Now</Link>
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