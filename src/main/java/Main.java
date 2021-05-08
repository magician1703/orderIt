import com.zagurskiy.cuisine.Cuisine;
import com.zagurskiy.dishes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList <Cuisine> cuisines;
    static Cuisine selectedCuisine;
    static Lunch selectedLunch;
    static Drink selectedDrink;

    static Scanner sc= new Scanner(System.in);

    static void init(ArrayList<Cuisine> cuisines){

        cuisines.add(new Cuisine("Polish"));
        cuisines.add(new Cuisine("Mexican"));
        cuisines.add(new Cuisine("Italian"));

        //Polish
        cuisines.get(0).addMainCourse(new MainCourse("Zurek", 7.5F));
        cuisines.get(0).addMainCourse(new MainCourse("Pork loin with potatoes", 10.5F));
        cuisines.get(0).addMainCourse(new MainCourse("Dumplings", 9.5F));
        cuisines.get(0).addDessert(new Dessert("Cheese cake", 5.5F));
        cuisines.get(0).addDessert(new Dessert("Nutcracker", 5.5F));
        cuisines.get(0).addDessert(new Dessert("Apple pie", 5.5F));
        cuisines.get(0).addDrink(new Drink("Barszcz w szklance", 3.5F));
        cuisines.get(0).addDrink(new Drink("Chamomile Tea", 2.5F));
        cuisines.get(0).addDrink(new Drink("Bear Zywiec", 4.5F));

        //Mexican
        cuisines.get(1).addMainCourse(new MainCourse("Tacos z wolowina", 12.5F));
        cuisines.get(1).addMainCourse(new MainCourse("Quesadilla with chicken", 13.5F));
        cuisines.get(1).addMainCourse(new MainCourse("Burrito with chilli sauce", 11.5F));
        cuisines.get(1).addDessert(new Dessert("Churros", 6.5F));
        cuisines.get(1).addDessert(new Dessert("Mexican Hot Chocolate Pie", 5.5F));
        cuisines.get(1).addDessert(new Dessert("Dulce de Leche", 6.5F));
        cuisines.get(1).addDrink(new Drink("Tepache", 4.5F));
        cuisines.get(1).addDrink(new Drink("Margarita", 2.5F));
        cuisines.get(1).addDrink(new Drink("Tequila", 5.5F));

        //Italian
        cuisines.get(2).addMainCourse(new MainCourse("Spaghetti di Parma", 13.5F));
        cuisines.get(2).addMainCourse(new MainCourse("Mule kokosero", 15.5F));
        cuisines.get(2).addMainCourse(new MainCourse("Gnocchi with duck", 13.5F));
        cuisines.get(2).addDessert(new Dessert("Meringata", 5.5F));
        cuisines.get(2).addDessert(new Dessert("Tiramisu", 5.5F));
        cuisines.get(2).addDessert(new Dessert("Panna cotta", 4.5F));
        cuisines.get(2).addDrink(new Drink("Sangiovese wine", 5.5F));
        cuisines.get(2).addDrink(new Drink("Prosecco", 6.5F));
        cuisines.get(2).addDrink(new Drink("San Pellegrio", 3.5F));
    }

    static void orderLunch(Cuisine cuisine) {
        int countMainCourse = 0;
        int countDessert = 0;
        int choosenMainCourse = 0;
        int choosenDessert = 0;


        System.out.print("\nChoosing Main Course : \n");
        for(MainCourse mainCourse : cuisine.getMainCourses()) {

            System.out.print("(" + (++countMainCourse) + ") " );
            mainCourse.print();
        }

        System.out.print("Choose Main Course : ");
        choosenMainCourse = sc.nextInt();
        MainCourse selectedMainCourse = cuisine.getMainCourses().get(choosenMainCourse - 1);


        System.out.print("\nChoosing Dessert  ");
        for(Dessert dessert : cuisine.getDesserts()) {
            System.out.print("(" + (++countDessert) + ") ");
            dessert.print();
        }
        System.out.print("Choose Dessert : ");
        choosenDessert = sc.nextInt();
        Dessert selectedDessert = cuisine.getDesserts().get(choosenDessert - 1);

        selectedLunch = new Lunch(selectedMainCourse,selectedDessert);
    }

    static void orderDrink(Cuisine cuisine) {
        int countDrinks = 0;
        int choosenDrink = 0;

        System.out.println("\nChoosing Drink ");
        for(Drink drink : cuisine.getDrinks()) {
            System.out.print("(" + (++countDrinks) + ") ");
            drink.print();
            System.out.println(" " + drink.getPrice());
        }
        System.out.print("Choose Drink : ");
        choosenDrink = sc.nextInt();
        selectedDrink = cuisine.getDrinks().get(choosenDrink-1);
        System.out.println("""
                
                Do you want add something to your drink\s
                (1) Add ice\s
                (2) Add lemon\s
                (3) Add ice and lemon
                (4) Nothing else""");

        System.out.print("Select option : ");
        int option = sc.nextInt();
        switch (option){
            case 1:
                selectedDrink.setWithIce(true);
                break;
            case 2: selectedDrink.setWithLemon(true);
                break;
            case 3:
                selectedDrink.setWithIce(true);
                selectedDrink.setWithLemon(true);
                break;
            default:
                break;
        }
    }

    static void changeCuisine(ArrayList<Cuisine> cuisines) {
        int countOfCuisine = 0;
        for(Cuisine cuisine : cuisines) {
            countOfCuisine++;
            System.out.print("\n(" + countOfCuisine + ") " + cuisine.getNameOfCuisene() + ", ");
        }
        System.out.print("\nSelected is " + selectedCuisine.getNameOfCuisene() + "\nChoose cuisine (1 - " + cuisines.size() + "): ");
        int changeCuisine = sc.nextInt();

        selectedCuisine = cuisines.get(changeCuisine - 1);
    }

    static void printOrder() {
        float totally = selectedLunch.getPrice() + selectedDrink.getPrice();
        System.out.print("\nYour order : " +
                selectedLunch.getMainCourse().getName() +
                " and " + selectedLunch.getDessert().getName() +
                " with ");
        selectedDrink.print();
        System.out.println("\nIts costs " + totally);
    }

    static void printMenu(ArrayList<Cuisine>cuisines){

        for(Cuisine cuisine :cuisines){
            System.out.println(cuisine.getNameOfCuisene());

            System.out.println("  Main Courses : ");
            for(MainCourse mainCourse : cuisine.getMainCourses()) {
                System.out.println("    " + mainCourse.getName() + " in price " + mainCourse.getPrice());
            }

            System.out.println("  Desserts : ");
            for(Dessert dessert : cuisine.getDesserts()){
                System.out.println("    " + dessert.getName() + " in price " + dessert.getPrice());
            }

            System.out.println("  Drinks :  ");
            for(Drink drink : cuisine.getDrinks()){
                System.out.println("    " + drink.getName() + " in price " + drink.getPrice());
            }
            System.out.println("Print any key to see menu of next Cuisine");
            String a = sc.next();
        }
    }

    public static void main(String[] args) {

        cuisines = new ArrayList<>();
        init(cuisines);
        selectedCuisine = cuisines.get(0);

        int selectFunction;

        do {
            System.out.println("\n(1) Change cuisine (Now is seleted "+ selectedCuisine.getNameOfCuisene() +
                    ")\n(2) Order lunch \n(3) Order drink \n(4) Print Menu");
            System.out.print("Choose function (1 - 4): ");
            selectFunction = sc.nextInt();
            switch (selectFunction) {
                case 1: //Changing Cuisine
                    changeCuisine(cuisines);
                    break;
                case 2:
                    orderLunch(selectedCuisine);
                    break;
                case 3:   // Order drink
                    orderDrink(selectedCuisine);
                    break;
                case 4:   // Order lunch and drink
                    printMenu(cuisines);
                    break;
                default:
                    break;
            }

            if(selectedDrink != null || selectedLunch !=null) {
                if(selectedDrink == null) {
                    System.out.print("\nDo you want to order : " +
                            selectedLunch.getMainCourse().getName() +
                            " and " + selectedLunch.getDessert().getName());
                    System.out.println("\n(1) Accept your order \n(2) Order drink(add to your order) \n(3) Cancel your order");
                    System.out.print("Select option : ");
                    int option = sc.nextInt();
                    switch(option) {
                        case 1:
                            System.out.print("\nYour order is : " +
                                    selectedLunch.getMainCourse().getName() +
                                    " and " + selectedLunch.getDessert().getName() +
                                    " in price " + selectedLunch.getPrice());
                            System.out.println("\nPlease wait 20 minutes \n thank you for choosing our cuisine");
                            selectFunction = 0 ;
                            break;
                        case 2:
                            //changeCuisine(cuisines);
                            orderDrink(selectedCuisine);
                            printOrder();
                            System.out.println("\n(1) Accept your order \n(2) Cancel your order");
                            System.out.print("Select option : ");
                            int accept = sc.nextInt();
                            if (accept == 1) {
                                printOrder();
                                System.out.println("\nPlease wait 20 minutes \n thank you for choosing our cuisine");
                                selectFunction = 0;
                            } else if (accept == 2) {
                                selectedDrink = null;
                                selectedLunch = null;
                            }
                        case 3:
                            selectedDrink = null;
                            selectedLunch = null;
                            break;
                        default:
                            break;
                    }

                }
                else {
                    System.out.print("\nDo you want to order : ");
                    selectedDrink.print();
                    System.out.println("\n(1) Accept your order \n(2) Order lunch(add to your order) \n(3) Cancel your order");
                    System.out.print("Select option : ");
                    int option = sc.nextInt();
                switch(option) {
                    case 1:
                        System.out.print("\nYour order is : ");
                        selectedDrink.print();
                        System.out.print(" in price " + selectedDrink.getPrice());
                        System.out.println("\nPlease wait 20 minutes \n thank you for choosing our cuisine");
                        selectFunction = 0 ;
                        break;
                    case 2:
                       // changeCuisine(cuisines);
                        orderLunch(selectedCuisine);
                        printOrder();
                        System.out.println("\n(1) Accept your order \n(2) Cancel your order");
                        System.out.print("Select option : ");
                        int accept = sc.nextInt();
                        if (accept == 1) {
                            printOrder();
                            System.out.println("\nPlease wait 20 minutes \n thank you for choosing our cuisine");
                            selectFunction = 0;
                        } else if (accept == 2) {
                            selectedDrink = null;
                            selectedLunch = null;
                        }
                    case 3:
                        selectedDrink = null;
                        selectedLunch = null;
                        break;
                    default:
                        break;
                }

                }
            }
        }
    while(selectFunction!=0);

    }
}