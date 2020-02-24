package fileIO;

import java.io.*;

/**
 *
 * FileReader和FileWriter只能处理字符文件不能处理字节文件
 *一个汉字占三个字符
 *  FileReader
 *  FileWriter
 *  FileInputStream
 *  FileOutputStream  这四个流都是属于节点流
 *
 *
 * @author cky
 * @create 2020 2 20 10:38
 */
public class FileIO_API {
    //文件在main 方法中的路径是 工程路径
    //在@test 是modual路径
    public static void main(String[] args)  {
//        System.out.println(filein("src/fileIO/hello.txt"));
//        System.out.println(fileout_append("src/fileIO/hello.txt", "hello io"));
        System.out.println(copybytefile("src/fileIO/hello.txt", "src/fileIO/hello2.txt"));

    }
    //文件读入
    public  static String filein(String s){

        StringBuilder res=new StringBuilder();
        FileReader fr=null;
        try {
            fr=new FileReader(new File(s));
            char[] cbuf=new char[2];
            //char数组要注意
            int len;
//            错误写法，因为是char数组，正常来说是要进行清零操作，然后再进行fr.read()
//            不然char中的内容没清理掉会产生错误
//            while((len=fr.read(cbuf))!=-1){
//                //System.out.println(len);
//                res.append(cbuf);
//            }
            while((len=fr.read(cbuf))!=-1){
                //System.out.println(len);
                res.append(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res.toString();
    }
    //文件写入追加
    //如果路文件径文件不存在，会自动创建
    //对于文件存在，是追加还是覆盖取决于调用的构造函数，
    public static  boolean fileout_append(String filename,String text){
        File f=new File(filename);
        FileWriter fw= null;
        try {
            fw = new FileWriter(f,true);
            fw.write("\n"+text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    //文件复制
    public static  boolean copybytefile(String srcfile,String destfile){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream(new File(srcfile));
            fos = new FileOutputStream(new File(destfile));
            byte []buffer =new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (fos!=null) {
                    fos.close();
                }
                if (fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;
    }

}
