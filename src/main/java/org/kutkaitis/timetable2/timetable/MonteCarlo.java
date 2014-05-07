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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.kutkaitis.timetable2.domain.Group;
import org.kutkaitis.timetable2.domain.Teacher;
import org.kutkaitis.timetable2.mock.StudentsMockDataFiller;

/**
 *
 * @author MkA
 */
@ManagedBean(name = "monteCarlo")
@SessionScoped
public class MonteCarlo extends OptimizationAlgorithm {

    @Inject
    StudentsMockDataFiller studentsMockDataFiller;
    @Inject
    UsersBean usersBean;
    @Inject
    PropertiesForOptimizationBean properties;

    List<String> teachersListOfIIIAndIVForOptm;

    private LinkedHashMap<String, LinkedHashMap> mondayTimeTable;

    private void optimizeMondayTimeTableForIIIAndIVGymnasium() {
        mondayTimeTable = new LinkedHashMap<>();
        LinkedHashMap<String, String> teachersTimeTable;

        for (int lectureNumber = 1; lectureNumber <= properties.getHoursPerDay(); lectureNumber++) {
            for (String teacherName : teachersListOfIIIAndIVForOptm) {
                teachersTimeTable = getTeachersTimeTable(teacherName);
                Teacher teacher = studentsMockDataFiller.getTeachers().get(teacherName);
                List<Group> teachersGroups = teacher.getTeachersGroups();

                int teachersGroupsTotal = teachersGroups.size();

                if (teachersGroupsTotal == 0) {
                    continue;
                }

                int counter = 0;
                for (Group grp : teachersGroups) {
                    if (grp.isIiiGymnasiumGroup() || grp.isIvGymnasiumGroup()) {
                        counter++;
                    }
                }

                if (counter == 0) {
                    continue;
                }

                Group group = getRandomGroup(teachersGroups, teachersGroupsTotal);

                if (group != null) {
                    teachersTimeTable.put(String.valueOf(lectureNumber), group.getGroupName());
                    teachersGroups.remove(group);
                }

            }
        }
    }

    public LinkedHashMap getOptimizedTimeTableForTeacherMonday() {
        if (mondayTimeTable == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            optimizeMondayTimeTableForIIIAndIVGymnasium();
        }
        return mondayTimeTable;
    }

    private LinkedHashMap<String, String> getTeachersTimeTable(String teacherName) {
        LinkedHashMap<String, String> teachersTimeTable;
        if (!mondayTimeTable.containsKey(teacherName)) {
            teachersTimeTable = new LinkedHashMap<>();
            mondayTimeTable.put(teacherName, teachersTimeTable);
        } else {
            teachersTimeTable = mondayTimeTable.get(teacherName);
        }
        return teachersTimeTable;
    }

    public List<String> getTeachersListOfIIIAndIVForOptm() {
        if (teachersListOfIIIAndIVForOptm == null) {
            teachersListOfIIIAndIVForOptm = new ArrayList<>();
            teachersListOfIIIAndIVForOptm = usersBean.getTeachersNamesFromIIIAndIV();
            Collections.shuffle(teachersListOfIIIAndIVForOptm);
        }
        return teachersListOfIIIAndIVForOptm;
    }

    private int generateRandomInteger(int teachersGroupsTotal) {
        Random random = new Random();
        return random.nextInt(teachersGroupsTotal);
    }

    private Group getRandomGroup(List<Group> groups, int teachersGroupsTotal) {
        //  System.out.println("groups size: " + teachersGroupsTotal);
        int randomNumber = generateRandomInteger(teachersGroupsTotal);
        Group group = groups.get(randomNumber);

        if (group == null || group.isIiGymnasiumGroup() || group.isiGymnasiumGroup()) {
            this.getRandomGroup(groups, teachersGroupsTotal);
            group = null;
        }
        return group;
    }

}
