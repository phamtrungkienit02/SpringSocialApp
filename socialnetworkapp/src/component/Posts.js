import { useEffect, useState } from "react";
import { Alert, Button, Card, Col, Row } from "react-bootstrap";
import MySpinner from "../layout/MySpinner";
import { Link } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import Image from 'react-bootstrap/Image';
import Moment from "react-moment";




const Posts = () => {
    const [posts, setPosts] = useState(null);

    //load bài viết:
    useEffect(() => {
        const loadPosts = async () => {
           try {
            let e = endpoints['posts'];
            let res = await Apis.get(e);
            setPosts(res.data);
           } catch (ex) {
               console.error(ex);
           }
        }
        loadPosts();
    }); 

    if (posts === null) 
    return <MySpinner />

    if (posts.length === 0)
        return <Alert variant="info" className="mt-1">Không có bài viết nào!</Alert>

    return (
        <>
        <h1 className="text-center text-info">BÀI VIẾT MỚI</h1>
        <Row>

            {posts.map(p => {
                return <Col xs={12}  className="mt-2 mb-2">
                        <Card style={{ width: '80rem' }}>
                                <Card.Body>
                                    {/* <Image src="{p.userId.avatar}" roundedCircle >{p.userId.avatar}</Image> */}
                                    <div style={{display:"flex"}}>
                                        <Image variant="top" style={{height: "40px", width: "40px" ,marginRight:"10px"}} src={p.userId.avatar} roundedCircle />
                                        <Card.Text style={{color:"blue"}}>{p.userId.lastName} {p.userId.firstName} </Card.Text>
                                        {/* y */}
                                        <Moment locale="vi" style={{marginLeft : "auto"}} fromNow>{p.createdDate}</Moment>
                                      
                                    </div>
                                    <hr></hr>
                                    <Card.Title>{p.title}</Card.Title>
                                    <Card.Text> {p.content}  </Card.Text>
                                    <Button variant="success" >Xem chi tiết bài viết</Button>
                                </Card.Body>
                        </Card>          
                     </Col>
            
                // <li>{p.title} </li>
                 })}

        </Row>
        </>
    )  
}

export default Posts