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
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.kutkaitis.timetable2.mock.StudentsMockDataFiller;

/**
 *
 * @author MkA
 */
@Named(value = "users")
@RequestScoped
public class Users {

    @EJB
    StudentsMockDataFiller studentsMockDataFiller;
    List<String> teachersNames;

    public Users() {
    }

    public List<String> getTeachersNames() {
        teachersNames = new ArrayList<>();
        System.out.println("KVIECIA");
        teachersNames.addAll(studentsMockDataFiller.getTeachers().keySet());
        return teachersNames;
    }
}
