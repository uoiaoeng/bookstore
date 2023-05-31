<template>
    <div class="footer">
        <i @click="showHouse" :class="(active1==0)? 'el-icon-house':'el-icon-s-home'"></i>
        <i @click="showStar" :class="(active2==0)? 'el-icon-star-off':'el-icon-star-on'"></i>
        <i @click="showUser" :class="(active3==0)? 'el-icon-user':'el-icon-user-solid'"></i>

    </div>
</template>

<script>
    export default {
        name:'MyFooter',
        data(){
            return{
                active1:1,
                active2:0,
                active3:0,
                token:'',
                username:''
            }
        },
        methods:{
            showHouse(){
                this.$router.push({
                    name:'home'
                })
                this.active1 = 1
                this.active2 = 0
                this.active3 = 0
                localStorage.setItem('position','主页')
            },
            showStar(){
                this.$router.push({
                    name:'collection'
                })
                this.active1 = 0
                this.active2 = 1
                this.active3 = 0
                localStorage.setItem('position','收藏')
            },
            showUser(){
                
                if(localStorage.getItem('username')){
                    this.$router.push({
                        name:'info',
                        params:{
                            username:this.username
                        }
                    })
                }else{
                    this.$router.push({
                        name:'login'
                    })
                }
                this.active1 = 0
                this.active2 = 0
                this.active3 = 1
            }
        },
        mounted(){
            this.active1 = localStorage.getItem('active1')
            this.active2 = localStorage.getItem('active2')
            this.active3 = localStorage.getItem('active3')
            this.$bus.$on('change',(a,b)=>{
				this.active1 = a
                this.active3 = b
			})
            this.$bus.$on('getUsername',()=>{
				//this.token = token
                this.username = localStorage.getItem('username')
			})
            this.$bus.$on('logout',()=>{
				localStorage.removeItem('username')
                localStorage.removeItem('token')
                this.showUser()
			})
            this.$bus.$on('DetailToColl',()=>{
                this.showStar()
			})
            this.username = localStorage.getItem('username')
        },
        updated(){
            localStorage.setItem('active1',this.active1)
            localStorage.setItem('active2',this.active2)
            localStorage.setItem('active3',this.active3)
        },
    }
</script>

<style scoped>
    i{
        font-size: 50px;
        margin-top: 15px;
        
    }
    i:hover{
        color: aqua;
    }
    .footer{
        background-color: white;
        width: 759px;
        height: 80px;
        position: absolute;
        top: 89%;
        left: 380px;
        display: flex;
		justify-content: space-around;
        position:fixed;
    }
    .el-icon-s-home{
        color: aqua;
    }
    .el-icon-star-on{
        color: aqua;
    }.el-icon-user-solid{
        color: aqua;
    }
    .cate{
        color: red;
    }
</style>