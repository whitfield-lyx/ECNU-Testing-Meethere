<template>
  <el-main>
    <el-row type="flex" class="row-bg" justify="center">
      <el-col :span="8">
        <div class="grid-content bg-purple">
          <div class="head-image" style="position: relative; height: 100px">
            <el-avatar :size=60 icon="el-icon-user-solid"></el-avatar>
          </div>
        </div>
        <div>
          <el-form ref="form" :model="personForm" label-width="100px" >
            <el-form-item label="昵称:">
              <span>{{personForm.userNickname}}</span>
            </el-form-item>
            <el-form-item label="账号:">
              <span>{{personForm.userName}}</span>
            </el-form-item>
            <el-form-item label="用户类型:">
              <el-radio-group v-model="personForm.userType" disabled>
                <el-radio-button label="user">普通用户</el-radio-button>
                <el-radio-button label="admin">管理员</el-radio-button>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="修改密码" prop="pass">
              <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
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
</template>

<script>
export default {
  name: 'pageInformation',
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
      personForm: {
        userNickname: '废柴阿翔',
        userName: sessionStorage.getItem('userName'),
        userType: sessionStorage.getItem('userType')
      },
      ruleForm: {
        pass: '',
        checkPass: '',
        age: ''
      },
      rules: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      },
      userId: sessionStorage.getItem('userId')
    }
  },
  mounted () {
    var self = this
    self.$axios
      .get('/user/info')
      .then(res => {
        sessionStorage.setItem('userId', res.data.userId)
        sessionStorage.setItem('userNickName', res.data.nickname)
        console.log('昵称获取成功', res)
        this.personForm.userNickname = res.data.nickname
      })
      .catch(function (error) {
        console.log('昵称获取失败', error)
        this.personForm.userNickname = '无名'
      })
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios
            .post('/user/info', {
              userId: this.userId,
              password: this.ruleForm.pass
            })
            .then(successResponse => {
              this.$message({
                message: '修改密码成功',
                type: 'success'
              })
            }
            )
            .catch(failResponse => {
              console.log('修改密码失败')
              console.log(failResponse)
              this.$message({
                message: '修改密码失败',
                type: 'warning'
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
