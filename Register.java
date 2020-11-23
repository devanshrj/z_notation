import java.util.ArrayList;
import java.util.Iterator;

//implementation of Z notation of Class Register given in the research paper as an exercise using java class

public class Register 
{
    // we are using two arraylists to store students that are enrolled
    // and students that have completed their homework.
    // Name of the ith student is stored in "names" and homework completion
    // status is stored in "finished"

    private ArrayList<String> names;
    private ArrayList<String> finished;
    
    public Register()
	{
		// implentation of schema InitRegister as constructor of class
        names = new ArrayList<String>();
        finished = new ArrayList<String>();
    }
    
    String enrollStudent(String student) 
    {
        // implementation of EnrollStudent
        for (Iterator<String> iterator = names.iterator(); iterator.hasNext();)
		{
			String string = (String) iterator.next();
			if (string.equals(student))
			{
				return "Student already enrolled";
			}
		}
        this.names.add(student);
        this.finished.add("No");
		return "Student enrolled successfully";
    }

    String addCompleted(String student) 
    {
        // implementation of AddCompleted
        boolean flag_enrolled = false;
        int idx = -1;

        for (Iterator<String> iterator = names.iterator(); iterator.hasNext();)
		{
            idx++;
			String string = (String) iterator.next();
			if (string.equals(student))
			{
                flag_enrolled = true;
                break;
			}
        }
        if (!flag_enrolled) 
        {
            return "Student not enrolled.";
        }
        else 
        {
            this.finished.set(idx, "Yes");
        }
		return "Student finished homework successfully";
    }

    String enquireCompleted(String student) 
    {
        // implementation of EnquireCompleted
        boolean flag_enrolled = false;
        int idx = -1;

        for (Iterator<String> iterate_enrolled = names.iterator(); iterate_enrolled.hasNext();)
		{
            idx++;
			String string = (String) iterate_enrolled.next();
			if (string.equals(student))
			{
                flag_enrolled = true;
                break;
			}
        }
        if (!flag_enrolled) 
        {
            return "Student not enrolled.";
        }
        else 
        {
            return this.finished.get(idx);
        }
    }

    public static void main(String[] args) 
    {
        // driver method to test implementation
        Register reg = new Register();
        System.out.println(reg.enrollStudent("Devansh"));
        System.out.println(reg.enrollStudent("Manthan"));
        System.out.println(reg.enrollStudent("Devansh"));
        System.out.println(reg.addCompleted("Devansh"));
        System.out.println(reg.enquireCompleted("Devansh"));
        System.out.println(reg.enquireCompleted("Manthan"));
    }
}
