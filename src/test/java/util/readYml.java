package util;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class readYml {


        public static String read(String variable) {
            String value = null;

            // Read YAML file
            try {
                String path = System.getProperty("user.dir") + "/config/ymlFiles/UAT.yml" ;
                FileInputStream input = new FileInputStream(path);
                Yaml yaml = new Yaml();

                // Parse YAML file
                Map<String, Object> data = yaml.load(input);

                // Get values from the map
                Map<String, Object> config = (Map<String, Object>) data.get("Params");
                 value = (String) config.get(variable);



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return value;
        }

    public static String readLocator(String variable) {
        String value = null;

        // Read YAML file
        try {
            String path = System.getProperty("user.dir") + "/repo/locator.yml" ;
            FileInputStream input = new FileInputStream(path);
            Yaml yaml = new Yaml();

            // Parse YAML file
            Map<String, Object> data = yaml.load(input);

            // Get values from the map
            Map<String, Object> config = (Map<String, Object>) data.get("Params");
            value = (String) config.get(variable);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
    }
