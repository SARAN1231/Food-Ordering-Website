import { Card, Chip, IconButton } from '@mui/material'
import React from 'react'
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
const RestaurantCard = () => {
  return (
  <Card className=' w-[18rem]'>
    <div className={`${true ?"cursor-pointer" :"cursor-not-allowed"} relative`}>
        <img src="https://via.placeholder.com/150" 
        
     alt="restaurant" className='w-full h-[10rem] 
     rounded-t-md object-cover object-center'/>
     <Chip size='small'
     className='absolute top-2 left-2'
     color={true?"success" :"error"}
     label={true?"open":"closed"}/>

    </div>
    <div className='p-4 textPart lg:flex w-full justify-between'>
        <div className='space-y-1'>
            <p className='font-semibold text-lg' >Indian Fast Food</p>
            <p className='text-gray-500'>North Indian, South Indian</p>

        </div>
        <div>
            <IconButton>
                {true?<FavoriteIcon/>:<FavoriteBorderIcon />}
            </IconButton>
        </div>
    </div>
  </Card>
  )
}

export default RestaurantCard