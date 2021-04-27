import java.util.*;

class Solution{
		
	public static String findEduProgramClassification(EduProgram[] edu) {
		for(int i=0;i<edu.length;i++) {
			if(edu[i].stillAvailable&&edu[i].withinCountry) {
				if(edu[i].noOfPeopleAttended>=1000)
					return "Evergreen";
				else if(edu[i].noOfPeopleAttended>=500&&edu[i].noOfPeopleAttended<1000)
					return "Golden";
				else if(edu[i].noOfPeopleAttended<500)
					return "Emerging Star";
			}
		}
		return null;
	}
	
	public static EduProgram[] findEduProgramBySponsor(EduProgram[] edu, String NOP) {
		ArrayList<EduProgram> al = new ArrayList<EduProgram>();
		for(int i=0;i<edu.length;i++) {
			for(int j=0;j<edu.length-1;j++) {
				if(edu[j].noOfPeopleAttended>edu[j+1].noOfPeopleAttended) {
					EduProgram temp = edu[j];
					edu[j] = edu[j+1];
					edu[j+1] = temp;;
				}
			}
		}
		int j=0;
		for(int i=0;i<edu.length;i++) {
			if(edu[i].sponsor.equalsIgnoreCase(NOP))
				al.add(edu[i]);
		}
		if(al.size()==0)
			return null;
		return al.toArray(new EduProgram[al.size()]);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		EduProgram[] edu = new EduProgram[4];
		for(int i=0;i<edu.length;i++) {
			EduProgram ep = new EduProgram();
			ep.eduProgramName = sc.nextLine();
			ep.sponsor = sc.nextLine();
			ep.noOfPeopleAttended = sc.nextInt();
			ep.stillAvailable = sc.nextBoolean();
			ep.withinCountry = sc.nextBoolean();
			sc.nextLine();
			edu[i] = ep;
		}
		String NOP = sc.nextLine();
		sc.close();
		String ans1 = findEduProgramClassification(edu);
		if(ans1!=null)
			System.out.println(ans1);
		else
			System.out.println("EduPrograms are not available now");
		
		EduProgram[] ans2 = findEduProgramBySponsor(edu, NOP);
		if(ans2!=null) {
			int i=0;
			while(i<ans2.length) {
				System.out.println(ans2[i].eduProgramName+"\n"+ans2[i].noOfPeopleAttended);
				i++;
			}
		}
		else
			System.out.println("No EduProgram is available for sponsor");
	}
}
class EduProgram{
	public String eduProgramName;
	public String sponsor;
	public int noOfPeopleAttended;
	public boolean stillAvailable;
	public boolean withinCountry;
	
	public EduProgram() {
		eduProgramName = "";
		sponsor = "";
		noOfPeopleAttended = 0;
		stillAvailable = false;
		withinCountry = false;
	}
}