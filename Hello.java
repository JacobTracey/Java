import java.io.*;

class Hello
{
	public static final int MAX_PAGE1 = 15;
	public static final int ROOMS = 20;
	
	public static boolean isNumeric(String strNum)    //<----Not my code
	{
		boolean ret = true;
		try
		{
			Double.parseDouble(strNum);

		}
		catch (NumberFormatException e)
		{
			ret = false;
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException
	{
		// Variable declarations
		double temp = 0, temp1 = 0;
		int check, pAns;
		String temp2;
		String A;
		double ans;
		char select, B;
		String tempString;
		String rHand, lHand, rLeg, lLeg, rArm, lArm, head, torso;
		String stance, state, usingItem;
		int rHandI, lHandI, rLegI, lLegI, rArmI, lArmI, headI, torsoI;
		int tempPage, page, room, pageVisit;
		boolean using, playing, firstTime, spiderBite7, won, switching, iSwitching, usable;
		int Bitem, playerArea;
		boolean calculating;
		boolean rLights[] = new boolean[ROOMS];
		String item[] = new String[10];
		String area[][][] = new String[ROOMS][10][10];
		String aItems[][] = new String[ROOMS][10];
		double pastAns[] = new double[25];
		boolean lightSwitch[] = new boolean[ROOMS];
		int itemSlot, sel;
		
		using = true;
		do
		{
			InputStreamReader inStream = new InputStreamReader(System.in);
			BufferedReader input = new BufferedReader(inStream);
			System.out.println("Select a value:\nCase 0(Quit):\nCase 1:\nCase 2:\nCase 3:\nCase 4(Calculator):\nCase 5(Game):");
			temp2 = input.readLine();
			check = Integer.parseInt(temp2);

			switch(check)
			{
				case 0:
				{
					using = false;
					continue;
				}
				case 1:
				{
					System.out.println("This instance is not yet in use.");
					continue;
				}
				case 2:
				{
					System.out.println("This instance is not yet in use.");
					continue;
				}
				case 3:
				{
					
					temp2 = input.readLine();
					continue;
				}
				case 4:    //Calculator
				{
					calculating = true;
					pAns = 0;
					do
					{
						do
						{
							if(pAns == 25)
							{
								pAns = 1;
								continue;
							}
							else
							{
								pastAns[pAns] = pastAns[1];
								pAns++;
								continue;
							}
						}
						while(pAns > 25);
						System.out.println("Please enter your first Operand(Or 'F' to exit):\n");
						temp2 = input.readLine();
						B = temp2.charAt(0);
						if(B == 'F')
						{
							calculating = false;
							break;
						}
						if(B == 'H')
						{
							int tempCheck;
							for(tempCheck = 0; tempCheck <= pAns; tempCheck++)
							{
								System.out.println("#" + tempCheck + ": " + pastAns[pAns]);
							}
							continue;
						}
						temp = Integer.parseInt(temp2);
						
						System.out.println("\nPlease enter your Operator:\n");
						A = input.readLine();
						B = A.charAt(0);
						
						if(B != '+' && B != '-' && B != '*' && B != '/')
						{
							System.out.println("Error: " + B + " is not an operator!\n");
							temp = 0;
							break;
						}
						else
						{
							System.out.println("Please enter the final Operand:\n");
							temp2 = input.readLine();
							temp1 = Integer.parseInt(temp2);
						}
						switch(B)
						{
							case '+':
							{
								ans = (temp + temp1);
								break;
							}
							case '-':
							{
								ans = (temp - temp1);
								break;
							}
							case '*':
							{
								ans = (temp * temp1);
								break;
							}
							case '/':
							{
								ans = (temp / temp1);
								break;
							}
							default:
							{
								ans = (temp + temp);
								continue;
							}
						}
						pastAns[1] = ans;

						System.out.println("Answer:" + ans);
					}
					while(calculating == true);
					continue;
				}
				case 5:    //Untitled game
				{
					playing     	= true;
					firstTime   	= true;
					spiderBite7 	= false;
					won         	= false;
					switching   	= false;
					
					head        	= "Uninjured";
					rHand  			= "Uninjured";
					lHand  			= "Uninjured";
					rLeg  			= "Uninjured";
					lLeg   			= "Uninjured";
					rArm  			= "Uninjured";
					lArm  	    	= "Uninjured";
					torso 	    	= "Uninjured";
					
					item[0]  		= "Empty";
					item[1] 		= "Empty";
					item[2]  		= "Empty";
					item[3]  		= "Empty";
					item[4]  		= "Empty";
					item[5]  		= "Empty";
					item[6]  		= "Empty";
					item[7]  		= "Empty";
					item[8]  		= "Empty";
					item[9] 		= "Empty";
					
					stance			= "laying";
					state  			= "healthy";
					
					headI  			= 0;
					rHandI 			= 0;
					lHandI 			= 0;
					rLegI  			= 0;
					lLegI  			= 0;
					rArmI  			= 0;
					lArmI  			= 0;
					torsoI 			= 0;
					
					Bitem  			= 0;
					room 			= 1;
					page 			= 1;
					tempPage 		= 0;
					pageVisit 		= 0;
					playerArea	 	= 0;
					itemSlot 		= 0;
					
					aItems[room][0]  = "Empty"; aItems[room][1]  = "Empty"; aItems[room][2]  = "Empty"; aItems[room][3]  = "Empty"; aItems[room][4]  = "Empty";
					aItems[room][5]  = "Empty"; aItems[room][6]  = "Empty"; aItems[room][7]  = "Empty"; aItems[room][8]  = "Empty"; aItems[room][9]  = "Empty";
					
					lightSwitch[1]  = false;
					lightSwitch[2]  = true;
					
					InputStreamReader inputText = new InputStreamReader(System.in);
					BufferedReader str = new BufferedReader(inputText);

					
					while(page != 0 && playing == true)
					{
						if(pageVisit == MAX_PAGE1 && room == 1)
						{
							System.out.println("You feel drowsey, and the air around you seems thick.\nYou can no longer stay awake. You drift off into a slumber,\nnever to awaken.");
							page = 0;
							state = "deceased";
							playing = false;
							continue;
						}
						switch(page)
						{
							case 1003:  //Use items 'U'
							{
								do
								{
									if(aItems[room][0] == "none")
									{
										System.out.println("You cannot use any items here!");
									}
									
									else
									{
										System.out.println("Which item would you like to attempt to use?:\n");
										
										System.out.println("1) " + item[0] + "\n2) " + item[1] + "\n3) " + item[2] + "\n4) " + item[3] + "\n5) " + item[4]);
										System.out.println("6) " + item[5] + "\n7) " + item[6] + "\n8) " + item[7] + "\n9) " + item[8] + "\n10) " + item[9]);
										System.out.println("11) Return");
										
										tempString = str.readLine();
										if(!isNumeric(tempString))
										{
											System.out.println("You must select an option!");
										}
										
										else
										{
											select = tempString.charAt(0);
											sel = Integer.parseInt(tempString);
											usable = false;
											
											if(sel > 11 || sel < 1)
											{
												System.out.println("You must select one of the available options!\n");
											}
											else if(sel != 11)
											{
												sel = sel-1;
												
												do
												{
													iSwitching = true;

													if(item[sel] != aItems[room][0] && item[sel] != aItems[room][1] && item[sel] != aItems[room][2]
													|| item[sel] != aItems[room][3] && item[sel] != aItems[room][4] && item[sel] != aItems[room][5]
													|| item[sel] != aItems[room][6] && item[sel] != aItems[room][7] && item[sel] != aItems[room][8]
													|| item[sel] != aItems[room][9])
													{
														System.out.println("You may not use that item here, select another!:\n");
														iSwitching = false;
														continue;
													}
													else
													{
														if(item[sel] == aItems[room][0] || item[sel] == aItems[room][1] || item[sel] == aItems[room][2]
														|| item[sel] == aItems[room][3] || item[sel] == aItems[room][4] || item[sel] == aItems[room][5]
														|| item[sel] == aItems[room][6] || item[sel] == aItems[room][7] || item[sel] == aItems[room][8]
														|| item[sel] == aItems[room][9])
														{
															usingItem = item[sel];
															usable = true;
														}
													}
												}
												while(usable != true && iSwitching == true);
													
												page = tempPage;
											}
											else
											{
												page = tempPage;
												switching = false;
											}
										}
									}
								}
								while(switching == true);
								continue;
							}
							
							case 1002:  //Check injuries 'I'
							{
								if(rHandI == 0 && lHandI == 0 && rLegI == 0 && lLegI == 0 && rArmI == 0 && lArmI == 0 && headI == 0 && torsoI == 0)
								{
									System.out.println("|--You are uninjured.--|\n");
								}
								else
								{
									System.out.println("\n--------------------------------------------------------------------");
									System.out.println("While " + stance + ", upon inspecting you body, you find:\nYour right hand is: " + rHand + " (" + rHandI + "%)");
									System.out.println("Your left hand is: " + lHand + " (" + lHandI + "%)");
									System.out.println("Your right arm is: " + rArm + " (" + rArmI + "%)");
									System.out.println("Your left arm is: " + lArm + " (" + lArmI + "%)");
									System.out.println("Your right leg is: " + rLeg + " (" + rLegI + "%)");
									System.out.println("Your left leg is: " + lLeg + " (" + lLegI + "%)");
									System.out.println("Your torso is: " + torso + " (" + torsoI + "%)");
									System.out.println("Your head is: " + head + " (" + headI + "%)\n");
									System.out.println("--------------------------------------------------------------------\n");
								}
								page = tempPage;
								continue;
							}
							
							case 1001:  //Search for items 'S'
							{
								boolean done;
								done = false;
								
								if(area[room][playerArea][0] == "Empty")
								{
									System.out.println("|--There are no items in the area!--|\n");
									page = tempPage;
									continue;
								}
								else
								{
									System.out.println("|--You find a(n) " + area[room][playerArea][itemSlot] + ".--|\n");
								}
								
								if(Bitem == 9)
								{
									do
									{
										System.out.println("|--Would you like to drop an item to pick it up?\nA) Yes:\nB) No:\n--|");

										tempString = str.readLine( );
										select = tempString.charAt(0);
										
										if(select == 'A' || select == 'B')
										{
											switch(select)
											{
												case 'A':
												{
													page = 1000;
													switching = true;
													done = true;
												}
											}
										}
										else
										{
											System.out.println("You must pick one of the two options!");
										}
									}
									while(done == false);
								}
							}
							
							case 1000:  //Check current items 'T'
							{
								boolean done;
								if(Bitem == -1)
								{
									System.out.println("|--You currently have no items.--|\n");
									page = tempPage;
									continue;
								}
								else
								{
									do
									{
										done = false;
										
										System.out.println("\n--------------------------------------------------------------------");
										System.out.println("Your items are:");
										System.out.println("0) " + item[0] + "\n" + "1) " + item[1] + "\n" + "2) " + item[2] + "\n" + "3) " + item[3] + "\n" + "4) " + item[4]);
										System.out.println("5) " + item[5] + "\n" + "6) " + item[6] + "\n" + "7) " + item[7] + "\n" + "8) " + item[8] + "\n" + "9) " + item[9] + "\n");
										System.out.println("\n-------------------------------------------------------------------\n");
										System.out.println("|--Pick an item you'd like to drop, or press 'F' to return.--|\n");

										tempString = str.readLine( );
										select = tempString.charAt(0);
										
										if(select == 'F')
										{
											done = true;
											continue;
										}
										else
										{
											if(isNumeric(tempString))
											{
												check = Integer.parseInt(tempString);
												if(check > 9)
												{
													System.out.println("|--Error: You must choose a number between 1 and 9!--|");
												}
												else
												{
													if(item[check] != "Empty")
													{
														if(switching == true)
														{
															System.out.println("|--You have traded your " + item[Bitem] + " for a(n) " + area[room][playerArea][itemSlot] + ".--|");
															item[Bitem-1] = area[room][playerArea][itemSlot];
															switching = false;
															page = tempPage;
															done = true;
														}
														System.out.println("|--You have dropped your " + item[check] + "!--|\n");
														item[check] = "Empty";
														Bitem = Bitem - 1;
														page = tempPage;
														done = true;
													}
													else
													{
														System.out.println("|--Error: You have nothing in that slot!--|\n");
														continue;
													}
												}
											}
										}
									}
									while(done == false);
								}
							}					
							
							case 1:  //Opening scene.  					(Room 1, Area 0)
							{
								pageVisit ++;
								aItems[room][0] = "none";
								
								if(firstTime == true)
								{
									System.out.println("Welcome to ___! Use 'F' at any time to quit.\nUse 'I' at any time to check your injuries.\nUse 'T' at any time to check your inventory.");
									System.out.println("Use 'S' at any time to search the area for items.");
									System.out.println("------------------------------------------------------------------\n");
									
									System.out.println("You awaken, laying on a floor made of what seems to be made of\nconcrete. You notice a throbbing ache in the back of your head and you don't remember much.\n");
									firstTime = false;
								}
								System.out.println(stance + " in the darkness, you don't see much.\nYou:");
								System.out.println("A) Attempt to stand.\nB) Attempt to roll onto your back.\nC) Look around as best you can from your position.\n");
								
								room = 1;
								playerArea = 0;
								
								do
								{
									System.out.println("Select an option!\n");

									tempString = str.readLine( );
									select = tempString.charAt(0);
								}
								while(select != 'A' && select != 'B' && select != 'C' && select != 'F' && select != 'I' && select != 'T' && select != 'U' && select != 'S');
								
								switch(select)
								{
									case 'A':
									{
										page = 2;
										continue;
									}
									case 'B':
									{
										page = 3;
										continue;
									}
									case 'C':
									{
										page = 4;
										continue;
									}
									
									
									case 'F':
									{
										playing = false;
										page = 0;
										continue;
									}
									case 'I':
									{
										tempPage = page;
										page = 1002;
										continue;
									}
									case 'T':
									{
										tempPage = page;
										page = 1000;
										continue;
									}
									case 'U':
									{
										tempPage = page;
										page = 1003;
										continue;
									}
									case 'S':
									{
										tempPage = page;
										page = 1001;
										continue;
									}
								}
							}
							case 2:  //In center of room 1. 			(Room 1, Area 0)
							{
								pageVisit ++;
								playerArea = 0;

								if(stance == "laying")
								{
									System.out.println("You bring yourself to your feet and commence to look around the room.");
									stance = "standing";
								}
								if(lightSwitch[1] == false)
								{
									System.out.println("In the low light, looking to your left reveals a wall\ncovered in various wires and pipes; to the right, you see what looks to\nbe a door, with light coming from below and above it.");
									System.out.println("Ahead of you and behind both appear to be walls with nothing visibly showing.\n");
								}
								else if(lightSwitch[1] == true)
								{
									System.out.println("To the left there is a wall covered in various valves, bare wires and pipes.\nTo the right, there is a door.");
									System.out.println("Ahead of you is a wall bearing the light-switch and behind you is an empty wall.");
								}
								System.out.println("You decide to:\nA) Turn to the left and walk toward the pipes.\nB) Turn to the right and walk toward the light.");
								System.out.println("C) Walk toward and look along the wall ahead of you.\nD) Turn around; walk toward and inspect the wall behind you.\n");
								
								do
								{
									System.out.println("Select an option!\n");

									tempString = str.readLine( );
									select = tempString.charAt(0);
								}
								while(select != 'A' && select != 'B' && select != 'C' && select != 'D' && select != 'F' && select != 'I' && select != 'U' && select != 'T');
								switch(select)
								{
									case 'A':
									{

										page = 5;
										playerArea = 3;
										continue;
									}

									case 'B':
									{
										page = 6;
										playerArea = 2;
										continue;
									}
									case 'C':
									{
										page = 8;
										playerArea = 1;
										continue;
									}
									case 'D':
									{
										if(lightSwitch[1] == false)
										{
											page = 5;
											continue;
										}
										else if(lightSwitch[1] == true)
										{
											page = 10;
											continue;
										}
										playerArea = 3;
									}
									
									
									case 'F':
									{
										playing = false;
										page = 0;
										System.out.println("F");
										continue;
									}
									case 'I':
									{
										tempPage = page;
										page = 1002;
										continue;
									}
									case 'T':
									{
										tempPage = page;
										page = 1000;
										continue;
									}
									case 'U':
									{
										
										tempPage = page;
										page = 1003;
										continue;
									}
									case 'S':
									{
										tempPage = page;
										page = 1001;
										continue;
									}
								}
								continue;
							}
							case 3:	 //Laying in center of room 1. 		(Room 1, Area 0)
							{
								pageVisit ++;
								playerArea = 0;

								System.out.println("\nRolling onto your back, you look up at the ceiling.\nYou notice various objects jutting out of the wall to the right.");
								System.out.println("The rest of the walls seem empty.\n");
								page = 4;
								continue;
							}
							case 4:  //Laying in center of room 1. 		(Room 1, Area 0)
							{
								pageVisit ++;
								playerArea = 0;

								System.out.println("You don't see much from your position. Will you stand?:\n");
								System.out.println("A) Yes\nB) No\n");
								do
								{
									System.out.println("Select an option!\n");

									tempString = str.readLine( );
									select = tempString.charAt(0);
								}
								while(select != 'A' && select != 'B' && select != 'F' && select != 'I' && select != 'T' && select != 'U' && select != 'S');
								{
									switch(select)
									{
										case 'A':
										{
											page = 2;
											continue;
										}
										case 'B':
										{
											page = 7;
											continue;
										}
										
										
										case 'F':
										{
											playing = false;
											page = 0;
											System.out.println("F");
											continue;
										}
										case 'I':
										{
											tempPage = page;
											page = 1002;
											continue;
										}
										case 'T':
										{
											tempPage = page;
											page = 1000;
											continue;
										}
										case 'U':
										{
											tempPage = page;
											page = 1003;
											continue;
										}
										case 'S':
										{
											tempPage = page;
											page = 1001;
											continue;
										}
									}
								}
								continue;
							}
							case 5:  //Near pipes, lights off. 			(Room 1, Area 4)
							{
								pageVisit ++;
								playerArea = 4;
								
								if(lightSwitch[1] == false)
								{
									System.out.println("As you approach the wall, you faintly hear the sound of water running through the pipes.");
									System.out.println("You:\nA) Begin feeling around the pipes.\nB) Go back to the center of the room.\n");
									
									System.out.println("Select an option!\n");

									tempString = str.readLine( );
									select = tempString.charAt(0);
									while(select != 'A' && select != 'B' && select != 'F' && select != 'I' && select != 'T' && select != 'U' && select != 'S');
									{
										switch(select)
										{
											case 'A':
											{
												page = 9;
												continue;
											}
											case 'B':
											{
												page = 2;
												continue;
											}
											
											
											case 'F':
											{
												playing = false;
												page = 0;
												System.out.println("F");
												continue;
											}
											case 'I':
											{
												tempPage = page;
												page = 1002;
												continue;
											}
											case 'T':
											{
												tempPage = page;
												page = 1000;
												continue;
											}
											case 'U':
											{
												tempPage = page;
												page = 1003;
												continue;
											}
											case 'S':
											{
												tempPage = page;
												page = 1001;
												continue;
											}
										}
									}
									continue;
								}
								else
								{
									System.out.println("You notice many bare wires and heavy pipes. One of the pipes seem lose. You:");
									System.out.println("A) Attempt to detach the loose pipe.\nB) Go back to the center of the room.\n");
									
									do
									{
										System.out.println("Select an option!\n");

										tempString = str.readLine( );
										select = tempString.charAt(0);
									}
									while(select != 'A' && select != 'B' && select != 'F' && select != 'I' && select != 'T' && select != 'U' && select != 'S');
									switch(select)
									{
										case 'A':
										{
											if(Bitem < 10)
											{
												System.out.println("The pipe detaches.\nYou now have a lead pipe!");
												item[Bitem] = "lead pipe";
												Bitem++;
												page = 2;
											}
											else if(Bitem == 10)
											{
												System.out.println("The pipe detaches. You cannot pick it up, however, since your inventory is full!");
												itemSlot++;
												area[1][3][itemSlot] = "lead pipe";
											}
											continue;
										}
										
										
										case 'F':
										{
											playing = false;
											page = 0;
											System.out.println("F");
											continue;
										}
										case 'I':
										{
											tempPage = page;
											page = 1002;
											continue;
										}
										case 'T':
										{
											tempPage = page;
											page = 1000;
											continue;
										}
										case 'U':
										{
											tempPage = page;
											page = 1003;
											continue;
										}
										case 'S':
										{
											tempPage = page;
											page = 1001;
											continue;
										}
									}
								}
							}
							case 6:  //Near door. 						(Room 1, Area 2)
							{
								pageVisit ++;
								playerArea = 2;

								System.out.println("As you approach the door, you can barely make out that the door seems to be made of wood.");
								System.out.println("You: \nA) Feel along the door in order to see what's there.\nB) Ram into the door with your body and hope for the best.\nGo back to the center of the room.");
							}
							case 7:  //Center of room. Spider bite.		(Room 1, Area 0)
							{
								pageVisit ++;
								playerArea = 0;

								if(spiderBite7 == false)
								{
									System.out.println("You elect to remain laying down on the ground.\nYou feel a sharp pain in your left arm.");
									System.out.println("You look toward your arm as you grab the injured\narea just in time to notice a large spider\nscurry into the darkness!\n");
									if(lArmI == 0)
									{
										lArm = "bitten by a spider!";
									}
									else
									{
										lArm = lArm + " + bitten by a spider!";
									}
									lArmI = lArmI + 5;
									spiderBite7 = true;
								}
								else
								{
									System.out.println("You continue laying on the ground, nothing interesting happens.");
								}
								page = 1;
								continue;
							}
							case 8:  //Lightswitch wall 				(Room 1, Area 1)
							{
								pageVisit ++;
								playerArea = 1;
								
								if(lightSwitch[1] == false)
								{
									System.out.println("You walk up to the wall. You can feel heat resonating off of it.");
									System.out.println("You:\nA) Inspect the wall more carefully.\nB) Go back to the center of the room.\n");
									
									do
									{
										System.out.println("Select an option!\n");

										tempString = str.readLine( );
										select = tempString.charAt(0);
									}
									while(select != 'A' && select != 'B' && select != 'F' && select != 'I' && select != 'T' && select != 'U' && select != 'S');
									switch(select)
									{
										case 'A':
										{
											page = 11;
											continue;
										}
										case 'B':
										{
											page = 2;
											continue;
										}
										
										
										case 'F':
										{
											playing = false;
											page = 0;
											System.out.println("F");
											continue;
										}
										case 'I':
										{
											tempPage = page;
											page = 1002;
											continue;
										}
										case 'T':
										{
											tempPage = page;
											page = 1000;
											continue;
										}
										case 'U':
										{
											tempPage = page;
											page = 1003;
											continue;
										}
										case 'S':
										{
											tempPage = page;
											page = 1001;
											continue;
										}
									}
								}
								else if(lightSwitch[1] == true)
								{
									System.out.println("As you approach the wall, you feel heat resonating off of it;\nThe only thing you see on the wall is the light stwich.");
									System.out.println("You:\nA) Turn off the lights.\nB) Go back to the center of the room.\n");
									
									do
									{
										System.out.println("Select an option!\n");

										tempString = str.readLine( );
										select = tempString.charAt(0);
									}
									while(select != 'A' && select != 'B' && select != 'F' && select != 'I' && select != 'T' && select != 'U' && select != 'S');
									switch(select)
									{
										case 'A':
										{
											page = 11;
											lightSwitch[1] = false;
											continue;
										}
										case 'B':
										{
											page = 2;
											continue;
										}
										
										case 'F':
										{
											playing = false;
											page = 0;
											continue;
										}
										case 'I':
										{
											tempPage = page;
											page = 1002;
											continue;
										}
										case 'T':
										{
											tempPage = page;
											page = 1000;
											continue;
										}
										case 'U':
										{
											tempPage = page;
											page = 1003;
											continue;
										}
										case 'S':
										{
											tempPage = page;
											page = 1001;
											continue;
										}
									}
								}
							}
							case 9:  //Near pipes. Die. 				(Room 1, Area 4)
							{
								pageVisit ++;
								
								System.out.println("As you feel along the wall, your hand encounters a bare wire.\nThe last thing you see before you die is a bright flash.\n\n");
								state = "deceased";
								page = 0;
								playing = false;
								break;
							}
							case 10: //Near pipes, lights on.           (Room 1, Area 4)
							{
								pageVisit ++;
								
								System.out.println("You notice many bare wires and heavy pipes. One of the pipes seem lose. You:");
								System.out.println("A) Attempt to detach the loose pipe.\nB) Go back to the center of the room.\n");
								
								do
								{
									System.out.println("Select an option!\n");

									tempString = str.readLine( );
									select = tempString.charAt(0);
								}
								while(select != 'A' && select != 'B' && select != 'F' && select != 'I' && select != 'T' && select != 'U' && select != 'S');
								switch(select)
								{
									case 'A':
									{
										if(Bitem < 10)
										{
											System.out.println("The pipe detaches.\nYou now have a lead pipe!");
											item[Bitem] = "lead pipe";
											page = 2;
										}
										else if(Bitem == 10)
										{
											System.out.println("The pipe detaches. You cannot pick it up, however, since your inventory is full!");
											itemSlot++;
											area[1][3][itemSlot] = "lead pipe";
										}
										continue;
									}
									
									
									case 'F':
									{
										playing = false;
										page = 0;
										System.out.println("F");
										continue;
									}
									case 'I':
									{
										tempPage = page;
										page = 1002;
										continue;
									}
									case 'T':
									{
										tempPage = page;
										page = 1000;
										continue;
									}
									case 'U':
									{
										tempPage = page;
										page = 1003;
										continue;
									}
									case 'S':
									{
										tempPage = page;
										page = 1001;
										continue;
									}
								}
							}
							case 11: //Back wall.                       (Room 1, Area 3)
							{
								pageVisit ++;
								playerArea = 3;
								
								System.out.println("The wall seems to be relatively empty, except for one small bit jutting out to the far right.");
								System.out.println("Upon closer inspection, you find a lightswitch on the far right of the wall.\nYou:");
								System.out.println("A) Turn on the lights.\nB) Return to the center of the room.");
								
								tempString = str.readLine( );
								select = tempString.charAt(0);
								while(select != 'A' && select != 'B' && select != 'F' && select != 'I' && select != 'T' && select != 'U' && select != 'S');
								{
									switch(select)
									{
										case 'A':
										{
											page = 2;
											lightSwitch[1] = true;
											continue;
										}
										case 'B':
										{
											page = 2;
											continue;
										}
										
										case 'F':
										{
											playing = false;
											page = 0;
											System.out.println("F");
											continue;
										}
										case 'I':
										{
											tempPage = page;
											page = 1002;
											continue;
										}
										case 'T':
										{
											tempPage = page;
											page = 1000;
											continue;
										}
										case 'U':
										{
											tempPage = page;
											page = 1003;
											continue;
										}
										case 'S':
										{
											tempPage = page;
											page = 1001;
											continue;
										}
									}
								}
							}
						}
					}
					if(won == false)
					{
						System.out.println("Your finishing status is '" + state + "', thank you for playing!\n\n");
						playing = false;
					}
					else
					{
						System.out.println("Congratulations! You are " + state + ". Thank you for playing!\n\n");
						playing = false;
					}
				}
			}
		}
		while(using == true);
	}
}