import React from "react";
import "./Home.css";
import MultiItemsCarousel from "./MultiItemsCarousel";
import RestaurantCard from "../Restaurant/RestaurantCard";
const restaurant = [1,1,1,1,1,1,1,1,1,1]
const Home = () => {
  return (
    <div className="pb-10">
      <section className="banner -z-50 relative flex flex-col justify-center items-center">
        <div className="w-[50vw] z-10 text-center pt-10">
          <p className="text-2xl lg:text-6xl font-bold z-10 pb-8"> Zosh Food</p>
          <p className="z-10 text-xl text-gray-300 lg:text-4xl">
            Taste the Convinience: Order your favorite food from your favorite
            restaurant
          </p>
        </div>
        <div className="cover absolute top-0 left-0 right-0"></div>
        <div className="fadeout"></div>
      </section>
      <section className="p-10 lg:py-10 lg-px-20">
        <p
          className="text-2xl font-semibold text-gray-400
          py-3 pb-2O"
        >
         
          Top Meals
        </p>
        <MultiItemsCarousel />
      </section>
      <section className="p-10 lg:px-20">
        <p className="text-2xl font-semibold text-gray-400
          pb-6 pb-2O">Order from Our Handpicked Favourites</p> 
        <div className="flex flex-wrap items-center justify-around gap-5">
            {
              restaurant.map((item,index)=>(
                <RestaurantCard />
              ))

            }
        </div>
      </section>
    </div>
  );
};

export default Home;
