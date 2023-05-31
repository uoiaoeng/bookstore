<template>
    <div class="bookList">
        <BookCategory></BookCategory>
        <BookShow></BookShow>
    </div>
</template>

<script>

import BookCategory from './BookCategory.vue'
import BookShow from './BookShow.vue'

    export default {
        name:'BookList',
        components:{
            BookCategory,
            BookShow
        },
    }
</script>

<style scoped>
    .bookList{
        background-color: white;
        width: 100%;
        /* height: 700px; */
        height: auto;
        position: relative;
        top: 210px;
    }
</style>