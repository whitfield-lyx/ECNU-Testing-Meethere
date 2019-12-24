<template>
  <el-card class="box-card">
    <div slot="header" >
      <el-row>
        <el-col :span=6>
          <span class="publisher-text">{{nickname}}</span>
        </el-col>
        <el-col :span=4 :offset=14>
          <el-button v-if="nickname==myUserId&&isEdit==0" type="info"  icon="el-icon-edit"  circle @click="editMessage()" ></el-button>
          <el-button  v-if="isEdit==1" type="success"  icon="el-icon-check"  circle @click="editMessageComplete()" ></el-button>
        </el-col>
      </el-row>
    </div>
    <div v-if="isEdit==0" style="text-align: left;text-indent:2em;">{{content}}</div>
    <el-input
      v-if="isEdit==1"
      type="textarea"
      placeholder="请输入内容"
      v-model="content"
      maxlength="150"
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
  name: 'messageCard',
  props: [
    'messagesData'],
  data () {
    return {
      messageId: this.messagesData.messageId,
      userId: this.messagesData.userId,
      isChecked: this.messagesData.isChecked,
      content: this.messagesData.content,
      time: this.messagesData.time,
      nickname: this.messagesData.nickname,
      myUserId: sessionStorage.getItem('userNickName'),
      isEdit: '0'
    }
  },
  methods: {
    editMessage () {
      this.isEdit = '1'
    },
    editMessageComplete () {
      this.reload()
      var self = this
      self.$axios
        .put('/message/update/' + this.messageId, {
          userId: this.userId,
          messageId: this.messageId,
          isChecked: 0,
          content: this.content,
          time: this.time,
          nickname: this.nickname
        })
      console.log('修改留言成功')
      this.$message({
        message: '修改留言成功',
        type: 'success'
      })
      this.isEdit = '0'
      this.reload()
    }
  }
}
</script>

<style scoped>
  .box-card{
    background: #D3FDCA;
  }
  .publisher-text{
    text-align: left;
    font-size: 20px;
  }
</style>
