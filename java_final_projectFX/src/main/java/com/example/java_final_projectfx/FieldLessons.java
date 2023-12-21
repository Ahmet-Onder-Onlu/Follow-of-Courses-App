package com.example.java_final_projectfx;
//Zorunlu dersler için sınıf oluşturuldu. Ve lesson interface i implement ettik.
public class FieldLessons implements Lesson{

    private String lessonName = null;
    private String teacherName = null;
    int what_year = 0;
    private String typeOfLesson = null;

    int course_time = 0;
    //Sınıf konstraktrı oluşturuldu.
    public FieldLessons(String lessonName, String teacherName, String typeOfLesson, int what_year, int time){
        super();
        this.lessonName = lessonName;
        this.teacherName = teacherName;
        this.what_year = what_year;
        this.typeOfLesson = typeOfLesson;
        this.course_time = time;
    }
    // Dersleri ekrana yazdıran kod kısmı
    @Override
    public void show_lesson_info() {
        System.out.println("****Ders Bilgisi*****");
        System.out.println("Dersin adi: " + lessonName);
        System.out.println("Derse giren hoca: " + teacherName);
        System.out.println("Kacinci sinif dersi: " + what_year);
        System.out.println("Dersin turu:  " + typeOfLesson);
    }

    // Get ve setter yani enkapsilosyanlar override edildi.
    @Override
    public int get_course_time() {
        return course_time;
    }
    public int get_course_time(int times){
        return course_time*times;
    }

    @Override
    public String get_lesson_name() {
        return getLessonName();
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getWhat_year() {
        return what_year;
    }

    public void setWhat_year(int what_year) {
        this.what_year = what_year;
    }

    public String getTypeOfLesson() {
        return typeOfLesson;
    }

    public void setTypeOfLesson(String typeOfLesson) {
        this.typeOfLesson = typeOfLesson;
    }
}
