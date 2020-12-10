import axios from 'axios'

export function page (params) {
    const url = '/sysQueryInfo/page'

    // const data = {}
    return axios.post(url, params).then((res) => {
        if (res.data) {
            return Promise.resolve(res.data)
        }
    })
}