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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
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

    List<String> mondayTimeTable;

    public List<String> getOptimizedTimeTableForTeacherMonday() {
        mondayTimeTable = new ArrayList<>();
        for (String teacherNames : usersBean.getTeachersNames()) {
            Teacher teacher = studentsMockDataFiller.getTeachers().get(teacherNames);
            mondayTimeTable.add()
        }
            
        }
        
        return mondayTimeTable;
    }

}
