<template>
  <div class="i-base-main">
    <transition name="slide-fade" mode="out-in">
      <keep-alive :include="cacheViews">
        <router-view :key="key"></router-view>
      </keep-alive>
    </transition>
  </div>
</template>

<script>
export default {
  name: "BaseMain",

  computed: {
    cacheViews () {
      console.log(this.$store.state.tagsView.cachedViews)
      return this.$store.state.tagsView.cachedViews
    },
    key () {
      return this.$route.path
    }
  }
}
</script>

<style lang="stylus" scoped>
.i-base-main
  padding 15px
//动画
.slide-fade-enter-active
  transition: all .5s ease
.slide-fade-leave-active
  transition: all .5s ease
.slide-fade-enter, .slide-fade-leave-to
  transform: translateX(10px)
  opacity: 0
</style>