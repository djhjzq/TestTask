# TestTask
# TestTask
Simple Spring Boot java project with the console interface for university.

Tech: java17, Spring boot 3.0.2, Spring shell, Spring data jpa, h2db.
-----------------------------------------------

Try it with query: 
--------------------------------------

 Who is head of department Computer_science

 Who is head of department Chemistry
 
 Who is head of department Sport
 
 ---------------------------------------------
 Show Computer_science statistics.
 
 Show Chemistry statistics.
 
 Show Sport statistics.
 -------------------------------------
 Show the average salary for the department Computer_science
 
 Show the average salary for the department Chemistry
 
 Show the averagy salary for the department Sport
 ---------------------------------------------------
 Show count of employee for Computer_science
 
 Show count of employee for Chemistry
 
 Show count of employee for Sport
 -----------------------------------------------------------
 Global search by an
 Global search by ez
 ------------------------------------------------------
 
 
 


Test data:

@PostConstruct
    public void init() {
        initDegree();
        initLector();
        initDepartment();
    }

    public void initDegree() {

        degreeRepository.save(new Degree(1L, DegreeEnum.professor));
        degreeRepository.save(new Degree(2L, DegreeEnum.assistant));
        degreeRepository.save(new Degree(3L, DegreeEnum.associate_professor));
    }

    public void initLector() {
        Degree professor = degreeRepository.findById(1L).get();
        Degree assistant = degreeRepository.findById(2L).get();
        Degree associate_professor = degreeRepository.findById(3L).get();

       lectorRepository.save(new Lector(1L, "Emily Adams", professor, BigDecimal.valueOf(600)));
       lectorRepository.save(new Lector(2L, "Jacob Lee", professor,  BigDecimal.valueOf(444)));
       lectorRepository.save(new Lector(3L, "Ava Patel", professor,  BigDecimal.valueOf(1254)));
       lectorRepository.save(new Lector(4L, "Ethan Kim", professor,  BigDecimal.valueOf(700)));
       lectorRepository.save(new Lector(5L, "Mia Chen", assistant,  BigDecimal.valueOf(631)));
       lectorRepository.save(new Lector(6L, "Noah Singh", assistant,  BigDecimal.valueOf(742)));
       lectorRepository.save(new Lector(7L, "Isabella Rodriguez", assistant,  BigDecimal.valueOf(833)));
       lectorRepository.save(new Lector(8L, "William Davis", associate_professor,  BigDecimal.valueOf(821)));
       lectorRepository.save(new Lector(9L, "Sophia Nguyen", associate_professor,  BigDecimal.valueOf(232)));
       lectorRepository.save(new Lector(10L, "Michael Martinez", associate_professor,  BigDecimal.valueOf(444)));
    }

    public void initDepartment() {
        ArrayList<Lector> lectors1 = new ArrayList<>();
        ArrayList<Lector> lectors2 = new ArrayList<>();
        ArrayList<Lector> lectors3 = new ArrayList<>();

        lectors1.add(lectorRepository.findById(1L).get());
        lectors1.add(lectorRepository.findById(5L).get());
        lectors1.add(lectorRepository.findById(8L).get());

        lectors2.add(lectorRepository.findById(2L).get());
        lectors2.add(lectorRepository.findById(6L).get());
        lectors2.add(lectorRepository.findById(10L).get());


        lectors3.add(lectorRepository.findById(3L).get());
        lectors3.add(lectorRepository.findById(4L).get());
        lectors3.add(lectorRepository.findById(7L).get());
        lectors3.add(lectorRepository.findById(9L).get());



        departmentRepository.save(new Department(1L, "Computer_science", lectors1, lectorRepository.findById(1L).get()));
        departmentRepository.save(new Department(2L, "Chemistry", lectors2, lectorRepository.findById(2L).get()));
        departmentRepository.save(new Department(3L, "Sport", lectors3, lectorRepository.findById(3L).get()));



    }

    
