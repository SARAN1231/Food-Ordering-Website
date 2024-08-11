import { Field, Form, Formik } from "formik";
import React from "react";
import { Button, FormControl, InputLabel, MenuItem, Select, TextField, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";

const Register = () => {
  const navigate = useNavigate();
  const initialValues = {
    fullname: "",
    email: "",
    password: "",
    role: "",
  };

  const handleSubmit = (values) => {
    console.log("Form values:", values);
  };

  return (
    <div>
      <Typography variant="h4" className="text-center">
        Register
      </Typography>
      <Formik onSubmit={handleSubmit} initialValues={initialValues}>
        {({ setFieldValue, values }) => (
          <Form>
            <div className="flex flex-col gap-4">
              <Field
                as={TextField}
                type="text"
                name="fullname"
                placeholder="FullName"
                className="p-2 border border-gray-300 rounded-lg"
              />
              <Field
                as={TextField}
                type="email"
                name="email"
                placeholder="Email"
                className="p-2 border border-gray-300 rounded-lg"
              />
              <Field
                as={TextField}
                type="password"
                name="password"
                placeholder="Password"
                className="p-2 border border-gray-300 rounded-lg"
              />

              <FormControl fullWidth>
                <InputLabel id="role-simple-select-label">Role</InputLabel>
                <Select
                  labelId="role-simple-select-label"
                  id="role-select"
                  value={values.role}
                  label="Role"
                  onChange={(event) =>
                    setFieldValue("role", event.target.value)
                  }
                >
                  <MenuItem value={"ROLE_CUSTOMER"}>Customer</MenuItem>
                  <MenuItem value={"ROLE_RESTAURANT_OWNER"}>Restaurant Owner</MenuItem>
                </Select>
              </FormControl>
              <button
                type="submit"
                className="bg-rose-500 text-white p-2 rounded-lg"
              >
                Register
              </button>
            </div>
          </Form>
        )}
      </Formik>
      <Typography align="center">
        Already have an account?{" "}
        <Button onClick={() => navigate("/account/login")}>Login</Button>
      </Typography>
    </div>
  );
};

export default Register;
