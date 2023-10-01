package BaseConverter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Convert {
    // the same Scanner object can be used in the entire code
    static Scanner scanner = new Scanner(System.in);
    
    // ASK BASE
    public static void askBase() {
        String base;
        boolean opt = true;
        while(opt) {
            System.out.print("\nWhat is the primary base of the number?\n1 - Binary\n2 - Octal\n3 - Decimal\n4 - Hexadecimal\n5 - Stop\nOption: ");
            base = scanner.nextLine();
            switch(base) {
                case "1":
                    checkBinary();
                    break;
                case "2":
                    checkOctal();
                    break;
                case "3":
                    checkDecimal();
                    break;
                case "4":
                    checkHexadecimal();
                    break;
                case "5":
                    opt = false;
                    break;
                default: 
                    System.out.println("Invalid. Try again");
                    break;
            }
        }
    }

    // BINARY
    public static void checkBinary() {
        while (true) {
            System.out.print("Number: ");
            String num = scanner.nextLine();
    
            Pattern patternHex = Pattern.compile("^[0-1]+$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = patternHex.matcher(num);
    
            if (matcher.find()) {
                convert(num, 2);
                break;
            } else {
                System.out.println("It's not binary. Please try again.");
            }
        }
    }

    // OCTAL 
    public static void checkOctal() {
        while (true) {
            System.out.print("Number: ");
            String num = scanner.nextLine();
    
            Pattern patternHex = Pattern.compile("^[0-7]+$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = patternHex.matcher(num);
    
            if (matcher.find()) {
                convert(num, 8);
                break;
            } else {
                System.out.println("It's not octal. Please try again.");
            }
        }
    }

    // DECIMAL 
    public static void checkDecimal() {
        while (true) {
            System.out.print("Number: ");
            String num = scanner.nextLine();
    
            Pattern patternHex = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = patternHex.matcher(num);
    
            if (matcher.find()) {
                convert(num, 10);
                break;
            } else {
                System.out.println("It's not decimal. Please try again.");
            }
        }
    }

    // HEXADECIMAL
    public static void checkHexadecimal() {
        while (true) {
            System.out.print("Number: ");
            String num = scanner.nextLine();
    
            Pattern patternHex = Pattern.compile("^[0-9a-fA-F]+$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = patternHex.matcher(num);
    
            if (matcher.find()) {
                convert(num, 16);
                break;
            } else {
                System.out.println("It's not hexadecimal. Please try again.");
            }
        }
    }

    // OPERATIONS
    public static void convert(String num, int base) {
        switch(base) {
            case 2:
                System.out.println("Binary: " + num + "\n" + 
                "Octal: " + Integer.toOctalString(Integer.parseInt(num, 2)) + "\n" + "Decimal: " + Integer.parseInt(num, 2) + "\n" + "Hexadecimal: " + Integer.toHexString(Integer.parseInt(num, 2)).toUpperCase());;
                break;

            case 8:
                System.out.println("Binary: " + Integer.toBinaryString(Integer.parseInt(num, 8)) + "\n" + 
                "Octal: " + num + "\n" + "Decimal: " + Integer.parseInt(num, 8) + "\n" + "Hexadecimal: " + Integer.toHexString(Integer.parseInt(num, 8)).toUpperCase());;
                break;

            case 10:
                System.out.println("Binary: " + Integer.toBinaryString(Integer.parseInt(num, 10)) + "\n" + 
                "Octal: " + Integer.toOctalString(Integer.parseInt(num, 10)) + "\n" + "Decimal: " + num + "\n" + "Hexadecimal: " + Integer.toHexString(Integer.parseInt(num, 10)).toUpperCase());;
                break;

            case 16:
                // When we want to pass hexadecimal into decimal, we should use an= Big Int. Integer.parseInt() doesnt accept F as hexadecimal number, for example 
                System.out.println("Binary: " + Integer.toBinaryString(Integer.parseInt(num, 16)) + "\n" + 
                "Octal: " + Integer.toOctalString(Integer.parseInt(num, 16)) + "\n" + "Decimal: " + new BigInteger(num, 16).toString() + "\n" + "Hexadecimal: " + num.toUpperCase());
                break;
        }
    }
}