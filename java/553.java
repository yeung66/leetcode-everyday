class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1)
            return String.valueOf(nums[0]);

        if (nums.length == 2) {
            return String.format("%d/%d", nums[0], nums[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < nums.length; i++) {
            sb.append("/");
            sb.append(nums[i]);
        }

        sb.delete(0, 1);


        return String.format("%d/(%d/(%s))", nums[0], nums[1], sb.toString());
    }
}