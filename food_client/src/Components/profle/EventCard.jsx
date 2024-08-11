import DeleteIcon from "@mui/icons-material/Delete";
import {
  Card,
  CardActions,
  CardContent,
  CardMedia,
  IconButton,
  Typography,
} from "@mui/material";
import React from "react";

const EventCard = () => {
  return (
    <div>
      <Card sx={{ width: 345 }}>
        <CardMedia
          sx={{ height: 345 }}
          image="https://images.pexels.com/photos/842571/pexels-photo-842571.jpeg?auto=compress&cs=tinysrgb&w=600"
        />
        <CardContent>
          <Typography variant="h5">Indian Fast Food</Typography>
          <Typography variant="body2">50% off on all items</Typography>
          <div className="py-2 space-y-2">
            <Typography variant="body2">
              <span className="font-semibold text-blue-400">Starts: </span> 12th
              Aug 2021
            </Typography>
            <Typography variant="body2">
              <span className="font-semibold text-red-400">Ends: </span> 12th
              Aug 2021
            </Typography>
          </div>
        </CardContent>
        {false && (
          <CardActions>
            <IconButton>
              
              <DeleteIcon />
            </IconButton>
          </CardActions>
        )}
      </Card>
    </div>
  );
};

export default EventCard;
