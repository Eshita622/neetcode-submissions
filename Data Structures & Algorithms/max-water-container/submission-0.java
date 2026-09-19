class Solution {
    public int maxArea(int[] heights) {
        int maxArea=0;
        int a_pointer=0;
        int b_pointer=heights.length-1;

        while(a_pointer<=b_pointer){
            if(heights[a_pointer] < heights[b_pointer]){
                maxArea=Math.max(maxArea,heights[a_pointer]*(b_pointer-a_pointer));
                a_pointer+=1;
            }else{
                maxArea=Math.max(maxArea,heights[b_pointer]*(b_pointer-a_pointer));
                b_pointer-=1;

            }
        }
        return maxArea;
    }
}
