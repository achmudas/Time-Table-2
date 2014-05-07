package org.kutkaitis.timetable2.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Startup;
import org.apache.commons.lang3.StringUtils;
import org.kutkaitis.timetable2.domain.Discipline;
import org.kutkaitis.timetable2.domain.Group;
import org.kutkaitis.timetable2.domain.Student;
import org.kutkaitis.timetable2.domain.Teacher;

/**
 *
 * @author achmudas
 */
@Startup
public class StudentsMockDataFiller {

    private HashMap<String, Group> groups = new HashMap<String, Group>();
    private HashMap<String, Teacher> teachers = new HashMap<String, Teacher>();

    public HashMap<String, Group> getGroups() {
        return groups;
    }

    public HashMap<String, Teacher> getTeachers() {
        return teachers;
    }

    // Creates mock data at the start of application
    @PostConstruct
    public void init() {
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
        createGroup(studentsIList1, ltI_II, ltTeacherI_II, "LtI1");
        createGroup(studentsIList2, ltI_II, ltTeacherI_II, "LtI2");

        createGroup(studentsIList1, mtI_II, mtTeacherI_II_IIIA_IVA, "MtI1");
        createGroup(studentsIList2, mtI_II, mtTeacherI_II_IIIA_IVA, "MtI2");

        createGroup(studentsIList1, fzI_II, fzTeacherI_II_IIIA_IVA, "FzI1");
        createGroup(studentsIList2, fzI_II, fzTeacherI_II_IIIA_IVA, "FzI2");

        createGroup(studentsIList1, angI_II, angTeacherI_II, "AngI1");
        createGroup(studentsIList2, angI_II, angTeacherI_II, "AngI2");

        List<Student> studentsIIList1 = createStudentsList("StudentII_", 1, 30, choosenDisciplinesI_II);
        List<Student> studentsIIList2 = createStudentsList("StudentII_", 31, 60, choosenDisciplinesI_II);

        // 2 gymnasium groups
        createGroup(studentsIIList1, ltI_II, ltTeacherI_II, "LtII1");
        createGroup(studentsIIList2, ltI_II, ltTeacherI_II, "LtII2");

        createGroup(studentsIIList1, mtI_II, mtTeacherI_II_IIIA_IVA, "MtII1");
        createGroup(studentsIIList2, mtI_II, mtTeacherI_II_IIIA_IVA, "MtII2");

        createGroup(studentsIIList1, fzI_II, fzTeacherI_II_IIIA_IVA, "FzII1");
        createGroup(studentsIIList2, fzI_II, fzTeacherI_II_IIIA_IVA, "FzII2");

        createGroup(studentsIIList1, angI_II, angTeacherI_II, "AngII1");
        createGroup(studentsIIList2, angI_II, angTeacherI_II, "AngII2");

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

        createGroup(studentsIIIListHum1, ltIIIA_IVA, ltTeacherIIIA_IVA, "LtAIII1");
        createGroup(studentsIIIListHum2, ltIIIA_IVA, ltTeacherIIIA_IVA, "LtAIII2");

        createGroup(studentsIIIListReal1, ltIIIB_IVB, ltTeacherIIIB_IVB, "LtBIII1");
        createGroup(studentsIIIListReal2, ltIIIB_IVB, ltTeacherIIIB_IVB, "LtBIII2");

        createGroup(studentsIIIListReal1, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA, "MtAIII1");
        createGroup(studentsIIIListReal2, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA, "MtAIII2");

        createGroup(studentsIIIListHum1, mtIIIB_IVB, mtTeacherIIIB_IVB, "MtBIII1");
        createGroup(studentsIIIListHum2, mtIIIB_IVB, mtTeacherIIIB_IVB, "MtBIII2");

        createGroup(studentsIIIListReal1, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA, "FzAIII1");
        createGroup(studentsIIIListReal2, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA, "FzAIII2");

        createGroup(studentsIIIListHum1, fzIIIB_IVB, fzTeacherIIIB_IVB, "FzBIII1");
        createGroup(studentsIIIListHum2, fzIIIB_IVB, fzTeacherIIIB_IVB, "FzBIII2");

        createGroup(studentsIIIListHum1, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB, "AngAIII1");
        createGroup(studentsIIIListHum2, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB, "AngAIII2");

        createGroup(studentsIIIListReal1, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB, "AngBIII1");
        createGroup(studentsIIIListReal2, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB, "AngBIII2");

        // 4 gymnasium groups
        List<Student> studentsIVListReal1 = createStudentsList("StudentIV_real_", 1, 20, choosenDisciplinesIII_IV_real);
        List<Student> studentsIVListReal2 = createStudentsList("StudentIV_real_", 21, 40, choosenDisciplinesIII_IV_real);
        List<Student> studentsIVListHum1 = createStudentsList("StudentIV_hum_", 1, 20, choosenDisciplinesIII_IV_hum);
        List<Student> studentsIVListHum2 = createStudentsList("StudentIV_hum_", 21, 40, choosenDisciplinesIII_IV_hum);

        createGroup(studentsIVListHum1, ltIIIA_IVA, ltTeacherIIIA_IVA, "LtAIV1");
        createGroup(studentsIVListHum2, ltIIIA_IVA, ltTeacherIIIA_IVA, "LtAIV2");

        createGroup(studentsIVListReal1, ltIIIB_IVB, ltTeacherIIIB_IVB, "LtBIV1");
        createGroup(studentsIVListReal2, ltIIIB_IVB, ltTeacherIIIB_IVB, "LtBIV2");

        createGroup(studentsIVListReal1, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA, "MtAIV1");
        createGroup(studentsIVListReal2, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA, "MtAIV2");

        createGroup(studentsIVListHum1, mtIIIB_IVB, mtTeacherIIIB_IVB, "MtBIV1");
        createGroup(studentsIVListHum2, mtIIIB_IVB, mtTeacherIIIB_IVB, "MtBIV2");

        createGroup(studentsIVListReal1, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA, "FzAIV1");
        createGroup(studentsIVListReal2, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA, "FzAIV2");

        createGroup(studentsIVListHum1, fzIIIB_IVB, fzTeacherIIIB_IVB, "FzBIV1");
        createGroup(studentsIVListHum2, fzIIIB_IVB, fzTeacherIIIB_IVB, "FzBIV2");

        createGroup(studentsIVListHum1, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB, "AngAIV1");
        createGroup(studentsIVListHum2, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB, "AngAIV2");

        createGroup(studentsIVListReal1, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB, "AngBIV1");
        createGroup(studentsIVListReal2, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB, "AngBIV2");

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

        for (Discipline disp : disciplines) {
            String dispName = disp.getDisciplineName();
            int iOccurMatches = StringUtils.countMatches(name, "I");
            boolean teachesI = false;
            boolean teachesII = false;
            boolean teachesIII = false;
            boolean teachesIV = false;
            if (iOccurMatches == 1 && !StringUtils.contains(name, "IV")) {
                teachesI = true;
            } else if (iOccurMatches == 2) {
                teachesII = true;
            } else if (iOccurMatches == 3) {
                teachesIII = true;
            } else {
                teachesIV = true;
            }
            
            if (teachesIII || teachesIV) {
                teacher.setTeacherInIIIAndIVGymnasiumClasses(true);
            }
        }

        teacher.setTeachersGroups(new ArrayList<Group>());
        teachers.put(name, teacher);
        return teacher;
    }

    private Group createGroup(List<Student> studentsList, Discipline discipline, Teacher teacher, String name) {
        Group group = new Group();
        group.setStudents(studentsList);
        group.setDiscipline(discipline);
        group.setTeacher(teacher);
        group.setGroupName(name);
        decideGymnasiumGroup(name, group);
        groups.put(name, group);
        teacher.getTeachersGroups().add(group);
        return group;
    }

    private void decideGymnasiumGroup(String name, Group group) {
        int iOccurMatches = StringUtils.countMatches(name, "I");
        if (iOccurMatches == 1 && !StringUtils.contains(name, "IV")) {
            group.setiGymnasiumGroup(true);
        } else if (iOccurMatches == 2) {
            group.setIiGymnasiumGroup(true);
        } else if (iOccurMatches == 3) {
            group.setIiiGymnasiumGroup(true);
        } else {
            group.setIvGymnasiumGroup(true);
        }
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

    @PreDestroy
    public void destroy() {
    }

}
