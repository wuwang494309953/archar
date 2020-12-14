<template>
  <el-card>
    <el-row>
      <el-col :span="12">
        <el-button type="primary" size="small" round @click="_handleAdd">新增</el-button>
        <el-table
          v-loading="loading"
          :data="tableData">
          <el-table-column
              type="index"
              width="50">
          </el-table-column>
          <el-table-column
              prop="queryCode"
              label="查询Code">
          </el-table-column>
          <el-table-column
              prop="queryName"
              label="名称">
          </el-table-column>
          <el-table-column
              label="操作"
              width="100">
            <template slot-scope="scope">
              <el-button type="text" size="small" @click="_handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button type="text" size="small" @click="_handleDel(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
            @current-change="_handleCurrentChange"
            :current-page.sync="page.pageNum"
            :page-size="page.pageSize"
            :total="total"
            layout="total, prev, pager, next"
        />
      </el-col>
      <el-col :span="12">456</el-col>
    </el-row>

    <QueryAddForm :visible.sync="visible" :editItem="editItem" @refreshTable="_getTableData"></QueryAddForm>
  </el-card>
</template>

<script>
import { getQueryInfoPage, delQueryInfo } from '@/api/queryInfo'
import QueryAddForm from "@/pages/sys/query-info/components/QueryAddForm";

export default {
  name: "TableInfoList",
  data () {
    return {
      total: 0,
      loading: false,
      tableData: [],
      visible: false,
      editItem: {},
      page: {
        pageNum: 1,
        pageSize: 10
      }
    }
  },
  methods: {
    _handleAdd() {
      this.visible = true
      this.editItem = {}
    },
    _handleEdit(index, row) {
      this.visible = true
      this.editItem = row
    },
    _handleDel(index, row) {
      this.$confirm("请确认是否删除数据?", "提示", {type: "warning"})
      .then(() => {
        delQueryInfo(row.id).then(res => {
          this.$message({
            showClose: true,
            message: '删除成功',
            type: "success"
          })
          this._getTableData()
        })
      })
      .catch(() => {
        console.log("取消删除")
      })
    },
    _getTableData() {
      this.loading = true
      getQueryInfoPage(this.page).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total
      }).finally(() => {
        this.loading = false
      })
    },
    _handleCurrentChange() {
      this._getTableData()
    }
  },
  created() {
    this._getTableData()
  },
  components: {
    QueryAddForm
  }
}
</script>

<style scoped>

</style>