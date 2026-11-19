package com.pluralsight.finance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        assets = new ArrayList<>();
    }

    public void add(Valuable asset){
        assets.add(asset);
    }

    public BigDecimal getValue(){
        BigDecimal total = new BigDecimal("0");
        for (Valuable asset : assets){
            if (asset instanceof CreditCard){
                total = total.subtract(asset.getValue());
            }
            else {
                total = total.add(asset.getValue());
            }
        }
        return total;
    }
}
