# Simple Performance compare for 3 languages

Performance benchmark for a simple computing and pointer intensive program in Java, C# and C++.

# Results

Language | Result | Relative Performance | Memory peak | Memory after called GC |Relative Memory
--- | --- | --- | --- | --- | ---
Java | 24.33s | 0.56 | 1768.9M | 1769.2M | 1.80
C#   |  21.22s | 0.64 | 1548.37M | 187.9M | 1.58
C++  | 13.58s  | 1.00 | 979.95M | 0.6M | 1.0
C++ reference-counting gc | 16.97s | 0.80 | 1831.2M | 0.6M | 1.87
Python | 80.18s(1/2) | 0.08 | 3757.5M | 28.2M | 7.66
Pypy | 10.46s(1/2) | 0.65 | 3824.9M | 3411.2M | 7.80

> Copyright (C) 2016  Shan Ting <vxst@vxst.org>
> 
> This program is free software: you can redistribute it and/or modify
> it under the terms of the GNU General Public License as published by
> the Free Software Foundation, either version 3 of the License, or
> (at your option) any later version.
> 
> This program is distributed in the hope that it will be useful,
> but WITHOUT ANY WARRANTY; without even the implied warranty of
> MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
> GNU General Public License for more details.
> 
> You should have received a copy of the GNU General Public License
> along with this program.  If not, see <http://www.gnu.org/licenses/>.

