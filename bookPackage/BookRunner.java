public class BookRunner {

	public static void main (String[] args){
		Book artOfProgramming = new Book("Art Of Programming", 500);
		Book cleanCode = new Book("Clean Code", 300);
		System.out.println(artOfProgramming.toString());
		System.out.println(cleanCode.toString());

		// artOfProgramming.name = "whackflocka";
		artOfProgramming.setName("whackflocka");
		System.out.println(artOfProgramming.getName());

		artOfProgramming.setNumOfPages(9000);
		System.out.println(artOfProgramming.getNumOfPages());
		System.out.println(artOfProgramming.toString());

		// artOfProgramming.setNumOfPages(-1);
		// System.out.println(artOfProgramming.getNumOfPages());
		try{
			artOfProgramming.setNumOfPages(-1);
		} catch (RuntimeException e){
			e.printStackTrace();
		}
		System.out.println(artOfProgramming.getNumOfPages());
	}
}