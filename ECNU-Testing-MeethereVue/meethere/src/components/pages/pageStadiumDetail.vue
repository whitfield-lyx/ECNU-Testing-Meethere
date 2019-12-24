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
    <div >
      <div>
        <el-row  style="margin-top: 20px; margin-bottom: 20px" >
          <el-col :span=7 style="margin-left: 15px">
            <stadium-card v-bind:stadium="stadium" ></stadium-card>
          </el-col>
          <el-col :span=8 style="margin-top: 80px;">
            <el-date-picker
              v-model="day"
              type="date"
              placeholder="选择日期"
              :picker-options="pickerOptions"
              format="yyyy-MM-dd"
              value-format="yyyy-MM-dd"
              style="margin-bottom: 20px"
            >
            </el-date-picker>
            <el-time-select
              v-model="hour"
              :picker-options="{
                  start: '08:00',
                  step: '01:00',
                   end: '22:00'}"
              placeholder="选择时间"
              style="margin-bottom: 20px">
            </el-time-select>
            <p><el-input-number  style="width: 220px" v-model="timeLength" :min= -0.1 :max=6.1></el-input-number></p>
            <p>
              <el-button type="danger" @click="cancelOrder">取消订单</el-button>
              <el-button type="primary" @click="makeOrder"  >确认预约</el-button>
            </p>
          </el-col>
          <el-col :span=7>
            <el-card >
              <div slot="header" >
                <span>订单</span>
              </div>
              <div>
                <el-form label-width="80px" >
                  <el-form-item label="场馆:">
                    {{stadium.stadiumId}}
                  </el-form-item>
                  <el-form-item  label="时间:">
                    {{timeString}}
                  </el-form-item>
                  <el-form-item label="时长:">
                    {{timeLength}}
                  </el-form-item>
                  <el-form-item label="总价:">
                    {{totolPrice}}
                  </el-form-item>
                </el-form>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>
    </div>
  </main>
</template>

<script>
import StadiumCard from '../cards/stadiumCard'

export default {
  name: 'pageStadiumDetail',
  components: {StadiumCard},
  data () {
    return {
      pickerOptions: {
        shortcuts: [{
          text: '今天',
          onClick (picker) {
            picker.$emit('pick', new Date())
          }
        }],
        disabledDate (date) {
          return date.getTime() <= Date.now()
        }
      },
      timeLength: '1',
      day: '',
      hour: '',
      stadiumId: this.$route.params.stadiumId,
      stadium: '',
      responseResult: '',
      userType: sessionStorage.getItem('userType')
    }
  },
  computed: {
    totolPrice: function () {
      return this.stadium.price * this.timeLength
    },
    timeString: function () {
      if (this.day !== '' && this.hour !== '') {
        return this.day + ' ' + this.hour + ':00'
      } else {
        return ''
      }
    }
  },
  methods: {
    cancelOrder () {
      this.$router.push({
        name: 'Booking'
      })
    },
    makeOrder () {
      if (this.userType === 'admin') {
        this.$message({
          message: '场馆预约失败 管理员不能预约场馆',
          type: 'warning'
        })
      } else {
        if (this.day !== '' && this.hour !== '') {
          this.$confirm('确认预约吗？', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            var self = this
            self.$axios
              .post('/order/newOrder', {
                userId: sessionStorage.getItem('username'),
                orderId: '1',
                stadiumId: this.stadiumId,
                time: this.timeString,
                hour: this.timeLength,
                isChecked: 0
              }).then(successResponse => {
                this.responseResult = JSON.stringify(successResponse.data)
                if (successResponse.data.code === 200) {
                  console.log('场馆预约成功 请管理员审核')
                  this.$message({
                    message: '场馆预约成功 请管理员审核',
                    type: 'success'
                  })
                  this.$router.replace({name: 'Order'})
                } else {
                  this.$message({
                    message: '场馆预约失败 预约时间冲突',
                    type: 'warning'
                  })
                }
              })
              .catch(failResponse => {
                this.$message({
                  message: '场馆预约失败',
                  type: 'warning'
                })
                console.log('场馆预约失败')
              })
          })
        } else {
          this.$message.error('场馆预约失败，请输入相应信息！')
        }
      }
    }
  },
  mounted () {
    var self = this
    self.$axios
      .get('/stadium')
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          var obj = {}
          obj.stadiumId = res.data[i].stadiumId
          if (obj.stadiumId === this.stadiumId) {
            obj.time = res.data[i].time
            obj.price = res.data[i].price
            obj.address = res.data[i].address
            obj.information = res.data[i].information
            this.stadium = obj
            break
          }
        }
        console.log('场馆获取成功', res)
      })
      .catch(function (error) {
        console.log('场馆获取失败', error)
      })
  }
}
</script>

<style scoped>

</style>
