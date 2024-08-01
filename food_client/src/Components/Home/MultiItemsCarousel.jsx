import React from 'react';
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { topmeals } from './Topmeals';
import CarouselItem from './CarouselItem';

const MultiItemsCarousel = () => {
  // Slick settings for the carousel
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 5,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 2000,
    arrows: false,
  };

  return (
    <div>
      <Slider {...settings}>
        {topmeals.map((meal, index) => (
         <CarouselItem key={index} image={meal.image} title={meal.title} />
        ))}
      </Slider>
    </div>
  );
};

export default MultiItemsCarousel;
