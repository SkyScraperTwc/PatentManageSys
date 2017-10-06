package com.scut.crm.utils;

import com.scut.crm.constant.SerialNumberConst;
import com.scut.crm.entity.Author;
import com.scut.crm.entity.Patent;
import com.scut.crm.entity.User;

import java.util.Random;

public class IdentifierUtils {

    public static String getSerialNumber(Class c) {
        String base = "123456789";
        String prefix = getPrefix(c);
        Random random = new Random();
        StringBuffer sb = new StringBuffer(prefix);
        for (int i = 0; i < 8; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getPrefix(Class c){
        String prefix = "";
        if (c.equals(User.class)){
            prefix = SerialNumberConst.USER_SERIAL_PREFIX;
        }else if (c.equals(Author.class)){
            prefix = SerialNumberConst.AUTHOR_SERIAL_PREFIX;
        }else if (c.equals(Patent.class)){
            prefix = SerialNumberConst.PATENT_SERIAL_PREFIX;
        }
        return prefix;
    }
}
