
public class a002StringBasics {
	public static void main(){
		String x = "a,1,asdf,2,3,4";
		String[] b = x.split(",");
		for(String ttx:b){
			System.out.println(ttx);
		}


	}
}
