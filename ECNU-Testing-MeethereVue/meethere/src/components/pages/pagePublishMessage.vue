<template>
  <div><el-container>
  <el-aside>
    <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
        <el-menu-item index="Message" >
          <i class="el-icon-menu"></i>
          <span slot="title">查看留言</span>
        </el-menu-item>
        <el-menu-item index="Publish">
          <i class="el-icon-menu"></i>
          <span slot="title">发布留言</span>
        </el-menu-item>
      <el-menu-item index="Verify">
        <i class="el-icon-menu"></i>
        <span slot="title">审核留言</span>
      </el-menu-item>
      </el-menu>
  </el-aside>
  <el-main>
      <el-row>
        <el-col>
          <el-input
            type="textarea"
            placeholder="请输入内容"
            v-model="content"
            maxlength="150"
            :autosize="{ minRows: 15}"
            show-word-limit
            class = "text-input"
            >
         </el-input>
        </el-col>
      </el-row>
    <el-button type="warning" round @click="PublishMessage">发布！</el-button>
  </el-main>
  </el-container>
  </div>
</template>

<script>

export default {
  name: 'pagePublishMessage',
  inject: ['reload'],
  data () {
    return {
      content: ''
    }
  },
  methods: {
    PublishMessage () {
      this.$confirm('确认发布吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.reload()
        var self = this
        self.$axios
          .post('/message', {
            messageId: '0',
            userId: '111',
            content: this.content,
            time: new Date(),
            isChecked: '0'
          })
        console.log('发布留言成功')
        this.$message({
          message: '发布留言成功',
          type: 'success'
        })
      }).catch(function (error) {
        console.log('发布留言失败', error)
        this.$message.error('发布留言')
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
