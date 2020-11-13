import Vue from 'vue'
import Router from 'vue-router'

import Layout from '@/components/layout/index'

Vue.use(Router)

//获取原型对象上的push函数
const originalPush = Router.prototype.push
//修改原型对象中的push方法
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            redirect: '/index'
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('@/pages/login/index')
        },
        {
            path: '/index',
            name: 'layout',
            component: () => import('@/components/layout/index')
        },
        {
            path: '/sys',
            name: 'sys',
            component: Layout,
            children: [
                {
                    path: 'demo1',
                    name: 'demo1',
                    component: () => import('@/pages/demo/demo1'),
                    meta: { title: 'demo1' }
                },
                {
                    path: 'demo2',
                    name: 'demo2',
                    component: () => import('@/pages/demo/demo2'),
                    meta: { title: 'demo2' }
                },
            ]
        },
        {
            path: '*',
            name: '404',
            component: () => import('@/pages/exception/404')
        },
    ]
})