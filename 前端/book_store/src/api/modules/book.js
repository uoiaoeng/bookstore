import {get,post,postJson} from "../axios"

export function getById(params){
    return get('/book/getById',params)
}

export function page(params){
    return post('/book/page',params)
}

export function save(params){
    return postJson('/book/save',params)
}

export function updateUsefulByIds(params){
    return post('/book/updateUsefulByIds',params)
}

export function deleteByIds(params){
    return post('/book/deleteByIds',params)
}

export function pageList(params){
    return post('/book/pageList',params)
}

export function AllList(params){
    return post('/book/AllList',params)
}