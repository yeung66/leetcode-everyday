function isUnique(astr: string): boolean {
    let mask = 0
    for (let c of astr) {
        let move = c.charCodeAt(0) - 'a'.charCodeAt(0)
        if ((mask & (1 << move)) !== 0) {
            return false
        }
        mask |= (1 << move)
    }
    return true
};