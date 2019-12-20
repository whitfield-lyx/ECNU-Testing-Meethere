<template>
  <main>
    <!-- 左侧导航 -->
    <div class="main-left">
      <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
        <el-menu-item index="Booking" >
          <i class="el-icon-menu"></i>
          <span slot="title">场馆列表</span>
        </el-menu-item>
      </el-menu>
    </div>
    <!-- 右侧主内容区 -->
    <div class="main-right" >
      <div class="block">
        <el-row type="flex" class="row-bg" style="margin-bottom: 20px">
          <el-col :span="6" align="auto">
            <div class="grid-content bg-purple">
              <span>名称：</span>
              <el-input v-model="stadiumId" placeholder="请输入场地名称" clearable style="width: 200px"></el-input>
            </div>
          </el-col>
          <el-col align="auto" :span="2">
            <el-button type="warning" round @click="SearchStadium">搜索</el-button>
          </el-col>
          <el-col :span="6" align="auto">
            <el-date-picker
              v-model="day"
              type="date"
              placeholder="选择日期"
              :picker-options="pickerOptions">
            </el-date-picker>
          </el-col>
          <el-col :span="6" align="auto">
            <el-time-select
              v-model="hour"
              :picker-options="{
                  start: '00:00',
                  step: '01:00',
                   end: '24:00'}"
              placeholder="选择时间">
            </el-time-select>
          </el-col>
          <el-col :span="6" align="auto">
            <el-input-number v-model="timeLength" @change="handleChange" :min="1" :max="8" label="时长"></el-input-number>
          </el-col>
        </el-row>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: 'pageStadiumDetail'
}
</script>

<style scoped>

</style>
