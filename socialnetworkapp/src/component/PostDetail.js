import { useEffect, useState } from "react";
import { Alert, Button, Card, Col, Form, Row } from "react-bootstrap";
import MySpinner from "../layout/MySpinner";
import { Link, useParams } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import Image from 'react-bootstrap/Image';
import Moment from "react-moment";

const PostDetail = () => {
    const {postId} = useParams();
    const [post, setPost] = useState(null);
    const [comment, setComment] = useState(null);

    useEffect(() => {
        const loadPost = async () => {
            let {data} = await Apis.get(endpoints['postDetail'](postId));
            setPost(data); 
        }
        const loadComment = async () => {
            try {
                let e = endpoints['listCommentByPostId'](postId);
                let res = await Apis.get(e);
                setComment(res.data);
               } catch (ex) {
                   console.error(ex);
               }
            // let {data} = await Apis.get(endpoints['listCommentByPostId'](postId));
            // setComment(data); 
        }

  
        loadPost();
        loadComment();

    }, [postId]);

    if (post === null) 
    return <MySpinner />

    // if (comment === null) 
    // return <MySpinner />
    // if (comment.length === 0)
    // return <Alert variant="info" className="mt-1">Không có bình luận nào!</Alert>

        return (
            <>
            <h1 className="text-center text-info mt-2">NỘI DUNG BÀI VIẾT({postId})</h1>
            <Row>

                <Col xs={12}  className="mt-2 mb-2">
                            <Card style={{ width: '80rem' }}>
                                    <Card.Body>
                                    
                                        <div style={{display:"flex"}}>
                                            <Image variant="top" style={{height: "40px", width: "40px" ,marginRight:"10px"}} src={post.userId.avatar} roundedCircle />
                                            <Card.Text style={{color:"blue"}}>{post.userId.lastName} {post.userId.firstName} </Card.Text>
                                        
                                    
                                            <Moment locale="vi" style={{marginLeft : "auto"}} fromNow>{post.createdAt}</Moment>
                                        
                                        </div>
                                        <hr></hr>
                                        <Card.Title>{post.title}</Card.Title>
                                        <Card.Text> {post.content}  </Card.Text>
                                    
                                    </Card.Body>
                            </Card>          
                        </Col>
             
        </Row>
        <Form >
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Control type="text" placeholder="Nhập nội dung..." />
            </Form.Group>  
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Button variant="info" type="submit">Bình luận</Button>
            </Form.Group>
        </Form>
        <Row>
        <h5>Nội dung bình luận</h5>
            { comment !== null ? <> 
                {comment.map(c => {
                return <Col xs={12}  className="mt-2 mb-2">

                        
                         <Card style={{ width: '80rem' }}>
                            <Card.Body>
                              
                            <div style={{display:"flex"}}>
                            <Image variant="top" style={{height: "40px", width: "40px" ,marginRight:"10px"}} src={c.userId.avatar} roundedCircle />
                            <Card.Text style={{color:"blue"}}>{post.userId.lastName} {c.userId.firstName} </Card.Text>
                                            
                                
                            <Moment locale="vi" style={{marginLeft : "auto"}} fromNow>{c.createdAt}</Moment>
                                    
                            </div>
                            <hr></hr>
                            <Card.Text> {c.content}  </Card.Text>
                                
                            </Card.Body>
                         </Card>          
                        </Col>
               
                })}
                </>:
                <>
                    <Card.Title>Không có bình luận nào</Card.Title>
                </>}

        </Row>
        </>
    )  
   
}

export default PostDetail;