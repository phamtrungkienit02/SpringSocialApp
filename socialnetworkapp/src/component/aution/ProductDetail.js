
import { useContext, useEffect, useState } from "react";
import { Button, Col, Form, Image, ListGroup, Row } from "react-bootstrap";
import Moment from "react-moment";
import { Link, useParams } from "react-router-dom";
import { MyUserContext } from "../../App";
import Apis, { authApi, endpoints } from "../../configs/Apis";
import MySpinner from "../../layout/MySpinner";
import ChatWindow from "./ChatWindow";

const ProductDetails = () => {
    // const [user, ] = useContext(MyUserContext);
    const {productId} = useParams();
    const [product, setProduct] = useState(null);
    // const [comments, setComments] = useState(null);
    // const [content, setContent] = useState();

    useEffect(() => {
        const loadProduct = async () => {
            let {data} = await Apis.get(endpoints['details'](productId));
            setProduct(data); 
        }

        // const loadComments = async () => {
        //     let {data} = await Apis.get(endpoints['comments'](productId));
        //     setComments(data);
        // }

        loadProduct();
    //     loadComments();
    }, [productId]);

    // // const addComment = () => {
    //     const process = async () => {
    //         let {data} = await authApi().post(endpoints['add-comment'], {
    //             "content": content, 
    //             "product": product.id
    //         });

    //         setComments([...comments, data]);
    //     }

    //     process();
    // }


    // || comments === null
    if (product === null )
        return <MySpinner /> ;

    // let url = `/login?next=/products/${productId}`;
    return <div>
        {/* <h1 className="text-center text-info mt-2">CHI TIẾT SẢN PHẨM ({productId})</h1> */}
        <Row>
            {/* <Col md={5} xs={6}>
                <ChatWindow/>
            </Col> */}
            <Col md={5} xs={6}>
                <Row>
                    <Col>
                        <Image src={product.image} rounded fluid />
                    </Col>
                    <Col>
                        <h2 className="text-danger">Tên sản phẩm: {product.name}</h2>
                        <p>Mô tả: {product.description}</p>
                        <h3>Giá bắt đầu: {product.startingPrice} VNĐ</h3>
                    </Col>
                </Row>
            </Col>   
        </Row>
        <br />
        

        {/* {user===null?<p>Vui lòng <Link to={url}>đăng nhập</Link> để bình luận! </p>:<>
        <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Nội dung bình luận" />
        <Button onClick={addComment} className="mt-2" variant="info">Bình luận</Button>
        </>}
        <hr />
        <ListGroup>
            {comments.map(c => <ListGroup.Item id={c.id}>
                        {c.user.username} - {c.content} - <Moment locale="vi" fromNow>{c.createdDate}</Moment>
                    </ListGroup.Item>)
            }
        </ListGroup> */}
    </div>
}

export default ProductDetails;