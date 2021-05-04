package dependencies;

import org.apache.commons.lang3.StringUtils;

/*
 * Klasa testowa dla zarządzania zależnościami i wpinania pluginów do cyklu
 * budowania aplikacj
 *
 * @author Kamil
 *
*/

public class NameVerifier {

	public static void main(String[] args) {
		String name = "Kamil";
		System.out.println(StringUtils.isAlpha(name));
	}

	/*
	 * Metoda dodająca dwie liczby
	 * 
	 * @param a
	 * 
	 * @param b
	 * 
	 * @param suma a+b
	 */
	public int add(int a, int b) {
		return a + b;
	}

}
