exports.install = function(Vue, options) {
    Vue.prototype.$deepClone = function(old) {
        return JSON.parse(JSON.stringify(old))
    };
}
