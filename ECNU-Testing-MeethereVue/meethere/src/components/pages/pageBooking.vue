<template>
  <main>
    <!-- 左侧导航 -->
    <div class="main-left">
      <el-menu default-active="" class="el-menu-vertical-demo" :router="true">
        <el-menu-item index="Booking" >
          <i class="el-icon-menu"></i>
          <span slot="title">场馆列表</span>
        </el-menu-item>
        <el-menu-item v-if="userType=='admin' " index="User" >
          <i class="el-icon-menu"></i>
          <span slot="title">用户管理</span>
        </el-menu-item>
      </el-menu>
    </div>
    <!-- 右侧主内容区 -->
        <div class="main-right" >
          <div class="block">
            <template>
              <el-table
                :data="placeData"
                style="margin-top: 20px"
                :row-class-name="tableRowClassName">
                <el-table-column
                  prop="stadiumId"
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
                  width="150">
                  <template slot-scope="scope">
                    <el-button type="info" round @click="ViewStadium(scope.row)">查看详情</el-button>
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
      stadiumId: '',
      userId: sessionStorage.getItem('userId'),
      userType: sessionStorage.getItem('userType'),
      placeData: [{
        stadiumId: '场馆获取失败',
        price: '400',
        address: '上海市普陀区金沙江路 1515 弄'
      }]
    }
  },
  mounted () {
    var self = this
    var stadiums = []
    self.$axios
      .get('/stadium')
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          var obj = {}
          obj.stadiumId = res.data[i].stadiumId
          obj.time = res.data[i].time
          obj.price = res.data[i].price
          obj.address = res.data[i].address
          stadiums[i] = obj
        }
        self.placeData = stadiums
        console.log('场馆获取成功', res)
      })
      .catch(function (error) {
        console.log('场馆获取失败', error)
      })

    if (this.userType == 'user') {
      self.$axios
        .get('/user/info')
        .then(res => {
          sessionStorage.setItem('userId', res.data.userId)
          sessionStorage.setItem('userNickName', res.data.nickname)
          console.log('昵称获取成功', res)
        })
        .catch(function (error) {
          sessionStorage.setItem('userNickName', '无名')
          console.log('昵称获取失败', error)
        })
    } else {
      sessionStorage.setItem('userId', 'admin')
      sessionStorage.setItem('userNickName', '管理员')
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
    ViewStadium (row) {
      this.$router.replace({
        name: 'StadiumDetail',
        params: {stadiumId: row.stadiumId}
      })
      console.log(row)
      this.$message({
        type: 'success',
        message: '查看成功!'
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
    padding: 0px 20px;
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
