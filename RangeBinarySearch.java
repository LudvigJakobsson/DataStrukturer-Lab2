
import java.util.Collection;
import java.util.Comparator;

public class RangeBinarySearch {

    // Returns the index of the *first* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N), where N is the length of the array
    public static int firstIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        int L = 0;
        int R = terms.length - 1;
        while (L < R) {
            int m = (int) ((R + L) / 2);
            if (comparator.compare(terms[m], key) == -1) {
                L = m + 1;
            } else {
                R = m;
            }
        }
        if (comparator.compare(terms[L], key) == 0) {
            return L;
        }
        else{
            return -1;
        }
    }

    // Returns the index of the *last* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N)
    public static int lastIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        int L = 0;
        int R = terms.length - 1;
        while (L < R) {
            int m = (int) ((R + L) / 2);
            if (comparator.compare(terms[m], key) == 1) {
                R = m;

            } else {
                L = m + 1;
            }
        }
        if (comparator.compare(terms[R - 1], key) == 0) {
            return R - 1;
        }
        else{
            return -1;
    }
}

}
