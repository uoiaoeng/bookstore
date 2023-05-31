<template>
    
    <div class="collect">
        <SearchBox title="收藏"></SearchBox>
        <div v-for="(p,index) in total" :key="index">
          <BookCard
            :bookData="tempBookData[p]"
            
            :userData="userData">
          </BookCard>
        </div>
    </div>
</template>

<script>

  import SearchBox from '@/components/SearchBox.vue'
  import BookCard from '@/components/home/BookCard.vue'
  import {AllList} from "@/api/modules/book"
  import {getByUsername} from "@/api/modules/user"
  export default {
    name:'CollectionPage',
    data(){
        return{
            total:'',
            bookData:[],
            tempBookData:[],
            userData:{},
            searchInput:'',
            flag:'false'
        }
    },
    components:{
        SearchBox,
        BookCard,
    },
    methods:{
    },
    mounted(){
        this.$bus.$on('search',(input)=>{
            console.log('cs');
            this.searchInput = input
            this.tempBookData = []
            this.tempBookData.push(0)
            var i = 0
            for(var book of this.bookData){
                if(input == book.name){
                    this.tempBookData.push(book)
                    i++
                }
            }
            if(i==0){
                alert('无此书')
                this.tempBookData = this.bookData
                this.tempBookData.unshift(0)
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
            var likeBookId = this.userData.likeBookId.split(',')

            for(var a of res.data){
                for(var bookId of likeBookId)

                    if(a.id == bookId){
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

<style>
.collect{
    height: 1200px;
    width: 759px;
    position:absolute;
    left: 380px;
    background-color: white;
    box-shadow: 0px 0px 5px rgb(142, 137, 137);
}
</style>