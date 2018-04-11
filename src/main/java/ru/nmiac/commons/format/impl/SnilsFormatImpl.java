package ru.nmiac.commons.format.impl;

import ru.nmiac.commons.format.intf.Format;

public class SnilsFormatImpl extends BaseRegexFormatImpl implements Format {

	public SnilsFormatImpl() {
		super("[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{2}", "([0-9]{1,}){1,}","999-999-999-99", true, 11, 11, null);
	}


}
