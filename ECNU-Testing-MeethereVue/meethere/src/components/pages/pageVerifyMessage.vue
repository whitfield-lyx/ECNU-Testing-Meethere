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
          <el-menu-item index="Verify">
            <i class="el-icon-menu"></i>
            <span slot="title">审核留言</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <el-main>
          <div v-for="message in messages" v-bind:key="message.time">
           <unchecked-message-card class="box-card" v-bind:messages-data="message"></unchecked-message-card>
          </div>
        </el-main>
        <el-footer>
          <el-pagination
            small
            layout="prev, pager, next"
            :total="50">
          </el-pagination>
        </el-footer>
      </el-container>
    </el-container>
    <router-view></router-view>
  </div>
</template>

<script>

import UncheckedMessageCard from '../cards/uncheckedMessageCard'
export default {
  name: 'pageVerifyMessage',
  components: {UncheckedMessageCard},
  data () {
    return {
      messages: [
        {
          messageId: '1',
          userId: '1',
          content: 'Hello!Hello!Hello!Hello!Hello!',
          time: '2019-12-17',
          isChecked: '1'
        }
      ]
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
