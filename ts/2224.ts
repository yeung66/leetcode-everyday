function convertTime(current: string, correct: string): number {
    let [h1, m1] = current.split(":").map(x => parseInt(x))
    let [h2, m2] = correct.split(":").map(x => parseInt(x))
    let diff = (h2 - h1) * 60 + (m2 - m1)

    let adds = [60, 15, 5, 1]
    let ans = 0
    for (let add of adds) {
        if (diff == 0) break
        if (diff < add) continue
        let times = Math.floor(diff / add)
        ans += times
        diff -= times * add
    }

    return ans
  };