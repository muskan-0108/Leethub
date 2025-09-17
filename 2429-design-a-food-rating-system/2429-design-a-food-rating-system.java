import java.util.*;

class FoodRatings {
    // food → rating
    private Map<String, Integer> ratingMap;
    // food → cuisine
    private Map<String, String> cuisineMap;
    // cuisine → TreeSet of foods (ordered by rating desc, then lexicographic asc)
    private Map<String, TreeSet<Food>> cuisineFoods;

    // Food object for TreeSet
    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        // comparator is defined in TreeSet, but equals & hashCode are needed for remove()
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Food)) return false;
            Food f = (Food) o;
            return rating == f.rating && name.equals(f.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, rating);
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        ratingMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        cuisineFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            ratingMap.put(food, rating);
            cuisineMap.put(food, cuisine);

            cuisineFoods.putIfAbsent(cuisine, new TreeSet<>(
                (a, b) -> {
                    if (a.rating != b.rating) {
                        return b.rating - a.rating; // higher rating first
                    }
                    return a.name.compareTo(b.name); // tie → lexicographically smaller first
                }
            ));

            cuisineFoods.get(cuisine).add(new Food(food, rating));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = cuisineMap.get(food);
        int oldRating = ratingMap.get(food);

        // Remove old entry
        cuisineFoods.get(cuisine).remove(new Food(food, oldRating));

        // Insert new entry
        cuisineFoods.get(cuisine).add(new Food(food, newRating));

        // Update rating map
        ratingMap.put(food, newRating);
    }
    
    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
