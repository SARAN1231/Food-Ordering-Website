import React from 'react'
import CartItem from './CartItem'

const Cart = () => {
  return (
    <div>
      <main className='l:flex justify-between'>
          <section className='lg:w-[30%] space-y-6 lg:min-h-screen pt-10'>
            <CartItem />

          </section>
      </main>
    </div>
  )
}

export default Cart
