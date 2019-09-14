package com.example.facebook_timeline;

import android.content.Context;

import com.example.facebook_timeline.facebook_timeline.facebookTimeLIne_Adapter;

public class nullContext {


        // variable to hold context
        private Context context;
    facebookTimeLIne_Adapter.ViewHolder holder;
//save the context recievied via constructor in a local variable

        public nullContext(Context context){
            this.context = context.getApplicationContext();
        }



    public nullContext(facebookTimeLIne_Adapter.ViewHolder viewHolder) {
            this.holder = viewHolder;
    }
}


