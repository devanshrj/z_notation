import java.util.HashMap;
import java.util.Map;

public class DatabaseExample {
	
	// because a database is a function from address to page, the map data structure has been used
	// both data types are kept as string for brevity and clarity, these may be replaced by user defined classes for address and pages  
	
	
	private Map<String, String> master;
	private Map<String, String> changes;
	
	
	DatabaseExample () {
		// Initialize the two databases
		master = new HashMap<String, String>();
		changes = new HashMap<String, String>();
	}
	String[] access(String address) {
		
		///implementation of helper function getChange and ReadMaster is more succinctly expressed by the if and else conditions
		// if condition is equivalent to getChange, ReadMaster equivalent to the else if block
		// second index of array is the report, and first is the page found, if any.
		
		if(changes.containsKey(address)) {
			return new String[] {changes.get(address), "Ok"};
		}
		else if (master.containsKey(address)) {
			return new String[] {master.get(address), "Found in master"};
		}
		else return new String[] {null, "Not present"};
	}
	
	
	void update(String address, String page) {
		//master remains as it is, no change
		changes.put(address, page);
		System.out.println("Entry added to changes");
	}
	
	void checkpoint() {
		//changes added to master
		//changes cleared
		master.putAll(changes);
		changes.clear();
		System.out.println("Checkpoint! Saved to master");
	}
	
	void restart() {
		// clear latest changes
		changes.clear();
		System.out.println("Recent changes cleared");
	}
	
	
	
	public static void main(String[] args) {
		
		DatabaseExample tester = new DatabaseExample();
		
		tester.update("a", "webd");
		tester.update("b", "ml");
		tester.update("c", "sde");
		System.out.println(tester.access("a")[0]+", "+tester.access("a")[1]);
		System.out.println(tester.access("c")[0]+", "+tester.access("c")[1]);
		tester.checkpoint();
		tester.update("d", "msi");		
		System.out.println(tester.access("b")[0]+", "+tester.access("b")[1]);
		tester.restart();
		System.out.println(tester.access("d")[0]+", "+tester.access("d")[1]);
	}

}
