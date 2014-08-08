public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int tail = A.length-1;
        while (tail>=0 && A[tail] == elem) tail--;
        int i = 0;
        while (i < tail) {
            if (A[i] == elem) {
                A[i] = A[tail];
                A[tail] = elem;
                while (tail>=0 && A[tail] == elem) tail--;
            }
            i++;
        }
        
        return tail+1;
    }
    
}