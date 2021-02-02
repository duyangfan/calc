package com.dudu.calc;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SaSum {


    public static void main(String[] args) throws Exception {
        Map<String,Double> map=new LinkedHashMap<>();
        Scanner sc=new Scanner(System.in);
        FileOutputStream fos = gerOutStream();
        System.out.print("A :");
        int a=sc.nextInt();
        writeFile("现在"+a,fos);

        System.out.print("f : ");
        int f=sc.nextInt();
        writeFile("预计到"+f,fos);
        float s=0;

        double[] res=new double[3];
        System.out.print("t:");
        res[0]=sc.nextInt();
        double t=0;

        print(sc,"case1 3000-",res,5000,a,f,s,map,fos);
        for (Map.Entry<String,Double> entry:map.entrySet()){
            t=entry.getValue();
            System.out.println(entry.getKey()+"    "+entry.getValue()+"  "+res[1] +"     "+res[2]);
            String str=entry.getKey()+"    "+entry.getValue()+"     "+res[1] +"       "+res[2];
            writeFile(str,fos);
        }
        System.out.println("total :"+(t+res[2]));
        writeFile("total :"+(t+res[2]),fos);

        close(fos);

    }




    public static Map<String,Double> print(Scanner sc, String key,double res[], int west, int current, int future, double s, Map<String,Double> map,FileOutputStream fos) throws Exception {
        if(current>=future){
            return map;
        }
        String teg=key+current+"----------------------------------------------------------------";
        System.out.println(teg);
        writeFile(teg,fos);

        System.out.print("B:");
        int hb=sc.nextInt();
        res[0]-=hb;
        writeFile("买东西花费:"+hb,fos);
        res[2]+=hb;


        System.out.print("C:");
        int come=sc.nextInt();
        writeFile("月收入："+come,fos);

        System.out.print("west:");
        west=sc.nextInt();
        writeFile("月开支："+west,fos);


        System.out.print("zb:");
        double zb=sc.nextDouble();
        writeFile("投资占比："+zb,fos);

        System.out.print("s:");
        s=sc.nextFloat();
        writeFile("预计收益："+s,fos);


        sum(res,0,come,0,west,0,0,s,zb,fos);
        current++;
        map.put(key+"-"+current,res[0]);

        return print(sc,key,res,west,current,future,s,map,fos);
    }

    public static void sum(double[] res,int temp,int come,int month,int west,int totalWest,int current,double s,double zb,FileOutputStream fos) throws Exception {
        if(month>=12){
            return ;
        }
        res[0]+=(come-west+current);
        int LC=0;
        if(res[0]>=0){
            LC=(int) (res[0]*zb);
        }

        if(LC>=0){
            current= (int) (LC*s);
        }
        res[2]+=west;
        res[1]+=current;
        temp+=current;
        totalWest+=west;
        month++;

        System.out.println("month:"+month+"  total:"+res[0]+"     totalWest:"+totalWest+"     LC:"+LC+"     current:"+current+"     temp:"+res[1]
                +"      SY: "+(float)((temp/res[0])*100)+"%" +"     MC:"+(float)((current/res[0])*100)+"%");

        String info="月份 :"+month+"  总收入:"+res[0]+"     今年开支:"+totalWest+"     当月投资:"+LC+"     当月收入:"+current+"     今年总收益:"+res[1]
                +"      至今收益率: "+(float)((temp/res[0])*100)+"%" +"     当月收益率:"+(float)((current/res[0])*100)+"%";

        writeFile(info,fos);

        sum(res,temp,come,month,west,totalWest,current,s,zb,fos);
    }


    public static FileOutputStream gerOutStream() throws Exception {
        File file=new File("D:\\Myself\\Base\\src\\main\\cs.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos=new FileOutputStream(file,true);
        return fos;
    }



    public static void  writeFile(String str ,FileOutputStream fos) throws Exception {
        str=str+"\n";
        fos.write(str.getBytes("utf-8"));
    }


    public static void close(FileOutputStream fos) throws Exception {
        fos.close();
    }










}
