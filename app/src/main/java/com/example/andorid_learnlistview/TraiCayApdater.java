package com.example.andorid_learnlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayApdater extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayApdater(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        ImageView stt = view.findViewById(R.id.stt);
        TextView name = view.findViewById(R.id.name);
        TextView mota = view.findViewById(R.id.mota);

        TraiCay traiCay = traiCayList.get(i);

        stt.setImageResource(traiCay.getStt()); //"traiCay.getStt()"
        name.setText(traiCay.getTen());//"traiCay.getTen()"
        mota.setText(traiCay.getMota());//"traiCay.getMota()"

        return view;
    }
}
