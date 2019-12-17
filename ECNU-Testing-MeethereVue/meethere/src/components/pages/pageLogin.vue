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
            <el-input v-model="userName" placeholder="请输入用户名" clearable class="input_style"> </el-input>
            <el-input v-model="passWord" placeholder="请输入密码" show-password class="input_style"> </el-input>
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
      userName: '',
      passWord: '',
      userType: 'user',
      responseResult: ''
    }
  },
  methods: {
    login () {
      this.$router.replace({path: '/Main/Booking'})
      if (this.userType === 'user') {
        this.$axios
          .post('/user/login', {
            userName: this.userName,
            passWord: this.passWord
          })
          .then(successResponse => {
            this.responseResult = JSON.stringify(successResponse.data)
            if (successResponse.data.code === 200) {
              this.$router.replace({path: '/Main/Booking'})
            }
          })
          .catch(failResponse => {
          })
      } else {
        this.$axios
          .post('/admin/login', {
            userName: this.userName,
            passWord: this.passWord
          })
          .then(successResponse => {
            this.responseResult = JSON.stringify(successResponse.data)
            if (successResponse.data.code === 200) {
              this.$router.replace({path: '/Main/Booking'})
            }
          })
          .catch(failResponse => {
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
