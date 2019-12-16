<template>
  <main>
    <!-- 左侧导航 -->
    <div class="main-left">
      <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
        <el-menu-item index="" :class="{'isActive': active}" >
          <i class="el-icon-menu"></i>
          <span slot="title">场馆列表</span>
        </el-menu-item>
      </el-menu>
    </div>
    <!-- 右侧主内容区 -->
        <div  class="main-right" >
          <div class="block">
            <el-row type="flex" class="row-bg">
              <el-col :span="10">
                <div class="grid-content bg-purple">
                  <span>名称：</span>
                  <el-input v-model="input" placeholder="请输入场地名称" clearable style="width: 200px"></el-input>
                </div></el-col>
              <el-col :span="15">
                <div class=" ">
                <span>日期: </span>
                  <el-date-picker
                    v-model="value2"
                    type="datetimerange"
                    align="right"
                    unlink-panels
                    range-separator="至"
                    start-placeholder="开始日期"
                    end-placeholder="结束日期"
                    :picker-options="pickerOptions">
                  </el-date-picker>
                </div>
              </el-col>
            </el-row>
            <template>
              <el-table
                :data="placeData"
                style="width: 100%"
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
                  width="100">
                  <template slot-scope="scope">
                    <el-button @click="checkClick(scope.row)" type="text" size="small">查看</el-button>
                    <el-button @click="bookClick(scope.row)" type="text" size="small">预约</el-button>
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
          text: '最近一周',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
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
      value1: [new Date(2000, 10, 10, 10, 10), new Date(2000, 10, 11, 10, 10)],
      value2: '',
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
    checkClick (row) {
      this.$message({
        message: '查看场馆',
        type: 'success'
      })
    },
    bookClick (row) {
      this.$message({
        message: '预约场馆',
        type: 'success'
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
