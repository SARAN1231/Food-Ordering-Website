import React, { useState } from 'react'
import ProfileNavigation from './ProfileNavigation'
import { Route, Routes } from 'react-router-dom'
import UserProfile from './UserProfile'
import Address from './Address'
import Home from '../Home/Home'
import Payments from './Payments'
import Events from './Events'
import Logout from './Logout'
import Notification from './Notification'
import Orders from './Orders'
import Wishlist from './Wishlist'
const Profile = () => {
    const [opensidebar , setOpensidebar] = useState(true)
  return (
    <div className='lg:flex justify-between'>
        <div className='sticky h-[80vh] lg:w-[20%]'>
            <ProfileNavigation open={opensidebar}/>
        </div>
        <div className='lg:w-[80%]'>

        <Routes>
            <Route path='/' element={<UserProfile/>}/> 
            <Route path='orders' element={<Orders/>}/>
            <Route path='wishlist' element={<Wishlist/>}/>
            <Route path='address' element={<Address/>}/>
            {/* <Route path='home' element={<Home/>}/> */}
            <Route path='payments' element={<Payments/>}/>
            <Route path='notification' element={<Notification/>}/>
            <Route path='events' element={<Events/>}/>
            <Route path='logout' element={<Logout/>}/>
        </Routes>
        </div>
    </div>
  )
}

export default Profile