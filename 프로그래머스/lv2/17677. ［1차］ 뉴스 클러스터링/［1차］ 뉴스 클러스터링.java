import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
                
        double jaccard = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i = 0; i < str1.length()-1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);
            
            if((first >= 'a' && first <= 'z') && (second >= 'a' && second <= 'z')) {
                list1.add(first + "" + second);
            }
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);
            
            if((first >= 'a' && first <= 'z') && (second >= 'a' && second <= 'z')) {
                list2.add(first + "" + second);
            }
        }
        
        for(String s : list1) {
            if(list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        for(String s : list2) {
            union.add(s);
        }
        
        if(union.size() == 0) {
            jaccard = 1;
        } else {
            jaccard = (double)intersection.size() / (double)union.size();
        }
        return (int)(jaccard * 65536);
    }
}