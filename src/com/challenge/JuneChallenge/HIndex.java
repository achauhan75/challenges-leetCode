package com.challenge.JuneChallenge;

public class HIndex {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        int left = 0, right = citations.length-1, mid;
        while(left<=right){
            mid = (left+right)/2;
            if(citations[mid]==citations.length-mid)
                return citations.length-mid;
            else if(citations[mid]<citations.length-mid)
                left = mid+1;
            else
                right = mid-1;
        }
        return citations.length-left;
    }
}
