package javaassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Semaphore;

/**
 * Title: JavaAssist
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2018/1/30
 * @version 1.0
 * @since 1.0
 */
public class JavaAssist {



	public static void main(String[] args) throws CannotCompileException, NotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
		ClassPool classPool = ClassPool.getDefault();
		CtClass myClass = classPool.makeClass("com.sample.MyClass");

		CtField field = CtField.make("private String str;",myClass);
		myClass.addField(field);

		CtMethod method = CtMethod.make("public String getStr(){return this.str;}",myClass);
		myClass.addMethod(method);

		CtConstructor ctConstructor = new CtConstructor(new CtClass[]{classPool.get("java.lang.String"),classPool.get("java.lang.String")},myClass);
		ctConstructor.setBody("{this.str=$2;}");
		myClass.addConstructor(ctConstructor);
		myClass.writeFile("C:\\Users\\chenl\\Desktop");

		Class c = myClass.toClass();
		Constructor constructor = c.getConstructor(String.class,String.class);
		Object obj = constructor.newInstance("啦啦啦","aa");
		System.out.println(c.getMethod("getStr").invoke(obj));

		Semaphore semaphore = new Semaphore(10);
		//semaphore.acquire();



	}
}
