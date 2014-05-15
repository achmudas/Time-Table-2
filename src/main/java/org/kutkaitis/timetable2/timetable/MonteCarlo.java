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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kutkaitis.timetable2.domain.ClassRoom;
import org.kutkaitis.timetable2.domain.Group;
import org.kutkaitis.timetable2.domain.Student;
import org.kutkaitis.timetable2.domain.Teacher;
import org.kutkaitis.timetable2.mock.StudentsMockDataFiller;
import org.primefaces.context.RequestContext;

/**
 *
 * @author MkA
 */
@Named("monteCarlo")
@RequestScoped
@Singleton
public class MonteCarlo extends OptimizationAlgorithm {

    @Inject
    StudentsMockDataFiller studentsMockDataFiller;
    @Inject
    UsersBean usersBean;
    @Inject
    PropertiesForOptimizationBean properties;
    @Inject
    @Singleton
    OptimizationResultsBean optimizationResults;

    List<String> teachersListOfIIIAndIVForOptm;

    private static final String EMPTY_GROUP = "-----";

    private LinkedHashMap<String, LinkedHashMap> mondayTimeTable;
    private LinkedHashMap<String, LinkedHashMap> tuesdayTimeTable;
    private LinkedHashMap<String, LinkedHashMap> wednesdayTimeTable;
    private LinkedHashMap<String, LinkedHashMap> thursdayTimeTable;
    private LinkedHashMap<String, LinkedHashMap> fridayTimeTable;

    private LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForMonday;
    private LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForTuesday;
    private LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForWednesday;
    private LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForThursday;
    private LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForFriday;
    private List<String> studentsList;
    private List<String> allTeachersListForOptm;
    private List<String> teachersListOfIAndIIForOptm;

    private List<LinkedHashMap> addStudentsTimeTablesToTheList(LinkedHashMap... studentsTMForTheDay) {
        List<LinkedHashMap> allDaysStudentsTimeTables = new ArrayList<>();
        for (LinkedHashMap studTmForTheDay : studentsTMForTheDay) {
            for (Student student : studentsMockDataFiller.getAllStudents()) {
                studTmForTheDay.put(student, new LinkedHashMap<String, String>());
            }
            allDaysStudentsTimeTables.add(studTmForTheDay);
        }
        return allDaysStudentsTimeTables;
    }

    private void convertTeachersTimeTableToStudents() {
        List<LinkedHashMap> teachersAllDay = addDaysTimeTablesForIteration();
        studentsTimeTableForMonday = new LinkedHashMap();
        studentsTimeTableForTuesday = new LinkedHashMap();
        studentsTimeTableForWednesday = new LinkedHashMap();
        studentsTimeTableForThursday = new LinkedHashMap();
        studentsTimeTableForFriday = new LinkedHashMap();

        List<LinkedHashMap> allDaysStudentsTimeTables = addStudentsTimeTablesToTheList(studentsTimeTableForMonday, studentsTimeTableForTuesday, studentsTimeTableForWednesday, studentsTimeTableForThursday, studentsTimeTableForFriday);

        for (LinkedHashMap<String, LinkedHashMap> daysTimeTable : teachersAllDay) {
            // Very dirty hack because of rush
            int weekDayNumber = teachersAllDay.indexOf(daysTimeTable);
            Days weekDay = decideWeekDay(weekDayNumber);
            Collection<String> teacherNames = daysTimeTable.keySet();
//            System.out.println("Day: " + weekDay);
            LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForDay = allDaysStudentsTimeTables.get(weekDayNumber);
//            System.out.println("studentsTimeTableForDay: " + studentsTimeTableForDay);

            LinkedHashMap<String, String> teachersTimeTableForTheDay = daysTimeTable.get(teacherNames.iterator().next());
            Collection<String> lectureNumbers = teachersTimeTableForTheDay.keySet();

            for (String teacherName : teacherNames) {
//                System.out.println("teacherName: " + teacherName);

                for (String lectureNumber : lectureNumbers) {
//                    System.out.println("lectureNumber: " + lectureNumber);
                    String groupNameToSplit = teachersTimeTableForTheDay.get(lectureNumber);
                    String[] splittedGroupNames = groupNameToSplit.split(":");
                    String groupName = splittedGroupNames[1].trim();
                    if (!StringUtils.equals(groupName, EMPTY_GROUP)) {
                        List<Student> groupsStudentsList = studentsMockDataFiller.getGroups().get(groupName).getStudents();

                        for (Student stud : groupsStudentsList) {
                            studentsTimeTableForDay.get(stud).put(lectureNumber, groupNameToSplit);
                        }

//                        System.out.println("studentsTimeTable for the day 2: " + studentsTimeTableForDay);
//                        System.out.println("group name: " + groupName);
//                        System.out.println("group students: " + groupsStudentsList);
//                    
//                        System.out.println(": " + studentsTimeTableForDay.get(groupsStudentsList));
//                        
//                    if (studentsTimeTableForDay.containsKey(groupsStudentsList)) {
//                        System.out.println("groupsStudentsList: " + groupsStudentsList);
////                        System.out.println("StudentsTimeTableForTheDay: " + studentsTimeTableForDay);
//                        
////                        studentsTimeTableForDay.get(groupsStudentsList).put(lectureNumber, groupNameToSplit);
//                    } else {
//                        System.out.println("Doesn't contain");
//                    }
                    }

                }
            }
        }
        System.out.println("AllDaysTM: " + allDaysStudentsTimeTables);

    }
    
    private void optimizeMondayTimeTableForIAndIIGymnasium() {
       List<LinkedHashMap> daysTimeTablesForItr = addDaysTimeTablesForIteration(); 
       
       LinkedHashMap<String, String> teachersTimeTable;
       
       for (int lectureNumber = 1; lectureNumber <= properties.getHoursPerDay(); lectureNumber++) {
//            System.out.println("--------------Lecture-----------------");
            for (String teacherName : teachersListOfIAndIIForOptm) {
//                System.out.println("--------------Teacher-----------------");
                for (LinkedHashMap dayTimeTable : daysTimeTablesForItr) {
//                    System.out.println("-----------------Day-------------");
                    teachersTimeTable = getTeachersTimeTable(teacherName, dayTimeTable);
                    Teacher teacher = studentsMockDataFiller.getTeachers().get(teacherName);
                    List<Group> teachersGroups = teacher.getTeachersGroups();

                    int teachersGroupsTotal = teachersGroups.size();
//                    System.out.println("teachersGroupsTotal: " + teachersGroupsTotal);

                    if (teachersGroupsTotal == 0) {
                        teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": -----");//Add group, because all the groups for teacher was added already
//                        System.out.println("add empty at the end");
                        continue;
                    }

//                    int counter = 0;
//                    counter = countThatThereIsIIIAndIVGymnGroups(teachersGroups, counter);
//
//                    if (counter == 0) {
//                        teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": -----");//Add group, because all the groups for teacher was added already
//                        continue;
//                    }

                    Group group = getRandomGroup(teachersGroups, teachersGroupsTotal);

                    while (group == null) {
                        group = getRandomGroup(teachersGroups, teachersGroupsTotal);
                    }

                    boolean isGroupAllowedToAdd = isMandatoryConditionsMet(teacher, teachersGroups, group, lectureNumber, dayTimeTable);
//                    System.out.println("Grupe idejimui: " + group);
//                    System.out.println("isGroupAllowedToAdd: " + isGroupAllowedToAdd);
//                    System.out.println("lecture number: " + lectureNumber);
                    if (isGroupAllowedToAdd) {
//                        System.out.println("Mokytojas: " + teacherName);
//                        System.out.println("Grupe, kai galima deti ja: " + group);
                        addGroupToTeachersTimeTable(group, teachersTimeTable, lectureNumber, teachersGroups);
                    } else {
                        teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": -----");
                    }
                }
            }
        }
        optimizationResults.setAllDaysTeacherTimeTable(daysTimeTablesForItr);
       
       
    }

    private void optimizeMondayTimeTableForIIIAndIVGymnasium() {
        mondayTimeTable = new LinkedHashMap<>();
        tuesdayTimeTable = new LinkedHashMap<>();
        wednesdayTimeTable = new LinkedHashMap<>();
        thursdayTimeTable = new LinkedHashMap<>();
        fridayTimeTable = new LinkedHashMap<>();
        List<LinkedHashMap> daysTimeTablesForItr = addDaysTimeTablesForIteration();

        LinkedHashMap<String, String> teachersTimeTable;
        HashMap<String, Teacher> teachersMapForDeletion = copyTeacherForDeletion();

        for (int lectureNumber = 1; lectureNumber <= properties.getHoursPerDay(); lectureNumber++) {
//            System.out.println("--------------Lecture-----------------");
            for (String teacherName : teachersListOfIIIAndIVForOptm) {
//                System.out.println("--------------Teacher-----------------");
                for (LinkedHashMap dayTimeTable : daysTimeTablesForItr) {
//                    System.out.println("-----------------Day-------------");
                    teachersTimeTable = getTeachersTimeTable(teacherName, dayTimeTable);
                    Teacher teacher = teachersMapForDeletion.get(teacherName);
                    List<Group> teachersGroups = teacher.getTeachersGroups();

                    int teachersGroupsTotal = teachersGroups.size();
//                    System.out.println("teachersGroupsTotal: " + teachersGroupsTotal);

                    if (teachersGroupsTotal == 0) {
                        teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": -----");//Add group, because all the groups for teacher was added already
//                        System.out.println("add empty at the end");
                        continue;
                    }

                    int counter = 0;
                    counter = countThatThereIsIIIAndIVGymnGroups(teachersGroups, counter);

                    if (counter == 0) {
                        teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": -----");//Add group, because all the groups for teacher was added already
                        continue;
                    }

                    Group group = getRandomGroup(teachersGroups, teachersGroupsTotal);

                    while (group == null || group.isIiGymnasiumGroup() || group.isiGymnasiumGroup()) {
                        group = getRandomGroup(teachersGroups, teachersGroupsTotal);
                    }

                    boolean isGroupAllowedToAdd = isMandatoryConditionsMet(teacher, teachersGroups, group, lectureNumber, dayTimeTable);
//                    System.out.println("Grupe idejimui: " + group);
//                    System.out.println("isGroupAllowedToAdd: " + isGroupAllowedToAdd);
//                    System.out.println("lecture number: " + lectureNumber);
                    if (isGroupAllowedToAdd) {
//                        System.out.println("Mokytojas: " + teacherName);
//                        System.out.println("Grupe, kai galima deti ja: " + group);
                        addGroupToTeachersTimeTable(group, teachersTimeTable, lectureNumber, teachersGroups);
                    } else {
                        teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": -----");
                    }
                }
            }
        }
        optimizationResults.setAllDaysTeacherTimeTable(daysTimeTablesForItr);

    }

    private List<LinkedHashMap> addDaysTimeTablesForIteration() {
        List<LinkedHashMap> daysTimeTablesForItr = new ArrayList<LinkedHashMap>();
        daysTimeTablesForItr.add(mondayTimeTable);
        daysTimeTablesForItr.add(tuesdayTimeTable);
        daysTimeTablesForItr.add(wednesdayTimeTable);
        daysTimeTablesForItr.add(thursdayTimeTable);
        daysTimeTablesForItr.add(fridayTimeTable);
        return daysTimeTablesForItr;
    }

    private HashMap<String, Teacher> copyTeacherForDeletion() {
        HashMap<String, Teacher> teachersMapForDeletion = new HashMap<>();
        for (Teacher teacher : studentsMockDataFiller.getTeachers().values()) {
            Teacher teacherToBeAddForDel = new Teacher();
            teacherToBeAddForDel.setName(teacher.getName());
            teacherToBeAddForDel.setTeacherDisciplines(teacher.getTeacherDisciplines());
            teacherToBeAddForDel.setTeacherInIIIAndIVGymnasiumClasses(teacher.isTeacherInIIIAndIVGymnasiumClasses());
            teacherToBeAddForDel.setTeachersGroups(teacher.getTeachersGroups());
            teachersMapForDeletion.put(teacherToBeAddForDel.getName(), teacherToBeAddForDel);
        }
        return teachersMapForDeletion;
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
            teachersTimeTable.put(String.valueOf(lectureNumber), lectureNumber + ": " + group.getGroupName() + ": " + group.getClassRoom().getRoomNumber());
            teachersGroups.remove(group);
        }
    }

    public LinkedHashMap getOptimizedTimeTableForTeacherMonday() {
        if (mondayTimeTable == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            optimizeMondayTimeTableForIIIAndIVGymnasium();
            optimizeMondayTimeTableForIAndIIGymnasium();
        }
        return mondayTimeTable;
    }

    public LinkedHashMap getOptimizedTimeTableForTeacherTuesday() {
        if (tuesdayTimeTable == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            optimizeMondayTimeTableForIIIAndIVGymnasium();
            optimizeMondayTimeTableForIAndIIGymnasium();
        }
        return tuesdayTimeTable;
    }

    public LinkedHashMap getOptimizedTimeTableForTeacherWednesday() {
        if (wednesdayTimeTable == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            optimizeMondayTimeTableForIIIAndIVGymnasium();
            optimizeMondayTimeTableForIAndIIGymnasium();
        }
        return wednesdayTimeTable;
    }

    public LinkedHashMap getOptimizedTimeTableForTeacherThursday() {
        if (thursdayTimeTable == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            optimizeMondayTimeTableForIIIAndIVGymnasium();
            optimizeMondayTimeTableForIAndIIGymnasium();
        }
        return thursdayTimeTable;
    }

    public LinkedHashMap getOptimizedTimeTableForTeacherFriday() {
        if (fridayTimeTable == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            optimizeMondayTimeTableForIIIAndIVGymnasium();
            optimizeMondayTimeTableForIAndIIGymnasium();
        }
        return fridayTimeTable;
    }
    
    public LinkedHashMap getTimeTableForStudentsMonday() {
        if (studentsTimeTableForMonday == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            getTeachersListOfIIIAndIVForOptm(); // another dirty hack
            optimizeMondayTimeTableForIIIAndIVGymnasium();
            convertTeachersTimeTableToStudents();
        }
        return studentsTimeTableForMonday;
    }

    public LinkedHashMap getTimeTableForStudentsTuesday() {
        if (studentsTimeTableForTuesday == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            convertTeachersTimeTableToStudents();
        }
        return studentsTimeTableForTuesday;
    }

    public LinkedHashMap getTimeTableForStudentsWednesday() {
        if (studentsTimeTableForWednesday == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            convertTeachersTimeTableToStudents();
        }
        return studentsTimeTableForWednesday;
    }

    public LinkedHashMap getTimeTableForStudentsThursday() {
        if (studentsTimeTableForThursday == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            convertTeachersTimeTableToStudents();
        }
        return studentsTimeTableForThursday;
    }

    public LinkedHashMap getTimeTableForStudentsFriday() {
        if (studentsTimeTableForFriday == null) { //TODO fix according java beans spec, that getter cannot have any business logic
            convertTeachersTimeTableToStudents();
        }
        return studentsTimeTableForFriday;
    }

    public List<LinkedHashMap> getOptimizedTimeTableForTeachersForAllWeek() {
        return addDaysTimeTablesForIteration();
    }

    private LinkedHashMap<String, String> getTeachersTimeTable(String teacherName, LinkedHashMap<String, LinkedHashMap> dayTimeTable) {
        LinkedHashMap<String, String> teachersTimeTable;
        if (!dayTimeTable.containsKey(teacherName)) {
            teachersTimeTable = new LinkedHashMap<>();
            dayTimeTable.put(teacherName, teachersTimeTable);
        } else {
            teachersTimeTable = dayTimeTable.get(teacherName);
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
    
    public List<String> getTeachersListOfIAndIIForOptm() {
        if (teachersListOfIAndIIForOptm == null) {
            teachersListOfIAndIIForOptm = new ArrayList<>();
            teachersListOfIAndIIForOptm = usersBean.getTeachersNamesFromIAndII();
            Collections.shuffle(teachersListOfIAndIIForOptm);
        }
        return teachersListOfIAndIIForOptm;
    }
    
    public List<String> getAllTeachersListForOptm() {
        if (allTeachersListForOptm == null) {
            allTeachersListForOptm = new ArrayList<>();
            allTeachersListForOptm.addAll(getTeachersListOfIIIAndIVForOptm());
            allTeachersListForOptm.addAll(getTeachersListOfIAndIIForOptm());
        }
        return allTeachersListForOptm;
    }
    
    
    public List<String> getStudentsList() {
        if (studentsList == null) {
            studentsList = new ArrayList<>();
            for (Student stud : studentsMockDataFiller.getAllStudents()) {
                studentsList.add(stud.getName());
            }
        }
        return studentsList;
    }

    private int generateRandomInteger(int teachersGroupsTotal) {
        Random random = new Random();
        return random.nextInt(teachersGroupsTotal);
    }

    private Group getRandomGroup(List<Group> groups, int teachersGroupsTotal) {
        //  System.out.println("groups size: " + teachersGroupsTotal);
        int randomNumber = generateRandomInteger(teachersGroupsTotal);
        Group group = groups.get(randomNumber);
//        System.out.println("Group in random group: " + group);
        if (group != null) {
//            System.out.println("Group name in random group: " + group.getGroupName());
        }

        return group;
    }

    private boolean isStudentInOneLectureAtTheTime(Teacher teacher, List<Group> teachersGroups, Group group, int lectureNumber, LinkedHashMap<String, LinkedHashMap> dayTimeTable) {
        boolean mandatoryConditionsMet = true;
        if (group != null) {
//            System.out.println("Grupe idejimui: " + group.getGroupName());
            List<Student> groupStudents = group.getStudents();
            Collection<LinkedHashMap> teachersTimeTables = dayTimeTable.values();
//            System.out.println("teachersTimeTables before if: " + teachersTimeTables);
            for (LinkedHashMap<String, String> teachersTimeTable : teachersTimeTables) {
//                System.out.println("Iskviete fore");
                if (teachersTimeTable.isEmpty()) {
                    mandatoryConditionsMet = true;
                    continue;
                }
//                System.out.println("teachersTimeTable: " + teachersTimeTable);
                String groupNameToSplit = teachersTimeTable.get(String.valueOf(lectureNumber));
                if (groupNameToSplit == null) {
                    mandatoryConditionsMet = true;
                    continue;
                }
                String[] splittedGroupNames = groupNameToSplit.split(":");
                String groupName = splittedGroupNames[1].trim();
//                System.out.println("Group name: " + groupName);
                Group groupToCheck = studentsMockDataFiller.getGroups().get(groupName);
//                System.out.println("groupToCheck: " + groupToCheck);
                boolean contains = true;
                if (StringUtils.equals(groupName, "-----")) {
                    contains = false;
                }

                if (groupToCheck != null) {
//                    System.out.println("Group to check: " + groupToCheck.getGroupName());
                    contains = CollectionUtils.containsAny(groupStudents, groupToCheck.getStudents());
//                    System.out.println("Contains: " + contains);
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

    private boolean isMandatoryConditionsMet(Teacher teacher, List<Group> teachersGroups, Group group, int lectureNumber, LinkedHashMap<String, LinkedHashMap> dayTimeTable) {
        boolean mandatoryConditionsMet = false;
        boolean studentInOneLectureAtTheTime = isStudentInOneLectureAtTheTime(teacher, teachersGroups, group, lectureNumber, dayTimeTable);
        boolean oneGroupInOneClassroom = isOneGroupInOneClassroom(group, lectureNumber, dayTimeTable); // TODO probably need to refactor and use one method fur this stuff
        if (studentInOneLectureAtTheTime && oneGroupInOneClassroom) {
            mandatoryConditionsMet = true;
        }
//        System.out.println("Mandatory conditions met: " + mandatoryConditionsMet);
        return mandatoryConditionsMet;
    }

    private boolean isOneGroupInOneClassroom(Group group, int lectureNumber, LinkedHashMap<String, LinkedHashMap> dayTimeTable) {
        boolean oneLectureInOneRoom = true;
        if (group != null) {
            ClassRoom groupsRoom = group.getClassRoom();
            String classRoomNumber = groupsRoom.getRoomNumber();
//            System.out.println("Group to add: " + group.getGroupName());
            Collection<LinkedHashMap> teachersTimeTables = dayTimeTable.values();
            for (LinkedHashMap<String, String> teachersTimeTable : teachersTimeTables) {
                if (teachersTimeTable.isEmpty()) {
                    oneLectureInOneRoom = true;
                    continue;
                }
                String groupNameToSplit = teachersTimeTable.get(String.valueOf(lectureNumber));
                if (groupNameToSplit == null) {
                    oneLectureInOneRoom = true;
                    continue;
                }
                String[] splittedGroupNames = groupNameToSplit.split(":");
                String groupName = splittedGroupNames[1].trim();
                Group groupToCheck = studentsMockDataFiller.getGroups().get(groupName);
                boolean roomBusy = true;
                if (StringUtils.equals(groupName, "-----")) {
                    roomBusy = false;
                }

                if (groupToCheck != null) {
//                    System.out.println("Group to check: " + groupToCheck.getGroupName());
                    roomBusy = StringUtils.equals(classRoomNumber, groupToCheck.getClassRoom().getRoomNumber());
//                    System.out.println("freeRoom: " + roomBusy);
                }
                if (roomBusy == false) {
                    oneLectureInOneRoom = true;
                } else {
                    oneLectureInOneRoom = false;
                    return oneLectureInOneRoom;
                }
            }
        } else {
            oneLectureInOneRoom = false;

        }
        return oneLectureInOneRoom;
    }

    private Days decideWeekDay(int weekDayNumber) {
        Days day = null;
        switch (weekDayNumber) {
            case 0:
                return Days.MONDAY;
            case 1:
                return Days.TUESDAY;
            case 2:
                return Days.WEDNESDAY;
            case 3:
                return Days.THURSDAY;
            case 4:
                return Days.FRIDAY;
            default:
                return day;

        }
    }
}
