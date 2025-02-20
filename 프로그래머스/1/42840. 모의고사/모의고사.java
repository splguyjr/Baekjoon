class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5};
        int a = 0, b = 0, c = 0;
        int idx = 0;
        
        for(int x : answers) {
            if(x == arr1[idx%40]) a++;
            if(x == arr2[idx%40]) b++;
            if(x == arr3[idx%40]) c++;
            idx++;
        }
        
        if(a==b && a==c) {
            return new int[]{1,2,3};
        }
        else if(a==b && b > c) {
            return new int[]{1,2};
        }
        else if(b==c && b > a) {
            return new int[]{2,3};
        }
        else if(c==a && a > b) {
            return new int[]{1,3};
        }
        else {
            if(a>b && a>c) return new int[]{1};
            else if(b>c && b>a) return new int[]{2};
            return new int[]{3};
        }
    }
}