package net.frontlinesms.junit;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.mockito.MockitoAnnotations;

import junit.framework.AssertionFailedError;
import junit.framework.ComparisonFailure;
import junit.framework.TestCase;

/**
 * Extension of basic junit {@link TestCase} to add extra functionality, such as deep array comparison.
 * @author Alex
 */
public abstract class BaseTestCase extends TestCase {
	
//> STATIC CONSTANTS
	/** Date format for formatting messages. */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy HH:mm:ss ZZZZZ");
	/** The name of the directory to store temporary test files in */
	private static final File TEMPORARY_DATA_DIRECTORY = new File("test_temp");
	
//> INSTANCE PROPERTIES
	/** Logging object */
	protected final Logger log = Logger.getLogger(this.getClass());
	
//> COMMON SETUP / TEARDOWN METHODS
	/**
	 * Set up common test resources:
	 * <li>{@link #TEMPORARY_DATA_DIRECTORY}</li>
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MockitoAnnotations.initMocks(this);
		TEMPORARY_DATA_DIRECTORY.mkdir();
	}
	
	/** Destroy common test resources created by {@link #setUp()}. */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		TEMPORARY_DATA_DIRECTORY.delete();
	}
	
//> COMMENT METHODS
	public static void TODO(String message) {
		// In future we may want the option to disable failure for calls to this
		// method and e.g. replace them with warnings in the logs.
		fail("TODO: " + message);
	}
	
//> SETUP METHODS
	public static void inject(Object object, String fieldName, Object value) {
		try {
			Field f = object.getClass().getDeclaredField(fieldName);
			f.setAccessible(true);
			f.set(object, value);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public static <T> List<T> emptyList(Class<T> c) {
		return Collections.emptyList();
	}
	
	public static int[] array(int... ts) {
		return ts;
	}
	
	public static <T> T[] array(T... ts) {
		return ts;
	}
	
	public static <T> T[] objectArray(T... ts) {
		return array(ts);
	}
	
	public static <T> List<T> asList(T... ts) {
		return new ArrayList<T>(Arrays.asList(ts));
	}
	
//> EQUALS METHODS
	/**
	 * Compare the contents of 2 <code>byte[]</code>.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(byte[] expected, byte[] actual) {
		assertEqualsWithoutMessage();
	}
	
	/**
	 * Compare the contents of 2 <code>long[]</code>.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(int[] expected, int[] actual) {
		assertEqualsWithoutMessage();
	}
	
	/**
	 * Compare the contents of 2 <code>long[]</code>.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(Integer[] expected, Integer[] actual) {
		assertEqualsWithoutMessage();
	}
	
	/**
	 * Compare the contents of 2 <code>long[]</code>.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(long[] expected, long[] actual) {
		assertEqualsWithoutMessage();
	}
	
	/**
	 * Compare the contents of 2 <code>long[]</code>.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(Long[] expected, Long[] actual) {
		assertEqualsWithoutMessage();
	}
	
	/**
	 * Compare the contents of 2 <code>String[]</code>.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(String[] expected, String[] actual) {
		assertEqualsWithoutMessage();
	}
	
	/**
	 * Compare the contents of 2 <code>byte[]</code>.
	 * @param message The message to display if the two arrays are not equal in length and content.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(String message, byte[] expected, byte[] actual) {
		assertEquals(message + " (different lengths)", expected.length, actual.length);
		for (int i = 0; i < actual.length; i++) {
			assertEquals(message + "(error found at position " + i + ")", expected[i], actual[i]);
		}
	}
	
	/**
	 * Compare the contents of 2 <code>int[]</code>.
	 * @param message The message to display if the two arrays are not equal in length and content.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(String message, int[] expected, int[] actual) {
		assertEquals(message + " (different lengths)", expected.length, actual.length);
		for (int i = 0; i < actual.length; i++) {
			assertEquals(message + "(error found at position " + i + ")", expected[i], actual[i]);
		}
	}
	
	/**
	 * Compare the contents of 2 <code>Integer[]</code>.
	 * @param message The message to display if the two arrays are not equal in length and content.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(String message, Integer[] expected, Integer[] actual) {
		assertEquals(message + " (different lengths)", expected.length, actual.length);
		for (int i = 0; i < actual.length; i++) {
			assertEquals(message + "(error found at position " + i + ")", expected[i], actual[i]);
		}
	}
	
	/**
	 * Compare the contents of 2 <code>long[]</code>.
	 * @param message The message to display if the two arrays are not equal in length and content.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(String message, long[] expected, long[] actual) {
		assertEquals(message + " (different lengths)", expected.length, actual.length);
		for (int i = 0; i < actual.length; i++) {
			assertEquals(message + "(error found at position " + i + ")", expected[i], actual[i]);
		}
	}
	
	/**
	 * Compare the contents of 2 <code>Integer[]</code>.
	 * @param message The message to display if the two arrays are not equal in length and content.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(String message, Long[] expected, Long[] actual) {
		assertEquals(message + " (different lengths)", expected.length, actual.length);
		for (int i = 0; i < actual.length; i++) {
			assertEquals(message + "(error found at position " + i + ")", expected[i], actual[i]);
		}
	}

	/**
	 * Compare the contents of 2 <code>String[]</code>.
	 * @param message The message to display if the two arrays are not equal in length and content.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(String message, String[] expected, String[] actual) {
		assertEquals(message + " (different lengths)", expected.length, actual.length);
		for (int i = 0; i < actual.length; i++) {
			assertEquals(message + "(error found at position " + i + ")", expected[i], actual[i]);
		}
	}

	/**
	 * Compare the contents of 2 <code>Object[]</code>.
	 * @param message The message to display if the two arrays are not equal in length and content.
	 * @param expected The expexted array.
	 * @param actual The actual array found in the test.
	 */
	public static void assertEquals(String message, Object[] expected, Object[] actual) {
		assertEquals(message + " (different lengths)", expected.length, actual.length);
		for (int i = 0; i < actual.length; i++) {
			assertEquals(message + "(error found at position " + i + ")", expected[i], actual[i]);
		}
	}
	
	/**
	 * Compares 2 {@link String}s and gives a detailed message if they are not equals.
	 * TODO please document this more clearly.
	 * @param message
	 * @param expected
	 * @param actual
	 */
	public static void assertStringEquals(String message, String expected, String actual) {
		try {
			assertEquals(message, expected, actual);
		} catch(AssertionFailedError f) {
			int minLen = Math.min(expected.length(), actual.length());
			for(int i=0; i<minLen; ++i) {
				if(expected.charAt(i) != actual.charAt(i)) throw new ComparisonFailure("Strings differ from character " + i, expected, actual);
			}
			throw f;
		}
	}
	
	/**
	 * Calls {@link #assertEquals(long, long)} on the time in millis of each date object.
	 * TODO this may foolishly ignore timezones; investigate.
	 * @param message
	 * @param expected
	 * @param actual
	 */
	public static void assertEquals(String message, Date expected, Date actual) {
		assertEquals(message, expected.getTime(), actual.getTime());	
	}
	
	/**
	 * Compares the contents of two {@link InputStream}s.
	 * @param expected Stream of expected values
	 * @param actual Stream of actual values
	 */
	public static void assertEquals(InputStream expected, InputStream actual) {
		assertEqualsWithoutMessage();
	}
	
	/**
	 * Compares the contents of two {@link InputStream}s.
	 * @param message Message to display if the comparison fails
	 * @param expected Stream of expected values
	 * @param actual Stream of actual values
	 */
	public static void assertEquals(String message, InputStream expected, InputStream actual) {
		ByteArrayOutputStream expectedAsBAOS = new ByteArrayOutputStream();
		stream2stream(expected, expectedAsBAOS);

		ByteArrayOutputStream actualAsBAOS = new ByteArrayOutputStream();
		stream2stream(actual, actualAsBAOS);
		
		assertEquals(message, expectedAsBAOS.toByteArray(), actualAsBAOS.toByteArray());
	}
	
	public static void assertDateEquals(String message, long expected, long actual) {
		if(expected != actual) {
			long d = expected - actual;
			long dSeconds = (d / 1000) % 60;
			long dMinutes = (d / (1000 * 60)) % 60;
			long dHours = (d / (1000 * 60 * 60)) % 60;
			long dDays = (d / (1000 * 60 * 60 * 24)) % 24;
			long dYears = (d / (1000 * 60 * 60 * 24 * 365));
			fail("Expected: " + DATE_FORMAT.format(expected) + " ("+expected+");\n" +
					"Actual: " + DATE_FORMAT.format(actual) + " ("+actual+");\n" +
					"Times differed by ~"+dYears+"y " +
					dDays+"d " +
					dHours+"h " +
					dMinutes+"m " +
					dSeconds+"s");
			fail("Time decode was incorrect.");
		}
	}

	public static void assertEqualsHashcodeTrue(Object a, Object b) {
		assert(a != null) : "You must provide at least one non-null object to this method.";
		assertTrue(a.equals(b));
		if(b != null) {
			assertTrue(b.equals(a));
			assertTrue(a.hashCode() == b.hashCode());
		}
	}
	
	public static void assertEqualsHashcodeFalse(Object a, Object b) {
		assert(a != null) : "You must provide at least one non-null object to this method.";
		assertFalse(a.equals(b));
		if(b != null) {
			assertFalse(b.equals(a));
			assertFalse(a.hashCode() == b.hashCode());
		}
	}
	
	public static void assertInstanceOf(String message, Class<?> c, Object o) {
		if(o == null) {
			fail(message + "\r\nExpected " + c + " but object was null.");
		}
		if(!c.isInstance(o)) {
			fail(message + "\r\nExpected " + c + " but got " + o.getClass());
		}
	}
	
//> STATIC UTILITIES
	/** print to the standard out */
	public static void println(String s) {
		System.out.println(s);
	}
	
	/**
	 * Creates a test output file in the temp test directory.
	 * @param fileName The name of the test output file.
	 * @return A temporary file in the temporary directory.
	 */
	protected static File getOutputFile(String fileName) {
		return new File(TEMPORARY_DATA_DIRECTORY, fileName);
	}
	
	/**
	 * Reads the entire contents of an {@link OutputStream} and writes it to an {@link InputStream}.
	 * @param from
	 * @param to
	 */
	private static void stream2stream(InputStream from, OutputStream to) {
		int read;
		try {
			while((read = from.read()) != -1) {
				to.write(read);
			}
		} catch(IOException ex) { /* we've reached the end of the stream - time to return */ }
	}
	
	/**
	 * Method to call from assertEquals methods which have no message.  This is to enforce provision
	 * of a message, and prevent confusion when we have overridden {@link #assertEquals(Object, Object)}
	 */
	private static void assertEqualsWithoutMessage() {
		throw new IllegalStateException("assertEquals() should not be called without a message.");
	}
}