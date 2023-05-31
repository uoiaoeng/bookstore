<template>
	<div>
		<div class="bookCard">
			<div class="imageDiv">
				<!-- <img src="@/assets/picture/zentanp1.jpg" class="image"> -->
				<img :src="require('@/assets/picture/'+bookData.imageUrl)" class="image">
			</div>
			<div class="text_detail text">{{bookData.name}}</div>
			<div class="text_author text">{{bookData.author}}</div>
			<div class="text_type text">{{bookData.category}}</div>
			<div class="text_price text">￥{{bookData.price}}</div>
      <el-button
				id="coll"
				:class="{btn_coll1:isActive,btn_coll2:!isActive}"
				type="primary"
				@click="collecte"
				plain>
				{{ isActive? '收藏':'取消' }}
			</el-button>
      <el-button class="btn_detail" type="primary" @click="goDetailPage" plain>查看详情</el-button>
		</div>
	</div>
</template>

<script>

	import {updateColl} from '@/api/modules/user'
	export default {
    name:'MyCategory',
		props:['bookData','userData'],
		data(){
			var active = true
			if(this.userData){
				var likeBooks = this.userData.likeBookId.split(',')
				for(var bookID of likeBooks){
					if(bookID === this.bookData.id){
						active = false
						break
					}
				}
			}
			return{
				isActive:active,
				user:{},
			}
		},
		computed:{

		},
		watch:{
			userData(newVal){
				if(this.userData){
					var likeBooks = newVal.likeBookId.split(',')
					for(var bookID of likeBooks){
						if(bookID === this.bookData.id){
							this.isActive = false
							break
						}
						this.isActive = true
					}
				}
			},
			bookData:{
				deep:true,
				handler(newVal){
					if(this.userData){
						var likeBooks = this.userData.likeBookId.split(',')
						for(var bookID of likeBooks){
							if(bookID === newVal.id){
								this.isActive = false
								break
							}
							this.isActive = true
						}
					}
					
				}
			}
		},
		methods:{
			goDetailPage(){
				this.$router.push({
					name:'detail',
					params:{
						bookData:this.bookData,
						userData:this.userData,
						isActive:this.isActive
					}
				})
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
			},
		},
  }
</script>

<style scoped>

.bookCard{
	background-color: rgb(247, 242, 242);
	width: 700px;
	height: 200px;
  margin:20px;
  box-shadow: 0px 0px 5px rgb(187, 182, 182);
}
.imageDiv{
	padding: 10px;
}
.image{
	padding: 10px;
	width: 150px;
	height: 150px;
}
.text{
	font-size: 20px;
	position: relative;
	left: 200px;
	top: -170px;
	margin-bottom: 20px;
}
.text_type{
  color: red;
}
.btn_coll1{
  position: relative;
  top: -230px;
  left: 610px;
}
.btn_coll1:checked{
	background-color:  rgb(104, 244, 10);
}
.btn_coll2{
	position: relative;
  top: -230px;
  left: 610px;
	background-color: rgb(64, 244, 10);
}
.btn_coll2:hover{
	background-color: rgb(104, 244, 10);
}
.btn_detail{
  position: relative;
  top: -230px;
  left: 410px;
}
</style>