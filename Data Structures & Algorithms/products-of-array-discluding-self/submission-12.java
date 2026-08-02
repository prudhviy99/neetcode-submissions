class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int zeroCount = 0;
        int product = 1;

        for ( int i =0; i < nums.length; i++ ) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            else {
                product = product * nums[i];
            }    
        }

        int[] res = new int[nums.length];
        if (zeroCount > 1) {
            for (int i = 0; i < res.length; i++) {
                res[i] = 0;
            }
            return res;
        }

        if (zeroCount == 1) {
            for ( int i =0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    res[i] = product;
                }
                else {
                res[i] = 0;
            }}
            return res;
        }

        for ( int i = 0; i < nums.length; i++) {
            if( nums[i] != 0) {
            res[i] = product  / nums[i];
        }
        }
        return res;
    }
}  


// can use the division approach, where the we calculate the product of all elements in the array and then for each element in the array we will divide the element by total prodcut
// before that, we should check for zeros
// during the first pass, if its zero, we skip and we can keep the count of the zero
// if one zero, we can skip that element and just return product of the all other elements in that place.
// if two zeros, we can just return an array with all zeros

// during second pass, we just divide the total product with current element

