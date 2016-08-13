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

import java.util.ArrayList;
import java.util.Scanner;

public class Program{
	public static void main (String[] args)
	{
		final int n = 10000000;
		Stopwatch stopwatch = new Stopwatch();
		ArrayList<BigObject> s = new ArrayList<BigObject>();
		double result = 0.0;
		stopwatch.start();
		for (int i = 0; i < n; i++)
		{
			s.add(new BigObject());
		}
		for(int i = 0; i < n; i++)
		{
			for (int j = 0; j < 10; j++)
				s.get(i).push();
			for (int j = 0; j < 9; j++)
				s.get(i).pop();
			result += s.get(i).sum();
		}
		System.gc();
		stopwatch.stop();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Finished");
		scanner.nextLine();
		stopwatch.start();
		s.clear();
		System.gc();
		System.runFinalization();
		stopwatch.stop();
		System.out.println("Time: " + stopwatch.elapsedSeconds());
		scanner.nextLine();
	}
}
