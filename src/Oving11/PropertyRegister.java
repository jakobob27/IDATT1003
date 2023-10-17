package Oving11;

import java.util.ArrayList;
import java.util.Scanner;

public class PropertyRegister {

    private final int ADD_PROPERTY = 1;
    private final int LIST_ALL_PROPERTIES = 2;
    private final int FIND_PROPERTY = 3;
    private final int CALCULATE_AVERAGE_AREA = 4;

    private final int REMOVE_PROPERTY = 5;

    private final int EXIT = 9;
    private final ArrayList<Property> propertyRegister;

    public PropertyRegister() {
        this.propertyRegister=new ArrayList<>();
    }

    public void addProperty(Property property) {
        propertyRegister.add(property);
    }

    public void removeProperty(Property property) {
        propertyRegister.remove(property);
    }

    public int registerSize(){
        return propertyRegister.size();
    }

    public Property findProperty(int munNum, int lnr, int snr) {
        for (Property i : propertyRegister) {
            if (i.getMunNum()==munNum && i.getLnr()==lnr && i.getSnr()==snr) {
                return i;
            }
        }
        return null;
    }

    public void printProperties(){
        for (Property i : propertyRegister) {
            System.out.println(i.toString());
        }
    }

    public double avgArea() {
        double sum = 0;
        for (Property i : propertyRegister) {
            sum+=i.getArea();
        }
        return sum/registerSize();
    }

    public ArrayList<Property> findLnr(int lnr) {
        ArrayList<Property> temp = new ArrayList<>();
        for (Property i : propertyRegister) {
            if (i.getLnr()==lnr) {
                temp.add(i);
            }
        }
        return temp;
    }

    private int showMenu()
    {
        int menuChoice = 0;
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Calculate average area");
        System.out.println("5. Remove property");
        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }
    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public void start() {
        Scanner inp = new Scanner(System.in);
        boolean finished = false;
// The while-loop will run as long as the user has not selected
// to quit the application
        while (!finished) {
            int menuChoice = this.showMenu();
            switch (menuChoice)
            {
                case ADD_PROPERTY:
                    System.out.println("Does the property have a name?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int choice = inp.nextInt();
                    if (choice!=1 && choice!=2) {
                        break;
                    }
                    System.out.println("Enter the municipality number");
                    int munNum=inp.nextInt();
                    System.out.println("Enter the municipality name");
                    inp.nextLine();
                    String munName=inp.nextLine();
                    System.out.println("Enter the lot number");
                    int lnr=inp.nextInt();
                    System.out.println("Enter the section number");
                    int snr=inp.nextInt();
                    System.out.println("What is the area?");
                    float area=inp.nextFloat();
                    System.out.println("What is the name of the owner?");
                    inp.nextLine();
                    String nameOwner = inp.nextLine();
                    if (choice==1) {
                        System.out.println("What is the property name?");
                        String bname = inp.nextLine();
                        addProperty(new Property(munNum, munName, lnr, snr, bname, area, nameOwner));
                        break;
                    }
                    addProperty(new Property(munNum, munName, lnr, snr, area, nameOwner));
                    break;
                case LIST_ALL_PROPERTIES:
                    printProperties();
                    break;
                case FIND_PROPERTY:
                    System.out.println("What type of search?");
                    System.out.println("1. By lot number");
                    System.out.println("2. By municipal number, lot number and section number");
                    int searchChoice = inp.nextInt();

                    System.out.println("Enter lot number");
                    int searchLnr = inp.nextInt();

                    switch(searchChoice) {
                        case 1:
                            System.out.println(findLnr(searchLnr).toString());
                            break;

                        case 2:
                            System.out.println("Enter section number");
                            int searchSnr = inp.nextInt();
                            System.out.println("Enter municipical number");
                            int searchMunNum = inp.nextInt();
                            System.out.println(findProperty(searchMunNum, searchLnr, searchSnr));
                    }
                    break;
                case CALCULATE_AVERAGE_AREA:
                    System.out.println(avgArea());
                    break;
                case REMOVE_PROPERTY:
                    System.out.println("Enter municipical number");
                    int remMunNum = inp.nextInt();
                    System.out.println("Enter lot number");
                    int remLnr = inp.nextInt();
                    System.out.println("Enter section number");
                    int remSnr = inp.nextInt();
                    removeProperty(findProperty(remMunNum, remLnr, remSnr));
                    break;
                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;
                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
    }

    public static void main(String[] args) {
    PropertyRegister test = new PropertyRegister();
    Property test1 = new Property(1445, "Gloppen", 77, 631, 1017.6, "Jens Olsen");
    Property test2 = new Property(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen");
    Property test3 = new Property(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
    Property test4 = new Property(1445, "Gloppen", 74, 188, 1457.2, "Karl Ove Bråten");
    Property test5 = new Property(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Else Indregård");

    test.addProperty(test1);
    test.addProperty(test2);
    test.addProperty(test3);
    test.addProperty(test4);
    test.addProperty(test5);
    test.start();
    }
}
