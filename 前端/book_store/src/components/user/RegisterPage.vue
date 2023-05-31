<template>
    <div>
        <i class="el-icon-arrow-left" @click="backLogin"></i>
        <span class="text_re">注册</span>
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="账号" prop="username">
                <el-input type="text" v-model="ruleForm.username" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
                <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="年龄" prop="age">
                <el-input type="text" v-model.number="ruleForm.age" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="邮箱地址" prop="email">
                <el-input v-model="ruleForm.email" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-radio v-model="ruleForm.sex" label="1">男</el-radio>
                <el-radio v-model="ruleForm.sex" label="2">女</el-radio>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import axios from 'axios'
    import {getByUsername} from '@/api/modules/user'
    export default{
        name:'RegisterPage',
        data() {
            var checkAge = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('年龄不能为空'));
                }   
                setTimeout(() => {
                    if (!Number.isInteger(value)) {
                        callback(new Error('请输入数字值'));
                    } else {
                        if (value < 18) {
                            callback(new Error('必须年满18岁'));
                        } else {
                            callback();
                        }
                    }
                }, 1000);
            };
            
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };

            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };

            var validateUsername = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('请输入账号'));
                }else{
                    getByUsername({username:this.ruleForm.username})
                    .then(res=>{
                        console.log(res);
                        if(res.message == "用户名存在"){
                            callback(new Error('用户名已存在'))
                        }
                        callback();
                    })
                    .catch(err=>{
                        console.log('请求发送失败',err.message)
                    })
                }
            };

            return {
                ruleForm: {
                    username: '',
                    password: '',
                    checkPass: '',
                    age: '',
                    sex:'',
                    email:''
                },
        
                rules: {
                    password: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],
                    age: [
                        { validator: checkAge, trigger: 'blur' }
                    ],
                    username: [
                        { validator: validateUsername, trigger: 'blur' }
                    ],
                    email:[
                        {type:'email',message:'邮箱格式不正确', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log('submit',this.ruleForm);

                        let params = this.ruleForm
                        let url='/user/register'

                        axios.post(url,params)
                        .then(res=>{
                            if(res.statusCode=='400'){
                                console.log('用户名存在',res.data.message);
                                alert('注册失败，用户名已存在')
                            }else{
                                alert('注册成功')
                                console.log('注册成功',res)
                                this.$router.push({
                                    name:'login'
                                })
                            }
                        })
                        .catch(err=>{
                            alert('注册失败1',err.message)
                            console.log('请求发送失败',err)
                        })
                    } else {
                        alert('注册失败2 ')
                        console.log('注册失败');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();

            },
            backLogin(){
                this.$router.push({
                    name:'login'
                })
            }
        },
        mounted(){
			axios.defaults.baseURL = '/api'
		},
  }
</script>

<style scoped>

.demo-ruleForm{
    position: relative;
    top: 100px;
    left: 100px;
    width: 400px;
}
.text_re{
    font-size: 30px;
    position: relative;
    left: 280px;
    top: 50px;
}
i{
    position: relative;
    top: 30px;
    left: 20px;
}
i:hover{
    color: aqua;
}

</style>