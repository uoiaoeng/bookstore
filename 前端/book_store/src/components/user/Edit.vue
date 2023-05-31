<template>
  <el-dialog :title="title" :visible="visible" :before-close="close">
      <el-form :model="form" :rules="rules" ref="form">
          <el-form-item label="书名" prop="name">
              <el-input v-model="form.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="价格"  prop="price">
              <el-input v-model="form.price" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="类别"  prop="category">
              <el-input v-model="form.category" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="作者"  prop="author">
              <el-input v-model="form.author" autocomplete="off"></el-input>
          </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
          <el-button @click="close">取 消</el-button>
          <el-button type="primary" @click="submit">确 定</el-button>
      </div>
  </el-dialog>
</template>

<script>
import {save,} from "@/api/modules/book"



export default {
  name:"edit",
  props:{
      visible:{
          type:Boolean,
          default:false
      },
      title:{
          type:String,
          default:"新增"
      },
      defaultFormData:{
          type:Object
      }
  },
  data(){
    var validatePrice = (rule, value, callback) => {
      if(isNaN(Number(value))){
        callback(new Error('价格必须为数字'))
      }
      callback();
    };

  return {
      flagOption:false, //false = add  true = update
      form:{
          name:'',
          price:'',
          category:'',
          author:''
      },
      flag:false,
      saveOrUpdate:false,
      rules:{
        name:[{required:true,message:"书名不能为空",trigger: "blur"},], //trigger: "blur" 失去焦点时才更新数据
              
        price:[{required:true,message:"价格不能为空", trigger: "blur"},
              {validator: validatePrice, trigger: 'blur'}],

        category:[{required:true,message:"类别不能为空", trigger: "blur"},],

        author:[{required:true,message:"作者不能为空", trigger: "blur"},] ,

      }
  }
  },
  mounted(){
      if(JSON.stringify(this.defaultFormData) == "{}"){
          //add
          this.flagOption = false
          this.saveOrUpdate= false
      }else{
          //edit
          this.form = JSON.parse(JSON.stringify(this.defaultFormData))
        
          this.flagOption = true
          this.saveOrUpdate= true
      }
  },
  methods:{
      close(){
          this.flag = false
          //emit
          this.$emit("close",this.flag)
      },
      submit(){
          this.$refs.form.validate(valid=>{
              if(valid){
                  //addOrUpdate
                  save({
                      ...this.form
                  }).then(res =>{
                      this.flag = true
                      this.$emit("close",this.flag)
                  })
                  .catch(err =>{
                      console.log(err)
                      this.flag = false
                      this.$emit("close",this.flag)
                  })
              }
          })
      }
  }
}
</script>