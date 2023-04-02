import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Product {
    int profit, weight;
    int ratio;

    public Product(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
        this.ratio = profit / weight;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "Product [profit=" + profit + ", weight=" + weight + ", ratio=" + ratio + "]";
    }
}

class CompareByRatio implements Comparator<Product> {
    public int compare(Product a, Product b) {
        if(a.ratio > b.ratio) {
            return a.ratio;
        } else {
            return b.ratio;
        }
    }
}

public class KnapsackGreedy {
    public static void main(String[] args) {
        int capacity = 60;
        int remaining = 60;
        int totalProfit = 0;

        ArrayList<Product> list = new ArrayList<>();

        Product p1 = new Product(280, 40);
        Product p2 = new Product(100, 10);
        Product p3 = new Product(120, 20);
        Product p4 = new Product(120, 24);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Collections.sort(list, new CompareByRatio());

        for(int i = 0; i < list.size() && capacity > 0; i++) {
            Product product = list.get(i);

            if(remaining - product.weight >= 0) {
                remaining = capacity - product.weight;
                capacity -= product.weight;  
                totalProfit += product.profit;
            } else if (remaining - product.weight < 0) {
                capacity -= remaining;
                totalProfit += (remaining * product.profit) / product.weight;
            }
        }

        System.out.println(totalProfit);
    }
}