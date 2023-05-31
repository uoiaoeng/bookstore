<template>
    <div class="searchBox">
        <!-- <i class="el-icon-picture"></i> -->
        <span class="title">{{title}}</span>
        <div class="demo-input-suffix" @keyup.enter="search">
            <el-input
                placeholder="输入书名搜索"
                prefix-icon="el-icon-search"
                v-model="input">
            </el-input>
        </div>

        <el-popover 
            trigger="hover" 
            placement="top-start"
            :content="username"
            >
            <i class="el-icon-s-custom" slot="reference"></i>
        </el-popover>
        
        <!-- <i class="el-icon-s-custom"></i> -->
        <span class="userText">个人信息</span>
        <div class="lineS"></div>
    </div>
</template>

<script>
    export default {
        name:'SearchBox',
        data(){
            return{
                input:'',
                username:'',
            }
        },
        props:['title'],
        methods:{
            search(){
                if(this.input==''){
                    alert('书名不能为空')
                }else{
                    this.$bus.$emit('search',this.input)
                }
            }
        },
        mounted(){
            this.username = localStorage.getItem('username')
        }
    }
</script>

<style>
    .searchBox{
        background-color: white;
        width: 100%;
        height: 98px;
        /* border-bottom: 5px solid rgb(153, 143, 143); */
    }
    .demo-input-suffix{
        position: absolute;
        top:25px;
        left: 220px;
        width:300px;
    }
    .el-icon-search{
        font-size: 15px;
    }
    .lineS{
        width: 50%;
        height: 5px;
        position: absolute;
        left: 25%;
        top: 93px;
        background-color: white;
        border-bottom: 2px solid rgb(224, 219, 227);
    }
    .el-icon-picture{
        position: absolute;
        left: 50px;
    }
    .el-icon-s-custom{
        font-size: 50px;
        position: absolute;
        left: 650px;
        top: 20px;
    }
    .el-icon-s-custom:hover{
        color: burlywood;
    }
    .userText{
        position: absolute;
        left: 642px;
        top: 70px;
    }
    .title{
        position: relative;
        left: 40px;
        top: 30px;
        font-size: 30px;
        cursor: pointer;
    }
</style>