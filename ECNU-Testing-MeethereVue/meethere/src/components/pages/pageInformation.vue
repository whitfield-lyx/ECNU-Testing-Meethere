<template>
  <el-main>
    <el-row type="flex" class="row-bg" justify="center">
      <el-col :span="8"><div class="grid-content bg-purple">
        <template>
          <div class="head-image" style="position: relative; height: 100px">
            <el-avatar :size=60 icon="el-icon-user-solid"></el-avatar>
          </div>
        </template></div>
        <div>
          <el-form ref="form" :model="personForm" label-width="80px" size="mini"  >
            <el-form-item label="用户名:">
              <el-input  :disabled="true" v-model="personForm.name"></el-input>
            </el-form-item>
            <el-form-item label="账号:">
              <el-input :disabled="true" v-model="personForm.userName"></el-input>
            </el-form-item>
            <el-form-item label="用户类型:">
              <el-radio-group v-model="personForm.userType" disabled>
                <el-radio-button label="user">普通用户</el-radio-button>
                <el-radio-button label="admin">管理员</el-radio-button>
              </el-radio-group>
            </el-form-item>
          </el-form>
        </div>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
export default {
  name: 'pageInformation',
  data () {
    return {
      personForm: {
        name: '废柴阿翔',
        userName: 'user123',
        userType: 'user'
      }
    }
  },
  methods: {
  }
}

</script>

<style scoped>
</style>
