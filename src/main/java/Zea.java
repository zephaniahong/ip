import java.util.Scanner;

public class Zea {
    public static void main(String[] args) {
            String logo = "______________________\n"
                    + "Hello! I'm Zea\n"
                    + "What can I do for you?\n"
                    + "______________________\n";

            System.out.println(logo);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("bye")) {
                    System.out.println("----------------------");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("----------------------");
                    break;
                } else {
                    System.out.println("----------------------");
                    System.out.println(command);
                    System.out.println("----------------------");
                }
            }
    }
}
