//Hana Hyder
//ImageEdit.java
//1/24/2013
//This program will generate a .ppm file named b1.ppm. This b1.ppm file
//is a ppm file of the American flag! The program utilizes PrintWriter,
//Scanner, and File.

import java.util.Scanner; //imports
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class ImageEdit
{
	private int width, height;
	private String dataString = new String("");
	private PrintWriter output = null;
	
	public ImageEdit()
	{
		width = 200;
		height = 160;		
	}
	public static void main(String [] args)
	{
		ImageEdit image = new ImageEdit();
		image.initString();
//		image.makeLoop();
		image.makeNewFile();
		
	}
	public void initString()
	{
		dataString = "P3\n" + width + "    " + height + "\n255\n";
	}
	public void makeNewFile() //Create all of the new files.
	{
		File f = new File("b1.ppm");
//		PrintWriter output = null;
		try
		{
			output = new PrintWriter(f);
		}
		catch(IOException e)
		{
			System.out.println("Error: no file found.");
			System.exit(1);
		}
		//output.print(dataString);
		output.write("P3\n" + width + "    " + height + "\n255\n");
//		output.write("\nHello?");
		makeLoop();
		output.close();
		System.out.println("\n\nb1.ppm created and updated.\n\n");
	}
	public void makeLoop() //b1.ppm
	{
		int red, green, blue;
		for(int i = 0; i < 160; i++)//rows
		{
			for(int j = 1; j < 201; j++)//columns
			{
				
				if(-Math.pow(i - 0, 3)/5 + 80 <= j)
				{
					
					red = 0;
					green = 114;
					blue = 255;
					if(-Math.pow(i - 14, 3)/5 + 80 <= j)
					{
						red = 255 - (int)(Math.random()*50);
						green = 255;
						blue = 255;
					}
					if(-Math.pow(i - 40, 3)/5 + 80 <= j)
					{
						red = 0;
						green = 90 + (int)(Math.random()*10);
						blue = 201;
						
					}
					if(-Math.pow(i - 0, 3)/5 + 80 <= j && j < 90)
					{
						red = 186 - (int)(Math.random()*40) - i;
						green = 29;
						blue = 0;
					}
					if(-Math.pow(i - 66, 3)/5 + 80 <= j)
					{
						red = 255 - (int)(Math.random()*50);
						green = 255;
						blue = 255;
					}
					if(-Math.pow(i - 82, 3)/5 + 80 <= j)
					{
						red = 0;
						green = 90 + (int)(Math.random()*10);
						blue = 201;
					}
					if(-Math.pow(i - 100, 3)/5 + 80 <= j)
					{
						red = 255 - (int)(Math.random()*50);
						green = 255;
						blue = 255;
					}
					if(-Math.pow(i - 116, 3)/5 + 80 <= j)
					{
						red = 0;
						green = 90 + (int)(Math.random()*10);
						blue = 201;
					}
					if(-Math.pow(i - 132, 3)/5 + 80 <= j)
					{
						red = 255 - (int)(Math.random()*50);
						green = 255;
						blue = 255;
					}
					if(-Math.pow(i - 148, 3)/5 + 80 <= j)
					{
						red = 0;
						green = 90 + (int)(Math.random()*10);
						blue = 201;
					}
					if(-Math.pow(i - 156, 3)/5 + 80 <= j)
					{
						red = 0;
						green = 0;
						blue = 0;
					}
					if(201*i/160 > j)
					{
						red+= i;
						green+= i;
						blue+= i;
					}
					if(201*i/160 - 20> j)
					{
						//red-= i;
						//green += i;
						blue -= i;
						green -= i;
						red -= i;
					}
					if(201*i/160 + 20> j)
					{
						//red-= i;
						blue -= i;
					}
					if(201*i/160 + 40> j)
					{
						//red-= i;
						red -= i;
					}
						green -= i;
					if(201*i/160 + 40 < j)
					{
						red+= (int)(i/20);
						//green+= (int)(i/20);
						//blue+= (int)(i/20);
					}
				
				}
				else
				{
					red = 0;
					green = 0;
					blue = 0;
				}
				output.printf("%-5d %-5d %-5d     ", red,green,blue);
				if(j%14 == 0 && j != 0)
				{
					output.write("\n");
				}
			}
			output.write("\n\n\n");
		}
	}

}
