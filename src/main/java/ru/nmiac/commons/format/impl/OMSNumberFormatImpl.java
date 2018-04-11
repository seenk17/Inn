package ru.nmiac.commons.format.impl;

import ru.nmiac.commons.format.intf.Format;

public class OMSNumberFormatImpl extends BaseRegexFormatImpl implements Format {

	public OMSNumberFormatImpl() {
		super("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}", "([0-9]{1,}){1,}","9999-9999-9999-9999", true, 11, 11, null);
	}


}
