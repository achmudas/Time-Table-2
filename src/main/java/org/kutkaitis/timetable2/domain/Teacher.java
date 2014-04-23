package org.kutkaitis.timetable2.domain;

/**
 *
 * @author achmudas
 */
public class Teacher {
    
    private String name;
    private Discipline teacherDiscipline;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Discipline getTeacherDiscipline() {
        return teacherDiscipline;
    }

    public void setTeacherDiscipline(Discipline teacherDiscipline) {
        this.teacherDiscipline = teacherDiscipline;
    }
    
    

}
