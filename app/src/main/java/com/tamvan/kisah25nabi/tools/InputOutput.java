package com.tamvan.kisah25nabi.tools;

import android.content.Context;

import com.tamvan.kisah25nabi.holder.Story;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rofie on 10/29/2016.
 */
public class InputOutput {

    public List<Story> ReadDataAllFromAsset(Context context) throws IOException{
        List<Story> dataStory = new ArrayList<>();
        String[] listFile = context.getAssets().list("story");
        for (String data:listFile) {
            InputStreamReader is = new InputStreamReader(context.getResources().getAssets().open("story/"+data));
            BufferedReader br = new BufferedReader(is);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine())!=null){
                sb.append(line).append('\n');
            }
            Story st = new Story();
            String[] fileName = data.split("\\.");
            st.set_title(fileName[0]);
            st.set_contents(sb.toString());
            dataStory.add(st);
            is.close();
        }
        return dataStory;
    }
}
