<template>
  <div>
    <el-container>
      <el-aside>
        <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
          <el-menu-item index="News" >
            <i class="el-icon-menu"></i>
            <span slot="title">查看新闻</span>
          </el-menu-item>
          <el-menu-item index="Publish">
            <i class="el-icon-menu"></i>
            <span slot="title">发布新闻</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main>
        <el-row>
          <el-col>
            <el-input
              type="textarea"
              placeholder="请输入标题"
              v-model="title"
              maxlength="20"
              show-word-limit
              class = "text-input">
            </el-input>
            <el-input
              type="textarea"
              placeholder="请输入内容"
              v-model="content"
              maxlength="150"
              :autosize="{ minRows: 15}"
              show-word-limit
              class = "text-input">
            </el-input>
          </el-col>
        </el-row>
        <el-button type="warning" round @click="PublishNews">发布！</el-button>
      </el-main>
    </el-container>
  </div>
</template>

<script>

export default {
  name: 'pagePublishNews',
  inject: ['reload'],
  data () {
    return {
      title: '',
      content: ''
    }
  },
  methods: {
    PublishNews () {
      this.$confirm('确认发布吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.reload()
        var self = this
        self.$axios
          .post('/news', {
            newsId: '0',
            title: this.title,
            content: this.content,
            name: 'test',
            time: '2019-08-08 08:00:00'
          })
        console.log('发布新闻成功')
        this.$message({
          message: '发布新闻成功',
          type: 'success'
        })
      }).catch(function (error) {
        console.log('发布新闻失败', error)
        this.$message.error('发布失败')
      })
    }
  }
}
</script>

<style scoped>
  .text-input{
    margin-top: 20px;
    margin-left: 20px;
  }
  .button{
    offset: auto;
  }
</style>
