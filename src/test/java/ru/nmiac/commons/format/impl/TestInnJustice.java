package ru.nmiac.commons.format.impl;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestInnJustice {
	
	InnJusticeFormatImpl fmt;
	
	@Before
	public void setUpClass() {
		fmt = new InnJusticeFormatImpl();
	}

	@Test
	public void testExtract() throws Exception {
		String raw = "123-fre456f-7f89-9";
		String res = fmt.extract(raw);
		Assert.assertEquals("1234567899", res);
		
	}
	
	@Test
	public void testFormat() throws Exception {
		String mng = "1234567890";
		String res = fmt.format(mng);
		Assert.assertEquals("1234567890", res);
		
		// должна выдать ошибку длины
		mng = "1234567895436565";
		try {
			res = fmt.format(mng);
			Assert.assertTrue(false);
		} catch (Exception ex) {
			Assert.assertTrue(true);
		}
		
	}
	@Test
	public void testInn()throws Exception {
    	int sum;
    	
    	int number1;
        Scanner input = new Scanner(System.in);                 // Объявляем Scanner
        System.out.println("Введем длину массива(10): ");
        int size = input.nextInt();                             // Читаем с клавиатуры размер массива и записываем в size
        int array[] = new int[size];                            // Создаём массив int размером в size
        System.out.println("Введем ИНН цифры:");            /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();                         // Заполняем массив элементами, введёнными с клавиатуры
        }       
        	sum=array[0]*2+array[1]*4+array[2]*10+array[3]*3+array[4]*5+array[5]*9+array[6]*4+array[7]*6+array[8]*8+array[9]*0;
        	number1=sum % 11;
        	if (number1>9 ) {
        		number1=sum % 10;
            } 
        	if(array[9]==number1) {
        		System.out.println("Инн введен правильно");	
        	}
        	else {
        		System.out.println("Такого ИНН не существует");
        	}    
    }
    }

	


	
