class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";
        
        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            
            if (!sorted.equals(prev)) {
                result.add(word);
                prev = sorted;
            }
        }
        return result;
    }
}
