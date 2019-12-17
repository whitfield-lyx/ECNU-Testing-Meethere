<template>
  <div>
    <el-container>
      <el-aside>
        <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
          <el-menu-item index="Message" :class="{'isActive': active}" >
            <i class="el-icon-menu"></i>
            <span slot="title">查看留言</span>
          </el-menu-item>
          <el-menu-item index="Publish" :class="{'isActive': active}" >
            <i class="el-icon-menu"></i>
            <span slot="title">发布留言</span>
          </el-menu-item>
          <el-menu-item index="Verify" :class="{'isActive': active}" >
            <i class="el-icon-menu"></i>
            <span slot="title">审核留言</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
      <el-main>
        <el-form v-for="message in Messages">
          <message-card class="box-card" v-bind:messages-data="message"></message-card>
        </el-form>
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
import MessageCard from '../cards/messageCard'
export default {
  name: 'pageMessage',
  components: {MessageCard},
  data () {
    return {
      Messages: [{
        username: '废柴阿翔',
        context: 'Hello!Hello!Hello!Hello!Hello!',
        time: '2019-12-17'
      },
      {
        username: '废柴阿翔2',
        context: 'Hello!Hello!Hello!Hello!Hello!',
        time: '2019-12-17'
      }
      ]
    }
  },
  mounted () {
    var self = this
    var news = []
    self.$axios
      .get('/messages')
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          var obj = {}
          obj.userNickname = res.data[i].userNickname
          obj.content = res.data[i].content
          obj.time = res.data[i].time
          news[i] = obj
        }
        self.tableData = news
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
