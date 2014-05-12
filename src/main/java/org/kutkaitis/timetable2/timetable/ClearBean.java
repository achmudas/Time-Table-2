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

import java.util.LinkedHashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author MkA
 */
@ManagedBean(name = "clearBean")
@SessionScoped
public class ClearBean {
    
    @Inject MonteCarlo monteCarlo;
    public void clearTimeTable() {
        LinkedHashMap mondayTm = monteCarlo.getOptimizedTimeTableForTeacherMonday();
        mondayTm = null;
                monteCarlo.getTeachersListOfIIIAndIVForOptm(); // just for creation

//        monteCarlo.getOptimizedTimeTableForTeacherTuesday()= null;
//        monteCarlo.getOptimizedTimeTableForTeacherWednesday() = null;
//        monteCarlo.getOptimizedTimeTableForTeacherThursday() = null;
//        monteCarlo.getOptimizedTimeTableForTeacherFriday() = null;
    }
    
}
