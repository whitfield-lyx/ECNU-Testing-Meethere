<template>
  <el-button type="info" round @click="ViewStadium">查看</el-button>
</template>

<script>
export default {
  name: 'viewButton',
  methods: {
    ViewStadium () {
      this.$message({
        type: 'success',
        message: '查看成功!'
      })
    }
  }
}
</script>

<style scoped>

</style>
