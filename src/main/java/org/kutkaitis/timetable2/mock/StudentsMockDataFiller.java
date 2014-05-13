package org.kutkaitis.timetable2.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Startup;
import org.apache.commons.lang3.StringUtils;
import org.kutkaitis.timetable2.domain.ClassRoom;
import org.kutkaitis.timetable2.domain.Discipline;
import org.kutkaitis.timetable2.domain.Group;
import org.kutkaitis.timetable2.domain.Student;
import org.kutkaitis.timetable2.domain.Teacher;
import org.kutkaitis.timetable2.timetable.Days;

/**
 *
 * @author achmudas
 */
@Startup
public class StudentsMockDataFiller {

    private HashMap<String, Group> groups = new HashMap<String, Group>();
    private HashMap<String, Teacher> teachers = new HashMap<String, Teacher>();
    private HashMap<String, Teacher> teachersFromIIIAndIV = new HashMap<String, Teacher>();

    public HashMap<String, Group> getGroups() {
        return groups;
    }

    public HashMap<String, Teacher> getTeachers() {
        return teachers;
    }

    public HashMap<String, Teacher> getTeachersFromIIIAndIV() {
        return teachersFromIIIAndIV;
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

        Teacher mtTeacherI_II_IIIA_IVA = createTeacher("TeacherI&II&IIIA&IVAMt", true, null, null, mtI_II);
        
        List<Days> freeDaysForLtTeach = new ArrayList<>();
        freeDaysForLtTeach.add(Days.MONDAY);
        Map<Days, String> freeHoursLtTeacher = new HashMap<>();
        freeHoursLtTeacher.put(Days.TUESDAY, "2");
        
        Teacher ltTeacherI_II = createTeacher("TeacherI&IILt", false, freeDaysForLtTeach, freeHoursLtTeacher, ltI_II);
        Teacher fzTeacherI_II_IIIA_IVA = createTeacher("TeacherI&II&IIIA&IVAFz", true, null, null, fzI_II);
        Teacher angTeacherI_II = createTeacher("TeacherI&IIAng", false, freeDaysForLtTeach, freeHoursLtTeacher, angI_II );

        List<Student> studentsIList1 = createStudentsList("StudentI_", 1, 30, choosenDisciplinesI_II);
        List<Student> studentsIList2 = createStudentsList("StudentI_", 31, 60, choosenDisciplinesI_II);
        
        ClassRoom classRoom1IAndII = new ClassRoom();
        classRoom1IAndII.setRoomNumber("100");
        classRoom1IAndII.setSpecializedRoom(false);
        
        ClassRoom classRoom2IAndII = new ClassRoom();
        classRoom2IAndII.setRoomNumber("101");
        classRoom2IAndII.setSpecializedRoom(false);
        ClassRoom classRoom3IAndII = new ClassRoom();
        classRoom3IAndII.setRoomNumber("102");
        classRoom3IAndII.setSpecializedRoom(false);
        ClassRoom classRoom4IAndII = new ClassRoom();
        classRoom4IAndII.setRoomNumber("103");
        classRoom4IAndII.setSpecializedRoom(false);
        
        ClassRoom classRoom5IIIAndIV = new ClassRoom();
        classRoom5IIIAndIV.setRoomNumber("104");
        classRoom5IIIAndIV.setSpecializedRoom(false);
        ClassRoom classRoom6IIIAndIV = new ClassRoom();
        classRoom6IIIAndIV.setRoomNumber("105");
        classRoom6IIIAndIV.setSpecializedRoom(false);
        ClassRoom classRoom7IIIAndIV = new ClassRoom();
        classRoom7IIIAndIV.setRoomNumber("106");
        classRoom7IIIAndIV.setSpecializedRoom(false);
        
        ClassRoom classRoom8IIIAndIV = new ClassRoom();
        classRoom8IIIAndIV.setRoomNumber("107");
        classRoom8IIIAndIV.setSpecializedRoom(false);
        ClassRoom classRoom9IIIAndIV = new ClassRoom();
        classRoom9IIIAndIV.setRoomNumber("108");
        classRoom9IIIAndIV.setSpecializedRoom(false);
        ClassRoom classRoom10IIIAndIV = new ClassRoom();
        classRoom10IIIAndIV.setRoomNumber("109");
        classRoom10IIIAndIV.setSpecializedRoom(false);
        ClassRoom classRoom11IIIAndIV = new ClassRoom();
        classRoom11IIIAndIV.setRoomNumber("120");
        classRoom11IIIAndIV.setSpecializedRoom(false);
        ClassRoom classRoom12FzIAndII = new ClassRoom();
        classRoom12FzIAndII.setRoomNumber("200");
        classRoom12FzIAndII.setSpecializedRoom(true);
        
        ClassRoom classRoom13FzIIIAndIV = new ClassRoom();
        classRoom13FzIIIAndIV.setRoomNumber("201");
        classRoom13FzIIIAndIV.setSpecializedRoom(true);
        ClassRoom classRoom14FzIIIAndIV = new ClassRoom();
        classRoom14FzIIIAndIV.setRoomNumber("202");
        classRoom14FzIIIAndIV.setSpecializedRoom(true);
        
        // 1 gymnasium groups
        createGroup(studentsIList1, ltI_II, ltTeacherI_II, "LtI1", classRoom1IAndII);
        createGroup(studentsIList2, ltI_II, ltTeacherI_II, "LtI2", classRoom1IAndII);

        createGroup(studentsIList1, mtI_II, mtTeacherI_II_IIIA_IVA, "MtI1", classRoom2IAndII);
        createGroup(studentsIList2, mtI_II, mtTeacherI_II_IIIA_IVA, "MtI2", classRoom2IAndII);

        createGroup(studentsIList1, fzI_II, fzTeacherI_II_IIIA_IVA, "FzI1", classRoom12FzIAndII);
        createGroup(studentsIList2, fzI_II, fzTeacherI_II_IIIA_IVA, "FzI2", classRoom12FzIAndII);

        createGroup(studentsIList1, angI_II, angTeacherI_II, "AngI1", classRoom3IAndII);
        createGroup(studentsIList2, angI_II, angTeacherI_II, "AngI2", classRoom3IAndII);

        List<Student> studentsIIList1 = createStudentsList("StudentII_", 1, 30, choosenDisciplinesI_II);
        List<Student> studentsIIList2 = createStudentsList("StudentII_", 31, 60, choosenDisciplinesI_II);

        // 2 gymnasium groups
        createGroup(studentsIIList1, ltI_II, ltTeacherI_II, "LtII1", classRoom4IAndII);
        createGroup(studentsIIList2, ltI_II, ltTeacherI_II, "LtII2", classRoom4IAndII);

        createGroup(studentsIIList1, mtI_II, mtTeacherI_II_IIIA_IVA, "MtII1", classRoom1IAndII);
        createGroup(studentsIIList2, mtI_II, mtTeacherI_II_IIIA_IVA, "MtII2", classRoom1IAndII);

        createGroup(studentsIIList1, fzI_II, fzTeacherI_II_IIIA_IVA, "FzII1", classRoom12FzIAndII);
        createGroup(studentsIIList2, fzI_II, fzTeacherI_II_IIIA_IVA, "FzII2", classRoom12FzIAndII);

        createGroup(studentsIIList1, angI_II, angTeacherI_II, "AngII1", classRoom2IAndII);
        createGroup(studentsIIList2, angI_II, angTeacherI_II, "AngII2", classRoom3IAndII);

        Discipline mtIIIA_IVA = createDiscipline("Matematika A", "6");
        Discipline ltIIIA_IVA = createDiscipline("Lietuviu kalba A", "6");
        Discipline fzIIIA_IVA = createDiscipline("Fizika A", "4");
        Discipline angIIIA_IVA = createDiscipline("Anglu kalba A", "5");
        Discipline mtIIIB_IVB = createDiscipline("Matematika B", "3");
        Discipline ltIIIB_IVB = createDiscipline("Lietuviu kalba B", "4");
        Discipline fzIIIB_IVB = createDiscipline("Fizika B", "2");
        Discipline angIIIB_IVB = createDiscipline("Anglu kalba B", "3");

        List<Days> freeDaysForIIIAndIVTeacher = new ArrayList<>();
        freeDaysForIIIAndIVTeacher.add(Days.FRIDAY);
        Map<Days, String> freeHoursForIIIAndIVTeacher = new HashMap<>();
        freeHoursForIIIAndIVTeacher.put(Days.THURSDAY, "3");
        
        Map<Days, String> freeHoursForIIIAndIVTeacher2 = new HashMap<>();
        freeHoursForIIIAndIVTeacher2.put(Days.MONDAY, "3");
        
        Teacher mtTeacherIIIB_IVB = createTeacher("TeacherIIIB&IVBMt", true, freeDaysForIIIAndIVTeacher, null, mtIIIB_IVB);
        Teacher ltTeacherIIIA_IVA = createTeacher("TeacherIIIA&IVALt", true, null, freeHoursForIIIAndIVTeacher, ltIIIA_IVA);
        Teacher ltTeacherIIIB_IVB = createTeacher("TeacherIIIB&IVBLt", true, null, null, ltIIIB_IVB);
        Teacher fzTeacherIIIB_IVB = createTeacher("TeacherIIIB&IVBFz", true, null, freeHoursForIIIAndIVTeacher, fzIIIB_IVB);
        Teacher angTeacherIIIA_IVA_IIIB_IVB = createTeacher("TeacherIIIA&IVA&IIIB&IVBAng", true, null, freeHoursForIIIAndIVTeacher2, angIIIA_IVA, angIIIB_IVB);

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

        createGroup(studentsIIIListHum1, ltIIIA_IVA, ltTeacherIIIA_IVA, "LtAIII1", classRoom5IIIAndIV);
        createGroup(studentsIIIListHum2, ltIIIA_IVA, ltTeacherIIIA_IVA, "LtAIII2", classRoom5IIIAndIV);

        createGroup(studentsIIIListReal1, ltIIIB_IVB, ltTeacherIIIB_IVB, "LtBIII1", classRoom6IIIAndIV);
        createGroup(studentsIIIListReal2, ltIIIB_IVB, ltTeacherIIIB_IVB, "LtBIII2", classRoom6IIIAndIV);

        createGroup(studentsIIIListReal1, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA, "MtAIII1", classRoom7IIIAndIV);
        createGroup(studentsIIIListReal2, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA, "MtAIII2", classRoom7IIIAndIV);

        createGroup(studentsIIIListHum1, mtIIIB_IVB, mtTeacherIIIB_IVB, "MtBIII1", classRoom8IIIAndIV);
        createGroup(studentsIIIListHum2, mtIIIB_IVB, mtTeacherIIIB_IVB, "MtBIII2", classRoom8IIIAndIV);

        createGroup(studentsIIIListReal1, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA, "FzAIII1", classRoom13FzIIIAndIV);
        createGroup(studentsIIIListReal2, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA, "FzAIII2", classRoom13FzIIIAndIV);

        createGroup(studentsIIIListHum1, fzIIIB_IVB, fzTeacherIIIB_IVB, "FzBIII1", classRoom14FzIIIAndIV);
        createGroup(studentsIIIListHum2, fzIIIB_IVB, fzTeacherIIIB_IVB, "FzBIII2", classRoom14FzIIIAndIV);

        createGroup(studentsIIIListHum1, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB, "AngAIII1", classRoom9IIIAndIV);
        createGroup(studentsIIIListHum2, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB, "AngAIII2", classRoom9IIIAndIV);

        createGroup(studentsIIIListReal1, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB, "AngBIII1", classRoom9IIIAndIV);
        createGroup(studentsIIIListReal2, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB, "AngBIII2", classRoom9IIIAndIV);

        // 4 gymnasium groups
        List<Student> studentsIVListReal1 = createStudentsList("StudentIV_real_", 1, 20, choosenDisciplinesIII_IV_real);
        List<Student> studentsIVListReal2 = createStudentsList("StudentIV_real_", 21, 40, choosenDisciplinesIII_IV_real);
        List<Student> studentsIVListHum1 = createStudentsList("StudentIV_hum_", 1, 20, choosenDisciplinesIII_IV_hum);
        List<Student> studentsIVListHum2 = createStudentsList("StudentIV_hum_", 21, 40, choosenDisciplinesIII_IV_hum);

        createGroup(studentsIVListHum1, ltIIIA_IVA, ltTeacherIIIA_IVA, "LtAIV1", classRoom5IIIAndIV);
        createGroup(studentsIVListHum2, ltIIIA_IVA, ltTeacherIIIA_IVA, "LtAIV2", classRoom5IIIAndIV);

        createGroup(studentsIVListReal1, ltIIIB_IVB, ltTeacherIIIB_IVB, "LtBIV1", classRoom6IIIAndIV);
        createGroup(studentsIVListReal2, ltIIIB_IVB, ltTeacherIIIB_IVB, "LtBIV2", classRoom6IIIAndIV);

        createGroup(studentsIVListReal1, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA, "MtAIV1", classRoom7IIIAndIV);
        createGroup(studentsIVListReal2, mtIIIA_IVA, mtTeacherI_II_IIIA_IVA, "MtAIV2", classRoom7IIIAndIV);

        createGroup(studentsIVListHum1, mtIIIB_IVB, mtTeacherIIIB_IVB, "MtBIV1", classRoom10IIIAndIV);
        createGroup(studentsIVListHum2, mtIIIB_IVB, mtTeacherIIIB_IVB, "MtBIV2", classRoom10IIIAndIV);

        createGroup(studentsIVListReal1, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA, "FzAIV1", classRoom14FzIIIAndIV);
        createGroup(studentsIVListReal2, fzIIIA_IVA, fzTeacherI_II_IIIA_IVA, "FzAIV2", classRoom14FzIIIAndIV);

        createGroup(studentsIVListHum1, fzIIIB_IVB, fzTeacherIIIB_IVB, "FzBIV1", classRoom14FzIIIAndIV);
        createGroup(studentsIVListHum2, fzIIIB_IVB, fzTeacherIIIB_IVB, "FzBIV2", classRoom14FzIIIAndIV);

        createGroup(studentsIVListHum1, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB, "AngAIV1", classRoom11IIIAndIV);
        createGroup(studentsIVListHum2, angIIIA_IVA, angTeacherIIIA_IVA_IIIB_IVB, "AngAIV2", classRoom11IIIAndIV);

        createGroup(studentsIVListReal1, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB, "AngBIV1", classRoom11IIIAndIV);
        createGroup(studentsIVListReal2, angIIIB_IVB, angTeacherIIIA_IVA_IIIB_IVB, "AngBIV2", classRoom11IIIAndIV);

    }

    private Discipline createDiscipline(String name, String hoursPerWeek) {
        Discipline discipline = new Discipline();
        discipline.setDisciplineName(name);
        discipline.setHoursPerWeek(hoursPerWeek);
        return discipline;
    }

    private Teacher createTeacher(String name, boolean teachesInIIIAndIV, List<Days> freeDays, Map<Days, String> freeLectures, Discipline... discipline) {
        Teacher teacher = new Teacher();
        List<Discipline> disciplines = new ArrayList<>();
        for (Discipline disp : discipline) {
            disciplines.add(disp);
        }
        teacher.setName(name);
        teacher.setTeacherDisciplines(disciplines);

        if (teachesInIIIAndIV) {
            teacher.setTeacherInIIIAndIVGymnasiumClasses(true);
            if (!teachersFromIIIAndIV.containsKey(name)) {
                teachersFromIIIAndIV.put(name, teacher);
            }

        }

        teacher.setFreeDays(freeDays);
        teacher.setFreeLectures(freeLectures);
        teacher.setTeachersGroups(new ArrayList<Group>());
//        System.out.println("Teachers from III and IV: " + teachersFromIIIAndIV.keySet());
        teachers.put(name, teacher);

        return teacher;
    }

    private Group createGroup(List<Student> studentsList, Discipline discipline, Teacher teacher, String name, ClassRoom classRoom) {
        Group group = new Group();
        group.setStudents(studentsList);
        group.setDiscipline(discipline);
        group.setTeacher(teacher);
        group.setGroupName(name);
        group.setClassRoom(classRoom);
        decideGymnasiumGroup(name, group);
        groups.put(name, group);
        int disciplineHoursPerWeek = Integer.parseInt(discipline.getHoursPerWeek());
        for (int i = 0; i < disciplineHoursPerWeek; i++) {
            teacher.getTeachersGroups().add(group);
        }
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
