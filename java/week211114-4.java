class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        init(n);
        // for (int[] r : restrictions) {
        //     unionElements(r[0], r[1]);
        // }

        boolean[] ans = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int[] req = requests[i];

            ans[i] = true;
            for (int[] res : restrictions) {
                if ((isConnected(res[0], req[0]) && isConnected(res[1], req[1]))
                        || (isConnected(res[1], req[0]) && isConnected(res[0], req[1]))) {
                    ans[i] = false;
                    break;
                }
            }
            
            if (ans[i]) {
                unionElements(req[0], req[1]);
            }
        }

        return ans;
    }
    
    private int[] id;

    /**
     * 并查集的元素个数
     */
    private int size;

    /**
     * 构造一个新的并查集
     *
     * @param size 初始大小
     */
    public void init(int size) {
        //初始化个数
        this.size = size;
        //初始化数组，每个并查集都指向自己
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    /**
     * 查看元素所属于哪个集合
     *
     * @param element 要查看的元素
     * @return element元素所在的集合
     */
    private int find(int element) {
        return id[element];
    }

    /**
     * 判断两个元素是否同属于一个集合
     *
     * @param firstElement  第一个元素
     * @param secondElement 第二个元素
     * @return <code>boolean</code> 如果是则返回true。
     */
    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    /**
     * 合并两个元素所在的集合，也就是连接两个元素
     *
     * @param firstElement  第一个元素
     * @param secondElement 第二个元素
     */
    public void unionElements(int firstElement, int secondElement) {
        // 找出firstElement所在的集合
        int firstUnion = find(firstElement);
        // 找出secondElement所在的集合
        int secondUnion = find(secondElement);

        // 如果这两个不是同一个集合，那么合并。
        if (firstUnion != secondUnion) {
            // 遍历数组，使原来的firstUnion、secondUnion合并为secondUnion
            for (int i = 0; i < this.size; i++) {
                if (id[i] == firstUnion) {
                    id[i] = secondUnion;
                }
            }
        }
    }
}
