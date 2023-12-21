package com.example.java_final_projectfx;

import java.util.ArrayList;

/**
 * @Person.java (abstract class) "Ahmet Önder Önlü"
 * Bu classi olusturmus oldugum ogrenci ve ogretmen sinif-
 * lari icin ust sinif olarak kullanacagim. Abstract
 * olmasinin nedeni bazi yerleri override edilmeli ve ekleme
 * yapilmali. Diger siniflarin ortak noktalarini olusturacak.
 */

// Person soyut sınıfı oluşturuldu.
public abstract class Person {
    private String name;
    private String surname;
    private String title;
    private int number;
    private int what_year;

    String universityName = "Marmara University";
    String campus = "Goztepe";

    //Person constructorı oluşturuldu.
    public Person(String name, String surname, String title, int no, int what_year) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.number = no;
        this.what_year = what_year;
    }

    // Seçmeli ve zorunlu ders arraylistleri oluşturuldu. Ders depolama için kayıt edilir.
    public abstract ArrayList<OptionalLessons> getOptLes();
    public abstract ArrayList<FieldLessons> getFldLes();

    public abstract void show_info();

    // Öğrenci kayıt olduğunda otomatik olarak çağırılır ve bildirim ekrana verilir.
    public String  notification(String name, String surname){
        return (name + " " + surname + " successfully logged in");
    }
    // abstract metodlar oluşturuldu override edilmeli ve hata olursa fırlatıldı.

    public abstract void addOptionalLessons(OptionalLessons oL) throws Alreadyhave, BoundOfLessons;

    public abstract void addFieldLessons(FieldLessons fL) throws Alreadyhave, BoundOfLessons;

    public abstract void deleteOptionalLessons(OptionalLessons oL) throws NotFound;

    public abstract void deleteFieldLessons(FieldLessons fL) throws NotFound;

    public int getWhat_year() {
        return what_year;
    }

    public void setWhat_year(int what_year) {
        this.what_year = what_year;
    }

    public abstract void show_all_lessons();

    // getter ve setterlar oluşturuldu.
    public String getName() {
        return name;
    }

    @Override
    public abstract String toString();

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

// Tüm kullandığım hata kontrol sınıflarım burada
class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}
class NotFound extends MyException{
    public NotFound(String message){
        super(message);
    }
}

class Alreadyhave extends Exception{
    public Alreadyhave(String message){
        super(message);
    }
}

class BoundOfLessons extends MyException{
    public BoundOfLessons(String message){
        super(message);
    }
}
