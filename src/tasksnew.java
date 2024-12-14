import java.util.Arrays;
import java.util.List;

public class tasksnew {
    public static void main(String[] args) {
        //salam
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] rnschar = ransomNote.toCharArray();
        char[] mgzchar = magazine.toCharArray();
        int count = 0;
        for (int i = 0; i < rnschar.length; i++) {
            for (int j = 0; j < mgzchar.length; j++) {
                if (rnschar[i] == mgzchar[j]) {
                    mgzchar[j] = '0';
                    count++;
                    break;
                }
            }
        }
        if (count == rnschar.length) {
            return true;
        } else {
            return false;
        }
    }


    public static String restoreString(String s, int[] indices) {
        char[] number = new char[indices.length];
        for (int i = 0; i < s.length(); i++) {
            number[indices[i]]=s.charAt(i);
        }
        return new String(number);
    }


    public static int finalPositionOfSnake(int n, List<String> commands) {
        int[][] matrix = new int[n][n];
        int number = 0;
        int result = 0;
        int scope1 =0;
        int scope2 =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=number;
                number++;
            }
        }
        for (int i = 0; i < commands.toArray().length; i++){
            switch (commands.get(i)){
                case "DOWN":
                    result = matrix[scope1+1][scope2];
                    scope1++;
                    break;
                case "UP":
                    result = matrix[scope1-1][scope2];
                    scope1--;
                    break;
                case "RIGHT":
                    result = matrix[scope1][scope2+1];
                    scope2++;
                    break;
                default:
                    result = matrix[scope1][scope2-1];
                    scope2--;
                    break;
            }
        }
        return result;

//        class Solution {
//            public int finalPositionOfSnake(int n, List<String> commands) {
//                int res = 0;
//                for(int i=0;i<commands.size();i++){
//                    switch(commands.get(i).charAt(0)){
//                        case 'D':
//                            res = res+n;
//                            break;
//                        case 'U':
//                            res = res-n;
//                            break;
//                        case 'R':
//                            res = res+1;
//                            break;
//                        case 'L':
//                            res = res-1;
//                            break;
//                    }
//                }
//                return res;
//            }
//        }

    }


    public static String intToRoman(int num) {
        int[] numbers = {1,5,10,50,100,500,1000};
        char[] romas = {'I','V','X','L','C','D','M'};

        StringBuilder resultmain = new StringBuilder();
        int help = 0;
        int index =0;

        while (num>0){
            StringBuilder result = new StringBuilder();
            int k = num%10;
            num=num/10;
            if (help==0){
                help++;
            }else {
                help*=10;
            }
            if (k==0){
                continue;
            }

            k*=help;
            if (k!=4*help && k!=9*help){


                while (k>0){
                    int max =0;
                    for (int i = 0; i < numbers.length; i++) {
                        if (max<=numbers[i] && numbers[i]<=k){
                            max=numbers[i];
                            index=i;
                        }
                    }
                    k-=max;
                    result.append(romas[index]);

                }


            }else {
                if (k==4*help){
                    switch (k){
                        case 4:
                            result.append("IV");
                            break;
                        case 40:
                            result.append("XL");
                            break;
                        case 400:
                            result.append("CD");
                            break;

                    }
                }else {
                    switch (k){
                        case 9:
                            result.append("IX");
                            break;
                        case 90:
                            result.append("XC");
                            break;
                        case 900:
                            result.append("CM");
                            break;

                    }
                }
            }
            resultmain.append(result.reverse());
        }
        String result2 = new String(resultmain.reverse());
//        resultmain.insert(0,result);

        return result2;
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int helper3 =1;
        int minushelper=0;
        int integerhelper=0;
        int lamp =9;
        if (nums.length==1){
            if ( nums[0]!=1){
                return 1;
            }else {
                return 2;
            }
        }
        for (int i = 1; i < nums.length; i++) {

            if (nums[minushelper]<0){
                minushelper++;
                if (minushelper == nums.length-1){
                    if (nums[minushelper]<0){
                        continue;
                    }else {
                        helper3=0;
                    }
                }else {
                    continue;
                }

            }else {

                helper3=0;
                integerhelper++;
            }
            if (nums[minushelper]==1 ){
                if (nums[i]==nums[i-1]){
                    integerhelper--;
                    continue;
                }
                if (nums[i]!=integerhelper+1){
                    lamp= nums[i-1]+1;
                    break;
                }
            }else if (nums[minushelper]==0 ){
                if (nums[i]==nums[i-1]){
                    integerhelper--;
                    continue;
                }
                if (nums[i]!=integerhelper){
                    if (nums[i-1]==0){
                        lamp = 1;
                        break;
                    }else {

                        lamp =  nums[i-1]+1;
                        break;
                    }
                }
            }else if (nums[minushelper]>0){
                lamp= 1;
                break;
            }
        }
        if (helper3 == 1){
            return 1;
        }
        if (lamp==9){
            return nums[nums.length-1]+1;
        }else {
            return lamp;
        }

    }

}
