package ru.nmiac.commons.format.impl;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestInnPeople {
	
	InnPeopleFormatImpl fmt;
	
	@Before
	public void setUpClass() {
		fmt = new InnPeopleFormatImpl();
	}

	@Test
	public void testExtract() throws Exception {
		String raw = "123-fre456f-7f89-91t5";
		String res = fmt.extract(raw);
		Assert.assertEquals("123456789915", res);
		
	}
	
	@Test
	public void testFormat() throws Exception {
		String mng = "123456789915";
		String res = fmt.format(mng);
		Assert.assertEquals("123456789915", res);
		
		// должна выдать ошибку длины
		mng = "1234567895";
		try {
			res = fmt.format(mng);
			Assert.assertTrue(false);
		} catch (Exception ex) {
			Assert.assertTrue(true);
		}
	}
	@Test
	public void testInn()throws Exception {
    	int sum,sum2,number1,number2;
        Scanner input = new Scanner(System.in);            // Объявляем Scanner
        System.out.println("Задаем длину массива(12)");
        int size = input.nextInt();                       // Читаем с клавиатуры размер массива и записываем в size
        int array[] = new int[size];                       // Создаём массив int размером в size
        System.out.println("Ввод цифр из ИНН");      /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();                    // Заполняем массив элементами, введёнными с клавиатуры
        }

        	sum=array[0]*7+array[1]*2+array[2]*4+array[3]*10+array[4]*3+array[5]*5+array[6]*9+array[7]*4+array[8]*6+array[9]*8+array[10]*0+array[11]*0;
        	number1=sum % 11;
        	sum2=array[0]*3+array[1]*7+array[2]*2+array[3]*4+array[4]*10+array[5]*3+array[6]*5+array[7]*9+array[8]*4+array[9]*6+array[10]*8+array[11]*0;
        	number2=sum2 % 11;
        	if (number1>9 ) {
        		number1=sum % 10;
            } 
        	if (number2>9) {
        		number2=sum2 % 10;
        	}
        	if(array[10]==number1 && array[11]==number2) {
        		System.out.println("Инн введен правильно");	
        	}
        	else {
        		System.out.println("Такого ИНН не существует");
        	}    
    }

	
}
