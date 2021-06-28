#include <bits/stdc++.h>
//Monte Carlo method
using namespace std;
int main(){
	int max=100;
	double rand_x, rand_y, origin_dist, pi;
	int circle_points = 0, square_points = 0;
	// Initializing rand()
	srand(time(NULL));
	for (int i = 0; i < (max*max); i++) {
		// Randomly generating x and y values
		rand_x = double(rand() % (max + 1)) / max;
		rand_y = double(rand() % (max + 1)) / max;
		square_points++;
		// calculating distance from origin
		origin_dist = rand_x * rand_x + rand_y * rand_y;
		if (origin_dist <= 1){
			circle_points++;// if point lies inside circle
		}
	}
	pi = double(4 * circle_points) / square_points;
	cout << "Estimated value of Pi = "<< pi;
	return 0;
}
