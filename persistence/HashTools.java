package de.sb.radio.persistence;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
import de.sb.Copyright;


/**
 * This facade provides operations to calculate SHA-256 hash codes.
 */
@Copyright(year=2017, holders="Sascha Baumeister")
public final class HashTools {

	static private byte[] DEFAULT = sha256HashCode(new byte[0]);


	/**
	 * Returns the quasi-unique SHA-256 hash of the given binary content.
	 * @param content the binary content, or {@code null} for none
	 * @return the corresponding SHA-256 hash code
	 */
	static public byte[] sha256HashCode (final byte[] content) {
		try {
			return content == null ? DEFAULT.clone() : MessageDigest.getInstance("SHA-256").digest(content);
		} catch (final NoSuchAlgorithmException exception) {
			throw new AssertionError(exception);
		}
	}


	/**
	 * Returns the quasi-unique SHA-256 hash of the given binary content.
	 * @param content the binary content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding SHA-256 hash code
	 */
	static public String sha256HashText (final byte[] content) {
		return DatatypeConverter.printHexBinary(sha256HashCode(content)).toLowerCase();
	}


	/**
	 * Returns the quasi-unique SHA-256 hash of the given textual context.
	 * @param content the textual content, or {@code null} for none
	 * @return the corresponding SHA-256 hash code
	 */
	static public byte[] sha256HashCode (final String content) {
		return sha256HashCode(content == null ? null : content.getBytes(StandardCharsets.UTF_8));
	}


	/**
	 * Returns the quasi-unique SHA-256 hash of the given textual content.
	 * @param content the textual content, or {@code null} for none
	 * @return the hexadecimal text representation of the corresponding SHA-256 hash code
	 */
	static public String sha256HashText (final String content) {
		return DatatypeConverter.printHexBinary(sha256HashCode(content)).toLowerCase();
	}


	/**
	 * Prevents external instantiation.
	 */
	private HashTools () {}
}