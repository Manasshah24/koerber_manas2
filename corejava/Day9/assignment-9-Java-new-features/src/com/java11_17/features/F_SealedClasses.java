package com.java11_17.features;

//https://rollbar.com/blog/what-are-sealed-classes-in-java/
//sealed here means this can be inherited nly by Dog and Cat and not other unrrleated classes
sealed class  Animal permits Dog, Cat{
    void sound(){

        System.out.println("This is animal");
    }
}
// nonsealed means it can be inherited by other subclass
non-sealed class Dog extends Animal{
    void sound(){
        System.out.println("bark");
    }


}
//final means it cannot be inherited ..this is the last class of tht type
final class Cat extends Animal{
    @Override
    void sound() {
        System.out.println("meow");
    }
}
//class Human extends Animal{
//
//} this is not possible because animal is sealed class which can be inherited nly by cat and dog classes

public class F_SealedClasses {
    public static void main(String[] args) {

    }
}
