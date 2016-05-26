/**
 * @class: VoteRecorder
 * @author: Sang Nguyen (shn2020@vccs.edu)
 * @Purpose: This class used to conduct the election and output the results
 * @inherits: none
 * @constructor: none		
 * @Class_methods:  getNumberOfVoter(), individualVote(), conductElection()
 * 					writeOutput(), setCandidatesPresident(String, String),
 * 					setCandidatesVicePresident(String,String),
 * 					resetVote(), getCurrentVotePresident(),
 * 					getCurrentVoteVicePresident().
 * 					
 * @Instance_methods: getAndConfirmVotes(), getAVote(), getVotes(),
 * 						confirmVotes(), recordVotes()
 */
import java.util.Scanner;

public class VoteRecorder {
	public static String nameCandidatePresident1;
	public static String nameCandidatePresident2;
	public static String nameCandidateVicePresident1;
	public static String nameCandidateVicePresident2;
	public static int votesCandidatePresident1;
	public static int votesCandidatePresident2;
	public static int votesCandidateVicePresident1;
	public static int votesCandidateVicePresident2;
	private int myVoteForPresident;
	private int myVoteForVicePresident;
	private static int numberOfVoter;
	private static Scanner input = new Scanner(System.in);
	
	public VoteRecorder() {
	}
	
	/* METHOD individualVote
	 * PURPOSE: generate an object for voters to vote
	 * PARAMETERS: none
	 * RETURN: none
	 */
	private static void individualVote() {
		VoteRecorder voteRecorder = new VoteRecorder();
		voteRecorder.getAndConfirmVotes();
	}
	
	/* METHOD conductElection
	 * PURPOSE: conduct election by prompt the user the enter the number of
	 * 			voters and let them vote
	 * PARAMETERS: none
	 * RETURN: none
	 */
	public static void conductElection() {
		System.out.print("Enter the number of voter: ");
		numberOfVoter = input.nextInt();
		System.out.println();
		for (int i = 0; i < numberOfVoter; i++) {
			System.out.println("______________________________");
			System.out.println("Person " + (i+1));
			individualVote();
		}
	}
	
	/* METHOD writeOutput
	 * PURPOSE: printout the result of the election
	 * PARAMETERS: none
	 * RETURN: none
	 */
	
	public static void writeOutput() {
		System.out.println("______________RESULTS_____________");
		System.out.println("For president candidates");
		System.out.println("Number of vote for candidate 1: " + VoteRecorder.votesCandidatePresident1 + "/" + VoteRecorder.getCurrentVotePresident());
		System.out.println("Number of vote for candidate 2: " + VoteRecorder.votesCandidatePresident2 + "/" + VoteRecorder.getCurrentVotePresident());
		if (VoteRecorder.votesCandidatePresident1 > VoteRecorder.votesCandidatePresident2) {
			System.out.println(VoteRecorder.nameCandidatePresident1 + " wins the election");
		}
		else if (VoteRecorder.votesCandidatePresident2 > VoteRecorder.votesCandidatePresident1) {
			System.out.println(VoteRecorder.nameCandidatePresident2 + " wins the election");
		}
		else System.out.println("It is a draw");
		System.out.println();
		
		System.out.println("For vice president candidates");
		System.out.println("Number of vote for candidate 1: " + VoteRecorder.votesCandidateVicePresident1 + "/" + VoteRecorder.getCurrentVoteVicePresident());
		System.out.println("Number of vote for candidate 2: " + VoteRecorder.votesCandidateVicePresident2 + "/" + VoteRecorder.getCurrentVoteVicePresident());
		if (VoteRecorder.votesCandidateVicePresident1 > VoteRecorder.votesCandidateVicePresident2) {
			System.out.println(VoteRecorder.nameCandidateVicePresident1 + " wins the election");
		}
		else if (VoteRecorder.votesCandidateVicePresident2 > VoteRecorder.votesCandidateVicePresident1) {
			System.out.println(VoteRecorder.nameCandidateVicePresident2 + " wins the election");
		}
		else System.out.println("It is a draw");
	}
	
	/* METHOD setCandidatesPresident, setCandidatesVicePresident
	 * PURPOSE: set the name of candidates president and vice president
	 * PARAMETERS: String name1, String name2
	 * RETURN: none
	 */
	
	public static void setCandidatesPresident(String name1, String name2) {
		nameCandidatePresident1 = name1;
		nameCandidatePresident2 = name2;
	}
	
	public static void setCandidatesVicePresident(String name1, String name2) {
		nameCandidateVicePresident1 = name1;
		nameCandidateVicePresident2 = name2;
	}
	
	public static void resetVotes() {
		votesCandidatePresident1 = 0;
		votesCandidatePresident2 = 0;
		votesCandidateVicePresident1 = 0;
		votesCandidateVicePresident2 = 0;
	}
	
	public static String getCurrentVotePresident() {
		return String.valueOf(votesCandidatePresident1 + votesCandidatePresident2);
	}
	
	public static String getCurrentVoteVicePresident() {
		return String.valueOf(votesCandidateVicePresident1 + votesCandidateVicePresident2);
	}
	
	/* METHOD confirmVotes
	 * PURPOSE: get and confirm vote form voters by invoking other methods
	 * PARAMETERS: none
	 * RETURN: none
	 */
	
	public void getAndConfirmVotes() {
		boolean myConfirm = true;
		do {
			myVoteForPresident = getAVote(nameCandidatePresident1,nameCandidatePresident2);
			myVoteForVicePresident = getAVote(nameCandidateVicePresident1,nameCandidateVicePresident2);
			myConfirm = confirmVotes();
			System.out.println();
		} while (!myConfirm);
		recordVotes();
	}
	
	/* METHOD getAVote
	 * PURPOSE: prompt the user to vote by enter the number corresponding
	 * 			to the candidates' name.
	 * PARAMETERS: name1, name2
	 * RETURN: none
	 */
	
	private int getAVote(String name1, String name2) {
		System.out.print("Your turn to vote" +
				"\nEnter your vote in number from 0 to 2" +
				"\n0. No choice" + 
				"\n1. You vote for " + name1 +
				"\n2. You vote for " + name2 + 
				"\nYour vote: ");
		int choice = input.nextInt();
		System.out.println();
		return choice;
	}
	
	private String getVotes() {
		return "Vote for president: " + myVoteForPresident +
				"\nVote for vice president: " + myVoteForVicePresident;
	}
	
	/* METHOD confirmVotes
	 * PURPOSE: to confirm the votes by asking the user to answer yes 
	 * 			or no whether they are happy with their vote
	 * PARAMETERS: none
	 * RETURN: none
	 */
	
	private boolean confirmVotes() {
		System.out.println(getVotes());
		System.out.print("Are you happy with your choices(Y/N)? ");
		String isHappy = input.next();
		switch (isHappy) {
		case "Y": case "y": return true;
		case "N": case "n": return false;
		}
		return true;
	}
	
	/* METHOD recordVotes
	 * PURPOSE: to record the votes
	 * PARAMETERS: none
	 * RETURN: none
	 */
	
	private void recordVotes() {
		switch (myVoteForPresident) {
		case 1: votesCandidatePresident1++; break;
		case 2: votesCandidatePresident2++; break;
		}
		
		switch(myVoteForVicePresident) {
		case 1: votesCandidateVicePresident1++;	break;
		case 2: votesCandidateVicePresident2++; break;
		}
	}
}
