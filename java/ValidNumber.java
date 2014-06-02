
public class ValidNumber {
    public boolean isNumber(String s) {
        //what is a numberic string?
        //can it contain whitespaces?       is ____123
        //can it contains +- signs?     is +    123 legal?  is +123 legal
        //can it start with meaningless 0s?     is 00000
        //can it be float?          1.3         .3?     -.3?            3.?true         .?false
            //can it be e           2e10        2.3e10      2.3e1.0?        +2.3e-1?        e10?false            E10?false        e?false
            
            
            //regular expression
            
            //corner case
            if (s == null) {
                return false;
            }
            
            
            char[] ch = s.toCharArray();
            //ignore the leading whitespaces
            int i = 0;
            while (i<ch.length && ch[i] == ' ') {
                i++;
            }
            
            //ignore the trailing whitespaces
            int j=ch.length-1;
            while (j >= i && ch[j] == ' ') {
                j--;
            }
            
            if (i > j) {
                //all whitespaces
                return false;
            }
            
            //ignore +-
            if (ch[i] == '-' || ch[i] == '+') {
                i++;
            }
            
            boolean hasDot = false; //canHaveDot will make life easier
            boolean hasE = false;   //canHaveE will make life easier
            boolean isNumber = false;
            while (i <= j) {
                if (ch[i] == '.') {
                    if (hasDot) {
                        //two . encounted, illegal
                        return false;
                    }
                    else {
                        hasDot = true;
                        if (hasE) {
                            //xxx e xxx.xxx,  illegal
                            return false;
                        }
                    }
                }
                else if (ch[i] == 'e') {
                    if (hasE) {
                        //two e encounted, illegal
                        return false;
                    }
                    else {
                        if (!isNumber) {
                            return false;
                        }
                        
                        //carefull index
                        if (i < j && (ch[i+1] == '-' || ch[i+1] == '+')) {
                            //ignore +- after e
                            i++;
                        }
                        hasE = true;
                        isNumber = false;
                    }
                }
                else if (ch[i] < '0' || ch[i] > '9') {
                    //illegal characters
                    return false;
                }
                else {
                    //number 0-9
                    isNumber = true;
                }
                i++;
            }
        
        return isNumber;
        
    }
    
    public boolean isNumberReg(String s) {
            //regular expression
        
        //corner case
        if (s == null) {
            return false;
        }
        
        //String.trim returns a copy of the string, with leading and trailing whitespace omitted. 
        if(s.trim().isEmpty()){  
            return false;  
        }  
        
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
        if(s.trim().matches(regex)){  
            return true;  
        }else{  
            return false;  
        }  
    }
}