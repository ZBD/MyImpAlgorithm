public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // you can use split
        // if (s == null || s.length() == 0) {
        //     return 0;
        // }
        // String[] strs = s.split(" +");
        // return strs.length == 0 ? 0 : strs[strs.length-1].length(); 
        
        //or DIY
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int pos = s.length() - 1;
        while(pos >= 0 && s.charAt(pos) == ' ') {
            pos--;
        }
        if (pos < 0) {
            return 0;
        }
        int length = 0;
        while (pos >= 0 && s.charAt(pos) != ' ') {
            pos--;
            length++;
        }
        return length;
    }
}