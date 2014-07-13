import java.util.*;


public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> justfied = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return justfied;
        }
        
        //get a line
        int i = 0;
        while (i < words.length) {
            int nextLine = getNextLineIndex(words, i, L);
            justfied.add(justfy(words, i, nextLine-1, L));
            i = nextLine;
        }
        
        return justfied;
    }
    
    private int getNextLineIndex(String[] words, int start, int L) {
        int i = start + 1;
        int len = words[start].length();
        while (i<words.length && len + words[i].length() + 1 <= L) {
            len += words[i++].length() + 1;
        }
        return i;
    }
    
    private String justfy(String[] words, int start, int end, int L) {
        //last line
        if (end == words.length - 1) return leftJustfy(words, start, L);
        //single word line in the middle
        if (start == end) return padWord(words[start], L);
        
        //normal line with at least two words
        StringBuilder sb = new StringBuilder(L);
        int clen = 0;
        for (int i=start; i<=end; i++) {
            clen += words[i].length();
        }
        int extra = (L-clen) % (end-start);
        int num = (L-clen) / (end-start);
        String pads = getPads(num);
        for (int i=0; i<extra; i++) {
            sb.append(words[start+i]+pads+" ");
        }
        for (int i=start+extra; i<end; i++) {
            sb.append(words[i]+pads);
        }
        sb.append(words[end]);
        return sb.toString();
    }
    
    private String getPads(int num) {
        StringBuilder pads = new StringBuilder(num);
        for (int i=0; i<num; i++)
            pads.append(" ");
        return pads.toString();
    }
    
    private String padWord(String word, int L) {
        StringBuilder sb = new StringBuilder(L);
        sb.append(word);
        for (int i=word.length(); i<L; i++) 
            sb.append(" ");
        return sb.toString();
    }
    
    private String leftJustfy(String[] words, int start, int L) {
        StringBuilder sb = new StringBuilder(words[start]);
        for (int i=start+1; i<words.length; i++) {
            sb.append(" " + words[i]);
        }
        for (int i=sb.length(); i<L; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}