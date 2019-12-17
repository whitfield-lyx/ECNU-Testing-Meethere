<template>
  <el-main>
    <el-table
      :data="tableData"
      stripe
      style="width: 100%"
      :row-class-name="tableRowClassName">
      <el-table-column
        prop="orderId"
        label="订单号"
        width="100">
      </el-table-column>
      <el-table-column
        prop="place"
        label="场地"
        width="180">
      </el-table-column>
      <el-table-column
        prop="startTime"
        label="开始时间"
        width="180">
      </el-table-column>
      <el-table-column
        prop="endTime"
        label="结束时间"
        width="180">
      </el-table-column>
      <el-table-column
        prop="time"
        label="时长"
        width="100">
      </el-table-column>
      <el-table-column
        prop="money"
        label="总租金"
        width="100">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址"
        width="300">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle  @click="editOrder"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteOrder"></el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-main>
</template>

<script>
export default {
  name: 'pageOrder',
  data () {
    return {
      tableData: [{
        orderId: '1',
        place: '大学生活动中心',
        startTime: '2019-12-13 11:00',
        endTime: '2019-12-13 14:00',
        time: '3',
        address: '普陀区中山北路3663号',
        money: '400'
      }]
    }
  },
  methods:{
    deleteOrder () {
      this.$message({
        type: 'success',
        message: '删除成功!'
      })
    },
    editOrder () {
      this.$message({
        type: 'success',
        message: '编辑成功!'
      })
    }
  },
  mounted () {
    var self = this
    var order = []
    self.$axios
      .get('/orders')
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          var obj = {}
          obj.orderId = res.data[i].orderId
          obj.startTime = res.data[i].time
          obj.money = res.data[i].money
          order[i] = obj
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
