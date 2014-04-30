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

import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author MkA
 */
@ManagedBean(name="propertiesForOptimizationBean")
@SessionScoped
public class PropertiesForOptimizationBean implements Serializable{

    /**
     * Creates a new instance of PropertiesForOptimisation
     */
    public PropertiesForOptimizationBean() {
    }
    
    int optimizationIterations;
    int hoursPerDay;
    String optimizationMethod;

    public int getOptimisationIterations() {
        return optimizationIterations;
    }

    public void setOptimisationIterations(int optimisationIterations) {
        this.optimizationIterations = optimisationIterations;
    }

    public int getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(int hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public String getOptimisationMethod() {
        return optimizationMethod;
    }

    public void setOptimisationMethod(String optimisationMethod) {
        this.optimizationMethod = optimisationMethod;
    }
    
    
    
    
}
