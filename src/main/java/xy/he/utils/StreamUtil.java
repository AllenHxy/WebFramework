package xy.he.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hexiuyu on 2018/1/14.But Nobody cares
 */
public class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);
    public static String getString(InputStream is){
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while((line = bufferedReader.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            LOGGER.error("get string fail by inputStream : " + e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
