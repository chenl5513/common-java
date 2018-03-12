package nio.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
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
                /*int read = channel.read(readBuffer);
                final  int remain = readBuffer.remaining();
                byte[] bytes = new byte[1024];
                readBuffer.flip();
                readBuffer.get(bytes);*/
                byte[] bytes = readBuffer.array();
                System.out.println(new String(bytes,"utf-8"));
                channel.close();

            }




        }


    }


    public static void main(String[] args) {
        new NioServer().start();
    }


}
