<template>
  <div class="detail">
    <div class="header">
      <i class="el-icon-arrow-left" @click="back(position)"></i>
      <div class="bookTitle">{{bookData.name}}</div>
      <el-dropdown class="dropdown1">
        <i class="el-icon-more"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>分享</el-dropdown-item>
          <el-dropdown-item>更多</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>

    <!-- <img src="@/assets/picture/zentanp1.jpg" class="img"> -->
    <img :src="require('@/assets/picture/'+bookData.imageUrl)" class="img">

    <div class="basicInfo">
      <div class="infoText">
        {{bookData.name}}<br><br>
        <div class="author">{{bookData.author}}<br><br></div>
        <div class="category">{{bookData.category}}<br><br></div>
        <div class="price">￥{{bookData.price}}</div>
      </div>
    </div>

    <div class="introText">
      {{bookData.introduction}}
    </div>

    <div class="footer">
      <i class="el-icon-chat-dot-round footIcon"></i><span class="iconText">客服</span>
      <i class="el-icon-star-off footIcon" @click="goCollPage"></i><span class="iconText coll">收藏夹</span>
      <i class="el-icon-box footIcon"></i><span class="iconText">店铺</span>
      <el-button
        type="success"
        round
        :class="{btn_coll1:isActive,btn_coll2:!isActive}"
        @click="collecte">
        {{ isActive? '收藏本书':'取消收藏' }}
      </el-button>
    </div>
  </div>
</template>

<script>
	import {updateColl} from '@/api/modules/user'
  export default{
    name:'DetailPage',
    data(){
      return{
        bookData:this.$route.params.bookData,
        userData:this.$route.params.userData,
        isActive:this.$route.params.isActive,
        position:'',
      }
    },
    methods:{
      back(position){
        if(position == '主页'){
          this.$router.push({
            name:'home'
          })
        }
        else if(position == '收藏'){
          this.$router.push({
            name:'collection'
          })
        }
      },
      goCollPage(){
        this.$bus.$emit('DetailToColl')
      },
      collecte(){
        if(localStorage.getItem('username')==null){
					alert('请先登录')
				}else{
					if(confirm(this.isActive?'确定要收藏本书吗':'确定要取消收藏吗')){
						this.isActive = !this.isActive
						updateColl({username:localStorage.getItem('username'),bookId:this.bookData.id,flag:!this.isActive})
						.then(res=>{
							console.log(res);
							this.isActive? alert("取消收藏成功") : alert("收藏成功")
						})
					}
				}
      }
    },
    mounted(){
      this.position = localStorage.getItem('position')
    }
  }
</script>

<style scoped>
.detail{
  height: 1200px;
  /* height: auto; */
    /* width: 50%; */
    width: 759px;
    position:absolute;
    left: 380px;
    /* left: 25%; */
    background-color: white;
    box-shadow: 0px 0px 5px rgb(142, 137, 137);
}
.header{
  width: 759px;
  height: 90px;
  border-bottom: 2px solid rgb(242, 237, 237);
  position: fixed;
  z-index: 999;
  background-color: rgb(253, 253, 253);
}
.el-icon-arrow-left{
  position: relative;
  top: 20px;
  left: 30px;
}
.el-icon-arrow-left:hover{
  color: aqua;
}
.bookTitle{
  width: 400px;
  font-size: 30px;
  text-align: center;
  position: relative;
  left: 180px;
  top: -20px;
  /* background-color: red; */
}

.el-icon-more:hover{
  color: aqua;
}
.dropdown1{
  position: relative;
  left: 650px;
  top: -65px;
}
.img{
  height: 200px;
  width: 200px;
  position: relative;
  top: 100px;
  left: 280px;
}
.basicInfo{
  height: 180px;
  position: relative;
  top: 120px;
  border-top: 2px solid rgb(242, 237, 237);
  background-color: rgb(247, 242, 242);
}
.infoText{
  position: relative;
  left: 20px;
  margin-top: 10px;
}
.author{
  font-weight: 200;
}
.category{
  color: red;
}
.price{
  font-size: 20px;
  font-weight: 700;
}
.introText{
  position: relative;
  top: 130px;
  height: 150px;
  font-size: 30px;
  padding: 20px;
}
.footer{
  width: 759px;
  height: 90px;
  /* height: 0px; */
  position: relative;
  top: 640px;
  position: fixed;
  z-index: 999; 
  background-color:  rgb(254, 254, 254);
}
.footIcon{
  font-size: 40px;
  margin-top: 5px;
  margin-left: 60px;
}
.footIcon:hover{
  color: rgb(87, 224, 252);
}
.el-icon-star-off{
  margin-left: 75px;
}
.iconText{
  position: relative;
  top: 25px;
  left: -35px;
}
.coll{
  position: relative;
  left: -42px;
}
.btn_coll1{
  width: 200px;
  height: 50px;
  position: relative;
  left: 70px;
  background-color: blue;
}
.btn_coll2{
  width: 200px;
  height: 50px;
  position: relative;
  left: 70px;
  background-color: rgb(135, 218, 10);
}
</style>