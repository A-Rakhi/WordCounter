package word.counter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashmapWordCounter {
	
	    public static void main(String[] args) {
	        String filePath = "rakhi.txt";

	        Map<String, Integer> wordCountMap = countWordOccurrences(filePath);

	        // show word count for each unique word in alphabetical order
	        displayWordOccurrences(wordCountMap);
	    }

	    // counting function
	    public static Map<String, Integer> countWordOccurrences(String filePath) {
	        Map<String, Integer> wordCountMap = new HashMap<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] words = line.split("[\\s.,;:!?()]+");
	                for (String word : words) {
	                    word = word.toLowerCase();
	                    if (word.length() > 0) {
	                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return wordCountMap;
	    }

	    // word count display for each unique word 
	    public static void displayWordOccurrences(Map<String, Integer> wordCountMap) {
	        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }
	}
	



