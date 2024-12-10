package extra.assign;

import java.io.*;
import java.util.*;

public class Main {
    protected static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = -1;

        while(choice != 0){
            System.out.println("Choose an option from 1-6\n1. Enter course list to file.\n2. Show course list from file.\n3. Edit course from file by id.\n4. Delete course from file.\n5. Find course by major.\n6. Sort course by id.\n0. Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    new Main().inputCourseToFile();
                    break;
                case 2:
                    new Main().showCourseList();
                    break;
                case 3:
                    new Main().editCourseById();
                    break;
                case 4:
                    Course course = new Main().removeCourseById();
                    System.out.println(course);
                    break;
                case 5:
                    List<Course> courseListByMajor = new Main().findCourseByMajor();
                    System.out.println(courseListByMajor);
                    break;
                case 6:
                    List<Course>  sortedCourseList = new Main().sortCourseById();
                    System.out.println(sortedCourseList);
                    break;
                default:
                    break;
            }
        }
    }
    
    private void writeCourseListToFile(List<Course> courseList){
        try {
            String path = System.getProperty("user.dir") + "/src/extra/assign/course.bin";
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(courseList);
            oos.close();
            fos.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private List<Course> readCourseListFromFile(){
        try{
            String path = System.getProperty("user.dir") + "/src/extra/assign/course.bin";
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Course> courseList = (List<Course>) ois.readObject();
            fis.close();
            ois.close();
            return courseList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void inputCourseToFile(){
        System.out.println("Enter number of courses to input to file: ");
        int size = sc.nextInt();
        sc.nextLine();

        List<Course> list = new ArrayList<Course>();

        for (int i = 0; i < size; i++){
            String[] courses = {};
            while (courses.length != 4) {
                System.out.println("Enter id, name, major and description of course (id,name,major,description): ");
                String input = sc.nextLine();
                courses = input.split(",");
            }
            list.add(new Course(Integer.parseInt(courses[0]), courses[1], courses[2], courses[3]));
            System.out.println("Input success");
        }
        
        writeCourseListToFile(list);
    }
    
    public void showCourseList(){
        List<Course> list = readCourseListFromFile();
        if (list != null){
            for(Course course : list){
                System.out.println(course);
            }
        }
    }
    
    public void editCourseById(){
        List<Course> list = readCourseListFromFile();
        if (list == null){
            System.out.println("No course in file");
            return;
        }
        
        System.out.println("Enter course id: ");
        int id = sc.nextInt();
        sc.nextLine();
        for(Course course : list){
            if (id == course.getId()){
                int index = list.indexOf(course);
                editCourseInListByIndex(index, inputCourseInfo().split(","), list);
                writeCourseListToFile(list);
                return;
            }
        }
    }

    private String inputCourseInfo(){
        StringBuilder builder = new StringBuilder();
        System.out.println("Enter new course name (Enter to skip): ");
        builder.append(sc.nextLine());
        builder.append(",");
        System.out.println("Enter new course major (Enter to skip): ");
        builder.append(sc.nextLine());
        builder.append(",");
        System.out.println("Enter new course description (Enter to skip): ");
        builder.append(sc.nextLine());
        builder.append(",");
        return builder.toString();
    }
    
    private void editCourseInListByIndex(int index, String[] information, List<Course> courseList){
        String name = information[0];
        String major = information[1];
        String description = information[2];

        if (!name.isEmpty()){
            courseList.get(index).setName(name);
        }
        if (!major.isEmpty()){
            courseList.get(index).setMajor(major);
        }
        if (!description.isEmpty()){
            courseList.get(index).setDescription(description);
        }
    }

    public Course removeCourseById(){
        List<Course> list = readCourseListFromFile();
        if (list == null){
            System.out.println("No course in file");
            return null;
        }

        System.out.println("Enter course id: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Course course : list){
            if (id == course.getId()){
                list.remove(course);
                return course;
            }
        }
        System.out.println("Id not found");
        return null;
    }

    public List<Course> findCourseByMajor(){
        List<Course> list = readCourseListFromFile();
        if (list == null){
            System.out.println("No course in file");
            return null;
        }

        List<Course> matchMajor = new ArrayList<>();
        System.out.println("Enter major");
        String major = sc.nextLine();
        for (Course course : list){
            if (major.equals(course.getMajor())){
                matchMajor.add(course);
            }
        }
        return matchMajor;
    }

    public List<Course> sortCourseById(){
        List<Course> list = readCourseListFromFile();
        if (list == null){
            System.out.println("No course in file");
            return null;
        }

        Collections.sort(list, new CourseComparator());
        return list;
    }
}
