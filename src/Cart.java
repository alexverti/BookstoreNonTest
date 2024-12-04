import java.util.ArrayList;
import java.util.List;

// Класс для представления корзины покупателя
class Cart {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showCart() {
        System.out.println("Ваша корзина:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + ": " + book.getPrice() + " руб.");
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total;
    }
}
