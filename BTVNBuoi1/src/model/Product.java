package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;
    private static int count;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        count++;
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static int getCount(){
        return count;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name không được rỗng.");
        } else {
            this.name = name;
        }
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.out.println("Price phải lớn hơn 0.");
        } else {
            this.price = price;
        }
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Stock không được âm.");
        } else {
            this.stock = stock;
        }
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | " + " Tồn: " + stock;
    }

}
