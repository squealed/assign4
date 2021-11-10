import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
        private CourseDBStructure dbStructure = new CourseDBStructure(20);
        @Override
        public CourseDBElement get(int courseID) {
                try{
                	return dbStructure.get(courseID);
                }catch (IOException error) {
                	error.getMessage();
                }
                return null;
        }
        @Override
        public void add(String userID, int courseID, int userCredit, String room, String teacher) {
                CourseDBElement data = new CourseDBElement(userID, courseID, userCredit, room, teacher);
                dbStructure.add(data);
        }
        @Override
        public ArrayList<String> showAll() {
                ArrayList<String> arrList = new ArrayList<String>();
                for (int j = 0; j < dbStructure.hashTable.length; j++) {
                        LinkedList<CourseDBElement> temp = dbStructure.hashTable[j];
                        if(temp != null) {
                                for(int k = 0; k < temp.size(); k++) {
                                        CourseDBElement element = temp.get(k);
                                        arrList.add(element.toString());
                                }
                        }
                }
                return arrList;
        }
        @Override
        public void readFile(File input) throws FileNotFoundException {
                try {
                	Scanner userData = new Scanner(input);
                	while(userData.hasNext()) {
                		String courseID = userData.next();
                		int couseNumber = userData.nextInt();
                		int numCredits = userData.nextInt();
                		String roomNum = userData.next();
                		String teacher = userData.nextLine();
                		add(courseID, couseNumber, numCredits, roomNum, teacher);
                        }
                	userData.close();
                }
                catch(FileNotFoundException error) {
                        System.out.print("File not found");
                        error.getMessage();
                }
        }
        

}