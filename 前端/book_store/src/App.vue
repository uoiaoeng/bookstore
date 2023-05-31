<template>
  <div class="myApp">
    <router-view></router-view>
    <MyFooter></MyFooter>
  </div>
</template>

<script>

import MyFooter from './components/MyFooter'

export default {
  name: 'App',
  components: {
    MyFooter,
  },
}
</script>

<style>
  .myApp{
    /* height: 1200px; */
    height: auto;
    background-color: rgb(244, 237, 237);
  }
  i{
    cursor: pointer;
    font-size: 50px;
  }
</style>
