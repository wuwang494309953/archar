<template>
  <div class="a-body">
    <!--  左边  -->
    <div class="slider-contain">
      <BaseAside></BaseAside>
    </div>
    <!--  右边  -->
    <div class="body-contain">
      <el-container>
        <el-header class="navbar">
          <BaseHead></BaseHead>
        </el-header>
        <el-main class="a-custom-main">
          <BaseMenuBar></BaseMenuBar>
          <BaseMain></BaseMain>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
import BaseAside from './components/BaseAside'
import BaseFoot from './components/BaseFoot'
import BaseHead from './components/BaseHead'
import BaseMain from './components/BaseMain'
import BaseMenuBar from './components/BaseMenuBar'
export default {
  name: "index",

  components: {
    BaseAside,
    BaseFoot,
    BaseHead,
    BaseMain,
    BaseMenuBar
  }
}
</script>

<style lang="stylus" scoped>
.a-body
  .slider-contain
    position fixed
    left 0
    top 0
    height 100%
    width 250px
  .body-contain
    position fixed
    left 250px
    top 0
    right 0
    height 100%
    background-color #F2F6FC
    .navbar
      background-color white
      box-shadow 0 2px 4px rgba(0, 0, 0, .04)

.el-main
  padding 0
</style>
