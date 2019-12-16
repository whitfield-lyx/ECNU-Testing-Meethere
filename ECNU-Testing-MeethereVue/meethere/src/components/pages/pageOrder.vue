<template>
  <el-main>
    <el-table
      :data="tableData"
      stripe
      style="width: 100%"
      :row-class-name="tableRowClassName">
      <el-table-column
        prop="number"
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
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
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
        number: '1',
        place: '大学生活动中心',
        startTime: '2019-12-13 11:00',
        endTime: '2019-12-13 14:00',
        time: '3',
        address: '普陀区中山北路3663号',
        money: '400'
      }]
    }
  },
  methods: {
    handleEdit () {
    },
    handleDelete () {
    }
  }
}
</script>

<style scoped>

</style>
