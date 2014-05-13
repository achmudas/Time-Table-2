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

/**
 *
 * @author MkA
 */
public enum PenaltyPoints {
    LECTURE_WINDOW_FOR_TEACHER_III_IV (100),
    LECTURE_WINDOW_FOR_STUDENT_TEACHER_TIME_TABLE (10),
    BAD_WORKING_HOURS_FOR_TEACHER_III_IV (10),
    BAD_WORKING_DAYS_FOR_TEACHER_III_IV (10),
    BAD_LECTURES_DIDACTICS (100),
    STUDENT_GROUP_LIST_CHANGES (1000),
    MORE_THAN_SEVEN_LECTURES_PER_DAY (100);
    
    private final int penaltyPoints;
    
    public int penaltyPoints() {
        return penaltyPoints;
    }
    
    PenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }
    
}
