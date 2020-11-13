<template>
  <div>
    我是测试标题1
    <el-input v-model="title" placeholder="请输入内容"></el-input>
  </div>
</template>

<script>
export default {
  name: "demo1",
  data () {
    return {
      title: ''
    }
  }
}
</script>

<style scoped>

</style>