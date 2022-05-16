package main;

import javax.swing.JOptionPane;

public class program {
	//Calls the Startup method
	public program() {
		startUp();
	}
	
	public int ans;
	public int totalCorrect = 0;
	public int totalQuestions;
	public boolean add = false;
	public boolean sub = false;
	public boolean div = false;
	public boolean mult = false;
	
	//Method for Addition Math Questions
	public void generateAdditionQuestion() {
		int firstNum = (int) ((Math.random()*1000)+1);
	    int secondNum = (int) ((Math.random()*1000) + 1);
	    
	    ans = firstNum + secondNum;
	    String question = firstNum + "+" + secondNum;
	    String response = JOptionPane.showInputDialog("What is the Answer of:\n" + question);
	    int numResponse = Integer.parseInt(response);
	    if(numResponse == ans) {
	    	JOptionPane.showMessageDialog(null, "Correct Answer!");
	    	totalCorrect++;
	    }else {
	    	JOptionPane.showMessageDialog(null, "Incorrect Answer!\n" +
	    			question + "\n" +
	    			"Correct Answer is: " + ans);
	    }
	}

	//Method for Subtraction Math Question
	public void generateSubtractionQuestion() {
		int firstNum = (int) ((Math.random()*1000)+1);
	    int secondNum = (int) ((Math.random()*999) + 1);
	    
	    if(firstNum < secondNum) {
	        int temp = firstNum;
	        firstNum = secondNum;
	        secondNum = temp;
	    }
	    ans = firstNum - secondNum;
	    String question = firstNum + "-" + secondNum;
	    String response = JOptionPane.showInputDialog("What is the Answer of:\n" + question);
	    int numResponse = Integer.parseInt(response);
	    if(numResponse == ans) {
	    	JOptionPane.showMessageDialog(null, "Correct Answer!");
	    	totalCorrect++;
	    }else {
	    	JOptionPane.showMessageDialog(null, "Incorrect Answer!\n" +
	    			question + "\n" +
	    			"Correct Answer is: " + ans);
	    }

	}

	//Method for Division Math Questions
	public void generateDivisionQuestion() {
	    int firstNum = (int) ((Math.random()*1000)+1);
	    int secondNum = (int) ((Math.random()*100) + 1);  //stops dividing by 0
	    
	    if(firstNum < secondNum) {
	        int temp = firstNum;
	        firstNum = secondNum;
	        secondNum = temp;
	    }
	    firstNum -= (firstNum % secondNum);
	    ans = firstNum/secondNum;
	    String question = firstNum + "/" + secondNum;
	    String response = JOptionPane.showInputDialog("What is the Answer of:\n" + question);
	    int numResponse = Integer.parseInt(response);
	    if(numResponse == ans) {
	    	JOptionPane.showMessageDialog(null, "Correct Answer!");
	    	totalCorrect++;
	    }else {
	    	JOptionPane.showMessageDialog(null, "Incorrect Answer!\n" +
	    			question + "\n" +
	    			"Correct Answer is: " + ans);
	    }
	}

	//Method for Multiplication Question
	public void generateMultiplicationQuestion() {
		int firstNum = (int) ((Math.random()*1000)+1);
	    int secondNum = (int) ((Math.random()*10) + 1);  //stops dividing by 0
	    
	    ans = firstNum * secondNum;
	    String question = firstNum + "x" + secondNum;
	    String response = JOptionPane.showInputDialog("What is the Answer of:\n" + question);
	    int numResponse = Integer.parseInt(response);
	    if(numResponse == ans) {
	    	JOptionPane.showMessageDialog(null, "Correct Answer!");
	    	totalCorrect++;
	    }else {
	    	JOptionPane.showMessageDialog(null, "Incorrect Answer!\n" +
	    			question + "\n" +
	    			"Correct Answer is: " + ans);
	    }
	}

	//----------------------------------------------------------
	//Initiates JOptionPanes
	public void startUp() {
		boolean loop = true;
		while(loop) {
			String amountQ = JOptionPane.showInputDialog("How many Questions do you wish to do?");
			try{
				totalQuestions = Integer.parseInt(amountQ);
				loop = false;
				if(totalQuestions <= 0) {
					loop = true;
					JOptionPane.showMessageDialog(null, "Amount must be more than 0");
				}
			}catch(Exception E) {
				JOptionPane.showMessageDialog(null, "Enter a Number");
			}
		}
		//Checks which Problems the user wants to do
		int doAdd = JOptionPane.showConfirmDialog(null, "Do you want to do Addition?", 
				"MathMaker", 
				JOptionPane.YES_NO_OPTION);
		if(doAdd == JOptionPane.YES_OPTION) {
			add = true;
		}
		int doSub = JOptionPane.showConfirmDialog(null, "Do you want to do Subtraction?", 
				"MathMaker", 
				JOptionPane.YES_NO_OPTION);
		if(doSub == JOptionPane.YES_OPTION) {
			sub = true;
		}
		int doDiv = JOptionPane.showConfirmDialog(null, "Do you want to do Division?", 
				"MathMaker", 
				JOptionPane.YES_NO_OPTION);
		if(doDiv == JOptionPane.YES_OPTION) {
			div = true;
		}
		int doMult = JOptionPane.showConfirmDialog(null, "Do you want to do Multiplication?", 
				"MathMaker", 
				JOptionPane.YES_NO_OPTION);
		if(doMult == JOptionPane.YES_OPTION) {
			mult = true;
		}
		
		int change = 0;
		int breakA = 0;
		for(int i = 0; i < totalQuestions; i++) {
			if(breakA == 0) {
				if(change == 0) {
					if(add) {
						generateAdditionQuestion();
						change = 1;
						breakA = 1;
					}else if(sub) {
						generateSubtractionQuestion();
						change = 1;
						breakA = 1;
					}else if(div) {
						generateDivisionQuestion();
						change = 2;
						breakA = 1;
					}else if(mult) {
						generateMultiplicationQuestion();
						change = 3;
						breakA = 1;
					}
				}
			}
			if(breakA==0) {
				if(change == 1) {
					if(sub) {
						generateSubtractionQuestion();
						change++;
						breakA++;
					}else if(div) {
						generateDivisionQuestion();
						change += 2;
						breakA++;
					}else if(mult) {
						generateMultiplicationQuestion();
						change = 0;
						breakA++;
					}
				}
			}
			if(breakA ==0) {
				if(change == 2) {
					if(div) {
						generateDivisionQuestion();
						change++;
						breakA++;
					}else if(mult) {
						generateMultiplicationQuestion();
						change = 0;
						breakA++;
					}
				}

			}	
			if(breakA == 0) {
				if(change == 3) {
					if(mult) {
						generateMultiplicationQuestion();
						change = 0;
						breakA++;
					}
				}
			}
			breakA = 0;
		}
		
		if(div==false && sub==false&& add==false&& mult==false) {
			JOptionPane.showMessageDialog(null, "You not using the program? Then get out of here");
		}else {
			int percent = (int)(((double)totalCorrect/(double)totalQuestions)*100);
			JOptionPane.showMessageDialog(null, "Good Work!\n" +
				"You have gotten " + totalCorrect + " out of " + totalQuestions + " correct.\n" +
				"You got a " + percent + "%");
		}
	}
}
