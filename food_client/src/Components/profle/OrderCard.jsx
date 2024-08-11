import { Button } from '@mui/material'
import React from 'react'

const OrderCard = () => {
  return (
    <div className='flex justify-between items-center p-5'>
        <div className='flex items-center space-x-5'>
            <img className='h-16 w-16' src="https://cdn.pixabay.com/photo/2024/04/26/12/24/ai-generated-8721771_640.jpg" alt="" />
            <div>
                <p>Biyani</p>
                <p>$300</p>
            </div>
        </div>
        <div>
            <Button className='cursor-not-allowed'>
                completed
            </Button>
        </div>
    </div>
  )
}

export default OrderCard