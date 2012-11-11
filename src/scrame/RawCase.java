package scrame;

import java.util.Collections;
import java.util.List;

public class RawCase  {

	public void rawStudent() {
		
		List list= Student.getStudentList();
		Student[] s = new Student[40];
		s[0]=new Student("Xiao Ling","xling12@e.ntu.edu.sg",98822331,3,"U1234567A",'F',"BLK 1 #02-11 WOODLANDS CRESENT(111222)");
		s[1]= new Student("Mei Xin","mxin22@e.ntu.edu.sg",93425432,4,"U1121137B",'F',"BLK 2 #03-11 WOODLANDS CRESENT(111222)");
		s[2] = new Student("Lawrence Gong","lgong12@e.ntu.edu.sg",93333333,3,"U1233567C",'M',"BLK 3 #02-11 WOODLANDS CRESENT(111222)");
		s[3] = new Student("Mary Jones","mjones20@e.ntu.edu.sg",94444444,4,"U1234577D",'F',"BLK 4 #02-11 WOODLANDS CRESENT(111222)");
		s[4] = new Student("Poh Shiting","pst10@e.ntu.edu.sg",95555555,3,"U1235567A",'F',"BLK 5 #02-11 WOODLANDS CRESENT(111222)");
		s[5] = new Student("Loh Meiyu","lmy30@e.ntu.edu.sg",96666666,4,"U1234267Z",'F',"BLK 6 #02-11 WOODLANDS CRESENT(111222)");
		s[6] = new Student("Ahmad Bin Salmid","abs1@e.ntu.edu.sg",97777777,3,"U1132567D",'M',"BLK 7 #02-11 WOODLANDS CRESENT(111222)");
		s[7] = new Student("Peter Anderson","pande1@e.ntu.edu.sg",98888888,3,"U1234597G",'M',"BLK 8 #02-11 WOODLANDS CRESENT(111222)");
		s[8] = new Student("Shawn Michael","smic12@e.ntu.edu.sg",90000000,3,"U1233567F",'M',"BLK 9 #02-11 WOODLANDS CRESENT(111222)");
		s[9] = new Student("Tan Caibao","ctan10@e.ntu.edu.sg",90000010,4,"U1234567P",'M',"BLK 10 #02-11 WOODLANDS CRESENT(111222)");
		s[10] = new Student("Jarryd Tan","zktan1@e.ntu.edu.sg",90000011,4,"U1234367C",'M',"BLK 11 #02-11 WOODLANDS CRESENT(111222)");
		s[11] = new Student("Clement Ng","zcng2@e.ntu.edu.sg",900000012,4,"U1234567R",'M',"BLK 12 #02-11 WOODLANDS CRESENT(111222)");
		s[12] = new Student("Ngo Hungson","ngo2@e.ntu.edu.sg",900000013,3,"U1234527X",'M',"BLK 13 #02-11 WOODLANDS CRESENT(111222)");
		s[13] = new Student("David Wu","david1@e.ntu.edu.sg",900000014,3,"U1234567Y",'M',"BLK 14 #02-11 WOODLANDS CRESENT(111222)");
		s[14] = new Student("Jay Zhourong","jay20@e.ntu.edu.sg",900000015,3,"U1234567Z",'M',"BLK 15 #02-11 WOODLANDS CRESENT(111222)");
		s[15] = new Student("Wong Xinping","wong40@e.ntu.edu.sg",900000016,3,"U1234561Z",'F',"BLK 16 #02-11 WOODLANDS CRESENT(111222)");
		s[16] = new Student("Andrew Tay","andr50@e.ntu.edu.sg",900000017,3,"U1234562Z",'M',"BLK 17 #02-11 WOODLANDS CRESENT(111222)");
		s[17] = new Student("Bernard Ow","ber100@e.ntu.edu.sg",900000018,3,"U1234563Z",'M',"BLK 18 #02-11 WOODLANDS CRESENT(111222)");
		s[18] = new Student("Jone Lope","jone20@e.ntu.edu.sg",900000019,3,"U1234564Z",'M',"BLK 19 #02-11 WOODLANDS CRESENT(111222)");
		s[19] = new Student("Ali Bin Ibrahim","ali99@e.ntu.edu.sg",90000020,4,"U1234564G",'M',"BLK 20 #02-11 WOODLANDS CRESENT(111222)");
		s[20] = new Student("Nathen s/o Proche","nat100@e.ntu.edu.sg",90000021,3,"U1234563V",'M',"BLK 21 #02-11 WOODLANDS CRESENT(111222)");
		s[21] = new Student("Wong Xinling","wxl99@e.ntu.edu.sg",900000022,4,"U1233367A",'F',"BLK 22 #02-11 WOODLANDS CRESENT(111222)");
		s[22] = new Student("Zhen xiaodong","zxd30@e.ntu.edu.sg",900000023,3,"U1222567C",'F',"BLK 23 #02-11 WOODLANDS CRESENT(111222)");
		s[23] = new Student("Wu Zhongxian","wzx30@e.ntu.edu.sg",90000024,3,"U1234517L",'F',"BLK 24 #02-11 WOODLANDS CRESENT(111222)");
		s[24] = new Student("Lin XiaoKang","lxk10@e.ntu.edu.sg",90000025,4,"U1234527B",'M',"BLK 25 #02-11 WOODLANDS CRESENT(111222)");
		s[25] = new Student("Apple Tay ","apple1@e.ntu.edu.sg",90000026,3,"U1234563C",'M',"BLK 26 #02-11 WOODLANDS CRESENT(111222)");
		s[26] = new Student("Michelle low","mic22@e.ntu.edu.sg",90000027,4,"U1234569F",'F',"BLK 27 #02-11 WOODLANDS CRESENT(111222)");
		s[27] = new Student("Eric Poh","eric10@e.ntu.edu.sg",90000028,3,"U1234560L",'M',"BLK 28 #02-11 WOODLANDS CRESENT(111222)");
		s[28] = new Student("Edwin Sia","edwin20@e.ntu.edu.sg",90000029,3,"U1234563I",'M',"BLK 29 #02-11 WOODLANDS CRESENT(111222)");
		s[29] = new Student("Louis Low","louis10@e.ntu.edu.sg",90000030,4,"U1234527D",'M',"BLK 30 #02-11 WOODLANDS CRESENT(111222)");
		s[30] = new Student("John Nathen","john10@e.ntu.edu.sg",90000031,3,"U1233567M",'M',"BLK 31 #02-11 WOODLANDS CRESENT(111222)");
		s[31] = new Student("Angeline Yeo","ange20@e.ntu.edu.sg",90000032,3,"U1234567N",'F',"BLK 32 #02-11 WOODLANDS CRESENT(111222)");
		s[32] = new Student("Angela Yan","yang22@e.ntu.edu.sg",90000033,3,"U1234567O",'F',"BLK 33 #02-11 WOODLANDS CRESENT(111222)");
		s[33] = new Student("Goh Pingren","gohpr21@e.ntu.edu.sg",90000034,4,"U1234567P",'M',"BLK 34 #02-11 WOODLANDS CRESENT(111222)");
		s[34] = new Student("Mou xiaoling","mou22@e.ntu.edu.sg",90000035,3,"U1234567T",'F',"BLK 35 #02-11 WOODLANDS CRESENT(111222)");
		
		for (int i =0; i <35;i++)
			list.add(s[i]);
		
		SerializeDB.writeSerializedObject("student.dat", list);

	
	}
	
	public void rawProfessor() {
		List list= Professor.getProfessorList();
		Professor[] p = new Professor[40];
		p[0] = new Professor("Joseph Lay", "jos@ntu.edu.sg", 67909999);	
		p[1] = new Professor("Mary yeo", "myeo@ntu.edu.sg", 67901111);	
		p[2] = new Professor("Wong Ping", "wping@ntu.edu.sg", 67902222);		
		p[3] = new Professor("Colin Eng", "ceng@ntu.edu.sg", 67903333);	
		p[4] = new Professor("Swee Peng", "speng@ntu.edu.sg", 67904444);	
		p[5] = new Professor("Kelvin Jones", "kjones@ntu.edu.sg", 67905555);	
		p[6] = new Professor("Steven Pone", "spone@ntu.edu.sg", 679096666);
		for (int i =0; i <7;i++)
			list.add(p[i]);

		SerializeDB.writeSerializedObject("professor.dat", list);
	}
	
	public void rawCourse() {
		List list= Course.getCourseList();
		Course[] c = new Course[40];
		 c[0] = new Course("Object Oriented Programming", "CZ2002", 3);	
		 c[1] = new Course("Software Engineering", "CZ2006", 3);	
		 c[2] = new Course("Human Resource Management", "CZ8003", 4);		
		 c[3] = new Course("Green Computing", "CZ1002", 2);	
		 c[4] = new Course("Engineering Math", "CZ1008", 3);	
		 c[5] = new Course("Engineer and Society", "CZ0001", 4);	
		 for (int i =0; i <6;i++)
			list.add(c[i]);

		SerializeDB.writeSerializedObject("course.dat", list);
	}
		public void rawStudentCourse()
	{
		List<StudentCourse> list= StudentCourse.getRegisterList();
		StudentCourse[] sc = new StudentCourse[500];
		 sc[0] = new StudentCourse("U1234567A", "CZ0001");
		 sc[1] = new StudentCourse("U1234564Z", "CZ0001");
		 sc[2] = new StudentCourse("U1234567T", "CZ0001");	 		 
		 sc[3] = new StudentCourse("U1234517L", "CZ0001");
		 sc[4] = new StudentCourse("U1234562Z", "CZ0001");
		 sc[5] = new StudentCourse("U1234567R", "CZ0001");
		 sc[6] = new StudentCourse("U1234527X", "CZ0001");
		 sc[7] = new StudentCourse("U1234563Z", "CZ0001");
		 sc[8] = new StudentCourse("U1234527D", "CZ0001");
		 sc[9] = new StudentCourse("U1234567P", "CZ0001");
		 sc[10] = new StudentCourse("U1234563C", "CZ0001");
		 sc[11] = new StudentCourse("U1234517L", "CZ0001");
		 sc[12] = new StudentCourse("U1234267Z", "CZ0001");
		 sc[13] = new StudentCourse("U1233567C", "CZ0001");
		 sc[14] = new StudentCourse("U1234567O", "CZ0001");
		 sc[15] = new StudentCourse("U1233567M", "CZ0001");
		 sc[16] = new StudentCourse("U1234561Z", "CZ0001");
		 sc[17] = new StudentCourse("U1233367A", "CZ0001");
		 
		 sc[18] = new StudentCourse("U1234567A", "CZ1008");
		 sc[19] = new StudentCourse("U1234267Z", "CZ1008");	
		 sc[20] = new StudentCourse("U1234567T", "CZ1008");	
		 sc[21] = new StudentCourse("U1234517L", "CZ1008");
		 sc[22] = new StudentCourse("U1234562Z", "CZ1008");
		 sc[23] = new StudentCourse("U1234567R", "CZ1008");
		 sc[24] = new StudentCourse("U1234527X", "CZ1008");
		 sc[25] = new StudentCourse("U1234563Z", "CZ1008");
		 sc[26] = new StudentCourse("U1234527D", "CZ1008");
		 sc[27] = new StudentCourse("U1234567P", "CZ1008");
		 sc[28] = new StudentCourse("U1234563C", "CZ1008");
		 sc[29] = new StudentCourse("U1234517L", "CZ1008");
		 sc[30] = new StudentCourse("U1234567Y", "CZ1008");
		 sc[31] = new StudentCourse("U1233567C", "CZ1008");
		 sc[32] = new StudentCourse("U1234567O", "CZ1008");
		 sc[33] = new StudentCourse("U1233567M", "CZ1008");
		 sc[34] = new StudentCourse("U1234561Z", "CZ1008");
		 sc[35] = new StudentCourse("U1233367A", "CZ1008");
		 
		 sc[36] = new StudentCourse("U1234567A", "CZ1002");
		 sc[37] = new StudentCourse("U1234564Z", "CZ1002");
		 sc[38] = new StudentCourse("U1234567T", "CZ1002");	 		 
		 sc[39] = new StudentCourse("U1234517L", "CZ1002");
		 sc[40] = new StudentCourse("U1234562Z", "CZ1002");
		 sc[41] = new StudentCourse("U1234567R", "CZ1002");
		 sc[42] = new StudentCourse("U1234527X", "CZ1002");
		 sc[43] = new StudentCourse("U1234563Z", "CZ1002");
		 sc[44] = new StudentCourse("U1234527D", "CZ1002");
		 sc[45] = new StudentCourse("U1234567P", "CZ1002");
		 sc[46] = new StudentCourse("U1234563C", "CZ1002");
		 sc[47] = new StudentCourse("U1234517L", "CZ1002");
		 sc[48] = new StudentCourse("U1234267Z", "CZ1002");
		 sc[49] = new StudentCourse("U1233567C", "CZ1002");
		 sc[50] = new StudentCourse("U1234567O", "CZ1002");
		 sc[51] = new StudentCourse("U1233567M", "CZ1002");
		 sc[52] = new StudentCourse("U1234561Z", "CZ1002");
		 sc[53] = new StudentCourse("U1233367A", "CZ1002");
		 
		 sc[54] = new StudentCourse("U1234567A", "CZ2002");
		 sc[55] = new StudentCourse("U1121137B", "CZ2002");
		 sc[56] = new StudentCourse("U1233567C", "CZ2002");
		 sc[57] = new StudentCourse("U1234577D", "CZ2002");		 
		 sc[58] = new StudentCourse("U1235567A", "CZ2002");	
		 sc[59] = new StudentCourse("U1234267Z", "CZ2002");			 
		 sc[60] = new StudentCourse("U1132567D", "CZ2002");
		 sc[61] = new StudentCourse("U1234597G", "CZ2002");
		 sc[62] = new StudentCourse("U1233567F", "CZ2002");		 
		 sc[63] = new StudentCourse("U1234567P", "CZ2002");
		 sc[64] = new StudentCourse("U1234367C", "CZ2002");
		 sc[65] = new StudentCourse("U1234567R", "CZ2002");
		 sc[66] = new StudentCourse("U1234527X", "CZ2002");	
		 sc[67] = new StudentCourse("U1234567Y", "CZ2002");	
		 sc[68] = new StudentCourse("U1234567Z", "CZ2002");
	 
		 sc[69] = new StudentCourse("U1234567A", "CZ8003");
		 sc[70] = new StudentCourse("U1121137B", "CZ8003");
		 sc[71] = new StudentCourse("U1233567C", "CZ8003");
		 sc[72] = new StudentCourse("U1234577D", "CZ8003");		 
		 sc[73] = new StudentCourse("U1235567A", "CZ8003");	
		 sc[74] = new StudentCourse("U1234267Z", "CZ8003");			 
		 sc[75] = new StudentCourse("U1132567D", "CZ8003");
		 sc[76] = new StudentCourse("U1234597G", "CZ8003");
		 sc[77] = new StudentCourse("U1233567F", "CZ8003");		 
		 sc[78] = new StudentCourse("U1234567P", "CZ8003");
		 sc[79] = new StudentCourse("U1234367C", "CZ8003");
		 sc[80] = new StudentCourse("U1234567R", "CZ8003");
		 sc[81] = new StudentCourse("U1234527X", "CZ8003");	
		 sc[82] = new StudentCourse("U1234567Y", "CZ8003");	
		 sc[83] = new StudentCourse("U1234567Z", "CZ8003");

		 sc[84] = new StudentCourse("U1234567A", "CZ2006");
		 sc[85] = new StudentCourse("U1121137B", "CZ2006");
		 sc[86] = new StudentCourse("U1233567C", "CZ2006");
		 sc[87] = new StudentCourse("U1234577D", "CZ2006");		 
		 sc[88] = new StudentCourse("U1235567A", "CZ2006");	
		 sc[89] = new StudentCourse("U1234267Z", "CZ2006");			 
		 sc[90] = new StudentCourse("U1132567D", "CZ2006");
		 sc[91] = new StudentCourse("U1234597G", "CZ2006");
		 sc[92] = new StudentCourse("U1233567F", "CZ2006");		 
		 sc[93] = new StudentCourse("U1234567P", "CZ2006");
		 sc[94] = new StudentCourse("U1234367C", "CZ2006");
		 sc[95] = new StudentCourse("U1234567R", "CZ2006");
		 sc[96] = new StudentCourse("U1234527X", "CZ2006");	
		 sc[97] = new StudentCourse("U1234567Y", "CZ2006");	
		 sc[98] = new StudentCourse("U1234567Z", "CZ2006");
		 for (int i =0; i <99;i++)
			list.add(sc[i]);

		SerializeDB.writeSerializedObject("studentcourse.dat", list);
	
	}
	
	//	public void rawClass() {
//		List<Class> list= Class.getClassList();
//		Class[] cl = new Class[40];
//		 cl[0] = new Class("FE1", "CZ2002", 20);	
//		 cl[1] = new Class("FE2", "CZ2006", 30);	
//		 cl[2] = new Class("FE3", "CZ8003", 15);		
//		 cl[3] = new Class("FE4", "CZ1002", 30);	
//		 cl[4] = new Class("FE5", "CZ1008", 16);	
//		 cl[5] = new Class("FE6", "CZ0001", 17);	
//		 for (int i =0; i <6;i++)
//			list.add(cl[i]);
//
//		SerializeDB.writeSerializedObject("class.dat", list);
//	}
}
