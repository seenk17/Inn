package ru.nmiac.commons.format.intf;

import java.util.regex.Pattern;

public interface Format {

	/**
	 * Извлекает только значащие символы
	 * @param raw
	 * @return
	 */
	public String extract(String raw) throws InvalidDataException;
	
	/**
	 * Форматирует, используя стандартную маску. Если значащие символы не соответствуют маске, выдаёт ошибку
	 * @param meaningful - только значащие символы
	 * @return сформатированную по маске строку
	 */
	public String format(String meaningful) throws InvalidDataException;
	
	/**
	 * Форматирует, используя стандартную маску. Если значащие символы не соответствуют маске, выдаёт сообщение по умолчанию
	 * @param meaningful - только значащие символы
	 * @param invalidDataDefault - сообщение по умолчанию
	 * @return сформатированную по маске строку
	 */	
	public String format(String meaningful, String invalidDataDefault);
	
	/**
	 * Форматирует, используя стандартную маску. Если значащие символы не соответствуют маске, выдаёт неформатированные данные
	 * @param meaningful - только значащие символы
	 * @return сформатированную по маске строку
	 */	
	public String formatOrNo(String meaningful);	
	
	/**
	 * Подходит ли данная строка под формат
	 * @param raw
	 * @return
	 */
	public boolean looksLike(String raw);
	
	public String getInputMask();
	
	public Pattern getValidationPattern();
}
