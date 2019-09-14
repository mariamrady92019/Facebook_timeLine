package com.example.facebook_timeline.facebook_timeline;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook_timeline.R;
import com.example.facebook_timeline.RelativeLayoutButton;
import com.example.facebook_timeline.nullContext;

import java.util.ArrayList;
import java.util.List;







public class facebookTimeLIne_Adapter extends RecyclerView.Adapter<facebookTimeLIne_Adapter.ViewHolder> {
    List<data> dataList ;
    onButtonClick onButtonClick;

    public facebookTimeLIne_Adapter(List<data> dataList) {
        this.dataList = dataList;
    }




    public void get_newlist(List<data> filterdlist){
        dataList = filterdlist;
        notifyDataSetChanged();

    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       final data data = dataList.get(position);
       holder.account_photo.setImageResource(data.getAccount_Photo());
        holder.post_photo.setImageResource(data.getPost_photo());
         holder.description.setText(data.getDiscription());
        holder.name.setText(data.getName());

        if(onButtonClick!=null){
             holder.like.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     onButtonClick.onClic(position,data);
                 }
             });

        }

    }

    @Override
    public int getItemCount() {
        if(dataList==null)return  0 ;
        return dataList.size();
    }

   public void setNewList(ArrayList<data> filtered){

        dataList= filtered;
        notifyDataSetChanged();
   }

    public void setOnButtonClick(facebookTimeLIne_Adapter.onButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }

    public interface onButtonClick {
        void onClic(int position , data data);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
      View post_view;
      TextView name;
      TextView description;
      ImageView account_photo;
      ImageView post_photo;
        RelativeLayout like ;
        RelativeLayout  comment;
        RelativeLayout  share ;
        TextView menu ;

      public ViewHolder(View post_view) {
          super(post_view);

          this.post_view = post_view;
          name = post_view.findViewById(R.id.account_name);
          description = post_view.findViewById(R.id.photo_description);
          account_photo = post_view.findViewById(R.id.accoount_photo);
          post_photo = post_view.findViewById(R.id.post_photo);

          like = post_view.findViewById(R.id.first_button);
        comment = post_view.findViewById(R.id.second_button);

         share =post_view.findViewById(R.id.third_button);



      }


    }

}
