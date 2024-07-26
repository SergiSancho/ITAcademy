/*package flowershop.entities;

public class Product{

    protected int id;
    protected String name;
    protected double price;
    protected int stock;

    public Product(){
    }

    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //hash & equals

@Override
    public boolean equals(Object o) {
        if (this == o) {
           return true;
        }
        if (o == null || getClass() != o.getClass()){
           return  false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
*/
package flowershop.entities;

import java.util.Objects;

public class Product<ID> {

    protected ID id;
    protected String name;
    protected double price;
    protected int stock;

    public Product(){
    }

    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //hash & equals

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return  false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}