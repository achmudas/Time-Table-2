package org.kutkaitis.timetable2.mock;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.kutkaitis.timetable2.domain.Discipline;
import org.kutkaitis.timetable2.domain.Group;
import org.kutkaitis.timetable2.domain.Student;
import org.kutkaitis.timetable2.domain.Teacher;

/**
 *
 * @author achmudas
 */
@ManagedBean
@SessionScoped
public class StudentsMockDataFiller {

    public void fillMockDataForStudents() {

        List<Student> studentsIList = new ArrayList<>();
        
        
        List<Discipline> choosenDisciplinesI_II = new ArrayList<>();
        Discipline mtI_II = new Discipline();
        mtI_II.setDisciplineName("Matematika");
        mtI_II.setHoursPerWeek("4");
        Discipline ltI_II = new Discipline();
        ltI_II.setDisciplineName("Lietuviu kalba");
        ltI_II.setHoursPerWeek("5");
        Discipline fzI_II = new Discipline();
        fzI_II.setDisciplineName("Fizika");
        fzI_II.setHoursPerWeek("2");
        Discipline angI_II = new Discipline();
        angI_II.setDisciplineName("Anglu kalba");
        angI_II.setHoursPerWeek("3");
        
        choosenDisciplinesI_II.add(mtI_II);
        choosenDisciplinesI_II.add(fzI_II);
        choosenDisciplinesI_II.add(angI_II);
        choosenDisciplinesI_II.add(ltI_II);
        
        Teacher mtTeacherI_II_IIIA_IVA = new Teacher();
        List<Discipline> mtTeacherI_II_IIIA_IVADisciplines = new ArrayList<>();
        mtTeacherI_II_IIIA_IVADisciplines.add(mtI_II);
        mtTeacherI_II_IIIA_IVA.setName("TeacherI&II&IIIA&IVAMt");
        mtTeacherI_II_IIIA_IVA.setTeacherDisciplines(mtTeacherI_II_IIIA_IVADisciplines);

        Teacher ltTeacherI_II = new Teacher();
        List<Discipline> ltTeacherI_IIDisciplines = new ArrayList<>();
        ltTeacherI_IIDisciplines.add(ltI_II);
        ltTeacherI_II.setName("TeacherI&IILt");
        ltTeacherI_II.setTeacherDisciplines(ltTeacherI_IIDisciplines);
        
        Teacher fzTeacherI_II_IIIA_IVA = new Teacher();
        List<Discipline> fzTeacherI_II_IIIA_IVADisciplines = new ArrayList<>();
        fzTeacherI_II_IIIA_IVADisciplines.add(fzI_II);
        fzTeacherI_II_IIIA_IVA.setName("TeacherI&II&IIIA&IVAFz");
        fzTeacherI_II_IIIA_IVA.setTeacherDisciplines(fzTeacherI_II_IIIA_IVADisciplines);
        
        Teacher angTeacherI_II = new Teacher();
        List<Discipline> angTeacherI_IIDisciplines = new ArrayList<>();
        angTeacherI_IIDisciplines.add(angI_II);
        angTeacherI_II.setName("TeacherI&IIAng");
        angTeacherI_II.setTeacherDisciplines(angTeacherI_IIDisciplines);
        
        for (int i = 1; i <= 30; i++) {
            Student student = new Student();
            student.setName("StudentI" + i);
            
            student.setChosenDisciplines(choosenDisciplinesI_II);
            studentsIList.add(student);
            
        }

        // 1 gymnasium groups
        Group groupILt1 = new Group();
        groupILt1.setStudents(studentsIList);
        groupILt1.setDiscipline(ltI_II);
        groupILt1.setTeacher(ltTeacherI_II);
        Group groupILt2 = new Group();
        groupILt2.setStudents(studentsIList);
        groupILt2.setDiscipline(ltI_II);
        groupILt2.setTeacher(ltTeacherI_II);

        Group groupIMt1 = new Group();
        groupIMt1.setStudents(studentsIList);
        groupIMt1.setDiscipline(mtI_II);
        groupIMt1.setTeacher(mtTeacherI_II_IIIA_IVA);
        Group groupIMt2 = new Group();
        groupIMt2.setStudents(studentsIList);
        groupIMt2.setDiscipline(mtI_II);
        groupIMt2.setTeacher(mtTeacherI_II_IIIA_IVA);

        Group groupIFz1 = new Group();
        groupIFz1.setStudents(studentsIList);
        groupIFz1.setDiscipline(fzI_II);
        groupIFz1.setTeacher(fzTeacherI_II_IIIA_IVA);
        Group groupIFz2 = new Group();
        groupIFz2.setStudents(studentsIList);
        groupIFz2.setDiscipline(fzI_II);
        groupIFz2.setTeacher(fzTeacherI_II_IIIA_IVA);

        Group groupIAng1 = new Group();
        groupIAng1.setStudents(studentsIList);
        groupIAng1.setDiscipline(angI_II);
        groupIAng1.setTeacher(angTeacherI_II);
        Group groupIAng2 = new Group();
        groupIAng2.setStudents(studentsIList);
        groupIAng2.setDiscipline(angI_II);
        groupIAng2.setTeacher(angTeacherI_II);

        
        List<Student> studentsIIList = new ArrayList<>();
        
        for (int i = 1; i <= 30; i++) {
            Student student = new Student();
            student.setName("StudentII" + i);
            
            student.setChosenDisciplines(choosenDisciplinesI_II);
            studentsIIList.add(student);
            
        }
        
        
        // 2 gymnasium groups
        Group groupIILt1 = new Group();
        groupIILt1.setStudents(studentsIIList);
        groupIILt1.setDiscipline(ltI_II);
        groupIILt1.setTeacher(ltTeacherI_II);
        Group groupIILt2 = new Group();
        groupIILt2.setStudents(studentsIIList);
        groupIILt2.setDiscipline(ltI_II);
        groupIILt2.setTeacher(ltTeacherI_II);

        Group groupIIMt1 = new Group();
        groupIIMt1.setStudents(studentsIIList);
        groupIIMt1.setDiscipline(mtI_II);
        groupIIMt1.setTeacher(mtTeacherI_II_IIIA_IVA);
        Group groupIIMt2 = new Group();
        groupIIMt2.setStudents(studentsIIList);
        groupIIMt2.setDiscipline(mtI_II);
        groupIIMt2.setTeacher(mtTeacherI_II_IIIA_IVA);

        Group groupIIFz1 = new Group();
        groupIIFz1.setStudents(studentsIIList);
        groupIIFz1.setDiscipline(fzI_II);
        groupIIFz1.setTeacher(fzTeacherI_II_IIIA_IVA);
        Group groupIIFz2 = new Group();
        groupIIFz2.setStudents(studentsIIList);
        groupIIFz2.setDiscipline(fzI_II);
        groupIIFz2.setTeacher(fzTeacherI_II_IIIA_IVA);

        Group groupIIAng1 = new Group();
        groupIIAng1.setStudents(studentsIIList);
        groupIIAng1.setDiscipline(angI_II);
        groupIIAng1.setTeacher(angTeacherI_II);
        Group groupIIAng2 = new Group();
        groupIIAng2.setStudents(studentsIIList);
        groupIIAng2.setDiscipline(angI_II);
        groupIIAng2.setTeacher(angTeacherI_II);
        
        
        
        List<Discipline> choosenDisciplinesIII_IV = new ArrayList<>();
        Discipline mtIIIA_IVA = new Discipline();
        mtIIIA_IVA.setDisciplineName("Matematika A");
        mtIIIA_IVA.setHoursPerWeek("6");
        Discipline ltIIIA_IVA = new Discipline();
        ltIIIA_IVA.setDisciplineName("Lietuviu kalba A");
        ltIIIA_IVA.setHoursPerWeek("6");
        Discipline fzIIIA_IVA = new Discipline();
        fzIIIA_IVA.setDisciplineName("Fizika A");
        fzIIIA_IVA.setHoursPerWeek("4");
        Discipline angIIIA_IVA = new Discipline();
        angIIIA_IVA.setDisciplineName("Anglu kalba A");
        angIIIA_IVA.setHoursPerWeek("5");
        
        Discipline mtIIIB_IVB = new Discipline();
        mtIIIB_IVB.setDisciplineName("Matematika B");
        mtIIIB_IVB.setHoursPerWeek("3");
        Discipline ltIIIB_IVB = new Discipline();
        ltIIIB_IVB.setDisciplineName("Lietuviu kalba B");
        ltIIIB_IVB.setHoursPerWeek("4");
        Discipline fzIIIB_IVB = new Discipline();
        fzIIIB_IVB.setDisciplineName("Fizika B");
        fzIIIB_IVB.setHoursPerWeek("2");
        Discipline angIIIB_IVB = new Discipline();
        angIIIB_IVB.setDisciplineName("Anglu kalba B");
        angIIIB_IVB.setHoursPerWeek("3");
        
        Teacher mtTeacherIIIB_IVB = new Teacher();
        List<Discipline> mtTeacherIII_IVBDisciplines = new ArrayList<>();
        mtTeacherIII_IVBDisciplines.add(mtIIIB_IVB);
        mtTeacherIIIB_IVB.setName("TeacherIIIB&IVBMt");
        mtTeacherIIIB_IVB.setTeacherDisciplines(mtTeacherIII_IVBDisciplines);

        Teacher ltTeacherIIIA_IVA = new Teacher();
        List<Discipline> ltTeacherIIIA_IVADisciplines = new ArrayList<>();
        ltTeacherIIIA_IVADisciplines.add(ltIIIA_IVA);
        ltTeacherIIIA_IVA.setName("TeacherIIIA&IVALt");
        ltTeacherIIIA_IVA.setTeacherDisciplines(ltTeacherIIIA_IVADisciplines);
        
        Teacher ltTeacherIIIB_IVB = new Teacher();
        List<Discipline> ltTeacherIIIB_IVBDisciplines = new ArrayList<>();
        ltTeacherIIIB_IVBDisciplines.add(ltIIIB_IVB);
        ltTeacherIIIB_IVB.setName("TeacherIIIB&IVBLt");
        ltTeacherIIIB_IVB.setTeacherDisciplines(ltTeacherIIIB_IVBDisciplines);
        
        Teacher fzTeacherIIIB_IVB = new Teacher();
        List<Discipline> fzTeacherIIIB_IVBDisciplines = new ArrayList<>();
        fzTeacherIIIB_IVBDisciplines.add(fzIIIB_IVB);
        fzTeacherIIIB_IVB.setName("TeacherIIIB&IVBFz");
        fzTeacherIIIB_IVB.setTeacherDisciplines(fzTeacherIIIB_IVBDisciplines);
        
        Teacher angTeacherIIIA_IVA_IIIB_IVB = new Teacher();
        angTeacherIIIA_IVA_IIIB_IVB.setName("TeacherIIIA&IVA&IIIB&IVBAng");
        List<Discipline> angTeacherIIIA_IVA_IIIB_IVBDisciplines = new ArrayList<>();
        angTeacherIIIA_IVA_IIIB_IVBDisciplines.add(angIIIA_IVA);
        angTeacherIIIA_IVA_IIIB_IVBDisciplines.add(angIIIB_IVB);
        angTeacherIIIA_IVA_IIIB_IVB.setTeacherDisciplines(angTeacherIIIA_IVA_IIIB_IVBDisciplines);

        // 3 gymnsium groups
        Group groupIIILtA1 = new Group();
        Group groupIIILtA2 = new Group();
        Group groupIIILtB1 = new Group();
        Group groupIIILtB2 = new Group();

        Group groupIIIMtA1 = new Group();
        Group groupIIIMtA2 = new Group();
        Group groupIIIMtB1 = new Group();
        Group groupIIIMtB2 = new Group();

        Group groupIIIFzA1 = new Group();
        Group groupIIIFzA2 = new Group();
        Group groupIIIFzB1 = new Group();
        Group groupIIIFzB2 = new Group();

        Group groupIIIAngA1 = new Group();
        Group groupIIIAngA2 = new Group();
        Group groupIIIAngB1 = new Group();
        Group groupIIIAngB2 = new Group();

        // 4 gymnasium groups
        Group groupIVLtA1 = new Group();
        Group groupIVLtA2 = new Group();
        Group groupIVLtB1 = new Group();
        Group groupIVLtB2 = new Group();

        Group groupIVMtA1 = new Group();
        Group groupIVMtA2 = new Group();
        Group groupIVMtB1 = new Group();
        Group groupIVMtB2 = new Group();

        Group groupIVFzA1 = new Group();
        Group groupIVFzA2 = new Group();
        Group groupIVFzB1 = new Group();
        Group groupIVFzB2 = new Group();

        Group groupIVAngA1 = new Group();
        Group groupIVAngA2 = new Group();
        Group groupIVAngB1 = new Group();
        Group groupIVAngB2 = new Group();

    }

}
