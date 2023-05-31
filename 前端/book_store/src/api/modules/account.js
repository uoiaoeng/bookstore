import {get,post,postJson} from "../axios"



export function save(params){
    return postJson('/sys/account/save',params)
}

export function login(params){
    return postJson('/sys/account/login',params)
}
