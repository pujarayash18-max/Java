class Student7c {
    String name;
    int age;
    String grade;
    void getData(String n, int a, String g) {
        name = n;
        age = a;
        grade = g;
    }
    void printData() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------");
    }
    public static void main(String[] args) {
        Student7c s1 = new Student7c();
        Student7c s2 = new Student7c();
        s1.getData("Yash", 18, "A");
        s2.getData("Jash", 19, "B");
        s1.printData();
        s2.printData();
    }
}
