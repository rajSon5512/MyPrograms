package college;
import java.util.*;

public class Student extends Person{

	private double mCPI;
	private double mFees;
	private String mName;
	public int i=0;
	public Student(String name){
		
		super(name);
		mName=name;
	}
	

	public void setmCPI(double cpi){

		mCPI=cpi;
		
	}

	public double getmCPI()
	{
		//double cpi=mCPI;
		return mCPI;
	}
		
	public void setmFees(double fees)
	{
		mFees=fees;
	}
		
	public double getFrees(){

		//double fees=mFees;
		return mFees;
	
	}

	public String toString(){
		
		return "Student Name:"+mName+"\nStudent CPI:"+mCPI+"\n\n";
		
	}
	

}

