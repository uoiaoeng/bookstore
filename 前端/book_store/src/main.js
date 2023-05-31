import Vue from 'vue'
import App from './App.vue'

//引入elementUI组件库
import elementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

//引入VueRouter
import VueRouter from 'vue-router'
//引入路由器
import router from './router/index'

Vue.use(elementUI)
Vue.use(VueRouter)
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router:router,
  beforeCreate(){
		Vue.prototype.$bus = this  //安装全局事件总线
	}
}).$mount('#app')
