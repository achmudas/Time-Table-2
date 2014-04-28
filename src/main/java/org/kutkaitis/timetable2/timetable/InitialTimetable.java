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
@FlowScoped("timetable")
public class InitialTimetable {

    @Inject StudentsMockDataFiller studentsMockDataFiller;
    
    
    
    public HashMap<String, Group> getAllGroups() {
        return studentsMockDataFiller.getGroups();
    }
    
    public HashMap<String, Group> getIGroups() {
        HashMap<String, Group> allGroups = getAllGroups();
        HashMap<String, Group> groupsI = new HashMap<>();
        Set<String> keys = allGroups.keySet();
        for (String key: keys) {
            if (key.contains("I") && (key.length() - key.replace("I", "").length()  == 1)) {
                groupsI.put(key, allGroups.get(key));
            }
        }
        return groupsI;
    }
    
    public List<Group> getMondayTimeTable() {
        List<Group> mondayTimeTable = new ArrayList<>();
        HashMap<String, Group> groupI = getIGroups();
        Set<String> groupIKeys = groupI.keySet();
        for (String key : groupIKeys) {
            mondayTimeTable.add(groupI.get(key));
        }
        return mondayTimeTable;
    }
    
    public HashMap<String, Teacher> getTeachers() {
        return studentsMockDataFiller.getTeachers();
    }
}
