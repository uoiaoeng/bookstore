module.exports = {
  presets: [
    '@vue/app',
    ["@babel/preset-env", { "modules": false }]
  ],
  env: {
    development: {
      plugins: ['dynamic-import-node']
    }
  },
  plugins: [
    [
      "component",
      {
        "libraryName": "element-ui",
        "styleLibraryName": "theme-chalk"
      }
    ]
  ],
}




// module.exports = {
//   presets: [
//     '@vue/cli-plugin-babel/preset',
//     ["@babel/preset-env", { "modules": false }]
//   ],
//   plugins: [
//     [
//       "component",
//       {
//         "libraryName": "element-ui",
//         "styleLibraryName": "theme-chalk"
//       }
//     ]
//   ],
// }

