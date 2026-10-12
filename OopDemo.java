/**
 * 面向对象基础实验：对象、类、封装、接口与继承。
 *
 * 本文件刻意不使用 package，方便作为第一个单文件 Java 程序运行。
 */
interface Rideable {
    void changeCadence(int newValue);

    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}

class Bicycle implements Rideable {
    // 字段：对象的状态。private 表示外部不能直接修改它们。
    private int cadence = 0;
    private int speed = 0;
    private int gear = 1;

    @Override
    public void changeCadence(int newValue) {
        cadence = newValue;
    }

    @Override
    public void changeGear(int newValue) {
        if (newValue < 1 || newValue > 6) {
            System.out.println("档位必须在 1 到 6 之间。");
            return;
        }
        gear = newValue;
    }

    @Override
    public void speedUp(int increment) {
        speed = speed + increment;
    }

    @Override
    public void applyBrakes(int decrement) {
        speed = Math.max(0, speed - decrement);
    }

    // 方法：对象向外提供的行为。
    public void printStates() {
        System.out.println("踏频：" + cadence
                + "，速度：" + speed
                + "，档位：" + gear);
    }
}

// MountainBike 是 Bicycle 的子类，因此会继承其公开方法。
class MountainBike extends Bicycle {
    private final int suspensionLevel;

    MountainBike(int suspensionLevel) {
        this.suspensionLevel = suspensionLevel;
    }

    public void printMountainBikeInfo() {
        System.out.println("避震等级：" + suspensionLevel);
        printStates();
    }
}

public class OopDemo {
    public static void main(String[] args) {
        // 两个对象各自保存自己的状态。
        Bicycle bike1 = new Bicycle();
        bike1.changeCadence(50);
        bike1.speedUp(10);
        bike1.changeGear(2);
        bike1.printStates();

        MountainBike bike2 = new MountainBike(3);
        bike2.changeCadence(40);
        bike2.speedUp(20);
        bike2.changeGear(3);
        bike2.printMountainBikeInfo();
    }
}
