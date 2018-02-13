package com.simple;

/**
 * Created by Administrator on 2017/7/5.
 */

import org.junit.Test;

/**
 * 设计模式
 */
public class demo2 {


    /**
     * 工厂方法模式
     */
    @Test
    public void fun1() throws Exception {

        Sender sender = SenderFactory.getSender("mail");
        sender.send();


    }

    interface  Sender{
        void send();
    }

    static class MailSender implements Sender{
        @Override
        public void send() {
            System.out.println("发送了一封邮件");
        }
    }
    static class MsgSender implements Sender{
        @Override
        public void send() {
            System.out.println("发送了一条消息");
        }
    }

    static class SenderFactory{

        public  static Sender getSender(String name) throws  Exception{

            if("msg".equals(name)){

                return new MsgSender();
            }else  if("mail".equals(name)){
                return new MailSender();
            }else{

                throw new Exception("未知名");
            }


        }


    }

    /**
     * 适配器模式
     */
    @Test
    public void fun2(){



    }



}
