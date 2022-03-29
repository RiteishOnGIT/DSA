package additional;

class Employee{
	
	Integer id;
	String name;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return id+" "+name;
	}
	
	@Override
	public int hashCode() {
		return (id == null && name == null)?0:(id == null)?
				name.hashCode():(name==null)?id.hashCode():id.hashCode()+name.hashCode();
	}
	
}




public class HashCodeDemo {
	
	
	public static void main(String[] args) {
		
		Employee employee = new Employee(1, "Ritesh");
		Employee employee2 = new Employee(1, "Ritesh");
		Employee employee3 = new Employee();
		Employee employee4 = new Employee(2, "Ritesh");
		Employee employee5 = new Employee(4, null);
		Employee employee6 = new Employee(5, "Ritesh");
		
		System.out.println(employee.hashCode()+" "+employee2.hashCode()+
				" "+employee3.hashCode()+" "+employee4.hashCode()+" "+employee5.hashCode()
				+" "+employee6.hashCode());
		
	}
	
}
