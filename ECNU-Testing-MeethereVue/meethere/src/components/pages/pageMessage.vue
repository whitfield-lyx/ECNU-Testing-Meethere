<template>
  <div>
    <el-container>
      <el-aside>
        <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
          <el-menu-item index="Message" >
            <i class="el-icon-menu"></i>
            <span slot="title">查看留言</span>
          </el-menu-item>
          <el-menu-item index="Publish" >
            <i class="el-icon-menu"></i>
            <span slot="title">发布留言</span>
          </el-menu-item>
          <el-menu-item index="Verify" v-if="userType==='admin'" >
            <i class="el-icon-menu"></i>
            <span slot="title">审核留言</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
      <el-main>
          <div v-for="message in messages" v-bind:key="message.time">
            <message-card class="box-card" v-bind:messages-data="message" v-if="message.isChecked==1"></message-card>
          </div>
      </el-main>
      <el-footer>
      </el-footer>
      </el-container>
    </el-container>
    <router-view></router-view>
  </div>
</template>

<script>
import MessageCard from '../cards/messageCard'
export default {
  name: 'pageMessage',
  components: {MessageCard},
  data () {
    return {
      messages: [
        {
          messageId: '1',
          userId: '1',
          context: 'Hello!Hello!Hello!Hello!Hello!',
          time: '2019-12-17',
          isChecked: '1',
          nickname: '我是nickname'
        }],
        userType: sessionStorage.getItem('userType')
    }
  },
  mounted () {
    var self = this
    var messages = []
    self.$axios
      .get('/message')
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          var obj = {}
          obj.messageId = res.data[i].messageId
          obj.userId = res.data[i].userId
          obj.content = res.data[i].content
          obj.time = res.data[i].time
          obj.isChecked = res.data[i].isChecked
          obj.nickname = res.data[i].nickname
          messages[i] = obj
        }
        self.messages = messages
        console.log('留言获取成功', res)
      })
      .catch(function (error) {
        console.log('留言获取失败', error)
      })
  }
}
</script>

<style scoped>
  .box-card {
    width: 1080px;
    margin-bottom: 20px;
  }
</style>
