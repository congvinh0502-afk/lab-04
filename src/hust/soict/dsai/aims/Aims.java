package hust.soict.dsai.aims;

import java.util.Scanner;
import java.util.Collections;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    public static void showMenu() {

        System.out.println("AIMS: ");

        System.out.println("--------------------------------");

        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");

        System.out.println("--------------------------------");

        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {

        System.out.println("Options: ");

        System.out.println("--------------------------------");

        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");

        System.out.println("--------------------------------");

        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void cartMenu() {

        System.out.println("Options: ");

        System.out.println("--------------------------------");

        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");

        System.out.println("--------------------------------");

        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void mediaDetailsMenu() {

        System.out.println("Options: ");

        System.out.println("--------------------------------");

        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");

        System.out.println("--------------------------------");

        System.out.println("Please choose a number: 0-1-2");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Store store = new Store();

        Cart cart = new Cart();

        // Sample media
        DigitalVideoDisc dvd1 =
                new DigitalVideoDisc(
                        "Batman",
                        "Movie",
                        "Nolan",
                        120,
                        20f
                );

        DigitalVideoDisc dvd2 =
                new DigitalVideoDisc(
                        "Avengers",
                        "Movie",
                        "Marvel",
                        150,
                        25f
                );

        Book book1 =
                new Book(
                        1,
                        "Java Programming",
                        "Education",
                        15f
                );

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);

        int choice;

        do {

            showMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    int storeChoice;

                    do {

                        store.printStore();

                        storeMenu();

                        storeChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (storeChoice) {

                            case 1:

                                System.out.print(
                                        "Enter media title: ");

                                String detailTitle =
                                        scanner.nextLine();

                                Media foundMedia = null;

                                for (Media media :
                                        store.getItemsInStore()) {

                                    if (media.getTitle()
                                            .equalsIgnoreCase(
                                                    detailTitle)) {

                                        foundMedia = media;

                                        break;
                                    }
                                }

                                if (foundMedia != null) {

                                    System.out.println(foundMedia);

                                    int detailChoice;

                                    do {

                                        mediaDetailsMenu();

                                        detailChoice =
                                                scanner.nextInt();

                                        scanner.nextLine();

                                        switch (detailChoice) {

                                            case 1:

                                                cart.addMedia(
                                                        foundMedia);

                                                break;

                                            case 2:

                                                if (foundMedia
                                                        instanceof Playable) {

                                                    Playable playable =
                                                            (Playable)
                                                                    foundMedia;

                                                    playable.play();

                                                } else {

                                                    System.out.println(
                                                            "This media cannot be played");
                                                }

                                                break;

                                            case 0:

                                                break;

                                            default:

                                                System.out.println(
                                                        "Invalid choice");
                                        }

                                    } while (detailChoice != 0);

                                } else {

                                    System.out.println(
                                            "Media not found");
                                }

                                break;

                            case 2:

                                System.out.print(
                                        "Enter media title to add: ");

                                String addTitle =
                                        scanner.nextLine();

                                boolean added = false;

                                for (Media media :
                                        store.getItemsInStore()) {

                                    if (media.getTitle()
                                            .equalsIgnoreCase(
                                                    addTitle)) {

                                        cart.addMedia(media);

                                        added = true;

                                        break;
                                    }
                                }

                                if (!added) {

                                    System.out.println(
                                            "Media not found");
                                }

                                break;

                            case 3:

                                System.out.print(
                                        "Enter media title to play: ");

                                String playTitle =
                                        scanner.nextLine();

                                boolean played = false;

                                for (Media media :
                                        store.getItemsInStore()) {

                                    if (media.getTitle()
                                            .equalsIgnoreCase(
                                                    playTitle)) {

                                        if (media
                                                instanceof Playable) {

                                            Playable playable =
                                                    (Playable) media;

                                            playable.play();

                                        } else {

                                            System.out.println(
                                                    "This media cannot be played");
                                        }

                                        played = true;

                                        break;
                                    }
                                }

                                if (!played) {

                                    System.out.println(
                                            "Media not found");
                                }

                                break;

                            case 4:

                                cart.printCart();

                                break;

                            case 0:

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice");
                        }

                    } while (storeChoice != 0);

                    break;

                case 2:

                    System.out.println(
                            "Update store feature");

                    break;

                case 3:

                    int cartChoice;

                    do {

                        cart.printCart();

                        cartMenu();

                        cartChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (cartChoice) {

                            case 1:

    System.out.println("1. Filter by id");
    System.out.println("2. Filter by title");

    int filterChoice = scanner.nextInt();
    scanner.nextLine();

    if (filterChoice == 1) {

        System.out.print("Enter id: ");

        int id = scanner.nextInt();
        scanner.nextLine();

        cart.searchById(id);

    } else if (filterChoice == 2) {

        System.out.print("Enter title: ");

        String title = scanner.nextLine();

        cart.searchByTitle(title);
    }

    break;
                            case 2:
                            

                                System.out.println("1. Sort by title");
                                System.out.println("2. Sort by cost");

                                int sortChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (sortChoice == 1) {

                                Collections.sort(
                                      cart.getItemsOrdered(),
                                      Media.COMPARE_BY_TITLE_COST
                                 );

                                 System.out.println(
                                      "Sorted by title");

                                 } else if (sortChoice == 2) {

                                     Collections.sort(
                                     cart.getItemsOrdered(),
                                     Media.COMPARE_BY_COST_TITLE
                                );

                                System.out.println(
                                   "Sorted by cost");
                                }

                                cart.printCart();                                       
                                break;

                            case 3:

                                System.out.print(
                                        "Enter title to remove: ");

                                String removeTitle =
                                        scanner.nextLine();

                                Media removeMedia = null;

                                for (Media media :
                                        store.getItemsInStore()) {

                                    if (media.getTitle()
                                            .equalsIgnoreCase(
                                                    removeTitle)) {

                                        removeMedia = media;

                                        break;
                                    }
                                }

                                if (removeMedia != null) {

                                    cart.removeMedia(removeMedia);

                                } else {

                                    System.out.println(
                                            "Media not found");
                                }

                                break;

                            case 4:

                                System.out.print(
                                        "Enter media title to play: ");

                                String cartPlay =
                                        scanner.nextLine();

                                boolean found = false;

                                for (Media media :
                                        store.getItemsInStore()) {

                                    if (media.getTitle()
                                            .equalsIgnoreCase(
                                                    cartPlay)) {

                                        if (media
                                                instanceof Playable) {

                                            Playable playable =
                                                    (Playable) media;

                                            playable.play();

                                        } else {

                                            System.out.println(
                                                    "This media cannot be played");
                                        }

                                        found = true;

                                        break;
                                    }
                                }

                                if (!found) {

                                    System.out.println(
                                            "Media not found");
                                }

                                break;

                            case 5:

                                System.out.println(
                                        "Order created!");

                                break;

                            case 0:

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice");
                        }

                    } while (cartChoice != 0);

                    break;

                case 0:

                    System.out.println("Goodbye!");

                    break;

                default:

                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        scanner.close();
    }
}