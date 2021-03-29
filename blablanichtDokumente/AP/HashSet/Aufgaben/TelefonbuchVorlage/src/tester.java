



public class tester{
	
	  public static void main(String[] args) {
		  Telefonbuch tb = new Telefonbuch();
		  Telefonbucheintrag tb1 = new Telefonbucheintrag("A", "F", "ABC");
		  Telefonbucheintrag tb2 = new Telefonbucheintrag("A", "C", "A");
		  Telefonbucheintrag tb3 = new Telefonbucheintrag("A", "I", "A");
		  Telefonbucheintrag tb4 = new Telefonbucheintrag("A", "A", "ACB");
		  Telefonbucheintrag tb5 = new Telefonbucheintrag("A", "E", "A");
		  Telefonbucheintrag tb6 = new Telefonbucheintrag("A", "G", "A");
		  Telefonbucheintrag tb7 = new Telefonbucheintrag("A", "L", "A");
		  tb.addEintrag(tb1);
		  tb.addEintrag(tb2);
		  tb.addEintrag(tb3);
		  tb.addEintrag(tb4);
		  tb.addEintrag(tb5);
		  tb.addEintrag(tb6);
		  tb.addEintrag(tb7);
		 
		  System.out.println(tb.toString());
		  System.out.println(tb.update(tb5,"ABCAIKFISDFLASDINLASDHL"));
		  System.out.println(tb.update(tb1,"ydfgdfgsadfgsdfg"));
		  System.out.println(tb.update(tb2,"fdgafgsadfgsdfh"));
		  System.out.println(tb.update(tb3,"sfgnfgjnghsgfgareg"));
		  System.out.println(tb.update(tb4,"SFGHSGHSGHSGSJKZFRUKLZU"));
		  System.out.println(tb.update(tb6,"STRZSRTZTZJRZHJM"));
		  System.out.println(tb.update(tb7,"DFJHSFTGJHSRTJSJDGJSGJGF"));
		  System.out.println(tb.toString());
	  }
}




/*

*/