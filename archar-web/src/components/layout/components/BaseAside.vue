<template>
  <div>
    <!--  左侧部分为了显示头和导航菜单  -->
    <div class="show-icon">
      <i class="el-icon-eleme icon"></i>
    </div>

    <!--  导航菜单  -->
    <div class="sidebar-container">
      <el-scrollbar style="height: 100%;">

        <el-menu
          default-active="2"
          background-color="#1F2D3D"
          text-color="#fff"
          active-text-color="#ffd04b"
          @select="_handleSelect"
        >

          <template v-for="item in menus">
            <template v-if="item.child != null && item.child.length > 0">
              <sub-menu v-bind:item="item"></sub-menu>
            </template>

            <template v-else>
              <el-menu-item :index="item.menuUrl">
                <i :class="item.menuIcon"></i>
                {{ item.menuName }}
              </el-menu-item>
            </template>
          </template>

        </el-menu>
      </el-scrollbar>
    </div>
  </div>

</template>

<script>
import SubMenu from './main/SubMenu'

export default {
  name: "BaseAside",
  data () {
    return {
      menus: [
        {
          menuName: '首页',
          menuIcon: 'el-icon-s-home',
          menuUrl: '/dashboard',
          child: []
        },
        {
          menuName: '系统设置',
          menuIcon: 'el-icon-setting',
          menuUrl: '/login',
          child: [
            {
              menuName: '菜单管理',
              menuIcon: '',
              menuUrl: '/sys/menus',
              child: []
            },
            {
              menuName: '列表数据',
              menuIcon: '',
              menuUrl: '/sys/tableInfo',
              child: []
            },
            {
              menuName: 'demo1',
              menuIcon: '',
              menuUrl: '/sys/demo1',
              child: []
            },
            {
              menuName: 'demo2',
              menuIcon: '',
              menuUrl: '/sys/demo2',
              child: []
            }
          ]
        }
      ]
    }
  },
  methods: {
    _handleSelect (key, keyPath) {
      this.$router.push(key)
    }
  },
  components: {
    SubMenu
  }
}
</script>

<style lang="stylus" scoped>
.show-icon
  height 50px
  line-height 50px
  text-align center
  padding 5px
  background-color #1F2D3D

  .icon
    font-size 50px
    color #409EFF
.sidebar-container
  position absolute
  top 60px
  left 0
  right 0
  bottom 0
  border-right 0
  background-color #1F2D3D
//修改element默认样式
.el-menu
  border-right none
</style>
