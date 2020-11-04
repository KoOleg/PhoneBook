import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {

    private static ArrayList array_contact = new ArrayList();
    private static ArrayList array_phone = new ArrayList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = formatName(scanner.nextLine());
        while (!name.equals("c")) {
            int index = checkName(name);
            if (index == -1) {
                System.out.println("Введите телефон");
                String phone = scanner.nextLine();
                while (!correctPhone(phone)) {
                    System.out.println("Enter correct phone");
                    phone = scanner.nextLine();
                }
                array_phone.add(formatPhone(phone));
                array_contact.add(name);
            }
            index = array_contact.indexOf(name);
            System.out.println(array_contact.get(index) + ":" + array_phone.get(index));
            name = formatName(scanner.nextLine());
        }

    }

    public static String formatName(String name) {
        String[] nameSplit = name.toLowerCase().trim().split(" ");
        String formatName = "";
        if (name.equals("c")) return name;
        for (String i : nameSplit) {
            formatName += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        }
        return formatName;
    }

    public static int checkName(String name) {
        int resut = array_contact.indexOf(name);
        return resut;
    }

    private static boolean correctPhone(String phone) {
        Boolean result = phone.replaceAll("[^0-9]", "").length() == 11;
        return result;
    }

    public static String formatPhone(String phone) {
        String clean = phone.replaceAll("[^0-9]", "");
        String finalPhone = "";
        finalPhone = "+7 " + clean.substring(1, 4) + " " + clean.substring(4, 7);
        finalPhone += " " + clean.substring(7, 9) + " " + clean.substring(9);
        return finalPhone;
    }
}
