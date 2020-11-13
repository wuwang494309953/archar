<template>
  <div>
    <div class="wrapper">
      <div class="container">
        <h1>Welcome</h1>
        <form method="post" class="form">
          <input type="text" v-model="form.username" placeholder="Account"/>
          <input type="password" v-model="form.password" @keyup.enter="_submit" placeholder="Password" autocomplete/>
          <el-button type="primary" :loading="isSubmit" @click="_submit">Login</el-button>
        </form>
      </div>
      <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "index",
  data () {
    return {
      isSubmit: false,
      form: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    _submit () {
      this.isSubmit = true
      console.log("点击了登录按钮")
    },
    _loginFail (message) {
      this.isSubmit = false
      this.$notify.error({
        title: '错误',
        message: message
      })
    }
  },
  created() {
    console.log(this.$store)
  }
}

</script>

<style scoped src="./main.css" >

</style>