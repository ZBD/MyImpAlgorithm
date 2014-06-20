public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<String>();
        }
        
        Map<Integer, List<String>> prefix = new HashMap<Integer, List<String>>(); // s.substring(0, index)
        
        prefix.put(0, new ArrayList<String>());
        
        //is s.substring(0,0) null or empty??
        for (int i=0; i<s.length(); i++) {
            if (prefix.get(i) != null) {
                for (String word : dict) {
                    if (s.substring(i, i+word.length()).equals(word)) {
                        int j = i + word.length();
                        if (prefix.get(j) == null) {
                            List<String> list = new ArrayList<String>();
                            list.add(word);
                            prefix.put(j, list);
                        }
                        else {
                            prefix.get(j).add(word);
                        }
                    }
                }
            }
        }
        
        return buildList(prefix, s.length());
    }
    
    private List<String> buildList(Map<Integer, List<String>> prefix, int length) {
        
    }
}
