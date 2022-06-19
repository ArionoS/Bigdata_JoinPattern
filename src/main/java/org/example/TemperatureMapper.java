package org.example;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TemperatureMapper extends Mapper<Object, Text, Text, Text> {
    public void map (Object key, Text value, Context context) throws IOException, InterruptedException{
        String txt = value.toString();
        String[] tokens = txt.split(",");
        String date = tokens[0];
        String id = tokens[1].trim();
        String temperature = tokens[2].trim();
        if (temperature.compareTo("Temperature") != 0 )
            context.write(new Text(id), new Text(temperature));
    }
}
