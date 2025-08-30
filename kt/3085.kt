import kotlin.math.min

class Solution {
    fun minimumDeletions(word: String, k: Int): Int {
        // Step 1: Calculate the frequency of each character in the word.
        // 'count' will be a map where keys are characters and values are their frequencies.
        val count = word.toCharArray().groupBy { c -> c }.mapValues { it.value.size }

        // Step 2: Get the list of character frequencies and sort them.
        // The problem statement implies we need to consider all characters, not just adjacent ones.
        // Sorting the frequencies helps in iterating through potential target ranges.
        // We can sort them in ascending or descending order; the logic will adapt.
        // Using sortedDescending() as per the user's initial snippet, which is fine.
        val sortedCounts = count.values.sortedDescending()

        // If the word is empty, no deletions are needed.
        if (sortedCounts.isEmpty()) {
            return 0
        }

        // Initialize 'minTotalDeletions' to a very large value.
        // This variable will store the minimum number of deletions found across all possibilities.
        var minTotalDeletions = Int.MAX_VALUE

        // Step 3: Iterate through each unique character frequency as a potential 'minAllowedFreq'.
        // The core idea is to assume that one of the existing character frequencies
        // will be the minimum allowed frequency in the final string.
        // For each such assumption, we calculate the deletions required.
        for (minAllowedFreq in sortedCounts) {
            // Based on the chosen 'minAllowedFreq' and the given 'k',
            // calculate the maximum allowed frequency for any character.
            val maxAllowedFreq = minAllowedFreq + k
            var currentDeletions = 0 // Deletions for the current 'minAllowedFreq' assumption.

            // Step 4: For the current 'minAllowedFreq' and 'maxAllowedFreq' range,
            // iterate through all character frequencies and calculate necessary deletions.
            for (freq in sortedCounts) {
                if (freq < minAllowedFreq) {
                    // If a character's frequency ('freq') is less than our chosen 'minAllowedFreq',
                    // it means this character cannot exist in the final string under this assumption.
                    // Therefore, we must delete all occurrences of this character.
                    currentDeletions += freq
                } else if (freq > maxAllowedFreq) {
                    // If a character's frequency ('freq') is greater than our calculated 'maxAllowedFreq',
                    // we must reduce its frequency to 'maxAllowedFreq'.
                    // The number of deletions for this character is the difference.
                    currentDeletions += freq - maxAllowedFreq
                }
                // If 'minAllowedFreq <= freq <= maxAllowedFreq', the character's frequency
                // is already within the acceptable range, so no deletions are needed for it.
            }
            // Step 5: Update 'minTotalDeletions' with the minimum value found so far.
            minTotalDeletions = min(minTotalDeletions, currentDeletions)
        }

        // Step 6: Return the overall minimum deletions required.
        return minTotalDeletions
    }

}