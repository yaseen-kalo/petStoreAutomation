package petStore.utilities;

import petStore.payloads.user;
import petStore.payloads.store;

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
            data[i][0] = user.getUserId();
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

    @DataProvider(name = "StoreData")  // Correct name
    public Object[][] getStoreDataFromJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFilePath = "/Users/yaseenkalo/Documents/automationProject/petStoreAutomation/TestData/store.json";  // Replace with the actual path

        List<store> stores = objectMapper.readValue(new File(jsonFilePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, store.class));

        Object[][] data = new Object[stores.size()][6];  // 8 fields based on the User class

        for (int i = 0; i < stores.size(); i++) {
            store store = stores.get(i);
            data[i][0] = store.getOrderId();
            data[i][1] = store.getPetId();
            data[i][2] = store.getQuantity();
            data[i][3] = store.getShipDate();
            data[i][4] = store.getStatus();
            data[i][5] = store.isComplete();
        }

        return data;
    }
}
