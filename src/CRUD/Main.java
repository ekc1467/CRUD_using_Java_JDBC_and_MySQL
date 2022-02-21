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
		System.out.println("메뉴 선택");
		System.out.println("1. C");
		System.out.println("2. R");
		System.out.println("3. U");
		System.out.println("4. D");
		System.out.println("5. 종료");
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
        case 5: System.out.println("프로그램을 종료합니다.");
                 break;
			}
		}
		
		// UpdateTest.Update(a,b,c,d);

		
	}
	
	static void insertValue() {

		System.out.println("입력할 이름을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		Insert.insert( name);
		
	}
	static void deleteValue() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요.");
		String name = scan.nextLine();
		Delete.delete(name);
	}
	
	
	static void updateValue() {
		Scanner scan = new Scanner(System.in);
		System.out.println("변경할 이름을 입력하세요.");
		String name = scan.nextLine();
		scan = new Scanner(System.in);
		System.out.println("변경하고 싶은 이름을 입력하세요.");
		String inputName = scan.nextLine();
		Update.update(name, inputName);
	}
}