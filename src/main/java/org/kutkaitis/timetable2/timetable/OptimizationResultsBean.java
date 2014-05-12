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

    private String duration;
    private String totalPenaltyPoints;
    private List<LinkedHashMap> allDaysTeacherTimeTable;

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
        List<LinkedHashMap> teachersAllDay = getAllDaysTeacherTimeTable();
        int points = 0;
        
             for (LinkedHashMap<String, LinkedHashMap> daysTimeTable : teachersAllDay) {
                 for (LinkedHashMap teachersDayLectures : daysTimeTable) {
                     
                 }
                  teachersNames = daysTimeTable.keySet();
//                 for(String teacherName : teachersNames) {
//                     
//                 }
             }
       
        return points;
        
    }

    public List<LinkedHashMap> getAllDaysTeacherTimeTable() {
        return allDaysTeacherTimeTable;
    }

    public void setAllDaysTeacherTimeTable(List<LinkedHashMap> allDaysTeacherTimeTable) {
        this.allDaysTeacherTimeTable = allDaysTeacherTimeTable;
    }

}
