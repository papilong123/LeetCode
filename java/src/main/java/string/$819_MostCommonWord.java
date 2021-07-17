package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class $819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph+=".";
        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> M = new HashMap();

        int ansfreq=0;
        String ans="";
        StringBuilder str=new StringBuilder();
        for(char c : paragraph.toCharArray()){
            if(Character.isLetter(c)){
                str.append(Character.toLowerCase(c));
            }else if(str.length()>0){
                String finalword=str.toString();
                if(!banset.contains(finalword)){
                    M.put(finalword,M.getOrDefault(finalword,0)+1);
                    if (M.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = M.get(finalword);
                    }
                }
                str= new StringBuilder();
            }
        }
        return ans;
    }
}
