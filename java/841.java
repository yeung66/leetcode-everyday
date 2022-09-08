class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> nextTry = new LinkedList<>();
        nextTry.offer(0);

        while(!nextTry.isEmpty()) {
            int nextRoom = nextTry.poll();
            if (!visited[nextRoom]) {
                visited[nextRoom]=true;
                for (int r:rooms.get(nextRoom)) {
                    if (!visited[r]) nextTry.offer(r);
                }
            }
        }

        for (boolean v:visited) {
            if (!v) return false;
        }
        return true;
    }
}