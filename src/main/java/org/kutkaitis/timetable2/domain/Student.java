package org.kutkaitis.timetable2.domain;

import java.util.Map;

/**
 *
 * @author achmudas
 */
public class Student {
    
    private String name;
    private Map<String, Group> chosenDisciplines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Group> getChosenDisciplines() {
        return chosenDisciplines;
    }

    public void setChosenDisciplines(Map<String, Group> chosenDisciplines) {
        this.chosenDisciplines = chosenDisciplines;
    }
    
    
}
