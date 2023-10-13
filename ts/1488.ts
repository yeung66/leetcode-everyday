function avoidFlood(rains: number[]): number[] {
    const lakes = new Map<number, number>()
    let release: number[] = []
    let ans = new Array(rains.length).fill(-1)
    for (let [ii, i] of rains.entries()) {
        if (i > 0) {
            if (lakes.has(i)) {
                let ableRelease = false
                for (let [idx, j] of release.entries()) {
                    if (j > lakes.get(i)!!) {
                        // console.log(i, j, lakes, release, ans)
                        release.splice(idx, 1)
                        lakes.delete(i)
                        ableRelease = true
                        ans[j] = i
                        break
                    }
                }

                if (!ableRelease) {
                    return []
                }
            }

            lakes.set(i, ii)
        } else {
            release.push(ii)
        }
    }

    release.forEach((i) => ans[i] = 1)

    return ans
}

// let rains = [69,0,0,0,69]
// console.log(avoidFlood(rains))
