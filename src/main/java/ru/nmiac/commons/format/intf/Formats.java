package ru.nmiac.commons.format.intf;

import ru.nmiac.commons.format.impl.InnJusticeFormatImpl;
import ru.nmiac.commons.format.impl.InnPeopleFormatImpl;
import ru.nmiac.commons.format.impl.OMSNumberFormatImpl;
import ru.nmiac.commons.format.impl.PassportRFFormatImpl;
import ru.nmiac.commons.format.impl.SnilsFormatImpl;
import ru.nmiac.commons.format.impl.SvidRFFormatImpl;
import ru.nmiac.commons.format.impl.TagFormatImpl;

public class Formats {
	
	private static Formats instance = new Formats();
	
	private Formats() {
		
	}
	
	public static Formats getInstance() {
		return instance;
	}

	public final Format SNILS = new SnilsFormatImpl(); 
	public final Format INN_PEOPLE = new InnPeopleFormatImpl(); 
	public final Format INN_JUSTICE = new InnJusticeFormatImpl(); 
	public final Format PASSPORT_RF = new PassportRFFormatImpl();
	public final Format SVID_RF = new SvidRFFormatImpl();
	public final Format OMS = new OMSNumberFormatImpl();
	public final Format TAG = new TagFormatImpl();

	public Format getSNILS() {
		return SNILS;
	}

	public Format getINN_PEOPLE() {
		return INN_PEOPLE;
	}

	public Format getINN_JUSTICE() {
		return INN_JUSTICE;
	}

	public Format getPASSPORT_RF() {
		return PASSPORT_RF;
	}

	public Format getOMS() {
		return OMS;
	}

	public Format getTAG() {
		return TAG;
	}

	public Format getSVID_RF() {
		return SVID_RF;
	} 
}
