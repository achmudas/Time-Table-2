/*
 * Copyright (C) 2014 MkA
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kutkaitis.timetable2.timetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.kutkaitis.timetable2.domain.Group;
import org.kutkaitis.timetable2.domain.Teacher;
import org.kutkaitis.timetable2.mock.StudentsMockDataFiller;

/**
 *
 * @author MkA
 */
@ManagedBean(name = "monteCarlo")
@SessionScoped
@Singleton
public class MonteCarlo extends OptimizationAlgorithm {

    @Inject
    StudentsMockDataFiller studentsMockDataFiller;
    @Inject
    UsersBean usersBean;
    @EJB
    PropertiesForOptimizationBean properties;
    
    List<String> teachersListForOptm;

    List<String> mondayTimeTable;

    public List<String> getOptimizedTimeTableForTeacherMonday() {
        mondayTimeTable = new ArrayList<>();
        for (String teacherName : teachersListForOptm) {
            System.out.print("Teacher name: " + teacherName);
            Teacher teacher = studentsMockDataFiller.getTeachers().get(teacherName);
            Group group = teacher.getTeachersGroups().get(0);
            System.out.print("; Group: " + group.getGroupName());
            mondayTimeTable.add(group.getGroupName());
            System.out.println("; Hours per day: " + properties.getHoursPerDay());
            for (int i = 1; i < properties.getHoursPerDay(); i++) {
                mondayTimeTable.add("Empty");
            }
        }
        
            
        return mondayTimeTable;
    }

    public List<String> getTeachersListForOptm() {
        teachersListForOptm = new ArrayList<>();
        teachersListForOptm = usersBean.getTeachersNames();
        Collections.shuffle(teachersListForOptm);
        return teachersListForOptm;
    }
    

}
