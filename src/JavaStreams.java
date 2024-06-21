import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class JavaStreams {

	
	
	public static void main(String[] args)
	{
		
		// ===============================  Count Streams by list =====================

		List<String>names=Arrays.asList("Amar","Deepak","Aman","Balram","Abhimanyu","Amardeep");
		long count =names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(count);

		Long count1 =Stream.of("Amar","Deepak","Aman","Balram","Abhimanyu","Amardeep").filter(s->s.startsWith("B")).count();
		System.out.println(count1);

		// =============================== length ,Limit and For Each  STREAM ========================

		
//		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
//		names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
		
		 // ================================   MAP Stream  =================================
		
//		names.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		List<String>names1=Arrays.asList("Akash","Jeevan","Anupam","Balram","Akshay","Anirudh");

		names1.stream().filter(s->s.startsWith("A")).sorted().forEach(s->System.out.println(s));
		
		
		//=============================== Merge Array List by Stream ===============
		Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
		//newStream.sorted().forEach(s->System.out.println());
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Jeevan"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		// ============================ Collectors Stream ==========================
		List<String> LS = Stream.of("Amar","Deepaka","Aman","Balrama","Abhimanyu","Amardeep").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		
		System.out.println(LS.get(0));
		
		// ============================ Distinct Steam =============================
		
		// Filter Unique Number
		
		List<Integer>values=Arrays.asList(1,5,8,6,2,4,4,2,6,9);
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> Li =	values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(Li.get(4));

		
	}
}
