<template>
  <el-main>
    <el-table
      :data="tableData"
      stripe
      style="width: 100%">
      <el-table-column
        prop="orderId"
        label="订单号"
        sortable
        width="100">
      </el-table-column>
      <el-table-column
        prop="stadiumId"
        label="场地"
        sortable
        :filters="[{text: '东操场', value: '东操场'}, {text: '中北乒乓球馆', value: '中北乒乓球馆'}, {text: '大活羽毛球馆', value: '大活羽毛球馆'}, {text: '篮球馆', value: '篮球馆'}]"
        :filter-method="filterHandler"
        width="180">
      </el-table-column>
      <el-table-column
        prop="startTime"
        sortable
        label="开始时间"
        width="180">
      </el-table-column>
      <el-table-column
        prop="isChecked"
        label="是否审核"
        sortable
        width="180">
        <template slot-scope="scope">
          <span v-if="scope.row.isChecked === 0">未审核</span>
          <span v-else>已审核</span>
        </template>
      </el-table-column>
      <el-table-column
        prop="hour"
        label="时长"
        width="100">
      </el-table-column>
      <el-table-column
        prop="price"
        label="总租金"
        width="100">
        <template slot-scope="scope">
          <span >{{scope.row.price * scope.row.hour}}</span>
        </template>
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址"
        width="300">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary"  v-if="userType==='admin'" icon="el-icon-check"  circle @click="checkOrder(scope.row)" ></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteOrder(scope.row)"></el-button>
          <!--<el-button type="info"  icon="el-icon-edit"  circle @click="editOrder(scope.row)" ></el-button>-->
        </template>
      </el-table-column>
    </el-table>

  </el-main>
</template>

<script>
export default {
  name: 'pageOrder',
  inject: ['reload'],
  data () {
    return {
      tableData: [{
        orderId: '1',
        userId: '123',
        stadiumId: '大学生活动中心',
        startTime: '2019-12-13 11:00',
        isChecked: '0',
        hour: '3',
        address: '普陀区中山北路3663号',
        price: '400'
      }],
      userType: sessionStorage.getItem('userType'),
      userId: sessionStorage.getItem('userId')
    }
  },
  methods: {
    checkOrder (row) {
      this.$confirm('确认审核吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.reload()
        var self = this
        self.$axios
          .put('/order/check/' + row.orderId)
        console.log('审核订单成功')
        this.$message({
          message: '审核订单成功',
          type: 'success'
        })
        this.reload()
      }).catch(function (error) {
        console.log('审核订单失败', error)
        this.$message.error('审核订单失败')
      })
    },
    deleteOrder (row) {
      this.$confirm('确认删除吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.reload()
        var self = this
        self.$axios
          .delete('/order/' + row.orderId)
        console.log('删除订单成功')
        this.reload()
        this.$message({
          message: '删除订单成功',
          type: 'success'
        })
      }).catch(function (error) {
        console.log('删除订单失败', error)
        this.$message.error('删除订单失败')
      })
    },
    editOrder (row) {
    },
    filterHandler (value, row, column) {
      const property = column['property']
      return row[property] === value
    }
  },
  mounted () {
    var self = this
    var order = []
    self.$axios
      .get('/order/all')
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          var obj = {}
          obj.userId = res.data[i].userId
          obj.orderId = res.data[i].orderId
          obj.stadiumId = res.data[i].stadiumId
          obj.isChecked = res.data[i].isChecked
          obj.address = res.data[i].address
          obj.startTime = res.data[i].time
          obj.price = res.data[i].price
          obj.hour = res.data[i].hour
          if (obj.userId == this.userId || this.userType === 'admin') {
            order[i] = obj
          }
        }
        self.tableData = order
        console.log('数据获取成功', res)
      })
      .catch(function (error) {
        console.log('数据获取失败', error)
      })
  }
}
</script>

<style scoped>

</style>
