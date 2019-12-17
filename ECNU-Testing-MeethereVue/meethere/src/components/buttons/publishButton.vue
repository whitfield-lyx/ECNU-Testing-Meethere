<template>
  <el-button type="warning" round @click="PublishMessage">发布！</el-button>
</template>

<script>
export default {
  name: 'publishButton',
  methods: {
    PublishMessage () {
      this.$confirm('确认发布吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        var self = this
        self.$axios
          .post('/news', {
            context: '1',
            userId: '1'
          })
      }).catch(function (error) {
        console.log('失败', error)
      })
    }
  }
}
</script>

<style scoped>

</style>
