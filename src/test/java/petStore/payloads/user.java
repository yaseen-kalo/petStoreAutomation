package petStore.payloads;

public class user {

    //pojo class, plain old java object

    public static String username;
    public static String firstName;
    public static String lastName;
    public static String email;
    public static String password;
    public static String phone;
    public static int userStatus = 0;

    public static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        user.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        user.username = username;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        user.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        user.lastName = lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        user.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        user.password = password;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        user.phone = phone;
    }

    public static int getUserStatus() {
        return userStatus;
    }

    public static void setUserStatus(int userStatus) {
        user.userStatus = userStatus;
    }
}
