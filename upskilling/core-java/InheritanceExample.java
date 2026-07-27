public class InheritanceExample {
    static class Animal {
        void makeSound() { System.out.println("Some generic sound"); }
    }

    static class Dog extends Animal {
        @Override
        void makeSound() { System.out.println("Bark"); }
    }

    public static void main(String[] args) {
        new Animal().makeSound();
        new Dog().makeSound();
    }
}