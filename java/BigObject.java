/*
 * Copyright (C) 2016  Shan Ting <vxst@vxst.org>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.LinkedList;
public class BigObject{	
	private int value;
	private LinkedList<Double> list;
	public BigObject()
	{
		list = new LinkedList<Double>();
	}
	public void push()
	{
		list.addLast((double)value);
		value++;
	}
	public void pop()
	{
		list.removeFirst();
	}
	public double sum()
	{
		double s = 0.0;
		for(double i :list)
		{
			s += Math.sin(i) - Math.log(Math.abs(i + 1.0))
				+ Math.pow(3.0, i);
		}
		return s;
	}
};
