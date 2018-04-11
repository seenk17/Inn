package ru.nmiac.commons.format.impl;

import org.apache.commons.lang.StringUtils;

import ru.nmiac.commons.format.intf.Format;
import ru.nmiac.commons.format.intf.InvalidDataException;

/**
 * Серия и номер свидетельства о рождении РФ
 * @author irina
 *
 */
public class SvidRFFormatImpl extends BaseRegexFormatImpl implements Format {

	public SvidRFFormatImpl() {
		super("[IVX]{1,3}-[А-Я]{2,2} [0-9]{6,6}", "([IVXivx0-9А-Яа-я]{1,}){1,}","*****-aa 999999", true, 9, 13, false);
	}

	@Override
	public String format(String meaningful) throws InvalidDataException {
		if (meaningful.length() < 13) {
			meaningful = StringUtils.leftPad(meaningful, 13, ' ');
		}

		return super.format(meaningful);
	}


}
