package org.kutkaitis.timetable2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.kutkaitis.timetable2.timetable.Days;

/**
 *
 * @author achmudas
 */
public class Teacher {
    
    private String name;
    private List<Discipline> teacherDisciplines;
    private List<Group> teachersGroups;
    private boolean teacherInIIIAndIVGymnasiumClasses;
    private List<Days> freeDays;
    private Map<Days, String> freeLectures;
    private boolean teacherInAllClasses;

    public boolean isTeacherInAllClasses() {
        return teacherInAllClasses;
    }

    public void setTeacherInAllClasses(boolean teacherInAllClasses) {
        this.teacherInAllClasses = teacherInAllClasses;
    }

    public List<Days> getFreeDays() {
        return freeDays;
    }

    public void setFreeDays(List<Days> freeDays) {
        this.freeDays = freeDays;
    }

    public Map<Days, String> getFreeLectures() {
        return freeLectures;
    }

    public void setFreeLectures(Map<Days, String> freeLectures) {
        this.freeLectures = freeLectures;
    }
    
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
