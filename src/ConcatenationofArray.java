public class ConcatenationofArray {
    public int[] getConcatenation(int[] nums) {
        int z = 0;
        int[] array2 = new int[nums.length * 2];
        for (int i = 0; i < array2.length; i++) {
            if (z >= nums.length) {
                z -= nums.length;
            }
            array2[i] = nums[z];
            z += 1;
        }
        return array2;


    }
}
