package com.simple;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created by Administrator on 2017/7/12.
 */
public class TestQrcode {


    public static void main(String[] args) {


        String url = "http://www.baidu.com" ;
        String filePath = "e:/1.png";
        encode(url,filePath);

    }


    static void encode(String conent, String filePath) {
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder();
        byte[] b = null;
        try { // Convert a string to ISO-8859-1 bytes in a ByteBuffer
            System.out.println("-------->" + conent.length());
            ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(conent));
            b = bbuf.array();
        } catch (CharacterCodingException e) {
            System.out.println(e.getMessage());
        }
        String data = "";
        try {
            data = new String(b, "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } // get a byte matrix for the data
        BitMatrix matrix = null;
        int h = 900;
        int w = 800;
        com.google.zxing.Writer writer = new QRCodeWriter();
        try {
            matrix = writer.encode(data,
                    com.google.zxing.BarcodeFormat.QR_CODE, w, h);
        } catch (com.google.zxing.WriterException e) {
            System.out.println(e.getMessage());
        }
        File file = new File(filePath);
        try {

            MatrixToImageWriter.writeToFile(matrix, "PNG", file);
            System.out.println("printing to " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
