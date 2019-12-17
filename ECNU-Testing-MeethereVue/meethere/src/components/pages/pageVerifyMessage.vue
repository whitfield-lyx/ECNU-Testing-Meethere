<template>
  <div>
    <el-container>
      <el-aside>
        <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
          <el-menu-item index="Message" :class="{'isActive': active}" >
            <i class="el-icon-menu"></i>
            <span slot="title">查看留言</span>
          </el-menu-item>
          <el-menu-item index="Publish" :class="{'isActive': active}" >
            <i class="el-icon-menu"></i>
            <span slot="title">发布留言</span>
          </el-menu-item>
          <el-menu-item index="Verify" :class="{'isActive': active}" >
            <i class="el-icon-menu"></i>
            <span slot="title">审核留言</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <el-main>
          <unchecked-message-card class="box-card"></unchecked-message-card>
        </el-main>
        <el-footer>
          <el-pagination
            small
            layout="prev, pager, next"
            :total="50">
          </el-pagination>
        </el-footer>
      </el-container>
    </el-container>
    <router-view></router-view>
  </div>
</template>

<script>
import UncheckedMessageCard from '../cards/uncheckedMessageCard'
export default {
  name: 'pageVerifyMessage',
  components: {UncheckedMessageCard}
}
</script>

<style scoped>
  .box-card {
    width: 1080px;
  }
</style>
