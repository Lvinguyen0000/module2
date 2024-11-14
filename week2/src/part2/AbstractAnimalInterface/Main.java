package part2.AbstractAnimalInterface;

import part2.AbstractAnimalInterface.animal.Animal;
import part2.AbstractAnimalInterface.animal.Chicken;
import part2.AbstractAnimalInterface.animal.Tiger;
import part2.AbstractAnimalInterface.edible.Edible;
import part2.AbstractAnimalInterface.fruit.Apple;
import part2.AbstractAnimalInterface.fruit.Fruit;
import part2.AbstractAnimalInterface.fruit.Orange;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
