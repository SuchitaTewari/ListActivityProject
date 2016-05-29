package project.suchita.com.surroundsyncproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SuchitaTewari on 5/16/16.
 */
public class CustomAdapter extends ArrayAdapter <ListItem> {

    private ArrayList<ListItem> listItems;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, int resource, ArrayList<ListItem> listItems) {
        super(context, resource);
        this.listItems = listItems;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public ListItem getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_content, null);
            holder = new ViewHolder();
            holder.taskView = (TextView) convertView.findViewById(R.id.task);
            holder.durationView = (TextView) convertView.findViewById(R.id.duration);
            holder.timeView = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        }else {
            holder =(ViewHolder)convertView.getTag();
        }

        ListItem current = listItems.get(position);
        holder.taskView.setText(current.getTaskName().toString());
        holder.durationView.setText(current.getTaskDuration().toString());
        holder.timeView.setText(current.getTaskTime().toString());
        return convertView;
    }
//


    static class ViewHolder {
      TextView taskView;
      TextView durationView;
      TextView timeView;
    }
}