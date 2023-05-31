<template>
    <div>
        <div class="head_portrait">
            <el-avatar :size="100" :src="circleUrl"></el-avatar>
        </div>
        <span class="text_info">用户名：{{userInfo.username}}</span>
        <div class="text_manage" v-if="flag"><span @click="goManege()">书本管理</span></div>
        <div class="text_logout"><span @click="logout()">退出登录</span></div>
        <div class="cancel"><span @click="cancel()">注销账号</span></div>

        
    </div>
</template>

<script>
    import axios from 'axios'
    import {getByUsername} from '@/api/modules/user'
    export default{
        name:'UserInfo',
        data(){
            return{
                circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
                userInfo:{
                    username:'',
                },
                flag:'false'
            }
        },
        methods:{
            logout(){
                var flag = confirm('确定要退出登录吗？')
                if(flag){
                    this.$bus.$emit('logout')
                }
            },
            cancel(){
                var flag = confirm('确定要注销账号吗？')
                if(flag){

                    let params = {username:this.userInfo.username}
                    let url='/user/cancel'
                    axios.post(url,params)
                    .then(res=>{
                        console.log('注销成功',res);
                        alert('注销成功')
                        this.$bus.$emit('logout')
                        this.router.push({
                            name:'login'
                        })
                    })
                    .catch(err=>{
                        console.log('请求发送失败',err.message);
                    })
                }
            },
            goManege(){
                this.$router.push({
                    name:'manage'
                })
            }
        },
        mounted(){
            axios.defaults.baseURL = '/api'
            this.userInfo.username = this.$route.params.username

            getByUsername({username:this.userInfo.username})
            .then(res=>{
                console.log(res);
                if(res.data.role == 2 || res.data.role == 1){
                    this.flag = true
                }else{
                    this.flag = false
                }
            })
        }
    }
</script>

<style scoped>
    .head_portrait{
        position: relative;
        top: 70px;
        left: 320px;
    }
    .text_info{
        font-size: 30px;
        position: relative;
        top: 150px;
        left: 270px;
    }
    .text_manage{
        width: 150px;
        font-size: 30px;
        position: relative;
        top: 220px;
        left: 320px;
        cursor: pointer;
    }
    .text_manage:hover{
        color: aqua;
    }
    .text_logout{
        width: 150px;
        font-size: 30px;
        position: relative;
        top: 250px;
        left: 320px;
        cursor: pointer;
    }
    .text_logout:hover{
        color: blue;
    }
    .cancel{
        width: 150px;
        font-size: 30px;
        position: relative;
        top: 300px;
        left: 320px;
        cursor:pointer;
    }
    .cancel:hover{
        color: red;
    }
</style>