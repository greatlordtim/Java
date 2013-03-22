public  class Test{
	public static void main(String []args){
		String phrase = "My name is Anindit";
		int x = 0;
		int spaces = 0;
		int a = 0;
		boolean b = true;
		
		phrase = remove(phrase, "it");
		System.out.println(phrase);
	}
	public static String remove(String s, String f){
		String d = "";
		System.out.println(f.length());
		if (s.endsWith(f)){
			for (int i = 0; i < (s.length() - f.length()); i++){
				d += s.charAt(i);
				System.out.println(d);
			}
		}	
		
		return d;
	}
}
