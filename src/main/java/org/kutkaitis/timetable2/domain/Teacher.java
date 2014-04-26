package org.kutkaitis.timetable2.domain;

import java.util.List;

/**
 *
 * @author achmudas
 */
public class Teacher {
    
    private String name;
    private List<Discipline> teacherDisciplines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Discipline> getTeacherDisciplines() {
        return teacherDisciplines;
    }

    public void setTeacherDisciplines(List<Discipline> teacherDisciplines) {
        this.teacherDisciplines = teacherDisciplines;
    }
    
    

}
