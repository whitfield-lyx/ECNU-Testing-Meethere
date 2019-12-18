<template>
  <div>
    <el-container>
      <el-aside>
        <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
          <el-menu-item index="News" >
            <i class="el-icon-menu"></i>
            <span slot="title">查看新闻</span>
          </el-menu-item>
          <el-menu-item index="PublishNews" >
            <i class="el-icon-menu"></i>
            <span slot="title">发布新闻</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <el-main>
          <el-form v-for="news in News">
            <news-card class="box-card" v-bind:news-data="news"></news-card>
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
import NewsCard from '../cards/newsCard'
export default {
  name: 'pageNews',
  components: {NewsCard},
  data () {
    return {
      News: [{
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
      .get('/news')
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          var obj = {}
          obj.title = res.data[i].title
          obj.content = res.data[i].content
          obj.time = res.data[i].time
          news[i] = obj
        }
        self.tableData = news
        console.log('新闻获取成功', res)
      })
      .catch(function (error) {
        console.log('新闻获取失败', error)
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
