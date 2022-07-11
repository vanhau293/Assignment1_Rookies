import axios from "axios";

const url_start ="http://localhost:8080"

export function get(url) {
    const axios = require('axios');
    return axios.get(url_start + url, {
        headers: {
            "Access-Control-Allow-Origin": "*",
            "accept": "application/json"
        },
    });
}
// export function getwithAuthtication(url){
//     return axios.get(url_start + url ,{
//         headers:{
//             Authorization: `Bearer ${getCookie("token")}`,
//             "Access-Control-Allow-Origin": "*",
//             'Content-Type': 'application/json; charset=utf-8',
//         },
//     });
// }
export function post(url, body) {
    return axios.post(url_start + url, body, {
        headers: {
            "Access-Control-Allow-Origin": "*",
            'Content-Type': 'application/json; charset=utf-8',
        },
    });
}