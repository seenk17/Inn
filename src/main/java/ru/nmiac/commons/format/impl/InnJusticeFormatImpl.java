package ru.nmiac.commons.format.impl;

import java.util.Scanner;

/**
 * ИНН юр лица
 * @author irina
 *
 */
public class InnJusticeFormatImpl extends BaseRegexFormatImpl {

	public InnJusticeFormatImpl() {
		super("[0-9]{10}", "([0-9]{1,}){1,}", "9999999999", true, 10, 10, null);
		int sum;
    	int number1;
        Scanner input = new Scanner(System.in);                 // Объявляем Scanner
        System.out.println("Введем длину массива(10): ");
        int size = input.nextInt();                             // Читаем с клавиатуры размер массива и записываем в size
        int array[] = new int[size];                            // Создаём массив int размером в size
        System.out.println("Введем ИНН цифры :");            /*Пройдёмся по всему массиву, заполняя его*/
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
