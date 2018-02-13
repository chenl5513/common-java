package com.simple;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2017/7/3.
 */
public class demo1 {

    @Test
    public void fun1(){

        ThreadLocal<String> tl = new ThreadLocal<String>();
        tl.set("haha");
        tl.set("haha12312");
        System.out.println(tl.get());
        //类似
        //Thread.currentThread().threadLocals.get(t1);
    }
    @Test
    public void fun2(){

        HashMap map = new HashMap();

        System.out.println(map.put("123","123"));
        System.out.println(map.put("123","123"));
        Hashtable table = new Hashtable();

    }

    @Test
    public void fun3() throws IOException, ClassNotFoundException {

        Car car = new Car();
        car.setName("啦啦啦");

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("car.bin"));
        oo.writeObject(car);
        oo.close();
        System.out.println(demo1.class.getResource(""));

        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("car.bin"));
        Car c  = (Car) oi.readObject();
        System.out.println(c.getName());


        File f = new File("/");
        System.out.println(f.getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
    }
    @Test
    public void fun4() throws IOException {
        //StringBuffer sb = new StringBuffer();


        //StringBuilder stringBuilder = new StringBuilder();

        Properties p = new Properties();
        p.load(new FileInputStream("A.properties"));
        System.out.println(p.getProperty("hh"));
        byte[] b ="123".getBytes();
 		List li = Arrays.asList(b);

    }

}
