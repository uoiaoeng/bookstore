<template>
    <div class="show">
        <!-- <router-view></router-view> -->
        <div v-for="(p,index) in total" :key="index">
          <BookCard
            :bookData="tempBookData[p]"
            
            :userData="userData">
          </BookCard>
        </div>
    </div>
</template>

<script>

  import BookCard from './BookCard.vue'
  import {AllList} from "@/api/modules/book"
  import {getByUsername} from "@/api/modules/user"
  export default {
    name:'BookShow',
    data(){
        return{
            type:'全部',
            total:'',
            bookData:[],
            tempBookData:[],
            userData:{},
            flag:'false'
        }
    },
    components:{
        BookCard,
    },
    methods:{
    },
    mounted(){
      this.$bus.$on('sendType',(type)=>{
        this.type = type
        this.tempBookData = this.bookData
      
        this.tempBookData = []  
        this.tempBookData.push(0)
        var i = 0
        for(var a of this.bookData){
          if(a.category == type || type == '全部'){
            // console.log('a',a);
            this.tempBookData.push(a)
            i++
          }
        }
        this.total = i
        this.flag = true
      }),

      this.$bus.$on('search',(input)=>{
        console.log('hs');
        this.searchInput = input
        var i = 0
        for(var book of this.bookData){
            if(input == book.name){
              this.tempBookData = []
              this.tempBookData.push(0)
              this.tempBookData.push(book)
              i++
              break
            }
        }
        if(i===0){
            alert('无此书')
            // this.tempBookData = this.bookData
            // console.log('bookData',this.bookData);
            // this.tempBookData.unshift(0)
            // console.log(this.tempBookData);
        }else{
            this.total = i
        }
      })
    },
    beforeCreate(){
      getByUsername({username:localStorage.getItem('username')})
      .then(res=>{
        this.userData = res.data
      }),
      
      AllList()
      .then(res=>{
        // console.log(res.data);
        var i = 0
        this.tempBookData.push(0)
        for(var a of res.data){
          // console.log('a',a);
          if(a.category == this.type || this.type == '全部'){
            this.bookData.push(a)
            this.tempBookData.push(a)
            i++
          }
        }
        this.total = i
        this.flag = true
      })
    },
    beforeDestroy(){
      this.$bus.$off('search')
    }
  }
</script>

<style scoped>
    .show{
        background-color: white;
        width: 100%;
        /* height: 700px; */
        height: auto;
        position: relative;
        top:20px;
    }
</style>