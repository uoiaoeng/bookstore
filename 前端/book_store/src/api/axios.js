import axios from "axios"
import qs from "qs"

import route from '@/router/index'
// import {getStore} from '@/libs/storage'
axios.defaults.baseURL = '/api'

axios.interceptors.response.use(res =>{
    //response status =200
    let result = res
    if(result.data.statusCode == 200){
        return Promise.resolve(result.data)
    }else if(result.data.statusCode == 600){
        route.push('login')
        return Promise.reject('need login!')
    }else if(result.data.statusCode == 400){
        return Promise.reject(result.data.message)
    }else{
        return Promise.reject(result.data.message)
    }

},err=>{
    //response status != 200
    return Promise.reject(err)
})

export function get(url,params){
    // var token = getStore("token")
    var token = localStorage.getItem('token')
    return axios({
        method:'get',
        url:`${url}`,
        params:params,
        headers: {
            'token': token
        }
    })
}

export function post(url,params){
    // var token = getStore("token")
    var token = localStorage.getItem('token')
    return axios({
        method:'post',
        url:`${url}`,
        params:params,
        transformRequest:[function(data){
            return qs.stringify(data,{allowDots:true})
        }],
        headers: {
            'token': token,
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
}

export function postJson(url,params){
    // var token = getStore("token")
    var token = localStorage.getItem('token')
      return axios({
          method: 'post',
          url: `${url}`,
          data: params,
          headers: {
            'token': token,
            'Content-Type': 'application/json',
            
          }
        })
  }