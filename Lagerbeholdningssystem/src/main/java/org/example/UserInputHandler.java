package org.example;

public class UserInputHandler {

    public void openCommunication() {
        InputHelper inputHelper = new InputHelper();
        FileReader fileReader = new FileReader();
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. Les ordrehistorikk");
            System.out.println("2. Les lagerbeholdning");
            System.out.println("3. Les leverandørrapport");
            System.out.println("4. Oppdater lagerstatus");
            System.out.println("5. Exit");

            int choice = inputHelper.getInt("Please select an option (1, 2, 3, 4 or 5): ");

            switch (choice) {
                case 1:
                    fileReader.ReadOrderData("ordredata.json");
                    break;

                case 2:
                    //fileReader.ReadFile("lagerbeholdning.json");
                    VareHandler handler = new VareHandler();
                    VareListe<Vare> vareListe = new VareListe<>();
                    vareListe = fileReader.ReadFile("lagerbeholdning.json", handler);
                    System.out.println("Lagerbeholdning:");
                    for (Vare vare : vareListe.liste.values()) {
                        System.out.println("Antall av " + vare.name + " på lager: " + vare.count);
                    }
                    break;

                case 3:
                    // TODO: Les leverandørrapport
                    System.out.println("Implement les leverandørrapport");
                    break;

                case 4:
                    String lagerFil = "lagerbeholdning.json";
                    FileWriter fileWriter = new FileWriter();
                    String updateInfo = inputHelper.getString("Oppdater lagerbeholdning på formatet: 'item_id -count;item_id -count;...': ");
                    System.out.println(updateInfo);
                    fileWriter.UpdateStorage(updateInfo, lagerFil);
                    System.out.println("Lagerbeholdning updated.");
                    break;

                case 5:
                    System.out.println("Logged out!");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        inputHelper.close();
    }
}
