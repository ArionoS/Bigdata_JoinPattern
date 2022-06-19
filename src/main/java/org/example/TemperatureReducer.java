package org.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TemperatureReducer extends Reducer<Text, Text, Text, IntWritable> {
    private final IntWritable result = new IntWritable();
    private Text cityName = new Text("Unknown");
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        int n = 0;
//    cityName = new Text( "city" + key.toString());
        for (Text val : values) {
            String strVal = val.toString();
            if (strVal.length() <= 3) {
                sum += Integer.parseInt(strVal);
                n += 1;
            } else {
                cityName = new Text(strVal);
            }
        }

//        if (n == 0) n = 1;
//        result.set(sum / n);
//        context.write(cityName, result);

        // inner join
//        if (n != 0 && cityName.toString().compareTo("Unknown") != 0) {
//            result.set(sum / n);
//            context.write(cityName, result);
//        }

        // left anti join
//            if (n==0){
//                if (n==0)n=1;
//                result.set(sum/n);
//                context.write(cityName,result);
//             }

        // left outer join
//             if (cityName.toString().compareTo("Unknown") != 0) {
//                 if (n == 0) n = 1;
//                 result.set(sum/n);
//                 context.write(cityName, result);
//             }

        // right outer join
//             if(n != 0){
//                 result.set(sum/n);
//                 context.write(cityName, result);
//             }

        // full outer join
             if (n == 0) n=1;
             result.set(sum/n);
             context.write(cityName, result);
        }
    }

