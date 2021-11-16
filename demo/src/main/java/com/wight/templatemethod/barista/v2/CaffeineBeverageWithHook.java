package com.wight.templatemethod.barista.v2;

/**
 * @author wight
 * @date 2021/11/16
 * @apiNote
 */
public abstract class CaffeineBeverageWithHook {
    void prepareRecipe() {
        boilWaster();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 冲泡的一种手段
     */
    abstract void brew();

    /**
     * 加入调料
     */
    abstract void addCondiments();

    void boilWaster() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    boolean customerWantsCondiments() {
        return true;
    }
}
