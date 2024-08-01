import React from "react";
import SearchIcon from "@mui/icons-material/Search";
import { Avatar, Badge, IconButton } from "@mui/material";
import { pink } from "@mui/material/colors";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import "./Navbar.css";
const Navbar = () => {
  return (
    <div className="px-5 z-50 py-[.8rem] bg-[#e91e63] lg:px-20 flex justify-between">
      <div className="lg:mr-10 cursor-pointer flex items-center space-x-4">
        <li className="logo font-semibold text-gray-200 text-2xl">Zosh Food</li>
      </div>
      <div className="flex items-center space-x-2 lg:space-x-10">
        <div>
          <IconButton>
            <SearchIcon sx={{ fontSize: "1.5rem" }} />
          </IconButton>
        </div>
        <div>
          <Avatar sx={{ bgcolor: "white", color: pink.A400 }}>S</Avatar>
        </div>
        <div>
          <IconButton>
            <Badge badgeContent={4} color="primary">
            <ShoppingCartIcon />
              </Badge>
        
          </IconButton>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
