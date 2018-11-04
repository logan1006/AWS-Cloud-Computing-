import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TeraSortHadoopMapper extends Mapper<LongWritable, Text, Text, Text>

{
	//define objects for key and value of map output
	private Text mapKey = new Text();
	private Text mapValue = new Text();
	@Override
	public void map(LongWritable key, Text value, Context context)
		throws IOException, InterruptedException
	{
				
		String[] split = null;
		String line = value.toString();
		split = line.split("\\n"); //splitting on the basis of new line character
		for ( int i=0; i < split.length; i++)
		{
			mapKey.set(split[i].substring(0, 10)); //assigning key as first 10 characters of line
			mapValue.set(split[i].substring(10)); //assigning value as remaining characters of line
			context.write(mapKey, mapValue); //write on mapper context
		}
	}
}
