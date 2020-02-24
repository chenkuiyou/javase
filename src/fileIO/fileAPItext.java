package fileIO;


import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * File 类只能执行文件/文件夹的创建，移动，删除，重命名 ，查看大小，修改时间等，
 * 并不涉及文件内容的修改
 * @author cky
 * @create 2020 2 19 20:06
 */
public class fileAPItext {
    public static void main(String[] args) {

        //相对路径是对于当前工程而言的   "modualname//文件路径"
        File f2=new File("src/fileIO/hello.txt");
        //绝对路径  右键文件-》 copy path
        File f1=new File("E:\\idea_workplace\\javaSE\\src\\fileIO\\hello.txt");
        //获取这个路径下的 child文件夹/文件
        File f3=new File("E:\\idea_workplace\\javaSE","src");
        File f4=new File(f3, "fileIO");

        //上面中只在内存中定义了对象， 没有真正设计是否存在这些文件，不会报错

        System.out.println(f1.getAbsoluteFile());
        System.out.println(f1.getPath());
        System.out.println(f1.getParent());
        System.out.println(f1.getName());  //文件名字
        System.out.println(f1.length());  //文件大小
        System.out.println(new Date(f1.lastModified()));  //文件最近修改的时间
//
        //获取指定路径下的全部 文件名称
        String[] list = f3.list();
        for(String s:list)
            System.out.println(s);
        //获取指定路径下的全部 文件对象
        System.out.println("**********");
        File[] files = f3.listFiles();
        for(File i:files){
            System.out.println(i);
        }

//        将指定的file 移动到某个位置并且命名为新的名字
//        将IOstream\\src\\filetxt 的文件 移动到IOstream并且更名为filetxt
//        这个函数会返回 一个boolean  如果目标路径不存在名字为filetxt的文件，转移成功
//        如果存在则移动失败，返回false
//        File file=new File("IOstream\\src\\filetxt");
//        file.renameTo(new File("IOstream\\filetxt"));

//
//         public boolean isDirectory()：判断是否是文件目录
//         public boolean isFile() ：判断是否是文件
//         public boolean exists() ：判断是否存在
//         public boolean canRead() ：判断是否可读
//         public boolean canWrite() ：判断是否可写
//         public boolean isHidden() ：判断是否隐藏

        System.out.println(f3.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.exists());
        System.out.println(f3.canRead());  //可读可写不局限于对文件而言，包括文件夹
        System.out.println(f3.canWrite());
        System.out.println(f3.isHidden());

//         File类的创建功能
//         public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false

//         File类的删除功能
//         public boolean delete()：删除文件或者文件夹
//                删除注意事项：
//                Java中的删除不走回收站。
//                要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
        File f5=new File("src/fileIO/hello1.txt");
        if(f5.exists()){
            f5.delete();
        }
        else {
            try {
                f5.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        文件目录的创建
//         public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
//                如果此文件目录的上层目录不存在，也不创建。
//         public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
//                注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目
//                路径下。
        File f6=new File("src/fileIO/IO");
        System.out.println(f6.mkdir());



    }

}
