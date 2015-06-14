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

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LookaheadReader {

	private InputStreamReader reader = null;

	/* Aufgabe 4 */
	private int line = 0;
	private int column = 0;
	private boolean newline = false;
	/* --- */

	private LinkedList<Integer> buffer = new LinkedList<Integer>();

	public LookaheadReader(InputStreamReader reader) {
		this.reader = reader;
		this.line = 1;
		this.column = 0;
	}

	public void close() throws IOException {
		reader.close();
	}

	public int lookahead(int n) throws IOException {
		while (buffer.size() < n) {
			buffer.add(reader.read());
		}
		return buffer.get(n - 1);
	}

	/* Aufgabe 4 */
	public int read() throws IOException {
		int res = 0;
		if (buffer.size() > 0) {
			res = buffer.poll().intValue();
		} else {
			res = reader.read();
		}
		if (res != '\r') {
			if (newline) {
				column = 0;
				line++;
				newline = false;
			} else {
				column++;
			}
		}
		if (res == '\n') {
			newline = true;
		}
		// System.out.println("read :" + res + " " + (char) res + "(" + line + ","
		//		+ column + ")");
		return res;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
	/* --- */

	
}
