<template>
  <main>
    <!-- 左侧导航 -->
    <div class="main-left">
      <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
        <el-menu-item index="" >
          <i class="el-icon-menu"></i>
          <span slot="title">场馆列表</span>
        </el-menu-item>
      </el-menu>
    </div>
    <!-- 右侧主内容区 -->
        <div class="main-right" >
          <div class="block">
            <el-row :gutter="30" type="flex" class="row-bg" style="margin-bottom: 20px">
              <el-col :span="12" align="auto">
                <div class="grid-content bg-purple">
                  <span>名称：</span>
                  <el-input v-model="input" placeholder="请输入场地名称" clearable style="width: 200px"></el-input>
                </div>
              </el-col>
              <el-col align="auto" :span="2">
                <el-button type="warning" round @click="SearchStadium">搜索</el-button>
              </el-col>
              <el-col :span="8" align="auto">
                  <el-date-picker
                    v-model="day"
                    type="date"
                    placeholder="选择日期"
                    :picker-options="pickerOptions">
                  </el-date-picker>
              </el-col>
              <el-col :span="8" align="auto">
                <el-time-select
                  v-model="hour"
                  :picker-options="{
                  start: '08:00',
                  step: '01:00',
                   end: '24:00'}"
                  placeholder="选择时间">
                </el-time-select>
              </el-col>
              <el-col :span="8" align="auto">
                <el-input-number v-model="timeLength" @change="handleChange" :min="1" :max="8" label="时长"></el-input-number>
              </el-col>
            </el-row>
            <template>
              <el-table
                :data="placeData"
                style="margin-top: 20px"
                :row-class-name="tableRowClassName">
                <el-table-column
                  prop="placeName"
                  label="场馆"
                  width="180">
                </el-table-column>
                <el-table-column
                  prop="price"
                  label="每小时价格"
                  width="180">
                </el-table-column>
                <el-table-column
                  prop="address"
                  label="地址">
                </el-table-column>
                <el-table-column
                  fixed="right"
                  label="操作"
                  width="200">
                  <template slot-scope="scope">
                    <el-button type="info" round @click="ViewStadium">查看</el-button>
                    <el-button type="primary" round @click="BookStadium">预约</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </template>
          </div>
      </div>
  </main>

</template>

<script>
export default {
  data () {
    return {
      pickerOptions: {
        shortcuts: [{
          text: '今天',
          onClick (picker) {
            picker.$emit('pick', new Date())
          }
        }],
        placeData: [{
          placeName: '体育馆',
          price: '400',
          address: '上海市普陀区金沙江路 1515 弄'
        }, {
          placeName: '东操场',
          price: '60',
          address: '上海市普陀区金沙江路 1516 弄'
        }, {
          placeName: '大学生活动中心',
          price: '40',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          placeName: '篮球场',
          price: '200',
          address: '上海市普陀区金沙江路 1518 弄'
        }]
      },
      timeLength: '',
      day: '',
      hour: '',
      placeData: [{
        placeName: '体育馆',
        price: '400',
        address: '上海市普陀区金沙江路 1515 弄'
      }, {
        placeName: '东操场',
        price: '60',
        address: '上海市普陀区金沙江路 1516 弄'
      }, {
        placeName: '大学生活动中心',
        price: '40',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        placeName: '篮球场',
        price: '200',
        address: '上海市普陀区金沙江路 1518 弄'
      }]
    }
  },
  methods: {
    tableRowClassName ({row, rowIndex}) {
      if (rowIndex === 1) {
        return 'warning-row'
      } else if (rowIndex === 3) {
        return 'success-row'
      }
      return ''
    },
    handleChange (value) {
      console.log(value)
    },
    BookStadium () {
      this.$message({
        type: 'success',
        message: '预约成功!'
      })
    },
    ViewStadium () {
      this.$message({
        type: 'success',
        message: '查看成功!'
      })
    },
    SearchStadium () {
      this.$message({
        type: 'success',
        message: '搜索成功!'
      })
    }
  }

}
</script>

<style >
  main{
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    min-height: 800px;
    border: solid 40px #E9ECF1;
    background-color: #FCFCFC;
  }
  main .main-left{
    text-align: center;
    width: 200px;
    float: left;
  }
  main .main-right{
    -webkit-box-flex: 1;
    -ms-flex: 1;
    flex: 1;
    background-color: #fff;
    padding: 30px 70px;
    text-align:left;
    text-indent: 5%
  }
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>
