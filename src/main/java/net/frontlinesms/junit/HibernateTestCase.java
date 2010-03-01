/**
 * 
 */
package net.frontlinesms.junit;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * Base class for transactional tests.
 * @author Alex
 */
public abstract class HibernateTestCase extends AbstractTransactionalDataSourceSpringContextTests {
//> SETUP
	/**
	 * Gets a Spring resource location from the classpath, derived from the package
	 * in which the extending implementation of this class exists. 
	 * @return classpath location of XML database config
	 */
	@Override
	protected String[] getConfigLocations() {
		return TestUtils.getConfigLocations(this.getClass());
	}
}
