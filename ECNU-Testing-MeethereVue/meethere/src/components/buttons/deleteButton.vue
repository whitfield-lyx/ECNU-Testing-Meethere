<template>
  <el-button type="danger" icon="el-icon-delete" circle @click="deleteOrder"></el-button>
</template>

<script>
export default {
  name: 'deleteButton',
  methods: {
    deleteOrder () {
      this.$message({
        type: 'success',
        message: '删除成功!'
      })
    }
  }
}
</script>

<style scoped>

</style>
