/*
The BlueMont chain hotels are almost located everywhere in the U.S and have 4 different types of room: single, double, king, and suite rooms.
However, the size of the hotel chains may be different in terms of the number of floors, the type and the number of rooms on each floor.
Therefore, this program calculates the occupancy rate and the total income of the a hotel chain for a night.
*/

#include <iostream> 
#include <string> 
#include <iomanip> //For right, setw and setprecision
using namespace std;

int main()
{
	const string programmerName = "Sakina Lougue",
		dueDate = "August,8th,2020";
	string location;

	const int minFloor = 1,
		maxFloor = 5,
		minRoom = 1,
		maxRoom = 30;
	int i, j = 0, // loop variable couting throught floors
		floors,   // Total number of floors in the hotel
		rooms =30,    // Total number of rooms in the hotel
		singleRooms,      //Number of single rooms
		doubleRooms,      //Number of double romms
		kingRooms,        //Number of king rooms
		suites;           //Number of suites 
	int totalSingleRooms=0, //set all total variable to zero
		totalDoubleRooms=0,
		totalKingRooms=0, 
		totalSuites=0;
	int singleRate = 60,        //Price of a single room
		doubleRate = 75,        //Price of a double room
		kingRate = 100,         //Price of a king room
		suiteRate = 150;        //Price of a suite
	int unoccupiedRooms=0, 
		totalRoomsInHotel =0,
		min,
		totalRooms,
		occupiedRooms = 0,
		sum = 0;
	double occupancyRate=0;

	cout << "==============================================================================\n";
	cout << right << setw(40) << "BlueMont Hotel\n";
	cout << "==============================================================================\n";
	cout << "Enter the location of this hotel chain: ";
	getline (cin, location);
	cout << "Enter total number of floors of the hotel: ";
	cin >> floors;

	while (floors < minFloor || floors > maxFloor)   //So that if the number of floor is out of the range of 1-5, it will loop
	{
		cout << "Number of floors should be between 1 and 5!! Please try again." << endl;
		cout << endl << "Enter the total number of floors of the hotel: ";
		cin >> floors;
	}
	for (i = 1; j < floors; i++)         //I used for loop because I want this part to loop specifically the the number of floors times
	{
		cout << endl << endl << "Enter the total number of rooms on the floor number #" << i << ": "; //i will just help keep a track on how many times to loop the question about the single, double, king, double...rooms
		cin >> totalRooms;                //different from the one set to 0
		while (totalRooms < minRoom || totalRooms > maxRoom)
		{
			cout << "Number of rooms should be between 1 and 30!! Please try again.";
			cout << endl << endl<< "Enter the total number of rooms on the floor number #" << i << ": ";
			cin >> totalRooms;
		}
		int inputRoomsOnFloor = 0;
		cout << "How many SINGLE rooms are occupied on the floor number #" << i << "? ";
		cin >> singleRooms;
		inputRoomsOnFloor += singleRooms;
		cout << "How many DOUBLE rooms are occupied on the floor number #" << i << "? ";
		cin >> doubleRooms;
		inputRoomsOnFloor += doubleRooms;
		cout << "How many KING rooms are occupied on the floor number #" << i << "? ";
		cin >> kingRooms;
		inputRoomsOnFloor += kingRooms;
		cout << "How many SUITE are occupied on the floor number #" << i << "? ";
		cin >> suites;
		inputRoomsOnFloor += suites;
		if (inputRoomsOnFloor > totalRooms)
		{
			cout << "The total number of occupied rooms exceed the total number of rooms on this floor. Please try again!!\n";
			i--;
			continue;
		}
		else
		{
			totalSingleRooms += singleRooms;
			totalDoubleRooms += doubleRooms;
			totalKingRooms += kingRooms;
			totalSuites += suites;
			totalRoomsInHotel += totalRooms;
		}
		j++;
	}//En of the loop part
	
	cout << endl << endl << "======================================================================================================================\n";
	cout << right << setw(42) << "BlueMont Hotel located in ";
	getline(cin, location);
	cout << endl << right << setw(50) << "TODAY'S ROOM RATES<US$/night>\n";
	cout << endl << right << setw(25) << "Single Room" << right << setw(25) << "Double Room" << right << setw(25) << "King Room" << right << setw(25) << "Suite Room\n";
	cout << endl << right << setw(24) << singleRate << "$";
	cout << right << setw(24) << doubleRate << "$";
	cout << right << setw(24) << kingRate << "$";
	cout << right << setw(24) << suiteRate << "$" << endl;
	cout << "=========================================================================================================================================";
	//calculation part
	occupiedRooms = occupiedRooms + totalSingleRooms + totalDoubleRooms + totalKingRooms + totalSuites; //The total of occupied can not just be "occupiedRoom" because we set it to 0. so it will be the sum of all single...rooms occupied on all the floors.
	unoccupiedRooms = totalRoomsInHotel - occupiedRooms;
	occupancyRate = (static_cast<double>(occupiedRooms) / totalRoomsInHotel)*100; //convert to double to avoid integer divion
	double hotelIncome = (static_cast<double>(totalSingleRooms) * 60) + (static_cast<double>(totalDoubleRooms) * 75) + (static_cast<double>(totalKingRooms) * 100) + (static_cast<double>(totalSuites) * 150); //convert to double to avoid arithmetic overflow
	cout << endl << right << setw(45) << "Hotel Income: " << right << setw(16) << "$" << hotelIncome;
	cout << endl << right << setw(45) << "Total number of rooms: " << right << setw(20) << totalRoomsInHotel;
	cout << endl << right << setw(45) << "Total number of occupied rooms: " << right << setw(20) << occupiedRooms;
	cout << endl << right << setw(45) << "Total number of unoccupied rooms: " << right << setw(20) << unoccupiedRooms;
	cout << endl << right << setw(45) << "Occupancy rate: " << right << setw(20)<<  fixed<< setprecision(2) << occupancyRate << "%";

	//Need to find minimum number of floors
	//i is the floor number
	min = rooms;
	for (i = 2; i <= floors; i++)
	{
		if (rooms < min)
			min = i;
	}
	cout << endl << endl << "The floor number# " << floors << " with " << totalRooms << " rooms, has the least number of rooms.\n";
	cout << "Need to improve hotel occupancy rate!!\n";
	cout << "\nThank you for testing my program!!";
	cout << "\nPROGRAMMER: " << programmerName;
	cout << "\nCMSC 140 Common Project 3";
	cout << "\nDue date: " << dueDate << endl << endl;


	system("pause");
	return 0;
}
