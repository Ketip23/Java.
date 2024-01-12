import stdlib.StdIn;
import stdlib.StdOut;

public class Outcast {
    private WordNet wordnet;

    // Constructs an Outcast object given the WordNet semantic lexicon.
    public Outcast(WordNet wordnet) {
        if (wordnet == null)
            throw new NullPointerException("wordnet is null");

        this.wordnet = wordnet;
    }

    // Returns the outcast noun from nouns.
    public String outcast(String[] nouns) {
        return null;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        String[] nouns = StdIn.readAllStrings();
        String outcastNoun = outcast.outcast(nouns);
        for (String noun : nouns) {
            StdOut.print(noun.equals(outcastNoun) ? "*" + noun + "* " : noun + " ");
        }
        StdOut.println();
    }
}
