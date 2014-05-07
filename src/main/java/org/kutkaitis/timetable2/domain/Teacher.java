package org.kutkaitis.timetable2.domain;

import java.util.List;

/**
 *
 * @author achmudas
 */
public class Teacher {
    
    private String name;
    private List<Discipline> teacherDisciplines;
    private List<Group> teachersGroups;
    private boolean teacherInIIIAndIVGymnasiumClasses;

    public List<Group> getTeachersGroups() {
        return teachersGroups;
    }

    public void setTeachersGroups(List<Group> teachersGroups) {
        this.teachersGroups = teachersGroups;
    }

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

    public boolean isTeacherInIIIAndIVGymnasiumClasses() {
        return teacherInIIIAndIVGymnasiumClasses;
    }

    public void setTeacherInIIIAndIVGymnasiumClasses(boolean teacherInIIIAndIVGymnasiumClasses) {
        this.teacherInIIIAndIVGymnasiumClasses = teacherInIIIAndIVGymnasiumClasses;
    }

    

}
