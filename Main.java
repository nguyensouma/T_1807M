package ADF2_Exam;

import ADF2_Exam.Student;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Method {
    public static ArrayList<Student> collectionOfStudent = new ArrayList<Student>();

    public void option() {
        System.out.println("\nOption 1: Add student record");
        System.out.println("Option 2: Display student record");
        System.out.println("Option 3: Save");
        System.out.println("Option 4: Exit");
        System.out.println("Enter your option: ");

        Scanner sc2 = new Scanner(System.in);
        int option = sc2.nextInt();
        switch (option) {
            case 1:
                Add();
                break;
            case 2:
                Display();
                break;
            case 3:
                Save();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("No suitable option");
                option();
                break;
        }
    }

    public void Add() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter student ID");
        String id = sc1.nextLine();
        System.out.println("Enter student name");
        String name = sc1.nextLine();
        System.out.println("Enter student address");
        String address = sc1.nextLine();
        System.out.println("Enter student phone");
        String phone = sc1.nextLine();

        Student student = new Student(id, name, address, phone);
        collectionOfStudent.add(student);
        option();
    }

    public void Display() {
        for (Student st : collectionOfStudent) {
            System.out.println("ID: " + st.studentID + " ,Name: " + st.name + " ,Address: " + st.address + " ,Phone: " + st.phone);
        }
        option();
    }

    public void Save() {
        try {
            PrintWriter out = new PrintWriter("student.txt");
            for (Student st : collectionOfStudent) {
                out.println("ID: " + st.studentID + " ,Name: " + st.name + " ,Address: " + st.address + " ,Phone: " + st.phone);
            }
            out.close();
        } catch (Exception e) {

        }
        option();
    }
}
