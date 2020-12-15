package Toy;

public class Toggle {

    volatile boolean toggle;

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public boolean isToggle() {
        return toggle;
    }

    public void onToggle(){
        System.out.println(Thread.currentThread().getName() + " включил тумблер");
    }

    public void offToggle(){
        System.out.println(Thread.currentThread().getName() + " выключил тумблер");
    }
}
