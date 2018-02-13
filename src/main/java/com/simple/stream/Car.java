package com.simple.stream;


public class Car {



    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
        System.out.println( "Following the this" + car.toString() );
    }
         
    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
        System.out.println( "Following the this" + this.toString() );
    }
         
    public void repair() {   
        System.out.println( "Repaired " + this.toString() );
    }
}