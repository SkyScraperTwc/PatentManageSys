import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JunitTest {

    @Test
    public void test1(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
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
