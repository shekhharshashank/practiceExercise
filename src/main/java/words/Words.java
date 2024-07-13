package words;

import java.util.HashSet;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Words.
 */
public class Words {
	
	
	/**
	 * Gets the unique words from sentence.
	 *
	 * @param sentence the sentence
	 * @return the unique words from sentence
	 */
	public static List<String> getUniqueWordsFromSentence(String sentence) {

		String[] strArray = sentence.split("[^\\w]");
		HashSet<String> hashSet = new HashSet<String>();

		for (String s : strArray) {
			if (!s.isEmpty()) {
				hashSet.add(s.toLowerCase());
			}

		}

		return hashSet.stream().toList();

	}
}
