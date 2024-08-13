import axios from "axios";
import { API_URL } from "../../config/api";

export const registeruser = (reqdata) => async (dispatch) => {
  dispatch({ type: REGISTER_REQUEST });
  try {
    const { data } = await axios.post(
      `${API_URL}/auth/signup`,
      reqdata.userData
    );
    if (data.jwt) {
      localStorage.setItem("jwt", data.jwt);
    }
    if (data.role === "ROLE_RESTAURANT_OWNER") {
      reqdata.navigate("/admin/restaurant");
    } else {
      reqdata.navigate("/");
    }
    dispatch({ type: REGISTER_SUCCESS, payload: data.jwt });
  } catch (error) {
    dispatch({ type: REGISTER_FAILURE, payload: error });
  }
};

export const loginuser = (reqdata) => async (dispatch) => {
  dispatch({ type: LOGIN_REQUEST });
  try {
    const { data } = await axios.post(
      `${API_URL}/auth/signin`,
      reqdata.userData
    );
    if (data.jwt) {
      localStorage.setItem("jwt", data.jwt);
    }
    if (data.role === "ROLE_RESTAURANT_OWNER") {
      reqdata.navigate("/admin/restaurant");
    } else {
      reqdata.navigate("/");
    }
    dispatch({ type: LOGIN_SUCCESS, payload: data.jwt });
  } catch (error) {
    dispatch({ type: LOGIN_FAILURE, payload: error });
  }
};

export const getuser = (jwt) => async (dispatch) => {
  dispatch({ type: GET_USER_REQUEST });
  try {
    const { data } = await axios.get(`${API_URL}/auth/signin`, {
      headers: {
        Authorization: `Bearer ${jwt}`,
      },
    });
    dispatch({ type: GET_USER_SUCCESS, payload: data });
  } catch (error) {
    dispatch({ type: GET_USER_FAILURE, payload: error });
  }
};

export const addtofavorite = (jwt, restaurantId) => async (dispatch) => {
  dispatch({ type: ADD_TO_FAVORITE_REQUEST });
  try {
    const { data } = await axios.put(
      `${API_URL}api/restaurants/${restaurantId}/favourites`,
      {},
      {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      }
    );
    dispatch({ type: ADD_TO_FAVORITE_SUCCESS, payload: data });
  } catch (error) {
    dispatch({ type: ADD_TO_FAVORITE_FAILURE, payload: error });
  }
};

export const logout = () => async (dispatch) => {
  try{
    localStorage.removeItem("jwt");
    dispatch({ type: LOGOUT });
  }
    catch(error){
        console.log(error)
    }
};
