//@code contributor: Mohammad J. Nourbakhsh

import java.io.FileNotFoundException;

public class Karnames {

	public static void main(String[] args) throws FileNotFoundException {

		Student[] s = new Student[20];
		for (int i = 0; i < s.length; i++) {
			s[i] = new Student(i);
		}

		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < s.length; i++) {
				s[i].setCourseAvg(s[i].getGrade()[j], j);	
			}			
		}
		

		s[0].SSort(s);


		s[0].Write(s);

	}	
}
