<template>
  <el-card class="box-card">
    <div slot="header" >
      <p class="publisher-text"><span>{{username}}</span>
        <el-row :gutter="20">
          <el-col :span="8" :offset="21">
            <el-button type="primary" icon="el-icon-check"  circle ></el-button>
            <el-button type="danger" icon="el-icon-close"  circle ></el-button>
          </el-col>
        </el-row>
      </p>
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

  }
  .publisher-text{
    text-align: left;
    font-size: 20px;
  }
</style>
