<template>
  <el-container>
    <el-main>
      <el-row type="flex" justify="center">
        <el-col :span="12">
          <div>
            <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
              <el-form-item label="账号" prop="userName">
                <el-input v-model="ruleForm.userName"></el-input>
              </el-form-item>
              <el-form-item label="昵称" prop="userNickName">
              <el-input v-model="ruleForm.userNickName"></el-input>
            </el-form-item>
              <el-form-item label="密码" prop="pass">
                <el-input type="passWords" v-model="ruleForm.pass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPass">
                <el-input type="passWords" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'pageSignIn',
  data () {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      ruleForm: {
        pass: '',
        checkPass: '',
        userName: '',
        userNickName: ''
      },
      rules: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios
            .post('/user/register', {
              nickname: this.ruleForm.userNickName,
              password: this.ruleForm.pass,
              name: this.ruleForm.userName,
              userID: '1'
            })
            .then(res => {
              console.log(this.username, this.password)
              console.log('用户注册成功', res)
              this.$message({
                message: '用户注册成功',
                type: 'success'
              })
              this.$refs[formName].resetFields()
            })
            .catch(failResponse => {
              console.log(this.ruleForm.userName, this.ruleForm.userNickName, this.ruleForm.pass)
              console.log('用户注册失败', failResponse)
              this.$message({
                message: '用户注册失败',
                type: 'error'
              })
            })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}

</script>

<style scoped>

</style>
