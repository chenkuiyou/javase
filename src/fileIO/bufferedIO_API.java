package fileIO;

import java.io.*;

/**
 * @author cky
 * @create 2020 2 20 11:48
 */
public class bufferedIO_API {
    public static void main(String[] args) {
        System.out.println(copycharfile("src/fileIO/hello.txt", "src/fileIO/hello3.txt"));
    }
    //非文本文件的文件复制
    //使用了 处理流
    //读入的是固定大小的byte数组 ，中间存储的介质是byte数组
    //使用处理流复制文库速度较快
    //因为内部创建了一个缓冲区，先将字节读入缓冲区在进行操作
    public static  boolean copybytefile(String srcfile,String destfile){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            fis = new FileInputStream(new File(srcfile));
            fos = new FileOutputStream(new File(destfile));
            bis =new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);

            byte []buffer =new byte[1024];
            int len;
            while ((len=bis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (bos!=null) {
                    bos.close();
                }
                if (bis!=null) {
                    bis.close();
                }
//                在关闭外层的处理流的时候会自动关闭内部的节点流流
//                if (fos!=null) {
//                    fos.close();
//                }
//                if (fis!=null) {
//                    fis.close();
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;
    }

    //文本文件的复制
    //读入的是一整行 ，中间存储的介质是String
    public static  boolean copycharfile(String srcfile,String destfile){
        FileReader fis= null;
        FileWriter fos= null;
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            fis = new FileReader(new File(srcfile));
            fos = new FileWriter(new File(destfile));
            br =new BufferedReader(fis);
            bw=new BufferedWriter(fos);

            String cbuffer =new String();
            while ((cbuffer=br.readLine())!=null){
                bw.write(cbuffer);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (br!=null) {
                    br.close();
                }
                if (bw!=null) {
                    bw.close();
                }
//                在关闭外层的处理流的时候会自动关闭内部的节点流流
//                if (fos!=null) {
//                    fos.close();
//                }
//                if (fis!=null) {
//                    fis.close();
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;
    }
}
