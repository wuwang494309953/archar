<template>
  <div class="main">
    <div class="head">
      <span class="code">当前选中查询Code: {{ queryInfoId }}</span>
      <span class="button-group" v-if="queryInfoId != null">
        <el-button type="primary" size="small" round>保存</el-button>
        <el-button type="primary" size="small" round @click="_showTableInit">按表初始化</el-button>
      </span>
    </div>
    <div class="body">
      <el-input
        type="textarea"
        placeholder="请输入内容"
        resize="vertical"
        :autosize="{ minRows: 20}"
        v-model="data"
      />
    </div>

    <el-dialog
      title="数据库表数据"
      :visible.sync="dialogVisible"
      :append-to-body="true"
      width="60%"
      >

    </el-dialog>

  </div>
</template>

<script>

import { getQueryInfoColumnById } from '@/api/queryInfoColum'

export default {
  name: "QueryColum",
  props: {
    queryInfoId: {
      type: String,
      default: 'VKLOFM'
    }
  },
  data() {
    return {
      data: '',
      dialogVisible: false
    }
  },
  methods: {
    _showTableInit() {
      this.dialogVisible = true
    }
  },
  created() {
    getQueryInfoColumnById('1338056914649591810').then(res => {
      console.log(res)
    })
  }
}
</script>

<style lang="stylus" scoped>
.main
  margin-left 15px
  .head
    //height 40px
    //line-height 40px

    padding 10px 0
    .code
      margin-right 40px

</style>