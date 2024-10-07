public class Main {
    public void maxSentence(StringBuffer text) {
        String[] sentences;
        String[][] words;
        int maxFreq = 0;
        String mostFreqWord = "";

        try {
            String inputText = text.toString();

            sentences = splitSentences(inputText);
            words = new String[sentences.length][];

            for (int i = 0; i < sentences.length; i++) {
                words[i] = splitWords(sentences[i].toLowerCase());
            }
        }
    }

    private String[] splitSentences(String text) {
        return text.split("[.!?]");
    }

    private String[] splitWords(String sentence) {
        return sentence.split("[ ,;]");
    }

    public static void main(String[] args) {
    }
}