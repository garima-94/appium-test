package util;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class FileUtil {

  private static Map<String, Map<String, String>> cap;

  static {
    try (InputStream input =
        FileUtil.class.getClassLoader().getResourceAsStream("config/mobile_capabilities.yml")) {
      Yaml yaml = new Yaml();
      cap = yaml.load(input);
    } catch (Exception e) {
      throw new RuntimeException(
          String.format("Failed to load capabilities file: %s", e.getMessage()));
    }
  }

  public static Map<String, String> getCap(String platform){
    return cap.get(platform.toLowerCase());
  }
}
