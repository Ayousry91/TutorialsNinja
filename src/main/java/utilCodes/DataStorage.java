package utilCodes;

public class DataStorage {

    private static String firstName;
    private static String lastName;
    private static String phoneNumber;
    public static String email;
    public static String password;


    public static void setFirstName(String firstName) {
        DataStorage.firstName = firstName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setLastName(String lastName) {
        DataStorage.lastName = lastName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setPhoneNumber(String phoneNumber) {
        DataStorage.phoneNumber = phoneNumber;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setEmail(String email) {
        DataStorage.email = email;
    }

    public static String getEmail() {
        return email;
    }

    public static void setPassword(String password) {
        DataStorage.password = password;
    }

    public static String getPassword() {
        return password;
    }
}
