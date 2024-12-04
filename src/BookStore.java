import java.util.ArrayList;
import java.util.List;


// Класс для управления книгами и пользователями
class BookStore {
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    public void registerUser(String username, String password) {
        users.add(new User(username, password));
        System.out.println("Пользователь зарегистрирован: " + username);
    }

    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        System.out.println("Неверное имя пользователя или пароль.");
        return null;
    }

    public void addBook(String title, double price) {
        books.add(new Book(title, price));
    }

    public List<Book> getBooks() {
        return books;
    }
}

