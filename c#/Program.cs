/*
 * Copyright (C) 2016  Shan Ting <vxst@vxst.org>
 * 
 * This is NOT an open source program!
 * 
 * The program is the private property of Shan Ting.
 * 
 * Unless required by applicable law or agreed to in writing, the author keeps
 * any rights of the program. All access, modify or distribute of any parts of
 * the program, include but not limit to executable file, libraries, source code,
 * are strictly forbidden. Any usage of the executable file, libraries or source
 * code will be regarded as DELIBERATELY VIOLATE LAWS, and will be prosecuted with
 * the maximum possibilities.
 * 
 * Even with the written confirmation from Shan Ting, the distribute of any
 * parts of the program(include but not limited to executable file, libraries, source
 * code) is regarded as DELIBERATELY VIOLATE LAWS, and will be prosecuted with maximum
 * effect.
 */

namespace CShapeStudy
{
	using System.Collections.Generic;
	class BigObject
	{
		private int value;
		private LinkedList<double> list;
		public BigObject()
		{
			list = new LinkedList<double>();
		}
		public void push()
		{
			list.AddLast(value);
			value++;
		}
		public void pop()
		{
			list.RemoveFirst();
		}
		public double sum()
		{
			double s = 0.0;
			foreach(double i in list)
			{
				s += System.Math.Sin(i) - System.Math.Log(System.Math.Abs(i + 1.0))
				           + System.Math.Pow(3.0, i);
			}
			return s;
		}
	}
	class MainClass
	{
		public static void Main (string[] args)
		{
			const int n = 5000000;
			System.Diagnostics.Stopwatch stopwatch = new System.Diagnostics.Stopwatch();
			List<BigObject> s = new List<BigObject>();
			double result = 0.0;
			stopwatch.Start();
			for (int i = 0; i < n; i++)
			{
				s.Add(new BigObject());
			}
			var op = new System.Threading.Tasks.ParallelOptions();
			op.MaxDegreeOfParallelism = 4;
			for(int i = 0; i < n; i++)
			{
				for (int j = 0; j < 10; j++)
					s[i].push();
				for (int j = 0; j < 9; j++)
					s[i].pop();
				result += s[i].sum();
			}
			System.GC.Collect();
			stopwatch.Stop();
			System.Console.Write("Finished");
			System.Console.ReadLine();
			stopwatch.Start();
			s.Clear();
			System.GC.Collect();
			stopwatch.Stop();
			System.Console.Write("Time: " + stopwatch.Elapsed.TotalSeconds);
			System.Console.ReadLine();
		}
	}
}
