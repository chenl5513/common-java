package springtest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Title: Advices
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/10/17
 * @version 1.0
 * @since 1.0
 */
@Aspect
@Component
public class TestAspect {


	@Pointcut("execution(public * springtest.aop..*.*(.. ))")
	public  void pointcut(){


	}
	@Before("pointcut()")
	public void doBefore(JoinPoint point) {
		echo("前置通知");
		System.out.println("args=="+ Arrays.toString(point.getArgs()));
		System.out.println("kind=="+point.getKind());
		System.out.println("Signature=="+point.getSignature());
		System.out.println("Signature->name=="+point.getSignature().getName());
		System.out.println("Signature->DeclaringTypeName=="+point.getSignature().getDeclaringTypeName());
		System.out.println("Signature->DeclaringType=="+point.getSignature().getDeclaringType());
		System.out.println("Signature->DeclaringType->Name=="+point.getSignature().getDeclaringType().getName());
		System.out.println("Signature->Modifiers=="+point.getSignature().getModifiers());
		System.out.println("SourceLocation=="+point.getSourceLocation());
		System.out.println("SourceLocation->WithinType=="+point.getSourceLocation().getWithinType());
		System.out.println("StaticPart=="+point.getStaticPart());
		System.out.println("Target=="+point.getTarget());
		System.out.println("This=="+point.getThis());
		echo("前置通知");
	}


	//声明后置通知
	/*@AfterReturning(value = "pointcut()", returning = "result")
	public void doAfterReturning(String result) {
		echo("后置通知1");
		System.out.println("---" + result + "---");
		echo("后置通知1");
	}*/
	@AfterReturning(value = "pointcut()", returning = "result")
	public void doAfterReturning(Integer result) {
		echo("后置通知2");
		System.out.println("---" + result + "---");
		echo("后置通知2");
	}

	@After("pointcut()")
	public void doAfter(JoinPoint point) {
		echo("最终通知");
	}

	//声明环绕通知
	@Around("pointcut()")
	public Object doAround(ProceedingJoinPoint pjp){
		echo("进入方法---环绕通知");
		Object o= null;
		try {
			o = pjp.proceed();
		}catch (Throwable e){
			echo("处理了~");
		}
		//System.out.println(o.getClass());
		echo("退出方法---环绕通知");
		return o;
	}

	//声明例外通知
	@AfterThrowing(pointcut = "pointcut()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		System.out.println("例外通知");
		System.out.println(e.getMessage());
	}






	public void echo(String str){
		System.out.println(String.format("============%s===========",str));


	}



}
