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
    private List<Student> allStudents = new ArrayList<>();

    public HashMap<String, Group> getGroups() {
        return groups;
    }

    public HashMap<String, Teacher> getTeachers() {
        return teachers;
    }

    public HashMap<String, Teacher> getTeachersFromIIIAndIV() {
        return teachersFromIIIAndIV;
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }
    
    // Creates mock data at the start of application
    @PostConstruct
    public void init() {
        Discipline mtI_II = createDiscipline("Matematika", "4");
        Discipline ltI_II = createDiscipline("Lietuviu kalba", "5");
        Discipline fzI_II = createDiscipline("Fizika", "2");
        Discipline angI_II = createDiscipline("Anglu kalba", "3");
        Discipline bioI_II = createDiscipline("Biologija", "2");
        Discipline chemI_II = createDiscipline("Chemija", "2");
        Discipline istI_II = createDiscipline("Istorija", "3");
        Discipline geoI_II = createDiscipline("Geografija", "2");

        List<Discipline> choosenDisciplinesI_II = new ArrayList<>();
        choosenDisciplinesI_II.add(mtI_II);
        choosenDisciplinesI_II.add(fzI_II);
        choosenDisciplinesI_II.add(angI_II);
        choosenDisciplinesI_II.add(ltI_II);
        choosenDisciplinesI_II.add(bioI_II);
        choosenDisciplinesI_II.add(chemI_II);
        choosenDisciplinesI_II.add(istI_II);
        choosenDisciplinesI_II.add(geoI_II);

        Teacher mtTeacherI_II_IIIA_IVA = createTeacher("TeacherI&II&IIIA&IVAMt", true, true, null, null, mtI_II);
        
        List<Days> freeDaysForLtTeach = new ArrayList<>();
        freeDaysForLtTeach.add(Days.MONDAY);
        Map<Days, String> freeHoursLtTeacher = new HashMap<>();
        freeHoursLtTeacher.put(Days.TUESDAY, "2");
        
        Teacher ltTeacherI_II = createTeacher("TeacherI&IILt", false, false, freeDaysForLtTeach, freeHoursLtTeacher, ltI_II);
        Teacher fzTeacherI_II_IIIA_IVA = createTeacher("TeacherI&II&IIIA&IVAFz", true, true, null, null, fzI_II);
        Teacher angTeacherI_II = createTeacher("TeacherI&IIAng", false, false, freeDaysForLtTeach, freeHoursLtTeacher, angI_II );
        Teacher bioTeacherI_II_IIIAB_IVAB = createTeacher("TeacherI&II&IIIAB&IVABBio", true, true, null, null, bioI_II);
        Teacher chemTeacherI_II_IIIAB_IVAB = createTeacher("TeacherI&II&IIIAB&IVABChem", true, true, null, null, chemI_II);
        Teacher istTeacherI_II_IIIAB_IVAB = createTeacher("TeacherI&II&IIIAB&IVABIst", true, true, null, null, istI_II);
        Teacher geoTeacherI_II_IIIAB_IVAB = createTeacher("TeacherI&II&IIIAB&IVABGeo", true, true, null, null, geoI_II);

        List<Student> studentsIList1 = createStudentsList("StudentI_", 1, 30, choosenDisciplinesI_II);
        List<Student> studentsIList2 = createStudentsList("StudentI_", 31, 60, choosenDisciplinesI_II);
        List<Student> studentsIList3 = createStudentsList("StudentI_", 61, 80, choosenDisciplinesI_II);
        List<Student> studentsIList4 = createStudentsList("StudentI_", 81, 101, choosenDisciplinesI_II);
        
        ClassRoom classRoom1IAndII = new ClassRoom();
        classRoom1IAndII.setRoomNumber("100");
        classRoom1IAndII.setSpecializedRoom(false);
        
        ClassRoom classRoom2IAndII = new ClassRoom();
        classRoom2IAndII.setRoomNumber("101");
        classRoom2IAndII.setSpecializedRoom(false);
        ClassRoom classRoom3IAndII = new ClassRoom();
        classRoom3IAndII.setRoomNumber("102");
        classRoom3IAndII.setSpecializedRoom(false);
        ClassRoom classRoom15IAndII = new ClassRoom();
        classRoom15IAndII.setRoomNumber("303");
        classRoom15IAndII.setSpecializedRoom(true);
        ClassRoom classRoom16IAndII = new ClassRoom();
        classRoom16IAndII.setRoomNumber("304");
        classRoom16IAndII.setSpecializedRoom(false);
        
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
        createGroup(studentsIList3, ltI_II, ltTeacherI_II, "LtI3", classRoom1IAndII);
        createGroup(studentsIList4, ltI_II, ltTeacherI_II, "LtI4", classRoom1IAndII);

        createGroup(studentsIList1, mtI_II, mtTeacherI_II_IIIA_IVA, "MtI1", classRoom2IAndII);
        createGroup(studentsIList2, mtI_II, mtTeacherI_II_IIIA_IVA, "MtI2", classRoom2IAndII);
        createGroup(studentsIList3, mtI_II, mtTeacherI_II_IIIA_IVA, "MtI3", classRoom2IAndII);
        createGroup(studentsIList3, mtI_II, mtTeacherI_II_IIIA_IVA, "MtI4", classRoom2IAndII);

        createGroup(studentsIList1, fzI_II, fzTeacherI_II_IIIA_IVA, "FzI1", classRoom12FzIAndII);
        createGroup(studentsIList2, fzI_II, fzTeacherI_II_IIIA_IVA, "FzI2", classRoom12FzIAndII);
        createGroup(studentsIList3, fzI_II, fzTeacherI_II_IIIA_IVA, "FzI3", classRoom12FzIAndII);
        createGroup(studentsIList3, fzI_II, fzTeacherI_II_IIIA_IVA, "FzI4", classRoom12FzIAndII);

        createGroup(studentsIList1, angI_II, angTeacherI_II, "AngI1", classRoom3IAndII);
        createGroup(studentsIList2, angI_II, angTeacherI_II, "AngI2", classRoom3IAndII);
        createGroup(studentsIList3, angI_II, angTeacherI_II, "AngI3", classRoom3IAndII);
        createGroup(studentsIList4, angI_II, angTeacherI_II, "AngI4", classRoom3IAndII);
        
         createGroup(studentsIList1, bioI_II, bioTeacherI_II_IIIAB_IVAB, "BioI1", classRoom15IAndII);
        createGroup(studentsIList2, bioI_II, bioTeacherI_II_IIIAB_IVAB, "BioI2", classRoom15IAndII);
        createGroup(studentsIList3, bioI_II, bioTeacherI_II_IIIAB_IVAB, "BioI3", classRoom15IAndII);
        createGroup(studentsIList4, bioI_II, bioTeacherI_II_IIIAB_IVAB, "BioI4", classRoom15IAndII);
        
         createGroup(studentsIList1, chemI_II, chemTeacherI_II_IIIAB_IVAB, "ChemI1", classRoom16IAndII);
        createGroup(studentsIList2, chemI_II, chemTeacherI_II_IIIAB_IVAB, "ChemI2", classRoom16IAndII);
        createGroup(studentsIList3, chemI_II, chemTeacherI_II_IIIAB_IVAB, "ChemI3", classRoom16IAndII);
        createGroup(studentsIList4, chemI_II, chemTeacherI_II_IIIAB_IVAB, "ChemI4", classRoom16IAndII);
        
         createGroup(studentsIList1, istI_II, istTeacherI_II_IIIAB_IVAB, "IstI1", classRoom16IAndII);
        createGroup(studentsIList2, istI_II, istTeacherI_II_IIIAB_IVAB, "IstI2", classRoom16IAndII);
        createGroup(studentsIList3, istI_II, istTeacherI_II_IIIAB_IVAB, "IstI3", classRoom16IAndII);
        createGroup(studentsIList4, istI_II, istTeacherI_II_IIIAB_IVAB, "IstI4", classRoom16IAndII);
        
         createGroup(studentsIList1, geoI_II, geoTeacherI_II_IIIAB_IVAB, "GeoI1", classRoom16IAndII);
        createGroup(studentsIList2, geoI_II, geoTeacherI_II_IIIAB_IVAB, "GeoI1", classRoom16IAndII);
        createGroup(studentsIList3, geoI_II, geoTeacherI_II_IIIAB_IVAB, "GeoI1", classRoom16IAndII);
        createGroup(studentsIList4, geoI_II, geoTeacherI_II_IIIAB_IVAB, "GeoI1", classRoom16IAndII);

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
        
        createGroup(studentsIIList1, bioI_II, bioTeacherI_II_IIIAB_IVAB, "BioII1", classRoom15IAndII);
        createGroup(studentsIIList2, bioI_II, bioTeacherI_II_IIIAB_IVAB, "BioII2", classRoom16IAndII);

        createGroup(studentsIIList1, chemI_II, chemTeacherI_II_IIIAB_IVAB, "ChemII1", classRoom15IAndII);
        createGroup(studentsIIList2, chemI_II, chemTeacherI_II_IIIAB_IVAB, "ChemII2", classRoom16IAndII);
        
        createGroup(studentsIIList1, istI_II, istTeacherI_II_IIIAB_IVAB, "IstII1", classRoom15IAndII);
        createGroup(studentsIIList2, istI_II, istTeacherI_II_IIIAB_IVAB, "IstII2", classRoom16IAndII);
        
        createGroup(studentsIIList1, geoI_II, geoTeacherI_II_IIIAB_IVAB, "GeoII1", classRoom15IAndII);
        createGroup(studentsIIList2, geoI_II, geoTeacherI_II_IIIAB_IVAB, "GeoII2", classRoom3IAndII);
        
        
        Discipline mtIIIA_IVA = createDiscipline("Matematika A", "6");
        Discipline ltIIIA_IVA = createDiscipline("Lietuviu kalba A", "6");
        Discipline fzIIIA_IVA = createDiscipline("Fizika A", "4");
        Discipline angIIIA_IVA = createDiscipline("Anglu kalba A", "5");
        Discipline mtIIIB_IVB = createDiscipline("Matematika B", "3");
        Discipline ltIIIB_IVB = createDiscipline("Lietuviu kalba B", "4");
        Discipline fzIIIB_IVB = createDiscipline("Fizika B", "2");
        Discipline angIIIB_IVB = createDiscipline("Anglu kalba B", "3");
        
        
        Discipline bioIIIB_IVB = createDiscipline("Biologija B", "2");
        Discipline bioIIIA_IVA = createDiscipline("Biologija A", "3");
        
        Discipline istIIIB_IVB = createDiscipline("Istorija B", "2");
        Discipline istIIIA_IVA = createDiscipline("Istorija A", "3");
        
        Discipline geoIIIA_IVA = createDiscipline("Geografija A", "2");
        
        Discipline chemIIIB_IVB = createDiscipline("Chemija B", "2");
        Discipline chemIIIA_IVA = createDiscipline("Chemija A", "3");
        
        List<Days> freeDaysForIIIAndIVTeacher = new ArrayList<>();
        freeDaysForIIIAndIVTeacher.add(Days.FRIDAY);
        Map<Days, String> freeHoursForIIIAndIVTeacher = new HashMap<>();
        freeHoursForIIIAndIVTeacher.put(Days.THURSDAY, "3");
        
        Map<Days, String> freeHoursForIIIAndIVTeacher2 = new HashMap<>();
        freeHoursForIIIAndIVTeacher2.put(Days.MONDAY, "3");
        
        Teacher mtTeacherIIIB_IVB = createTeacher("TeacherIIIB&IVBMt", true, false, freeDaysForIIIAndIVTeacher, null, mtIIIB_IVB);
        Teacher ltTeacherIIIA_IVA = createTeacher("TeacherIIIA&IVALt", true, false, null, freeHoursForIIIAndIVTeacher, ltIIIA_IVA);
        Teacher ltTeacherIIIB_IVB = createTeacher("TeacherIIIB&IVBLt", true, false, null, null, ltIIIB_IVB);
        Teacher fzTeacherIIIB_IVB = createTeacher("TeacherIIIB&IVBFz", true, false, null, freeHoursForIIIAndIVTeacher, fzIIIB_IVB);
        Teacher angTeacherIIIA_IVA_IIIB_IVB = createTeacher("TeacherIIIA&IVA&IIIB&IVBAng", true, false, null, freeHoursForIIIAndIVTeacher2, angIIIA_IVA, angIIIB_IVB);
        
        // 3 gymnasium groups
        List<Discipline> choosenDisciplinesIII_IV_hum = new ArrayList<>();
        List<Discipline> choosenDisciplinesIII_IV_real = new ArrayList<>();

        // Adding disciplines for III and IV
        choosenDisciplinesIII_IV_hum.add(ltIIIA_IVA);
        choosenDisciplinesIII_IV_hum.add(angIIIA_IVA);
        choosenDisciplinesIII_IV_hum.add(mtIIIB_IVB);
        choosenDisciplinesIII_IV_hum.add(fzIIIB_IVB);
        choosenDisciplinesIII_IV_hum.add(geoIIIA_IVA);
        choosenDisciplinesIII_IV_hum.add(istIIIA_IVA);
        choosenDisciplinesIII_IV_hum.add(bioIIIB_IVB);
        

        choosenDisciplinesIII_IV_real.add(ltIIIB_IVB);
        choosenDisciplinesIII_IV_real.add(angIIIB_IVB);
        choosenDisciplinesIII_IV_real.add(mtIIIA_IVA);
        choosenDisciplinesIII_IV_real.add(fzIIIA_IVA);
        choosenDisciplinesIII_IV_real.add(chemIIIA_IVA);
        choosenDisciplinesIII_IV_real.add(bioIIIA_IVA);
        choosenDisciplinesIII_IV_real.add(istIIIB_IVB);

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

        createGroup(studentsIIIListReal1, chemIIIA_IVA, chemTeacherI_II_IIIAB_IVAB, "ChemAIII1", classRoom9IIIAndIV);
        createGroup(studentsIIIListReal2, chemIIIA_IVA, chemTeacherI_II_IIIAB_IVAB, "ChemAIII2", classRoom9IIIAndIV);
        
        createGroup(studentsIIIListReal1, bioIIIA_IVA, bioTeacherI_II_IIIAB_IVAB, "BioAIII1", classRoom9IIIAndIV);
        createGroup(studentsIIIListReal2, bioIIIA_IVA, bioTeacherI_II_IIIAB_IVAB, "BioAIII2", classRoom9IIIAndIV);
        
        createGroup(studentsIIIListReal1, istIIIB_IVB, istTeacherI_II_IIIAB_IVAB, "IstBIII1", classRoom8IIIAndIV);
        createGroup(studentsIIIListReal2, istIIIB_IVB, istTeacherI_II_IIIAB_IVAB, "IstBIII2", classRoom8IIIAndIV);
        
        createGroup(studentsIIIListHum1, geoIIIA_IVA, geoTeacherI_II_IIIAB_IVAB, "GeoAIII1", classRoom9IIIAndIV);
        createGroup(studentsIIIListHum2, geoIIIA_IVA, geoTeacherI_II_IIIAB_IVAB, "GeoAIII2", classRoom8IIIAndIV);
        
        createGroup(studentsIIIListHum1, istIIIA_IVA, istTeacherI_II_IIIAB_IVAB, "IstAIII1", classRoom9IIIAndIV);
        createGroup(studentsIIIListHum2, istIIIA_IVA, istTeacherI_II_IIIAB_IVAB, "IstAIII2", classRoom8IIIAndIV);
        
        createGroup(studentsIIIListHum1, bioIIIB_IVB, bioTeacherI_II_IIIAB_IVAB, "BioBIII1", classRoom9IIIAndIV);
        createGroup(studentsIIIListHum2, bioIIIB_IVB, bioTeacherI_II_IIIAB_IVAB, "BioBIII2", classRoom10IIIAndIV);
        
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
        
        
        createGroup(studentsIIIListReal1, chemIIIA_IVA, chemTeacherI_II_IIIAB_IVAB, "ChemAIV1", classRoom11IIIAndIV);
        createGroup(studentsIIIListReal2, chemIIIA_IVA, chemTeacherI_II_IIIAB_IVAB, "ChemAIV2", classRoom11IIIAndIV);
        
        createGroup(studentsIIIListReal1, bioIIIA_IVA, bioTeacherI_II_IIIAB_IVAB, "BioAIV1", classRoom11IIIAndIV);
        createGroup(studentsIIIListReal2, bioIIIA_IVA, bioTeacherI_II_IIIAB_IVAB, "BioAIV2", classRoom11IIIAndIV);
        
        createGroup(studentsIIIListReal1, istIIIB_IVB, istTeacherI_II_IIIAB_IVAB, "IstBIV1", classRoom7IIIAndIV);
        createGroup(studentsIIIListReal2, istIIIB_IVB, istTeacherI_II_IIIAB_IVAB, "IstBIV2", classRoom7IIIAndIV);
        
        createGroup(studentsIIIListHum1, geoIIIA_IVA, geoTeacherI_II_IIIAB_IVAB, "GeoAIV1", classRoom7IIIAndIV);
        createGroup(studentsIIIListHum2, geoIIIA_IVA, geoTeacherI_II_IIIAB_IVAB, "GeoAIV2", classRoom7IIIAndIV);
        
        createGroup(studentsIIIListHum1, istIIIA_IVA, istTeacherI_II_IIIAB_IVAB, "IstAIII1", classRoom8IIIAndIV);
        createGroup(studentsIIIListHum2, istIIIA_IVA, istTeacherI_II_IIIAB_IVAB, "IstAIII2", classRoom8IIIAndIV);
        
        createGroup(studentsIIIListHum1, bioIIIB_IVB, bioTeacherI_II_IIIAB_IVAB, "BioBIV1", classRoom8IIIAndIV);
        createGroup(studentsIIIListHum2, bioIIIB_IVB, bioTeacherI_II_IIIAB_IVAB, "BioBIV2", classRoom8IIIAndIV);

    }

    private Discipline createDiscipline(String name, String hoursPerWeek) {
        Discipline discipline = new Discipline();
        discipline.setDisciplineName(name);
        discipline.setHoursPerWeek(hoursPerWeek);
        return discipline;
    }

    private Teacher createTeacher(String name, boolean teachesInIIIAndIV, boolean teacherInAllClasses, List<Days> freeDays, Map<Days, String> freeLectures, Discipline... discipline) {
        Teacher teacher = new Teacher();
        List<Discipline> disciplines = new ArrayList<>();
        for (Discipline disp : discipline) {
            disciplines.add(disp);
        }
        teacher.setName(name);
        teacher.setTeacherDisciplines(disciplines);
        teacher.setTeacherInAllClasses(teacherInAllClasses);

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
            allStudents.add(student);

        }
        
        return studentsList;
    }

    @PreDestroy
    public void destroy() {
    }

}
