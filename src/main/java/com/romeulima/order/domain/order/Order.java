package main.java.com.romeulima.order.domain.order;

import main.java.com.romeulima.order.domain.client.Client;
import main.java.com.romeulima.order.enums.OrderStatus;
import main.java.com.romeulima.order.domain.orderitem.OrderItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LocalDateTime moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem> items = new ArrayList<>();

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        this.items.add(item);
    }

    public void removeItem(OrderItem item){
        this.items.remove(item);
    }

    public Double total(){
        double sum = 0.0;

        for (OrderItem item : this.items){
            sum += item.subTotal();
        }

        return sum;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Order moment: ");
        builder.append(this.moment.format(fmt) + "\n");
        builder.append("Order status: ");
        builder.append(this.status + "\n");
        builder.append("Client: ");
        builder.append(this.client + "\n");
        builder.append("Order items:\n");

        for (OrderItem item : this.items){
            builder.append(item + "\n");
        }

        builder.append("Total price: $");
        builder.append(String.format("%.2f", this.total()));

        return builder.toString();
    }
}
