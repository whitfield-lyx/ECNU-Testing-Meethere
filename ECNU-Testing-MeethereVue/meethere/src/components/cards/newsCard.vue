<template>
  <el-card class="box-card">
    <div slot="header" >
      <el-row>
        <el-col span="18">
          <span class="publisher-text">{{title}}</span>
        </el-col>
        <el-col offset="4" span="2">
          <el-button type="danger" icon="el-icon-close" circle @click="deleteNews" ></el-button>
        </el-col>
      </el-row>
    </div>
    <div style="text-align: left;text-indent:2em;">
      {{content}}
    </div>
    <p style="text-align: right;"><span>{{time}}</span></p>
  </el-card>
</template>

<script>
export default {
  inject: ['reload'],
  name: 'newsCard',
  props: [
    'newsData'],
  data () {
    return {
      title: this.newsData.title,
      content: this.newsData.content,
      time: this.newsData.time,
      newsId: this.newsData.newsId
    }
  },
  methods: {
    deleteNews () {
      this.$confirm('确认删除吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.reload()
        var self = this
        self.$axios
          .delete('/news/' + this.newsId)
        console.log('删除新闻成功')
        this.$message({
          message: '删除新闻成功',
          type: 'success'
        })
      }).catch(function (error) {
        console.log('删除新闻失败', error)
        this.$message.error('删除失败')
      })
    }
  }
}
</script>

<style scoped>
  .box-card{
    background: #E9D3FF;
  }
  .publisher-text{
    text-align: left;
    font-size: 20px;
  }
</style>
