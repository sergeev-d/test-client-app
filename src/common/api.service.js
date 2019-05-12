import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";
import { API_URL } from "@/common/config";

const ApiService = {
    init() {
        Vue.use(VueAxios, axios);
        Vue.axios.defaults.baseURL = API_URL;
    },
    setHeader() {
        //Vue.axios.defaults.headers.common["Authorization"] = `Token ${JwtService.getToken()}`;
        Vue.axios.defaults.headers.common['Accept'] = ['application/json','application/jpg'];
        Vue.axios.defaults.headers.common['Content-Type'] = 'application/json';
        Vue.axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
    },
    query(resource, params) {
        ApiService.setHeader();
        return Vue.axios.get(resource, params)
            .catch(error => {
                throw new Error(`ApiService ${error}`);
        });
    },
    post(resource, params) {
        ApiService.setHeader();
        return Vue.axios.post(resource, params)  //`${resource}`
            .catch(error => {
                    throw new Error(`ApiService ${error}`);
        });
    }
};

export default ApiService;

export const AssessmentService = {
    query(params) {
        return ApiService.query(("assessments"), {
            params: params
        })
    }

};

export const DownloadService = {
    get(params) {
        return ApiService.query(("download_document"), {
            params: {
                doc_id:params
            }
        })
    }

};
