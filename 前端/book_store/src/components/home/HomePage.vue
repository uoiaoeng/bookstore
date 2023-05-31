<template>
    <div class="home">
      <SearchBox title="主页"></SearchBox>
      <ShufPicture></ShufPicture>
      <BookList></BookList>
    </div>
</template>
  
<script>
  
import SearchBox from '../SearchBox.vue'
import ShufPicture from './ShufPicture'
import BookList from './BookList'
  
  export default {
        name: 'App',
        components: {
            SearchBox,
            ShufPicture,
            BookList,
        },
  }
</script>
  
<style>
  .home{
    /* height: 1200px; */
    min-height:1500px;
    height: auto;
    /* width: 50%; */
    width: 759px;
    position:absolute;
    left: 380px;
    /* left: 25%; */
    background-color: white;
    box-shadow: 0px 0px 5px rgb(142, 137, 137);
  }
</style>
  