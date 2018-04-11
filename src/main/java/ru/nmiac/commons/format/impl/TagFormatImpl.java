package ru.nmiac.commons.format.impl;

import ru.nmiac.commons.format.intf.Format;

public class TagFormatImpl extends BaseRegexFormatImpl implements Format {

	public TagFormatImpl() {
		super("[0-9a-zа-я]{2,50}", "([0-9a-zA-Zа-яА-Я]{1,}){1,}","****************************************************", true, 2, 50, true);
	}


}
