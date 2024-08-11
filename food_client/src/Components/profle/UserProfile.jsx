import React from "react";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import { Margin } from "@mui/icons-material";
import { Button } from "@mui/material";
const UserProfile = () => {
  const  handleLogout = () => {
    console.log("Logout");
  }
  return (
    <div className="min-h-[80vh] flex flex-col justify-center items-center">
      <div className="flex flex-col  items-center justify-center">
        <AccountCircleIcon sx={{ fontSize: "10rem" }} />
        <h1 className="py-5 text-2xl font-semibold"> SARAN</h1>
        <p className="text-gray-400">Email: saranprakash3112@gmail.com </p>
        <Button Button variant="contained" onClick = {handleLogout} sx={{ margin: "2rem 0rem" }}>Logout</Button>
      </div>
    </div>
    
  );
};

export default UserProfile;
