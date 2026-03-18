abstract class A {
    public abstract void display();
    public void methodA() {
        System.out.println("This is a method from class A");
    }
}
class B extends A {
    public void display() {
        System.out.println("call me from B");
    }
    public void methodB() {
        System.out.println("This is a method from class B");
    }
}
public class AbstractClass8a {
    public static void main(String[] args) {
        B obj = new B();
        obj.display();
    }
}