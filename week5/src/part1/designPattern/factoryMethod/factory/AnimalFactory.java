package part1.designPattern.factoryMethod.factory;

import part1.designPattern.factoryMethod.animal.Animal;
import part1.designPattern.factoryMethod.animal.Cat;
import part1.designPattern.factoryMethod.animal.Dog;

public class AnimalFactory {
    public Animal getAnimal(String type) {
        if ("canine".equals(type)) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
