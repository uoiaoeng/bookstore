<template>
  <div style="position: relative; top: 70px;"> 
    <i class="el-icon-arrow-left" @click="back"></i>

   <!-- <div class="search">
    <el-form ref="searchForm" :model="searchForm" :inline="true" class="formItem" label-width="80px">
        <el-col :xl="6" :md="8" :sm="24">
          <el-form-item label="字典类型名称" prop="name" >
            <el-input  placeholder="请输入字典类型名称" v-model="searchForm.name" clearable></el-input>
          </el-form-item>
        </el-col>

            <el-col :xl="6" :md="8" :sm="24">
          <el-form-item label="字典类型值" prop="name" >
            <el-input  placeholder="请输入字典类型值" v-model="searchForm.value" clearable></el-input>
          </el-form-item>
        </el-col>

        <el-col :xl="6||24" :md="8||24" :sm="24">
          <el-form-item>
            <div :style=" { float: 'right', overflow: 'hidden' } || {} ">
              <el-button icon="el-icon-search" type="primary" @click="search">搜索</el-button>
            </div>
          </el-form-item>
        </el-col>
      </el-form>
  </div> -->

  
    <div style="position: relative; left: 300px;">
      <el-button type="primary" @click="add" >新增</el-button>
      <el-button type="primary" @click="delAll" >批量删除</el-button>
    </div>
      <pageTable @load-table-data="loadTableData" ref="dataTable"  @selection-change="selectionChange"
                      row-key="id">
          <template slot="tb-columns">

            <el-table-column prop="name" label="书名" align="center"></el-table-column>
            
            <el-table-column prop="price" label="价格" align="center"></el-table-column>
            <el-table-column prop="category" label="类别" align="center"></el-table-column>
            <el-table-column prop="author" label="作者" align="center"></el-table-column>

             <el-table-column fixed="right" label="操作" width="100">
              <template slot-scope="scope">
                <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
                <el-button @click="delOne(scope.row.id)" type="text" size="small">删除</el-button>
              </template>
            </el-table-column>
          </template>
      </pageTable>
      
      <Edit :title="title" :visible="visible" v-if="visible" :defaultFormData="defaultFormData" @close=close></Edit>
  </div>
</template>

<script>
  import {deleteByIds,pageList} from "@/api/modules/book"
  import Edit from "@/components/user/Edit.vue"
  import PageTable from '@/components/tools/PageTable.vue'
  export default {
    name:"index",
    components:{PageTable,Edit},
    data(){
        return {
          title:"新增",
          visible:false,
          defaultFormData:{},
          ids:'',
          searchForm:{
              name:'',
              price:'',
              category:'',
              author:''
          }
        }
    },
    methods:{
      search(){
        this.$refs.dataTable.loadTableData('reload')
      },
      selectionChange(selection){
        //selection表示选中的记录 array
        var aryIds = []
        for(var item of selection){
            aryIds.push(item.id)
        }

        this.ids = aryIds.join(",")

      },
      delAll(){
        if(this.ids.length <=0){
          this.$message({
            message: '请先选择记录',
            type: 'warning'
          });
          return
        }
        this.del(this.ids)
      },
    
      delOne(id){
        this.del(id)
      },
      del(ids){
        this.$confirm('是否确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          //点击确认的时候 触发
          
        deleteByIds({ids:ids}).then(res =>{
          this.$message({
            message:'删除成功',
            type:'success'
          });
          //reload
          this.$refs.dataTable.loadTableData('reload')
        }).catch(err =>{
              console.log(err)
          })
        }).catch(() => {

        //点击取消的时候触发         
        });
    },
      close(val){
        this.visible = false
        if(val){
          //reload
          this.$refs.dataTable.loadTableData('reload')
          //this.$refs.dataTable = document.getElementById('dataTable')
        }
      },
      add(){
        this.visible = true
        this.defaultFormData = {}
      },
      edit(obj){
        this.visible = true
        this.title = "编辑"
        this.defaultFormData = obj
      },
      loadTableData(filter,callback){
        console.log(filter);
        pageList({
          ...filter,
        })
        .then(res =>{
          // console.log('res',res);
          //res = result
          let data = {
            data:res.data.records,
            total:res.data.total
          }
          //data
          callback(data)
        })
        .catch(err =>{
          console.log(err);
        })
      },
      back(){
        console.log('aaa');
        this.$router.push({
          name:'info',
          params:{
            username:localStorage.getItem('username')
          }
        })
      }
  }
}
</script>

<style scoped>
.el-icon-arrow-left{
  position: relative;
  top: -60px;
}
.el-icon-arrow-left:hover{
  color: aqua;
}
</style>