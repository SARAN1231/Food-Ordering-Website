import React from 'react';

const CarouselItem = ({ image, title }) => {
  return (
    <div className='flex flex-col justify-center items-center'>
      <img 
        className='w-[10rem] h-[10rem] lg:w-[14rem] lg:h-[14rem] rounded-full object-cover object-center' 
        src={image} 
        alt={title} 
      />
      <span className='text-xl py-5 text-gray-300 font-semibold'>{title}</span>
    </div>
  );
};

export default CarouselItem;
