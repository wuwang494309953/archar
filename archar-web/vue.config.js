module.exports = {
    lintOnSave: false,
    devServer:{
        port:8081, // 启动端口
        open:true,  // 启动后是否自动打开网页
        proxy: {
            "/": {
                target: 'http://localhost:8100',
                changeOrigin: true,
                ws: true
            }
        }
    }
}