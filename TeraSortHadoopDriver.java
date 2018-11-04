
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class TeraSortHadoopDriver extends Configured implements Tool
{
	@Override
	public int run(String[] args) throws Exception
	{
				
		//check input parameters for file paths
		if(args.length != 2)
		{
			System.err.println("Input file path or output file path missing");
			System.exit(-1);
		}
		
		//create new job
		@SuppressWarnings("deprecation")
		Job job = new Job();
		job.setJarByClass(TeraSortHadoopDriver.class);
		job.setJobName("Tera Sort");
		
		// get input and output files
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//assign mapper and combiner class
		job.setMapperClass(TeraSortHadoopMapper.class);
		job.setCombinerClass(TeraSortHadoopReducer.class);
		
		//assign reducer class		
		job.setReducerClass(TeraSortHadoopReducer.class);
		
		//define Reducers output data types
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		//submit job and wait for completion
		return job.waitForCompletion(true) ? 0 : 1;
	}
	
	//main method
	public static void main(String[] args) throws Exception
	{	
		//ToolRunner to run the code
		int exitCode = ToolRunner.run(new Configuration(), new TeraSortHadoopDriver(), args);
		System.exit(exitCode);		
			
	}
}
