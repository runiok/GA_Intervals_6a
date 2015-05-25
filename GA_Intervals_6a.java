/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ga_intervals_6a;

/**
 *
 * @author j
 */

import java.io.*;
import java.text.*;
import java.util.*;

class Input
{
    public Input()
    {
        
    }
    
    public Input(String file)
    {
        readfile(file);
    }
    
	public Vector readfile(String f)
	{
		try
		{
			File d = new File(f);
			FileReader filereader = new FileReader(d);
			BufferedReader reader = new BufferedReader(filereader);

			while( (line = reader.readLine()) != null )
			{
				file_input.add(line);
			}

			reader.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return file_input;
	}

	public double[] transfer(String choice)
	{
		String[][] main_array = new String[file_input.size()][];
		String line1 = null;
		double[] index = new double[file_input.size()-1];
                double[] index_modified = new double[file_input.size()-1];
		double[] close = new double[file_input.size()-1];
		double[] close_1 = new double[file_input.size()-1];
                double[] close_modified = new double[file_input.size()-1];
		double[] open = new double[file_input.size()-1];
		double[] open_1 = new double[file_input.size()-1];
                double[] open_modified = new double[file_input.size()-1];
		double[] high = new double[file_input.size()-1];
		double[] high_1 = new double[file_input.size()-1];
                double[] high_modified = new double[file_input.size()-1];
		double[] low = new double[file_input.size()-1];
		double[] low_1 = new double[file_input.size()-1];
                double[] low_modified = new double[file_input.size()-1];
		double[] volume = new double[file_input.size()-1];
		double[] volume_1 = new double[file_input.size()-1];
                double[] volume_modified = new double[file_input.size()-1];
		double[] month = new double[file_input.size()-1];
		double[] month_1 = new double[file_input.size()-1];
                double[] month_modified = new double[file_input.size()-1];
		double[] day_of_the_month = new double[file_input.size()-1];
		double[] day_of_the_month_1 = new double[file_input.size()-1];
                double[] day_of_the_month_modified = new double[file_input.size()-1];
		double[] year = new double[file_input.size()-1];
		double[] year_1 = new double[file_input.size()-1];
                double[] year_modified = new double[file_input.size()-1];
		double[] day_of_the_week = new double[file_input.size()-1];
		double[] day_of_the_week_1 = new double[file_input.size()-1];
                double[] day_of_the_week_modified = new double[file_input.size()-1];
		double[] days = new double[file_input.size()-1];
		double[] days_1 = new double[file_input.size()-1];
                double[] days_modified = new double[file_input.size()-1];
		double max_volume = 0;


		for(int i = 0; i < file_input.size() ; i++)
			{
				line1 = file_input.get(i).toString();
				main_array[i] = line1.split(",");
			}

		try
		{
/*
			for(int i = 0; i < file_input.size()-1 ; i++)
				System.out.println(main_array[i+1][0]);
*/
			SimpleDateFormat rdate = new SimpleDateFormat("M/d/yyyy");
			Date[] date1 = new Date[file_input.size()-1];
			GregorianCalendar cal = new GregorianCalendar();
			GregorianCalendar cal1 = new GregorianCalendar();
			GregorianCalendar cal2 = new GregorianCalendar();
/*
			for(int i = 0; i < file_input.size()-1 ; i++)
				date1[date1.length-i-1] = rdate.parse(main_array[i+1][0]);

			for(int i = 0; i < file_input.size()-1 ; i++)
				System.out.println(date1[i].getMonth());
*/
			for(int i = 0; i < file_input.size()-1 ; i++)
			{
				cal.setTime(rdate.parse(main_array[i+1][0]));
				month_1[i] = cal.get(cal.MONTH) + 1;
				day_of_the_month_1[i] = cal.get(cal.DAY_OF_MONTH);
				year_1[i] = cal.get(cal.YEAR);
				day_of_the_week_1[i] = cal.get(cal.DAY_OF_WEEK);
				days_1[i] = cal.getTimeInMillis()/(1000*60*60*24);
			}

			for(int i = 0; i < file_input.size()-1 ; i++)
			{
				month[i] = month_1[month_1.length - i - 1];
                                month_modified[i] = month_1[month_1.length - i - 1] / 12.0;
				day_of_the_month[i] = day_of_the_month_1[day_of_the_month.length - i - 1];
                                day_of_the_month_modified[i] = day_of_the_month_1[day_of_the_month.length - i - 1] / 31.0;
				year[i] = year_1[year.length - i - 1];
                                year_modified[i] = Math.log(Math.log(Math.log(year_1[year.length - i - 1])));
				day_of_the_week[i] = day_of_the_week_1[day_of_the_week.length - i - 1];
                                day_of_the_week_modified[i] = day_of_the_week_1[day_of_the_week.length - i - 1] / 7.0;
				days[i] = days_1[days.length - i - 1];
                                days_modified[i] = days_1[days.length - i - 1] / 30000.0;
			}
/*
			for(int i = 0; i < file_input.size()-1 ; i++)
				System.out.println(month[i] + " " + day_of_the_month[i] + " " + year[i] + " " + day_of_the_week[i] + " " + days[i]);
*/

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		if ( choice == "index" )
		{
			for(int i = 0; i < file_input.size()-1; i++)
                        {
                            index[i] = (i + 1.0);
                            index_modified[i] = (i + 1.0) / file_input.size();
                        }

			return index;
		}
		else if ( choice == "close" )
		{
			for(int i = 0; i < file_input.size()-1 ; i++)
				close_1[i] = Double.valueOf(main_array[i+1][6]).doubleValue();

			for(int i = 0; i < close.length ; i++)
				close[i] = close_1[close.length-i-1];
                        
                        for(int i = 0; i < close.length ; i++)
				close_modified[i] = Math.log(Math.log(Math.log(close_1[close.length-i-1])));

			return close;
		}
		else if ( choice == "open" )
		{
			for(int i = 0; i < file_input.size()-1 ; i++)
				open_1[i] = Double.valueOf(main_array[i+1][1]).doubleValue();

			for(int i = 0; i < open.length ; i++)
				open[i] = open_1[open.length-i-1];
                        
                        for(int i = 0; i < open.length ; i++)
				open_modified[i] = Math.log(Math.log(Math.log(open_1[open.length-i-1])));

			return open;
		}
		else if ( choice == "high" )
		{
			for(int i = 0; i < file_input.size()-1 ; i++)
				high_1[i] = Double.valueOf(main_array[i+1][2]).doubleValue();

			for(int i = 0; i < high.length ; i++)
				high[i] = high_1[high.length-i-1];
                        
                        for(int i = 0; i < high.length ; i++)
				high_modified[i] = Math.log(Math.log(Math.log(high_1[high.length-i-1])));

			return high;
		}
		else if ( choice == "low" )
		{
			for(int i = 0; i < file_input.size()-1 ; i++)
				low_1[i] = Double.valueOf(main_array[i+1][3]).doubleValue();

			for(int i = 0; i < low.length ; i++)
				low[i] = low_1[low.length-i-1];
                        
                        for(int i = 0; i < low.length ; i++)
				low_modified[i] = Math.log(Math.log(Math.log(low_1[low.length-i-1])));

			return low;
		}
		else if ( choice == "volume" )
		{
			for(int i = 0; i < file_input.size()-1 ; i++)
				volume_1[i] = Double.valueOf(main_array[i+1][5]).doubleValue();

			for(int i = 0; i < volume.length ; i++)
				volume[i] = volume_1[volume.length-i-1];

			for(int i = 0; i < volume.length; i++)
				max_volume = Math.max(volume[i], max_volume);

			for(int i = 0; i < volume.length; i++)
				volume_modified[i] = volume[i] / max_volume;

			return volume;
		}
		else if ( choice == "month" )
		{
			return month;
		}
		else if ( choice == "day_of_the_month" )
		{
			return day_of_the_month;
		}
		else if ( choice == "year" )
		{
			return year;
		}
		else if ( choice == "day_of_the_week" )
		{
			return day_of_the_week;
		}
		else if ( choice == "days" )
		{
			return days;
		}
		else
			System.out.println("Bad Choice");

		return null;
	}
	private
		Vector file_input = new Vector();
		String line = new String();
} // End of class Input

class SDP
{
    
    static final double TRADE_FRACTION_THRESHOLD = (1.0/3.0);
    static final double REVERSAL_PERCENTAGE = 3.0;
    static final int LINE_LIMIT_WRITE_OUT = 9000;
    static final int DAYS_BACK = 100;

    double[] close;
    
    double[] open_percent_change;
    double[] high_percent_change;
    double[] low_percent_change;
    double[] close_percent_change;
    String[] reversal;
    String[] trade;

    boolean top = true, bottom = true;
    int i, j, k, max_entry_number;
    int max_i = 0, min_i = 0;
    double curr_t = 0, max_t = 0, min_t = 0;

    String first_reversal;
    String second_reversal;
    double reversal_close_percent_change = 0;
    double trade_threshold;
    double reversal_to_threshold_sum;
    int second_reversal_index;
    
//    Input input = new Input();    

    SDP()
    {
        
    }
    
    SDP(Input input)
    {
        variableInstantiation( input.transfer("open"), input.transfer("high"), input.transfer("low"), input.transfer("close") );
        init();
        percentChange( input.transfer("open"), input.transfer("high"), input.transfer("low"), input.transfer("close") );
        reversals();
        trades();
    }
    
    public void variableInstantiation(double[] open, double[] high, double[] low, double[] close)
    {
        this.close = close;
        open_percent_change = new double[open.length];
        high_percent_change = new double[high.length];
        low_percent_change = new double[low.length];
        close_percent_change = new double[close.length];        
        reversal = new String[close.length];
        trade = new String[close.length];
    }

    public void init()
    {
        for( int i = 0; i < close.length; i++ )
        {
//                entry_number[i] = i;
            open_percent_change[i] = 0.0;
            high_percent_change[i] = 0.0;
            low_percent_change[i] = 0.0;            
            close_percent_change[i] = 0.0;
            reversal[i] = "N";
            trade[i] = "N";

//               trade_classification[i] = null;
        }
    }

    public void percentChange(double[] open, double[] high, double[] low, double[] close)
    {
        for( int i = 1; i < close.length - 1; i++ )
        {
                open_percent_change[i] = 100 * ( open[i] - open[i-1] ) / open[i-1];
                high_percent_change[i] = 100 * ( high[i] - high[i-1] ) / high[i-1];
                low_percent_change[i] = 100 * ( low[i] - low[i-1] ) / low[i-1];
                close_percent_change[i] = 100 * ( close[i] - close[i-1] ) / close[i-1]; 
        }
    }

    public void reversals()
    {
        for( int i = 0; i < reversal.length; i++ )
        {
                curr_t += close_percent_change[i];

                if( curr_t > max_t )
                {
                        max_i = i;
                        max_t = curr_t;
                }

                if( curr_t < min_t )
                {
                        min_i = i;
                        min_t = curr_t;
                }

                if( (( max_t - curr_t ) > SDP.REVERSAL_PERCENTAGE ) && top ) // Top Reversals
                {
                        reversal[max_i] = "3T";
                        trade[max_i] = "S";

                        min_i = i;

                        curr_t = curr_t - max_t;

                        min_t = curr_t;

                        max_t = 0;

                        top = false;
                        bottom = true;
                }

                if( (( min_t - curr_t ) < - SDP.REVERSAL_PERCENTAGE) && bottom ) // Bottom Reversals
                {
                        reversal[min_i] = "3B";
                        trade[min_i] = "B";

                        max_i = i;

                        curr_t = curr_t - min_t;

                        max_t = curr_t;

                        min_t = 0;

                        top = true;
                        bottom = false;
                }
        }
    } // End of reversals()

    public void trades()
    {
        String filepath_3 = "SDP_debug_0.txt";

        try
        {
            FileWriter fw1 = new FileWriter(filepath_3);
            BufferedWriter bw1 = new BufferedWriter(fw1);

//                System.out.println("reversal.length = " + reversal.length);

            for( i = 0; i < reversal.length; i++ )
            {

                        reversal_to_threshold_sum = 0;
                        first_reversal = "N";
                        second_reversal = "N";

//                            System.out.println("i = " + i + "    reversal[i] = " + reversal[i]);

                        if( !(reversal[i].equals("N")) )
                        {

                                first_reversal = reversal[i];
                                for( j = i+1; j < close.length; j++ )
                                        if( !(reversal[j].equals("N")) )
                                        {
                                            second_reversal_index = j;
                                            second_reversal = reversal[j];
                                            break;
                                        }

//                                    System.out.println( "\nfirst_reversal " + first_reversal + "   second_reversal " + second_reversal);
                                bw1.write(  "\r\nfirst_reversal " + first_reversal + "   second_reversal " + second_reversal);
        //			printf( "\nsec rev found: i %d   j %d\n", i, j);
//                                    System.out.println( "\ni " + i + "   second_reversal_index " + second_reversal_index + "    close[second_reversal_index] " + close[second_reversal_index] + "    close[i] " + close[i] + "\n" );
                                bw1.write( "    i " + i + "   second_reversal_index " + second_reversal_index + "    close[i] " + close[i] + "    close[second_reversal_index] " + close[second_reversal_index] + "\r\n" );

/*
                                if( close[second_reversal_index] - close[i] < 0 )
                                        System.out.println( "\n(nasdaq[second_reversal_index].close - nasdaq[i].close) < 0");

*/
                                reversal_close_percent_change = 100 * ( close[second_reversal_index] - close[i] ) / close[i];
/*
                                if( reversal_close_percent_change < 0 )
                                                System.out.println( "\n3T trade set: i " + i + "  j " + j + "   reversal_close_percent_change " + reversal_close_percent_change);
*/ 

                                trade_threshold = SDP.TRADE_FRACTION_THRESHOLD * reversal_close_percent_change;

                                for( int k = i+1; k < close.length; k++ )
                                {
                                        reversal_to_threshold_sum += close_percent_change[k];                              

/*                                        
                                            if( trade_threshold < 0 )
                                                    System.out.println( "\n3T trade set: i " + i + "   j " + j + "   reversal_to_threshold_sum " + reversal_to_threshold_sum + "   trade_threshold " + trade_threshold);
*/
                                            bw1.write( "\r\n entry_number.length = " + close.length + "   i = " + i + "   k = " + k + "   reversal_to_threshold_sum = " + reversal_to_threshold_sum + "   trade_threshold = " + trade_threshold +"\r\n" );
                                            if( first_reversal.equals("3B") && (reversal_to_threshold_sum < trade_threshold ) )
                                            {

                                                trade[k] = trade[i];
//                                                System.out.println( "3B: trade[k] = " + trade[k] + "   trade[i] = " + trade[i] );
                                                bw1.write( "\r\n3B: trade[k] = " + trade[k] + "   trade[i] = " + trade[i] +"\r\n" );
                                            }
                                            else if( first_reversal.equals("3T") && (reversal_to_threshold_sum > trade_threshold ) )
                                            {

                                                trade[k] = trade[i];
//                                                System.out.println( "3T: trade[k] = " + trade[k] + "   trade[i] = " + trade[i] );
                                                bw1.write( "\r\n3T: trade[k] = " + trade[k] + "   trade[i] = " + trade[i] +"\r\n" );
//                                                    System.out.println( "\n3T trade set: i " + i + "   j " + j + "   reversal_to_threshold_sum " + reversal_to_threshold_sum + "   trade_threshold " + trade_threshold);
                                            }
                                            else
                                                    break;


    //			printf( "\n"                                "inside second for: i %d   j %d\n", i, j);
                            } // End k loop

                            if( !(j >= reversal.length - 1) )
                            {
                                    i = second_reversal_index-1;
    //				strcpy(first_reversal, nasdaq[i].reversal);
                            }
                            else
                                    i = reversal.length;
                    } // End of Reversal if test                
            } // End of Threshold for loop
            bw1.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    } // End of trades()
    
    public int CPCLength()
    {
        return close_percent_change.length;
    }

} // End of class SDP

class PGPRNG
{
    //    #include "pgprng.h"
    //#include <time.h>
    //#include <math.h>

    static final double PI = 3.14159265359;
    //#define MAXUINT	4294967295
    static final int MAXUINT = 2147483647;

     int [] MT = new int[623];
     int index;
    // time_t t_seed;

     // Initialize the generator from a seed
    void initialize_generator(int seed) 
    {
             int i;

         index = 0;
         MT[0] = seed;
         for( i = 1; i < 623; i++ ) { // loop over each other element
             MT[i] = (1812433253 * (MT[i-1] ^ (MT[i-1]) >> 30) + i); //last 32 bits of  0x6c078965    right shift by 30 bits
         }
    }

     // Generate an array of 624 untempered numbers
    void generate_numbers()
     {
             int i;
             int y;

         for( i = 0; i< 623; i++ )
             {
             y = (MT[i] & 0x80000000) + (MT[(i+1) % 624] & 0x7fffffff); // bit 31 (32nd bit) of MT[i], bits 0-30 (first 31 bits) of MT[...], right shift by 1 bit

             MT[i] = MT[(i + 397) % 624] ^ (y >> 1);
             if ( (y % 2) != 0 )
                     { // y is odd
                 MT[i] = MT[i] ^ (0x9908b0df); //  2567483615
             }
         }
     }

     // Extract a tempered pseudorandom number based on the index-th value,
     // calling generate_numbers() every 624 numbers
    int extract_number()
     {
             int y;

         if ( index == 0 )
             {
             generate_numbers();
         }

         y = MT[index];
         y = y ^ (y >> 11);  // right shift by 11 bits
         y = y ^ ((y << 7) & (0x9d2c5680)); //  2636928640  left shift by 7 bits
         y = y ^ ((y << 11) & (0xefc60000)); //  4022730752  left shift by 15 bits
         y = y ^ (y >> 18); //   right shift by 18 bits

         index = (index + 1) % 624;
         return y;
     }

    void pgprng_init()
    {
            index = 0;

//            time( &t_seed );
//            initialize_generator(t_seed);
    }

    double p_gaussian()
    {
//            unsigned int y;
            int y;            
            double z, theta, g;

            y = extract_number();
            z = 2.0 * y / (double)MAXUINT - 1.0;
            theta = z * PI / 2.0;
            g = Math.tan( theta );

            return g;
    }
} // End of class 

class Ziggurat
{
    static final int ZSIZE = 256;
    static final double INTERVALFACTOR = 0.75;
    static final double INV_RAND_MAX = 0.000030518509476;
    
    double [] zig = new double [ZSIZE];
    
    void ziggurat_init()
    {
        int i;

        for( i = 0; i < ZSIZE; i++ )
        {
                zig[i] = INTERVALFACTOR * Math.sqrt( -Math.log( i / (double)ZSIZE ) );
        }
    }
    
    double rand_zig()
    {
            int layer;
//          int i, r;
            
            double r, x;
            
            r = Math.random();

            layer = (int)(Math.random() * Integer.MAX_VALUE) % ( ZSIZE - 1 );

            for( int i = 10; --i > 0; )
            {
//                    r = rand();
                    r = Math.random();                
                    x = zig[layer] * r;

                    if ( x < zig[layer+1] )
                            if( (int)(r * Integer.MAX_VALUE) % 2 == 0 )
                                    return x;
                            else
                                    return -x;

                    if( layer == 0 )
                            return r * Integer.MAX_VALUE;
            }

            return zig[layer+1] * r;
    }
    
    
} // End of class Ziggurat

public class GA_Intervals_6a {

    /**
     * @param args the command line arguments
     */
    
    static final int GENERATIONS = 10;
    static final int BSIZE = 1;
    static final int CSIZE = 10;
    static final int ESIZE = 1;
    static final int PSIZE = 10000;
    static final int ZSIZE = 256;
    static final int ESTART = 0;
    static final int SHIFTNUMBER = 200;
    static final double INTERVALFACTOR = 0.75;
    static final double	CROSSOVERALPHA = 0.25;
    static final double	MUTATIONALPHA = 1;
    static final double	INV_RAND_MAX = 0.000030518509476;
    static final double	PIo2 = 1.570796326795;
    static final double	PI = 3.14159265359;
//    static final String sm_data = "nasdaq";

    char c;

    int data_size;
    int max_value;
    int [][] buy_evaluations = new int[PSIZE][ESIZE];
    int [][] assignments = new int[2][PSIZE];
    int [] best_relative_score = new int [2];
    int crossover_count;
    int mutation_count;

    double rand_factor;
    double rand_lower, rand_upper;
    double neg_inv_gen;
    double inv_max_value;

    double [] zig = new double[ZSIZE];

    double [][] sm_data;
    double [][][] population = new double[PSIZE][CSIZE][2];
    double [][][] best_individuals = new double[BSIZE][CSIZE][2];
    double [][] best_individuals_data = new double[BSIZE][4];
    double [] best_absolute_score = new double[2];

//    time_t seed;

//    File* fd1;
    String fd1;
    String fd2;
    String fd3;    
    
    static Input input = new Input("nasdaq_7_28_10.csv");
    static SDP sdp = new SDP(input);
    PGPRNG pgprng = new PGPRNG();
    Ziggurat ziggurat = new Ziggurat();
    
    void rand_factor_init()
    {
	rand_factor = PI * INV_RAND_MAX;
    }
    
    void buy_evaluations_init()
    {
	int i;

	for( i = 0; i < PSIZE; i++ )
		buy_evaluations[i][0] = 0;	
    }
    
    void assignments_init()
    {
	int i;

	for( i = 0; i < PSIZE; i++ )
	{
		assignments[0][i] = -1;
		assignments[1][i] = -1;
	}
    }
    
    void population_init()
    {
	int i, j;
	double r_temp;
        
        StringBuilder main_sb = new StringBuilder("");
        
        Random random = new Random();

	for( i = 0; i < PSIZE; i++ )
	{
		for( j = 0; j < CSIZE; j++ )
		{
//			rand_lower = pgprng.p_gaussian()*INTERVALFACTOR;
//			rand_upper = pgprng.p_gaussian()*INTERVALFACTOR;
                        
			rand_lower = random.nextGaussian()*INTERVALFACTOR;
			rand_upper = random.nextGaussian()*INTERVALFACTOR;                        

			if( rand_lower > rand_upper )
			{
				r_temp = rand_upper;
				rand_upper = rand_lower;
				rand_lower = r_temp;
			}

			population[i][j][0] = rand_lower;
			population[i][j][1] = rand_upper;
		}
                
//		main_sb += String.format(fd1, "individual number: %d\n", i );
		main_sb.append(String.format("\nindividual number: %d\r\n", i ));
		main_sb.append(String.format("rand_upper: "));
                
		for( j = 0; j < CSIZE; j++ )
		{
//			printf("rand_lower: %f     rand_upper: %f\n", rand_lower, rand_upper );
			main_sb.append(String.format("%f ", population[i][j][1] ));
		}
		main_sb.append(String.format("\r\n"));
		main_sb.append(String.format("rand_lower: "));
		for( j = 0; j < CSIZE; j++ )
		{
//			printf("rand_lower: %f     rand_upper: %f\n", rand_lower, rand_upper );
			main_sb.append(String.format("%f ", population[i][j][0]));
		}
		main_sb.append(String.format( "\r\n"));
 
 
	} // End of for( i = 0; i < PSIZE; i++ )
        
        try
        {
            FileWriter fw = new FileWriter(fd1);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.append(main_sb);
            
            bw.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

    } // End of void population_init()
    
    void population_final()
    {
	int i, j;
//	double r_temp;
        
        fd2 = "ga_population_final.txt";
        
        StringBuilder main_sb = new StringBuilder("");

	main_sb.append(String.format("\n\nPopulation Final:\r\n" ));

	for( i = 0; i < PSIZE; i++ )
	{
//		main_sb += String.format(fd1, "individual number: %d\n", i );
		main_sb.append(String.format("\nindividual number: %d\r\n", i ));
		main_sb.append(String.format("rand_upper: "));
		for( j = 0; j < CSIZE; j++ )
		{
//			printf("rand_lower: %f     rand_upper: %f\n", rand_lower, rand_upper );
			main_sb.append(String.format("%f ", population[i][j][1] ));
		}
		main_sb.append(String.format("\r\n"));
		main_sb.append(String.format("rand_lower: "));
		for( j = 0; j < CSIZE; j++ )
		{
//			printf("rand_lower: %f     rand_upper: %f\n", rand_lower, rand_upper );
			main_sb.append(String.format("%f ", population[i][j][0]));
		}
		main_sb.append(String.format("\r\n"));
	} // End of for( i = 0; i < PSIZE; i++ )
        
        try
        {
            FileWriter fw = new FileWriter(fd2);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.append(main_sb);
            
            bw.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        
    } // End of void population_final()
    
    void init()
    {
        Ziggurat ziggurat = new Ziggurat();
        
            
//	fd1 = fopen("ga_intervals_debugging_output.txt", "w");
	fd1 = "ga_intervals_debugging_output.txt";        
//	time(&seed);
//	srand( (unsigned int)seed);
	ziggurat.ziggurat_init();
	rand_factor_init();
//	smdrpw();
	pgprng.pgprng_init();
	buy_evaluations_init();
	assignments_init();
	population_init();
//	population_final();

	neg_inv_gen = (-1 / (double)GENERATIONS);
//	data_size = max_entry_number;

	best_relative_score[0] = 1;
	best_relative_score[1] = -1;
	best_absolute_score[0] = 0;
	best_absolute_score[1] = -1;

	crossover_count = 0;
	mutation_count = 0;
    }
    
    void buy_evaluation( int datasize )
    {
            boolean f, y;
            int d, i, j, k, v;
            int d_shift;

    //	printf( " sm_data[d_shift].close_percent_change: %f     d_shift: %d\n", sm_data[d_shift].close_percent_change, d_shift );

            if( SHIFTNUMBER + ESTART < datasize )
                    for( d = ESTART; d < SHIFTNUMBER + ESTART; d++ )
                            for( i = 0; i < PSIZE; i++ )
                            {
                                    v = 0;
//                                    f = 0;
//                                    y = 1;
                                    f = false;
                                    y = true;                                    
                                    d_shift = d;

                                    for( j = 0, k = d_shift; j < CSIZE && k + CSIZE < datasize && k < SHIFTNUMBER + d_shift; j++, k++ )
                                    {
                                            if( sdp.close_percent_change[k] < population[i][j][0] || sdp.close_percent_change[k] > population[i][j][1] )
                                            {
                                                    f = false;
                    //				printf( " if; interval test: i: %d     j: %d     k: %d     f:%d    data: %f     d_shift: %d     pop0: %f     pop1: %f\n", i, j, k, f, sm_data[k].close_percent_change, d_shift, population[i][j][0], population[i][j][1] );
                    //				fprintf(fd1,  " if; interval test: i: %d     j: %d     k: %d     f:%d     d_shift: %d     pop0: %f    data: %f     pop1: %f\n", i, j, k, f, d_shift, population[i][j][0], sm_data[k].close_percent_change, population[i][j][1] );
                                                    break;
                                            }
                                            else
                                            {
                                                    f = true;
                    //				printf( " else; interval test: i: %d     j: %d     k: %d     f:%d     data: %f     d_shift: %d     pop0: %f     pop1: %f\n", i, j, k, f, sm_data[k].close_percent_change, d_shift, population[i][j][0], population[i][j][1] );
                    //				fprintf(fd1,  " else; interval test: i: %d     j: %d     k: %d     f:%d     d_shift: %d     pop0: %f      data: %f    pop1: %f\n", i, j, k, f, d_shift, population[i][j][0], sm_data[k].close_percent_change, population[i][j][1] );
                                            }
                                    }

                    //		printf( " sm_data[CSIZE + d_shift].reversal: %s     CSIZE + d_shift: %d     data_size: %d     max_value: %d\n", sm_data[CSIZE + d_shift].reversal, CSIZE + d_shift, data_size, max_value );
                    //		fprintf(fd1,  " sm_data[CSIZE + d_shift].reversal: %s     CSIZE + d_shift: %d     data_size: %d     max_value: %d\n", sm_data[CSIZE + d_shift].reversal, CSIZE + d_shift, data_size, max_value );

                                    if( CSIZE + d_shift < datasize )
                                            if( sdp.reversal[CSIZE + d_shift].equals( "3B" ) )
                                            {
                                                    v = 20;
                    //				printf( " sm_data[CSIZE + d_shift].reversal: %s     y: %d     v: %d     max_value: %d\n", sm_data[CSIZE + d_shift].reversal, y, v, max_value );
                    //				fprintf(fd1, " sm_data[CSIZE + d_shift].reversal: %s     y: %d     v: %d     max_value: %d\n", sm_data[CSIZE + d_shift].reversal, y, v, max_value );
                                            }
                                            else if( sdp.trade[CSIZE + d_shift].equals( "B" ) )
                                            {
                                                    v = 3;
                    //				printf( " sm_data[CSIZE + d_shift].trade: %s     y: %d     v: %d     max_value: %d\n", sm_data[CSIZE + d_shift].trade, y, v, max_value );
                    //				fprintf(fd1, " sm_data[CSIZE + d_shift].trade: %s     y: %d     v: %d     max_value: %d\n", sm_data[CSIZE + d_shift].trade, y, v, max_value );
                                            }
                                            else
                                            {
                                                    y = false;
                                                    v = 1;
                    //				printf( " else: %s     y: %d     v: %d     max_value: %d\n", "inside buy_evaluation", y, v, max_value );
                    //				fprintf(fd1, " else: %s     y: %d     v: %d     max_value: %d\n", "inside buy_evaluation", y, v, max_value );
                                            }

             //                       if( !i )
                                    if( i == 0 )
                                            max_value += v;

//                                    buy_evaluations[i][0] += v * ( f*y || !f*!y );
                                    
                                    if( (f && y) || (!f && !y) )
                                        buy_evaluations[i][0] += v;
                                    
                    //		fprintf(fd1, " i: %d     max_value: %d     buy_evaluations[i][0]: %d     v: %d     f: %d     y: %d\n", i, max_value, buy_evaluations[i][0], v, f, y );
                            } // End of for( i = 0; i < PSIZE; i++ )
            else
                    System.out.println( "\r\nSHIFTNUMBER + ESTART greater or equal to datasize\r\n" );

            inv_max_value = 1.0 / (double)max_value;
    } // End of void buy_evaluation( int datasize )
    
    void assign(int generation)
    {
            int a, b, i;

            a = 0; b = 0;

            for( i = 0; i < PSIZE; i++ )
            {
                    if( best_relative_score[0] < buy_evaluations[i][0] )
                    {
                            best_relative_score[0] = buy_evaluations[i][0];
                            best_relative_score[1] = i;
                            best_absolute_score[0] = buy_evaluations[i][0] * inv_max_value;
                            best_absolute_score[1] = i;
                            
                            for( int c = 0; c < CSIZE; c++)
                            {
                                best_individuals[0][c][0] = population[i][c][0];
                                best_individuals[0][c][1] = population[i][c][1];
                            }
                            
                            best_individuals_data[0][0] = best_relative_score[0];
                            best_individuals_data[0][1] = best_absolute_score[0];
                            best_individuals_data[0][2] = generation;
                            best_individuals_data[0][3] = i;
                    }

    //		if( (buy_evaluations[i][0] / (double)max_value) > (rand() / (double)RAND_MAX) )
//                    if( crossover_probability(i) > (rand() * INV_RAND_MAX ) )
                    if( crossover_probability(i) > ( Math.random() ) )                        
                    {
                            assignments[0][a] = i; // crossover
                            a++;
                    }
                    else
                    {
                            assignments[1][b] = i; // crossover replacement
                            b++;
                    }

            }
    } //End of void assign()
    
    double crossover_probability( int pop_index )
    {
            double cp;

    //	fprintf(fd1,  "buy_evaluations[pop_index][0]: %d     (double)best_relative_score[0]: %f\n", buy_evaluations[pop_index][0], (double)best_relative_score[0] );

    //	cp = CROSSOVERALPHA * (buy_evaluations[pop_index][0] / (double)best_relative_score[0]) + (1-CROSSOVERALPHA) * (buy_evaluations[pop_index][0] / (double)max_value);
            cp = CROSSOVERALPHA * (buy_evaluations[pop_index][0] / (double)best_relative_score[0]) + (1-CROSSOVERALPHA) * buy_evaluations[pop_index][0] * inv_max_value;

    //	printf( "generation: %d     individual: %d     mutation probability: %f\n", gen, pop_index, mp );
    //	fprintf(fd1,  "individual: %d     crossover probability: %f\n", pop_index, cp );

            return cp;
    }
    
    void crossover( int gen_index )
    {
            int a, j;

            for( a = 0; assignments[0][a+1] != -1 && assignments[1][a+1] != -1  && a+1 < PSIZE; a +=2 )
            {
                    for( j = 0; j < CSIZE; j++ )
                            if( j < CSIZE / 2.0 )
                            {
                                    population[assignments[1][a]][j][0] = population[assignments[0][a]][j][0];
                                    population[assignments[1][a+1]][j][0] = population[assignments[0][a+1]][j][0];
                                    population[assignments[1][a]][j][1] = population[assignments[0][a]][j][1];
                                    population[assignments[1][a+1]][j][1] = population[assignments[0][a+1]][j][1];
                            }
                            else
                            {
                                    population[assignments[1][a]][j][0] = population[assignments[0][a+1]][j][0];
                                    population[assignments[1][a+1]][j][0] = population[assignments[0][a]][j][0];
                                    population[assignments[1][a]][j][1] = population[assignments[0][a+1]][j][1];
                                    population[assignments[1][a+1]][j][1] = population[assignments[0][a]][j][1];
                            }

                            buy_evaluations[assignments[1][a]][0] = buy_evaluations[assignments[0][a]][0];
                            buy_evaluations[assignments[1][a+1]][0] = buy_evaluations[assignments[0][a+1]][0];

                            if( gen_index == GENERATIONS /2 )
                                    ++crossover_count;

    //	printf("crossver between %d and %d     replacement of %d and %d\n", assignments[0][a], assignments[0][a+1], assignments[1][a], assignments[1][a+1]);
    //	fprintf(fd1,"crossver between %d and %d     replacement of %d and %d\n", assignments[0][a], assignments[0][a+1], assignments[1][a], assignments[1][a+1]);
            }
    } // End of void crossover( int gen_index )
    
    double mutation_probability_1( int pop_index, int gen, double neg_inv_generations )
    {
            double mp;

    //	mp = (1-buy_evaluations[pop_index][0] / (double)max_value)  * sqrt(sqrt( 1 / log( (double)gen ) ) );
            mp = ( (1-buy_evaluations[pop_index][0] * inv_max_value)  * (neg_inv_generations * gen + 1) );

    //	printf( "generation: %d     individual: %d     mutation probability: %f\n", gen, pop_index, mp );
    //	fprintf(fd1,  "generation: %d     individual: %d     mutation probability: %f\n", gen, pop_index, mp );

            return mp;
    }

    double mutation_probability_2( int pop_index, int gen )
    {
            double mp;

    //	mp = (1-buy_evaluations[pop_index][0] / (double)max_value)  *  sqrt(sqrt( 1 / log( (double)gen ) ) );
            mp = 1-buy_evaluations[pop_index][0] * inv_max_value;

            return mp;
    }
    
    void mutate( int gen_index, double rnd_factor )
    {
            int i, j;
            
            Random random = new Random();

            for( i = 0; i < PSIZE; i++ )
    //		if( mutation_probability_1(i, generation) > (rand() / (double)RAND_MAX) )
//                    if( RAND_MAX * mutation_probability_1(i, gen_index, neg_inv_gen) > rand() )
                    if( mutation_probability_1(i, gen_index, neg_inv_gen) > Math.random() )                    
                    {

                            if( gen_index == GENERATIONS /2 )
                                    ++mutation_count;

    //			printf("mutation of %d at intervals: ",i);
    //			fprintf(fd1, "mutation of %d at intervals: ",i);
                            for( j = 0; j < CSIZE; j++ )
    //				if( mutation_probability_2(i, generation)  > (rand() / (double)RAND_MAX) )
//                                    if( RAND_MAX * mutation_probability_2(i, gen_index)  > rand() )
    //				if( (1-buy_evaluations[i][0] / (double)max_value)  > (rand() / (double)RAND_MAX) )
                                    if( mutation_probability_2(i, gen_index)  > Math.random() )                                
                                    {
    //					population[i][j][0] = p_gaussian();
    //					population[i][j][1] = p_gaussian();
    //					population[i][j][0] = rand_zig();
    //					population[i][j][1] = rand_zig();
//                                            if( gen_index % 10 )
                                            if( gen_index % 10 != 0 )                                                
                                            {
    //						population[i][j][0] = tan( rnd_factor * rand() - PIo2 );
    //						population[i][j][1] = tan( rnd_factor * rand() - PIo2 );
                                                    population[i][j][0] = ziggurat.rand_zig();
                                                    population[i][j][1] = ziggurat.rand_zig();
                                            }
                                            else
                                            {
//                                                    population[i][j][0] = p_gaussian();
//                                                    population[i][j][1] = p_gaussian();
                                                    population[i][j][0] = random.nextGaussian();
                                                    population[i][j][1] = random.nextGaussian();                                                    
                                            }

    //				printf("%d ",j);
    //				fprintf(fd1, "%d ",j);
                                    }
    //			printf("\n");
    //			fprintf(fd1, "\n");
                    }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int d, i, j;
        int g = 0;
//	time_t start, stop, time_interval;
	long start, stop, time_interval;        
        
        GA_Intervals_6a ga6a = new GA_Intervals_6a();
        ga6a.init();
        ga6a.buy_evaluation( sdp.CPCLength() );
        ga6a.assign(g);
        ga6a.crossover( 0 );
        ga6a.mutate( 0, 0 );
        
//	init();
/*
	for( i = 0; i < PSIZE; i++ )
		for( j = 0; j < CSIZE; j++ )
		{
			printf( "%f     %f\n", population[i][j][0], population[i][j][1] );
		}
*/
//	start = clock();
        start = System.currentTimeMillis();
	for( g = 0; g < GENERATIONS; g++ )
	{
//	printf( "Start of generation %d\n", g );
//	fprintf(fd1,  "\nStart of generation %d\n", g );

//	population_final();
		ga6a.max_value = 0;
		ga6a.buy_evaluations_init();
		ga6a.assignments_init();


//	population_final();
//		if( SHIFTNUMBER + ESTART < data_size )
//			for( d = ESTART; d < SHIFTNUMBER + ESTART; d++ )
		ga6a.buy_evaluation( sdp.CPCLength() );
		ga6a.assign(g);
		ga6a.crossover(g);
//		ga6a.mutate(g, ga6a.rand_factor);

//	printf( "\n" );
//	fprintf(fd1,  "\n" );
/*
	for( i = 0; i < PSIZE; i++ )
	{
		printf( "%d ", buy_evaluations[i][0] );
		fprintf(fd1,  "%d ", buy_evaluations[i][0] );
	}
*/
//	printf( "\n" );
//	fprintf(fd1,  "\n" );

//		printf( "\n%s     %d\n", "max_value", max_value );
//		printf( "\n%s     %d     %f     %d,  %f\n", "relative and absolute best scores and index", best_relative_score[0], best_absolute_score[0], best_relative_score[1], best_absolute_score[1] );
                
	} // End of for( g = 0; g < GENERATIONS; g++ )
        
//	stop = clock();
        stop = System.currentTimeMillis();
//	time_interval = ( stop - start ) / CLOCKS_PER_SEC;
	time_interval = ( stop - start ) / 1000;        

/*
	for( i = 0; i < PSIZE; i++ )
	{
//		printf( "%d\n", buy_evaluations[i][0] );
		fprintf(fd1,  "%d\n", buy_evaluations[i][0] );
	}
*/
	ga6a.population_final();
        
        try
        {
            FileWriter fwMain1 = new FileWriter("ga_counts_scores_time.txt");
            BufferedWriter bwMain1 = new BufferedWriter(fwMain1);
            
            System.out.println( String.format("\r\ncrossover_count %d     mutation_count %d\r\n\r\n", ga6a.crossover_count, ga6a.mutation_count) );
            bwMain1.write( String.format("\r\ncrossover_count %d     mutation_count %d\r\n\r\n", ga6a.crossover_count, ga6a.mutation_count) );
            System.out.println( String.format("\r\n%s     %d     %f     %d,  %f      time_interval: %f\r\n", "\nfinal relative and absolute best scores and index\n", ga6a.best_relative_score[0], ga6a.best_absolute_score[0], ga6a.best_relative_score[1], ga6a.best_absolute_score[1], (double)time_interval ) );
            bwMain1.write( String.format("\r\n%s     %d     %f     %d,  %f      time_interval: %f\r\n", "\nfinal relative and absolute best scores and index\n", ga6a.best_relative_score[0], ga6a.best_absolute_score[0], ga6a.best_relative_score[1], ga6a.best_absolute_score[1], (double)time_interval ) );
            
            bwMain1.write( String.format("\r\n%s\r\n", "Best Individuals:") );
            for(int b = 0; b < BSIZE; b++)
            {
                for(int c = 0; c < CSIZE; c++)
                {
                    bwMain1.write(String.format("%f   ", ga6a.best_individuals[b][c][0]) );
                }
                bwMain1.write("\r\n");
                for(int c = 0; c < CSIZE; c++)
                {
                    bwMain1.write(String.format("%f   ", ga6a.best_individuals[b][c][1]) );
                }
                bwMain1.write("\r\n");
                bwMain1.write(String.format("\r\n%s\r\n", "best_individuals data:") );
                bwMain1.write(String.format("\r\n%s%f %s%f %s%f %s%f   ", "best_relative_score: ", ga6a.best_individuals_data[b][0], "   best_absolute_score: ", ga6a.best_individuals_data[b][1] , "   generation: ", ga6a.best_individuals_data[b][2], "   index: ", ga6a.best_individuals_data[b][3]  ) );
            }
            
            bwMain1.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    } // End of main()
} // End of GA_Intervals_6
