package com.example.facebook_timeline;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.facebook_timeline.facebook_timeline.data;
import com.example.facebook_timeline.facebook_timeline.facebookTimeLIne_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Facebook_TimelineActivity extends AppCompatActivity {

 RecyclerView facebook ;
RecyclerView.Adapter adapter ;
  List<data> dataList= new ArrayList<data>();
RecyclerView.LayoutManager layoutManager ;
    boolean click = true ;
    EditText editText ;
    ImageView like_image;
     TextView like_text ;
     ImageView menue ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         this.getSupportActionBar().hide();
        setContentView(R.layout.activity_facebook_timeline);
        bulid_recycler();
        bulid_editText();


    }





    public void click_buttonLike(){
        ((facebookTimeLIne_Adapter) adapter).setOnButtonClick(new facebookTimeLIne_Adapter.onButtonClick() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClic(int position, data data) {
                like_text = findViewById(R.id.buttonLike_text);
                like_image= findViewById(R.id.buttonLike_image);

                if(click){
                     like_image.setImageResource(R.drawable.blue_like);
                     like_text.setTextColor(getResources().getColor(R.color.text_color));
                    click = false ;
                }else{
                    like_image.setImageResource(R.drawable.like);
                    like_text.setTextColor(getResources().getColor(R.color.backclick_color));

//kjhgfee4r56t7gyhuijok
                    click = true;

                }

            }
        });
    }

    public  void create_dataList(){
        dataList.add(new data("mariam rady elbradiey","There are two types of people who will tell you that you cannot make a difference in this world: those who are afraid to try and those who are afraid you will succeed.",
                R.drawable.graduated_girl,R.drawable.graduation));
        dataList.add(new data(" Zainab rady elbradiey","Don't be afraid to give up the good to go for the great",
                R.drawable.eng,R.drawable.gamalon));
        dataList.add(new data("mariam rady elbradiey","Successful people do what unsuccessful people are not willing to do. Don't wish it were easier; wish you were better.",
                R.drawable.civil,R.drawable.sunshine));
        for(int i = 0 ;i<1000;i++)
            dataList.add(new data("name" + i, "Opportunities don't happen. You create them."
          , R.drawable.graduated_girl, R.drawable.reserch));

    }

    public  void  bulid_recycler(){

     facebook =findViewById(R.id.recycler_facebook);
        create_dataList();
      adapter = new facebookTimeLIne_Adapter(dataList);
        click_buttonLike();
    layoutManager = new LinearLayoutManager(this);
     facebook.setLayoutManager(layoutManager);
     facebook.setAdapter(adapter);


 }



    public void bulid_editText(){
        editText=findViewById(R.id.edit_text);
       editText.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void afterTextChanged(Editable editable) {
             String s = editable.toString();
              Filter(s);
           }
       });


   }


   public  void Filter(String s){
     ArrayList<data> FilterdList = new ArrayList<>();
      for (data data_elemnt : dataList){
          if(data_elemnt.getName().toLowerCase().contains(s.toLowerCase())){
            FilterdList.add(data_elemnt);

          }}
       ((facebookTimeLIne_Adapter) adapter).setNewList(FilterdList);
   }

}
