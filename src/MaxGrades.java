import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxGrades {

    private static final String INPUT = "input";
    private static final String OUTPUT = "output";

    public static void main(String[] args) throws Exception {
        // Mapreduce driver function
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "grade max");
        job.setJarByClass(MaxGrades.class);
        job.setMapperClass(GradeMapper.class);
        job.setCombinerClass(GradeReducer.class);
        job.setReducerClass(GradeReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(INPUT));
        FileOutputFormat.setOutputPath(job, new Path(OUTPUT));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
