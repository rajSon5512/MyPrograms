import college.*;
import java.util.*;

public class Main{

	static List<Subject> subjectList=new ArrayList<Subject>();
	static Scanner scObj=new Scanner(System.in);
	static List<Person> personList=new ArrayList<Person>();
	static List<Student> studentList=new ArrayList<Student>();
	static List<Teacher> teacherList=new ArrayList<Teacher>();
	static int selectIndex;

	public static void main(String args[]) throws Exception{
	
		

		Subject hindi=new Subject("hindi",1,2);
		Subject Gujarati=new Subject("Gujarati",2,5);
		Subject English=new Subject("English",3,4);
		Subject Chemistry=new Subject("Chemistry",4,5);
		Subject physics=new Subject("physics",5,5);

		subjectList.add(hindi);
		subjectList.add(Gujarati);
		subjectList.add(English);
		subjectList.add(Chemistry);
		subjectList.add(physics);

		
	//	Student student = new Student("Raj");

	//	Subject[] subjects = new Subject[]{hindi, Gujarati};

	//	studentInfo(student,1.8,subjects);
		
		int mChoice;
		int mExit=0;
	

		System.out.println("Welcome To Golden College Member Management System\n");

		do{

		
			System.out.println("What should You like to do.");
			System.out.println("(1)Insert StudentInfo\n(2)Insert TeacherInfo\n(3)Number of Members\n(4)Exit");
		
			System.out.print("\n\nEnter Your Choice:");
			mChoice=scObj.nextInt();

			switch(mChoice){


					case 1: System.out.print("Enter Student Name:");
							String sName=scObj.next();
							System.out.print("Enter Student CPI:");
							double sCPI=scObj.nextDouble();
							System.out.println("Subjects:(1)hindi(2)Gujarati(3)English(4)Chemistry(5)physics");
							System.out.println("Enter Number of Subject You Want To add:");
							int sNo=scObj.nextInt();
							List<Subject> sSubject=new ArrayList<Subject>();

							for(int i=0;i<sNo;i++)
							{
								System.out.print("Subject Index:");
								int sIndex=scObj.nextInt();
								//System.out.println(subjectList.get(sIndex));
								sSubject.add(subjectList.get(sIndex));
							}
							
							Student mStudent=new Student(sName);
							studentInfo(mStudent,sCPI,sSubject);
							personList.add(mStudent);
							
							mExit=Exit();
							break;

					case 2:System.out.print("Enter Teacher Name:");
							String tName=scObj.next();
							System.out.print("Enter Teacher Salary:");
							double tSalary=scObj.nextDouble();
							System.out.println("Subjects:(1)hindi(2)Gujarati(3)English(4)Chemistry(5)physics");
							System.out.println("Enter Number of Subject You Want To add:");
							sNo=scObj.nextInt();
							List<Subject> tSubject=new ArrayList<Subject>();

							for(int i=0;i<sNo;i++)
							{
								System.out.print("Subject Index:");
								int sIndex=scObj.nextInt();
								//System.out.println(subjectList.get(sIndex));
								tSubject.add(subjectList.get(sIndex));
							}
							
							Teacher tTeacher=new Teacher(tName);
							teacherInfo(tTeacher,tSalary,tSubject);
							personList.add(tTeacher);
							
							mExit=Exit();
							break;

					case 3: 
							System.out.print("which Infomation You want To See.\n\n(1)Student\n(2)Teacher\n\n");

							System.out.println("Enter Your Choice");
							 mChoice=scObj.nextInt();

							if(mChoice==1){

								System.out.println("Students List:");
								
								//infoUpdate(studentList);

							}
							else if(mChoice==2)
							{
								System.out.println("Teacher List:");
								

							}
							getListPerson(mChoice);
							infoUpdate();

							mExit=Exit();

							break;

					case 4:break;

					default:System.out.println("Please Make Correct Choice.");
							

			}
		
	

		}while(mExit==1);

	}

	public static void getList(List<Subject> x){
		
		Iterator interators=x.iterator();
		int i=0;

		while(interators.hasNext())
		{
			System.out.println("("+i+")"+interators.next());
			i++;
		}

	}

	public static void getListPerson(int choice){
		
		int i=0;
		
		while(i<personList.size())
		{
			Person person = personList.get(i);
			if(choice == 1 && person instanceof Student)
			{
				System.out.println("("+i+")"+person);
				Student tempStudentObj=(Student)personList.get(i);
				studentList.add(tempStudentObj);
				
			}
			else if(choice == 2 && person instanceof Teacher)
			{
				System.out.println("("+i+")"+person);
				Teacher tempTeacherObj=(Teacher)personList.get(i);
				teacherList.add(tempTeacherObj);
			}

			i++;
		}

	}




/*	public static Subject setListSubject(String Name,int code,int totalChapter)
	{	

		Subject subList=new Subject(Name,code,totalChapter); 
		return subList;

	}*/
	public static void studentInfo(Student studentObj,double cpi,List<Subject> subject){
	
		System.out.println("\n\n_____Student Info_____\n");
		
		studentObj.addSubject(subject);
		//Person person=new Person(name);
		System.out.println("Student Name:"+studentObj.getName());
		//System.out.println("Student Subject : "+studentObj.getAllSubject());
		studentObj.setmCPI(cpi);
		System.out.println("Student CPI :"+studentObj.getmCPI());
	//	studentObj.removeSubject(1);
		List<Subject> Lsub=studentObj.getAllSubject();
		getList(Lsub);

	//	studentObj.removeAllSubject();
		//System.out.println("Empty Subject:"+student.getAllSubject());
	
		if(studentObj.getAllSubject().isEmpty()){

			System.out.println("\n\n\tYour All Subject Are Remove from List.");
		}		


	}

	public static void teacherInfo(Teacher teacherObj,double salary,List<Subject> subjects){
		
		teacherObj.addSubject(subjects);
		//Person person=new Person(name);
		System.out.println("Teacher Name:"+teacherObj.getName());
		//System.out.println("Student Subject : "+studentObj.getAllSubject());
		teacherObj.setmSalary(salary);
		System.out.println("Teacher Salary :"+teacherObj.getmSalary());
		//	studentObj.removeSubject(1);
		List<Subject> Lsub=teacherObj.getAllSubject();
		getList(Lsub);

		//	studentObj.removeAllSubject();
		//System.out.println("Empty Subject:"+student.getAllSubject());
	
		if(teacherObj.getAllSubject().isEmpty())
		{
			System.out.println("\n\n\tYour All Subject Are Remove from List.");
		}		

		

	}


	public static int Exit(){

		int mTempChoice;
		System.out.println("Do You want to Continue press 1/Other");
		mTempChoice=scObj.nextInt();

		if(mTempChoice!=1){

				System.exit(0);
			
		}

		return mTempChoice;
	}

	public static void infoUpdate(){

		
		int r=0;
		System.out.println("Do You want To Update Infomation of Person (1/Other):");
		r=scObj.nextInt();
		
		System.out.println("Number Of Total Member = "+personList.size());

		do{
			System.out.println("Which Person:\n(1)Student\n(2)Teacher");	
			System.out.println("Choose Person: ");
			r=scObj.nextInt();

			if(r>3 && r!=0)
			{
				System.out.println("Please Choose Corrent Option");
				infoUpdate();
			}
			else
			{
				if(r==1)
				{
					System.out.println("Student List:\n\n");
					getListPerson(1);
					System.out.println("Select Student Index:");
					selectIndex=scObj.nextInt();
					
					if(selectIndex>studentList.size() && selectIndex<personList.size())
					{
						System.out.println("Please select Corrent option.");
						infoUpdate();
					}


				}
				else if(r==2)
				{
					System.out.println("Teacher List:");
					getListPerson(2);
					System.out.println("Select Teacher Index");
					selectIndex=scObj.nextInt();

					if(selectIndex>teacherList.size() && selectIndex<personList.size())
					{
						System.out.println("Please select Corrent option.");
						infoUpdate();
					}

				}
				
				
				System.out.println("(1)AddSubject\n(2)RemoveSubjectById\n(3)getAllSubject\n(4)removeAllSubject\n(5)AddSubjectList\n(6)getName\n");
				
				System.out.print("Choose Opration :");
				int tempChoice=scObj.nextInt();

				switch(tempChoice){
					
					case 1:System.out.println("Subject List:");
							getList(subjectList);
							System.out.println("Which subject Would You Like To add:");
							int tempSubject=scObj.nextInt();
							personList.get(selectIndex).addSubject(subjectList.get(tempSubject));
							r=Exit();
							break;

					case 2:System.out.println("Delete Subject By ID");
							System.out.println("Person name"+personList.get(selectIndex));
							System.out.println("person Choosed Subject:");
							getList(personList.get(selectIndex).getAllSubject());
							System.out.println("\nEnter Subject Index: ");
							int tempDeleteId=scObj.nextInt();
							personList.get(r).removeSubject(tempDeleteId);
							r=Exit();
							break;

					case 3:System.out.print("Choosed Person Subjects are:");
							getList(personList.get(selectIndex).getAllSubject());
							r=Exit();
							break;

					case 4:System.out.print("Remove All Subjects of Person.");
							personList.get(selectIndex).removeAllSubject();
							r=Exit();
							break;
					
					case 5:System.out.println("Add Subject List");
							List<Subject> tempSubjectList=MakeSubjectList();
							personList.get(selectIndex).addSubject(tempSubjectList);
							r=Exit();
							break;

					case 6:System.out.print("\nStudent Name :"+personList.get(selectIndex).getName());
							r=Exit();
							break;

					default:System.out.println("please Choose Right option");
							infoUpdate();
					
				}				


			}
			
		}while(r==1);
		
	}	

	public static List<Subject> MakeSubjectList()
	{
			List<Subject> sSubject=new ArrayList<Subject>();
			int sNo=0;

			System.out.println("All Subjects :");
			getList(subjectList);

			System.out.print("How Many Subject You want to Add :");
			sNo=scObj.nextInt();

			for(int i=0;i<sNo;i++)
			{
					System.out.print("Select Subject Index:");
					int sIndex=scObj.nextInt();
					//System.out.println(subjectList.get(sIndex));
					sSubject.add(subjectList.get(sIndex));
			}

			return sSubject;
	
	}
	
}

	

