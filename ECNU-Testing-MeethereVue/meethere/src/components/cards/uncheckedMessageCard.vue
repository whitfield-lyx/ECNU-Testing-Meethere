<template>
  <el-card class="box-card">
    <div slot="header" >
        <el-row >
          <el-col :span="6">
            <span class="publisher-text">{{username}}</span>
          </el-col>
          <el-col :span="4">
            <span class="publisher-text">{{username}}</span>
          </el-col>
          <el-col :span="8" :offset="6">
            <el-button type="primary" icon="el-icon-check"  circle ></el-button>
            <el-button type="danger" icon="el-icon-close"  circle ></el-button>
          </el-col>
        </el-row>
    </div>
    <div >
      {{context}}
    </div>
    <p style="text-align: right;"><span>{{time}}</span></p>
  </el-card>
</template>

<script>
export default {
  name: 'uncheckedMessageCard',
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

  }
  .publisher-text{
    text-align: left;
    font-size: 20px;
  }
</style>
