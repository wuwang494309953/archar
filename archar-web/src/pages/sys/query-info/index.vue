<template>
  <el-card>
    <el-row>
      <el-col :span="12">
        <el-table
          :data="tableData">
          <el-table-column
              type="index"
              width="50">
          </el-table-column>
          <el-table-column
              prop="date"
              label="日期">
          </el-table-column>
          <el-table-column
              prop="date"
              label="日期">
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="12">456</el-col>
    </el-row>
  </el-card>
</template>

<script>
import {page} from '@/api/queryInfo'
export default {
  name: "TableInfoList",
  data () {
    return {
      tableData: []
    }
  },
  created() {
    page().then(res => {
      console.log(res)
    })
  }
}
</script>

<style scoped>

</style>