package com.example.java_final_projectfx;

/*
 * @Lesson.java (interface) "Ahmet Önder Önlü"
 * Bu classi olusturmus oldugum Secmeli ve zorunlu sinif-
 * lar icin ust sinif olarak kullanacagim. Interface
 * olmasinin nedeni diğer iki sinif icin temel olması ve override
 * edilecek.
 */
public interface Lesson {
    String universityName = "Marmara University";
    String campus = "Goztepe";

    int optionalLesson_time = 3;
    int fieldLesson_time = 4;

    public abstract void show_lesson_info();
    public abstract int get_course_time();

    public abstract String get_lesson_name();

}
