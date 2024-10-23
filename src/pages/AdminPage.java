package pages;

public class AdminPage {
    public static void adminPage(){
        showAdminPage();
    }

    public static void showAdminPage() {
        System.out.println("1 -> USER CREATE");
        System.out.println("2 -> USER DELETE");
        System.out.println("3 -> USER UPDATE");
        System.out.println("4 -> USERS LIST");
        System.out.println("e -> LOGOUT");
    }
}
