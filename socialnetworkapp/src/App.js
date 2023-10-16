// import logo from './logo.svg';
// import './App.css';

import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./component/Home";
import Footer from "./layout/Footer";
import Header from "./layout/Header";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from "react-bootstrap";
import Login from "./component/Login";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";
import Register from "./component/Register";
import Posts from "./component/Posts";
import 'moment/locale/vi';
import ProductDetails from "./component/aution/ProductDetail";
import PostDetail from "./component/PostDetail";
import Livestream from "./component/Livestream/Livestream";
import Room from "./component/Livestream/Room";

export const MyUserContext = createContext();

const App = () => {
  //reducer trả 2 thứ: 1 current state, 2 dispatch: gửi tín hiệu cho reducer đã cập nhật=> update lại giao 
  //cookie.load("user") || null: xử lý khi load lại trang vẫn duy trì trạng thái hiển thị đã đăng nhập
  //trường hợp load không hiện có thể do token hết hạn
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);

  // const [cartCounter, cartDispatch] = useReducer(MyCartCounterReducer, countCart());

  return (
    <MyUserContext.Provider value={[user, dispatch]}>
      {/* <MyCartContext.Provider value={[cartCounter, cartDispatch]}> */}
      <BrowserRouter>
        <Header />
        <Container>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/posts" element={<Posts />} />
            <Route path="/livestream" element={<Livestream />} />
            <Route path="/livestream/room/:roomId" element={<Room />} />
            {/* <Route path="/cart" element={<Cart />} /> */}
            <Route path="/products/:productId" element={<ProductDetails />} />
            <Route path="/posts/:postId" element={<PostDetail />} />
            
          </Routes>
        </Container>
        <Footer />
      </BrowserRouter>
      {/* </MyCartContext.Provider> */}
    </MyUserContext.Provider>
  )
}

export default App;