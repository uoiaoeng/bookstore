<template>
    <div class="user">
        <router-view></router-view>
    </div>
</template>

<script>

    export default {
    name: "UserPage",
}
</script>

<style>
    .user{
        height: 1200px;
        width: 759px;
        position:absolute;
        left: 380px;
        background-color: white;
        box-shadow: 0px 0px 5px rgb(142, 137, 137);
    }
</style>