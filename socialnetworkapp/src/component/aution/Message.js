import { Card,Image} from "react-bootstrap";
import Moment from "react-moment";

export default function Message( {text, username, createdAt, avatar}) {
    return (
        <div>
              <div style={{display:"flex"}}>
                    <Image variant="top" style={{height: "40px", width: "40px" ,marginRight:"10px"}} src={avatar} roundedCircle />
                    <Card.Text style={{color:"blue", marginRight:"20px"}}>{username} </Card.Text>
                    <Moment locale="vi" fromNow >{createdAt}</Moment>
                                      
             </div>
                <Card.Text> {text}  </Card.Text>
        </div>
    )
}