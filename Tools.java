
public  final class Tools {
	public static String secondsToTime(int seconds){
		String output = "";
		if((seconds/3600)>0){
			output+= seconds/3600 + " hours ";
		}
		if(((seconds%3600)/60)>0){
			output+= ((seconds%3600)/60) + " minutes ";
		}
		if(((seconds%60))>0)
			output+= ((seconds%60)) + " seconds ";
		
		return output;
	}
}
