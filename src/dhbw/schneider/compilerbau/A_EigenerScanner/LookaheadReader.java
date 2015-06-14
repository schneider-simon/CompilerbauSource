/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel AS-SCanner 3
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.A_EigenerScanner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LookaheadReader {
	
	private InputStreamReader reader = null;
	
	private LinkedList<Integer> buffer = new LinkedList<Integer>();
	
	public LookaheadReader(InputStreamReader reader) {
		this.reader = reader;
	}
	
	public void close() throws IOException {
		reader.close();
	}
	
	public int lookahead(int n) throws IOException {
		while (buffer.size()<n) {
			buffer.add(reader.read());
		}
		return buffer.get(n-1);
	}
	
	public int read() throws IOException {
		if (buffer.size()>0) {
			return buffer.poll().intValue();
		} else {
			return reader.read();
		}
	}

}
