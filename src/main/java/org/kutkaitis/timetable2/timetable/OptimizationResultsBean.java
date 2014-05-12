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

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author MkA
 */
@ManagedBean(name = "optimizationResultsBean")
@SessionScoped
public class OptimizationResultsBean {

    @Inject
    PropertiesForOptimizationBean properties;
    
    private String duration;
    private String totalPenaltyPoints;

    public String getDuration() {
        return "0";
    }

    public String getTotalPenaltyPoints() {
        return "0";
    }
    
    public void showResults() {
        System.out.println("Kviecia");
        System.out.println("Checking request context from optimization results: " + RequestContext.getCurrentInstance().toString());
        RequestContext.getCurrentInstance().openDialog("showResults");

    }
}
