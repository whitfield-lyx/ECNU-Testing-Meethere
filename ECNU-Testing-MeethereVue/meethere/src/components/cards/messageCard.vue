<template>
  <el-card class="box-card">
    <div slot="header" >
      <p class="publisher-text"><span>{{username}}</span></p>
    </div>
    <div >
      {{context}}
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
      username: this.messagesData.username,
      context: this.messagesData.context,
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
