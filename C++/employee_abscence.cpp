/*
This program calculates the average number of days a company employees are absent
during the year and output a report on a file named "employeeAbsences.txt".
*/

#include <iostream>
#include <fstream>
#include <iomanip>
using namespace std;

//Functions' prototypes
int NumOfEmployees();              //this first function asks the user for the number of employees in the company.
                                   //The value should be returned as an int. The function accepts no arguments (No parameter/input)
int TotDaysAbscent(int, ofstream&);//This second fuction Asks the user to enter the employee number (ID), The number of days that employee was abscent
                                   //and also accepts an arguments of type int for the number of employees in the company and returns the total of missed days as an int.
double AverageAbscent(int, int);   //The third funtion calculates the average number of days absent.
int main()
{
	//Define variables
	int num_emp_data = 0;
	int num_days_data = 0;
	double avg_abs_data = 0.0;
	ofstream myfile;
	num_emp_data = NumOfEmployees(); //The first function's call
	myfile.open("employeeAbsences.txt");
	num_days_data = TotDaysAbscent(num_emp_data, myfile); //The second function's call
	myfile << endl << "The " << num_emp_data << " employees were absent for a total number of " << num_days_data << " days " << endl;
	avg_abs_data = AverageAbscent(num_emp_data, num_days_data); //The third function's call
	myfile << "The average number of days absent is: " << avg_abs_data << " days " << endl;
	myfile << endl;
	myfile << "Programmer: Sakina Lougue ";
	cout << "Programmer: Sakina Lougue" << endl;
	system("pause");
	return 0;
}
int NumOfEmployees()
{   //First function body
	int num_emp1;
	cout << "Calculate the average number of days a company's employee are absent " << endl;
	cout << endl << "Please enter the number of employees in the company : ";
	cin >> num_emp1;

	while (num_emp1 < 1)
	{
		cout << "The number of employees must not be negative and > 1.\n";
		cout << "Please re-enter the number of employees in the company : ";
		cin >> num_emp1;
	}
	return num_emp1;
}
int TotDaysAbscent(int e, ofstream& myfile)
{   //Second function body
	int num_emp1 = e;
	int num_days1;
	int total_days = 0;
	int id;
	if (myfile) {
		myfile << "EMPLOYEE ABSENCE REPORT " << endl;
		myfile << "employee id" << "\t" << "days absent" << endl;
	}
	for (int i = 0; i < num_emp1; i++)
	{
		cout << "Please enter an employee ID : ";
		cin >> id;
		cout << "Please enter the number of days this employee was absent : ";
		cin >> num_days1;
		while (num_days1 < 0)
		{
			cout << "The number of days must not be negative." << endl;
			cout << "Please re-enter the number of days this employee was absent : ";
			cin >> num_days1;
		}

		if (myfile) 
		{
			myfile << setw(8) << id << setw(12) << num_days1 << endl;
		}

		total_days += num_days1;
	}

	return total_days;
}
double AverageAbscent(int e, int d)

{   //Third function body
	int num_emp2 = e;
	int num_days2 = d;
	double avg_abs1;
	//Calculate the average number of days absent
	avg_abs1 = static_cast<double>(num_days2) / num_emp2;
	return avg_abs1;

}
