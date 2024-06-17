package tasca3.n2exercici2;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<Restaurant> restaurants = new TreeSet<>();

        restaurants.add(new Restaurant("La Tagliatella", 9));
        restaurants.add(new Restaurant("La Tagliatella", 10));
        restaurants.add(new Restaurant("La Bella Napoli", 10));
        restaurants.add(new Restaurant("La Bella Napoli", 9));

        for (Restaurant restaurant : restaurants) {

            System.out.println(restaurant);

        }
    }
}
