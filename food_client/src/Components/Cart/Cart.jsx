import React from "react";
import CartItem from "./CartItem";
import {
  Box,
  Button,
  Card,
  Divider,
  Grid,
  Modal,
  TextField,
} from "@mui/material";
import AddressCard from "./AddressCard";
import AddLocationAltIcon from "@mui/icons-material/AddLocationAlt";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as yup from "yup";

const items = [1, 1];
const Cart = () => {
  const [open, setOpen] = React.useState(false);

  const handleClose = () => setOpen(false);

  const style = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 400,
    bgcolor: "background.paper",
    outline: "none",
    boxShadow: 24,
    p: 4,
  };

  const createOrderusingSelectedAddress = (item) => {
    console.log(item);
  };

  const handleOpenAddressModal = () => {
    setOpen(true);
  };

  const initialValues = {
    address: "",
    city: "",
    state: "",
    pincode: "",
  };

  const validationSchema = yup.object().shape({
    address: yup.string().required("Address is required"),
    city: yup.string().required("City is required"),
    state: yup.string().required("State is required"),
    pincode: yup.string().required("Pincode is required"),
  });

  const handleSubmit = (values) => {
    console.log(values);
  };

  return (
    <>
      <main className="lg:flex justify-between">
        <section className="lg:w-[30%] space-y-6 lg:min-h-screen pt-10">
          {items.map((item, index) => (
            <CartItem key={index} />
          ))}
          <Divider />
          <div className="billdetails px-5 text-sm">
            <p className="font-extralight py-5">Bill Details</p>
            <div className="space-y-3">
              <div className="flex justify-between text-gray-400">
                <p>Item Total</p>
                <p>$599</p>
              </div>
              <div className="flex justify-between text-gray-400">
                <p>Delivery Fee</p>
                <p>$5</p>
              </div>
              <div className="flex justify-between text-gray-400">
                <p>GST & Charges</p>
                <p>$33</p>
              </div>
              <div className="flex justify-between text-gray-400">
                <p>Total</p>
                <p>$637</p>
              </div>
            </div>
          </div>
        </section>
        <Divider orientation="vertical" flexItem />
        <section className="lg:w-[70%] flex justify-center px-5 pb-10 lg:pb-0">
          <div>
            <h1 className="text-center font-semibold text-2xl py-10">
              Choose Delivery Address
            </h1>
            <div className="flex gap-5 flex-wrap justify-center">
              {[1, 1, 1, 1, 1].map((item, index) => (
                <AddressCard
                  key={index}
                  Handleselectaddress={createOrderusingSelectedAddress}
                  item={item}
                  showButton={true}
                />
              ))}
              <Card className="flex gap-5 w-64 p-5">
                <AddLocationAltIcon />
                <div className="space-y-3 text-gray-400">
                  <h1 className="font-semibold text-lg text-white">
                    Add New Address
                  </h1>
                  <Button
                    fullWidth
                    variant="outlined"
                    onClick={handleOpenAddressModal}
                  >
                    Add
                  </Button>
                </div>
              </Card>
            </div>
          </div>
        </section>
      </main>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Formik
            initialValues={initialValues}
            validationSchema={validationSchema}
            onSubmit={handleSubmit}
          >
            {({ errors, touched }) => (
              <Form>
                <Grid container spacing={2}>
                  <Grid item xs={12}>
                    <Box mb={2}>
                      <Field
                        as={TextField}
                        name="address"
                        label="Address"
                        variant="outlined"
                        fullWidth
                        error={touched.address && !!errors.address}
                        helperText={touched.address && errors.address}
                      />
                    </Box>
                  </Grid>
                  <Grid item xs={12}>
                    <Box mb={2}>
                      <Field
                        as={TextField}
                        name="city"
                        label="City"
                        variant="outlined"
                        fullWidth
                        error={touched.city && !!errors.city}
                        helperText={touched.city && errors.city}
                      />
                    </Box>
                  </Grid>
                  <Grid item xs={12}>
                    <Box mb={2}>
                      <Field
                        as={TextField}
                        name="state"
                        label="State"
                        variant="outlined"
                        fullWidth
                        error={touched.state && !!errors.state}
                        helperText={touched.state && errors.state}
                      />
                    </Box>
                  </Grid>
                  <Grid item xs={12}>
                    <Box mb={2}>
                      <Field
                        as={TextField}
                        name="pincode"
                        label="Pincode"
                        variant="outlined"
                        fullWidth
                        error={touched.pincode && !!errors.pincode}
                        helperText={touched.pincode && errors.pincode}
                      />
                    </Box>
                  </Grid>
                  <Grid item xs={12}>
                    <Button
                      fullWidth
                      type="submit"
                      variant="contained"
                      color="primary"
                    >
                      Deliver Here
                    </Button>
                  </Grid>
                </Grid>
              </Form>
            )}
          </Formik>
        </Box>
      </Modal>
    </>
  );
};

export default Cart;
