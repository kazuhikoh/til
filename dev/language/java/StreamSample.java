import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamSample{

	public static void main(String[] args){
		List<Person> persons = Arrays.asList(new Person[]{
			new Person("nico", 3),
			new Person("rin",  1),
			new Person("pana", 1),
		});
		
		printPersonGroup(persons);
		// <OUTPUT>
		// 1: [rin, pana]
		// 3: [nico]
	}
	
	public static void printPersonGroup(List<Person> persons){
		Map<Integer, List<Person>> groups =
			persons.stream().collect(Collectors.groupingBy(p -> p.getGrade()));
			
		groups.forEach((key,value) -> {
			System.out.println(
				key + ": " + 
				value.stream().map(v -> v.getName()).collect(Collectors.toList())
			);
		});
	}

}

class Person{
	private String  name;
	private Integer grade;
	
	public Person(String name, Integer grade){
		this.name  = name;
		this.grade = grade;
	}
	
	public String getName(){ return name; }
	public Integer getGrade(){ return grade; }
}
