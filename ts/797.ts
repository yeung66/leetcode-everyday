function allPathsSourceTarget(graph: number[][]): number[][] {
    const n = graph.length;
    const res: number[][] = [];

    const dfs = (path: number[], node: number): void => {
        if (node === n - 1) {
            res.push(path.slice());
            return;
        }

        for (const next of graph[node]) {
            path.push(next);
            dfs(path, next);
            path.pop();
        }
    }

    dfs([0], 0);

    return res;
};