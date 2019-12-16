<template>
  <el-button type="warning" round @click="SearchStadium">搜索</el-button>
</template>

<script>
export default {
  name: 'searchButton',
  methods: {
    SearchStadium () {
      this.$message({
        type: 'success',
        message: '搜索成功!'
      })
    }
  }
}
</script>

<style scoped>

</style>
