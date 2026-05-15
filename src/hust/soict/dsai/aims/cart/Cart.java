package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0;

    // Add DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // Remove DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                break;
            }
        }

        if (!found) {
            System.out.println("The disc is not found");
        }
    }

    // Total cost
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    //*************array*************
    /*public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    for (DigitalVideoDisc dvd : dvdList) {
        addDigitalVideoDisc(dvd);
    }
}*/
    //***************varargs******************
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
    for (DigitalVideoDisc dvd : dvdList) {
        addDigitalVideoDisc(dvd);
    }
}
    //*************2DVD**************
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    addDigitalVideoDisc(dvd1);
    addDigitalVideoDisc(dvd2);
    }
    //    printCart
    public void printCart() {
    System.out.println("***********************CART***********************");
    System.out.println("Ordered Items:");

    for (int i = 0; i < qtyOrdered; i++) {
        System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
    }

    System.out.println("Total cost: " + totalCost());
    System.out.println("***************************************************");
    }
    //    search theo id
    public void searchById(int id) {
    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].getId() == id) {
            System.out.println("Found: " + itemsOrdered[i]);
            return;
        }
    }
    System.out.println("Not found");
    }
    // search theo title
    public void searchByTitle(String title) {
    boolean found = false;
    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].isMatch(title)) {
            System.out.println(itemsOrdered[i]);
            found = true;
        }
    }
    if (!found) System.out.println("Not found");
}
}
