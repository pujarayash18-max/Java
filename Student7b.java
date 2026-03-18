class Student7b {
    String name;
    String city;
    int age;
    public Student7b(String name, String city, int age) 
    {
        this.name = name;
        this.city = city;
        this.age = age;
    }
    public void printData()
    {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Age: " + age);
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Student7b s1 = new Student7b("Yash", "Rajkot", 18);
        Student7b s2 = new Student7b("Jash", "Surat", 19);
        s1.printData();
        s2.printData();
    }
}