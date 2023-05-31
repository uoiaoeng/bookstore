module.exports = {
  // pages: {
  //   index: {
  //     //入口
  //     entry: 'src/main.js',
  //   },
  // },


  publicPath: '/',
  outputDir: 'dist', // 打包的目录
  lintOnSave: true, // 在保存时校验格式
  productionSourceMap: false, // 生产环境是否生成 SourceMap

  // devServer:{
  //   proxy:{
  //     'api':{
  //       target:'http://localhost:8888/SpringBoot',
  //       pathRewrite: {
  //         '^/api': ''
  //       },
  //       ws:true,  //用于支持websocket
  //       changeOrigin: true   //用于控制请求头的host值，让请求来源的端口号跟服务器相同
  //     }
  //   }
  // }
  devServer: {
      open: true, // 启动服务后是否打开浏览器
      host: 'localhost',
      port: 8088, // 服务端口
      https: false,
      //hotOnly: false,

      //  api/book/save
      //  http://localhost:8888/SpringBoot/book/save
      proxy: {
          '/api': { 
              //名字必须跟application context相同 否则404
              target: 'http://localhost:8888/SpringBoot',
              changeOrigin: true, //  跨域
              pathRewrite: {
                  '^/api': ''
              }
          }
      }, // 设置代理
      //before: app => {}
  },
}