import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import useAuth from "../../context/useAuth";

const Login = () => {

  const [formData, setFormData] = useState({
      'email':'',
      'password': ''
  })
  const navigate = useNavigate();
  const { user } = useAuth();
  const[loading, setLoading] = useState(false);
  const[error, setError] = useState(null);

  useEffect(()=>{
      if (user) navigate(`/${user.role}`);
  },[]);

  return (
    <div className='authWrapper'>
        <label className='authWrapper_label'>Email</label>
    </div>
  )
}

export default Login
