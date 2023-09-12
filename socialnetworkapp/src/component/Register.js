import { useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";


//Tạo thêm api kiểm tra username
const Register = () => {
    const [user, setUser] = useState({
        "username": "", 
        "password": "", 
        "firstName": "", 
        "lastName": "", 
        "email": "",
        "phone": "",
        "confirmPass": ""
    });
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const avatar = useRef();
    const nav = useNavigate();

    const register = (evt) => {
        evt.preventDefault();

        const process = async () => {
            //vì có avatar nên dùng form
            let form = new FormData();

            for (let field in user)
                if (field !== "confirmPass")
                    form.append(field, user[field]);

            form.append("avatar", avatar.current.files[0]);

            setLoading(true)
            let res = await Apis.post(endpoints['register'], form);
            if (res.status === 201) {
                nav("/login");
                // <Alert variant="success"> Đăng kí thành công!</Alert>
            } else
            setErr("Hệ thống bị lỗi!");
        }

        if (user.password === user.confirmPass)
            process();
        else {
            setErr("Mật khẩu KHÔNG khớp!");
        }
        //xử lí username đã tồn tại gọi api
    }

    const change = (evt, field) => {
        //lấy lấy user và chỉ ghi đè lên field
        //nếu {...current, field: evt.target.value}=> ghi đè field; [field]=>lấy giá trị của field
        // setUser({...user, [field]: evt.target.value})
        
        //current: trạng thái hiện tại
        setUser(current => {
            return {...current, [field]: evt.target.value}
        })
    }

    return <>
        <h1 className="text-center text-info mt-2">ĐĂNG KÝ NGƯỜI DÙNG</h1>

        {err === null ? "" : <Alert variant="danger">{err}</Alert>}

        <Form onSubmit={register}>
            <Form.Group className="mb-3">
                <Form.Label>Tên</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "firstName")} placeholder="Tên" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Họ và chữ lót</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "lastName")} placeholder="Họ và chữ lót" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Email</Form.Label>
                <Form.Control type="email" onChange={(e) => change(e, "email")} placeholder="Email" required/>
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Điện thoại</Form.Label>
                <Form.Control type="tel" onChange={(e) => change(e, "phone")} placeholder="Điện thoại" required/>
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control value={user.username} onChange={(e) => change(e, "username")} type="text" placeholder="Tên đăng nhập" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control value={user.password} onChange={(e) => change(e, "password")} type="password" placeholder="Mật khẩu" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Xác nhận mật khẩu</Form.Label>
                <Form.Control value={user.confirmPass} onChange={(e) => change(e, "confirmPass")} type="password" placeholder="Xác nhận mật khẩu" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Ảnh đại diện</Form.Label>
                {/* avatar cần tham số thật */}
                <Form.Control type="file" ref={avatar}  />
            </Form.Group>
            <Form.Group className="mb-3">

                {/* đang đăng kí thì hiện spinner ngược lại hiện nút đăng ký */}
                {loading === true?<MySpinner />: <Button variant="info" type="submit">Đăng ký</Button>}
                
            </Form.Group>
        </Form>
    </>
}

export default Register;