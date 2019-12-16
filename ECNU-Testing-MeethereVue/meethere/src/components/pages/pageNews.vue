<template>
  <div>
    <el-container>
      <el-aside>
        <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
          <el-menu-item index="News" :class="{'isActive': active}" >
            <i class="el-icon-menu"></i>
            <span slot="title">查看新闻</span>
          </el-menu-item>
          <el-menu-item index="PublishNews" :class="{'isActive': active}" >
            <i class="el-icon-menu"></i>
            <span slot="title">发布新闻</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <el-main>
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>管理员1</span>
              <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>管理员1</span>
              <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>管理员2</span>
              <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 '}}
            </div>
          </el-card>
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
export default {
  name: 'pageNews'
}
</script>

<style scoped>
  .text {
    font-size: 14px;
  }
  .box-card{
    margin-bottom:20px;
  }
  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 1100px;
  }
</style>
