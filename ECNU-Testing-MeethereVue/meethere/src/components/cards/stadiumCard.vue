<template>
  <el-card >
    <div slot="header" >
      <span>{{stadium.stadiumId}}</span>
    </div>
    <div>
      <el-form label-width="80px" >
        <el-form-item label="地址:">
          {{stadium.address}}
        </el-form-item>
        <el-form-item label="价格:">
          {{stadium.price+"元/小时"}}
        </el-form-item>
        <el-form-item label="介绍:">
          {{stadium.information}}
        </el-form-item>
      </el-form>
    </div>
  </el-card>
</template>

<script>
export default {
  inject: ['reload'],
  name: 'stadiumCard',
  props: [
    'stadium'
  ],
  data () {
    return {
    }
  }
}

</script>

<style scoped>

</style>
