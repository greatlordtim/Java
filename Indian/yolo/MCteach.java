/*
 *      MCteach.java
 *      
 *      Copyright 2012  <>
 *      
 *      This program is free software; you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation; either version 2 of the License, or
 *      (at your option) any later version.
 *      
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *      
 *      You should have received a copy of the GNU General Public License
 *      along with this program; if not, write to the Free Software
 *      Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 *      MA 02110-1301, USA.
 */


public abstract class MCteach {
	int x = 3;
	public static void main (String args[]) {		
			MC c = new MC();		
			c.superMethod(90);
	}
	public void print (int x){
		this.x = x; 
		
	}
	
	
}

class MC extends MCteach{
	public void print(int x){
		this.x = 100- this.x + x;
	}
	public void superMethod(int x){
		print(x);
		System.out.println(this.x)
		
		super.print(20);
		System.out.println(this.x);
	}
	
}
