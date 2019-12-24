<template>
  <el-card >
    <div slot="header" >
      <span>{{stadium.stadiumId}}</span>
    </div>
    <div>
      <el-form label-width="80px" >
        <el-form-item label="地址:">
          <div v-if="isEdit==0">
          {{this.stadium.address}}
          </div>
          <div v-else>
            <el-input
              v-if="isEdit==1"
              type="textarea"
              v-model="stadiumAddress"
              maxlength="50"
              show-word-limit
            >
            </el-input>
          </div>
        </el-form-item>
        <el-form-item label="价格:">
          <div v-if="isEdit==0">
          {{this.stadium.price+"元/小时"}}
          </div>
          <div v-else>
            <el-input
              v-if="isEdit==1"
              type="textarea"
              v-model="stadiumPrice"
              maxlength="10"
              show-word-limit
            >
            </el-input>
          </div>
        </el-form-item>
        <el-form-item label="介绍:">
          <div v-if="isEdit==0">
          {{this.stadium.address}}
          </div>
          <div v-else>
            <el-input
              v-if="isEdit==1"
              type="textarea"
              v-model="stadiumInformation"
              maxlength="200"
              show-word-limit
            >
            </el-input>
          </div>
        </el-form-item>
        <el-form-item v-if="userType=='admin'">
            <el-button type="primary" v-if="isEdit==0" @click="editStadium">修改</el-button>
            <el-button type="danger" v-else @click="editStadiumComplete">确认</el-button>
          <el-button type="danger" v-if="isEdit==1" @click="editStadiumCancel">取消</el-button>
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
      stadiumId: this.stadium.stadiumId,
      stadiumAddress: this.stadium.address,
      stadiumPrice: this.stadium.price,
      stadiumInformation: this.stadium.information,
      stadiumTime: this.stadium.time,
      userType: sessionStorage.getItem('userType'),
      isEdit: '0'
    }
  },
  methods: {
    editStadium () {
      this.isEdit = '1'
    },
    editStadiumComplete () {
      var self = this
      self.$axios
        .put('/stadium/update', {
          stadiumId: this.stadium.stadiumId,
          address: this.stadiumAddress,
          time: this.stadiumTime,
          information: this.stadiumInformation,
          price: this.stadiumPrice
        }).then(res => {
          console.log('修改场馆成功', res)
          if (res.data.code === 200) {
            this.$message({
              message: '修改场馆成功',
              type: 'success'
            })
          } else if (res.data.code === 400) {
            this.$message({
              message: '修改场馆失败',
              type: 'error'
            })
          }
        }).catch(function (error) {
          console.log('修改场馆失败', error)
          this.$message({
            message: '修改场馆失败',
            type: 'error'
          })
        })
      this.isEdit = '0'
      this.reload()
    },
    editStadiumCancel () {
      this.isEdit = '0'
    }
  }
}

</script>

<style scoped>

</style>
