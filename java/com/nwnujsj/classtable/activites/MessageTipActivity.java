package com.nwnujsj.classtable.activites;/*
package com.example.tableofclass.activites;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.example.tableofclass.domain.MessageTipsBean;
import com.example.tableofclass.utils.ButtonUtils;
import java.io.PrintStream;
import java.util.ArrayList;

public class MessageTipActivity
  extends Activity
{
  private static ArrayList<MessageTipsBean> lists = new ArrayList();
  private Myadapter adapter;
  private AlertDialog addMessage;
  private Button btn_add_event;
  private SQLiteDatabase db;
  private ListView lv_message_addtips;
  private MessageTipsEventSqlite messageTipsEventSqlite;
  
  private void addData(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("eventname", paramString1);
    localContentValues.put("eventtime", paramString2);
    paramSQLiteDatabase.insert("messagetips", null, localContentValues);
  }
  
  private void deleteData(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.delete("messagetips", "eventname=?", new String[] { paramString });
  }
  
  private void getDataBase()
  {
    Cursor localCursor = db.query("messagetips", null, null, null, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0)) {}
    for (;;)
    {
      if (!localCursor.moveToNext()) {
        return;
      }
      String str1 = localCursor.getString(0);
      String str2 = localCursor.getString(1);
      MessageTipsBean localMessageTipsBean = new MessageTipsBean();
      localMessageTipsBean.setEventName(str1);
      localMessageTipsBean.setEventTime(str2);
      localMessageTipsBean.setEventStatus("已过期");
      lists.add(localMessageTipsBean);
      adapter.notifyDataSetChanged();
    }
  }
  
  private void initData()
  {
    messageTipsEventSqlite = new MessageTipsEventSqlite(getApplicationContext());
    db = messageTipsEventSqlite.getWritableDatabase();
    adapter = new Myadapter(null);
    lv_message_addtips.setAdapter(adapter);
    lists = new ArrayList();
    getDataBase();
  }
  
  private void initEvent()
  {
    btn_add_event.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Builder(MessageTipActivity.this);
        paramAnonymousView.setCancelable(false);
        View localView = View.inflate(MessageTipActivity.this, 2130903050, null);
        final EditText localEditText1 = (EditText)localView.findViewById(2131296278);
        final EditText localEditText2 = (EditText)localView.findViewById(2131296279);
        Button localButton1 = (Button)localView.findViewById(2131296280);
        Button localButton2 = (Button)localView.findViewById(2131296281);
        localButton1.setOnClickListener(new OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            if (!ButtonUtils.isFastDoubleClick(2131296269))
            {
              MessageTipActivity.addMessage.dismiss();
              MessageTipActivity.addData(MessageTipActivity.db, localEditText1.getText().toString().trim(), localEditText2.getText().toString().trim());
              paramAnonymous2View = new MessageTipsBean();
              paramAnonymous2View.setEventName(localEditText1.getText().toString().trim());
              paramAnonymous2View.setEventTime(localEditText2.getText().toString().trim());
              paramAnonymous2View.setEventStatus("已过期");
              MessageTipActivity.lists.add(paramAnonymous2View);
              MessageTipActivity.adapter.notifyDataSetChanged();
            }
          }
        });
        localButton2.setOnClickListener(new OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            if (!ButtonUtils.isFastDoubleClick(2131296269)) {
              MessageTipActivity.addMessage.dismiss();
            }
          }
        });
        MessageTipActivity.addMessage = paramAnonymousView.create();
        MessageTipActivity.addMessage.show();
        int i = MessageTipActivity.getWindowManager().getDefaultDisplay().getWidth();
        MessageTipActivity.addMessage.setContentView(localView);
        MessageTipActivity.addMessage.getWindow().clearFlags(131072);
        MessageTipActivity.addMessage.getWindow().setLayout((int)(i * 0.8D), (int)(i * 0.4D));
      }
    });
  }
  
  private void initView()
  {
    setContentView(2130903041);
    lv_message_addtips = ((ListView)findViewById(2131296259));
    btn_add_event = ((Button)findViewById(2131296258));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    initData();
    initEvent();
  }
  
  public void selectData(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query("messagetips", null, null, null, null, null, null);
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.getCount() > 0)) {}
    for (;;)
    {
      if (!paramSQLiteDatabase.moveToNext()) {
        return;
      }
      String str1 = paramSQLiteDatabase.getString(1);
      String str2 = paramSQLiteDatabase.getString(2);
      System.out.println("name" + str1 + str2);
    }
  }
  
  private class Myadapter
    extends BaseAdapter
  {
    private Myadapter() {}
    
    public int getCount()
    {
      return MessageTipActivity.lists.size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null) {}
      for (;;)
      {
        paramViewGroup = (TextView)paramView.findViewById(2131296350);
        TextView localTextView1 = (TextView)paramView.findViewById(2131296351);
        TextView localTextView2 = (TextView)paramView.findViewById(2131296352);
        localTextView2 = (TextView)paramView.findViewById(2131296353);
        paramViewGroup.setText(((MessageTipsBean)MessageTipActivity.lists.get(paramInt)).getEventName());
        localTextView1.setText(((MessageTipsBean)MessageTipActivity.lists.get(paramInt)).getEventTime());
        localTextView2.setOnClickListener(new OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (!ButtonUtils.isFastDoubleClick(2131296269))
            {
              MessageTipActivity.deleteData(MessageTipActivity.db, ((MessageTipsBean)MessageTipActivity.lists.get(paramInt)).getEventName());
              MessageTipActivity.lists.remove(MessageTipActivity.lists.get(paramInt));
              MessageTipActivity.adapter.notifyDataSetChanged();
            }
          }
        });
        return paramView;
        paramView = View.inflate(MessageTipActivity.getApplicationContext(), 2130903065, null);
      }
    }
  }
}
*/
