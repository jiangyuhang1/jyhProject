package com.jyh.pattern.structType.decorator;

/**
 * 装饰模式客户端，大圣本尊是个猴子，具有七十二变化，可以装饰成鱼儿，在从鱼儿装饰成鸟
 * 1.由于所有的具体装饰类对象都是由抽象角色生成的，装饰出来的类也有顶层抽象角色统一管理
 * 2.透明类装饰模式要求所有装饰角色由被装饰的角色(抽象构件角色)统一生成管理
 * 3.一般装饰类都会进行拓展方法，有些方法不是原来被装饰角色上的，此时调用这些方法不能够使用被装饰角色管理了
 *   此时的装饰模式又叫半透明装饰模式
 * 4.在java i/o模型中得到应用
 * 5.装饰模式的作用是为了拓展对象的功能
 */
public class DecoratorClient {

    public static void main(String[] args) {
        GreatSage gs = new Monkey();

        GreatSage fish = new Fish(gs);
        GreatSage bird = new Bird(fish);

        gs.move();
        fish.move();
        bird.move();

        /**
         * 纯粹的装饰模式太少，基本上装饰角色都有自己的行为，不全是装饰行为
         */
        Fish fish1 = new Fish(gs);
        Bird bird1 = new Bird(gs);

        fish1.eat();
        bird1.eat();
    }
}
