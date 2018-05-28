package college;
import java.util.*;

public class Teacher extends Person{
	
	private double mSalary;
	public String mName;

	public Teacher(String name){
		super(name);
		mName=name;
	}

	
	public void setmSalary(double Salary)
	{
		mSalary=Salary;

	}

	public double getmSalary()
	{
		return mSalary;
	}

	public String toString()
	{
		return "Teacher Name:"+mName+"\nTeacher Salary:"+mSalary+"\n\n";
	}

}
