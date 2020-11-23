import java.util.ArrayList;
import java.util.Iterator;

//implementation of Z notation of BirthdayBook given in the research paper using java class

public class BirthdayBook
{
	// we are using two arraylists to store names and birthdays of people. the name
	// of the ith person is stored at the ith index of the arraylist
	// "names" and their corresponding birthday is stored at the ith position of the
	// arraylist "birdhdays"
	
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> birthday = new ArrayList<String>();
	private int hwm; // this is used to store the length of the current birthday list

	public BirthdayBook()
	{
		// implentation of schema InitBirthdayBook as constructor of class
		hwm = 0;
	}

	String addBirthday(String name, String date)
	{
		// implementation of schema named AddBirthday1
		for (Iterator<String> iterator = names.iterator(); iterator.hasNext();)
		{
			String string = (String) iterator.next();
			if (string.equals(name))
			{
				return "Birthday already known";
			}

		}
		this.names.add(name);
		this.birthday.add(date);
		hwm++;
		return "Birthday added successfully";
	}

	ArrayList<String> Remind(String date)
	{
		// implementation of schema names Remind1
		ArrayList<String> reminder = new ArrayList<String>();
		for (int i = 0; i < hwm; i++)
		{
			if (birthday.get(i).equals(date))
				reminder.add(names.get(i));
		}
		return reminder;
	}

	String findBirthday(String name)
	{
		// implementation of schema names FindBirthday1
		for (int i = 0; i < hwm; i++)
		{
			if (names.get(i).equals(name))
				return name + "'s Birthday is " + birthday.get(i);
		}

		return "Birthday not found in Birthday Book";
	}

	public static void main(String[] args)
	{
		// driver method to test our implementation
		BirthdayBook bb = new BirthdayBook();
		System.out.println(bb.addBirthday("Aman", "24-06-2000"));
		System.out.println(bb.addBirthday("Sabhya", "24-06-2000"));
		System.out.println(bb.Remind("24-06-2000"));
		System.out.println(bb.findBirthday("Aman"));

	}

}
