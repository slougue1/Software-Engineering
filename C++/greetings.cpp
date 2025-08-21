#include <iostream>
#include <string> // for the string variables and constants
#include <iomanip> // for setprecision and fixed
using namespace std;

int main()
{
	string robotName = "Robert",
		visitorName;
	const string programmerName = "Sakina Lougue",
		dueDate = "Jully,25th,2020"; // If written that way: 07/25/2020 the computer will take it as a division

	int age,
		assigmentNumber = 1;

	const int monthsPerYear = 12, // there are 12 months in a year
		daysPerYear = 360, // 365 days a in year
		hoursPerYear = 8640, // 8760 h in a year
		minutesPerYear = 518400, // 5256000 mns in a year
		secondsPerYear = 31104000, // and 3153000s in a year
		dogYear = 7,
		goldfishYear = 5;

	int value1, value2;


	cout << "\n*********************************Robot Prototype Scrpting**************************************\n\n";
	cout << "Hello, welcome to Montgomery College! My name is " << robotName << ". May I please have your name?\n"; //presentation of the robot
	getline (cin, visitorName); // the visitor's name has a space in it, that's why we use getline

	cout << "Nice to have you with us today, " << visitorName << "!\n";
	cout << "Let me impress you with a small game.\n";
	cout << "Give me the age of an important person or a pet to you.\n";
	cout << "Please give me only a number:\n"; // prompt to enter an age
	cin >> age;

	cout << endl << "You have entenred 2." << endl;
	cout << " If this is for a person, the age can be expressed as: " << endl;
	cout << " " << age << " years\n";
	cout << " or, " << age * monthsPerYear << " months" << endl;        //Calculation of the person's age in month
	cout << " or, about " << age * daysPerYear << " days" << endl;      //in days
	cout << " or, about " << age * hoursPerYear << " hours" << endl;    //in hours
	cout << " or, about " << age * minutesPerYear << " minutes" << endl;//in minutes
	cout << " or, about " << age * secondsPerYear << " seconds." << endl;//in hours 
	cout << " If this is for a dog, it is " << age * dogYear << " years old in human age." << endl;
	cout << " If this is for a gold fish, it is " << age * goldfishYear << " years old in human age." << endl << endl;

	cout << "Let's play another game, " << visitorName << "." << " Give me a whole number." << '\n'; //promt
	cin >> value1;
	cout << "Very well. Give me another whole number." << '\n';//promt
	cin >> value2;

	cout << "Using the operator '+' in C++, the result of " << value1 << " + " << value2 << " is " << value1 + value2 << "." << endl;
	cout << "Using the operator '/', the result of " << value1 << "/" << value2 << " is " << value1 / value2 << endl;
	cout << "however, the result of " << setprecision(1) << fixed << static_cast<double>(value1) << "/" << static_cast<double>(value2) << " is about " << static_cast<double>(value1) / static_cast<double>(value2) << ".";
	cout << endl << endl; // As the first and second number were identify as integer, we need to convert them in double to avoid an integer division
						  // use fixed not to have the number written in scientifique notation and setprecision to have only a number as the precision

	cout << "*******************************************************************************************************************************************\n\n";
	cout << "Thank you for testing my program!!\n";
	cout << "PROGARMMER: " << programmerName << endl;
	cout << "CMSC 140 Common Project 1\n";
	cout << "Due Date: " << dueDate << endl;

	system("pause");
	return (0);

}
