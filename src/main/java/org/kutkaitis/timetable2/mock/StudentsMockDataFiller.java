package org.kutkaitis.timetable2.mock;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.kutkaitis.timetable2.domain.Student;

/**
 *
 * @author achmudas
 */
@ManagedBean
@SessionScoped
public class StudentsMockDataFiller {
    
    public void fillMockDataForStudents() {
         for (int studentCounter = 0; studentCounter < 500; studentCounter++) {
             Student student = new Student();
             
         }
    }
    

}
