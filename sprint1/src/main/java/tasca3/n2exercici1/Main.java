package tasca3.n2exercici1;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Restaurant> restaurants = new HashSet<>();

        restaurants.add(new Restaurant("La Tagliatella", 10));
        restaurants.add(new Restaurant("La Tagliatella", 10));
        restaurants.add(new Restaurant("La Tagliatella", 9));
        restaurants.add(new Restaurant("La Bella Napoli", 10));

        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }
}
