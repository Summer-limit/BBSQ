package com.nwnujsj.classtable.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import com.nwnujsj.classtable.R;

public class SpinerPopWindow<T> extends PopupWindow
{
  private LayoutInflater inflater;
  private MyAdapter mAdapter;
  private ListView mListView;
  private String[] termname;
  
  public SpinerPopWindow(Context context, String[] strings, AdapterView.OnItemClickListener listener)
  {
    super(context);
    this.inflater = LayoutInflater.from(context);
    this.termname = strings;
    init(listener);
  }
  
  private void init(AdapterView.OnItemClickListener clickListener) {
    View view = inflater.inflate(R.layout.personal_lookup_score, null);
    setContentView(view);
    setWidth(-1);
    setHeight(-1);
    setFocusable(true);
    setBackgroundDrawable(new ColorDrawable(0));
    mListView = view.findViewById(R.id.listview);
    mAdapter = new MyAdapter();
    mListView.setAdapter(mAdapter);
    mListView.setOnItemClickListener(clickListener);
  }
  
  private class MyAdapter extends BaseAdapter
  {

    @Override
    public int getCount() {
      return termname.length;
    }

    @Override
    public Object getItem(int position) {
      return null;
    }

    @Override
    public long getItemId(int position) {
      return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      if (convertView==null){
          convertView=inflater.inflate(R.layout.item_personal_lookup,null);
      }
      TextView tv_name = convertView.findViewById(R.id.tv_name);
      tv_name.setText(termname[position]);
      return convertView;
    }
  }

}