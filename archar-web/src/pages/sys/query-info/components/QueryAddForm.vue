<template>
  <div>
    <el-dialog
      title="新增"
      :visible.sync="visible"
      :append-to-body="true"
      :before-close="_handleClose">
      <el-form ref="form" :rules="rules" :model="form" label-width="100px">
        <el-form-item label="查询code" prop="queryCode">
          <el-input v-model="form.queryCode">
            <el-button slot="append" @click="_handleRandomCode">随机Code</el-button>
          </el-input>
        </el-form-item>
        <el-form-item label="查询名称" prop="queryName">
          <el-input v-model="form.queryName"></el-input>
        </el-form-item>
        <el-form-item label="备注" prop="description">
          <el-input
            type="textarea"
            show-word-limit
            maxlength="500"
            :autosize="{ minRows: 3, maxRows: 6}"
            v-model="form.description"
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="_handleSubmit('form')">确定</el-button>
          <el-button @click="_handleClose">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import {randomStr} from "@/utils/random";
import {save} from "@/api/queryInfo";

export default {
  name: "QueryAddForm",
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    editItem: {
      type: Object,
      default: {}
    }
  },
  watch: {
    editItem(val) {
      this.$nextTick(() => {
        this._resetForm()
        Object.assign(this.form, val)
      })
    }
  },
  data() {
    return {
      form: {
        queryCode: '',
        queryName: '',
        description: ''
      },
      rules: {
        queryCode: [
          { required: true, message: '请输入code', trigger: 'blur' }
        ],
        queryName: [
          { required: true, message: '请输入名称', trigger: 'blur' }
        ],
        description: [
          { max: 500, message: '长度不超过500', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    _handleSubmit(formName) {
      this.$refs[formName].validate(vaild => {
        if (!vaild) {
          return false
        }
        save(this.form).then(res => {
          this.$message({
            showClose: true,
            message: "保存成功",
            type: "success"
          })
          this.$emit("refreshTable")
          this._handleClose()
        })
      })
    },
    _resetForm() {
      this.$refs['form'].resetFields();
    },
    _handleClose() {
      this.$emit('update:visible', false)
    },
    _handleRandomCode() {
      //生成随机code
      this.form.queryCode = randomStr(6)
    }
  }
}
</script>

<style scoped>

</style>