//@code contributor: Mohammad J. Nourbakhsh
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Student implements Comparable<Student>{
	
	public static double round(double a, int b){
		a = a*(Math.pow(10, b));
		a = Math.round(a);
		a = a / 100;
		return a;
		}
	
	Scanner inp = new Scanner(System.in);
	private static final File file = new File("D:\\workspace\\Initial_File.txt");
	private String name;
	private String lastname;
	private int studentId;
	private double[] grades = new double[4] ;
	private double avg;
	private int[] CourseDivision = {4,3,3,2};
	PrintWriter outf = new PrintWriter(new File("D:\\workspace\\Final_file.txt"));
	private static double[] CourseAvg = new double[4];
	
	public Student(int i ) throws FileNotFoundException{
		Scanner inf = new Scanner(file);
		for (int j = 0; j < i; j++) {
			if (inf.hasNext()) {
				inf.nextLine();
			}
			
		}
		this.studentId = inf.nextInt();
		this.avg=0;
		this.lastname = inf.next();
		this.name = inf.next();
		for (int j = 0; j < 4; j++) {
			this.grades[j] = inf.nextDouble();
			this.avg += grades[j]*CourseDivision[j];
		}
		this.avg = avg / 12;
		inf.close();	
	}
	
	public String getName(){
		return name;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	public int getStudentID(){
		return studentId;
	}
	public double getAvg(){
		return avg;
	}
	
	public double[] getGrade(){
		return this.grades;
	}
	public int compareTo(Student compareStudent){
		return Double.compare(studentId, compareStudent.studentId);
	}
	
	public void SSort(Student[] s){
		Arrays.sort(s);
		
	}
	public void setCourseAvg(double d , int i){
				Student.CourseAvg[i] = Student.CourseAvg[i] + d;
		}
		
		
	
	public void Write(Student[] s){
		outf.printf("\t%-9s ", "StudentID");
		outf.printf("\t%-30s ", "LastName");
		outf.printf("\t%-20s ", "Name");
		outf.printf("\t%-10s ", "C1");
		outf.printf("\t%-10s ", "C2");
		outf.printf("\t%-10s ", "C3");
		outf.printf("\t%-10s ", "C4");
		outf.printf("\t%-10s ", "AVG");
		outf.println();
		outf.print("\t");
		outf.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < s.length; i++) {
			outf.printf("\t%-9s ", s[i].studentId);
			outf.printf("\t%-30s ", s[i].lastname);
			outf.printf("\t%-20s ", s[i].name);
			for (int j = 0; j < grades.length; j++) {
				outf.printf("\t%-10s ", s[i].grades[j]);
			}
			outf.printf("\t%-10s", round(s[i].avg , 2));
			outf.println();
			outf.print("\t");
			outf.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		}
		outf.printf("\t\t\t%-50s", "");
		for (int i = 0; i < 4; i++) {
			outf.printf("\t%-10s", round(CourseAvg[i]/20 , 2));
		}
		outf.flush();
		
		
	}
}
