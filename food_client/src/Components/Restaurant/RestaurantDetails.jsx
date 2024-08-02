import {
  Divider,
  FormControl,
  FormControlLabel,
  Grid,
  Radio,
  RadioGroup,
  Typography,
} from "@mui/material";
import React, { useState } from "react";
import AddLocationIcon from "@mui/icons-material/AddLocation";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import MenuCard from "./MenuCard";
const RestaurantDetails = () => {
    const [foodType, setFoodType] = useState("all");
  const categories = ["pizza", "biryani", "burger", "chiken", "rice"];

  const foodTypes = [
    { label: "All", value: "all" },
    { label: "Vegetarian only", value: "vegetarian" },
    { label: "Non-Vegetarian", value: "non_vegetarian" },
    { label: "seasonal", value: "seasonal" },
  ];

  const handleFilter = (e) => {
    console.log(e.target.value);
  }
  const menu = [1,1,1,1,1]
  return (

    <div className="px-5 lg:px-20">
      <section>
        <h3 className="text-gray-300 py-2 mt-10">
          Home/india/indian fast food/3
        </h3>
        <div>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <img
                src="https://via.placeholder.com/150"
                alt="restaurant"
                className="w-full h-[40vh] rounded-md object-cover object-center"
              />
            </Grid>
            <Grid item xs={12} lg={6}>
              <img
                src="https://via.placeholder.com/150"
                alt="restaurant"
                className="w-full h-[40vh] rounded-md object-cover object-center"
              />
            </Grid>
            <Grid item xs={12} lg={6}>
              <img
                src="https://via.placeholder.com/150"
                alt="restaurant"
                className="w-full h-[40vh] rounded-md object-cover object-center"
              />
            </Grid>
          </Grid>
        </div>
        <div className="pt-3 pb-5">
          <h1 className="text-4xl mt-2 font-semibold">Indian Fast Food</h1>
          <p className="text-gray-500 mt-2">
            Lorem ipsum, dolor sit amet consectetur adipisicing elit. Vitae
            beatae hic sit, quo repellendus iusto totam dignissimos minima ex
            voluptatibus consequatur. Mollitia, laborum aspernatur. Est error
            eum deleniti quis illo.
          </p>
          <div className="space-y-3 mt-3">
            <p className="MBltext-gray-500 flex items-center gap-3">
              <AddLocationIcon />
              <span>Chennai, Tamil Nadu, India</span>
            </p>
            <p className="MBltext-gray-500 flex items-center gap-3">
              <CalendarMonthIcon />
              <span>Open Now - 10:00 AM - 10:00 PM</span>
            </p>
          </div>
        </div>
      </section>
      <Divider />
      <section className="pt-[2rem] lg:flex relative">
        <div className="space-y-10 lg:w-[20%] filter ">
          <div className="box space-y-5 lg:sticky top-28">
            <div>
              <Typography variant="h5" sx={{ paddingBottom: "iren" }}>
                Food Type
              </Typography>
              <FormControl className="py-10 space-y-5" component={"fieldset"}>
                <RadioGroup onChange={handleFilter}name="foodType" value={foodType}>
                    {
                        foodTypes.map((type, index) => (
                            <FormControlLabel
                                key={index}
                                value={type.value}
                                control={<Radio />}
                                label={type.label}
                            />
                        ))
                    }
                    </RadioGroup>



              </FormControl>
            </div>
            <Divider/>
            <div>
              <Typography variant="h5" sx={{ paddingBottom: "iren" }}>
                Food Category
              </Typography>
              <FormControl className="py-10 space-y-5" component={"fieldset"}>
                <RadioGroup onChange={handleFilter}name="foodType" value={foodType}>
                    {
                        categories.map((type, index) => (
                            <FormControlLabel
                                key={index}
                                value={type}
                                control={<Radio />}
                                label={type}
                            />
                        ))
                    }
                    </RadioGroup>



              </FormControl>
            </div>
          </div>
        </div>
        <div className="space-y-5 lg:w-[86%] 1g:pl-16">
            {
                menu.map((item, index) => (
                    <MenuCard key={index} />
                ))
            }
        </div>
      </section>
    </div>
  );
};

export default RestaurantDetails;
