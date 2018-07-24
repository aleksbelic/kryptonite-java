package start;

import cyphers.CaesarCipher;
import common.Constants;

public class Start {

	public static void main(String[] args) {
		
		CaesarCipher c = new CaesarCipher(Constants.ALPHABET_EN);
		System.out.println(c.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
		System.out.println(c.decrypt("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!", 23));
	}

}
