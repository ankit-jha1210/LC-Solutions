We need to k closest points to distance so we see k and closest means min distance from origin so how we judge between two points which is more closest . So we use distance of those two points so formula of distance is` √(x1 - x2)^2 + (y1 - y2)^2)`  well we have to find distance from origin so distance becomes `√x1^2 + y1^2` . Well we use heap to get k closest points and sort them on basis of distance . well we will do `x1^2 + y1^2` cause
√x1^2 + y1^2 <  √x2^2 + y2^2
Squaring both sides
x1^2 + y1^2 <  x2^2 + y2^2
so that's we will do x1^2 + y1^2