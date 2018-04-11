package ru.nmiac.commons.format.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTag {
	
	TagFormatImpl fmt;
	
	@Before
	public void setUpClass() {
		fmt = new TagFormatImpl();
	}

	@Test
	public void testExtract() throws Exception {
		String raw = "12 ааф3-45z %66-789-9";
		String res = fmt.extract(raw);
		Assert.assertEquals("12ааф345z667899", res);		
	}
	
	@Test
	public void testFormat() throws Exception {
		String mng = "12ааф345z667899";
		String res = fmt.format(mng);
		Assert.assertEquals("12ааф345z667899", res);
		
		// должна выдать ошибку длины
		mng = "1";
		try {
			res = fmt.format(mng);
			Assert.assertTrue(false);
		} catch (Exception ex) {
			Assert.assertTrue(true);
		}
	}
	
}
