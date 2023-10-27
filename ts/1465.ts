function maxArea(
    h: number,
    w: number,
    horizontalCuts: number[],
    verticalCuts: number[]
): number {
    horizontalCuts.sort((a, b) => a - b)
    verticalCuts.sort((a, b) => a - b)
    return Number(
        (BigInt(findMax(horizontalCuts, h)) *
            BigInt(findMax(verticalCuts, w))) %
            BigInt(1000000007)
    )
}

const findMax = (arr: number[], board: number): number => {
    let prev = 0,
        max = 0
    for (let cur of arr) {
        max = Math.max(max, cur - prev)
        prev = cur
    }

    return Math.max(max, board - prev)
}
