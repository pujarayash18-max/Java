class Student7d 
{
    int id;
    String name;
    Student7d(int id, String name) 
    {
        this.id = id;
        this.name = name;
    }
    void display() 
    {
        System.out.println("ID: " + id + ", Name: " + name);
    }
    public static void main(String[] args) {
        Student7d obj1 = new Student7d(101, "Yash");
        Student7d obj2 = new Student7d(102, "Jash");
        obj1.display();
        obj2.display();
    }
}