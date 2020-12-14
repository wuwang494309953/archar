export function randomStr(len) {
    const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    let pwd = ''
    for (let i = 0; i < len; i++) {
        pwd += chars.charAt(Math.floor(Math.random() * chars.length))
    }
    return pwd
}


