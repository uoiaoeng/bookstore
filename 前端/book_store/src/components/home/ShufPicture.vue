<template>
    <div class="shufPicture">
        <span class="demonstration"></span>
        <el-carousel trigger="click" height="150px">
            <el-carousel-item v-for="item in img_list" :key="item">
                <img :src="item" alt />
            </el-carousel-item>
        </el-carousel>
        <div class="lineP"></div>
    </div>
</template>

<script>
    export default {
        name:'ShufPicture',
        data(){
            var imgs = [require("@/assets/picture/shuf1.jpg"),
                        require("@/assets/picture/shuf2.jpg"),
                        require("@/assets/picture/shuf3.jpg"),
                        require("@/assets/picture/shuf4.jpg")]
            return {
                img_list:imgs
            }
        },
        mounted() {
            this.screenWidth = window.innerWidth;
            window.onresize = () => {
                this.screenWidth = window.innerWidth;
            };
        }

        
    }
</script>

<style scoped>
    .shufPicture{
        background-color: white;
        width: 100%;
        height: 200px;
        position: absolute;
        top: 100px;
        padding-top: 20px;
    }
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 150px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }
    
    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }
    .lineP{
        width: 50%;
        height: 10px;
        position: absolute;
        left: 25%;
        top: 188px;
        background-color: white;
        border-bottom: 2px solid rgb(224, 219, 227);
    }
    img{
        width: 400px;
        height: 150px;
        position: relative;
        left: 180px;
    }
</style>