import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/SocialApp";
const SERVER = "http://localhost:8080";
export const endpoints = {
    "categories": `${SERVER_CONTEXT}/api/categories/`,
    "products": `${SERVER_CONTEXT}/api/products/`,
    //lấy api login 
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "register": `${SERVER_CONTEXT}/api/users/`,
    "posts": `${SERVER_CONTEXT}/api/posts/`,
    "comments": `${SERVER_CONTEXT}/api/comments/`,
    // "pay": `${SERVER_CONTEXT}/api/pay/`,
    //hàm
    "listCommentByPostId": (postId) => `${SERVER_CONTEXT}/api/commentsByPostId/${postId}/`,
    "postDetail": (postId) => `${SERVER_CONTEXT}/api/posts/${postId}/`,
    "details": (productId) => `${SERVER_CONTEXT}/api/products/${productId}/`,
    // "comments": (productId) => `${SERVER_CONTEXT}/api/products/${productId}/comments/`,
    // "add-comment": `${SERVER_CONTEXT}/api/comments/`,
}

//các api này cần chứng thực
export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization":  cookie.load("token")
        }
    })
}

export default axios.create({
    //tên miền
    baseURL: SERVER
})