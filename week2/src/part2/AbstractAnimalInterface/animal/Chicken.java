package part2.AbstractAnimalInterface.animal;

import part2.AbstractAnimalInterface.edible.Edible;

public class Chicken extends Animal implements Edible {
    public Chicken(){}

    @Override public String makeSound(){
        return "Chicken: cluck-cluck!";
    }

    @Override public String howToEat(){
           return "Could be fried";
    }
}
