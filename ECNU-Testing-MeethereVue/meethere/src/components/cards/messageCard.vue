<template>
  <el-card class="box-card">
    <div slot="header" >
      <p class="publisher-text"><span>{{userId}}</span></p>
    </div>
    <div style="text-align: left;text-indent:2em;">
      {{content}}
    </div>
    <p style="text-align: right;"><span>{{time}}</span></p>
  </el-card>
</template>

<script>
export default {
  name: 'messageCard',
  props: [
    'messagesData'],
  data () {
    return {
      messageId: this.messagesData.messageId,
      userId: this.messagesData.userId,
      isChecked: this.messagesData.isChecked,
      content: this.messagesData.content,
      time: this.messagesData.time
    }
  }
}
</script>

<style scoped>
  .box-card{
    background: #94C9FF;
  }
  .publisher-text{
    text-align: left;
    font-size: 20px;
  }
</style>
