import axios from 'axios'

export function getQueryInfoColumnPage (params) {
    const url = '/sysQueryInfoColumn/page'
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

export function getQueryInfoColumnById (id) {
    const url = '/sysQueryInfoColumn/columns/' + id
    // const data = {}
    return axios.get(url).then((res) => {
        if (res.data) {
            return Promise.resolve(res.data)
        }
    }).catch(e => {
        return Promise.reject(e)
    })
}

export function saveColumn (params) {
    const url = '/sysQueryInfoColumn'
    params = params == null ? {} : params
    return axios.put(url, params).then((res) => {
        if (res.data) {
            return Promise.resolve(res.data)
        }
    }).catch(e => {
        return Promise.reject(e)
    })
}

export function saveColumnList (list) {
    const url = '/sysQueryInfoColumn'
    list = list == null ? [] : list
    return axios.put(url, list).then((res) => {
        if (res.data) {
            return Promise.resolve(res.data)
        }
    }).catch(e => {
        return Promise.reject(e)
    })
}

export function delQueryInfoColumn (id) {
    const url = `/sysQueryInfoColumn/${id}`
    return axios.delete(url).then((res) => {
        if (res.data) {
            return Promise.resolve(res.data)
        }
    }).catch(e => {
        return Promise.reject(e)
    })
}
