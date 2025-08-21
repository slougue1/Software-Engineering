/**
 * @author Sakina Lougue
 * */
public class HolidayBonus extends java.lang.Object

{
	/**definition of the method calculateHolidayBonus
	  pass in a two dimensional ragged array of doubles,
	  bonus for high, bonus for low, and bouns for others.
	  and returns the an array of doubles which represents
	  the holiday bonuses for each of the stores in the district.
	  @param data -the two dimensional array of store sales
	  @param high -bonus for the highest store in a category
	  @param low -bonus for the lowest store in a category
	  @param other -bonus for all other stores in a category
	  @return holidayBonusPerStore -an array of the bonus for each store
	  
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high,
			double low, double other)
	{
		double[] holidayBonusPerStore = new double[data.length];
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				
				if(col<data.length && TwoDimRaggedArrayUtility.getHighestInColumn(data, col)==data[row][col]  && data[row][col] > 0) {
					holidayBonusPerStore[row] += high;
				}
				else if( col<data.length && TwoDimRaggedArrayUtility.getLowestInColumn(data, col)==data[row][col]  && data[row][col] > 0) {
					holidayBonusPerStore[row] += low;
					
				}else  if( col<data.length && data[row][col] > 0) {
					holidayBonusPerStore[row] += other;
					
				}
			}
		}
		return holidayBonusPerStore;	
	}
	
	/** definition of the method calculateTotalHolidayBonus
	 pass in a two dimensional ragged array of doubles,
	 bonus for high, bonus for low, and bouns for others.
	 returns a double which represents the total of all Holiday Bonuses for
	 the District.
	 @param data -the two dimensional array of store sales
	 @param high -bonus for the highest store in a category
	 @param low -bonus for the lowest store in a category
	 @param other -bonus for all other stores in a category
	 @return totalHoliday -the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data,
			double high, double low, double other)
	{
		double totalHoliday =0;
		double[] holidayBonusArr = calculateHolidayBonus(data, high, low, other);
		for (int i = 0; i < holidayBonusArr.length; i++) {
			totalHoliday += holidayBonusArr[i];
		}
		
		return totalHoliday;
	}
}