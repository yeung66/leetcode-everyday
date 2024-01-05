function hIndex(citations: number[]): number {
    const n = citations.length;
    let left = 0, right = n;
    while (left < right) {
        let mid = (left + right) >> 1;
        if (citations[mid] == n - mid) return n - mid
        else if (citations[mid] < n - mid) {
            left = mid + 1
        } else {
            right = mid
        }

    }

    return n - left
};