package com.asheesh.Problems.Stack;

import com.asheesh.Stacks.*;

public class LargestAreaHistogram{
	public static void main(String [] args){
		// Stack stack = new Stack(10);
		// stack.utilityMethod();
		int [] histogram =  {6, 3, 5, 4, 5, 2, 6};
		int l = largestArea(histogram,histogram.length);
		System.out.println(" largest area = " + l);
	}
	
	public static int largestArea(int [] A, int n){
		int maxArea = 0;
		int currentArea = 0;
		Stack s = new Stack(n);
		for(int i = 0 ; i < n ; i++){
			while(s.top >= 0 && (i == n-1  || A[s.S[s.top]] > A[i])){
				int left;
				if(s.top > 0){
					left = s.S[s.top - 1];	
				}else{
					left = -1;
				}
				currentArea = ((i-1) - left) * A[s.S[s.top]];
				if(currentArea > maxArea){
					maxArea = currentArea;
				}
				s.top--;
			}
			s.push(i);
		}
		
		while(s.top >= 0){
		currentArea = (n-1 - s.S[s.top] + 1) * A[s.S[s.top]];
		if(currentArea > maxArea){
			maxArea = currentArea;
		}
		s.top--;
		}
		
		return maxArea;
	}
}