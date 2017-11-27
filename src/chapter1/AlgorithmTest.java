package chapter1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class AlgorithmTest {
    public static void main(String[] args)
    {
        String filepath = "E:\\IdeaProject\\algorithm\\data\\algorithm_test_data.txt";
        System.out.println(filepath);
        try
        {
            File file = new File(filepath);
            if(!file.exists()) {
                //如果不存在data.txt文件则创建
                file.createNewFile();
                System.out.println("测试数据创建完成");
            }
            //创建文件写入:
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            //产生随机数据，写入文件
            Random random = new Random();
            for(int i=0;i<10;i++) {
                //产生0-10000之间随机数:
                int randint =(int)Math.floor((random.nextDouble()*10.0));
                //写入一个随机数:
                bw.write(String.valueOf(randint));
                //新的一行:
                bw.newLine();
            }
            bw.close();
            fw.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
