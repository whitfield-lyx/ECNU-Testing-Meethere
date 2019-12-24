<template>
  <main>
    <!-- 左侧导航 -->
    <div class="main-left">
      <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
        <el-menu-item index="Booking" >
          <i class="el-icon-menu"></i>
          <span slot="title">场馆列表</span>
        </el-menu-item>
        <el-menu-item index="User" >
          <i class="el-icon-menu"></i>
          <span slot="title">用户管理</span>
        </el-menu-item>
      </el-menu>
    </div>
    <!-- 右侧主内容区 -->
    <div class="main-right" >
      <div class="block">
        <template>
          <el-table
            :data="UserData"
            style="margin-top: 20px">
            <el-table-column
              prop="userName"
              label="用户账号"
              width="200">
            </el-table-column>
            <el-table-column
              prop="nickName"
              label="用户昵称"
              width="200">
            </el-table-column>
            <el-table-column
              prop="password"
              label="用户密码">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="200">
              <template slot-scope="scope">
                <el-button type="info" round @click="ResetPass(scope.row)">密码重置</el-button>
              </template>
            </el-table-column>
          </el-table>
        </template>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: 'pageUser',
  inject: ['reload'],
  data () {
    return {
      stadiumId: '',
      userId: sessionStorage.getItem('userId'),
      userType: sessionStorage.getItem('userType'),
      UserData: [{
        userId: '0',
        userName: '未获得账户名',
        nickName: '未获得昵称',
        password: '未获得密码'
      }],
      firstPassword: '000000'
    }
  },
  mounted () {
    var self = this
    var users = []
    self.$axios
      .get('/user/userInfo')
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          var obj = {}
          obj.userId = res.data[i].userId
          obj.userName = res.data[i].name
          obj.nickName = res.data[i].nickname
          obj.password = res.data[i].password
          users[i] = obj
        }
        self.UserData = users
        console.log('用户获取成功', res)
      })
      .catch(function (error) {
        console.log('用户获取失败', error)
      })
  },
  methods: {
    ResetPass (row) {
      this.reload()
      var self = this
      self.$axios
        .post('/user/userInfo', {
          userId: row.userId,
          name: row.userName,
          nickname: row.nickName,
          password: this.firstPassword
        }).then(res => {
          this.$message({
            message: '重置密码成功',
            type: 'success'
          })
          console.log('重置密码成功', res)
        }).catch(function (error) {
          console.log('重置密码失败', error)
          this.$message({
            message: '重置密码失败',
            type: 'warning'
          })
        })
      this.reload()
      this.$forceUpdate()
    }
  }
}
</script>

<style scoped>

</style>
