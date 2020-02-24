package DateAPI;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * jdk8 表示时间 Local（Date/Time）
 *
 * 瞬时 Instant
 *
 *  格式解析 DateTimeFormateer
 * @author cky
 * @create 2020 2 16 18:44
 */
public class JDK8NEWDate {

    public static void main(String[] args) {
        //创建对象
        LocalDate localDate= LocalDate.now();
        LocalTime localTime=LocalTime.now();

        System.out.println(localDate);
        System.out.println(localTime);

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);

        //设定指定的时间 of()  上面三种类都有of方法
        System.out.println(LocalTime.of(2, 3, 4));

        //获得时间的某个属性 getXxx（）  .之后都会有提示
        System.out.println(localDateTime.getMonth());

        //用with修改某个locakDateTime 的值，返回新的对象，体现了locakDateTime不可变性
        LocalDateTime localdatetime=localDateTime.withDayOfMonth(1);
        System.out.println(localDateTime);
        System.out.println(localdatetime);
        //用 plus 和minus 进行加减操作 和with一样

        System.out.println("------------------");

        //Instant
        //实例化
        Instant instant=Instant.now();
        System.out.println(instant);

        //需要的时候自己百度就行了
    }
}
