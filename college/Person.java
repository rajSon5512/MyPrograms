package college;
import java.util.*;

 abstract public class Person{

	private String mName;
	private List<Subject> mSubject;

	public Person(String name){
		mSubject=new ArrayList<Subject>();
		mName=name;
		}

	 public void addSubject(Subject mSub){
		 mSubject.add(mSub);
	 }
	
	 public void removeSubject(int subjectId)
	 {
		 mSubject.remove(subjectId);
	 }
	 public void removeSubject(Subject SubObj)
	 {
		mSubject.remove(SubObj);
	 }
	
	 public List<Subject> getAllSubject()
	 {
		 return mSubject;
	 }

	 public void removeAllSubject()
	 {
		 mSubject.clear();
	 }
	 public void addSubject(List<Subject> subList)
	 {
		 mSubject.addAll(subList);
	 }
	 public String getName()
	 {
		 return mName;
	 }
}

