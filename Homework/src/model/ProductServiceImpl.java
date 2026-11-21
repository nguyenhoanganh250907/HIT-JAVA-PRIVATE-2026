package model;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    List<Product> PSI = new ArrayList<>();
    @Override
    public void addProduct(Product product) {
        PSI.add(product);
    }

    @Override
    public Product findById(String id) {
        for (Product i : PSI){
            if (i.getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return null;
    }

    @Override
    public void printProducts() {
        for(int i = 0;i < PSI.size();i++){
            System.out.println(i + 1 + " | " + PSI.get(i));
        }
    }

}
