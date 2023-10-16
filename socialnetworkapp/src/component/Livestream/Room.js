import { ZegoUIKitPrebuilt } from '@zegocloud/zego-uikit-prebuilt';
import React, { useContext } from 'react'
import {useParams} from 'react-router-dom'
import { MyUserContext } from '../../App';

export default function Room() {
    const [user, dispatch] = useContext(MyUserContext);
    const {roomId} = useParams()

    const myMeeting = async (element )  => {
        const appID =  162089223;
        const users = "Nhập tên...";
        const id =  Date.now().toString();
        if (user !== null){
            const users = user.firstName +" "+ user.lastName;
            const id = user.id.toString();
        }
       
           
        
        const serverSecret = "5814805ca83d5c542778d2adfbfd1cf8";
        const kitToken =  ZegoUIKitPrebuilt.generateKitTokenForTest(
            appID,
            serverSecret,
            roomId,  
            id,
            // "userName" + roomId
            users
            );
            const zp = ZegoUIKitPrebuilt.create(kitToken);

              // start the call
            zp.joinRoom({
                container: element,
                scenario: {
                    mode: ZegoUIKitPrebuilt.LiveStreaming,
                // config: {
                //     role,
                // },
                },
                // sharedLinks,
            });
        };



    return (
        <div className='meeting' >
            <div ref={myMeeting}/>
        </div>
    )
}
