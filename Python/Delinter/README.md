Delinting function that provides suggestions about using inclusive language:
•	Partial matches not trigger a notice (e.g. bayou guys not trigger the you_guys delinter rule)
•	Matches is case insensitive
•	Use the notice function from Part 2 to output a notice each time I find non-inclusive language
•	Each notice include the index of the first character of the non-inclusive language within the text
•	Multiple notices are displayed in ascending order by index
•	If multiple notices are needed connect them with a new line character \n
•	If no notices are displayed it return an empty string ""
