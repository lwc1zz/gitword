package ex1;
import java.util.Scanner;

public class PasswordManager {
	public static String encrypt(String password) {
        StringBuilder Password1 = new StringBuilder(password);
        for (int i = 0; i < Password1.length(); i++) {
            char c = (char) (Password1.charAt(i) + i + 1 + 3); // ASCII码加上位置和偏移值3
            Password1.setCharAt(i, c);
        }
        Password1 = Password1.reverse(); // 反转字符串
        char firstChar = Password1.charAt(0);
        char lastChar = Password1.charAt(Password1.length() - 1);
        Password1.setCharAt(0, lastChar); // 调换第一位和最后一位
        Password1.setCharAt(Password1.length() - 1, firstChar);
        return Password1.toString();
    }

    public static String decrypt(String encryptedPassword) {
        StringBuilder Password2 = new StringBuilder(encryptedPassword);
        char firstChar = Password2.charAt(0);
        char lastChar = Password2.charAt(Password2.length() - 1);
        Password2.setCharAt(0, lastChar); // 调换第一位和最后一位
        Password2.setCharAt(Password2.length() - 1, firstChar);
        Password2 = Password2.reverse(); // 反转字符串
        for (int i = 0; i < Password2.length(); i++) {
            char c = (char) (Password2.charAt(i) - i - 1 - 3); // 恢复原来的ASCII码
            Password2.setCharAt(i, c);
        }
        return Password2.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("密码管理系统");
            System.out.println("1. 加密");
            System.out.println("2. 解密");
            System.out.println("3. 退出");
            System.out.print("请选择功能：");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("请输入密码：");
                    String password = scanner.next();
                    String Password1 = encrypt(password);
                    System.out.println("加密后的密码：" + Password1);
                    break;
                case 2:
                    System.out.print("请输入加密后的密码：");
                    String encryptedPasswordInput = scanner.next();
                    String Password2 = decrypt(encryptedPasswordInput);
                    System.out.println("解密后的密码：" + Password2);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("无效的选择");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
    }


