/**
 * @param {number[][]} mat
 * @param {number[][]} target
 * @return {boolean}
 */
 var findRotation = function(mat, target) {
    const n = mat.length
    for(let _=0;_<4;_++) {
        mat = mat.map((val, idx) => {
            const row = []
            for(let i=0;i<n;i++) {
                row.push(mat[n-i-1][idx])
            }
            return row
        })

        let found = true
        for(let i=0;i<n;i++) {
            if(!found) break
            for(let j=0;j<n;j++) {
                if(mat[i][j]!=target[i][j]) {
                    found = false
                    break
                }
            }
        }

        if(found) return true
    }
    return false
};

