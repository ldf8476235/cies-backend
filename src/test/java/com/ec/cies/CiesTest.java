package com.ec.cies;

import com.ec.cies.utils.R;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@SpringBootTest
public class CiesTest {
    @Test
    void autotest(){
        System.out.println(R.ok().put("list","123"));
    }

}
