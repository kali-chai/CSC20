public class Zoo {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

class Animal {
    private int age;
    private String name;
    private String color;

    public Animal(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
