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
  name: 'newsCard',
  props: [
    'newsData'],
  data () {
    return {
      username: this.newsData.username,
      context: this.newsData.context,
      time: this.newsData.time
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
