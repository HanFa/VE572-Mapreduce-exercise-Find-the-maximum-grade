import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GradeMapper extends Mapper <Object, Text, Text, IntWritable> {
    private BufferedReader reader;

    @Override
    protected void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        // Input: Shasta Neddo,0896728883,38
        // Output: Shasta Neddo, 38
        reader = new BufferedReader(new StringReader(value.toString()));
        String currentLine = reader.readLine();
        while (currentLine != null) {
            List<String> lineList = Arrays.asList(currentLine.split(","));
            context.write(new Text(lineList.get(0)), new IntWritable(Integer.parseInt(lineList.get(2))));
            currentLine = reader.readLine();
        }
        reader.close();
    }
}
