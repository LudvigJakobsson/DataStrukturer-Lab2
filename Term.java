import java.lang.*;
import java.util.Comparator;

public class Term {
    private String word;
    private long weight;

    // Initializes a term with a given word and weight.
    public Term(String word, long weight) {
        this.word = word;
        this.weight = weight;
    }

    // Gets the word.
    public String getWord() {
        return word;
    }

    // Gets the weight.
    public long getWeight() {
        return weight;
    }

    // Extracts a prefix from the word.
    public String getPrefix(int len) {
        if (len >= this.word.length()) {
            return this.word;
        } else {
            return this.word.substring(0, len);
        }
    }


    // Compares the two terms in case-insensitive lexicographic order.
    public static Comparator<Term> byLexicographicOrder() {
        return new Comparator<Term>() {
            @Override
             public int compare(Term o1, Term o2){
                return o1.getWord().compareToIgnoreCase(o2.getWord());
            }
        };
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                return -1 * o1.longCompare(o2.getWeight());
            }
        };
    }

    // Compares the two terms in case-insensitive lexicographic order,
    // but using only the first k characters of each word.
    public static Comparator<Term> byPrefixOrder(int k) {
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2){
                return o1.getPrefix(k).compareToIgnoreCase(o2.getPrefix(k));
            }
        };
    }

    public int longCompare(long b) {
        long a = this.getWeight();
        if (a == b) {
            return 0;
        } else if (a < b) {
            return -1;
        } else {
            return 1;
        }
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by whitespace, followed by the word.
    public String toString() {
        return String.format("%12d    %s", this.getWeight(), this.getWord());
    }


}
