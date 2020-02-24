package fileIO;

import java.io.*;

/**
 *
 * 对象流 将对象转化为二进制文件，用于网络传输
 * @author cky
 * @create 2020 2 21 12:07
 */
public class objectstream {
    public static void main(String[] args) {
        String s=new String("中国");
        System.out.println(s);
        objToStream("obj.dat",s);
        streamToObj("obj.dat");
    }

    public static void objToStream(String s , Object obj){
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(s));
            oos.writeObject(obj);
            oos.flush();  //刷新操作  将写的对象刷入到存储中

            oos.writeObject(new student("tutu",20));
            oos.flush();  //刷新操作  将写的对象刷入到存储中
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(oos!=null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static  void streamToObj(String path){
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));

            String s=(String) ois.readObject();

            student s2=(student) ois.readObject();
            System.out.println(s);
            System.out.println(s2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois!=null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

//自定义可序列化对象
//需要两点 ， 继承可序列化的接口， 定义serialVersionUID
//类中的属性也必须是可序列化的
//有static 和transient 修饰的 变量不能被序列化
// transient  就是用来修饰 不想被序列化的属性
//static 是属于类的，不是属于变量的
class student implements  Serializable{
    //为了识别是哪个类
    //如果不提供，系统会自动提供一个随机的id，但是在系统重启之后，这个id会变
    private static final long serialVersionUID = 794470754667710L;
    public String name;
    public int age;

    public student() {
    }
    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}