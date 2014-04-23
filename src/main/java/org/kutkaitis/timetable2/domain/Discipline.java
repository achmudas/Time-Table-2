package org.kutkaitis.timetable2.domain;

/**
 *
 * @author achmudas
 */
public class Discipline {
    
    private String disciplineName;
    private String level;
    private String hoursPerWeek;

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(String hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
    
        
}
