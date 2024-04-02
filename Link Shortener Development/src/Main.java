import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Link Shortener Application!");

        Scanner scanner = new Scanner(System.in);
        LinkShortener linkShortener = new LinkShortener();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the long URL to shorten: ");
                    String longUrl = scanner.next();
                    try {
                        String shortUrl = linkShortener.shorten(longUrl);
                        System.out.println("Short URL: " + shortUrl);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter the short URL to expand: ");
                    String shortUrl = scanner.next();
                    try {
                        String expandedUrl = linkShortener.expand(shortUrl);
                        System.out.println("Expanded URL: " + expandedUrl);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
