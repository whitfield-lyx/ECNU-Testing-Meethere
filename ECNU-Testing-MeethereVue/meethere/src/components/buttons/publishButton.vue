<template>
  <el-button type="warning" round @click="PublishMessage">发布！</el-button>
</template>

<script>
export default {
  name: 'publishButton',
  methods: {
    PublishMessage () {
      this.$message({
        type: 'success',
        message: '发布成功!'
      })
    }
  }
}
</script>

<style scoped>

</style>
