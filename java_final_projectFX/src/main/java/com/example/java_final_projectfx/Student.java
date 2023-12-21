package com.example.java_final_projectfx;

import java.util.ArrayList;
// Student class öğrencileri oluşturmak için açıldı
public class Student extends Person{
    private ArrayList<OptionalLessons> optionalLessons;
    private ArrayList<FieldLessons> fieldLessons;
    public static int amountOfFieldLessons = 0;
    public static int amountOfOptionalLessons = 0;
    // constructor oluşturuldu ve extend edilen class super ile çağrıldı
    public Student(String name, String surname, String title,int what_year, int no) {

        super(name, surname, title, no, what_year);
        notification(name, surname);
        optionalLessons = new ArrayList<>();
        fieldLessons = new ArrayList<>();


    }
// verileri gösteren fonksiyon override edildi
    @Override
    public void show_info() {
        System.out.println("***** Student Information's: ***** ");
        System.out.println("Student's Name: " + getName());
        System.out.println("Student's Surname: "+ getSurname());
        System.out.println("Student's Title: " + getTitle());
        System.out.println("Student's Year: " + getWhat_year());
        System.out.println("Student's name of university and campus: " + universityName + campus);
    }

    // Seçmeli dersler bu fonksiyon ile arrayliste eklenir.
    public void addOptionalLessons(OptionalLessons oL) throws Alreadyhave, BoundOfLessons {

        if(optionalLessons.contains(oL)){
            throw new Alreadyhave("Bu ders zaten eklenmis!");
        }

        if(super.getWhat_year() == 1 || super.getWhat_year() == 2)
            if(amountOfOptionalLessons < 3) {
                optionalLessons.add(oL);
                amountOfOptionalLessons++;
                System.out.println("Secmeli ders eklendi.");
            }
            else{
                throw new BoundOfLessons("Derslerin dolu ekleyemezsin!");
            }
        else
        if(amountOfOptionalLessons < 4) {
            optionalLessons.add(oL);
            amountOfOptionalLessons++;
            System.out.println("Secmeli ders eklendi. ");
        }
        else{
            throw new BoundOfLessons("Derslerin dolu ekleyemezsin!");
        }
    }

    // Zorunlu dersler bu fonksiyon ile arrayliste eklenir.
    public void addFieldLessons(FieldLessons fL) throws Alreadyhave, BoundOfLessons {
        if(fieldLessons.contains(fL)){
            throw new Alreadyhave("Bu ders zaten eklenmis!");
        }
        if(super.getWhat_year() == 1 || super.getWhat_year() == 2)
            if(amountOfFieldLessons < 3) {
                fieldLessons.add(fL);
                amountOfFieldLessons++;
                System.out.println("Zorunlu ders eklendi. ");

            }
            else{
                throw new BoundOfLessons("Derslerin dolu ekleyemezsin!");
            }
        else
        if(amountOfFieldLessons < 4) {
            fieldLessons.add(fL);
            amountOfFieldLessons++;
            System.out.println("Zorunlu ders eklendi. ");

        }
        else{
            throw new BoundOfLessons("Derslerin dolu ekleyemezsin!");
        }
    }

    // Seçmeli dersleri arrayListten kaldıran fonksiyon.
    public void deleteOptionalLessons(OptionalLessons oL) throws NotFound {

        if(optionalLessons.contains(oL)) {
            optionalLessons.remove(oL);
            amountOfOptionalLessons--;
            System.out.println("Secmeli ders silindi. ");
        }
        else{
            throw new NotFound("Bu ders bulunamadi.");
        }
    }

    // Zorunlu dersleri arrayListten kaldıran fonksiyon
    public void deleteFieldLessons(FieldLessons fL) throws NotFound {
        if(fieldLessons.contains(fL)) {
            fieldLessons.remove(fL);
            amountOfFieldLessons--;
            System.out.println("Zorunlu ders silindi. ");
        }
        else{
            throw new NotFound("Bu ders bulunamadi.");
        }
    }

    // Tüm dersleri ekrana yazdıran fonksiyon (console a)
    public void show_all_lessons(){
        System.out.println("***Zorunlu Alınan Dersler:***");
        for (FieldLessons fieldLessons1: fieldLessons){
            System.out.print(fieldLessons1.getLessonName() + " ");
        }

        System.out.println("\n---------------------------------");
        System.out.println("***Secmeli Alınan Dersler:***");
        for (OptionalLessons optionalLessons1: optionalLessons){
            System.out.print(optionalLessons1.getLessonName() + " ");
        }

        System.out.println("\nTotal ders sayisi: " + (amountOfOptionalLessons + amountOfFieldLessons));

    }

    // Overridelar ve arrayListler oluşturuldu
    public ArrayList<OptionalLessons> getOptLes(){
        return optionalLessons;
    }
    public ArrayList<FieldLessons> getFldLes(){
        return fieldLessons;
    }

    @Override
    public String toString() {
        return super.notification(super.getName(), super.getSurname());
    }

    public ArrayList<OptionalLessons> getOptionalLessons() {
        return optionalLessons;
    }

    public void setOptionalLessons(ArrayList<OptionalLessons> optionalLessons) {
        this.optionalLessons = optionalLessons;
    }

    public ArrayList<FieldLessons> getFieldLessons() {
        return fieldLessons;
    }

    public void setFieldLessons(ArrayList<FieldLessons> fieldLessons) {
        this.fieldLessons = fieldLessons;
    }

    public static int getAmountOfFieldLessons() {
        return amountOfFieldLessons;
    }

    public static void setAmountOfFieldLessons(int amountOfFieldLessons) {
        Student.amountOfFieldLessons = amountOfFieldLessons;
    }

    public static int getAmountOfOptionalLessons() {
        return amountOfOptionalLessons;
    }

    public static void setAmountOfOptionalLessons(int amountOfOptionalLessons) {
        Student.amountOfOptionalLessons = amountOfOptionalLessons;
    }

    public int getWhat_year() {
        return super.getWhat_year();
    }

}

