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

#include <cstdio>
#include <chrono>
#include <list>
#include <vector>
#include <cmath>

using namespace std;
double time_unix(){
	return (double)(chrono::duration_cast<chrono::milliseconds>(chrono::system_clock::now().time_since_epoch())).count() / 1000.0;
}
class BigObject
{
private:
	int value;
	list<double>* l;
public:
	BigObject()
	{
		l = new list<double>();
	}
	~BigObject()
	{
		delete l;
	}
	void push()
	{
		l->push_back(value);
		value++;
	}
	void pop()
	{
		l->pop_front();
	}
	double sum()
	{
		double s = 0.0;
		for(double i: *l)
		{
			s += sin(i) - log(fabs(i)) + pow(3.0, i);
		}
		return s;
	}
};

int main(){
	const int n = 10000000;
	vector<BigObject*>* s = new vector<BigObject*>;
	double result = 0.0;
	double start_time = time_unix();
	for (int i = 0; i < n; i++)
	{
		s->push_back(new BigObject);
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < 10; j++)
			s->at(i)->push();
		for (int j = 0; j < 9; j++)
			s->at(i)->pop();
		result += s->at(i)->sum();
	}
	for(int i = 0; i < (int)s->size(); i++)
		delete s->at(i);
	s->clear();
	s->shrink_to_fit();
	double end_time = time_unix();
	printf("Time: %.3lf\n", end_time - start_time);
	delete s;
}
