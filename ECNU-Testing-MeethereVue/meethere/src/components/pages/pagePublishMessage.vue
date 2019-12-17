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
            v-model="textarea"
            maxlength="150"
            :autosize="{ minRows: 15}"
            show-word-limit
            class = "text-input"
            >
         </el-input>
        </el-col>
      </el-row>
    <PublishButton class="button"></PublishButton>
  </el-main>
  </el-container>
  </div>
</template>

<script>
import PublishButton from '../buttons/publishButton'
export default {
  name: 'pagePublishMessage',
  components: {PublishButton},
  data () {
    return {
      text: '',
      textarea: ''
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
