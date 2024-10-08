public class Main {
    public void maxSentence(StringBuffer text) {
        String[] sentences;
        String[][] words;
        int maxFreq = 0;
        String mostFreqWord = "";

        try {
            String inputText = text.toString();

            // splitting text into sentences
            sentences = splitSentences(inputText);
            words = new String[sentences.length][];

            // splitting sentences into words
            for (int i = 0; i < sentences.length; i++) {
                words[i] = splitWords(sentences[i].toLowerCase());
            }

            // finding the most frequent word
            for (int i = 0; i < words.length; i++) {
                for (String word : words[i]) {
                    int freq = 0;

                    // counting the number of sentences containing the word
                    for (int j = 0; j < words.length; j++) {
                        if (containsWord(words[j], word)) {
                            freq++;
                        }
                    }

                    if (freq > maxFreq) {
                        maxFreq = freq;
                        mostFreqWord = word;
                    }
                }
            }
            System.out.println("The most frequent word is: " + mostFreqWord);
            System.out.println("Number of sentences containing the word: " + maxFreq);
        } catch (NullPointerException e) {
            System.out.println("The text is empty");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // function to split text into sentences
    private String[] splitSentences(String text) {
        return text.split("[.!?]");
    }

    // function to split sentences into words
    private String[] splitWords(String sentence) {
        return sentence.split("[ ,;]");
    }

    // function to check if a word is in the sentence
    private boolean containsWord(String[] words, String word) {
        for (String w :words) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StringBuffer text = new StringBuffer("Hello, world! Hello, Aboba? Hello, John.");
        Main analyze = new Main();
        analyze.maxSentence(text);
    }
}