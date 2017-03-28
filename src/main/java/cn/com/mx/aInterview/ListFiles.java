package cn.com.mx.aInterview;

import java.io.File;

/**
 * Created by wangchangye on 2017/3/28.
 *
 * @Author wangchangye
 */
public class ListFiles {
    public static void main(String[] args) {
        traverseFolder2("E:\\gomeo2o_pro\\venus-properties\\venus-web");
    }

    public static void traverseFolder2(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("file is empty!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("file directory" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        System.out.println("file name:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("file not exist!");
        }
    }
}//
