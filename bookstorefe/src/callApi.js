import axios from "axios";

const url_start ="https://bookstoreapi-rookies.herokuapp.com"

export function get(url) {
    const axios = require('axios');
    return axios.get(url_start + url, {
        headers: {
            "Access-Control-Allow-Origin": "*",
            "accept": "application/json"
        },
    });
}
export function getwithAuthtication(url){
    return axios.get(url_start + url ,{
        headers:{
            Authorization: `Bearer ${localStorage.getItem('token')}`,
            "Access-Control-Allow-Origin": "*",
            'Content-Type': 'application/json; charset=utf-8',
        },
    });
}
export function post(url, body) {
    return axios.post(url_start + url, body, {
        headers: {
            "Access-Control-Allow-Origin": "*",
            'Content-Type': 'application/json; charset=utf-8',
        },
    });
}
export function postWithAuth(url, body) {
    return axios.post(url_start + url, body, {
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
            "Access-Control-Allow-Origin": "*",
            'Content-Type': 'application/json; charset=utf-8',
        },
    });
}
export function putWithAuth(url, body){
    const axios = require('axios');
    let req = {
        url: url,
        method: 'PUT',
        data: body,
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
            "Access-Control-Allow-Origin": "*",
            'Content-Type': 'application/json; charset=utf-8'
        }
      }
    return axios(req);
}