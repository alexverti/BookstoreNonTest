import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore store = new BookStore();
        Cart cart = new Cart();

        // Добавление книг в магазин
        store.addBook("Java Programming", 500);
        store.addBook("Effective Java", 600);
        store.addBook("Head First Java", 450);

        // Регистрация пользователя
        System.out.print("Введите имя пользователя для регистрации: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        store.registerUser(username, password);

        // Вход пользователя
        System.out.print("Введите имя пользователя для входа: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String loginPassword = scanner.nextLine();
        User user = store.loginUser(loginUsername, loginPassword);

        if (user != null) {
            boolean shopping = true;

            while (shopping) {
                System.out.println("\nДоступные книги:");
                for (int i = 0; i < store.getBooks().size(); i++) {
                    Book book = store.getBooks().get(i);
                    System.out.println((i + 1) + ". " + book.getTitle() + ": " + book.getPrice() + " руб.");
                }

                System.out.print("Введите номер книги для добавления в корзину (или 0 для завершения): ");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    shopping = false;
                } else if (choice > 0 && choice <= store.getBooks().size()) {
                    cart.addBook(store.getBooks().get(choice - 1));
                    System.out.println("Книга добавлена в корзину.");
                } else {
                    System.out.println("Неверный выбор.");
                }
            }

            // Показать корзину и общую стоимость
            cart.showCart();
            System.out.println("Общая стоимость: " + cart.getTotalPrice() + " руб.");
        }

        scanner.close();
    }
}