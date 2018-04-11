package ru.nmiac.commons.format.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSNILS {
	
	PassportRFFormatImpl fmt;
	
	@Before
	public void setUpClass() {
		fmt = new PassportRFFormatImpl();
	}

	@Test
	public void testExtract() throws Exception {
		String raw = "123-456-789-9";
		String res = fmt.extract(raw);
		Assert.assertEquals("1234567899", res);		
	}
	
	@Test
	public void testFormat() throws Exception {
		String mng = "1234567899";
		String res = fmt.format(mng);
		Assert.assertEquals("1234-567899", res);
		
		// должна выдать ошибку длины
		mng = "123456789915";
		try {
			res = fmt.format(mng);
			Assert.assertTrue(false);
		} catch (Exception ex) {
			Assert.assertTrue(true);
		}
	}
	
}
