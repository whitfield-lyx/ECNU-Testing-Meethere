<template>
  <el-container>
    <el-main>
      <el-row type="flex" justify="center">
        <el-col :span="12">
            <div style="margin-top: 20px; margin-bottom: 20px">
              <el-radio v-model="userType" label="user" border size="medium" class="chooseUser">普通用户</el-radio>
              <el-radio v-model="userType" label="admin" border size="medium" class="chooseUser">管理员</el-radio>
            </div>
          <div>
            <el-input v-model="username" placeholder="请输入用户名" clearable class="input_style"> </el-input>
            <el-input v-model="password" placeholder="请输入密码" show-password class="input_style"> </el-input>
            <el-button type="primary" @click="login" class="login_style">登录</el-button>
            <el-button  @click="signIn" class="login_style">注册</el-button>
          </div>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'pageLogin',
  data () {
    return {
      username: '',
      password: '',
      userType: 'user',
      responseResult: ''
    }
  },
  methods: {
    login () {
      if (this.userType === 'user') {
        this.$axios
          .post('/user/login', {
            name: this.username,
            password: this.password
          })
          .then(successResponse => {
            this.responseResult = JSON.stringify(successResponse.data)
            if (successResponse.data.code === 200) {
              sessionStorage.setItem('userName', this.username)
              sessionStorage.setItem('userType', this.userType)
              this.$message({
                message: '用户登录成功',
                type: 'success'
              })
              this.$router.replace({path: '/Main/Booking'})
            } else {
              this.$message({
                message: '用户登录失败',
                type: 'warning'
              })
            }
          })
          .catch(failResponse => {
            this.$message({
              message: '用户登录失败',
              type: 'warning'
            })
            console.log(this.username, this.password)
            console.log('用户登录失败')
          })
      } else {
        this.$axios
          .post('/admin/login', {
            name: this.username,
            password: this.password
          })
          .then(successResponse => {
            this.responseResult = JSON.stringify(successResponse.data)
            if (successResponse.data.code === 200) {
              sessionStorage.setItem('userName', this.username)
              sessionStorage.setItem('userType', this.userType)
              this.$router.replace({path: '/Main/Booking'})
              this.$message({
                message: '管理员登录成功',
                type: 'success'
              })
            } else {
              this.$message({
                message: '管理员登录失败',
                type: 'warning'
              })
            }
          })
          .catch(failResponse => {
            console.log('管理员登录失败')
            this.$message({
              message: '管理员登录失败',
              type: 'warning'
            })
          })
      }
    },
    signIn () {
      this.$router.push({
        name: 'SignIn'
      })
    }
  }
}
</script>

<style scoped>
  .login{
    margin-top: 200px;
  }
  .chooseUser{
    width: 150px;
  }
  .input_style{
    width: 400px;
    margin-bottom: 10px;
  }
  .login_style{
    width: 400px;
    margin-bottom: 10px;
  }
</style>
