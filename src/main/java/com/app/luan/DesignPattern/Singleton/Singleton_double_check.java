package com.app.luan.DesignPattern.Singleton;

public class Singleton_double_check {
    // 私有构造
    private Singleton_double_check() {}

    private static Singleton_double_check single = null;

    // 双重检查
    public static Singleton_double_check getInstance() {
        if (single == null) {
            synchronized (Singleton_double_check.class) {
                if (single == null) {
                    single = new Singleton_double_check();
                }
            }
        }
        return single;
    }
}