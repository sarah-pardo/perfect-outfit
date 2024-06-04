package depaul.edu.Authentication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import depaul.edu.Util.Paths;

public class UserFileReaderWriter {
	public static ArrayList<String> loadUserNames() {
        List<String> userNames = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Paths.USER_NAMES_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",\\s*");
                userNames.addAll(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(userNames);
    }
	public static void addNewUserToFile(String newUserName) {
        File file = new File(Paths.USER_NAMES_FILE_PATH);
        boolean isEmpty = !file.exists() || file.length() == 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            if (!isEmpty) {
                bw.write(",");
            }
            bw.write(newUserName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
