package cn.com.mx.aInterview;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by wangchangye on 2017/3/29.
 *
 * @Author wangchangye
 */
public class DeleteFile {


    public static void main(String[] args) throws Exception{
        deletefile("E:\\开发学习资料\\大数据课程");
    }

    public static boolean deletefile(String delpath)
          throws Exception {
      try {

          File file = new File(delpath);
          if (!file.isDirectory()) {
              System.out.println("1");
              file.delete();
          } else if (file.isDirectory()) {
              System.out.println("2");
              String[] filelist = file.list();
              for (int i = 0; i < filelist.length; i++) {
                  File delfile = new File(delpath + "\\" + filelist[i]);
                  if (!delfile.isDirectory()) {
                      System.out.println("path=" + delfile.getPath());
                      System.out.println("absolutepath="
                              + delfile.getAbsolutePath());
                      System.out.println("name=" + delfile.getName());
                      delfile.delete();
                      System.out.println("删除文件成功");
                  } else if (delfile.isDirectory()) {
                      deletefile(delpath + "\\" + filelist[i]);
                  }
              }
              file.delete();

          }

      } catch (FileNotFoundException e) {
          System.out.println("deletefile()  Exception:" + e.getMessage());
      }
      return true;
  }



}//
