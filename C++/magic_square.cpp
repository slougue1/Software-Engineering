//This is a program that simulates a magic square using 3 one dimensional parallel arrays of integer type.

#include <iostream>
#include <string>
using namespace std;
//Information about the project
const string programmerName = "Sakina Lougue",
dueDate = "August 18th, 2020";

// Global constants 
const int ROWS = 3,  // The number of rows in the array
COLS = 3,  // The number of columns in the array
MIN = 1,  // The value of the smallest number
MAX = 9;  // The value of the largest number

// Function prototypes
bool isMagicSquare(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size),
checkRange(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size, int min, int max),
checkUnique(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size),
checkRowSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size),
checkColSum(int arrayRow1[], int arrayRow2[], int arraRrow3[], int size),
checkDiagSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
void fillArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size),
showArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);

int main()
{
	int magicArray[ROWS][COLS];
	bool doLoopAgain = true;
	char playAgain = 'y';
	//Code goes here
	do
	{
		fillArray(magicArray[0], magicArray[1], magicArray[2], ROWS);
		showArray(magicArray[0], magicArray[1], magicArray[2], ROWS);
		if (!isMagicSquare(magicArray[0], magicArray[1], magicArray[2], ROWS))
		{
			cout << "This is not a Lo shu magic square" << endl;
		}
		else
		{
			cout << "This is a Lo shu magic square" << endl;
		}
		cout << endl << endl << "Do you want to try again? ";
		cin >> playAgain;

	} while (playAgain == 'y');

	cout << "\n\n\nThank you for testing my program!!";
	cout << "\nPROGRAMMER: " << programmerName;
	cout << "\nCMSC 140 Common Project 5";
	cout << "\nDue date: " << dueDate << endl << endl;

	system("pause");

	return 0;
}
// Function definitions
void fillArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size)
{
	cout << "Enter the number for row 0 and column 0: ";
	cin >> arrayRow1[0];
	cout << "Enter the number for row 0 and column 1: ";
	cin >> arrayRow1[1];
	cout << "Enter the number for row 0 and column 2: ";
	cin >> arrayRow1[2];
	cout << "Enter the number for row 1 and column 0: ";
	cin >> arrayRow2[0];
	cout << "Enter the number for row 1 and column 1: ";
	cin >> arrayRow2[1];
	cout << "Enter the number for row 1 and column 2: ";
	cin >> arrayRow2[2];
	cout << "Enter the number for row 2 and column 0: ";
	cin >> arrayRow3[0];
	cout << "Enter the number for row 2 and column 1: ";
	cin >> arrayRow3[1];
	cout << "Enter the number for row 2 and column 2: ";
	cin >> arrayRow3[2];
}


bool isMagicSquare(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size)
{
	if (!checkRange(arrayRow1, arrayRow2, arrayRow3, size, MIN, MAX) || !checkUnique(arrayRow1, arrayRow2, arrayRow3, size) ||
		!checkColSum(arrayRow1, arrayRow2, arrayRow3, size) || !checkRowSum(arrayRow1, arrayRow2, arrayRow3, size) ||
		!checkDiagSum(arrayRow1, arrayRow2, arrayRow3, size))
	{
		return false;
	}
	return true;
}
bool checkRange(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size, int min, int max)
{
	for (int counter = 0; counter < 3; counter++)
	{
		if (arrayRow1[counter]<min || arrayRow1[counter]>max)
		{
			return false;
		}
		if (arrayRow2[counter]<min || arrayRow2[counter]>max)
		{
			return false;
		}
		if (arrayRow3[counter]<min || arrayRow3[counter]>max)
		{
			return false;
		}
	}
	return true;
}

bool checkUnique(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size)
{
	for (int numberToFind = 1; numberToFind <= 9; numberToFind++)
	{
		bool hasCheckPassed = false;
		for (int column = 0; column < size; column++)
		{
			if (arrayRow1[column] == numberToFind || arrayRow2[column] == numberToFind || arrayRow3[column] == numberToFind)
			{
				hasCheckPassed = true;
				break;
			}
		}
		if (!hasCheckPassed)
		{
			return false;
		}
	}
	return true;
}
bool checkRowSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size)
// Calculating the sum of each row
{
	if (arrayRow1[0] + arrayRow1[1] + arrayRow1[2] != 15)
	{
		return false;
	}
	if (arrayRow2[0] + arrayRow2[1] + arrayRow2[2] != 15)
	{
		return false;
	}
	if (arrayRow3[0] + arrayRow3[1] + arrayRow3[2] != 15)
	{
		return false;
	}

	return true;
}
bool checkColSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size)
{
	if (arrayRow1[0] + arrayRow2[0] + arrayRow3[0] != 15)
	{
		return false;
	}
	if (arrayRow1[1] + arrayRow2[1] + arrayRow3[1] != 15)
	{
		return false;
	}
	if (arrayRow1[2] + arrayRow2[2] + arrayRow3[2] != 15)
	{
		return false;
	}
	return true;
}
bool checkDiagSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size)
{
	if (arrayRow1[0] + arrayRow2[1] + arrayRow3[2] != 15)
	{
		return false;
	}
	if (arrayRow1[2] + arrayRow2[1] + arrayRow3[0] != 15)
	{
		return false;
	}
	return true;
}
void showArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size)
{
	cout << arrayRow1[0] << " " << arrayRow1[1] << " " << arrayRow1[2] << endl;
	cout << arrayRow2[0] << " " << arrayRow2[1] << " " << arrayRow2[2] << endl;
	cout << arrayRow3[0] << " " << arrayRow3[1] << " " << arrayRow3[2] << endl;
}
