<template>
    <div class="login">
        <span class="text_title">密码登录</span>
        <div class="head_portrait">
            <el-avatar :size="100" :src="circleUrl"></el-avatar>
        </div>
        <form ref="form">
            <span class="text_u">账号</span>
            <div class="input_u">
                <el-input v-model="loginInfo.username" placeholder="请输入账号"></el-input>
            </div>
            <span class="text_p">密码</span>
            <div class="input_p">
                <el-input v-model="loginInfo.password" placeholder="请输入密码" @keyup.enter.native="submitForm" show-password></el-input>
            </div>
            <div>
                <div class="login_icon">
                    <el-button type="primary" class="el-icon-right" @click="submitForm"></el-button>
                </div>
                <span class="text_l">登录</span>
            </div>
        </form>
        <div class="regis">
            <span>没有账号请先<span class="goRegis" @click="goRegister()">注册</span></span> 
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name:'UserPage',
        data(){
            return{
                loginInfo:{
                    username:'',
                    password:''
                },
                circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
            }
        },
        mounted(){
			axios.defaults.baseURL = '/api'
		},
        methods:{
            submitForm(){
                let params = this.loginInfo
                    
                let url='/user/login'
                //console.log('params',params);

                axios.post(url,params)
                .then(res=>{
                    console.log(res);
                    if(res.data.statusCode=='400'){
                        console.log('登录失败',res.data.message);
                        alert('用户名或密码错误',)
                    }else{
                        console.log('登录成功',res.data);
                        alert('登录成功')
                        this.$bus.$emit('change',1,0)
                        localStorage.setItem('username',this.loginInfo.username)
                        this.$bus.$emit('getUsername')
                        console.log(res);
                        localStorage.setItem('token',res.data.token)
                        this.$router.push({
                            name:'home'
                        })
                    }
                })
                .catch(err=>{
                    console.log('请求发送失败',err.message);
                })
            },
            goRegister(){
                this.$router.push({
                    name:'register'
                })
            },
        }
    }
</script>

<style scoped>
    .head_portrait{
        position: absolute;
        top: 100px;
        left: 330px;
    }
    .text_title{
        font-size: 30px;
        position: absolute;
        left: 320px;
        top: 30px;
    }
    .input_u{
        position: relative;
        left: 230px;
        top: 250px;
        width: 300px;
    }
    .text_u{
        font-size: 20px;
        position: relative;
        top: 282px;
        left: 160px;
    }
    .input_p{
        position: relative;
        left: 230px;
        top: 300px;
        width: 300px;
    }
    .text_p{
        font-size: 20px;
        position: relative;
        top: 330px;
        left: 160px;
    }
    .login_icon{
        position: relative;
        top: 330px;
        left: 350px;
    }
    .el-icon-right:hover{
        color: rgb(6, 246, 6);
    }
    .text_l{
        font-size: 20px;
        position: relative;
        top: 335px;
        left: 360px;
    }
    .regis{
        font-size: 20px;
        position: relative;
        left: 300px;
        top: 370px;
    }
    .goRegis{
        text-decoration: underline;
        cursor: pointer;
    }
    .goRegis:hover{
        color: blue;
    }
</style>