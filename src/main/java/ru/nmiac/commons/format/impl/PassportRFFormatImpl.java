package ru.nmiac.commons.format.impl;

import ru.nmiac.commons.format.intf.Format;

/**
 * Серия и номер паспорта РФ
 * @author irina
 *
 */
public class PassportRFFormatImpl extends BaseRegexFormatImpl implements Format {

	public PassportRFFormatImpl() {
		super("[0-9]{4}-[0-9]{6}", "([0-9]{1,}){1,}","9999-999999", true, 10, 10, null);
	}


}
