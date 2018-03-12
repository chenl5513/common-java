package nio.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @User chenlei
 * @Date 2018/3/10
 * @Time 20:00
 * @Description
 */
public class NioClient {


    private SocketChannel socketChannel;
    private Selector selector;
    private boolean isStart = true;

    public void start(){

        try {

            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            boolean isConnected = socketChannel.connect(new InetSocketAddress("localhost", 8888));
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
            /*if(isConnected){
                //连上了
                socketChannel.register(selector,SelectionKey.OP_READ);
                //发送数据
                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                writeBuffer.put("我是一只鸟".getBytes());
                socketChannel.write(writeBuffer);
                socketChannel.close();
            }else {
                //没连上,注册等待链接的事件
                socketChannel.register(selector,SelectionKey.OP_CONNECT);
            }*/


            while(isStart){
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

    private void handleSelectionKey(SelectionKey selectionKey) throws IOException {
        //是否能用
        if(selectionKey.isValid()){

            //读事件
            if(selectionKey.isWritable()){

                //发送数据
                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                writeBuffer.put("我是一只鸟".getBytes());
                socketChannel.write(writeBuffer);
                socketChannel.close();
                isStart = false;

            }
            if(selectionKey.isConnectable()){

                SocketChannel channel = (SocketChannel) selectionKey.channel();
                // 如果正在连接，则完成连接
                if(channel.isConnectionPending()){
                    channel.finishConnect();

                }
                // 设置成非阻塞
                channel.configureBlocking(false);

                //在这里可以给服务端发送信息哦
                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                writeBuffer.put("我是一只鸟".getBytes("UTF-8"));
                //writeBuffer.flip();
                channel.write(writeBuffer);

                //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                channel.register(this.selector, SelectionKey.OP_READ);
                channel.close();
                isStart = false;


            }
        }



    }

    public static void main(String[] args) {
        new NioClient().start();

    }




}
