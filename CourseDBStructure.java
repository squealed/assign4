import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {
        protected int listSize;
        protected LinkedList<CourseDBElement> hashTable[];
        @SuppressWarnings("unchecked")
        public CourseDBStructure(String testing, int size) {
                this.listSize = size;
                hashTable = new LinkedList[size];
        }
        @SuppressWarnings("unchecked")
        public CourseDBStructure(int dataSize) {
                this.listSize = dataSize;
                hashTable = new LinkedList[dataSize];
        }
        @Override
        public CourseDBElement get(int courseID) throws IOException {
                String holder = courseID + "";
                int index = holder.hashCode() % listSize;
                if(hashTable[index] == null) {
                        throw new IOException();
                }
                else {
                        for(int j = 0; j < listSize; j++) {
                                CourseDBElement temp = hashTable[index].get(j);
                                if(temp.getCRN() == courseID) {
                                        return temp;
                                }
                        }
                        return null;
                }
        }
        @Override
        public void add(CourseDBElement data) {
                int location = data.hashCode() % listSize;
                if(hashTable[location] == null) {
                        hashTable[location] = new LinkedList<CourseDBElement>();
                }
                hashTable[location].add(data);
        }
        @Override
        public int getTableSize() {
                return listSize;
        }

}