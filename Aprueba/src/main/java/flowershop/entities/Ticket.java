/*package flowershop.entities;

import java.time.LocalDate;
import java.util.HashMap;

public class Ticket {

    private int idTicket;
    private HashMap<Product, Integer> saleProducts;
    private LocalDate saleDate;
    private double saleTotal;

    public Ticket(){
        this.saleDate = LocalDate.now();
    }

    public Ticket(HashMap<Product, Integer> saleProducts, double saleTotal){
        this.saleProducts = saleProducts;
        this.saleTotal = saleTotal;
        this.saleDate = LocalDate.now();
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public HashMap<Product, Integer> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(HashMap<Product, Integer> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public double getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(double saleTotal) {
        this.saleTotal = saleTotal;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = LocalDate.now;
    }

    //hash&equals
}
*/
package flowershop.entities;

import java.time.LocalDate;
import java.util.HashMap;

public class Ticket<ID> {

    private ID idTicket;
    private HashMap<Product<ID>, Integer> saleProducts;
    private LocalDate saleDate;
    private double saleTotal;

    public Ticket(){
    }

    public Ticket(HashMap<Product<ID>, Integer> saleProducts, double saleTotal){
        this.saleProducts = saleProducts;
        this.saleTotal = saleTotal;
    }

    public ID getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(ID idTicket) {
        this.idTicket = idTicket;
    }

    public HashMap<Product<ID>, Integer> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(HashMap<Product<ID>, Integer> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public double getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(double saleTotal) {
        this.saleTotal = saleTotal;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    //hash&equals
}