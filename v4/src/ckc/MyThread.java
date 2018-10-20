package ckc;

import java.sql.Connection;

public class MyThread extends Thread{
    public Connection conn;
    public Dictionary dict;
    public String value;
    public MyThread(Connection conn, Dictionary dict, String value){
        this.conn = conn;
        this.dict = dict;
        this.value = value;
    }

    @Override
    public void run(){
//        ConfigConnection configConnection = new ConfigConnection();
//
//        dict = configConnection.getData(conn,value);
//
//        System.out.println("1111111111111111111111111111111");
//
//        for (int i =0;i<this.dict.arWords.size();i++)
//            System.out.println(dict.arWords.get(i).word_target);
    }
//    public Dictionary getDict(){
//        return  dict;
//    }

}
