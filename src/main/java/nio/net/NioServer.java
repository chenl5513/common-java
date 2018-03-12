package nio.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @User chenlei
 * @Date 2018/3/10
 * @Time 20:00
 * @Description
 */
public class NioServer {

    private boolean isRun = true;
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private SocketChannel socketChannel;

    public void start(){


        try {
            selector  = Selector.open();
            //通过open方法来打开一个未绑定的ServerSocketChannel实例
            serverSocketChannel = ServerSocketChannel.open();
            //将该ServerSocketChannel绑定到指定ip地址
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost",8888));
            //设置不阻塞
            serverSocketChannel.configureBlocking(false);
            //将ServerSocketChannel注册到指定Selector对象
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


            while(isRun){
                if(selector.select() > 0){
                    //有事件
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()){
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        handleSelectionKey(selectionKey);
                    }



                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    /**
     * 处理selectionKey
     * @param selectionKey
     */
    private void handleSelectionKey(SelectionKey selectionKey) throws IOException {

        //是否能用
        if(selectionKey.isValid()){
            //连接事件
            if(selectionKey.isAcceptable()){
                System.out.println("log for :connecting.....");
                ServerSocketChannel  channel = (ServerSocketChannel) selectionKey.channel();
                socketChannel = channel.accept();
                //设置非阻塞
                socketChannel.configureBlocking(false);
                socketChannel.register(selector,SelectionKey.OP_READ);
                //将selectionKey对应的Channel设置成准备接受其他请求
                //selectionKey.interestOps(SelectionKey.OP_ACCEPT);
            }
            //读事件
            if(selectionKey.isReadable()){

                System.out.println("log for :read.....");

                SocketChannel channel = (SocketChannel) selectionKey.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int read = channel.read(readBuffer);
                /*final  int remain = readBuffer.remaining();
                byte[] bytes = new byte[1024];
                readBuffer.flip();
                readBuffer.get(bytes);*/
                readBuffer.flip();
                byte[] bytes = readBuffer.array();
                System.out.println(new String(bytes));


                response(channel);
                channel.close();

            }




        }


    }

    private void response(SocketChannel channel) {

        String body = "<html><head></head><body><h1>哈哈哈</h1></body></html>";

        String response = "HTTP/1.1 200 OK \r\n";
        response += "Date: "+new Date().toGMTString()+"\r\n";
        response += "Server: localhost\r\n";
        response += "Content-Type: text/html;charset=utf-8\r\n";
        response += "Content-Encoding: gzip\r\n";
        response += "Connection: Keep-Alive\r\n";
        try {
            response += "Content-Length: "+body.getBytes("UTF-8").length+"\r\n\r\n";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response += body;

        System.out.println(response);
        try {
            channel.write(ByteBuffer.wrap(response.getBytes("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        new NioServer().start();
    }


}
