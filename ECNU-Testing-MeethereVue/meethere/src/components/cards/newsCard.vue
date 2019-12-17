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
  data () {
    return {
      username: '废柴阿翔',
      context: 'Hello!Hello!Hello!Hello!Hello!',
      time: '2019-12-17'
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
