/*
This program converts the temperature from celsuis to farenheit,
the distance from kilometer to miles, and
the weight from kilogram to pounds.
*/

#include <iostream>
#include <string>  // for the string variables
#include <iomanip> // for setprecision and fixed
#include <cmath>   // for the round function
using namespace std;

int main()
{

	const string programmerName = "Sakina Lougue",
		dueDate = "August, 1st,2020"; // If written that way: 08/01/2020 the computer will take it as a division

	string countryName;

	int chosenNumber;
	double celciusTemparature,
		kilometerDistance,
		kilogramWeight;

	cout << "\nHello! Please enter a country name: ";
	getline(cin, countryName); //So that the computer can let you enter a name with a space in it.
	cout << "\n\n";
	cout << "Converter Toolkit\n";
	cout << "--------------------\n";
	cout << "1. Temperature Converter\n";
	cout << "2. Distance Converter\n";
	cout << "3. Weight Converter\n";
	cout << "4. Quit\n\n";
	cout << "Enter your choice (1-4): ";
	cin >> chosenNumber;

	if (chosenNumber == 1) //The = operator will assignt 1 to the chosenNumber instead of making it equal to 1
	{
		cout << "Please enter a temperature in celsius (such as 24): ";
		cin >> celciusTemparature;
		cout << "It is " << fixed << setprecision(0) << round (1.8 * celciusTemparature + 32) << " Fahrenheit."; // To have the result in an integer; if written (9/5), the computer will take it as an integer division
	}
	else if (chosenNumber == 2) //The = operator will assignt 2 to the chosenNumber instead of making it equal to 2
	{ 
		cout << "Please enter a distance in kilometer (such as 18.54) : ";
		cin >> kilometerDistance;

		if (kilometerDistance >=0)   //this statement has to come after entering the value of the kilometerDinstance
			                         //I can't use && here, because I needed to diplay an error message if the distance is negative
			cout << "It is " << fixed << setprecision(2) << kilometerDistance * 0.6 << " miles.\n";    //To have the number rounded up to 2 decimals
	
		else
			cout << "!!! Program does not convert negative distances !!!";
	}
	else if (chosenNumber == 3)  //The = operator will assignt 3 to chosenNumber instead of making it equal to 3
	{
		cout << "Please enter a weight in kilogram (such as 20): ";
		cin >> kilogramWeight;
		 
		if (kilogramWeight >=0)//
			cout << "It is " << fixed << setprecision(1) << kilogramWeight * 2.2 << " pounds.\n";  //To have the number rounded up to 1 decimal
		
		else
			cout << "!!! Program does not convert negative weight values !!!";
	}
	else if (chosenNumber == 4)
		cout << "Thank you for using this program!\nHave a great day!";

	else   //For any other numbers out of the range of {1,2,3,4}
	{
		cout << "ERROR !!! INVALID NUMBER !!!.\n";
		cout << "Please choose a whole number between 1 and 4 and run the program again.Thank you!";
	}

	cout <<endl << endl << countryName << " sounds fun!\n\n";
	cout << "Thank you for testing my program!!\n";
	cout << "PROGRAMMER: " << programmerName << endl;
	cout << "CMSC 140 Common Project 2 \n";
	cout << "Due Date: " << dueDate << endl << endl;

	system("pause");
	return (0);
}

	   
	    
	    
