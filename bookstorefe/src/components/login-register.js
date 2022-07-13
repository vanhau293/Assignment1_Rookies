import React, { useState } from "react";
import { getwithAuthtication, post } from "../callApi";
import { Link, useNavigate } from "react-router-dom";
import { Input, Form, FormGroup, FormFeedback, FormText } from "reactstrap";


export default function Login(props){
    const navigate = useNavigate();
    const [password, setPassword] = useState('');
    const [confirm, setConfirm] = useState('');
    const [account, setAccount] = useState({
        username : '',
        password : ''
    });
    const [register, setRegister] = useState({
        userName : '',
        password : '',
        name : '',
        email : '',
        phoneNumber : '',
        address : ''
    })
    const handleUsername = event => {
        account.username = event.target.value
        setAccount(account)
    };

    const handlePassword = event => {
        account.password = event.target.value
        setAccount(account)
    };
    const handleLogin =  (e) =>{
        e.preventDefault();
        post("/auth/login", account)
        .then(function (response) {
            if (response.status === 200) {
                
                localStorage.setItem('user', JSON.stringify(response.data))
                localStorage.setItem('token', response.data.token);
                localStorage.setItem('role', response.data.role);
                localStorage.setItem('isLogin', 'true');
                getInformation();
                alert("Hello, "+ JSON.parse(localStorage.getItem('information')).name + " !!!");
                props.onLoginChange(response.data.role, 'true');
                    window.location.href = "http://localhost:3000/"
                
            }
		})
		.catch(function (error) {
			let message = "Sign in failed!";
            if (error.response) {
                message = error.response.data.errors.username +"\n"+error.response.data.errors.password;
			}
            else message = "Connection failed ! Please try again later";
			alert(message);	
		});
    }
    function getInformation(){
        getwithAuthtication("/accounts/"+JSON.parse(localStorage.getItem('user')).id)
        .then(function(response){
            localStorage.setItem('information', JSON.stringify(response.data));
        })
        .catch( function(error){
            let message = "Connection failed !"
            if (error.response) {
                message = error.response.data.message;
			}
            else message = "Connection failed ! Please try again later";
			alert(message);	
        })
    }
    const handleRegister = (e) => {
        if(password !== confirm){
            alert("Confirm Password is not correct");
        } 
    }
    return (
        <section class="login-register-area">
            <div class="container">
                <div class="row">
                
                <div class="col-md-5 login-register-border">
                    <div class="login-register-content">
                    <div class="login-register-title mb-30">
                        <h2>Login</h2>
                        <p>Welcome back! Please enter your username and password to login. </p>
                    </div>
                    <div class="login-register-style login-register-pr">
                        <form onSubmit={handleLogin}>
                        <div class="login-register-input">
                            <input type="text"  name="user-name" placeholder="Username"
                            onChange={(e)=> {
                                account.username = e.target.value
                                setAccount(account)
                            }}/>
                        </div>
                        <div class="login-register-input">
                            <input type="password"  name="user-password" placeholder="Password"
                            onChange={(e) => {
                                account.password = e.target.value
                                setAccount(account)
                            }}/>
                            
                        </div>
                        <div class="btn-style-3">
                            <button class="btn" type="submit">Login</button>
                        </div>
                        </form>
                    </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="login-register-content login-register-pl">
                    <div class="login-register-title mb-30">
                        <h2>Register</h2>
                        <p>Create new account today to reap the benefits of a personalized shopping experience. </p>
                    </div>
                    <div class="login-register-style">
                        <form onSubmit={handleRegister}>
                        
                        <div class="login-register-input">
                            <input type="text" name="user-name" placeholder="Full Name" onChange={(e) => {
                                register.name = e.target.value;
                                setRegister(register)
                            }}/>
                        </div>
                        <div class="login-register-input">
                            <input type="text" name="user-name" placeholder="User Name" onChange={(e) => {
                                register.userName = e.target.value;
                                setRegister(register)
                            }}/>
                        </div>
                        <div class="login-register-input">
                            <input type="text" name="user-name" placeholder="Phone Number" onChange={(e) => {
                                register.phoneNumber = e.target.value;
                                setRegister(register)
                            }}/>
                        </div>
                        <div class="login-register-input">
                            <input type="text" name="user-name" placeholder="E-mail Address" onChange={(e) => {
                                register.email = e.target.value;
                                setRegister(register)
                            }}/>
                        </div>
                        
                        <div class="login-register-input">
                            <input type="text" name="user-name" placeholder="Address" onChange={(e) => {
                                register.address = e.target.value;
                                setRegister(register)
                            }}/>
                        </div>
                        <div class="login-register-input">
                            <input type="password" name="user-password" placeholder="Password" onChange={(e) => setPassword(e.target.value)}/>
                        </div>
                        <div class="login-register-input">
                            <input type="password" name="user-password" placeholder="Confirm Password" onChange={(e) => setConfirm(e.target.value)}/>
                        </div>
                        
                        <div class="login-register-paragraph">
                            <p>Your personal data will be used to support your experience throughout this website, to manage access to your account, and for other purposes described in our privacy policy.</p>
                        </div>
                        <div class="btn-style-3">
                            <button class="btn"  type="submit">Register</button>
                        </div>
                        </form>
                        
                    </div>
                    </div>
                </div>
                </div>
            </div>
            </section>
    );
}