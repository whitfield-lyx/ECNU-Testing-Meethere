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
              placeholder="请输入内容"
              v-model="textarea"
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
  data () {
    return {
      textarea: ''
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
            context: this.textarea,
            userId: '1'
          })
      }).catch(function (error) {
        console.log('获取Player的Money失败', error)
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
