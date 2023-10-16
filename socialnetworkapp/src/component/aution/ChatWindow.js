import { Button, Form} from 'react-bootstrap';
import styled from 'styled-components'
import Message from './Message';
import { db } from '../../firebase/Config';
import { MyUserContext } from '../../App';
import React, { useContext } from 'react';

const ContentStyled = styled.div`
    height: calc(100% - 10px);
    display: flex;
    flex-direction: column;
    padding: 12px;
   justify-content: flex-end;
`;
const MessageList = styled.div``;
const WrapperStyled = styled.div`
    height: 90vh;
    background: lightblue;
`;

const ChatWindow = () => {
    // const {productId} = useParams();
    // const [product, setProduct] = useState(null);
    const [user, dispatch] = useContext(MyUserContext);


   const addChat = () => {
        const process = async () => {
            // let {data} = await authApi().post(endpoints['add-comment'], {
            //     "content": content, 
            //     "product": product.id
            // });

            // setComments([...comments, data]);


            // db.collection('chat').add({
            //     name: user.username,
            //     avatar: user.avatar,
            
            // })
        }

        process();

        // React.useEffect(() => {
        //     db.collection('users').onSnapshot((snapshot) => {
        //         const data = snapshot.docs.map((doc) => ({
        //             ...doc.data(),
        //             id: doc.id,
        //         }));

        //         console.log({ data, snapshot, docs: snapshot.docs});
        //     });
        // }, []);
    }



    return <>
    <WrapperStyled>
        <h1 className="text-center text-info mt-2">Chat room</h1>
       
       <ContentStyled>
            <MessageList>
                <Message text="Hello" 
                avatar={"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLbj8rUXCxf1cjqTqDknU77Ym-aOcv22ULU5nEG_F39A&s"} 
                username="Kien" createdAt={1694507156000}>
                </Message>
                <Message text="Hello" 
                avatar={"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLbj8rUXCxf1cjqTqDknU77Ym-aOcv22ULU5nEG_F39A&s"} 
                username="Kien" createdAt={1694507156000}>
                </Message>
                <Message text="Hello" 
                avatar={"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLbj8rUXCxf1cjqTqDknU77Ym-aOcv22ULU5nEG_F39A&s"} 
                username="Kien" createdAt={1694507156000}>
                </Message>
            </MessageList>
            {/* onSubmit={login} */}
            <Form style={{display:"flex"}}>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1" style={{paddingRight:"10px"}}>   
                {/* value={username} onChange={e => setUsername(e.target.value)} */}
                    <Form.Control  type="text" placeholder="Nhập nội dung..." />
                </Form.Group>
            
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1" >
                    <Button variant="info" type="submit">Gửi</Button>
                </Form.Group>
             </Form>
            
       </ContentStyled>
       </WrapperStyled>
    </>
}

export default ChatWindow;