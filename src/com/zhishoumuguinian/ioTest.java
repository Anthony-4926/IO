package com.zhishoumuguinian;

import java.io.*;

/**
 * @author 赵鑫
 * @create 2019-03-09 10:06
 */
public class ioTest {
    public static void main(String[] args) throws IOException {
        /**
         * 基于单个字符从文件中读取数据
         */
        FileInputStream in = null;
        FileOutputStream out = null;
        int c;
        try {
            in = new FileInputStream("C:\\Users\\赵鑫\\Desktop\\io.txt");
            out = new FileOutputStream("C:\\Users\\赵鑫\\Desktop\\o.txt");
            while ((c = in.read()) != -1){
                System.out.println(c);
                out.write(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        }

    }
}
