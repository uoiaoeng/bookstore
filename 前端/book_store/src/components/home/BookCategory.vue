<template>
    <div class="category">
        <div class="">
            <i :class="{active:flag==1}" @click="goType(1,'全部')" class="el-icon-tickets"></i>
            <span class="cate" :class="{active:flag==1}">全部</span>
        </div>
        <div>
            <i :class="{active:flag==2}" @click="goType(2,'侦探')" class="el-icon-tickets"></i>
            <span class="cate" :class="{active:flag==2}">侦探</span>
        </div>
        <div>
            <i :class="{active:flag==3}" @click="goType(3,'军事')" class="el-icon-tickets"></i>
            <span class="cate" :class="{active:flag==3}">军事</span>
        </div>
        <div>
            <i :class="{active:flag==4}" @click="goType(4,'历史')" class="el-icon-tickets"></i>
            <span class="cate" :class="{active:flag==4}">历史</span>
        </div>
        <div>
            <i :class="{active:flag==5}" @click="goType(5,'科幻')" class="el-icon-tickets"></i>
            <span class="cate" :class="{active:flag==5}">科幻</span>
        </div>
        <div>
            <i :class="{active:flag==6}" @click="goType(6,'魔幻')" class="el-icon-tickets"></i>
            <span class="cate" :class="{active:flag==6}">魔幻</span>
        </div>
        
    </div>
</template>

<script>

    export default {
        name:'BookCategory',
        data(){
            return{
                flag:0
            }
        },
        methods:{
            goType(a,b){
                this.flag = a;
                this.$bus.$emit('sendType',b)
            }
        }
    }
</script>

<style scoped>
    .category{
        background-color: white;
        width: 100%;
        height: 100px;
        display: flex;
		justify-content: space-around;
        position: relative;
        top: 10px;
    }
    .active{
        color:aqua
    }
    .cate{
        position: relative;
        top: 30px;
        left: -40px;
    }
</style>