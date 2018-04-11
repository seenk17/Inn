package ru.nmiac.commons.format.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPassportRF {
	
	SnilsFormatImpl fmt;
	
	@Before
	public void setUpClass() {
		fmt = new SnilsFormatImpl();
	}

	@Test
	public void testExtract() throws Exception {
		String raw = "123-456-789-91";
		String res = fmt.extract(raw);
		Assert.assertEquals("12345678991", res);
		
	}
	
	@Test
	public void testFormat() throws Exception {
		String mng = "12345678991";
		String res = fmt.format(mng);
		Assert.assertEquals("123-456-789-91", res);
		
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
