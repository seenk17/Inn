package ru.nmiac.commons.format.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSvidRF {
	
	SvidRFFormatImpl fmt;
	
	@Before
	public void setUpClass() {
		fmt = new SvidRFFormatImpl();
	}

	@Test
	public void testExtract() throws Exception {
		String raw = "i-шр 765904";
		String res = fmt.extract(raw);
		Assert.assertEquals("IШР765904", res);
		
	}
	
	@Test
	public void testFormat() throws Exception {
		String mng = "IШР765904";
		String res = fmt.format(mng);
		Assert.assertEquals("    I-ШР 765904", res);
		
		// должна выдать ошибку длины
		mng = "IXIVXXШР765904";
		try {
			res = fmt.format(mng);
			Assert.assertTrue(false);
		} catch (Exception ex) {
			Assert.assertTrue(true);
		}
	}
	
}
