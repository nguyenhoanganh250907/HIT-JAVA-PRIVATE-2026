package model;

public class GeneralProduct extends Product{
    public GeneralProduct(String id, String name, double price, int stock) {
        super(id, name, price, stock);
    }

    @Override
    public boolean isExpensive() {
        if(getPrice() > 10000) return true;
        return false;
    }
}
