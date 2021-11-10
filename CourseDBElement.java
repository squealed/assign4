public class CourseDBElement implements Comparable{
        private int coursenum, creditCount;
        private String courseId, classroomNum, teacher;
        public CourseDBElement() {
        		classroomNum = "";
        		teacher = "";
        		coursenum = 0;
        		creditCount = 0;
        		courseId = "";
        }
        public CourseDBElement(String idNum, int courseId, int creditNum, String classroomNum, String teacher) {
                this.courseId = idNum;
                this.coursenum = courseId;
                this.creditCount = creditNum;
                this.classroomNum = classroomNum;
                this.teacher = teacher;
        }
        public void setCRN(int crn) {
                this.coursenum = crn;
        }
        @Override
        public int compareTo(CourseDBElement data) {
                return (this.coursenum - data.coursenum);
        }
        public int getCRN() {
                return coursenum;
        }
        @Override
        public int hashCode() {
                String str = coursenum + "";
                return str.hashCode();
        }
        @Override
        public boolean equals(Object obj) {
                if(this == obj) {
                	return true;
                }else if(obj == null) {
                	return false;
                }else if (getClass() != obj.getClass()) {
                	return false;
                }
                CourseDBElement other = (CourseDBElement) obj;
                if (coursenum != other.coursenum) {
                        return false;
                }else {
                	return true;
                }
        }
        @Override
        public String toString() {
                return "\n" + "Course: " + courseId + " CRN: " + coursenum + " Credits: " + creditCount + " Instructor:" + teacher + " Room:" + classroomNum;
        }
        
}