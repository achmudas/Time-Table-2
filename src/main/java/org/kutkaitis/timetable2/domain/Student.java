package org.kutkaitis.timetable2.domain;

import java.util.List;
import java.util.Map;

/**
 *
 * @author achmudas
 */
public class Student {
    
    private String name;
    private List<Discipline> chosenDisciplines;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Discipline> getChosenDisciplines() {
        return chosenDisciplines;
    }

    public void setChosenDisciplines(List<Discipline> chosenDisciplines) {
        this.chosenDisciplines = chosenDisciplines;
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
    
}
