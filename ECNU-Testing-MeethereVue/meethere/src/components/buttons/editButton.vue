<template>
  <el-button type="primary" icon="el-icon-edit" circle  @click="editOrder"></el-button>
</template>

<script>
export default {
  name: 'editButton',
  methods: {
    editOrder () {
      this.$message({
        type: 'success',
        message: '编辑成功!'
      })
    }
  }
}
</script>

<style scoped>

</style>
