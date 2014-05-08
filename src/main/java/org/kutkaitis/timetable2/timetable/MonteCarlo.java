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
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kutkaitis.timetable2.domain.Group;
import org.kutkaitis.timetable2.domain.Student;
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
            System.out.println("--------------Lecture-----------------");
            for (String teacherName : teachersListOfIIIAndIVForOptm) {
                System.out.println("--------------Teacher-----------------");
                teachersTimeTable = getTeachersTimeTable(teacherName);
                Teacher teacher = studentsMockDataFiller.getTeachers().get(teacherName);
                List<Group> teachersGroups = teacher.getTeachersGroups();

                int teachersGroupsTotal = teachersGroups.size();
                System.out.println("teachersGroupsTotal: " + teachersGroupsTotal);

                if (teachersGroupsTotal == 0) {
                    teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": -----");//Add group, because all the groups for teacher was added already
                    System.out.println("add empty at the end");
                    continue;
                }

                int counter = 0;
                counter = countThatThereIsIIIAndIVGymnGroups(teachersGroups, counter);

                if (counter == 0) {
                    teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": -----");//Add group, because all the groups for teacher was added already
                    continue;
                }
                
                Group group = getRandomGroup(teachersGroups, teachersGroupsTotal);
                boolean isGroupAllowedToAdd = isMandatoryConditionsMet(teacher, teachersGroups, group, lectureNumber);
                System.out.println("Grupe idejimui: " + group);
                System.out.println("isGroupAllowedToAdd: " + isGroupAllowedToAdd);
                System.out.println("lecture number: " + lectureNumber);
                if (isGroupAllowedToAdd) {
                    System.out.println("Mokytojas: " + teacherName);
                    System.out.println("Grupe, kai galima deti ja: " + group);
                    addGroupToTeachersTimeTable(group, teachersTimeTable, lectureNumber, teachersGroups);
                } else {
                    teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": -----");
                }
            }
        }
    }

    private int countThatThereIsIIIAndIVGymnGroups(List<Group> teachersGroups, int counter) {
        for (Group grp : teachersGroups) {
            if (grp.isIiiGymnasiumGroup() || grp.isIvGymnasiumGroup()) {
                counter++;
            }
        }
        return counter;
    }

    private void addGroupToTeachersTimeTable(Group group, LinkedHashMap<String, String> teachersTimeTable, int lectureNumber, List<Group> teachersGroups) {
        if (group != null) {
            teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": " + group.getGroupName());
            teachersGroups.remove(group);
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
        if (group != null)
        System.out.println("Group in random group: " + group.getGroupName());

        if (group == null || group.isIiGymnasiumGroup() || group.isiGymnasiumGroup()) {
            this.getRandomGroup(groups, teachersGroupsTotal);
            group = null;
        }
        return group;
    }

    // TODO
    // 1. check that student is having just one lecture at the time
    // 2. check, that classroom is empty
    private boolean isMandatoryConditionsMet(Teacher teacher, List<Group> teachersGroups, Group group, int lectureNumber) {
        boolean mandatoryConditionsMet = true;
        if (group != null) {
            System.out.println("Grupe idejimui: " + group.getGroupName());
            List<Student> groupStudents = group.getStudents();
            Collection<LinkedHashMap> teachersTimeTables = mondayTimeTable.values();
            System.out.println("teachersTimeTables before if: " + teachersTimeTables);
            for (LinkedHashMap<String, String> teachersTimeTable : teachersTimeTables) {
                System.out.println("Iskviete fore");
                if (teachersTimeTable.isEmpty()) {
                    mandatoryConditionsMet = true;
                    continue;
                }
                System.out.println("teachersTimeTable: " + teachersTimeTable);
                String groupName = teachersTimeTable.get(String.valueOf(lectureNumber));
                System.out.println("Group name: " + groupName);
                Group groupToCheck = studentsMockDataFiller.getGroups().get(groupName);
                boolean contains = true;
                if (!StringUtils.equals(groupName, "e")) {
                    contains = false;
                }
                if (groupToCheck != null) {
                    System.out.println("Group to check: " + groupToCheck.getGroupName());
                    contains = CollectionUtils.containsAny(groupStudents, groupToCheck.getStudents());
                    System.out.println("Contains: " + contains);
                }
                if (contains == false) {
                    mandatoryConditionsMet = true;
                } else {
                    mandatoryConditionsMet = false;
                    return mandatoryConditionsMet;
                }
            }
        } else {
            mandatoryConditionsMet = false;
        }
        return mandatoryConditionsMet;
    }

}
