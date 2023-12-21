package com.example.java_final_projectfx;
// Seçmeli dersler için lesson interfacini implement eden class oluşturuldu.
public class OptionalLessons implements Lesson {

    private String lessonName;
    private String teacherName;
    int what_year = 0;
    private String typeOfLesson;

    int course_time = 0;

    // Class ın constructorı oluşturuldu.
    public OptionalLessons(String lessonName, String teacherName, String typeOfLesson, int what_year, int time) {
        super();
        this.lessonName = lessonName;
        this.teacherName = teacherName;
        this.what_year = what_year;
        this.typeOfLesson = typeOfLesson;
        this.course_time = time;
    }

    // Ders bilgileri ekrana yazıdırıldı.
    @Override
    public void show_lesson_info() {
        System.out.println("****Ders Bilgisi*****");
        System.out.println("Dersin adi: " + lessonName);
        System.out.println("Derse giren hoca: " + teacherName);
        System.out.println("Kacinci sinif dersi: " + what_year);
        System.out.println("Dersin turu:  " + typeOfLesson);
    }

    // getter ve setterlar overide edildi.
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

    public int getCourse_time() {
        return course_time;
    }

    public void setCourse_time(int course_time) {
        this.course_time = course_time;
    }
}