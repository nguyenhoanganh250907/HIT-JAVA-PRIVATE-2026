package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrderServiceImpl implements OrderService{
    List<Order> OSI = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    @Override
    public void addOrder(Order order) {
        OSI.add(order);
    }

    @Override
    public void printOrders() {
        System.out.println("============Giỏ hàng============");
        if (OSI.isEmpty()){
            System.out.println("Giỏ hàng đang trống.");
        }else {
            System.out.println(OSI.get(0).getCustomer());
            for (int i = 0;i < OSI.size();i++){
                System.out.printf("%d | Id đơn hàng: %s| Id sản phẩm: %s | Sản phẩm: %s| Giá: %.2f | Số lượng: %d | Thành tiền: %.2f\n",
                        i + 1,OSI.get(i).getId(),OSI.get(i).getProduct().getId(),OSI.get(i).getProduct().getName(),OSI.get(i).getProduct().getPrice(),
                        OSI.get(i).getQuantity(),OSI.get(i).getProduct().getPrice()* OSI.get(i).getQuantity());
            }
        }
    }

    @Override
    public void updateOrder(String id) {
        System.out.print("Nhập số lượng mới: ");
        int newQuantity = Integer.parseInt(sc.nextLine());
        if (newQuantity <= 0) {
            System.out.println("Số lượng cần lớn hơn 0");
            return;
        }
        for (int i = 0;i < OSI.size();i++){
            if (OSI.get(i).getId().equalsIgnoreCase(id)){
                OSI.get(i).setQuantity(newQuantity);
            }
        }
        printOrders();
    }

    @Override
    public void deleteOrder(String id) {
        printOrders();
        for (int i = 0;i < OSI.size();i++) {
            if (OSI.get(i).getProduct().getId().equalsIgnoreCase(id)) {
                OSI.remove(i);
            }
        }
    }

    public List<Order> getOrder(){
        return OSI;
    }
}
