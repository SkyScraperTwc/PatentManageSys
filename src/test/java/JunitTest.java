import org.junit.Test;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JunitTest {

    @Test
    public void test1(){
        System.out.println(Boolean.valueOf("true123"));
    }

    @Test
    public void test2(){
        Map<String,Object> map = new HashMap<>();
        map.put("aa","123");
        System.out.println(map);
        map = Collections.unmodifiableMap(map);
        map.put("bb","456");
    }

}
