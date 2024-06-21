import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> farmAnimals = new ArrayList<>();
        AnimalFarm animalFarm = new AnimalFarm(farmAnimals);
        animalFarm.add(Animal.DOG, "Шарик");
        animalFarm.add(Animal.DOG, "Мухтар");
        animalFarm.add(Animal.DOG, "Айза");
        animalFarm.add(Animal.CAT, "Вася");
        animalFarm.add(Animal.CAT, "Кузя");
        animalFarm.add("Кузя");
        animalFarm.add(Animal.HORSE);
        HashSet<String> uniqueNames = new HashSet<>();
        uniqueNames = animalFarm.uniqueNames();
        HashMap<String, Integer> countedAnimals = new HashMap<>();
        countedAnimals = animalFarm.countedAnimals();

        System.out.println(uniqueNames);
        System.out.println(countedAnimals);
        System.out.println(animalFarm.toString());

    }
}