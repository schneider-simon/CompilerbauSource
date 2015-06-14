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

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class LookaheadReaderTest {

	public String EXAMPLE = "abcdefgh";

	@Test
	public void testRead() throws IOException {
		LookaheadReader reader = new LookaheadReader(new InputStreamReader(
				new ByteArrayInputStream(EXAMPLE.getBytes())));
		assertEquals('a', reader.read());
		assertEquals('b', reader.read());
		assertEquals('c', reader.read());
		assertEquals('d', reader.read());
		assertEquals('e', reader.read());
		assertEquals('f', reader.read());
		assertEquals('g', reader.read());
		assertEquals('h', reader.read());
		assertEquals(-1, reader.read());
		assertEquals(-1, reader.read());
		assertEquals(-1, reader.read());
		reader.close();
	}

	@Test
	public void testLookahead() throws IOException {
		LookaheadReader reader = new LookaheadReader(new InputStreamReader(
				new ByteArrayInputStream(EXAMPLE.getBytes())));
		assertEquals('a', reader.read());
		assertEquals('b', reader.lookahead(1));
		assertEquals('b', reader.lookahead(1));
		assertEquals('c', reader.lookahead(2));
		assertEquals('b', reader.read());
		assertEquals('c', reader.read());
		assertEquals('h', reader.lookahead(5));
		assertEquals(-1, reader.lookahead(6));
		assertEquals(-1, reader.lookahead(7));
		assertEquals('d', reader.read());
		assertEquals('e', reader.read());
		assertEquals('f', reader.read());
		assertEquals('g', reader.read());
		assertEquals('h', reader.read());
		assertEquals(-1, reader.read());
		assertEquals(-1, reader.read());
		assertEquals(-1, reader.read());
		reader.close();
	}

}
