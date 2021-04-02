public class BookRunner {

	public static void main (String[] args){
		Book artOfProgramming = new Book("Art Of Programming");
		Book cleanCode = new Book("Clean Code");
		System.out.println(artOfProgramming.toString());
		System.out.println(cleanCode.toString());

		// artOfProgramming.name = "whackflocka";
		artOfProgramming.setName("whackflocka");
		System.out.println(artOfProgramming.toString());
	}
}