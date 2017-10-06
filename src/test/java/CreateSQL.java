import com.scut.crm.entity.Author;
import com.scut.crm.entity.Patent;
import com.scut.crm.utils.IdentifierUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateSQL {

    @Test
    public void CreateAuthorSql(){
        String[] name = {"'马云'","'李彦宏'","'马化腾'"};
        String[] userId = {"'1'","'2'","'3'","'4'","'5'"};
        List<String> list = new ArrayList<>();

        Random random = new Random();
        for (int i=0;i<200;i++){
            StringBuffer buffer = new StringBuffer("INSERT INTO `author` VALUES ('0', ");
            String serialNumber = IdentifierUtils.getSerialNumber(Author.class);
            buffer.append("'"+serialNumber+"'"+",");

            int max=3;
            int min=0;
            int s = random.nextInt(max)%(max-min+1) + min;
            buffer.append(name[s]+",");
            buffer.append("'13888888888', '北京三里桥', ");

            max=5;
            min=0;
            s = random.nextInt(max)%(max-min+1) + min;
            buffer.append(userId[s]+",");

            buffer.append("current_date(),current_date());");
            list.add(buffer.toString());
        }
        for (String string :list) {
            System.out.println(string);
        }
    }

    @Test
    public void CreateContractSql(){
        String[] name = {"'两维移动三维转动虚拟轴机床'",
                "'石墨电极双螺纹梳加工机床'","'用于程序控制机床的控制台'","'多功能摆线加工机床'",
                "'智能机床控制柜'","'机床电源接线盒'","'钢令生产专用机床可编程控制装置'"
                ,"'一种轴类零件加工的多功能数控组合机床'","'一种教学用齿轮插齿机床'"};
        String[] type = {"'发明专利'","'实用新型专利'","'外观设计专利'"};
        String[] state = {"'专利申请尚未授权'","'专利申请撤回'","'专利权有效'"};
        String[] authorId = {"'1'","'2'","'3'","'4'","'5'","'6'","'7'"
                ,"'8'","'9'","'10'","'11'","'12'","'13'","'14'"
                ,"'15'","'16'","'17'","'18'","'19'","'20'","'21'","'22'","'23'","'24'"
                ,"'25'","'26'","'27'","'28'","'29'","'30'","'31'","'32'","'33'","'34'","'35'"};

        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<500;i++){
            StringBuffer buffer = new StringBuffer("INSERT INTO `patent` VALUES ('0', ");
            String serialNumber = IdentifierUtils.getSerialNumber(Patent.class);
            buffer.append("'"+serialNumber+"'"+",");

            int max=9;
            int min=0;
            int s = random.nextInt(max)%(max-min+1) + min;
            buffer.append(name[s]+",");

            max=3;
            min=0;
            s = random.nextInt(max)%(max-min+1) + min;
            buffer.append(type[s]+",");

            max=3;
            min=0;
            s = random.nextInt(max)%(max-min+1) + min;
            buffer.append(state[s]+",");

            max=35;
            min=0;
            s = random.nextInt(max)%(max-min+1) + min;
            buffer.append(authorId[s]+",");

            buffer.append("current_date(),current_date());");
            list.add(buffer.toString());
        }
        for (String string :list) {
            System.out.println(string);
        }
    }
}
