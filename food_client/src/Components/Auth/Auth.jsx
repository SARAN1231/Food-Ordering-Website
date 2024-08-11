import { Modal, Box } from "@mui/material";
import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import Login from "./Login";
import Register from "./Register";

const Auth = () => {
  const location = useLocation();
  const navigate = useNavigate();

  return (
    <div>
      <Modal
        open={
          location.pathname === "/account/login" ||
          location.pathname === "/account/register"
        }
        onClose={() => navigate("/")}
      >
        <Box
          sx={{
            position: 'absolute',
            top: '50%',
            left: '50%',
            transform: 'translate(-50%, -50%)',
            width: 400,
            bgcolor: 'background.paper',
            border: '2px solid #000',
            boxShadow: 24,
            p: 4,
          }}
        >
          {/* Your login or register form goes here */}
          {location.pathname === "/account/login" ? (
            <Login />
          ) : (
           <Register />
          )}
        </Box>
      </Modal>
    </div>
  );
};

export default Auth;
