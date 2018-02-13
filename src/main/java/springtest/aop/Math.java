package springtest.aop;

import org.springframework.stereotype.Component;

@Component("math")
public class Math implements IMath {
	//加
    public int add(int n1, int n2){
        int result=n1+n2;
        System.out.println(n1+"+"+n2+"="+result);
        return result;
    }
    
    //减
    public int sub(int n1, int n2){
        int result=n1-n2;
        System.out.println(n1+"-"+n2+"="+result);
        return result;
    }
    
    //乘
    public int mut(int n1, int n2){
        int result=n1*n2;
        System.out.println(n1+"X"+n2+"="+result);
        return result;
    }
    
    //除
    public Integer div(int n1, int n2){
        int result=n1/n2;
        System.out.println(n1+"/"+n2+"="+result);
        return result;
    }
    //绝对值
    public String abs(int n){

        return( n > 0? n :-n) +"";
    }
}