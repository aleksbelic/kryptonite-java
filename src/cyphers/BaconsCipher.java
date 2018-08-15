package cyphers;

import java.util.HashMap;

/**
 * Bacon's Cipher class, both versions.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class BaconsCipher {

	// substitution map, has different values for verion 1 and 2
	private HashMap<Character, String> alphabetMap = new HashMap<Character, String>();

	public BaconsCipher(String version) {
		alphabetMap.put('a', "aaaaa");
		alphabetMap.put('b', "aaaab");
		alphabetMap.put('c', "aaaba");
		alphabetMap.put('d', "aaabb");
		alphabetMap.put('e', "aabaa");
		alphabetMap.put('f', "aabab");
		alphabetMap.put('g', "aabba");
		alphabetMap.put('h', "aabbb");
		alphabetMap.put('i', "abaaa");
		if (version == "1") {
			alphabetMap.put('j', "abaaa");
			alphabetMap.put('k', "abaab");
			alphabetMap.put('l', "ababa");
			alphabetMap.put('m', "ababb");
			alphabetMap.put('n', "abbaa");
			alphabetMap.put('o', "abbab");
			alphabetMap.put('p', "abbba");
			alphabetMap.put('q', "abbbb");
			alphabetMap.put('r', "baaaa");
			alphabetMap.put('s', "baaab");
			alphabetMap.put('t', "baaba");
			alphabetMap.put('u', "baabb");
			alphabetMap.put('v', "baabb");
			alphabetMap.put('w', "babaa");
			alphabetMap.put('x', "babab");
			alphabetMap.put('y', "babba");
			alphabetMap.put('z', "babbb");
		} else if (version == "2") {
			alphabetMap.put('j', "abaab");
			alphabetMap.put('k', "ababa");
			alphabetMap.put('l', "ababb");
			alphabetMap.put('m', "abbaa");
			alphabetMap.put('n', "abbab");
			alphabetMap.put('o', "abbba");
			alphabetMap.put('p', "abbbb");
			alphabetMap.put('q', "baaaa");
			alphabetMap.put('r', "baaab");
			alphabetMap.put('s', "baaba");
			alphabetMap.put('t', "baabb");
			alphabetMap.put('u', "babaa");
			alphabetMap.put('v', "babab");
			alphabetMap.put('w', "babba");
			alphabetMap.put('x', "babbb");
			alphabetMap.put('y', "bbaaa");
			alphabetMap.put('z', "bbaab");
		} else {
			throw new IllegalArgumentException("ERROR: false cipher version given. Try passing \"1\" or \"2\".");
		}
	}

	/**
	 * Encrypts given string.
	 * 
	 * @param s string to encrypt
	 * @param misleadingText visible text in which we are going to hide our real message
	 * @return encrypted string
	 */
	public String encrypt(String s, String misleadingText) {
		
		// TODO
		// check if misleading text is shorter than substitute string!
		
		// original Bacon's cipher uses bold & regular letters, we'll be using uppercase & lowercase letters respectively
		s = s.toLowerCase();
		misleadingText = misleadingText.toLowerCase();
		
		String substituteForChar = "";
		String substituteString = "";
		String encryptedString = "";
		
		for (int i = 0; i < s.length(); i++) {
			substituteForChar = alphabetMap.get(s.charAt(i));
			if (substituteForChar != null) {
				substituteString += substituteForChar;
			}
		}
		
		for (int i = 0, j = 0; i < substituteString.length(); i++, j++) {
			if (!Character.isLetter(misleadingText.charAt(j % misleadingText.length()))) {
				while (!Character.isLetter(misleadingText.charAt(j % misleadingText.length()))) {
					encryptedString += misleadingText.charAt(j % misleadingText.length());
					j++;
				}
			}
			if (substituteString.charAt(i) == 'a') {
				encryptedString += misleadingText.charAt(j % misleadingText.length());
			} else if (substituteString.charAt(i) == 'b') {
				encryptedString += Character.toUpperCase(misleadingText.charAt(j % misleadingText.length()));
			}
		}
		
		return encryptedString;
	}

}