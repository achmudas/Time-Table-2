package org.kutkaitis.timetable2.timetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.kutkaitis.timetable2.domain.Group;
import org.kutkaitis.timetable2.domain.Teacher;
import org.kutkaitis.timetable2.mock.StudentsMockDataFiller;

/**
 *
 * @author achmudas
 */
@Named
@SessionScoped
public class InitialTimetable {

    
    @Inject
    StudentsMockDataFiller studentsMockDataFiller;
    
    List<Group> mondayTimeTable = new ArrayList<>();
    List<Group> tuesdayTimeTable = new ArrayList<>();
    List<Group> wednesdayTimeTable = new ArrayList<>();
    List<Group> thursdayTimeTable = new ArrayList<>();
    List<Group> fridayTimeTable = new ArrayList<>();
    
    public HashMap<String, Group> getAllGroups() {
        return studentsMockDataFiller.getGroups();
    }
    
    public HashMap<String, Group> getIGroups() {
        HashMap<String, Group> allGroups = getAllGroups();
        HashMap<String, Group> groupsI = new HashMap<>();
        Set<String> keys = allGroups.keySet();
        for (String key: keys) {
            if (key.contains("I") && (key.length() - key.replace("I", "").length()  == 1)) { //FIXME IV adds
                groupsI.put(key, allGroups.get(key));
            }
        }
        return groupsI;
    }
    
    public List<Group> getMondayTimeTable() {
        System.out.println("ISKVIETE");
        return mondayTimeTable;
    }

    public StudentsMockDataFiller getStudentsMockDataFiller() {
        return studentsMockDataFiller;
    }

    public List<Group> getTuesdayTimeTable() {
        return tuesdayTimeTable;
    }

    public List<Group> getWednesdayTimeTable() {
        return wednesdayTimeTable;
    }

    public List<Group> getThursdayTimeTable() {
        return thursdayTimeTable;
    }

    public List<Group> getFridayTimeTable() {
        return fridayTimeTable;
    }
    
    
    public void createStartingTimeTableForIIIAndIV() {
        
    }
    
    public HashMap<String, Teacher> getTeachers() {
        return studentsMockDataFiller.getTeachers();
    }
}
