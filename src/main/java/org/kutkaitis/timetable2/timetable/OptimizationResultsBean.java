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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kutkaitis.timetable2.domain.Student;
import org.kutkaitis.timetable2.mock.StudentsMockDataFiller;

/**
 *
 * @author MkA
 */
@Named("optimizationResultsBean")
@RequestScoped
@Singleton
public class OptimizationResultsBean {

    @Inject
    PropertiesForOptimizationBean properties;

    @Inject
    StudentsMockDataFiller studentsMockData;

    private String duration;
    private String totalPenaltyPoints;
    private List<LinkedHashMap> allDaysTeacherTimeTable;
    private static final String EMPTY_GROUP = "-----";

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public String getTotalPenaltyPoints() {
        int pointsTeacherLectureWindowIIIAndIV = calculateTeachersLectureWindowForIIIAndIV();
        int pointsMoreThanSevenLectures = calculateMoreThanSevenLecturesPerDay();
        // TODO penalty for group students list changes, currently not important, because groups are created programaticaly
        int pointsForLectureDidactics = calculateLectureDidacticsPenalties();
        int pointsForBadWorkingDayForTeacherIIIAndIV = calculateNotAppropriateWorkingDaysForTeacherIIIAndIV();
        int pointsForBadWorkingHoursIIIAndIV = calculateBadWorkingHoursTeacherIIIAndIV();
//        int pointsForLectureWindowInStudentsGroup = calculateLectureWindowsInStudentsGroup(); // TODO calculate penalties for students windows
        return String.valueOf(pointsTeacherLectureWindowIIIAndIV + pointsMoreThanSevenLectures + pointsForLectureDidactics 
        + pointsForBadWorkingDayForTeacherIIIAndIV + pointsForBadWorkingHoursIIIAndIV);
    }
    
    private List<LinkedHashMap> addStudentsTimeTablesToTheList(LinkedHashMap ... studentsTMForTheDay) {
       List<LinkedHashMap> allDaysStudentsTimeTables = new ArrayList<>();
       for (LinkedHashMap studTmForTheDay : studentsTMForTheDay) {
           for (Student student : studentsMockData.getAllStudents()) {
                studTmForTheDay.put(student, new LinkedHashMap<String, String>());
        }
          allDaysStudentsTimeTables.add(studTmForTheDay);
       }
       return allDaysStudentsTimeTables;
    }

    private int calculateLectureWindowsInStudentsGroup() {
        int penaltyPoints = 0;
        List<LinkedHashMap> teachersAllDay = getAllDaysTeacherTimeTable();
        LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForMonday = new LinkedHashMap();
        LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForTuesday = new LinkedHashMap();
        LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForWednesday = new LinkedHashMap();
        LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForThursday = new LinkedHashMap();
        LinkedHashMap<Student, LinkedHashMap<String, String>> studentsTimeTableForFriday = new LinkedHashMap();
        
        List<LinkedHashMap> allDaysStudentsTimeTables = addStudentsTimeTablesToTheList(studentsTimeTableForMonday, studentsTimeTableForTuesday,  studentsTimeTableForWednesday, studentsTimeTableForThursday, studentsTimeTableForFriday);
        
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
                        List<Student> groupsStudentsList = studentsMockData.getGroups().get(groupName).getStudents();

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
        
        return penaltyPoints;
    }

    private int calculateBadWorkingHoursTeacherIIIAndIV() {
        int penaltyPoints = 0;

        List<LinkedHashMap> teachersAllDay = getAllDaysTeacherTimeTable();

        for (LinkedHashMap<String, LinkedHashMap> daysTimeTable : teachersAllDay) {
            // Very dirty hack because of rush
            int weekDayNumber = teachersAllDay.indexOf(daysTimeTable);
            Days weekDay = decideWeekDay(weekDayNumber);
            Collection<String> teacherNames = daysTimeTable.keySet();

            for (String teacherName : teacherNames) {
                LinkedHashMap<String, String> teachersTimeTableForTheDay = daysTimeTable.get(teacherName);
                Collection<String> lectureNumbers = teachersTimeTableForTheDay.keySet();
//                System.out.println("teacherName: " + teacherName);

                for (String lectureNumber : lectureNumbers) {
                    String groupNameToSplit = teachersTimeTableForTheDay.get(lectureNumber);
                    String[] splittedGroupNames = groupNameToSplit.split(":");
                    String groupName = splittedGroupNames[1].trim();

                    if (!StringUtils.equals(groupName, EMPTY_GROUP)) {
                        if (studentsMockData.getTeachersFromIIIAndIV().containsKey(teacherName)) {
                            if (studentsMockData.getTeachers().get(teacherName).getFreeLectures() != null) {
                                if (StringUtils.equals(studentsMockData.getTeachers().get(teacherName).getFreeLectures().get(weekDay), lectureNumber)) {
                                    penaltyPoints += PenaltyPoints.BAD_WORKING_HOURS_FOR_TEACHER_III_IV.penaltyPoints();
                                }

                            }
                        }
                    }

                }
            }
        }

        return penaltyPoints;

    }

    private int calculateNotAppropriateWorkingDaysForTeacherIIIAndIV() {
        int penaltyPoints = 0;

        List<LinkedHashMap> teachersAllDay = getAllDaysTeacherTimeTable();

        for (LinkedHashMap<String, LinkedHashMap> daysTimeTable : teachersAllDay) {
            // Very dirty hack because of rush
            int weekDayNumber = teachersAllDay.indexOf(daysTimeTable);
            Days weekDay = decideWeekDay(weekDayNumber);
            Collection<String> teacherNames = daysTimeTable.keySet();

            teacher:
            for (String teacherName : teacherNames) {
                LinkedHashMap<String, String> teachersTimeTableForTheDay = daysTimeTable.get(teacherName);
                Collection<String> lectureNumbers = teachersTimeTableForTheDay.keySet();

                for (String lectureNumber : lectureNumbers) {
                    String groupNameToSplit = teachersTimeTableForTheDay.get(lectureNumber);
                    String[] splittedGroupNames = groupNameToSplit.split(":");
                    String groupName = splittedGroupNames[1].trim();

                    if (!StringUtils.equals(groupName, EMPTY_GROUP)) {
                        if (studentsMockData.getTeachersFromIIIAndIV().containsKey(teacherName)) {
                            if (studentsMockData.getTeachers().get(teacherName).getFreeDays() != null
                                    && studentsMockData.getTeachers().get(teacherName).getFreeDays().contains(weekDay)) {

                                penaltyPoints += PenaltyPoints.BAD_WORKING_DAYS_FOR_TEACHER_III_IV.penaltyPoints();
                                continue teacher;
                            }
                        }
                    }

                }
            }
        }

        return penaltyPoints;

    }

    private int calculateLectureDidacticsPenalties() {
        int penaltyPoints = 0;
        List<LinkedHashMap> teachersAllDay = getAllDaysTeacherTimeTable();

        for (LinkedHashMap<String, LinkedHashMap> daysTimeTable : teachersAllDay) {
            Collection<String> teacherNames = daysTimeTable.keySet();

            for (String teacherName : teacherNames) {
                LinkedHashMap<String, String> teachersTimeTableForTheDay = daysTimeTable.get(teacherName);
                Collection<String> lectureNumbers = teachersTimeTableForTheDay.keySet();
                List<String> groupsListforCheck = new ArrayList<>();

                for (String lectureNumber : lectureNumbers) {
                    String groupName = teachersTimeTableForTheDay.get(lectureNumber).split(":")[1].trim();
                    if (!StringUtils.equals(groupName, EMPTY_GROUP)) {
                        if (groupsListforCheck.contains(groupName)) {
                            penaltyPoints += PenaltyPoints.BAD_LECTURES_DIDACTICS.penaltyPoints();
                        }
                        groupsListforCheck.add(groupName);

                    }

                }
            }
        }
        return penaltyPoints;
    }

    private int calculateMoreThanSevenLecturesPerDay() {
        int penaltyPoints = 0;
        List<LinkedHashMap> teachersAllDay = getAllDaysTeacherTimeTable();

        days:
        for (LinkedHashMap<String, LinkedHashMap> daysTimeTable : teachersAllDay) {
            Collection<String> teacherNames = daysTimeTable.keySet();
            for (String teacherName : teacherNames) {
                LinkedHashMap<String, String> teachersTimeTableForTheDay = daysTimeTable.get(teacherName);
                Collection<String> lectureNumbers = teachersTimeTableForTheDay.keySet();
                int lectureNumbersSize = lectureNumbers.size();
                if (lectureNumbersSize > 7) {
                    penaltyPoints += PenaltyPoints.MORE_THAN_SEVEN_LECTURES_PER_DAY.penaltyPoints();
                    continue days;
                }
            }
        }

        return penaltyPoints;
    }

    private int calculateTeachersLectureWindowForIIIAndIV() {
        int penaltyPoints = 0;
        List<LinkedHashMap> teachersAllDay = getAllDaysTeacherTimeTable();

        for (LinkedHashMap<String, LinkedHashMap> daysTimeTable : teachersAllDay) {
            Collection<String> teacherNames = daysTimeTable.keySet();

            for (String teacherName : teacherNames) {
                LinkedHashMap<String, String> teachersTimeTableForTheDay = daysTimeTable.get(teacherName);
                Collection<String> lectureNumbers = teachersTimeTableForTheDay.keySet();
                int lectureNumbersSize = lectureNumbers.size();

                for (String lectureNumber : lectureNumbers) {
                    String groupNameToSplit = teachersTimeTableForTheDay.get(lectureNumber);
                    String[] splittedGroupNames = groupNameToSplit.split(":");
                    String groupName = splittedGroupNames[1].trim();

                    if (StringUtils.equals(groupName, EMPTY_GROUP)) {
                        if (studentsMockData.getTeachersFromIIIAndIV().containsKey(teacherName)) {
                            boolean isNotLastLectures = true;
                            for (int lectNum = Integer.valueOf(lectureNumber); lectNum <= lectureNumbersSize; lectNum++) {

                                String grpNam = teachersTimeTableForTheDay.get(String.valueOf(lectNum)).split(":")[1].trim();

                                if (StringUtils.equals(grpNam, EMPTY_GROUP)) {
                                    isNotLastLectures = false;
                                } else {
                                    isNotLastLectures = true;
                                    break;
                                }
                            }

                            if (isNotLastLectures) {
                                penaltyPoints += PenaltyPoints.LECTURE_WINDOW_FOR_TEACHER_III_IV.penaltyPoints();

                            }

                        }
                    }

                }

            }
        }

        return penaltyPoints;

    }

    public List<LinkedHashMap> getAllDaysTeacherTimeTable() {
//        System.out.println("alldayteachertimetable: " + allDaysTeacherTimeTable.hashCode());
        return allDaysTeacherTimeTable;
    }

    public void setAllDaysTeacherTimeTable(List<LinkedHashMap> allDaysTeacherTimeTable) {
        this.allDaysTeacherTimeTable = allDaysTeacherTimeTable;
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
