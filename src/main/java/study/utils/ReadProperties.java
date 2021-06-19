package study.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    /**
     *根据文件名称、属性名获取相应属性值
     *@throws IOException
     *@throws FileNotFoundException
     *
     *
     */
    public static String getprop(String filename, String propname) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(filename + ".properties"));
        String property = props.getProperty(propname);
        return property;
    }
}
