class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int left = capacity;
        int n = plants.length;
        int steps = 0;
        for (int i = 0; i < n; i++) {
            if (plants[i] <= left) {
                left -= plants[i];
                steps++;
            } else {
                steps += 2 * i + 1;
                left = capacity - plants[i];
            }
        }

        return steps;
    }
}