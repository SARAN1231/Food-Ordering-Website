import { Field, Form, Formik } from 'formik'
import React from 'react'
import {
  
    Button,
    TextField,
    Typography,
  } from "@mui/material";
import {  useNavigate } from 'react-router-dom';
const Login = () => {
    const navigate = useNavigate()
    const initialvalues = {
        email: '',
        password: ''
    }
    const handlesubmit = (values) => {
    }
  return (
    <div>
        <Typography variant='h4' className = 'text-center'>Login</Typography>
        <Formik onSubmit={handlesubmit} initialValues={initialvalues} >
            <Form>
                <div className='flex flex-col gap-4'>
                    <Field   as={TextField} type='email' name='email' placeholder='Email' className='p-2 border border-gray-300 rounded-lg' />
                    <Field   as={TextField} type='password' name='password' placeholder='Password' className='p-2 border border-gray-300 rounded-lg' />
                    <button type='submit' className='bg-rose-500 text-white p-2 rounded-lg'>Login</button>
                </div>
            </Form>
        </Formik>
        <Typography align='center'>
            Don't have an account? <Button onClick={()=> navigate('/account/register')}>
                Register
            </Button>
        </Typography>
    </div>
  )
}

export default Login