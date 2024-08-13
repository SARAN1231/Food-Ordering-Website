import { act } from "react";
import { ADD_TO_FAVORITE } from "./ActionType";
import { error } from "yupp/util/logger";

const initailState = {
  user: null,
  loading: false,
  error: null,
  jwt: null,
  favouries: [],
  success: null,
};

export const authReducer = (state = initailState, action) => {
  switch (action.type) {
    case REGISTER_REQUEST:
    case LOGIN_REQUEST:
    case GET_USER_REQUEST:
    case ADD_TO_FAVORITE_REQUEST:
      return {
        ...state,
        loading: true,
        error: null,
      };

      break;
    case REGISTER_SUCCESS:
    case LOGIN_SUCCESS:
      return {
        ...state,
        loading: false,
        jwt: action.payload,
        success: "success",
      };
      break;
      case ADD_TO_FAVORITE_SUCCESS:
        return {
          ...state,
          loading: false,
          success: "success",
          error
        };
        break;

    default:
      break;
  }
};
