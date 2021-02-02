package com.dudu.utils;

import java.io.*;

public class MyClassLoader extends ClassLoader {


    private String path;
    private String className;


    public MyClassLoader(String path,String className){
        this.path=path;
        this.className=className;

    }


    //用于寻找类文件

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes=loadClassData(name);
        return defineClass(name,bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name) {
        name=path+name+".class";
        InputStream in=null;
        ByteArrayOutputStream bos=null;
        try{
            in=new FileInputStream(new File(name));
            bos=new ByteArrayOutputStream();
            int i=0;
            while((i=in.read())!=-1){
                bos.write(i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bos.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return bos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader m=new MyClassLoader("C:\\Users\\A\\Desktop\\","Test");
        Class<?> test = m.findClass("Test");
        Object o = test.newInstance();
        System.out.println(test.getClassLoader().getParent());
        System.out.println(test.getClassLoader().getParent().getParent());
        System.out.println(test.getClassLoader().getParent().getParent().getParent());
    }
}
