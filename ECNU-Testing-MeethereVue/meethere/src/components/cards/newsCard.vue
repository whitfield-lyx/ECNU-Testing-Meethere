<template>
  <el-card class="box-card">
    <div slot="header" >
      <el-row>
        <el-col :span=14>
          <span class="publisher-text">{{title}}</span>
        </el-col>
        <el-col  :offset=6 :span=4>
          <div v-if="userType==='admin'">
          <el-button  v-if="isEdit==0"  type="info"  icon="el-icon-edit"  circle @click="editNews()" ></el-button>
          <el-button  v-if="isEdit==1" type="success"  icon="el-icon-check"  circle @click="editNewsComplete()" ></el-button>
          <el-button  type="danger" icon="el-icon-close" circle @click="deleteNews" ></el-button>
          </div>
        </el-col>
      </el-row>
    </div>
    <div v-if="isEdit==0" style="text-align: left;text-indent:2em;">
      {{content}}
    </div>
    <el-input
      v-if="isEdit==1"
      type="textarea"
      placeholder="请输入内容"
      v-model="content"
      maxlength="500"
      :autosize="{ minRows: 5}"
      show-word-limit
    >
    </el-input>
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
      newsId: this.newsData.newsId,
      userType: sessionStorage.getItem('userType'),
      isEdit: '0',
      userId: sessionStorage.getItem('userId')
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
    },
    editNews () {
      this.isEdit = '1'
    },
    editNewsComplete () {
      var self = this
      self.$axios
        .put('/news/update/' + this.newsId, {
          adminId: this.userId,
          content: this.content
        })
      console.log('修改新闻成功')
      this.$message({
        message: '修改新闻成功',
        type: 'success'
      })
      this.reload()
      this.isEdit = '0'
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
