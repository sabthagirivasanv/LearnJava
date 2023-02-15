package com;

import java.util.Stack;

class Histogram {
    class Hist{
        int pos;
        int height;

        public Hist(int pos, int height){
            this.pos = pos;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Hist> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int end = 0;
        while(end < heights.length){
            if(stack.isEmpty() || stack.peek().height <= heights[end]){
                if(heights[end] > 0){
                    stack.push(new Hist(end, heights[end]));
                }
                end++;
            }else{
                Hist top = stack.pop();
                while(!stack.empty() && stack.peek().height >= heights[end]){
                    maxArea = Math.max(maxArea, (end - top.pos) * top.height);
                    top = stack.pop();
                }
                maxArea = Math.max(maxArea, (end - top.pos) * top.height);
                if(heights[end] > 0){
                    stack.push(new Hist(top.pos, heights[end]));
                }
            }
        }

        while(!stack.empty()){
            Hist top = stack.pop();
            int area = top.height * (heights.length - top.pos);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Histogram histogram = new Histogram();
        System.out.println(histogram.largestRectangleArea(new int[]{2,0,2,4,4,2,3,0}));
    }
}
