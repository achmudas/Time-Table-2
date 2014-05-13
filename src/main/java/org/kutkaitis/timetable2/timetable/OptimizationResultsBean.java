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

import java.util.Collection;
import java.util.HashMap;
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
import org.apache.commons.lang3.StringUtils;
import org.kutkaitis.timetable2.mock.StudentsMockDataFiller;
import org.primefaces.context.RequestContext;

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

    public String getDuration() {
        return "0";
    }

    public String getTotalPenaltyPoints() {
        int pointsTeacherLectureWindow = calculateTeachersLectureWindowForIIIAndIV();
        return String.valueOf(pointsTeacherLectureWindow);
    }

    public void calculatePenaltyPoints() {
        calculateTeachersLectureWindowForIIIAndIV();

    }

    private int calculateTeachersLectureWindowForIIIAndIV() {
        int penaltyPoints = 0;
        List<LinkedHashMap> teachersAllDay = getAllDaysTeacherTimeTable();

        for (LinkedHashMap<String, LinkedHashMap> daysTimeTable : teachersAllDay) {
            Collection<String> teacherNames = daysTimeTable.keySet();

            for (String teacherName : teacherNames) {
                LinkedHashMap<String, String> teachersTimeTableForTheDay = daysTimeTable.get(teacherName);
                Collection<String> lectureNumbers = teachersTimeTableForTheDay.keySet();
//                System.out.println("Lecture number size: " + lectureNumbers.size());
                int lectureNumbersSize = lectureNumbers.size();

                for (String lectureNumber : lectureNumbers) {
                    String groupNameToSplit = teachersTimeTableForTheDay.get(lectureNumber);
                    String[] splittedGroupNames = groupNameToSplit.split(":");
                    String groupName = splittedGroupNames[1].trim();

                    if (StringUtils.equals(groupName, EMPTY_GROUP)) {
                        if (studentsMockData.getTeachersFromIIIAndIV().containsKey(teacherName)) {
                            boolean isNotLastLectures = true;
                            for (int lectNum = Integer.valueOf(lectureNumber); lectNum <= lectureNumbersSize; lectNum++) {
                                System.out.println("lectNum: " + lectNum);
                         
                                String grpNam = teachersTimeTableForTheDay.get(String.valueOf(lectNum)).split(":")[1].trim();
                                System.out.println("grpName: " + grpNam);
                                
                                if (StringUtils.equals(grpNam, EMPTY_GROUP)) {
                                    isNotLastLectures = false;
                                } else {
                                    isNotLastLectures = true;
                                    break;
                                }
                            }
                            
                            System.out.println("isNotLastLectures: " + isNotLastLectures);
                            if (isNotLastLectures) {
                                penaltyPoints += PenaltyPoints.LECTURE_WINDOW_FOR_TEACHER_III_IV.penaltyPoints();
                                 
                            }

//                            System.out.println("Penalty points: " + penaltyPoints);
                        }
                    }

                }

            }
        }

        return penaltyPoints;

    }

    public List<LinkedHashMap> getAllDaysTeacherTimeTable() {
        return allDaysTeacherTimeTable;
    }

    public void setAllDaysTeacherTimeTable(List<LinkedHashMap> allDaysTeacherTimeTable) {
        this.allDaysTeacherTimeTable = allDaysTeacherTimeTable;
    }

}
