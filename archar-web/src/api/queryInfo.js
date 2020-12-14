import axios from 'axios'

export function getQueryInfoPage (params) {
    const url = '/sysQueryInfo/page'
    params = params == null ? {} : params
    // const data = {}
    return axios.post(url, params).then((res) => {
        if (res.data) {
            return Promise.resolve(res.data)
        }
    }).catch(e => {
        return Promise.reject(e)
    })
}

export function save (params) {
    const url = '/sysQueryInfo'
    params = params == null ? {} : params
    return axios.put(url, params).then((res) => {
        if (res.data) {
            return Promise.resolve(res.data)
        }
    }).catch(e => {
        return Promise.reject(e)
    })
}

export function delQueryInfo (id) {
    const url = `/sysQueryInfo/${id}`
    return axios.delete(url).then((res) => {
        if (res.data) {
            return Promise.resolve(res.data)
        }
    }).catch(e => {
        return Promise.reject(e)
    })
}
