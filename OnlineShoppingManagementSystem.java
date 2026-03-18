import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

abstract class User {
    String firstName, surname, emailOrPhone, password;
    String addressLine, state, city, country;
    int pincode;
    int otp;

    User(String firstName, String surname, String emailOrPhone, String password,
    String addressLine, String state, String city, String country, int pincode, int otp) {
        this.firstName = firstName;
        this.surname = surname;
        this.emailOrPhone = emailOrPhone;
        this.password = password;
        this.addressLine = addressLine;
        this.state = state;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
        this.otp = otp;
    }

    abstract void displayRole();

    String getFullAddress() {
        return addressLine + ", " + city + ", " + state + ", " + country + " - " + pincode;
    }
}

class Customer extends User {
    Customer(String firstName, String surname, String emailOrPhone, String password,
    String addressLine, String state, String city, String country, int pincode, int otp) {
        super(firstName, surname, emailOrPhone, password, addressLine, state, city, country, pincode, otp);
    }

    @Override
    void displayRole() {
        System.out.println("Role: Customer");
    }
}

class Seller extends User {
    Seller(String firstName, String surname, String emailOrPhone, String password,
    String addressLine, String state, String city, String country, int pincode, int otp) {
        super(firstName, surname, emailOrPhone, password, addressLine, state, city, country, pincode, otp);
    }

    @Override
    void displayRole() {
        System.out.println("Role: Seller");
    }
}

class Product {
    String name, category;
    double price;
    int quantity;

    Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

class ReviewSystem {
    ArrayList<String> reviews = new ArrayList<>();

    void addReview(String review) {
        reviews.add(review);
        System.out.println("Review added!");
    }

    void viewReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews available.");
        } else {
            System.out.println("Customer Reviews:");
            for (String review : reviews) {
                System.out.println("- " + review);
            }
        }
    }
}

class Order {
    String orderId;
    LocalDateTime paymentTime;

    Order() {
        paymentTime = LocalDateTime.now();
        orderId = paymentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    String getDeliveryStatus() {
        Duration duration = Duration.between(paymentTime, LocalDateTime.now());
        long hours = duration.toHours();
        if (hours < 24) return "Preparing";
        else if (hours < 36) return "On Route";
        else return "Delivered";
    }
}

abstract class PaymentMethod {
    abstract boolean pay(double total, Scanner sc);

    protected boolean processPayment(double total, Scanner sc) {
        System.out.printf("Your bill: Rs.%.2f\n", total);
        System.out.print("Enter amount: ");
        double paid = sc.nextDouble();
        if (paid >= total) {
            System.out.println("Payment successful!");
            if (paid > total) {
                System.out.printf("Change: Rs.%.2f\n", paid - total);
            }
            return true;
        } else {
            System.out.println("Insufficient amount!");
            return false;
        }
    }
}

class UPIPayment extends PaymentMethod {
    @Override
    boolean pay(double total, Scanner sc) {
        System.out.print("Enter UPI ID: ");
        sc.next();
        return processPayment(total, sc);
    }
}

class CardPayment extends PaymentMethod {
    @Override
    boolean pay(double total, Scanner sc) {
        System.out.print("Enter Card Number (16 digits): ");
        String cardNum = sc.next();
        while (!cardNum.matches("\\d{16}")) {
            System.out.println("Invalid Card Number! Try again.");
            cardNum = sc.next();
        }
        System.out.print("Enter Expiry Date (MM/YY): ");
        String expiry = sc.next();
        while (!expiry.matches("(0[1-9]|1[0-2])/\\d{2}")) {
            System.out.println("Invalid Expiry Date! Try again.");
            expiry = sc.next();
        }
        System.out.print("Enter CVV (3 digits): ");
        String cvv = sc.next();
        while (!cvv.matches("\\d{3}")) {
            System.out.println("Invalid CVV! Try again.");
            cvv = sc.next();
        }
        return processPayment(total, sc);
    }
}

class CashPayment extends PaymentMethod {
    @Override
    boolean pay(double total, Scanner sc) {
        System.out.println("Processing cash payment...");
        return processPayment(total, sc);
    }
}

public class OnlineShoppingManagementSystem {
    static boolean isStrongPassword(String password) {
        return password.length() >= 8 &&
        password.matches(".*[A-Z].*") &&
        password.matches(".*[a-z].*") &&
        password.matches(".*[0-9].*") &&
        password.matches(".*[!@#$%^&*()].*");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<CartItem> cart = new ArrayList<>();
        ReviewSystem reviewSystem = new ReviewSystem();
        Random rand = new Random();

        // Sample Products
        products.add(new Product("Laptop", "Electronics", 54000, 5));
        products.add(new Product("Smartphone", "Electronics", 22500, 10));
        products.add(new Product("Fiction Book", "Books", 380, 15));
        products.add(new Product("Cookware", "Home Appliances", 1425, 20));
        products.add(new Product("Harry Potter", "Books", 225, 8));

        while (true) {
            System.out.println("\n1. Sign Up\n2. Log In\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Email/Phone: ");
                String emailOrPhone = sc.nextLine();
                boolean userExists = users.stream().anyMatch(u -> u.emailOrPhone.equals(emailOrPhone));

                if (userExists) {
                    System.out.println("Already registered!");
                } else {
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();
                    while (!isStrongPassword(password)) {
                        System.out.println("Weak Password! Try again.");
                        password = sc.nextLine();
                    }
                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Surname: ");
                    String surname = sc.nextLine();
                    System.out.print("City: ");
                    String city = sc.nextLine();
                    System.out.print("State: ");
                    String state = sc.nextLine();
                    System.out.print("Country: ");
                    String country = sc.nextLine();
                    System.out.print("Address (House No, Street, etc.): ");
                    String addressLine = sc.nextLine();
                    System.out.print("Pincode: ");
                    int pincode = sc.nextInt();

                    int otp = rand.nextInt(900000) + 100000;
                    System.out.println("Your OTP: " + otp);

                    users.add(new Customer(firstName, surname, emailOrPhone, password,
                            addressLine, state, city, country, pincode, otp));
                    System.out.println("Registered Successfully!");
                }

            } else if (choice == 2) {
                System.out.print("Enter Email/Phone: ");
                String emailOrPhone = sc.nextLine();
                User currentUser = users.stream()
                    .filter(u -> u.emailOrPhone.equals(emailOrPhone))
                    .findFirst().orElse(null);

                if (currentUser == null) {
                    System.out.println("User not found!");
                } else {
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();
                    if (currentUser.password.equals(password)) {
                        System.out.print("Enter OTP: ");
                        int otp = sc.nextInt();
                        sc.nextLine();
                        if (currentUser.otp == otp) {
                            currentUser.displayRole();
                            System.out.println("Welcome " + currentUser.firstName);
                            boolean loggedIn = true;

                            while (loggedIn) {
                                System.out.println("\n1. Seller Section\n2. Customer Section\n3. Logout");
                                int section = sc.nextInt();
                                sc.nextLine();

                                if (section == 1) {
                                    System.out.println("Seller Section:\n1. Add Product\n2. Exit Seller Section");
                                    int sellerChoice = sc.nextInt();
                                    sc.nextLine();
                                    if (sellerChoice == 1) {
                                        System.out.println("Existing Categories:");
                                        products.stream()
                                        .map(p -> p.category)
                                        .distinct()
                                        .forEach(cat -> System.out.println("- " + cat));
                                        System.out.print("Enter Category: ");
                                        String category = sc.nextLine();
                                        System.out.print("Product Name: ");
                                        String name = sc.nextLine();
                                        System.out.print("Price: ");
                                        double price = sc.nextDouble();
                                        System.out.print("Quantity: ");
                                        int quantity = sc.nextInt();
                                        products.add(new Product(name, category, price, quantity));
                                        System.out.println("Product Added Successfully!");
                                    }

                                } else if (section == 2) {
                                    boolean customerActive = true;
                                    while (customerActive) {
                                        System.out.println("\nCustomer Section:\n1. View Products\n2. Add to Cart\n3. View Cart\n4. Remove from Cart\n5. Pay\n6. Write Review\n7. View Reviews\n8. Back");
                                        int customerChoice = sc.nextInt();
                                        sc.nextLine();

                                        switch (customerChoice) {
                                            case 1 -> products.forEach(p -> System.out.println(p.name + " - " + p.category + " - Rs." + p.price + " - Qty: " + p.quantity));
                                            case 2 -> {
                                                    products.stream().filter(p -> p.quantity > 0)
                                                    .forEach(p -> System.out.println("- " + p.name + " (" + p.category + ") - Rs." + p.price + " - Qty: " + p.quantity));
                                                    System.out.print("Enter Product Name to Add: ");
                                                    String pname = sc.nextLine();
                                                    Optional<Product> found = products.stream()
                                                        .filter(p -> p.name.equalsIgnoreCase(pname) && p.quantity > 0)
                                                        .findFirst();
                                                    if (found.isPresent()) {
                                                        Product p = found.get();
                                                        cart.add(new CartItem(p, 1));
                                                        p.quantity--;
                                                        System.out.println("Added to Cart!");
                                                    } else {
                                                        System.out.println("Product not found or out of stock!");
                                                    }
                                                }
                                            case 3 -> {
                                                    double total = 0;
                                                    for (CartItem c : cart) {
                                                        System.out.println(c.product.name + " - Rs." + c.product.price);
                                                        total += c.product.price;
                                                    }
                                                    System.out.printf("Total: Rs.%.2f\n", total);
                                                }
                                            case 4 -> {
                                                    if (cart.isEmpty()) {
                                                        System.out.println("Cart is Empty!");
                                                        break;
                                                    }
                                                    for (int i = 0; i < cart.size(); i++) {
                                                        System.out.println((i + 1) + ". " + cart.get(i).product.name);
                                                    }
                                                    System.out.print("Enter product number to remove: ");
                                                    int removeIndex = sc.nextInt() - 1;
                                                    if (removeIndex >= 0 && removeIndex < cart.size()) {
                                                        CartItem removed = cart.remove(removeIndex);
                                                        removed.product.quantity++;
                                                        System.out.println("Removed " + removed.product.name + " from cart.");
                                                    } else {
                                                        System.out.println("Invalid selection!");
                                                    }
                                                }
                                            case 5 -> {
                                                    if (cart.isEmpty()) {
                                                        System.out.println("Cart is Empty!");
                                                        break;
                                                    }
                                                    double total = cart.stream().mapToDouble(c -> c.product.price * c.quantity).sum();
                                                    System.out.println("Choose Payment Method: 1.UPI \n 2.Card\n  3.Cash");
                                                    int payMethod = sc.nextInt();
                                                    PaymentMethod payment = switch (payMethod) {
                                                            case 1 -> new UPIPayment();
                                                            case 2 -> new CardPayment();
                                                            default -> new CashPayment();
                                                        };
                                                    if (payment.pay(total, sc)) {
                                                        Order order = new Order();
                                                        System.out.println("Order ID: " + order.orderId);
                                                        System.out.println("Delivery Status: " + order.getDeliveryStatus());
                                                        System.out.println("Order will be delivered to:");
                                                        System.out.println(currentUser.firstName + " " + currentUser.surname);
                                                        System.out.println(currentUser.getFullAddress());
                                                        cart.clear();
                                                    }
                                                }
                                            case 6 -> {
                                                    System.out.print("Write a review: ");
                                                    String review = sc.nextLine();
                                                    reviewSystem.addReview(review);
                                                }
                                            case 7 -> reviewSystem.viewReviews();
                                            case 8 -> customerActive = false;
                                            default -> System.out.println("Invalid choice!");
                                        }
                                    }
                                } else if (section == 3) {
                                    loggedIn = false;
                                }
                            }
                        } else {
                            System.out.println("Incorrect OTP!");
                        }
                    } else {
                        System.out.println("Incorrect Password!");
                    }
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid Choice!");
            }
        }
    }
}
