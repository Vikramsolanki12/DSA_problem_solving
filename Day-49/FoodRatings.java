import java.util.*;

public class FoodRatings {
    private Map<String, TreeSet<Food>> cuisineMap = new HashMap<>();
    private Map<String, Food> foodMap = new HashMap<>();

    private class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);

            cuisineMap.putIfAbsent(cuisines[i], new TreeSet<>(
                    (a, b) -> a.rating == b.rating ? a.name.compareTo(b.name) : b.rating - a.rating
            ));

            cuisineMap.get(cuisines[i]).add(food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        Food food = foodMap.get(foodName);
        TreeSet<Food> set = cuisineMap.get(food.cuisine);
        set.remove(food);
        food.rating = newRating;
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }

    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        FoodRatings fr = new FoodRatings(foods, cuisines, ratings);
        System.out.println(fr.highestRated("korean"));
        System.out.println(fr.highestRated("japanese"));

        fr.changeRating("sushi", 16);
        System.out.println(fr.highestRated("japanese"));
    }
}
