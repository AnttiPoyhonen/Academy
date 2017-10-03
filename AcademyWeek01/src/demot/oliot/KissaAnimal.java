package demot.oliot;

public class KissaAnimal {
    public static void main(String args[]) {
        Animal cat = new Cat(true, 4, "Kissa");
        Object obj = cat;
        System.out.println(obj.equals(cat));
    }
}

class Animal {
    boolean mammal;
    int numberOfEyes;

    public Animal(boolean mammal, int numberOfEyes) {
        this.mammal = mammal;
        this.numberOfEyes = numberOfEyes;
    }
}

class Cat extends Animal {
    String name;

    public Cat(boolean mammal, int numberOfEyes, String name) {
        super(mammal, numberOfEyes);
        this.name = name;
    }

    public Cat(boolean mammal, int numberOfEyes){
        this(mammal, numberOfEyes, null);
    }
}