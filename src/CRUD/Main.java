package CRUD;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		
		int inpt;
		String str;
		while(true) {
		System.out.println("�޴� ����");
		System.out.println("1. C");
		System.out.println("2. R");
		System.out.println("3. U");
		System.out.println("4. D");
		System.out.println("5. ����");
		inpt = scan.nextInt();
		switch (inpt) {
        case 1:  insertValue();
                 break;
        case 2:  Select.select();
                 break;
        case 3:  updateValue();
                 break;
        case 4:  deleteValue();
                 break;
        case 5: System.out.println("���α׷��� �����մϴ�.");
                 break;
			}
		}
		
		// UpdateTest.Update(a,b,c,d);

		
	}
	
	static void insertValue() {

		System.out.println("�Է��� �̸��� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		Insert.insert( name);
		
	}
	static void deleteValue() {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �̸��� �Է��ϼ���.");
		String name = scan.nextLine();
		Delete.delete(name);
	}
	
	
	static void updateValue() {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �̸��� �Է��ϼ���.");
		String name = scan.nextLine();
		scan = new Scanner(System.in);
		System.out.println("�����ϰ� ���� �̸��� �Է��ϼ���.");
		String inputName = scan.nextLine();
		Update.update(name, inputName);
	}
}