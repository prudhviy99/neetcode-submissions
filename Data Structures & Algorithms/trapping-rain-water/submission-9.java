class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;

        int l = 0;
        int r = height.length - 1;

        int maxL = height[0];
        int maxR = height[height.length - 1];

        int res = 0;

        while(l < r) {
            if(maxL < maxR) {
                l++;
                

                if(maxL < height[l])
                    maxL = height[l];

                int curr = maxL - height[l];

                if (curr > 0)
                    res = res + curr;
                
            } else {
                    r--;

                    if(maxR < height[r])
                        maxR = height[r];

                    int curr = maxR - height[r];


                    if(curr > 0)
                        res = res + curr;
            }
        }
    return res;
    }
}
