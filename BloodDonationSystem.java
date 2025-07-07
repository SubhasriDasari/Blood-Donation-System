import java.util.*;

class Donor {
    private String id;
    private String name;
    private String bloodGroup;
    private String contact;
    private String address;

    public Donor(String id, String name, String bloodGroup, String contact, String address) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.contact = contact;
        this.address = address;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getBloodGroup() { return bloodGroup; }
    public String getContact() { return contact; }
    public String getAddress() { return address; }

    public void displayDonor() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Contact: " + contact);
        System.out.println("Address: " + address);
        System.out.println("-------------------------");
    }
}

class BloodBank {
    private List<Donor> donors = new ArrayList<>();

    public void registerDonor(Donor donor) {
        donors.add(donor);
        System.out.println(" Donor registered: " + donor.getName());
    }

    public void searchByBloodGroup(String bloodGroup) {
        System.out.println(" Searching for blood group: " + bloodGroup);
        boolean found = false;
        for (Donor d : donors) {
            if (d.getBloodGroup().equalsIgnoreCase(bloodGroup)) {
                d.displayDonor();
                found = true;
            }
        }
        if (!found) {
            System.out.println(" No donors found with blood group: " + bloodGroup);
        }
    }

    public void listAllDonors() {
        if (donors.isEmpty()) {
            System.out.println(" No donors registered yet.");
            return;
        }
        System.out.println("--- List of Donors ---");
        for (Donor d : donors) {
            d.displayDonor();
        }
    }
}

public class BloodDonationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BloodBank bloodBank = new BloodBank();

        while (true) {
            System.out.println("\n--- Blood Donation Management System ---");
            System.out.println("1. Register Donor");
            System.out.println("2. Search Donor by Blood Group");
            System.out.println("3. List All Donors");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Blood Group: ");
                    String bloodGroup = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    Donor donor = new Donor(id, name, bloodGroup, contact, address);
                    bloodBank.registerDonor(donor);
                    break;

                case 2:
                    System.out.print("Enter Blood Group to Search: ");
                    String searchGroup = sc.nextLine();
                    bloodBank.searchByBloodGroup(searchGroup);
                    break;

                case 3:
                    bloodBank.listAllDonors();
                    break;

                case 4:
                    System.out.println(" Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }
}
