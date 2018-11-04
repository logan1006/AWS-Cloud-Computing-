import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;;

public class TeraSortHadoopReducer extends Reducer<Text, Text, Text, Text>
{	
	//Reducer here is just used to make the data go through shuffle and sort stage to get sorted output
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{
		
		Text finalValue = null ;
		for(Text value : values)
		{
			finalValue = value; //assigning input to output of reducer
		}
		context.write(key, finalValue); //writing values to context
	}
		
}
