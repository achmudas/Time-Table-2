package org.kutkaitis.timetable2.domain;

/**
 *
 * @author achmudas
 */
public class Group {
    
    private Teacher teacher;
    private String groupName;
    private Discipline discipline;
    private Student studet;

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

    public Student getStudet() {
        return studet;
    }

    public void setStudet(Student studet) {
        this.studet = studet;
    }
    
    

}
