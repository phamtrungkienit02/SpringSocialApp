import {  useContext, useState } from "react";
// useContext,
import { Button, Form } from "react-bootstrap";
import cookie from "react-cookies";
// import {  useSearchParams } from "react-router-dom";
// useNavigate,
// import { MyUserContext } from "../App";
import Apis, { authApi, endpoints } from "../configs/Apis";
import { MyUserContext } from "../App";
import { Navigate } from "react-router-dom";

import firebase,  { auth } from "../firebase/Config";




const Login = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    // const [q] = useSearchParams();
    const fbProvider = new firebase.auth.FacebookAuthProvider();

    const fbLogin = () => {
        auth.signInWithPopup(fbProvider);
    }

    // auth.onAuthStateChanged((user) => {
    //     console.log({user});
    // });

    
    
    const login = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                let res = await Apis.post(endpoints['login'], {
                    "username": username,
                    "password": password
                });
                console.info(res.data);

                //tiến hành lưu token mà server gửi về khi đăng nhập thành công trên cookie
                cookie.save("token", res.data);
                
                
                let {data} = await authApi().get(endpoints['current-user']);
                cookie.save("user", data);

                
                //phát tín hiệu cho reducer
                dispatch({
                    "type": "login",
                    "payload": data
                });
            } catch (err) {
                console.error(err);
            }
        }
        //gọi hàm
        process();
    
    }

    //đăng nhập rồi về trang chủ
    if (user !== null) {
        // let next = q.get("next") || "/";
        return <Navigate to="/" />
        // return <Navigate to={next} />
    }

    return <>
        <h1 className="text-center text-info">ĐĂNG NHẬP NGƯỜI DÙNG</h1>

        
        <Form onSubmit={login}>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control value={username} onChange={e => setUsername(e.target.value)} type="text" placeholder="Tên đăng nhập" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control value={password} onChange={e => setPassword(e.target.value)} type="password" placeholder="Mật khẩu" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Button variant="info" type="submit">Đăng nhập</Button>
            </Form.Group>
        </Form>


        {/* <Button onClick={fbLogin}>Đăng nhập bằng Facebook</Button> */}
        <Button>Đăng nhập bằng gmail</Button>
    </>
}

export default Login;