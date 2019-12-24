<template>
  <div id="app">
    <header class="header">
      <el-row>
        <el-col :span="8" :offset="8">
      <el-link  style = "font-size: 30px" type="primary" >Welcome to the MeetHere System！</el-link>
        </el-col>
        <el-col :span="4" :offset="4">
      <el-button style="margin-right: 20px; margin-top: 5px" type="danger" size="mini" @click="logOut">退出登录</el-button>
        </el-col>
      </el-row>
      <el-row v-if="$route.meta.keepalive">
        <el-col :span="24">
          <el-menu default-active="" class="el-menu-demo" mode="horizontal"  :router="true">
            <el-menu-item index= "/Main/Booking">
              <i class="el-icon-star-on"></i>
              场馆预约
            </el-menu-item>
            <el-menu-item index= "/Main/Order">
              <i class="el-icon-s-order"></i>
              订单管理
            </el-menu-item>
            <el-menu-item index= "/Main/News">
              <i class="el-icon-data-analysis"></i>
              查看新闻
            </el-menu-item>
            <el-menu-item index= "/Main/Message">
              <i class="el-icon-chat-line-round"></i>
              留言管理
            </el-menu-item>
            <el-menu-item index= "/Main/Information">
              <i class="el-icon-medal"></i>
              个人信息
            </el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </header>
    <router-view v-if="isRouterAlive"></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  provide () {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    },
    logOut () {
      sessionStorage.clear()
      this.$router.push({
        name: 'Login'
      })
    }
  }
}
</script>

<style scoped>
  #app {
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 0px;
  }
  header{
    z-index: 1000;min-width: 1200px;
    transition: all 0.5s ease;
    border-top: solid 4px #3091F2;
    background-color: #fff;
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.12),0 0 6px 0 rgba(0,0,0,.04);
  }
  header .el-menu-demo{
    padding-left: 300px!important;
  }
</style>
