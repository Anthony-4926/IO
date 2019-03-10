package com.zhishoumuguinian;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalTime;

/**
 * @author 赵鑫
 * @create 2019-03-09 10:06
 */
public class ioTest {
    public static void main(String[] args) throws IOException {
        /**
         * 基于单个字符从文件中读取数据
         */

        int c;
        /**
         * 将资源卸载try语句里，基于try-with-resource 自动关闭资源，简化了finally的资源关闭，
         */
        try (FileInputStream in = new FileInputStream("C:\\Users\\赵鑫\\Desktop\\io.txt");
             FileOutputStream out = new FileOutputStream("C:\\Users\\赵鑫\\Desktop\\o.txt")) {

            long begin = System.nanoTime();
//             read()返回值为下一个流中下一个字符的assic码
            while ((c = in.read()) != -1) {
//                System.out.println(c);
//                write()将assic码转换为字符写到文件中
                out.write(c);
            }
            long end = System.nanoTime();
            System.out.println("第一种时间：" + (end - begin));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 基于缓冲区读取文件
         */

        try (FileInputStream in = new FileInputStream("C:\\Users\\赵鑫\\Desktop\\io.txt");
             FileOutputStream out = new FileOutputStream("C:\\Users\\赵鑫\\Desktop\\o1.txt")) {
            byte[] buffer = new byte[3];
            int len;
            long begin = System.nanoTime();
//            read(byte[]) 返回值为读取的长度
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            long end = System.nanoTime();
            System.out.println("第二种时间：" + (end - begin));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
