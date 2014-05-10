package org.kutkaitis.timetable2.domain;

import java.util.List;

/**
 *
 * @author achmudas
 */
public class Group {
    
    private Teacher teacher;
    private String groupName;
    private Discipline discipline;
    private List<Student> students;
    private boolean iGymnasiumGroup;
    private boolean iiGymnasiumGroup;
    private boolean iiiGymnasiumGroup;
    private boolean ivGymnasiumGroup;
    private ClassRoom classRoom;

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
    
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean isiGymnasiumGroup() {
        return iGymnasiumGroup;
    }

    public void setiGymnasiumGroup(boolean iGymnasiumGroup) {
        this.iGymnasiumGroup = iGymnasiumGroup;
    }

    public boolean isIiGymnasiumGroup() {
        return iiGymnasiumGroup;
    }

    public void setIiGymnasiumGroup(boolean iiGymnasiumGroup) {
        this.iiGymnasiumGroup = iiGymnasiumGroup;
    }

    public boolean isIiiGymnasiumGroup() {
        return iiiGymnasiumGroup;
    }

    public void setIiiGymnasiumGroup(boolean iiiGymnasiumGroup) {
        this.iiiGymnasiumGroup = iiiGymnasiumGroup;
    }

    public boolean isIvGymnasiumGroup() {
        return ivGymnasiumGroup;
    }

    public void setIvGymnasiumGroup(boolean ivGymnasiumGroup) {
        this.ivGymnasiumGroup = ivGymnasiumGroup;
    }

}
