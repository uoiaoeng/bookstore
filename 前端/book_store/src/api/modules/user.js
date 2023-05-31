import {get,post,postJson} from "../axios"

export function getByUsername(params){
    return post('/user/validate',params)
}

export function updateColl(params){
    return post('/user/updateColl',params)
}