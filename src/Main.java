import main.java.com.romeulima.order.domain.client.Client;
import main.java.com.romeulima.order.domain.order.Order;
import main.java.com.romeulima.order.domain.orderitem.OrderItem;
import main.java.com.romeulima.order.domain.product.Product;
import main.java.com.romeulima.order.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.next();
        System.out.print("Birth date (DD/MM/YYYY) : ");
        LocalDate clientBirthDate = LocalDate.parse(sc.next(), fmt);

        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
        System.out.print("How many items to this order? ");
        int itemsQuantity = sc.nextInt();

        Order order = new Order(LocalDateTime.now(), orderStatus, client);

        for (int i = 1; i <= itemsQuantity ; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem item = new OrderItem(quantity, productPrice, product);

            order.addItem(item);
        }

        System.out.println();
        System.out.println("ORDER SUMARY:");
        System.out.println(order);
    }
}