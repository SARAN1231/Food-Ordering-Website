import { HomeRepairServiceOutlined } from '@mui/icons-material'
import { Button, Card } from '@mui/material'
import React from 'react'
import HomeIcon from '@mui/icons-material/Home';
const AddressCard = ({item,showButton,Handleselectaddress}) => {
    
  return (
    <Card className='flex gap-5 w-64 p-5'>
        <HomeIcon />
        <div className='space-y-3 text-gray-400'>

        
        <h1 className='font-semibold text-lg text-white'>Home</h1>
        <p>Mumbai,new shivam building,gokulam street maharastra india</p>
        {showButton && <Button fullWidth variant='outlined' onClick={()=> Handleselectaddress(item)}>Select</Button>}
        </div>
    </Card>

  )
}

export default AddressCard