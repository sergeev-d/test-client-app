import ApiService from "@/common/api.service";
import JwtService from "@/common/jwt.service";
import {
  LOGIN,
  LOGOUT,
  // REGISTER,
  CHECK_AUTH,
  // UPDATE_USER
} from "../actions.type";
import { SET_AUTH, PURGE_AUTH, SET_ERROR, SET_USER } from "../mutations.type";

const state = {
  errors: null,
  user: {},
  isAuthenticated: !!JwtService.getToken()
};

const getters = {
  currentUser(state) {
    return state.user;
  },
  isAuthenticated(state) {
    return state.isAuthenticated;
  }
};

const actions = {
  [LOGIN](context, {email, password}) {
    return new Promise(resolve => {
      ApiService.post("/login", { email, password })
        .then(({ data }) => {
          context.commit(SET_AUTH, data.user);
          resolve(data);
        })
        .catch(({ response }) => {
          context.commit(SET_ERROR, response.data.errors);
        });
    });
  },
  [LOGOUT](context) {
    context.commit(PURGE_AUTH);
    // return new Promise(resolve => {
    //   ApiService.post("logout")
    //       .then(() => {
    //         context.commit(PURGE_AUTH);
    //         resolve();
    //       })
    //       .catch(({ response }) => {
    //         context.commit(SET_ERROR, response.data.errors);
    //       });
    // });
  },
  // [REGISTER](context, credentials) {
  //   return new Promise((resolve, reject) => {
  //     ApiService.post("users", { user: credentials })
  //       .then(({ data }) => {
  //         context.commit(SET_AUTH, data.user);
  //         resolve(data);
  //       })
  //       .catch(({ response }) => {
  //         context.commit(SET_ERROR, response.data.errors);
  //         reject(response);
  //       });
  //   });
  // },
  [CHECK_AUTH](context) {
    if (JwtService.getToken()) {
      ApiService.setHeader();
      ApiService.query("user")
        .then(({ data }) => {
          context.commit(SET_USER, data.user);
        })
        .catch(({ response }) => {
          context.commit(SET_ERROR, response.data.errors);
        });

    } else {
      context.commit(PURGE_AUTH);
    }
  },
  // [UPDATE_USER](context, payload) {
  //   const { email, username, password, image, bio } = payload;
  //   const user = {
  //     email,
  //     username,
  //     bio,
  //     image
  //   };
  //   if (password) {
  //     user.password = password;
  //   }
  //
  //   return ApiService.put("user", user).then(({ data }) => {
  //     context.commit(SET_AUTH, data.user);
  //     return data;
  //   });
  // }
};

const mutations = {
  [SET_ERROR](state, error) {
    state.errors = error;
  },
  [SET_AUTH](state, user) {
    state.isAuthenticated = true;
    state.user = user;
    state.errors = {};
    JwtService.saveToken(state.user.token);
  },
  [SET_USER](state, user) {
    state.isAuthenticated = true;
    state.user = user;
    state.errors = {};
  },
  [PURGE_AUTH](state) {
    JwtService.destroyToken();
    state.isAuthenticated = false;
    state.user = {};
    state.errors = {};
  }
};

export default {
  state,
  actions,
  mutations,
  getters
};
