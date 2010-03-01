package net.frontlinesms.junit;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class TestUtils {
	/**
	 * Gets config loctions for the test method from the test class's package on the classpath.
	 * @param clazz The class of the test case class
	 * @return the spring config locations for the test
	 */
	public static String[] getConfigLocations(Class<? extends AbstractTransactionalDataSourceSpringContextTests> clazz) {
		String resourcePath = "classpath:" + clazz.getName().replace('.', '/') + '.' + "xml";
		return new String[] { resourcePath };
	}

}
