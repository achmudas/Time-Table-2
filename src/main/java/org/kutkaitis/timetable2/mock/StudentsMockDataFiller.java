package org.kutkaitis.timetable2.mock;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
//TODO create group names
@ManagedBean
@SessionScoped
public class StudentsMockDataFiller {

    @PostConstruct
    private void fillMockDataForStudents() {

        
        Discipline mtI_II = createDiscipline("Matematika", "4");
        Discipline ltI_II = createDiscipline("Lietuviu kalba", "5");
        Discipline fzI_II = createDiscipline("Fizika", "2");
        Discipline angI_II = createDiscipline("Anglu kalba", "3");

        List<Discipline> choosenDisciplinesI_II = new ArrayList<>();
        choosenDisciplinesI_II.add(mtI_II);
        choosenDisciplinesI_II.add(fzI_II);
        choosenDisciplinesI_II.add(angI_II);
        choosenDisciplinesI_II.add(ltI_II);

        Teacher mtTeacherI_II_IIIA_IVA = createTeacher("TeacherI&II&IIIA&IVAMt", mtI_II);
        Teacher ltTeacherI_II = createTeacher("TeacherI&IILt", ltI_II);
        Teacher fzTeacherI_II_IIIA_IVA = createTeacher("TeacherI&II&IIIA&IVAFz", fzI_II);
        Teacher angTeacherI_II = createTeacher("TeacherI&IIAng", angI_II);

        List<Student> studentsIList1 = createStudentsList("StudentI_", 1, 30, choosenDisciplinesI_II);
        List<Student> studentsIList2 = createStudentsList("StudentI_", 31, 60, choosenDisciplinesI_II);

        // 1 gymnasium groups
        Group groupILt1 = createGroup(studentsIList1, ltI_II, ltTeacherI_II);
        Group groupILt2 = createGroup(studentsIList2, ltI_II, ltTeacherI_II);

        Group groupIMt1 = createGroup(studentsIList1, mtI_II, mtTeacherI_II_IIIA_IVA);
        Group groupIMt2 = createGroup(studentsIList2, mtI_II, mtTeacherI_II_IIIA_IVA);

        Group groupIFz1 = createGroup(studentsIList1, fzI_II, fzTeacherI_II_IIIA_IVA);
        Group groupIFz2 = createGroup(studentsIList2, fzI_II, fzTeacherI_II_IIIA_IVA);

        Group groupIAng1 = createGroup(studentsIList1, angI_II, angTeacherI_II);
        Group groupIAng2 = createGroup(studentsIList2, angI_II, angTeacherI_II);

        List<Student> studentsIIList1 = createStudentsList("StudentII_", 1, 30, choosenDisciplinesI_II);
        List<Student> studentsIIList2 = createStudentsList("StudentII_", 31, 60, choosenDisciplinesI_II);

        // 2 gymnasium groups
        Group groupIILt1 = createGroup(studentsIIList1, ltI_II, ltTeacherI_II);
        Group groupIILt2 = createGroup(studentsIIList2, ltI_II, ltTeacherI_II);

        Group groupIIMt1 = createGroup(studentsIIList1, mtI_II, mtTeacherI_II_IIIA_IVA);
        Group groupIIMt2 = createGroup(studentsIIList2, mtI_II, mtTeacherI_II_IIIA_IVA);

        Group groupIIFz1 = createGroup(studentsIIList1, fzI_II, fzTeacherI_II_IIIA_IVA);
        Group groupIIFz2 = createGroup(studentsIIList2, fzI_II, fzTeacherI_II_IIIA_IVA);

        Group groupIIAng1 = createGroup(studentsIIList1, angI_II, angTeacherI_II);
        Group groupIIAng2 = createGroup(studentsIIList2, angI_II, angTeacherI_II);

        Discipline mtIIIA_IVA = createDiscipline("Matematika A", "6");
        Discipline ltIIIA_IVA = createDiscipline("Lietuviu kalba A", "6");
        Discipline fzIIIA_IVA = createDiscipline("Fizika A", "4");
        Discipline angIIIA_IVA = createDiscipline("Anglu kalba A", "5");
        Discipline mtIIIB_IVB = createDiscipline("Matematika B", "3");
        Discipline ltIIIB_IVB = createDiscipline("Lietuviu kalba B", "4");
        Discipline fzIIIB_IVB = createDiscipline("Fizika B", "2");
        Discipline angIIIB_IVB = createDiscipline("Anglu kalba B", "3");

        Teacher mtTeacherIIIB_IVB = createTeacher("TeacherIIIB&IVBMt", mtIIIB_IVB);
        Teacher ltTeacherIIIA_IVA = createTeacher("TeacherIIIA&IVALt", ltIIIA_IVA);
        Teacher ltTeacherIIIB_IVB = createTeacher("TeacherIIIB&IVBLt", ltIIIB_IVB);
        Teacher fzTeacherIIIB_IVB = createTeacher("TeacherIIIB&IVBFz", fzIIIB_IVB);
        Teacher angTeacherIIIA_IVA_IIIB_IVB = createTeacher("TeacherIIIA&IVA&IIIB&IVBAng", angIIIA_IVA, angIIIB_IVB);

        // 3 gymnasium groups
        List<Discipline> choosenDisciplinesIII_IV_hum = new ArrayList<>();
        List<Discipline> choosenDisciplinesIII_IV_real = new ArrayList<>();

        // Adding disciplines for III and IV
        choosenDisciplinesIII_IV_hum.add(ltIIIA_IVA);
        choosenDisciplinesIII_IV_hum.add(angIIIA_IVA);
        choosenDisciplinesIII_IV_hum.add(mtIIIB_IVB);
        choosenDisciplinesIII_IV_hum.add(fzIIIB_IVB);

        choosenDisciplinesIII_IV_real.add(ltIIIB_IVB);
        choosenDisciplinesIII_IV_real.add(angIIIB_IVB);
        choosenDisciplinesIII_IV_real.add(mtIIIA_IVA);
        choosenDisciplinesIII_IV_real.add(fzIIIA_IVA);

        List<Student> studentsIIIListReal1 = createStudentsList("StudentIII_real_", 1, 20, choosenDisciplinesIII_IV_real);
        List<Student> studentsIIIListReal2 = createStudentsList("StudentIII_real_", 21, 40, choosenDisciplinesIII_IV_real);
        List<Student> studentsIIIListHum1 = createStudentsList("StudentIII_hum_", 1, 20, choosenDisciplinesIII_IV_hum);
        List<Student> studentsIIIListHum2 = createStudentsList("StudentIII_hum_", 21, 40, choosenDisciplinesIII_IV_hum);

        Group groupIIILtA1 = createGroup(studentsIIIListHum1, ltIIIA_IVA, ltTeacherIIIA_IVA);
        Group groupIIILtA2 = createGroup(studentsIIIListHum2, ltIIIA_IVA, ltTeacherIIIA_IVA);

        Group groupIIILtB1 = createGroup(studentsIIIListReal1, ltIIIB_IVB, ltTeacherIIIB_IVB);
        Group groupIIILtB2 = createGroup(studentsIIIListReal2, ltIIIB_IVB, ltTeacherIIIB_IVB);

        Group groupIIIMtA1 = createGroup(studentsIIIListReal1, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA);
        Group groupIIIMtA2 = createGroup(studentsIIIListReal2, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA);

        Group groupIIIMtB1 = createGroup(studentsIIIListHum1, mtIIIB_IVB, mtTeacherIIIB_IVB);
        Group groupIIIMtB2 = createGroup(studentsIIIListHum2, mtIIIB_IVB, mtTeacherIIIB_IVB);

        Group groupIIIFzA1 = createGroup(studentsIIIListReal1, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA);
        Group groupIIIFzA2 = createGroup(studentsIIIListReal2, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA);

        Group groupIIIFzB1 = createGroup(studentsIIIListHum1, fzIIIB_IVB, fzTeacherIIIB_IVB);
        Group groupIIIFzB2 = createGroup(studentsIIIListHum2, fzIIIB_IVB, fzTeacherIIIB_IVB);

        Group groupIIIAngA1 = createGroup(studentsIIIListHum1, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB);
        Group groupIIIAngA2 = createGroup(studentsIIIListHum2, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB);

        Group groupIIIAngB1 = createGroup(studentsIIIListReal1, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB);
        Group groupIIIAngB2 = createGroup(studentsIIIListReal2, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB);

        // 4 gymnasium groups
        List<Student> studentsIVListReal1 = createStudentsList("StudentIV_real_", 1, 20, choosenDisciplinesIII_IV_real);
        List<Student> studentsIVListReal2 = createStudentsList("StudentIV_real_", 21, 40, choosenDisciplinesIII_IV_real);
        List<Student> studentsIVListHum1 = createStudentsList("StudentIV_hum_", 1, 20, choosenDisciplinesIII_IV_hum);
        List<Student> studentsIVListHum2 = createStudentsList("StudentIV_hum_", 21, 40, choosenDisciplinesIII_IV_hum);

        Group groupIVLtA1 = createGroup(studentsIVListHum1, ltIIIA_IVA, ltTeacherIIIA_IVA);
        Group groupIVLtA2 = createGroup(studentsIVListHum2, ltIIIA_IVA, ltTeacherIIIA_IVA);

        Group groupIVLtB1 = createGroup(studentsIVListReal1, ltIIIB_IVB, ltTeacherIIIB_IVB);
        Group groupIVLtB2 = createGroup(studentsIVListReal2, ltIIIB_IVB, ltTeacherIIIB_IVB);

        Group groupIVMtA1 = createGroup(studentsIVListReal1, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA);
        Group groupIVMtA2 = createGroup(studentsIVListReal2, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA);

        Group groupIVMtB1 = createGroup(studentsIVListHum1, mtIIIB_IVB, mtTeacherIIIB_IVB);
        Group groupIVMtB2 = createGroup(studentsIVListHum2, mtIIIB_IVB, mtTeacherIIIB_IVB);

        Group groupIVFzA1 = createGroup(studentsIVListReal1, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA);
        Group groupIVFzA2 = createGroup(studentsIVListReal2, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA);

        Group groupIVFzB1 = createGroup(studentsIVListHum1, fzIIIB_IVB, fzTeacherIIIB_IVB);
        Group groupIVFzB2 = createGroup(studentsIVListHum2, fzIIIB_IVB, fzTeacherIIIB_IVB);

        Group groupIVAngA1 = createGroup(studentsIVListHum1, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB);
        Group groupIVAngA2 = createGroup(studentsIVListHum2, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB);

        Group groupIVAngB1 = createGroup(studentsIVListReal1, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB);
        Group groupIVAngB2 = createGroup(studentsIVListReal2, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB);

    }

    private Discipline createDiscipline(String name, String hoursPerWeek) {
        Discipline discipline = new Discipline();
        discipline.setDisciplineName(name);
        discipline.setHoursPerWeek(hoursPerWeek);
        return discipline;
    }

    private Teacher createTeacher(String name, Discipline... discipline) {
        Teacher teacher = new Teacher();
        List<Discipline> disciplines = new ArrayList<>();
        for (Discipline disp : discipline) {
            disciplines.add(disp);
        }
        teacher.setName(name);
        teacher.setTeacherDisciplines(disciplines);
        return teacher;
    }

    private Group createGroup(List<Student> studentsList, Discipline discipline, Teacher teacher) {
        Group group = new Group();
        group.setStudents(studentsList);
        group.setDiscipline(discipline);
        group.setTeacher(teacher);
        return group;
    }

    private List createStudentsList(String studentName, int from, int until, List<Discipline> choosenDisciplines) {
        List<Student> studentsList = new ArrayList<>();
        for (int i = from; i <= until; i++) {
            Student student = new Student();
            student.setName(studentName + i);

            student.setChosenDisciplines(choosenDisciplines);
            studentsList.add(student);

        }

        return studentsList;
    }

}
