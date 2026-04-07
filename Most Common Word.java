

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    // Regex pattern to match sequences of lowercase letters
    private static final Pattern WORD_PATTERN = Pattern.compile("[a-z]+");

    public String mostCommonWord(String paragraph, String[] banned) {
        // Create a set of banned words for O(1) lookup
        Set<String> bannedWordsSet = new HashSet<>();
        for (String word : banned) {
            bannedWordsSet.add(word);
        }
      
        // Map to count frequency of each valid word
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
      
        // Convert paragraph to lowercase and find all words using regex
        Matcher matcher = WORD_PATTERN.matcher(paragraph.toLowerCase());
        while (matcher.find()) {
            String currentWord = matcher.group();
          
            // Skip if the word is in the banned list
            if (bannedWordsSet.contains(currentWord)) {
                continue;
            }
          
            // Update the frequency count for the current word
            wordFrequencyMap.put(currentWord, wordFrequencyMap.getOrDefault(currentWord, 0) + 1);
        }
      
        // Find the word with the maximum frequency
        int maxFrequency = Integer.MIN_VALUE;
        String mostCommonWord = null;
      
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostCommonWord = entry.getKey();
            }
        }
      
        return mostCommonWord;
    }
}