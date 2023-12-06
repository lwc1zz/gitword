package ex1;
import java.util.Scanner;
import java.util.Random;
/////////////////////lwc修改
public class PasswordManager {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	      boolean exit = false;
	        while (!exit) {
	            System.out.println("请选择操作：");
	            System.out.println("1. 加密密码");
	            System.out.println("2. 解密密码");
	            System.out.println("3. 判断密码强度");
	            System.out.println("4. 随机生成");
	            System.out.println("5. 退出");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // 读取换行符

	            switch (choice) {
	                case 1:
	                    System.out.println("请输入要加密的密码：");
	                    String plainPassword = scanner.nextLine();
	                    String encryptedPassword = encryptPassword(plainPassword);
	                    System.out.println("加密后的密码为：" + encryptedPassword);
	                    break;
	                case 2:
	                    System.out.println("请输入要解密的密码：");
	                    String encryptedPassword2 = scanner.nextLine();
	                    String decryptedPassword = decryptPassword(encryptedPassword2);
	                    System.out.println("解密后的密码为：" + decryptedPassword);
	                    break;
	                case 3:
	                    System.out.println("请输入要判断强度的密码：");
	                    String password = scanner.nextLine();
	                    String strength = checkPasswordStrength(password);
	                    System.out.println("密码强度为：" + strength);
	                    break;
	                case 4:
	                	System.out.println("请输入要生成密码的长度：");
	                    int passwordLength = scanner.nextInt();
	                    String generatedPassword = generatePassword(passwordLength);
	                    System.out.println("生成的密码为：" + generatedPassword);
	                    break;
	                    
	                case 5: exit = true;
                        System.out.println("已退出密码管理系统。");//
                    break;//
	                default:
	                   System.out.println("无效的选择！");//
	            }
	        }
}

	    // 加密密码功能
	    public static String encryptPassword(String password) {
	        char[] chars = password.toCharArray();
	        int offset = 3;
	        for (int i = 0; i < chars.length; i++) {
	            chars[i] = (char) (chars[i] + i + offset);
	        }
	        char temp = chars[0];
	        chars[0] = chars[chars.length - 1];
	        chars[chars.length - 1] = temp;
	        return new StringBuilder(new String(chars)).reverse().toString();
	    }

	    // 解密密码功能
	    public static String decryptPassword(String encryptedPassword) {
	        char[] chars = new StringBuilder(encryptedPassword).reverse().toString().toCharArray();
	        char temp = chars[0];
	        chars[0] = chars[chars.length - 1];
	        chars[chars.length - 1] = temp;
	        int offset = 3;
	        for (int i = 0; i < chars.length; i++) {
	            chars[i] = (char) (chars[i] - i - offset);
	        }
	        return new String(chars);
	    }

	    // 判断密码强度
	    public static String checkPasswordStrength(String password) {
	        int length = password.length();
	        boolean hasDigit = false;
	        boolean hasLowercase = false;
	        boolean hasUppercase = false;

	        for (char c : password.toCharArray()) {
	            if (Character.isDigit(c)) {
	                hasDigit = true;
	            } else if (Character.isLowerCase(c)) {
	                hasLowercase = true;
	            } else if (Character.isUpperCase(c)) {
	                hasUppercase = true;
	            }
	        }

	        if (length < 8 || (length >= 8 && !(hasDigit && (hasLowercase || hasUppercase)))) {
	            return "弱强度";
	        } else if (hasDigit && (hasLowercase || hasUppercase)) {
	            return "中强度";
	        } else if (hasDigit && hasLowercase && hasUppercase) {
	            return "高强度";
	        } else {
	            return "未知强度";
	        }
	    } 
	    public static String generatePassword(int length) {
	        StringBuilder password = new StringBuilder();
	        Random random = new Random();

	      
	        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	        for (int i = 0; i < length; i++) {
	            // 随机选择一个字符并添加到密码中
	            int index = random.nextInt(chars.length());
	            password.append(chars.charAt(index));
	        }

	        return password.toString();
}
}