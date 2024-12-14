public class TheTwoSneakyNumberofDigitville {
    public int[] getSneakyNumbers(int[] nums) {
        int a = 0;
        int[] nums2 = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j && a < 2) {
                    if (a == 1 && nums2[0] != nums[i]) {
                        nums2[a] = nums[i];
                        a += 1;
                    } else if (a == 0) {
                        nums2[a] = nums[i];
                        a += 1;
                    }
                }
            }

        }
        return nums2;

    }
}
