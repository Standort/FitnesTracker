import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserData {
    private String fileName;

    public UserData(String fileName) {
        this.fileName = fileName;
    }

    public void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String userData = user.getName() + "," +
                    user.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "," +
                    user.getHeight() + "," +
                    user.getWeight() + "," +
                    user.getGender();

            writer.write(userData);
        } catch (IOException e) {
            System.out.println("Failed to save user data: " + e.getMessage());
        }
    }
    public User loadUser() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line != null) {
                String[] userData = line.split(",");
                if (userData.length == 5) {
                    String name = userData[0];
                    LocalDate dateOfBirth = LocalDate.parse(userData[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    float height = Float.parseFloat(userData[2]);
                    float weight = Float.parseFloat(userData[3]);
                    String gender = userData[4];

                    return new User(name, dateOfBirth, height, weight, gender);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load user data: " + e.getMessage());
        }

        return null;
    }
}
