import {BASE_URL} from "./config.js";

export async function loginAPI(loginForm){
    let res;
    await axios.post(BASE_URL+'/user/login', {
        email: loginForm.email,
        password: loginForm.password
    },{
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(function (response) {
            res = response;
        })
        .catch(function (error) {
            res = error;
        });
    console.log(res)
 return res;
}