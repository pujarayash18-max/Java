 class Bird7e 
{
    String name;
    Bird7e(String name) 
    {
        this.name = name;
    }
    void display() 
    {
        System.out.println("Bird Name: " + name);
    }
    public static void main(String[] args) 
    {
        Bird7e bird1 = new Bird7e("Sparrow");
        Bird7e bird2 = new Bird7e("Peacock");
        Bird7e bird3 = new Bird7e("Parrot");
        bird1.display();
        bird2.display();
        bird3.display();
    }
}