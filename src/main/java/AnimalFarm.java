import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class AnimalFarm {
    //В этом списке лежат данные по всем животным на ферме в виде двух слов, разделенных пробелом
    public ArrayList<String> farmAnimals;

    public AnimalFarm(ArrayList<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    //Формировать хеш-таблицу, в которой ключ — это вид животного (Animal),
    // а значение — количество животных этого вида на ферме.
    public HashMap<String, Integer> countedAnimals() {
        HashMap<String, Integer> farmAnimalsCount = new HashMap<>();
        for (String farmAnimal : farmAnimals) {
            String[] split = farmAnimal.split(" ");
            try {
                //Проверим, что содержит первым словом валидный вид животного
                Animal.valueOf(split[0]);
                if (farmAnimalsCount.containsKey(split[0])) {
                    farmAnimalsCount.put(split[0], farmAnimalsCount.get(split[0]) + 1);
                } else {
                    farmAnimalsCount.put(split[0], 1);
                }
            } catch (IllegalArgumentException exception) {
                System.out.printf("Please correct string %s. Incorrect input data.", farmAnimal);
            }
        }
        return farmAnimalsCount;
    }

    //Возвращаeт коллекцию всех уникальных имён животных на ферме
    public HashSet<String> uniqueNames() {
        HashSet<String> farmAnimalsName = new HashSet<>();
        for (String farmAnimal : farmAnimals) {
            String[] split = farmAnimal.split(" ");
            try {
                farmAnimalsName.add(split[1]);
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.printf("Please correct string %s. Incorrect input data.", farmAnimal);
            }
        }
        return farmAnimalsName;
    }

    //Добавления нового животного на ферму:
    //по переданному виду животного и имени;
    public void add(Animal vidAnimal, String nameAnimal) {
        farmAnimals.add(String.format("%s %s", vidAnimal.name(), nameAnimal));
    }

    //по переданному виду животного ;
    public void add(Animal vidAnimal) {
        farmAnimals.add(String.format("%s N", vidAnimal.name()));
    }

    //по переданному имени животного.
    public void add(String nameAnimal) {
        farmAnimals.add(String.format("NOT_DEFINED %s", nameAnimal));
    }

    @Override
    public String toString() {
        String animals = "";
        for (String farmAnimal : farmAnimals) {
            animals = animals + farmAnimal + "\n";

        }
        return animals;
    }
}
