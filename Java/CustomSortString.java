/*

You are given two strings order and s. All the words of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

*/

class Solution {
    public String customSortString(String order, String s) {
        
        StringBuilder result = new StringBuilder("");
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            map.merge(s.charAt(i), 1, (current, one) -> current + 1);
        }
        
        for(int i = 0; i < order.length(); i++){
            
            char c = order.charAt(i);
            
            while(map.containsKey(c) && map.get(c) > 0){ 
                result.append(c);
                if(map.get(c) == 1) map.remove(c);
                else map.merge(c, 1, (current, one) -> current - 1);
            }
        }
        
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        
        while(iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            while(entry.getValue() > 0){
                result.append(entry.getKey());
                map.merge(entry.getKey(), 1, (current, one) -> current - 1);
            }  
        }
        
        return result.toString();
    }
}