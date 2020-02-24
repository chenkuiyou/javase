package collection_and_map.Map;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author cky
 * @create 2020 2 19 10:53
 */
public class properties {
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        pros.load(new FileInputStream("E:\\idea_workplace\\java_senior\\Collection_and_Map\\src\\Map\\jdbc.properties") );
        System.out.println(pros.getProperty("name"));
    }
}
