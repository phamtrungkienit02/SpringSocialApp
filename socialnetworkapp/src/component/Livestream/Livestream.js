import { Button, Form } from "react-bootstrap"

import {useState} from 'react'
import {useNavigate} from 'react-router-dom'
import styled from "styled-components";


const RoomStyled = styled.div`
    background-color: lightblue;
    height: 700px;
    padding: 25px;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 5px;
`;

const Livestream = () => {
    const [roomId, setRoomId] = useState('')
    const navigate = useNavigate()
    const HandelSubmit = (e) => {
        e.preventDefault()
        navigate(`room/${roomId}`)
    }

    return (
        <RoomStyled>
            <Form onSubmit={HandelSubmit}>
          
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Control type="text"
                    required
                    value = {roomId}
                    onChange={e => setRoomId(e.target.value)}
                    placeholder="Nhập id..." />
                </Form.Group>  
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Button variant="info" type="submit">Start</Button>
                </Form.Group>
        
            </Form>
        </RoomStyled>
    )
    
}

export default Livestream;