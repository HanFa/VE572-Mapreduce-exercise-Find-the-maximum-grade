import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class GradeReducer extends Reducer <Text,IntWritable,Text,IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        // Input: Shasta Neddo, 15,23,42,11
        // Output: Shasta Neddo, 42
        int max = 0;
        for (IntWritable value : values) {
            max = Math.max(value.get(), max);
        }
        context.write(key, new IntWritable(max));
    }
}
