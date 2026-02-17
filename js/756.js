/**
 * @param {string} bottom
 * @param {string[]} allowed
 * @return {boolean}
 */
var pyramidTransition = function (bottom, allowed) {
    const candidates = new Map();
    for (let i = 0; i < allowed.length; i++) {
        const list = candidates.get(allowed[i][0] + allowed[i][1]) || []
        list.push(allowed[i][2])
        candidates.set(allowed[i][0] + allowed[i][1], list)
    }

    const memo = new Set();

    const dfs = (row) => {
        if (row.length === 1) return true;

        if (memo.has(row)) return false;

        if (buildNextRow(row, 0, [])) return true;

        memo.add(row);
        return false;
    }

    const buildNextRow = (row, index, cur) => {
        if (index === row.length - 1) {
            return dfs(cur.join(''))
        }

        const list = candidates.get(row[index] + row[index + 1])
        if (!list) return false;

        for (let i = 0; i < list.length; i++) {
            cur.push(list[i])
            if (buildNextRow(row, index + 1, cur)) return true;
            cur.pop()
        }

        return false;
    }

    return dfs(bottom);
}
