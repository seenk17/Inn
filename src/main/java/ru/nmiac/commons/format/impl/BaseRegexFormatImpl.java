package ru.nmiac.commons.format.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.nmiac.commons.format.intf.Format;
import ru.nmiac.commons.format.intf.InvalidDataException;

public abstract class BaseRegexFormatImpl implements Format {
	
	private static final String digits = "0123456789";
	private static final Pattern latins = Pattern.compile("[a-zA-Z]{1,}"); 
	private static final Pattern russians = Pattern.compile("[а-яА-Я]{1,}");
	
	protected Pattern pattern;
	protected Pattern patternExtract;
	protected String mask;
	protected boolean alwaysTrim;
	// Минимальная и максимальная длина значащих символов. null - без ограничений
	protected Integer minMLength; 
	protected Integer maxMLength;
	protected Boolean toLowerCase; // null - регистр не имеет значения, true/false - перевести в нижний/верхний регистр

	public BaseRegexFormatImpl(String regex, String regexExtract, String mask, boolean alwaysTrim, Integer minMLength, Integer maxMLength, Boolean toLowerCase) {
		this.pattern = Pattern.compile(regex);
		this.patternExtract = Pattern.compile(regexExtract);
		this.alwaysTrim = alwaysTrim;
		this.minMLength = minMLength;
		this.maxMLength = maxMLength;
		this.toLowerCase = toLowerCase;
		this.mask = mask;
	}
	
	public String extract(String raw) throws InvalidDataException {
		if (raw == null) {
			return null;
		}
		if (alwaysTrim) {
			raw = raw.trim();
		}
		String sres = "";
		Matcher m = patternExtract.matcher(raw);
		int i = 0;
		while (m.find()) {
			sres = sres + m.group();
			i++;
		}
		if (alwaysTrim) {
			sres = sres.trim();
		}
		if (minMLength != null && sres.length() < minMLength) {
			throw new InvalidDataException("Длина должна быть не менее " + minMLength.toString());
		}
		if (maxMLength != null && sres.length() > maxMLength) {
			throw new InvalidDataException("Длина должна быть не более " + maxMLength.toString());
		}
		
		if (sres.length() == 0) {
			return null;
		} else {
			if (toLowerCase == null) {
				return sres;
			} else {
				if (toLowerCase.booleanValue()) {
					return sres.toLowerCase();
				} else {
					return sres.toUpperCase();
				}
			}
		}
	}
	
	public String format(String meaningful, String invalidDataDefault) {
		try {
			String res = format(meaningful);
			return res;
		} catch (InvalidDataException e) {
			return invalidDataDefault;
		}
	}
	
	public String formatOrNo(String meaningful) {
		try {
			String res = format(meaningful);
			return res;
		} catch (InvalidDataException e) {
			return meaningful;
		}
		
	}
	
	public String format(String meaningful) throws InvalidDataException {
		if (meaningful == null) {
			return null;
		}
		
		String sres = "";
		int n = -1;
		for (int i = 0; i < mask.length(); i++) {
			char chm = mask.charAt(i);
			if (chm == '*' || chm == 'a' || chm == '9') {
				n++;
				// Строка короче маски. Ожидается, что в строке есть символ
				if (n >= meaningful.length() ) {
					if (this.minMLength == null || ( meaningful.length() >= this.minMLength )) {
						// но притом строка длиннее минимальной длины
						break;
					} else {
						throw new InvalidDataException("Строка " + meaningful + " не может быть сформатирована по маске " + this.mask);
					}
				}
				char ch = meaningful.charAt(n);
				switch(chm) {
					case '*':sres = sres + ch;break;// подойдёт любой символ
					case '9':{
						if (digits.indexOf(ch) >= 0) {
							sres = sres + ch;
						} else {
							throw new InvalidDataException("В позиции " + n + " ожидается цифра");
						}
					};break; // ожидается цифра
					case 'a': {
						if (latins.matcher(ch + "").matches() || russians.matcher(ch + "").matches()) {
							sres = sres + ch;
						} else {
							throw new InvalidDataException("В позиции " + n + " ожидается буква");
						}
					};break; // ожидается буква
				}
				
				
			} else {
				// символы маски
				sres = sres + chm;
			}
		}
		
		// ожидается, что вся значащая строка ушла в маску
		if ( (n+1) < meaningful.length()) {
			throw new InvalidDataException("Строка " + meaningful + " не может быть сформатирована по маске " + this.mask);
		}
			
		if (toLowerCase == null) {
			return sres;
		} else {
			if (toLowerCase.booleanValue()) {
				return sres.toLowerCase();
			} else {
				return sres.toUpperCase();
			}
		}
	}

	public boolean looksLike(String raw) {
		if (raw == null) {
			return false;
		}
		
		if (alwaysTrim) {
			raw = raw.trim();
		}
		return pattern.matcher(raw).matches();
	}
	
	public Pattern getValidationPattern() {
		return this.pattern;
	}
	
	public String getInputMask() {
		return this.mask;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public Pattern getPatternExtract() {
		return patternExtract;
	}

	public boolean isAlwaysTrim() {
		return alwaysTrim;
	}

	public Integer getMinMLength() {
		return minMLength;
	}

	public Integer getMaxMLength() {
		return maxMLength;
	}

	public Boolean getToLowerCase() {
		return toLowerCase;
	}

	public String getMask() {
		return mask;
	}	
}
