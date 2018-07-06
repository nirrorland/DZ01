import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        if (args.length > 0) {

            String[] inputStrings = new String[10];
            int j = enterStrings(inputStrings);

            printStrings(args, inputStrings, j);

        } else {
            System.out.println("Нет аргументов");
        }
    }

    private static void printStrings(String[] args, String[] inputStrings, int j) {
       if (!(inputStrings.length==0)) {
           System.out.println("Выводим строки:");
           for (int i = 0; i < j; i++) {

               if (stringMatches(inputStrings[i], args)) {
                   System.out.println(inputStrings[i]);
               }

           }
       } else System.out.println("нет введённых строк");
    }

    private static boolean stringMatches(String string, String[] args) {
        boolean result = false;
        String temp = string;

        for (int i=0;i<args.length;i++) {

            if (args[i].startsWith("regex=")) {

                String regex = args[i].replace("regex=", "");
                //System.out.println("finding regex " + regex);
                if (string.matches(regex)) {
                    result = true;
                }

            } else if (temp.toLowerCase().contains(args[i].toLowerCase())) {
                result = true;
            }
        }
        return result;
    }

    private static int enterStrings(String[] inputStrings) {
        Scanner userScanner = new Scanner(System.in);

        System.out.println("Введите строки (максимум 10 строк, для прекращения введите :end)");

        String temp = "";
        int j = 0;

        out_loop:
        for (int i = 0; i < 10; i++) {
            System.out.println("Введите строку " + Integer.toString(i + 1) + ": ");
            temp = userScanner.next();

            if (temp.equals(":end")) {
                break out_loop;
            }
            inputStrings[i] = temp;
            j++;
        }
        System.out.println("Ввод завершён");
        return j;
    }



}

