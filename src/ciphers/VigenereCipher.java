package ciphers;

import java.util.HashMap;
import common.Constants;

/**
 * VigenereCipher class.
 * 
 * @author Aleksandar.Belic <aleks.belic@gmail.com>
 */
public class VigenereCipher {

	private String alphabet = Constants.ALPHABET_EN;
	private HashMap<Character, String> tabulaRecta = new HashMap<Character, String>();

	/**
	 * Constructor generates tabula recta with default english alphabet.
	 */
	public VigenereCipher() {
		alphabet = Constants.ALPHABET_EN;
		String shiftedAlphabet = "";
		for (int i = 0; i < alphabet.length(); i++) {
			shiftedAlphabet = alphabet.substring(i) + alphabet.substring(0, i);
			tabulaRecta.put(alphabet.charAt(i), shiftedAlphabet);
		}
	}

	/**
	 * Constructor generates tabula recta with user defined alphabet.
	 */
	public VigenereCipher(String userAlphabet) {
		alphabet = userAlphabet;
		String shiftedAlphabet = "";
		for (int i = 0; i < alphabet.length(); i++) {
			shiftedAlphabet = alphabet.substring(i) + alphabet.substring(0, i);
			tabulaRecta.put(alphabet.charAt(i), shiftedAlphabet);
		}
	}

	/**
	 * Encrypts given string using specified keyword.
	 * 
	 * @param plaintext string to encrypt
	 * @param keyword phrase to use in encryption process
	 * @return encrypted string
	 */
	public String encrypt(String plaintext, String keyword) {
		keyword = keyword.toUpperCase();
		String encryptedString = "";
		String shiftedAlphabet = "";
		char currentChar;
		int currentCharPositionInAlphabet;
		int keywordCounter;
		for (int i = 0, j = 0; i < plaintext.length(); i++, j++) {
			keywordCounter = j % keyword.length();
			currentChar = Character.toUpperCase(plaintext.charAt(i));
			if (alphabet.indexOf(currentChar) == -1) {
				encryptedString += currentChar;
				j--;
			} else {
				shiftedAlphabet = tabulaRecta.get(keyword.charAt(keywordCounter));
				currentCharPositionInAlphabet = alphabet.indexOf(currentChar);
				encryptedString += shiftedAlphabet.charAt(currentCharPositionInAlphabet);
			}
		}
		return encryptedString;
	}

	/**
	 * Decrypts given string using specified keyword.
	 * 
	 * @param ciphertext string to decrypt
	 * @param keyword phrase to use in decryption process
	 * @return decrypted string
	 */
	public String decrypt(String ciphertext, String keyword) {
		keyword = keyword.toUpperCase();
		String decryptedString = "";
		String shiftedAlphabet = "";
		char currentChar;
		int currentCharPositionInAlphabet;
		int keywordCounter;
		for (int i = 0, j = 0; i < ciphertext.length(); i++, j++) {
			keywordCounter = j % keyword.length();
			currentChar = Character.toUpperCase(ciphertext.charAt(i));
			if (alphabet.indexOf(currentChar) == -1) {
				decryptedString += currentChar;
				j--;
			} else {
				shiftedAlphabet = tabulaRecta.get(keyword.charAt(keywordCounter));
				currentCharPositionInAlphabet = shiftedAlphabet.indexOf(currentChar);
				decryptedString += alphabet.charAt(currentCharPositionInAlphabet);
			}
		}
		return decryptedString;
	}
}