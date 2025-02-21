package petStore.utilities;

import petStore.payloads.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "UserData")  // Correct name
    public Object[][] getUserDataFromJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFilePath = "/Users/yaseenkalo/Documents/automationProject/petStoreAutomation/TestData/user.json";  // Replace with the actual path

        List<user> users = objectMapper.readValue(new File(jsonFilePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, user.class));

        Object[][] data = new Object[users.size()][8];  // 8 fields based on the User class

        for (int i = 0; i < users.size(); i++) {
            user user = users.get(i);
            data[i][0] = user.getId();
            data[i][1] = user.getUsername();
            data[i][2] = user.getFirstName();
            data[i][3] = user.getLastName();
            data[i][4] = user.getEmail();
            data[i][5] = user.getPassword();
            data[i][6] = user.getPhone();
            data[i][7] = user.getUserStatus();
        }

        return data;
    }
}
