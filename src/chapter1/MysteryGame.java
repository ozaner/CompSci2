package programs;
//Needs 8 rooms, a math puzzle with a floating point operator and comparison, AND 3 examples of logical operators
public class MysteryGame extends CommonMethods
{
	String name;
	MGameTimer deathEvent = new MGameTimer();	//For 5 minute timer that kills player.
	MGameTimer quickEvent = new MGameTimer();	//For Dining Room dodge fork event 2
	MGameTimer quickEvent2 = new MGameTimer();	//For Dining Room dodge fork event 2
	MGameTimer quickEvent3 = new MGameTimer();	//For attic dodge event
	char unImportantChar;	//Place Holder for decisions
	boolean firstKey = false, secondKey = false, unlockHallway = false, 
			dodgedLog = false, obtainedFork = false, lockPick = false;
	float userInputFloat, floatAnswer = (float)22 / (float)7;	//Math puzzle variables
	int numerator, denomenator;		//Math puzzle variables
	
	
	public void startingBlurb()
	{
		System.out.println("What's your name");
		name = scan.nextLine();
		System.out.println("Welcome, " + name + ", to the Spooooooky Mansion!!!\nYou must unlock the front "
				+ "door to escape the mansion.\nIf you don't escape in 5 minutes, YOU DIE!");
	}
	
	public void foyer()		//Foyer Room (1)A
	{
		if (firstKey || secondKey)
		{
			if (firstKey && secondKey)
			{
				System.out.println("You did it. You got both halves of the key. Unlock the door? Y/N");
				unImportantChar = scan.nextLine().toUpperCase().charAt(0);
				switch(unImportantChar)
				{
					case 'Y':
						System.out.println("You have escaped you win!");
						System.exit(0);
						break;
					default:
						System.out.println("You decide that refusing to win is a stupid idea and leave the mansion anyway");
						System.out.println("You Win!");
						System.exit(0);
						break;
				}
			}
			System.out.println("You got one half of the key. Just one more to go!");
		}
		System.out.println("\n\nYou enter the Foyer");
		if (!lockPick)
		{
			System.out.println("You see a lock-pick on the ground. Pick it up? Y/N");
			unImportantChar = scan.nextLine().toUpperCase().charAt(0);
			switch(unImportantChar)
			{
			case 'Y':
				System.out.println("You picked up a rusty lock-pick.");
				lockPick = true;
				break;
			default:
				System.out.println("You decided to ignore the lock-pick.");
				break;
			}
		}
		if(lockPick)
		{
			System.out.println("Would you like to use the lock-pick to open the front door? Y/N");
			unImportantChar =  scan.nextLine().toUpperCase().charAt(0);
			switch(unImportantChar)
			{
				case 'Y':
					System.out.println("The rusty lock-pick shatters in your hands as you try to pick the lock");
					System.out.println("The lock is jammed and you are trapped inside.");
					System.out.println("YOU LOSE!!!");
					System.exit(0);
				default:
					System.out.println("You decided it would be better if you didn't try to pick the lock open.");
			}	
		}
		System.out.println("Would you like to go into the kitchen(K), the dungeon(D), or the dining room(R)? K/D/R");
		unImportantChar = scan.nextLine().toUpperCase().charAt(0);
		switch(unImportantChar)
		{
			case 'D':
				dungeon();
				break;
			case 'K':
				kitchen();
				break;
			case 'R':
				dining();
				break;
			default:
				System.out.println("That wasn't an option. You walk out of the Foyer and walk back in.");
				foyer();
				break;
		}
	}
	
	public void dungeon()	//runs the dungeon room (2) Path A1
	{
		System.out.println("You walk downstairs into the dungeon.");
		
		if (!unlockHallway) //skips over hallway unlock if you already did it
		{
			System.out.println("You see a totally inconspicuous bookshelf by the wall");
			System.out.println("Investigate it? Y/N");
			unImportantChar = scan.nextLine().toUpperCase().charAt(0);
			switch(unImportantChar) //Unlocks Hallway
			{
				case 'Y':
					System.out.println("You found a secret switch.");
					System.out.println("You flick the switch revealing a passageway to a long hallway.");
					unlockHallway = true;
					break;
				default:
					System.out.println("You decide not to investigate.");
					break;
			}
		}
		if (unlockHallway) //Asks if you want to enter Hallway
		{
			System.out.println("Would you like to go into the secret hallway? Y/N");
			unImportantChar = scan.nextLine().toUpperCase().charAt(0);
			switch(unImportantChar)
			{
			case 'Y':
				hallway();
				break;
			default:
				break;
			}
		}
		System.out.println("There is nothing else left to do here. You decide to go back into the foyer.");
		foyer();
	}
	
	public void kitchen()	//runs the kitchen room (3) Path A2
	{
		System.out.println("You walk into the kitchen.");
		if(!firstKey)
		{	
			System.out.println("You hear a microwave beeping. Open the microwave? Y/N");
			unImportantChar = scan.nextLine().toUpperCase().charAt(0);
			switch(unImportantChar)
			{
				case 'Y':
					System.out.println("You open the microwave and find.. THE FIRST HALF OF THE KEY!!!");
					firstKey = true;
					break;
				default:
					System.out.println("You decide to ignore the microwave, sucks for you, there were hot pockets");
					break;
			}
		}
		else
		{
			System.out.println("There is nothing of interest here.");
		}
		System.out.println("Go into the Foyer or the Kitchen Closet. F/C");
		unImportantChar = scan.nextLine().toUpperCase().charAt(0);
		switch(unImportantChar)
		{
			case 'F':
				foyer();
				break;
			case 'C':
				closet();
				break;
			default:
				System.out.println("That  wasn't an option so you walk back into the foyer.");
				foyer();
		}
	}
		
	public void dining()	//runs the dining Room (4) Path A3
	{
		System.out.println("You enter the dining room.");
		if(!obtainedFork)
		{
			System.out.println("You see a single fork lying on the dining table. Pick it up? Y/N");
			unImportantChar = scan.nextLine().toUpperCase().charAt(0);
			switch (unImportantChar)
			{
				case 'Y':	//kills you
					System.out.println("As you approach the fork, it rises into the air and rushes towards you.");
					System.out.println("ENTER D TO DODGE!");
					timer2.schedule(quickEvent2, 2000);
					unImportantChar = scan.nextLine().toUpperCase().charAt(0);
					switch(unImportantChar)
					{
						case 'D':
							System.out.println("You dodged the fork");
							timer2.cancel();
							System.out.println("\nBUT IT TURNS AROUND AND AIMS FOR YOU AGAIN!");
							System.out.println("ENTER D TO DODGE");
							timer3.schedule(quickEvent3, 2000);
							unImportantChar = scan.nextLine().toUpperCase().charAt(0);
							switch(unImportantChar)
							{
								case 'D':
									timer3.cancel();
									System.out.println("You dodge the fork again and it falls into your pocket.");
									obtainedFork = true;
									break;
								default:
									System.out.println("You got hit and, of course, DIED! YOU LOSE!");
									System.exit(0);
									break;
							}
							break;
						default:
							System.out.println("You missed and, of course, DIED! YOU LOSE!");
							System.exit(0);
							break;
					}
					break;
				default:
					System.out.println("You decide to ignore the fork and move on.");
					break;
			}
		}
		System.out.println("\nYou see a large door with a warning sign that reads:");
		System.out.println("AUTHORIZED PERSONNEL ONLY!!! DO NOT ENTER!!!");
		System.out.println("Would you like to enter anyway? Y/N");
		unImportantChar = scan.nextLine().toUpperCase().charAt(0);
		switch (unImportantChar)
		{
			case 'Y':
				System.out.println("You rebel..");
				clockwork();
				break;
			default:
				System.out.println("Good idea. You decide NOT to enter the room and go back to the foyer.");
				foyer();
		}
	}
	
	public void clockwork()	//Runs the clockworks room (5) Path A3-1
	{
		System.out.println("You enter a strange room filled with clocks.");
		System.out.println("There is a large timer in the middle of the room that is counting down from 5 minutes.");
		System.out.println("Disable it? Y/N");
		unImportantChar = scan.nextLine().toUpperCase().charAt(0);
		switch(unImportantChar)
		{
			case 'Y':
				System.out.println("You disable the timer.");
				timer.cancel();
				break;
			default:
				System.out.println("You decide it would be better not to tamper with it.");
				break;
		}
		System.out.println("There is nothing left to do. You go back to the dining room.");
		dining();
	}

	public void closet()	//runs the kitchen closet room (6) (Kills them) Path A2-1
	{
		System.out.println("You open the closet.");
		System.out.println("A giant chainsaw comes down and slashes you in half.");
		System.out.println("YOU LOSE!!");
		System.exit(0);
	}
	
	public void hallway()	//runs the hallway room (7) Path A1-1
	{
		System.out.println("You enter the secret hallway.");
		System.out.println("You see a ladder that goes up into the attic.");
		System.out.println("Go up? Y/N");
		unImportantChar = scan.nextLine().toUpperCase().charAt(0);
		switch(unImportantChar)
		{
			case 'Y':
				System.out.println("You go up the ladder.");
				attic();
				break;
			default:
				System.out.println("You decide not to go up the ladder and go back into the dungeon.");
				dungeon();
				break;
		}
	}
	
	public void attic()		//runs the attic room (8) Path A1-2
	{
		System.out.println("You enter the Attic.");
		if(!dodgedLog)	//Makes user enter d to dodge a falling log
		{
			System.out.println("A log falls from the ceiling, ENTER D TO DODGE IT!!");
			timer4.schedule(quickEvent, 2000);	//Terminates program in 2 seconds
			unImportantChar = scan.nextLine().toUpperCase().charAt(0);
			switch(unImportantChar)
			{
				case 'D':
					timer4.cancel();	//Disables timer to end program in 2 seconds
					System.out.println("You dodged the falling log");
					break;
				default:
					System.out.println("YOU GOT THE WRONG NUMBAAA FOO!! The log fell on you and you died. YOU LOSE!!");
					System.exit(0);
					break;
			}
		}
		if(!secondKey)	//Math puzzle to get second half of key
		{
			System.out.println("You see the second half of the key on a marble pedestol. Grab it? Y/N");
			unImportantChar = scan.nextLine().toUpperCase().charAt(0);
			switch(unImportantChar)	//asks if user wants to attempt getting key
			{
				case 'Y':
					System.out.println("A magical floating hand blocks you from grabbing the key.");
					System.out.println("OMINOUS VOICE: YOU MUST SOLVE MY MATH PUZZLE"
							+ " (Which includes a floating point calculation!) TO CONTINUE!!!");
					System.out.println("\nGive me a fraction that is an approximation of the ratio of a "
							+ "circle's circumference to its diameter."); 
					System.out.println("\n(HINT: The numerator of the fraction is be a multiple of 11, "
							+ "and the denomenator is be a prime number.");
					
					System.out.println("\nEnter the numerator.");
					numerator = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter the denomenator");
					denomenator = scan.nextInt();
					scan.nextLine();
					
					userInputFloat = (float)numerator / (float)denomenator;
					if(userInputFloat == floatAnswer)
					{
						System.out.println("YOU HAVE SOLVED THE MY PUZZLE. YOU ARE TRULY A MATH WHIZ.");
						secondKey = true;
					}
					else
					{
						System.out.println("OMINOUS VOICE: YOU FOOL, THE ANSWER IS OBVIOSULY '22/7'!! "
								+ "Oh great now I have to kill you. You know too much.");
						System.out.println("YOU DIED!!!");
						System.exit(0);
					}
					break;
				default:
					System.out.println("You decide to ignore the obvious bait-- I mean other half of the key.");
					System.out.println("There is nothing else to do so you head down the ladder back to the hallway.");
					hallway();
					break;
			}
		}
		System.out.println("There is nothing else to do so you head down the ladder back to the hallway.");
		hallway();
	}
	
	public void runProgram()
	{
		timer.schedule(deathEvent, 300000);	//Terminates the program in 5 minutes (Runs TimerEvent from MGameTimer Class)
		startingBlurb();
		foyer(); //runs room 1 which will call all the other rooms when needed (Creates a long thread but whatevs)
	}
	
	public static void main(String[] args)
	{
		MysteryGame obj = new MysteryGame();
		obj.runProgram();
	}
}