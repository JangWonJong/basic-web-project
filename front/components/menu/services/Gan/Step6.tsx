import { SyntheticEvent, useState } from 'react'
import { Box, Text, Flex,  Input, Button } from '@chakra-ui/react'
import Link from 'next/link'
import axios from 'axios'

function Step6() {
    const [ img, setImg ] = useState('')

    const imgset = '/j/5.png'
       
    
    return (
        <>
        <div>
        <h1>6. 결과확인 </h1>
        </div>
        <div>
            <img src={imgset} width={500} height={500}/>
        </div>
        
         <Button><Link href="/menu/services/imageprocess/step7"><a>motion transfer &raquo;</a></Link></Button>
        </>
    )
}

export default Step6