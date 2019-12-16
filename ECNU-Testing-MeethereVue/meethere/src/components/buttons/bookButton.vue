<template>
  <el-button type="primary" round @click="BookStadium">预约</el-button>
</template>

<script>
export default {
  name: 'bookButton',
  methods: {
    BookStadium () {
      this.$message({
        type: 'success',
        message: '预约成功!'
      })
    }
  }
}
</script>

<style scoped>

</style>
