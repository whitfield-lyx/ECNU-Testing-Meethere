<template>
  <el-card class="box-card">
    <div slot="header" >
        <el-row >
          <el-col :span="6">
            <span class="publisher-text">{{nickname}}</span>
          </el-col>
          <el-col :span="4">
            <span class="publisher-text">{{checked}}</span>
          </el-col>
          <el-col :span="8" :offset="6">
            <el-button type="primary" icon="el-icon-check" @click="checkMessage"  circle ></el-button>
            <el-button type="danger" icon="el-icon-close" @click="deleteMessage"  circle ></el-button>
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
  inject:['reload'],
  name: 'uncheckedMessageCard',
  props: [
    'messagesData'],
  data () {
    return {
      messageId: this.messagesData.messageId,
      userId: this.messagesData.userId,
      isChecked: this.messagesData.isChecked,
      content: this.messagesData.content,
      time: this.messagesData.time,
      nickname: this.messagesData.nickname
    }
  },
  computed: {
    checked: function () {
      if (this.isChecked === 0) { return '未审核' } else { return '已审核' }
    }
  },
  methods: {
    checkMessage () {
      this.$confirm('确认审核吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.reload()
        var self = this
        self.$axios
          .post('/message/check/' + this.messageId)
        console.log('审核留言成功')
        this.$message({
          message: '审核留言成功',
          type: 'success'
        })
      }).catch(function (error) {
        console.log('审核留言失败', error)
        this.$message.error('审核留言失败')
      })
    },
    deleteMessage () {
      this.$confirm('确认删除吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.reload()
        var self = this
        self.$axios
          .delete('/message/' + this.messageId)
        console.log('删除留言成功')
        this.$message({
          message: '删除留言成功',
          type: 'success'
        })
      }).catch(function (error) {
        console.log('删除留言失败', error)
        this.$message.error('删除留言失败')
      })
    }
  }
}
</script>

<style scoped>
  .box-card{

  }
  .publisher-text{
    text-align: left;
    font-size: 20px;
  }
</style>
