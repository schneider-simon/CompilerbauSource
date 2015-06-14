/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel AS-SCanner 5
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.A_EigenerScanner;

import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTable {

	private ArrayList<String> table = null;
	private HashMap<String, Integer> map = null;
	
	private static SymbolTable instance = null;
	
	public static SymbolTable getInstance() {
		if (instance==null) {
			instance = new SymbolTable();
		}
		return instance;
	}

	private SymbolTable() {
		table = new ArrayList<String>();
		map = new HashMap<String, Integer>();
	}

	private SymbolTable(int initialSize) {
		table = new ArrayList<String>(initialSize);
		map = new HashMap<String, Integer>(initialSize);
	}

	public int add(String symbol) {
		if (map.containsKey(symbol)) {
			return map.get(symbol).intValue();
		} else {
			int res = table.size();
			table.add(symbol);
			map.put(symbol, new Integer(res));
			return res;
		}

	}

	public void add(String symbol, int number) throws Exception {
		if (map.containsKey(symbol)) {
			if (table.get(map.get(symbol)).equals(symbol)) {
				/* ignore this - duplicate entry */
			} else {
				throw new Exception("Invalid entry " + number + " for "
						+ symbol + ". Entry taken by "
						+ (table.get(map.get(symbol)))+".");

			}
		} else {
			while(table.size()<=number) table.add("");
			table.set(number, symbol);
			map.put(symbol, new Integer(number));
		}
	}

	public String get(int number) {
		return table.get(number);
	}

}
