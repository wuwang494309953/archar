<template>
  <div class="bar-area">
    <div v-if="visitedViews.length > 0" class="tag-area">
      <el-scrollbar style="white-space: nowrap; height: 40px; line-height: 40px;">
        <el-tag
            v-for="item in visitedViews"
            :key="item.path"
            :class="_isActive(item)?'active':''"
            :effect="_isActive(item)?'dark':'plain'"
            @close="_delTags(item)"
            type="success"
            size="medium"
            closable
            class="tag"
        >
          <router-link :to="item.path">
            <span>{{item.title}}</span>
          </router-link>
        </el-tag>
      </el-scrollbar>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      routers: []
    }
  },
  computed: {
    visitedViews() {
      return this.$store.state.tagsView.visitedViews
    }
  },
  watch: {
    $route() {
      this._addTags()
    }
  },
  methods: {
    _isActive(route) {
      return route.path === this.$route.path
    },
    _addTags() {
      const { name } = this.$route
      if (name) {
        this.$store.dispatch('tagsView/addView', this.$route)
      }
      return false
    },
    _delTags(view) {
      this.$store.dispatch('tagsView/delView', view).then(({ visitedViews }) => {
        if (this._isActive(view)) {
          this.toLastView(visitedViews, view)
        }
      })
    },
    toLastView(visitedViews) {
      const latestView = visitedViews.slice(-1)[0]
      if (latestView) {
        this.$router.push(latestView)
      } else {
        this.$router.push('/')
      }
    }
  }
}
</script>

<style lang="stylus" scoped>
.bar-area
  margin 1px 0px
  background-color white
  .tag-area
    margin 0px 15px
    .tag
      margin 3px 4px
    .active
      span
        color white

a
  text-decoration none
  color black
</style>
