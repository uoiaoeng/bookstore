// 该文件专门用于创建整个应用的路由器
import VueRouter from "vue-router";
import HomePage from '../components/home/HomePage'
import CollectionPage from '../components/collect/CollectionPage'
import UserPage from '../components/user/UserPage'
import UserLogin from '../components/user/UserLogin'
import UserInfo from '../components/user/UserInfo'
import RegisterPage from '../components/user/RegisterPage'
import Manage from '../components/user/Manage'
import DetailPage from '../components/home/DetailPage'



const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err);
}

//创建并暴露一个路由器
export default new VueRouter({
    scrollBehavior (to, from, savedPosition) {
        // 解决路由跳转后 会滚动到底部
        if (savedPosition) {
          return savedPosition
        } else {
          return { x: 0, y: 0 }
        }
    },
    routes:[
        {
            name:'home',
            path:'/home',
            component:HomePage,
            // children:[
            //     {
            //         name:'type1',
            //         path:'type1/:type',
            //         component:TypePage1
            //     }
            // ]
        },
        {
            name:'collection',
            path:'/collection',
            component:CollectionPage
        },
        {
            name:'detail',
            path:'/detail/:bookData:userData:isActive',
            component:DetailPage
        },
        {
            name:'user',
            path:'/user',
            component:UserPage,
            children:[
                {
                    name:'login',
                    path:'login',
                    component:UserLogin
                },
                {
                    name:'info',
                    path:'info/:username',
                    component:UserInfo
                },
                {
                    name:'register',
                    path:'register',
                    component:RegisterPage
                },
                {
                    name:'manage',
                    path:'manage',
                    component:Manage
                },
            ]
        },
        {
            path:'/',
            redirect:'/home'
        },
    ]
})