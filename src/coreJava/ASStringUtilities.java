package coreJava;
//package CoreJava;
//
//import java.lang.Character.UnicodeBlock;
//import java.lang.reflect.Proxy;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.logging.Logger;
//import java.util.regex.Pattern;
//import java.util.regex.PatternSyntaxException;
//
//import javax.xml.transform.Transformer;
//
//public class ASStringUtilities extends Object {
//
//	 	/**
//	 * 
//	 * Default delimiter for composite keys created with
//	 * {@link #buildDelimitedString(String[])} is
//	 * 
//	 * set to the pipe character: "|".
//	 */
//
//	public static final String COMPOSITE_KEY_DELIMITER_DEFAULT = "|";
//
//	private static final char[] LEGAL_ATOM_CHARACTERS = legalAtomChars();
//
//	private static final char[] LEGAL_DS_ATOM_CHARACTERS = legalDSAtomChars();
//
//	/**
//	 * 
//	 * Prefix padding for hexadecimal numbers to HEX_LENGTH.
//	 */
//
//	private static final Map<Integer, String> HEX_PADDING = new ConcurrentHashMap<Integer, String>();
//
//	/**
//	 * 
//	 * Hexadecimal prefix for printing "pointers".
//	 */
//
//	public static final String HEX_PREFIX = "0x";
//
//	public static final int HEX_LENGTH = 8;
//
//	/**
//	 * 
//	 * Empty string, length 0.
//	 */
//
//	public static final String EMPTY_STRING = "";
//
//	/**
//	 * 
//	 *
//	 * 
//	 * Represents a single level of indentation for use by
//	 * <CODE>getDepthString(int)</CODE>.
//	 * 
//	 *
//	 */
//
//	public static final String SINGLE_LEVEL_DEPTH_STRING = "   ";
//
//	/**
//	 * 
//	 *
//	 * 
//	 * Represents a single level of indentation for use by
//	 * <CODE>getPaddingString(int)</CODE>.
//	 * 
//	 *
//	 */
//
//	public static final String SINGLE_LEVEL_PADDING_STRING = " ";
//
//	/**
//	 * 
//	 *
//	 * 
//	 * Returned by <CODE>getUniqueDescriptor()</CODE> when the object is
//	 * <CODE>null</CODE>.
//	 * 
//	 *
//	 */
//
//	public static final String NULL_OBJECT_STRING = "<null>";
//
//	/**
//	 * 
//	 * Regex used to strip html from strings. It does matching of both tags and
//	 * entities.
//	 */
//
//	// note that &; is not an entity, but &a; is. hence the + on the entity
//
//	// match instead of *. &#1234; is a numeric entity, and should also be
//	// stripped.
//
//	private static final Pattern htmlStripPattern = Pattern
//			.compile("<[^>]*?>|&#??[A-Za-z0-9]+;");
//
//	// there are many situations where we do not want to strip character
//
//	// entities, maybe this should be the default?
//
//	private static final Pattern htmlStripPatternKeepEntities = Pattern
//			.compile("<[^>]*?>");
//
//	// there are some situations we only want to strip entities
//
//	private static final Pattern htmlStripPatternOnlyEntities = Pattern
//			.compile("&#??[A-Za-z0-9]+;");
//
//	// there are other situations where browsers render incomplete HTML like
//	// "<a onclick='alert(1)'"
//
//	// (note that the tag is not closed); in this cases we also want to remove
//	// the '<'
//
//	// for simplicity the regex catches any '<' followed by any letter (<img,
//	// <a, <html, etc)
//
//	private static final Pattern stripHtmlAndTagStartPattern = Pattern
//			.compile(htmlStripPattern.pattern() + "|<++(?=[a-zA-Z])");
//
//	private static char[] legalAtomChars() {
//
//		final char[] temp = "!#$%&'*+-./0123456789=?ABCDEFGHIJKLMNOPQRSTUVWXYZ^_`abcdefghijklmnopqrstuvwxyz{|}~"
//				.toCharArray();
//
//		Arrays.sort(temp);
//
//		return temp;
//
//	}
//
//	private static char[] legalDSAtomChars() {
//
//		final char[] temp = "+-.0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz"
//				.toCharArray();
//
//		Arrays.sort(temp);
//
//		return temp;
//
//	}
//
//	/**
//	 * 
//	 * Checks to see if the string represents a valid email address per RFC 822.
//	 * Implemented in a
//	 * 
//	 * similar manner as isValidEmailAddress from FoundationExtrasX.
//	 * 
//	 *
//	 * 
//	 * @param value
//	 * 
//	 * @return true if the string is a valid email address
//	 */
//
//	public static boolean isValidEmailAddress(final String value) {
//
//		return isValidEmailAddress(value, LEGAL_ATOM_CHARACTERS);
//
//	}
//
//	/**
//	 * 
//	 * Checks to see if the string represents a valid email address per DS Email
//	 * Standard
//	 * 
//	 *
//	 * 
//	 * @param value
//	 * 
//	 * @return true if the string is a valid DS email address
//	 */
//
//	public static boolean isValidDSEmailAddress(final String value) {
//
//		return isValidEmailAddress(value, LEGAL_DS_ATOM_CHARACTERS);
//
//	}
//
//	public static boolean isValidEmailAddress(final String value,
//			final char[] legalCharacters) {
//
//		boolean isValid = false;
//
//		if (value != null) {
//
//			String local, domain;
//
//			String[] components = value.split("@");
//
//			if (components.length == 2) {
//
//				local = components[0];
//
//				domain = components[1];
//
//				if ((local.length() > 0) && (domain.length() > 0)) {
//
//					components = domain.split("\\.");
//
//					if (components.length > 1) {
//
//						int i;
//
//						isValid = true;
//
//						for (i = 0; i < components.length; i++) {
//
//							if (components[i].length() == 0) {
//
//								isValid = false;
//
//								break;
//
//							}
//
//						}
//
//						if (isValid) {
//
//							components = value.split("\\!");
//
//							for (i = 0; i < components.length; i++) {
//
//								if (components[i].length() == 0) {
//
//									isValid = false;
//
//									break;
//
//								}
//
//							}
//
//							if (isValid) {
//
//								// At this point we know we have
//
//								// 1) Only 1 @ in the address
//
//								// 2) A domain with at least 1 . in it
//
//								// 3) A domain that contains no zero length bits
//
//								// between .
//
//								// 4) An email address that contains no zero
//
//								// length bits between !
//
//								// Now we make sure the local and domain contain
//
//								// no specials
//
//								// see http://www.ietf.org/rfc/rfc822.txt
//
//								/*
//								 * 
//								 * Syntax rules for e-mail addresses (RFC 822)
//								 * 
//								 * 
//								 * 
//								 * address = mailbox mailbox = addr-spec /
//								 * phrase route-addr
//								 * 
//								 * 
//								 * 
//								 * addr-spec = local-part "@" domain local-part
//								 * = word("." word)
//								 * 
//								 * domain = sub-domain("." sub-domain)
//								 * sub-domain = domain-ref /
//								 * 
//								 * domain-literal domain-ref = atom
//								 * domain-literal = "["(dtext /
//								 * 
//								 * quoted-pair) "]"
//								 * 
//								 * 
//								 * 
//								 * phrase = 1word route-addr = "<" [route]
//								 * addr-spec ">" route =
//								 * 
//								 * 1#("@" domain) ":"
//								 * 
//								 * 
//								 * 
//								 * word = atom / quoted-string atom = 1<any CHAR
//								 * except specials,
//								 * 
//								 * SPACE and CTLs>
//								 * 
//								 * 
//								 * 
//								 * CHAR = <any ASCII character> SPACE = <ASCII
//								 * SP, space> CTL = <any
//								 * 
//								 * ASCII control character and DEL> specials =
//								 * "(" / ")" / "<" / ">"
//								 * 
//								 * / "@" / "," / ";" / ":" / "\" / <"> / "." /
//								 * "[" / "]"
//								 * 
//								 * 
//								 * 
//								 * quoted-pair =
//								 * "\" CHAR quoted-string = <">(qtext /
//								 * quoted-pair)
//								 * 
//								 * <"> dtext = <any CHAR excluding "[", "]", "\"
//								 * & CR, & including
//								 * 
//								 * linear-white-space> qtext = <any CHAR
//								 * excepting <">, "\" & CR,
//								 * 
//								 * and including linear-white-space> CR = <ASCII
//								 * CR, carriage
//								 * 
//								 * return>
//								 */
//
//								char[] chars = local.toCharArray();
//
//								for (i = 0; i < chars.length; i++) {
//
//									if (Arrays.binarySearch(legalCharacters,
//											chars[i]) < 0) {
//
//										isValid = false;
//
//										break;
//
//									}
//
//								}
//
//								if (local.endsWith(".") || domain.endsWith(".")
//										|| local.contains("..")) {
//
//									isValid = false;
//
//								}
//
//								if (isValid) {
//
//									chars = domain.toCharArray();
//
//									for (i = 0; i < chars.length; i++) {
//
//										if (Arrays.binarySearch(
//												legalCharacters, chars[i]) < 0) {
//
//											isValid = false;
//
//											break;
//
//										}
//
//									}
//
//								}
//
//							}
//
//						}
//
//					}
//
//				}
//
//			}
//
//		}
//
//		return isValid;
//
//	}
//
//	/**
//	 * 
//	 * Checks to see if all the characters in a string are in Katakana
//	 * 
//	 *
//	 * 
//	 * @param value
//	 * 
//	 * @return true if the string is completely katakana characters
//	 */
//
//	public static boolean isStringKatakana(final String value) {
//
//		boolean isKatakana = true;
//
//		if ((value != null) && (value.length() > 0)) {
//
//			final char[] characters = value.toCharArray();
//
//			int i, j;
//
//			char aChar;
//
//			for (i = 0, j = characters.length; i < j; i++) {
//
//				aChar = characters[i];
//
//				if (!UnicodeBlock.of(aChar).equals(UnicodeBlock.KATAKANA)) {
//
//					isKatakana = false;
//
//					break;
//
//				}
//
//			}
//
//		}
//
//		return isKatakana;
//
//	}
//
//	/**
//	 * 
//	 * Checks to see if all the characters in the string are numeric
//	 * 
//	 *
//	 * 
//	 * @param value
//	 * 
//	 * @return true if the string is all numerals
//	 */
//
//	public static boolean isStringNumeral(final String value) {
//
//		if ((value == null) || (value.length() == 0)) {
//
//			return false;
//
//		}
//
//		boolean isNumeral = true;
//
//		if (value.length() > 0) {
//
//			final char[] characters = value.toCharArray();
//
//			int i, j;
//
//			char aChar;
//
//			for (i = 0, j = characters.length; i < j; i++) {
//
//				aChar = characters[i];
//
//				if ((aChar < '0') || (aChar > '9')) {
//
//					isNumeral = false;
//
//					break;
//
//				}
//
//			}
//
//		}
//
//		return isNumeral;
//
//	}
//
//	/**
//	 * 
//	 * Performs a Mod10 check on the string
//	 * 
//	 *
//	 * 
//	 * @param number
//	 * 
//	 * @return true if the string is a valid credit card number
//	 */
//
//	public static boolean isStringValidMod10CreditCardNumber(final String number) {
//
//		final int zeroOffset = '0';
//
//		int sum = 0;
//
//		int i, j;
//
//		for (i = 1, j = number.length(); i <= j; i++) {
//
//			int digit = number.charAt(j - i) - zeroOffset;
//
//			if ((i % 2) == 0) // even
//
//			{
//
//				digit *= 2;
//
//				if (digit > 9) {
//
//					digit -= 9;
//
//				}
//
//			}
//
//			sum += digit;
//
//		}
//
//		if ((sum % 10) != 0) {
//
//			return false;
//
//		}
//
//		return true;
//
//	}
//
//	/**
//	 * 
//	 * Add the given prefix to each line of the string. The "line" after the
//	 * last "\n" gets a prefix
//	 * 
//	 * if and only if it is nonempty.
//	 * 
//	 *
//	 * 
//	 * @param prefix
//	 *            Prefix to append
//	 * 
//	 * @param string
//	 *            String containing zero or more lines
//	 */
//
//	public static String addPrefixToLines(final String prefix, String string) {
//
//		if ((string == null) || "".equals(string)) {
//
//			return "";
//
//		}
//
//		final boolean finalNewline = string.endsWith("\n");
//
//		if (finalNewline) {
//
//			string = string.substring(0, string.length() - 1);
//
//		}
//
//		string = string.replaceAll("\n", "\n" + prefix);
//
//		string = prefix + string;
//
//		if (finalNewline) {
//
//			string = string + "\n";
//
//		}
//
//		return string;
//
//	}
//
//	/**
//	 * 
//	 * Returns true if the given string is either null or zero length.
//	 * 
//	 *
//	 * 
//	 * @param str
//	 * 
//	 * @return
//	 */
//
//	public static boolean isNullOrEmpty(final String str) {
//
//		return isNullOrEmpty(str, false);
//
//	}
//
//	/**
//	 * 
//	 * Returns true if the string given is null or empty. If the trimmed flag is
//	 * given the string
//	 * 
//	 * will be trimmed of whitespace before an empty comparison, so that strings
//	 * consisting of all
//	 * 
//	 * whitespace are effectively empty.
//	 * 
//	 *
//	 * 
//	 * @param str
//	 * 
//	 * @param trimmed
//	 * 
//	 * @return
//	 */
//
//	public static boolean isNullOrEmpty(final String str, final boolean trimmed) {
//
//		return (str == null) || ((trimmed ? str.trim() : str).length() == 0);
//
//	}
//
//	public static boolean isNotNullOrEmpty(final String str) {
//
//		return !isNullOrEmpty(str, false);
//
//	}
//
//	public static boolean isNotNullOrEmpty(final String str,
//			final boolean trimmed) {
//
//		return !isNullOrEmpty(str, trimmed);
//
//	}
//
//	/**
//	 * 
//	 * Constructs a String from an array of elements by appending them, in
//	 * order, with a default
//	 * 
//	 * delimiter ( {@link #COMPOSITE_KEY_DELIMITER_DEFAULT}) between each; this
//	 * is useful for, among
//	 * 
//	 * other things, constructing cache keys.
//	 * 
//	 *
//	 * 
//	 * @param keyElements
//	 * 
//	 * @return the composite key
//	 */
//
//	public static String buildDelimitedString(final String[] keyElements) {
//
//		return buildDelimitedString(keyElements,
//				COMPOSITE_KEY_DELIMITER_DEFAULT);
//
//	}
//
//	/**
//	 * 
//	 * Constructs a String from an array of elements by appending them, in
//	 * order, with a specified
//	 * 
//	 * delimiter between each; this is useful for, among other things,
//	 * constructing cache keys.
//	 * 
//	 *
//	 * 
//	 * @param keyElements
//	 * 
//	 * @param delimiter
//	 *            used after each key element except the last; if null, then
//	 * 
//	 *            {@link #COMPOSITE_KEY_DELIMITER_DEFAULT} is used.
//	 * 
//	 * @return the composite key
//	 */
//
//	public static String buildDelimitedString(final String[] keyElements,
//			String delimiter) {
//
//		if (delimiter == null) {
//
//			delimiter = COMPOSITE_KEY_DELIMITER_DEFAULT;
//
//		}
//
//		final StringBuilder buf = new StringBuilder();
//
//		for (int i = 0; i < keyElements.length; i++) {
//
//			buf.append(keyElements[i]);
//
//			if (i < (keyElements.length - 1)) {
//
//				buf.append(delimiter);
//
//			}
//
//		}
//
//		return buf.toString();
//
//	}
//
//	public static String buildDelimitedString(
//			Collection<? extends Object> keyElements, String delimiter,
//
//			Transformer transform) {
//
//		if (keyElements == null) {
//
//			keyElements = Collections.emptyList();
//
//		}
//
//		if (delimiter == null) {
//
//			delimiter = COMPOSITE_KEY_DELIMITER_DEFAULT;
//
//		}
//
//		if (transform == null) {
//
// 
//		}
//
//		final StringBuilder buf = new StringBuilder();
//
//		for (final Iterator<? extends Object> iterator = keyElements.iterator(); iterator
//				.hasNext();) {
//
//			final Object obj = transform.transformObject(iterator.next());
//
//			buf.append(String.valueOf(obj));
//
//			if (iterator.hasNext()) {
//
//				buf.append(delimiter);
//
//			}
//
//		}
//
//		return buf.toString();
//
//	}
//
//	public static String buildDelimitedString(
//			final Collection<? extends Object> keyElements,
//			final String delimiter) {
//
//		return buildDelimitedString(keyElements, delimiter,
//				new NullTransformer());
//
//	}
//
//	/**
//	 * 
//	 * Brute force method that strips html tags and entities from a string.
//	 * 
//	 *
//	 * 
//	 * @see #stripHTML(String, boolean)
//	 * 
//	 *x
//	 * 
//	 * @param theString
//	 * 
//	 * @return
//	 */
//
//	public static String stripHTML(final String theString) {
//
//		return stripHTML(theString, false);
//
//	}
//
///**
//
//     * Brute force method that strips html tags and entities from a string and also removes remaining '<'
//
//     * characters that can be the start of a malformed html tag. This is needed because malformed html like this:
//
//     * <code><a onclick="alert(1)"</code> is not removed by calling stripHTML but it's rendered by some browsers
//
//     * (like Firefox). 
//
//     *
//
//     * @see #stripHTML(String, boolean)
//
//     *
//
//     * @param theString
//
//     * @return
//
//     */
//
//	public static String stripHTMLAndMalformedHTML(final String theString) {
//
//		if (theString == null) {
//
//			return null;
//
//		}
//
//		return stripHtmlAndTagStartPattern.matcher(theString).replaceAll("");
//
//	}
//
//	/**
//	 * 
//	 * Brute force method that strips html tags and, optionally, entities from a
//	 * string. Entities
//	 * 
//	 * will be preserved unless <code>preserveCharacterEntites</code> is set to
//	 * false. Entities are
//	 * 
//	 * not checked against a table of valid entities, instead, anything with a
//	 * &[characters]; match
//	 * 
//	 * is assumed to be an entity. Also, anything resembling a tag is stripped,
//	 * but not data outside
//	 * 
//	 * the tag.
//	 * 
//	 * <p>
//	 * 
//	 * <strong>Example:</strong>
//	 * 
//	 * <p>
//	 * 
//	 * <code>
//	 * &lt;a href="url"&gt;&lt;img src="foo"&gt;text here&lt;/a&gt;
//	 * </code> This is not technically balanced, but we expect the strip method
//	 * to return just
//	 * 
//	 * "text" in this case. Ditto for nonstandard entities like
//	 * <code>&kthxbye;</code>, we try our
//	 * 
//	 * hardest to strip them when not preserving character entities.
//	 * 
//	 *
//	 * 
//	 * @param theString
//	 * 
//	 * @param preserveCharacterEntites
//	 *            if true character entities will not be stripped
//	 * 
//	 * @return
//	 */
//
//	public static String stripHTML(final String theString,
//			final boolean preserveCharacterEntites) {
//
//		final Pattern pattern = (preserveCharacterEntites ? htmlStripPatternKeepEntities
//				: htmlStripPattern);
//
//		return pattern.matcher(theString).replaceAll("");
//
//	}
//
//	/**
//	 * 
//	 * Brute force method that strips html entity declarations from a string.
//	 * *lt; characters and
//	 * 
//	 * tags are not touched.
//	 * 
//	 *
//	 * 
//	 * @param theString
//	 * 
//	 * @return
//	 */
//
//	public static String stripHTMLEntities(final String theString) {
//
//		return htmlStripPatternOnlyEntities.matcher(theString).replaceAll("");
//
//	}
//
//	public static String stringByAppendingEllipsis(final String theString) {
//
//		String suffix = "";
//
//		if (theString.endsWith(".")) {
//
//			if (theString.endsWith("..")) {
//
//				if (!theString.endsWith("...")) {
//
//					suffix = ".";
//
//				}
//
//			} else {
//
//				suffix = "..";
//
//			}
//
//		} else {
//
//			suffix = "...";
//
//		}
//
//		return theString + suffix;
//
//	}
//
//	/**
//	 * 
//	 * Append the specified ellipsis to the end of the string. If the string
//	 * already ends with a
//	 * 
//	 * recognised ellipsis (or substring thereof) it will first have the
//	 * ellipsis stripped off.
//	 * 
//	 *
//	 * 
//	 * @param theString
//	 *            The string to have the ellipsis added
//	 * 
//	 * @param ellipsis
//	 *            The ellipsis string to use (e.g. "...", "\u2026", "&hellip;")
//	 * 
//	 * @return
//	 */
//
//	public static String stringByAppendingEllipsis(final String theString,
//			final String ellipsis) {
//
//		String prefix = theString;
//
//		final String suffix = (ellipsis == null) ? "..." : ellipsis;
//
//		final int length = theString.length();
//
//		if (theString.endsWith("\u2026")) {
//
//			prefix = theString.substring(0, length - 1);
//
//		} else if (theString.endsWith("&hellip;")) {
//
//			prefix = theString.substring(0, length - 8);
//
//		} else if (theString.endsWith("...")) {
//
//			prefix = theString.substring(0, length - 3);
//
//		} else if (theString.endsWith("..")) {
//
//			prefix = theString.substring(0, length - 2);
//
//		} else if (theString.endsWith(".")) {
//
//			prefix = theString.substring(0, length - 1);
//
//		}
//
//		return prefix + suffix;
//
//	}
//
//	/**
//	 * 
//	 * Truncates a String at a word boundary (detected via
//	 * java.lang.Character.isWhitespace()). If
//	 * 
//	 * there is no whitespace, or the length arg is 0, the String will not be
//	 * truncated. Example:
//	 * 
//	 * "This is a test" truncated to length 11 will return "This is a".
//	 * 
//	 *
//	 * 
//	 * @param theString
//	 * 
//	 * @param length
//	 * 
//	 * @return the truncated String
//	 */
//
//	public static String truncateStringToNearestWordBoundaryWithLength(
//			final String theString, final int length) {
//
//		int newEnd = 0;
//
//		char[] chars;
//
//		// sanity check
//
//		if ((length > 0) && (length >= theString.length())) {
//
//			return theString;
//
//		}
//
//		/*
//		 * 
//		 * Check theString at length. If it's whitespace, we might truncate
//		 * theString here. if
//		 * 
//		 * (Character.isWhitespace(theString.charAt(length))) { newEnd = length;
//		 * } else { inWord =
//		 * 
//		 * true; }
//		 */
//
//		chars = theString.toCharArray();
//
//		// if we're in a word, walk back until we hit a whitespace char.
//
//		// if (inWord) {
//
//		for (int i = length; i >= 0; i--) {
//
//			final char c = chars[i];
//
//			if (Character.isWhitespace(c)) {
//
//				newEnd = i;
//
//				break;
//
//			}
//
//		}
//
//		// }
//
//		// Walk back from where we found whitespace until we hit a
//
//		// non-whitespace char
//
//		// (prevents trailing whitespace, detects strings that have all
//
//		// whitespace up front).
//
//		for (; newEnd >= 0; newEnd--) {
//
//			final char c = chars[newEnd];
//
//			if (!Character.isWhitespace(c)) {
//
//				newEnd++;
//
//				break;
//
//			}
//
//		}
//
//		// If we don't find any whitespace, we can't truncate, return theString.
//
//		if (newEnd == 0) {
//
//			return theString;
//
//		} else {
//
//			return theString.substring(0, newEnd);
//
//		}
//
//	}
//
//	/**
//	 * 
//	 * Truncates a String at a word boundary (detected via {@link
//	 * 
//	 * java.lang.Character.isWhitespace()}). If there is no whitespace, or the
//	 * length arg is 0, or
//	 * 
//	 * the length asked for is >= the size of the string the String will not be
//	 * truncated. We will
//	 * 
//	 * only truncate at the end of a word. If no word has completed before we
//	 * have hit the maximum
//	 * 
//	 * length then the original string is returned even if the string started
//	 * with whitespace.
//	 * 
//	 * <p>
//	 * 
//	 * Here are the rules this method will follow.
//	 * 
//	 * <ol>
//	 * 
//	 * <li>Leading spaces are not counted.</li>
//	 * 
//	 * <li>Character entities are treated as a single character, e.g.
//	 * {@code &amp;} counts as one
//	 * 
//	 * character.</li>
//	 * 
//	 * <li>Numeric entities are treated as single character, e.g.
//	 * {@code &#8226;} counts as one
//	 * 
//	 * character.</li>
//	 * 
//	 * <li>Consecutive white space adds up to only one character, e.g. these
//	 * four whitespace
//	 * 
//	 * characters {@code "    "} only count as one character.</li>
//	 * 
//	 * </ol>
//	 * 
//	 * <p>
//	 * 
//	 * <img src="doc-files/truncate-html-word-boundary.png">
//	 * 
//	 * <p>
//	 * 
//	 * <strong>Example:</strong>
//	 * 
//	 *
//	 * 
//	 * {@code "     This is a point &amp; shoot game"} truncated to length 23
//	 * will return {@code
//
//	 * "     This is a point &amp; shoot"}.
//	 * 
//	 *
//	 * 
//	 * @param theString
//	 *            the string
//	 * 
//	 * @param length
//	 *            the length of the string
//	 * 
//	 * @return the truncated String
//	 */
//
//	public static String truncateHTMLStringToNearestWordBoundaryWithLength(
//			final String string, final int length) {
//
//		// sanity check
//
//		if ((length > 0) && (length >= string.length())) {
//
//			return string;
//
//		}
//
//		final int numChars = string.length();
//
//		// current length
//
//		int current = 0;
//
//		// end position of last word
//
//		int lastWordIndex = 0;
//
//		int i = 0;
//
//		// count leading white space for length but do not set lastWordIndex
//
//		if (Character.isWhitespace(string.charAt(i))) {
//
//			current++;
//
//			i++;
//
//		}
//
//		// consume extra spaces
//
//		while ((i < numChars) && Character.isWhitespace(string.charAt(i))) {
//
//			i++;
//
//		}
//
//		chars: while (i < numChars) {
//
//			final char c = string.charAt(i++);
//
//			if (c == '&') {
//
//				// consume entity
//
//				int entityLength = 1;
//
//				if (i < numChars) {
//
//					// --- detect NUMERIC ENTITIES vs. CHARACTER ENTITIES
//
//					final boolean isNumericEntity = ('#' == string.charAt(i));
//
//					if (isNumericEntity) {
//
//						// consume the hash mark
//
//						i++;
//
//						// advance counter
//
//						entityLength++;
//
//					}
//
//					while (i < numChars) {
//
//						final char e = string.charAt(i++);
//
//						entityLength++;
//
//						if (((e >= '0') && (e <= '9'))
//								||
//
//								(!isNumericEntity && (((e >= 'a') && (e <= 'z')) || ((e >= 'A') && (e <= 'Z'))))) {
//
//							// an entity character
//
//						} else if (e == ';') {
//
//							/*
//							 * 
//							 * end of entity, count as one character, resume
//							 * chars state
//							 */
//
//							current++;
//
//							continue chars;
//
//						} else {
//
//							// not a valid entity so treat it as a word
//
//							current += entityLength - 1;
//
//							/*
//							 * 
//							 * epsilon -- don't advance counter (backup due to
//							 * charAt(i++) above)
//							 */
//
//							i--;
//
//							continue chars;
//
//						}
//
//					}
//
//				}
//
//				if (current > length) {
//
//					// ran past the maximum length, done searching
//
//					break;
//
//				}
//
//				/*
//				 * 
//				 * hit end of string without seeing ';', not sure where the
//				 * entity ended, so treat
//				 * 
//				 * it as a bunch of characters
//				 */
//
//				current += entityLength;
//
//				if ((i >= numChars) && (current <= length)) {
//
//					// If at the end of the string and have not exceeded the
//
//					// maximum then this is the end of the word
//
//					lastWordIndex = i;
//
//				}
//
//			} else if (Character.isWhitespace(c)) {
//
//				// end of a word
//
//				if (current > length) {
//
//					// ran past the maximum length, done searching
//
//					break;
//
//				}
//
//				/*
//				 * 
//				 * Keep track of the end of this word: known to be < length.
//				 * Note we subtract 1
//				 * 
//				 * because we had already advanced the counter when we go the
//				 * current character.
//				 */
//
//				lastWordIndex = (i - 1);
//
//				current++;
//
//				// consume extra spaces
//
//				while ((i < numChars)
//						&& Character.isWhitespace(string.charAt(i))) {
//
//					i++;
//
//				}
//
//			} else {
//
//				// word characters
//
//				if (current > length) {
//
//					// ran past the maximum length, done searching
//
//					break;
//
//				}
//
//				current++;
//
//				if ((i >= numChars) && (current <= length)) {
//
//					// If at the end of the string and have not exceeded the
//
//					// maximum then this is the end of the word
//
//					lastWordIndex = i;
//
//				}
//
//			}
//
//		}
//
//		if (current < length) {
//
//			// we like the whole thing
//
//			return string;
//
//		} else if (lastWordIndex == 0) {
//
//			// a single word
//
//			return string;
//
//		} else {
//
//			// take the last known good word
//
//			return string.substring(0, lastWordIndex);
//
//		}
//
//	}
//
//	/**
//	 * 
//	 * Truncate an html string to a specified length. First strips out all the
//	 * HTML in the string
//	 * 
//	 * using stripHTML(), then attempts to trim down to length. Can specify
//	 * whether to truncate at
//	 * 
//	 * word boundaries and append trailing ellipsis.
//	 * 
//	 *
//	 * 
//	 * @param htmlString
//	 *            the original string
//	 * 
//	 * @param length
//	 *            length to truncate to
//	 * 
//	 * @param useWordBoundary
//	 *            boolean indicating whether to truncate only at word boundaries
//	 * 
//	 * @param appendEllipsis
//	 *            boolean indicating whether to append ellipsis.
//	 * 
//	 * @return the truncated string
//	 */
//
//	public static String truncateHTMLStringToLength(final String htmlString,
//			final int length,
//
//			final boolean useWordBoundary, final boolean appendEllipsis) {
//
//		return truncateHTMLStringToLength(htmlString, length,
//
//		useWordBoundary,
//
//		(appendEllipsis ? "..." : null));
//
//	}
//
//	/**
//	 * 
//	 * Truncate an html string to a specified length. First strips out all the
//	 * HTML in the string
//	 * 
//	 * using stripHTML(), then attempts to trim down to length. Can specify
//	 * whether to truncate at
//	 * 
//	 * word boundaries and append trailing ellipsis.
//	 * 
//	 * 
//	 * 
//	 * @param htmlString
//	 *            the original string
//	 * 
//	 * @param length
//	 *            length to truncate to
//	 * 
//	 * @param useWordBoundary
//	 *            boolean indicating whether to truncate only at word boundaries
//	 * 
//	 * @param appendEllipsis
//	 *            boolean indicating whether to append ellipsis.
//	 * 
//	 * @param ellipsis
//	 *            The ellipsis string to use. If null, then no ellipsis will be
//	 *            appended
//	 * 
//	 * @return the truncated string
//	 */
//
//	public static String truncateHTMLStringToLength(final String htmlString,
//			final int length,
//
//			final boolean useWordBoundary, final String ellipsis) {
//
//		String result = htmlString;
//
//		if ((result != null) && (length > 0) && (result.length() > length)) {
//
//			result = ASStringUtilities.stripHTML(result, true);
//
//			if (result.length() > length) {
//
//				if (useWordBoundary) {
//
//					result = ASStringUtilities
//							.truncateHTMLStringToNearestWordBoundaryWithLength(
//									result, length);
//
//				} else {
//
//					result = result.substring(0, length);
//
//				}
//
//				if (ellipsis != null) {
//
//					result = ASStringUtilities.stringByAppendingEllipsis(
//							result, ellipsis);
//
//				}
//
//			}
//
//		}
//
//		return result;
//
//	}
//
//	/**
//	 * 
//	 * Truncate an html string to a specified length. First strips out all the
//	 * HTML in the string
//	 * 
//	 * using stripHTML(), then attempts to trim down to length. Can specify
//	 * whether to truncate at
//	 * 
//	 * word boundaries. Appends trailing ellipsis.
//	 * 
//	 *
//	 * 
//	 * @param htmlString
//	 *            the original string
//	 * 
//	 * @param length
//	 *            length to truncate to
//	 * 
//	 * @param useWordBoundary
//	 *            boolean indicating whether to truncate only at word boundaries
//	 * 
//	 * @return the truncated string with a trailing ellipsis
//	 */
//
//	public static String truncateHTMLStringToLength(final String htmlString,
//			final int length,
//
//			final boolean useWordBoundary) {
//
//		return truncateHTMLStringToLength(htmlString, length, useWordBoundary,
//				"...");
//
//	}
//
//	/**
//	 * 
//	 * Removes double spaces and trims pre and post white space from the given
//	 * string.
//	 * 
//	 *
//	 * 
//	 * @param input
//	 *            the original string
//	 * 
//	 * @return the string with extra whitespace removed
//	 */
//
//	public static String removeExtraWhitespace(final String input) {
//
//		if (input == null) {
//
//			return null;
//
//		}
//
//		final String inputString = input.trim();
//
//		final StringBuilder output = new StringBuilder();
//
//		boolean updateNextChar = false;
//
//		for (int i = 0; i < inputString.length(); i++) {
//
//			if (updateNextChar && Character.isWhitespace(inputString.charAt(i))) {
//
//				updateNextChar = true;
//
//			} else if (Character.isWhitespace(inputString.charAt(i))) {
//
//				updateNextChar = true;
//
//				output.append(inputString.charAt(i));
//
//			} else {
//
//				updateNextChar = false;
//
//				output.append(inputString.charAt(i));
//
//			}
//
//		}
//
//		return output.toString();
//
//	}
//
//	/**
//	 * 
//	 * @param input
//	 *            a String containing multiple words separated by different
//	 *            delimiters that are to
//	 * 
//	 *            be removed.
//	 * 
//	 * @param delimiterRegex
//	 *            a String containing the pattern by which to split the input
//	 *            string
//	 * 
//	 *            words.
//	 * 
//	 * @return Lower-camel-case String. Examples:
//	 * 
//	 *
//	 * 
//	 *         <pre>
//	 * 
//	 * toLowerCamelCase(&quot;foo bar&quot;, &quot;\\s&quot;).equals(&quot;fooBar&quot;);
//	 * 
//	 * toLowerCamelCase(&quot;one-click&quot;, &quot;-&quot;).equals(&quot;oneClick&quot;);
//	 * 
//	 * toLowerCamelCase(&quot;one-click is cool&quot;, &quot;\\s|-&quot;).equals(&quot;oneClickIsCool&quot;);
//	 * 
//	 * </pre>
//	 */
//
//	public static String toLowerCamelCase(final String input,
//			final String delimiterRegex) {
//
//		if (input == null) {
//
//			return null;
//
//		}
//
//		final StringBuilder output = new StringBuilder();
//
//		final String[] subcomponents = input.split(delimiterRegex);
//
//		if (subcomponents.length > 0) {
//
//			if (subcomponents[0].length() > 1) {
//
//				output.append(subcomponents[0].substring(0, 1).toLowerCase());
//
//				output.append(subcomponents[0].substring(1));
//
//			} else {
//
//				output.append(subcomponents[0].toLowerCase());
//
//			}
//
//		}
//
//		for (int i = 1; i < subcomponents.length; i++) {
//
//			if (subcomponents[i].length() > 1) {
//
//				output.append(subcomponents[i].substring(0, 1).toUpperCase());
//
//				output.append(subcomponents[i].substring(1));
//
//			} else {
//
//				output.append(subcomponents[i].toUpperCase());
//
//			}
//
//		}
//
//		return output.toString();
//
//	}
//
//	/**
//	 * 
//	 * Strips the string of non-javascript identifier characters
//	 * 
//	 *
//	 * 
//	 * @param input
//	 *            the string to check
//	 * 
//	 * @return the string as a valid javascript identifier
//	 */
//
//	public static String getJavascriptIdentifierFromString(final String input) {
//
//		if (input == null) {
//
//			return null;
//
//		}
//
//		final StringBuilder ouput = new StringBuilder();
//
//		final char[] chars = input.toCharArray();
//
//		if ((chars.length > 0) && !Character.isJavaIdentifierStart(chars[0])) {
//
//			ouput.append('_');
//
//		}
//
//		for (final char c : chars) {
//
//			if (Character.isJavaIdentifierPart(c)) {
//
//				ouput.append(c);
//
//			}
//
//		}
//
//		return ouput.toString();
//
//	}
//
//	/**
//	 * 
//	 * Returns the input string with HTML special characters encoded, replacing
//	 * line breaks with the
//	 * 
//	 * given line break string. Can specify the maximum number of consecutive
//	 * line breaks to output.
//	 * 
//	 * A value of -1 for the maximum number of line breaks indicates no maximum
//	 * limit.
//	 * 
//	 *
//	 * 
//	 * @param input
//	 *            the input string to encode
//	 * 
//	 * @param lineBreak
//	 *            the string to replace line breaks
//	 * 
//	 * @param maxLineBreaks
//	 *            the maximum number of consecutive line breaks to replace, any
//	 *            additional
//	 * 
//	 *            line breaks are removed from the encoded string; a value of -1
//	 *            indicates no max
//	 * 
//	 *            limit
//	 * 
//	 * @return the HTML encoded string
//	 */
//
//	public static String encodeHTMLSpecialCharacters(final String input,
//			final String lineBreak, final int maxLineBreaks) {
//
//		return encodeHTMLSpecialCharacters(input, lineBreak, maxLineBreaks,
//				false);
//
//	}
//
//	/**
//	 * 
//	 * Returns the input string with HTML special characters encoded, replacing
//	 * line breaks with the
//	 * 
//	 * given line break string. Can specify the maximum number of consecutive
//	 * line breaks to output.
//	 * 
//	 * A value of -1 for the maximum number of line breaks indicates no maximum
//	 * limit.
//	 * 
//	 *
//	 * 
//	 * @param input
//	 *            the input string to encode
//	 * 
//	 * @param lineBreak
//	 *            the string to replace line breaks
//	 * 
//	 * @param maxLineBreaks
//	 *            the maximum number of consecutive line breaks to replace, any
//	 *            additional
//	 * 
//	 *            line breaks are removed from the encoded string; a value of -1
//	 *            indicates no max
//	 * 
//	 *            limit
//	 * 
//	 * @param stripInvalidXmlCharacters
//	 *            to skip any characters not permitted in an XML document by
//	 * 
//	 *            the XML specification - {@see #isValidXmlCharacter(char)}
//	 * 
//	 * @return the HTML encoded string
//	 */
//
//	public static String encodeHTMLSpecialCharacters(final String input,
//			final String lineBreak,
//
//			final int maxLineBreaks, final boolean stripInvalidXmlCharacters) {
//
//		if (input == null) {
//
//			return null;
//
//		}
//
//		final char[] chars = input.toCharArray();
//
//		final StringBuilder output = new StringBuilder(input.length() * 2);
//
//		int count = 0;
//
//		for (final char c : chars) {
//
//			if (c == '\n') {
//
//				count++;
//
//				// append line break only if there is no max limit or there are
//
//				// less than the maximum number of consecutive line breaks
//
//				if ((maxLineBreaks < 0) || (count <= maxLineBreaks)) {
//
//					output.append(lineBreak);
//
//				}
//
//			} else {
//
//				// reset count for non-line break characters
//
//				count = 0;
//
//				if (stripInvalidXmlCharacters && !isValidXmlCharacter(c)) {
//
//					// ignore this character - it is not allowed in an XML
//					// document, even encoded
//
//				} else if ((c > 127) || (c == '&') || (c == '"') || (c == '<')
//						|| (c == '>')) {
//
//					// HTML encode special characters
//
//					output.append("&#");
//
//					output.append((int) c);
//
//					output.append(";");
//
//				} else {
//
//					output.append(c);
//
//				}
//
//			}
//
//		}
//
//		return output.toString();
//
//	}
//
//	/**
//	 * 
//	 * Convenience wrapper for
//	 * {@link #encodeHTMLSpecialCharacters(String, String, int, boolean)}
//	 * 
//	 * with maxLineBreaks set to -1, i.e. no maximum. {@see
//	 * #encodeHTMLSpecialCharacters(String,
//	 * 
//	 * String, int, boolean)}
//	 */
//
//	public static String encodeHTMLSpecialCharacters(final String input,
//			final String lineBreak,
//
//			final boolean stripInvalidXmlCharacters) {
//
//		return encodeHTMLSpecialCharacters(input, lineBreak, -1,
//				stripInvalidXmlCharacters);
//
//	}
//
//	/**
//	 * 
//	 * http://www.w3.org/TR/1998/REC-xml-19980210#charsets lists the valid XML
//	 * character range, and
//	 * 
//	 * this method lets us recognise them.
//	 * 
//	 *
//	 * 
//	 * <pre>
//	 * 
//	 * Char  ::=    #x9 | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] | [#x10000-#x10FFFF]   /* any Unicode character, excluding the surrogate blocks, FFFE, and FFFF.
//	 * 
//	 * </pre>
//	 * 
//	 *
//	 * 
//	 * We may need to strip those characters from certain strings
//	 * 
//	 *
//	 * 
//	 * @param c
//	 *            the code point to check
//	 * 
//	 * @return true is the character can be included in a valid XML document
//	 */
//
//	public static boolean isValidXmlCharacter(final int c) {
//
//		return ((c == 0x9) || (c == 0xA) || (c == 0xD)
//				|| ((c >= 0x20) && (c <= 0xD7FF)) ||
//
//				((c >= 0xE000) && (c <= 0xFFFD)) || ((c >= 0x10000) && (c <= 0x10FFFF)));
//
//	}
//
//	/**
//	 * 
//	 * Returns the input string with HTML special characters encoded, replacing
//	 * line breaks with the
//	 * 
//	 * given line break string. Has no limit for maximum number of line breaks
//	 * emitted.
//	 * 
//	 *
//	 * 
//	 * @param input
//	 *            the input string to encode
//	 * 
//	 * @param lineBreak
//	 *            the string to replace line breaks
//	 * 
//	 * @return the HTML encoded string
//	 */
//
//	public static String encodeHTMLSpecialCharacters(final String input,
//			final String linebreak) {
//
//		return ASStringUtilities.encodeHTMLSpecialCharacters(input, linebreak,
//				-1, false);
//
//	}
//
//	/**
//	 * 
//	 * Converts text that may include HTML entities such as &amp; or &rsquo;
//	 * into plain text. The
//	 * 
//	 * actual entities converted are specified in the application configuration.
//	 * Note that html
//	 * 
//	 * elements will be treated as text - so will be returned unchanged.
//	 * 
//	 *
//	 * 
//	 * @param input
//	 *            The string that may contain html entities
//	 * 
//	 * @param strict
//	 *            Set to false if unrecognised entities should be returned
//	 *            unmodified. This will
//	 * 
//	 *            also allow bare & characters to appear in the input string. If
//	 *            true, then
//	 * 
//	 *            unrecognised entities and bare & characters in the input will
//	 *            result in an
//	 * 
//	 *            IllegalArgumentException being thrown
//	 * 
//	 * @return The input string, with all html entities converted to their
//	 *         character equivalent.
//	 * 
//	 * @throws IllegalArgumentException
//	 *             If strict decoding is on, and an unrecognised entity (or
//	 * 
//	 *             bare &) is found in the input string.
//	 */
//
//	public static String decodeHTMLEncodedEntities(final String input,
//			final boolean strict)
//
//	throws IllegalArgumentException {
//
//		if (input == null) {
//
//			throw new IllegalArgumentException(
//					"argument 'input' cannot be null");
//
//		}
//
//		final Map<String, String> entityMap = HtmlEntitiesConfigurationFactory
//				.getHtmlEntitiesConfiguration()
//
//				.getEntityMappings();
//
//		final int length = input.length();
//
//		final StringBuilder builder = new StringBuilder(length);
//
//		int currentPos = 0;
//
//		while (currentPos < length) {
//
//			// Not in entity;
//
//			final int ampersandPos = input.indexOf('&', currentPos);
//
//			if (ampersandPos == -1) {
//
//				builder.append(input.substring(currentPos));
//
//				break;
//
//			}
//
//			builder.append(input.subSequence(currentPos, ampersandPos));
//
//			currentPos = ampersandPos;
//
//			// In possible entity - find its end
//
//			int entityCurrentPos = currentPos + 1;
//
//			char c = 0;
//
//			for (; entityCurrentPos < length; entityCurrentPos++) {
//
//				c = input.charAt(entityCurrentPos);
//
//				if ((c == ' ') || (c == ';')) {
//
//					// Increment counter one past the end of the token
//
//					entityCurrentPos++;
//
//					break;
//
//				}
//
//			}
//
//			final String potentialEntity = input.substring(currentPos,
//					entityCurrentPos);
//
//			currentPos = entityCurrentPos;
//
//			if (c == ';') {
//
//				// Might be a valid entity - look it up.
//
//				final String substitute = entityMap.get(potentialEntity);
//
//				if (substitute != null) {
//
//					builder.append(substitute);
//
//					continue;
//
//				}
//
//				// We check the map before checking code points explicitly,
//				// since we might want to
//
//				// override the value
//
//				if (potentialEntity.startsWith("&#")) {
//
//					// A numeric code character entity
//
//					int codepoint = 0;
//
//					if (potentialEntity.startsWith("&#x")) {
//
//						// this is a hexadecimal entity
//
//						codepoint = Integer.parseInt(
//								potentialEntity.substring(3,
//										potentialEntity.length() - 1), 16);
//
//					} else {
//
//						codepoint = Integer.parseInt(potentialEntity.substring(
//								2, potentialEntity.length() - 1));
//
//					}
//
//					if (Character.isValidCodePoint(codepoint)) {
//
//						builder.append(Character.toChars(codepoint));
//
//						continue;
//
//					}
//
//				}
//
//			}
//
//			// We haven't matched a known entity
//
//			if (strict) {
//
//				// We should throw if we don't recognise the entity
//
//				throw new IllegalArgumentException(
//
//						"Found unrecognised or badly formed entity, or bare & while in strict mode, starting at position "
//								+
//
//								currentPos + ": " + potentialEntity);
//
//			}
//
//			// We should append the text anyway on the grounds that we want to
//			// cope with any string.
//
//			builder.append(potentialEntity);
//
//		}
//
//		return builder.toString();
//
//	}
//
//	/**
//	 * 
//	 * Returns the string value of an object or null if the input object is
//	 * null.
//	 * 
//	 *
//	 * 
//	 * @param anObject
//	 * 
//	 * @return
//	 */
//
//	public static String toString(final Object anObject) {
//
//		return toString(anObject, null);
//
//	}
//
//	/**
//	 * 
//	 * Returns the string value of the given object. if the object is null this
//	 * will return the
//	 * 
//	 * defaultValue given.
//	 * 
//	 *
//	 * 
//	 * @param anObject
//	 * 
//	 * @param defaultValue
//	 * 
//	 * @return
//	 */
//
//	public static String toString(final Object anObject,
//			final String defaultValue) {
//
//		return (anObject == null) ? defaultValue : anObject.toString();
//
//	}
//
//	/**
//	 * 
//	 * Returns a "pointer" string in the usual format for these things - 0x<hex
//	 * digits>.
//	 */
//
//	public static String getPointerString(final int num) {
//
//		final StringBuilder result = new StringBuilder();
//
//		final String hex = Integer.toHexString(num);
//
//		String pad;
//
//		final Integer l = Integer.valueOf(hex.length());
//
//		if ((pad = HEX_PADDING.get(l)) == null) {
//
//			final StringBuilder pb = new StringBuilder();
//
//			for (int i = hex.length(); i < HEX_LENGTH; i++) {
//
//				pb.append('0');
//
//			}
//
//			pad = new String(pb);
//
//			HEX_PADDING.put(l, pad);
//
//		}
//
//		result.append(pad);
//
//		result.append(hex);
//
//		return new String(result);
//
//	}
//
//	/**
//	 * 
//	 * Returns a "pointer" string in the usual format for these things - 0x<hex
//	 * digits> for the
//	 * 
//	 * object given. This will always return a unique value for each object.
//	 */
//
//	public static String getPointerString(final Object o) {
//
//		return getPointerString((o == null) ? 0 : System.identityHashCode(o));
//
//	}
//
//	/**
//	 * 
//	 * Returns an indentation string of spaces for indentation to the depth
//	 * given.
//	 */
//
//	public static String getDepthString(final int depth) {
//
//		return getPaddingString(depth, SINGLE_LEVEL_DEPTH_STRING);
//
//	}
//
//	/**
//	 * 
//	 * Returns an padding string of spaces for indentation to the padding amount
//	 * given.
//	 */
//
//	public static String getPaddingString(final int padding) {
//
//		return getPaddingString(padding, SINGLE_LEVEL_PADDING_STRING);
//
//	}
//
//	/**
//	 * 
//	 * Returns a padding string composed of multiple appendings of the given
//	 * singlePadding string.
//	 * 
//	 *
//	 * 
//	 * @param padding
//	 * 
//	 * @param singlePadding
//	 * 
//	 * @return
//	 */
//
//	public static String getPaddingString(final int padding,
//			final String singlePadding) {
//
//		String result;
//
//		if (padding <= 0) {
//
//			result = EMPTY_STRING;
//
//		} else {
//
//			result = generatePaddingString(padding, singlePadding, null)
//					.toString();
//
//		}
//
//		return result;
//
//	}
//
//	/**
//	 * 
//	 * Generates a padding string into the StringBuilder provided. If the buffer
//	 * provided is null
//	 * 
//	 * this will create a StringBuilder.
//	 * 
//	 *
//	 * 
//	 * @param padding
//	 * 
//	 * @param singlePadding
//	 * 
//	 * @param buffer
//	 * 
//	 * @return
//	 */
//
//	public static StringBuilder generatePaddingString(final int padding,
//			final String singlePadding,
//
//			StringBuilder buffer) {
//
//		if (buffer == null) {
//
//			buffer = new StringBuilder();
//
//		}
//
//		for (int i = 0; i < padding; i++) {
//
//			buffer.append(singlePadding);
//
//		}
//
//		return buffer;
//
//	}
//
//	/**
//	 * 
//	 * Returns a unique descriptor string that includes the object's class and a
//	 * unique integer
//	 * 
//	 * identifier. If fullyQualified is true then the class name will be fully
//	 * qualified to include
//	 * 
//	 * the package name, else it will be just the class' base name.
//	 * 
//	 *
//	 */
//
//	public static String getUniqueDescriptor(Object object,
//			final boolean fullyQualified) {
//
//		final StringBuilder result = new StringBuilder();
//
//		if (object != null) {
//
//			if (object instanceof Proxy) {
//
//				final Class<? extends Object> interfaceClass = object
//						.getClass().getInterfaces()[0];
//
//				result.append(getClassName(interfaceClass, fullyQualified));
//
//				result.append('^');
//
//				object = Proxy.getInvocationHandler(object);
//
//			}
//
//			result.append(getClassName(object, fullyQualified));
//
//			result.append('@');
//
//			result.append(getPointerString(object));
//
//		} else {
//
//			result.append(NULL_OBJECT_STRING);
//
//		}
//
//		return new String(result);
//
//	}
//
//	/**
//	 * 
//	 * Returns a unique descriptor string that includes the object's class' base
//	 * name and a unique
//	 * 
//	 * integer identifier.
//	 */
//
//	public static String getUniqueDescriptor(final Object object) {
//
//		return getUniqueDescriptor(object, false);
//
//	}
//
//	/**
//	 * 
//	 * Returns the base name (the class name without the package name prepended)
//	 * of the object
//	 * 
//	 * given.
//	 */
//
//	public static String getBaseName(final Object o) {
//
//		return getClassBaseName(o.getClass());
//
//	}
//
//	/**
//	 * 
//	 * Returns the base name (the class name without the package name prepended)
//	 * of the class given.
//	 */
//
//	public static String getClassBaseName(final Class<? extends Object> c) {
//
//		final String s = c.getName();
//
//		return s.substring(s.lastIndexOf('.') + 1);
//
//	}
//
//	public static String getClassName(Object o, final boolean fullyQualified) {
//
//		if (!(o instanceof Class)) {
//
//			o = o.getClass();
//
//		}
//
//		final Class<?> oAsClass = (Class<?>) o;
//
//		return getClassName(oAsClass, fullyQualified);
//
//	}
//
//	public static String getClassName(final Class<? extends Object> c,
//			final boolean fullyQualified) {
//
//		return fullyQualified ? c.getName() : getClassBaseName(c);
//
//	}
//
//	/**
//	 * 
//	 * Returns the package name of the object's class.
//	 */
//
//	public static String getPackageName(final Object o) {
//
//		return getClassPackageName(o.getClass());
//
//	}
//
//	/**
//	 * 
//	 * Returns the package name of the class given. If the class is in the
//	 * default package this will
//	 * 
//	 * return an empty string.
//	 */
//
//	public static String getClassPackageName(final Class<? extends Object> c) {
//
//		final String s = c.getName();
//
//		final int i = s.lastIndexOf('.');
//
//		return (i < 0) ? "" : s.substring(0, i);
//
//	}
//
//	public static boolean isEqual(final String string1, final String string2) {
//
//		boolean result = false;
//
//		if (string1 == string2) {
//
//			result = true;
//
//		} else {
//
//			if ((string1 == null) || (string2 == null)) {
//
//				result = false;
//
//			} else {
//
//				result = string1.equals(string2);
//
//			}
//
//		}
//
//		return result;
//
//	}
//
//	public static boolean isStringArrayEqual(final String[] array1,
//			final String[] array2) {
//
//		boolean result = false;
//
//		if (array1.length == array2.length) {
//
//			if (array1.length > 0) {
//
//				result = true;
//
//				for (int i = 0, ilast = array1.length - 1; i <= ilast; i++) {
//
//					if (!isEqual(array1[i], array2[i])) {
//
//						result = false;
//
//						break;
//
//					}
//
//				}
//
//			}
//
//		}
//
//		return result;
//
//	}
//
//	/**
//	 * 
//	 * Checks whether the string contains all ascii characters
//	 * 
//	 *
//	 * 
//	 * @param string
//	 * 
//	 * @return true if the string is null or empty or contains ALL ascii
//	 *         characters
//	 */
//
//	public static boolean isASCII(final String checkString) {
//
//		final boolean isAscii = true;
//
//		if ((checkString != null) && (checkString.length() > 0)) {
//
//			char[] characters;
//
//			int i, j;
//
//			characters = checkString.toCharArray();
//
//			for (i = 0, j = characters.length; i < j; i++) {
//
//				final char aChar = characters[i];
//
//				if ((aChar < ' ') || (aChar > '~')) {
//
//					return false;
//
//				}
//
//			}
//
//		}
//
//		return isAscii;
//
//	}
//
//	static String rewriteRules(String string,
//			final List<Map<String, String>> rules) {
//
//		if ((string != null) && (rules != null)) {
//
//			// evaluate the rules in order
//
//			for (final Map<String, String> rule : rules) {
//
//				try {
//
//					// each rule is a set of regexp -> replacements
//
//					// that apply in any order
//
//					for (final Map.Entry<String, String> entry : rule
//							.entrySet()) {
//
//						final String regexp = entry.getKey();
//
//						final String replace = entry.getValue();
//
//						string = string.replaceAll(regexp, replace);
//
//					}
//
//				} catch (final Exception e) {
//
//					// eat the exception, this is a best effort
//
//				}
//
//			}
//
//		}
//
//		return string;
//
//	}
//
//	public static enum HorizontalAlignment {
//
//		LEFT, CENTER, RIGHT
//
//	}
//
//	/**
//	 * 
//	 * Returns an object value formatted to a given width. If the width is > 0
//	 * then the field width
//	 * 
//	 * is applied; if width is less than or equal to zero then the result will
//	 * simply be the string
//	 * 
//	 * given as input.
//	 * 
//	 *
//	 * 
//	 * If the input value is null the string value will be "null".
//	 * 
//	 *
//	 * 
//	 * @param value
//	 * 
//	 * @param width
//	 * 
//	 * @return
//	 */
//
//	public static String toStringWithWidth(final Object value, final int width,
//			final HorizontalAlignment align) {
//
//		final String s = (value == null) ? "null" : value.toString();
//
//		if (width > 0) {
//
//			if (align == HorizontalAlignment.LEFT) {
//
//				return s + getPaddingString(width - s.length());
//
//			} else if (align == HorizontalAlignment.RIGHT) {
//
//				return getPaddingString(width - s.length()) + s;
//
//			} else if (align == HorizontalAlignment.CENTER) {
//
//				final int padding = width - s.length();
//
//				final int left = padding / 2;
//
//				final int right = padding - left;
//
//				return getPaddingString(left) + s + getPaddingString(right);
//
//			}
//
//		}
//
//		return s;
//
//	}
//
//	public static String formatRow(final Object[] row, final int[] widths,
//			final HorizontalAlignment[] alignments,
//
//			final String separator) {
//
//		final StringBuilder result = new StringBuilder();
//
//		// row length of 1 means just insert verbatim
//
//		if (row.length > 1) {
//
//			for (int i = 0, ilast = row.length - 1; i <= ilast; i++) {
//
//				final boolean isLastColumn = (i == ilast);
//
//				int columnWidth = widths[i];
//
//				// if it's the last effective column and we have left align then
//				// just don't
//
//				// bother with padding. Sending zero for the column width
//				// triggers this in
//
//				// toStringWithWidth().
//
//				if (isLastColumn && (alignments[i] == HorizontalAlignment.LEFT)) {
//
//					columnWidth = 0;
//
//				}
//
//				result.append(toStringWithWidth(row[i], columnWidth,
//						alignments[i]));
//
//				if (!isLastColumn) {
//
//					result.append(separator);
//
//				}
//
//			}
//
//		} else {
//
//			result.append(row[0]);
//
//		}
//
//		return result.toString();
//
//	}
//
//	public static String formatColumnHeaderSeparator(final String[] headerRow,
//			final int[] widths,
//
//			final HorizontalAlignment[] alignments, final String separator) {
//
//		final StringBuilder result = new StringBuilder();
//
//		final int columnCount = headerRow.length;
//
//		for (int i = 0, ilast = columnCount - 1; i <= ilast; i++) {
//
//			final boolean isLastColumn = (i == ilast);
//
//			int separatorWidth = widths[i];
//
//			if (isLastColumn && (alignments[i] == HorizontalAlignment.LEFT)) {
//
//				// if it's the last effective column and we have left align then
//				// don't print the entire column header row
//
//				// separator.
//
//				separatorWidth = headerRow[i].length();
//
//			}
//
//			result.append(ASStringUtilities.getPaddingString(separatorWidth,
//					"-"));
//
//			if (i < ilast) {
//
//				result.append(separator);
//
//			}
//
//		}
//
//		return result.toString();
//
//	}
//
//	public static String formatAsTable(final List<String[]> rows,
//			final HorizontalAlignment[] alignments,
//
//			final String separator) {
//
//		return formatAsTable(rows, alignments, separator, false);
//
//	}
//
//	public static String formatAsTable(final List<String[]> rows,
//			final HorizontalAlignment[] alignments,
//
//			final String separator, final boolean collapseDuplicates) {
//
//		final StringBuilder result = new StringBuilder();
//
//		int[] widths = null;
//
//		int rowNum = 0;
//
//		String[] previousRow = null;
//
//		int dupeCount = 0;
//
//		for (final String[] row : rows) {
//
//			if (widths == null) {
//
//				widths = new int[row.length];
//
//			}
//
//			// special row of length 1 gets inserted as given
//
//			if (row.length > 1) {
//
//				for (int i = 0; i < row.length; i++) {
//
//					if (row[i] != null) {
//
//						widths[i] = Math.max(row[i].length(), widths[i]);
//
//					}
//
//				}
//
//			}
//
//		}
//
//		for (final String[] row : rows) {
//
//			if (collapseDuplicates && (previousRow != null)
//					&& ASStringUtilities.isStringArrayEqual(row, previousRow)) {
//
//				dupeCount++;
//
//			} else {
//
//				if (collapseDuplicates) {
//
//					if (dupeCount > 0) {
//
//						result.append(formatRow(new String[] { "  [^ Repeated "
//								+ dupeCount +
//
//								" additional time(s) ^]\n" }, widths,
//								alignments,
//
//								separator));
//
//						dupeCount = 0;
//
//					}
//
//				}
//
//				result.append(formatRow(row, widths, alignments, separator));
//
//				result.append('\n');
//
//				if (rowNum == 0) {
//
//					result.append(formatColumnHeaderSeparator(row, widths,
//							alignments, separator));
//
//					result.append('\n');
//
//				}
//
//				rowNum++;
//
//			}
//
//			previousRow = row;
//
//		}
//
//		return result.toString();
//
//	}
//
//	/**
//	 * 
//	 *
//	 * 
//	 * @param patterns
//	 * 
//	 * @param value
//	 * 
//	 * @param fullMatch
//	 * 
//	 * @return
//	 */
//
//	public static boolean isMatchFound(final List<Pattern> patterns,
//			final String value, final boolean fullMatch) {
//
//		if (patterns == null) {
//
//			return false;
//
//		}
//
//		for (final Pattern regex : patterns) {
//
//			if (fullMatch) {
//
//				if (regex.matcher(value).matches()) {
//
//					return true;
//
//				}
//
//			} else {
//
//				if (regex.matcher(value).lookingAt()) {
//
//					return true;
//
//				}
//
//			}
//
//		}
//
//		return false;
//
//	}
//
//	/**
//	 * 
//	 *
//	 * 
//	 * @param patternStrings
//	 * 
//	 * @return
//	 */
//
//	public static List<Pattern> regexPatternArrayFromPatternStringArray(
//			final List<String> patternStrings) {
//
//		if (patternStrings == null) {
//
//			return null;
//
//		}
//
//		final List<Pattern> list = new ArrayList<Pattern>(patternStrings.size());
//
//		for (final String patternString : patternStrings) {
//
//			try {
//
//				final Pattern pattern = Pattern.compile(patternString);
//
//				list.add(pattern);
//
//			} catch (final PatternSyntaxException e) {
//
//			 
//
//			}
//
//		}
//
//		return list;
//
//	}
//
//}