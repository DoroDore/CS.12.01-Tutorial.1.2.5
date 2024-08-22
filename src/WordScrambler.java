public class WordScrambler {

    private final String[] scrambledWords;

    public WordScrambler(String[] wordArr) {
        if (wordArr.length %2 != 0) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        for (String s : wordArr) {
            if (s.contains(" ")) {
                throw new IllegalArgumentException("Word Array must contain single words only! " + s + " contains more than one word!");
            }
        }
        scrambledWords = wordArr;

    }

    private String recombine(String word1, String word2) {
        String thing = "";
        thing += word1.substring(0, word1.length() / 2);
        thing += word2.substring(word2.length()/2);
        return thing;
    }

    public String[] getScrambledWords() {
        String[] thing = new String[scrambledWords.length];
        for(int i = 0; i < thing.length; i+=2) {
            thing[i] = recombine(scrambledWords[i], scrambledWords[i+1]);
            thing[i+1] = recombine(scrambledWords[i+1], scrambledWords[i]);
        }
        return thing;
    }
}