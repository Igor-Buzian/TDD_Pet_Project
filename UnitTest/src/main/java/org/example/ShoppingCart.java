package org.example;

import org.example.discount.IOffer;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList = new ArrayList<>();
    private double totalCartValue;
    private IOffer offer;

    public int getProductCount() {
        return productList.size();
    }

    public double totalCartValue()
    {
        if(productList.size()>0){
            for(Product product : productList){
                totalCartValue += product.getTotalPrice();
            }
            return totalCartValue;
        }
        return 0;
    }

    public void addProduct(Product product){
       if(offer!=null){
           offer.applyOffer(product);
       }
        productList.add(product);
    }

    public Product getProductByName(String name)
    {
        if(productList.size()>0)
        {
            for(Product product : productList)
            {
                if(product.getProductName().equals(name)){
                    return product;
                }
            }
        }
        return null;
    }

    public void setOffer(IOffer offer) {
        this.offer = offer;
    }
}
