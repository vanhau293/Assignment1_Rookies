import React, { useState } from "react";
import { post } from "../callApi";
import { Link, useNavigate } from "react-router-dom";
import { Input, Form, FormGroup, FormFeedback, FormText } from "reactstrap";


export default function Login(props){
    const navigate = useNavigate();
    const [account, setAccount] = useState({
        username : '',
        password : ''
    });
    let [user, setUser] = useState();
    const handleUsername = event => {
        account.username = event.target.value
        console.log(event.target.value);
        setAccount(account)
    };

    const handlePassword = event => {
        account.password = event.target.value
        setAccount(account)
        console.log(account.password);
    };
    const handleLogin =  (e) =>{
        e.preventDefault();
        post("/auth/login", account)
        .then(function (response) {
            if (response.status === 200) {
                alert("Hello, "+ response.data.username);
                localStorage.setItem('user', JSON.stringify(response.data))
                localStorage.setItem('token', response.data.token);
                localStorage.setItem('role', response.data.role);
                localStorage.setItem('isLogin', 'true');
                alert("Hello, "+ response.data.username);
                props.onLoginChange(response.data.role, true);
                if(response.data.role === "ADMIN"){
                    navigate('/manage/orders');
                } 
                else {
                    navigate('/', {replace: true});
                }
            }
		})
		.catch(function (error) {
			let message = "Sign in failed!";
            if (!error.response) message = error.response.data.message;
            else {
                message = error.response.data.message;
			}
			alert(message);	
		});
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
                        {/* <FormGroup className="position-relative">
                            
                            <Input valid />
                            <FormFeedback
                            tooltip
                            valid
                            >
                            Sweet! that name is available
                            </FormFeedback>
                            <FormText>
                            Example help text that remains unchanged.
                            </FormText>
                        </FormGroup>
                        <FormGroup className="position-relative">
                            
                            <Input invalid />
                            <FormFeedback tooltip>
                            Oh noes! that name is already taken
                            </FormFeedback>
                            <FormText>
                            Example help text that remains unchanged.
                            </FormText>
                        </FormGroup> */}
                        <div class="login-register-input">
                            <input type="text" defaultValue={account.username} name="user-name" placeholder="Username"
                            onChange={handleUsername}/>
                        </div>
                        <div class="login-register-input">
                            <input type="password" defaultValue={account.password} name="user-password" placeholder="Password"
                            onChange={handlePassword}/>
                            
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
                        <form action="#" method="post">
                        <div class="login-register-input">
                            <input type="text" name="user-name" placeholder="Username"/>
                        </div>
                        <div class="login-register-input">
                            <input type="text" name="user-name" placeholder="E-mail address"/>
                        </div>
                        <div class="login-register-input">
                            <input type="password" name="user-password" placeholder="Password"/>
                        </div>
                        <div class="login-register-paragraph">
                            <p>Your personal data will be used to support your experience throughout this website, to manage access to your account, and for other purposes described in our <a href="#">privacy policy.</a></p>
                        </div>
                        <div class="btn-style-3">
                            <button class="btn" onclick="window.location.href='my-account.html'" type="button">Register</button>
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