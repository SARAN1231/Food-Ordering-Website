import React from "react";
import ShoppingBagIcon from "@mui/icons-material/ShoppingBag";
import FavoriteIcon from "@mui/icons-material/Favorite";
import HomeIcon from "@mui/icons-material/Home";
import AccountBalanceWalletIcon from "@mui/icons-material/AccountBalanceWallet";
import NotificationImportantIcon from "@mui/icons-material/NotificationImportant";
import EventIcon from "@mui/icons-material/Event";
import Logout from "@mui/icons-material/Logout";
import { AddReaction } from "@mui/icons-material";
import { Divider, Drawer, useMediaQuery } from "@mui/material";
import { useNavigate } from "react-router-dom";

const ProfileNavigation = ({ open, handleclose }) => {
  const menu = [
    {
      title: "Orders",
      icon: <ShoppingBagIcon />,
    },
    {
      title: "Wishlist",
      icon: <FavoriteIcon />,
    },
    {
      title: "Address",
      icon: <AddReaction />,
    },
    // {
    //   title: "Home",
    //   icon: <HomeIcon />,
    // },
    {
      title: "Payments",
      icon: <AccountBalanceWalletIcon />,
    },
    {
      title: "Notification",
      icon: <NotificationImportantIcon />,
    },
    {
      title: "Events",
      icon: <EventIcon />,
    },
    {
      title: "Logout",
      icon: <Logout />,
    },
  ];

  const isSmallScreen = useMediaQuery("(max-width:900px)");

  const navigate = useNavigate();

  const handleNavigation = (item) => {
    navigate(`/my-profile/${item.title.toLowerCase()}`);
  };

  return (
    <div>
      <Drawer
        variant={isSmallScreen ? "temporary" : "permanent"}
        onClose={handleclose}
        open={isSmallScreen ? open : true}
        anchor="left"
        sx={{ zIndex: -1, position: "sticky" }}
      >
        <div className="w-[50vw] lg:w-[20vw] h-[90vh] flex flex-col justify-center text-xl gap-8 pt-16">
          {menu.map((item, index) => (
            <div key={index}>
              <div
                onClick={() => handleNavigation(item)}
                className="px-5 flex items-center space-x-5 cursor-pointer py-3"
              >
                {item.icon}
                <span>{item.title}</span>
              </div>
              {index !== menu.length - 1 && <Divider className="mx-5" />}
            </div>
          ))}
        </div>
      </Drawer>
    </div>
  );
};

export default ProfileNavigation;
