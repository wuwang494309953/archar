<template>
  <el-submenu :index="item.menuUrl" v-bind:key="item.menuUrl">
    <template slot="title">
      <i :class="item.menuIcon"></i>
      <span>{{ item.menuName }}</span>
    </template>

    <template v-for="(child,index) in item.child">
      <sub-menu v-if="child.child != null && child.child.length > 0"
        v-bind:item="child"
        v-bind:key="index">
      </sub-menu>

      <el-menu-item v-else :index="child.menuUrl">
        <i :class="child.menuIcon"></i>
        {{ child.menuName }}
      </el-menu-item>
    </template>
  </el-submenu>
</template>

<script>
export default {
  name: "SubMenu",
  props: {
    item: Object
  }
}
</script>

<style scoped>

</style>