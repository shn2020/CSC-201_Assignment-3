/**
 * @assignment3: Chapter 6, Programming project 10
 * @author: Sang Nguyen (shn2020@vccs.edu)
 * @course: CSC 201(041N)
 * @instructor: Sabah Salin
 * @due: 11:59PM of May 27, 2016
 * @purpose: Create a program for an president and vice president election
 * @language: Java
 */

public class VoteRecorderDemo {
	public static void main(String[] args) {
		VoteRecorder.setCandidatesPresident("Annie", "Bob");
		VoteRecorder.setCandidatesVicePresident("John", "Susan");
		VoteRecorder.resetVotes();
		VoteRecorder.conductElection();
		VoteRecorder.writeOutput();
	}	
}
