public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Dog dog = new Dog();
        Cat cat = new Cat();
        Lion lion = new Lion();
        Cat[] cats = { cat, lion };
        for (Cat c : cats) {
            c.makeSound();
        }
    }
}

interface AnimalSound {
    void makeSound();

    void eat();

    void hunt();
}

class Animal implements AnimalSound {
    public Animal() {

    }

    public void makeSound() {
        System.out.println("???");
    }

    public void eat() {
        System.out.println("Eating");
    }

    public void hunt() {
        System.out.println("Hunting???");
    }
}

class Dog {
    public Dog() {

    }

    public void makeSound() {
        System.out.println("Woof");
    }

    public void hunt() {
        System.out.println("What do you mean by hunt? I'm a dog");
    }
}

class Cat {
    public Cat() {

    }

    public void makeSound() {
        System.out.println("Meow");
    }

    public void hunt() {
        System.out.println("What do you mean by hunt? I'm a cat");
    }
}

class Lion extends Cat {
    public Lion() {
        super();
    }

    public void makeSound() {
        System.out.println("Roar");
    }

    public void hunt() {
        System.out.println("Hunting");
    }
}

class Tiger extends Cat {
    public Tiger() {
        super();
    }

    public void makeSound() {
        System.out.println("Growl");
    }

    public void hunt() {
        System.out.println("Hunting");
    }
}
