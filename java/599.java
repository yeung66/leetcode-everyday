class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        TreeMap<Integer, List<String>> cnt = new TreeMap<>();
        int n = list1.length, m = list2.length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (list1[i].equals(list2[j])) {
                    if (!cnt.containsKey(i+j)) cnt.put(i+j, new ArrayList<>());
                    cnt.get(i+j).add(list1[i]);
                }
            }
        }

        String[] ans = null;
        for (var k: cnt.values()) {
            ans = k.stream().toArray(String[]::new);
            break;
        }

        return ans;
    }
}