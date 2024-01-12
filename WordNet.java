import dsa.DiGraph;
import dsa.SeparateChainingHashST;
import dsa.Set;
import stdlib.In;
import stdlib.StdOut;

public class WordNet {
    private SeparateChainingHashST<String, Set<Integer>> st;
    private SeparateChainingHashST<Integer, String> rst;
    private ShortestCommonAncestor sca;
    private DiGraph G;



    // Constructs a WordNet object given the names of the input (synset and hypernym) files.
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null)
            throw new NullPointerException("synsets is null");
        if (hypernyms == null)
            throw new NullPointerException("hypernyms is null");
        In hypernymsFile = new In(hypernyms);
        G = new DiGraph(st.size()); // Assuming you have a size() method in SeparateChainingHashST

        while (hypernymsFile.hasNextLine()) {
            String line = hypernymsFile.readLine();
            String[] parts = line.split(","); // Adjust this according to your hypernyms file format

            int v = Integer.parseInt(parts[0]);
            for (int i = 1; i < parts.length; i++) {
                int w = Integer.parseInt(parts[i]);
                G.addEdge(v, w);
            }
        }

        hypernymsFile.close();

        st = new SeparateChainingHashST<>();
        rst = new SeparateChainingHashST<>();
        sca = new ShortestCommonAncestor(G);
    }

    // Returns all WordNet nouns.
    public Iterable<String> nouns() {
        return st.keys();
    }

    // Returns true if the given word is a WordNet noun, and false otherwise.
    public boolean isNoun(String word) {
        if (word == null)
            throw new NullPointerException("word is null");

        return st.contains(word);
    }

    // Returns a synset that is a shortest common ancestor of noun1 and noun2.
    public String sca(String noun1, String noun2) {
        if (noun1 == null)
            throw new NullPointerException("noun1 is null");
        if (noun2 == null)
            throw new NullPointerException("noun2 is null");
        if (!isNoun(noun1))
            throw new IllegalArgumentException("noun1 is not a noun");
        if (!isNoun(noun2))
            throw new IllegalArgumentException("noun2 is not a noun");
        return null;
    }

    // Returns the length of the shortest ancestral path between noun1 and noun2.
    public int distance(String noun1, String noun2) {
        if (noun1 == null)
            throw new NullPointerException("noun1 is null");
        if (noun2 == null)
            throw new NullPointerException("noun2 is null");
        if (!isNoun(noun1))
            throw new IllegalArgumentException("noun1 is not a noun");
        if (!isNoun(noun2))
            throw new IllegalArgumentException("noun2 is not a noun");
        return -1;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        String word1 = args[2];
        String word2 = args[3];
        int nouns = 0;
        for (String noun : wordnet.nouns()) {
            nouns++;
        }
        StdOut.printf("# of nouns = %d\n", nouns);
        StdOut.printf("isNoun(%s)? %s\n", word1, wordnet.isNoun(word1));
        StdOut.printf("isNoun(%s)? %s\n", word2, wordnet.isNoun(word2));
        StdOut.printf("isNoun(%s %s)? %s\n", word1, word2, wordnet.isNoun(word1 + " " + word2));
        StdOut.printf("sca(%s, %s) = %s\n", word1, word2, wordnet.sca(word1, word2));
        StdOut.printf("distance(%s, %s) = %s\n", word1, word2, wordnet.distance(word1, word2));
    }
}
