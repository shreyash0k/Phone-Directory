/* ALL RIGHTS RESERVERD BY Shreyash Karandikar oct 2016 */
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
class contacts
{
	Scanner sc = new Scanner(System.in);
	String fname;
	String lname;
 	BigInteger pno;
	int entryno;
	public void replace(contacts c[],int index,int ent)
	{
		for(int k=index;k<ent-1;k++)
		{
			this.fname = c[k+1].fname;
			this.lname = c[k+1].lname;
			this.pno   = c[k+1].pno;
		}
	}
	public void edit(BigInteger a,String x,String y)
	{
		pno = a;
		fname = x;
		lname = y;
		
	}
	public void addnew(int x)
	{
		System.out.println("------------------------------------");
		System.out.println("Entry NO: "+x);
		System.out.print("First Name:   ");
		fname = sc.next();
		System.out.print("Last Name:    ");
		lname = sc.next();
		System.out.print("Phone Number: ");
		pno = sc.nextBigInteger();
		entryno=x;
		System.out.println("");
		
		
	}
	public void display()
	{
		System.out.println("------------------------------------");
		System.out.println("Entry NO: "+entryno);
		System.out.println("First Name:  "+fname);
		System.out.println("Last Name:   "+lname);
		System.out.println("Phone Number:"+pno);
		System.out.println("");
	}
	public boolean compare(String f,String l)
	{
			if(f.equals(fname)&& l.equals(lname))
			{
				return(true);
			}
			else 
				return (false);
	}
	public boolean comparenum(BigInteger i)
	{
		System.out.println(pno+""+i);
		if(pno.equals(i))
		{
			
			return (true);
		}
		else
		{
			return (false);
		}
		
	}
}




public class pdirectory
{
	public static void main(String arg[])
	{	
		int count=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of entries:");
		int entry = sc.nextInt();
		try
		{
			contacts[] c = new contacts[100];
			for(int i=0;i<entry;i++)
			{
				c[i]= new contacts();
				c[i].addnew(i);			
			}	
			do
			{
				System.out.println("------------------------------------");
				System.out.println("0.Exit \n1.Search by name \n2.Search by number\n3.Edit\n4.Add\n5.Remove\n6.Display\n"); //menu..............
				
				int ch = sc.nextInt();
				switch(ch)
				{
					case 0:{
							System.out.println("EXIT");
							System.exit(0);
							break;
							}
					case 1:{
							if(entry ==0)
							{
								System.out.println("------------------------------------");
								System.out.println("EMPTY CONCTACT LIST PLEASE ADD NEW CONTACT");
								break;
							}
							System.out.println("SEARCH BY NAME");
							System.out.println("\nEnter first name and last name to search: ");
							String x=sc.next();
							String y=sc.next();
							for(int i=0;i<entry;i++)
							{
							if(c[i].compare(x,y)==true)
							{
								System.out.println("------------------------------------");
								System.out.println("---Found---");
								c[i].display();
								break;
					
							}
							if(i==entry-1)
							{
								System.out.println("------------------------------------");
								System.out.println("---NOT Found---");
								break;
							}
							}//for
							
							
				
						break;
							}// case1
				
					case 2:{
							if(entry ==0)
							{
								System.out.println("------------------------------------");
								System.out.println("EMPTY CONCTACT LIST PLEASE ADD NEW CONTACT");
								break;
							}
							System.out.println("SEARCH BY NUMBER");
							System.out.println("\nEnter number ");
							BigInteger x=sc.nextBigInteger();
							for(int i=0;i<entry;i++)
							{
									if(c[i].comparenum(x)==true)
									{
									System.out.println("------------------------------------");
									System.out.println("---Found---");
									c[i].display();
									break;
									
									}
									if(i==entry-1)
									{
										System.out.println("------------------------------------");
										System.out.println("---NOT Found---");
										break;
									}
							}
							break;
							}//case2
					case 3:{
							if(entry ==0)
							{	
								System.out.println("------------------------------------");
								System.out.println("EMPTY CONCTACT LIST PLEASE ADD NEW CONTACT");
								break;
							}
							int z;
							System.out.println("EDIT........................USING\n1.NUMBER\t2.NAME");
							z=sc.nextInt();
							switch(z)
							{
								case 1:{
									System.out.println("EDIT USING NUMBER");
									System.out.println("\nEnter number ");
									BigInteger x=sc.nextBigInteger();
									for(int i=0;i<entry;i++)
									{
										if(c[i].comparenum(x)==true)
										{
											System.out.println("Enter new fname ");
											String f = sc.next();
											System.out.println("Enter new lname ");
											String l = sc.next();
											System.out.println("Enter new number:");
											BigInteger o=sc.nextBigInteger();
											c[i].edit(o,f,l);
											System.out.println("------------------------------------");
											System.out.println("--Succesfuly edited--");
											break;
											
									
										}
										if(i==entry-1)
										{
											System.out.println("---NOT Found---");
											break;
										}
									}
									break;
									}
								case 2:{
									System.out.println("EDIT USING NAME");
									System.out.println("\nEnter first name and last name to search: ");
									String x=sc.next();
									String y=sc.next();
									for(int i=0;i<entry;i++)
									{
										if(c[i].compare(x,y)==true)
										{	System.out.println("Enter new fname ");
											String f = sc.next();
											System.out.println("Enter new lname ");
											String l = sc.next();
											System.out.println("Enter new number:");
											BigInteger o=sc.nextBigInteger();
											c[i].edit(o,f,l);
											System.out.println("------------------------------------");
											System.out.println("--Succesfuly edited--");
											
											break;
						
										}
										if(i==entry-1)
										{
											System.out.println("---NOT Found---");
											break;
										}
									
									}
									break;
										}//case 2 of inner switch
							}//inner switch
							break;
					}//3rd case of outer switch
					case 4:
					{
						System.out.println("ADD NEW CONTACT");
						c[entry] = new contacts();
						c[entry].addnew(entry);
						entry++;
						System.out.println("------------------------------------");
						System.out.println("--Succesfuly added--");
						break;
					}
					case 5:
					{
						if(entry ==0)
						{
							System.out.println("------------------------------------");
							System.out.println("EMPTY CONCTACT LIST PLEASE ADD NEW CONTACT");
							break;
						}
						else
						{
							System.out.println("REMOVE");
							System.out.println("1.Remove by name\n2.Remove all");
							
							int h = sc.nextInt();
							if(h==1)
							{
								System.out.println("\nEnter first name and last name to search: ");
								String x=sc.next();
								String y=sc.next();
								for(int i=0;i<entry;i++)
								{
									if(c[i].compare(x,y)==true)
									{
										if(i==entry-1)//last element
										{
											entry = entry -1;
											System.out.println("------------------------------------");
											System.out.println("Succesfuly removed");
											break;
										}
										else
										{
										c[i].replace(c,i,entry);
										entry--;
										System.out.println("------------------------------------");
										System.out.println("Succesfuly removed");
										
										break;
										}
										
									}
									if(i==entry-1)
									{
										System.out.println("------------------------------------");
										System.out.println("---NOT Found---");
										break;
									}
								}//for
							}
							else if(h==2)
							{
								System.out.println("------------------------------------");
								System.out.println("REMOVED ALL CONTACTS");
								entry = 0;
							}
							else
							{
								System.out.println("------------------------------------");
								System.out.println("Wrong choise ");
							}
							
							break;
						}//else
						
					}
					case 6:
					{
							if(entry ==0)
							{	System.out.println("------------------------------------");
								System.out.println("EMPTY CONCTACT LIST PLEASE ADD NEW CONTACT");
							}
							else
							{
								System.out.println("ALL CONCTACTS ");
								for(int i=0;i<entry;i++)
								{
									c[i].display();
									
								}
							}
							break;
							
					}
					default: 
					{
						System.out.println("------------------------------------");
						System.out.println("wrong choise dude");
						break;
					}
				}//switch
				count++;
			}while(true); //while loop for menu
		}//try
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}
