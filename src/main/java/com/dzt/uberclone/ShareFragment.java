package com.dzt.uberclone;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ShareFragment extends Fragment implements View.OnClickListener {
    GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_share, container, false);

        gridView = (GridView) v.findViewById(R.id.gridview);

        gridView.setAdapter(new ImageAdapter(getActivity().getBaseContext()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(getActivity(),v.getId() + "",Toast.LENGTH_SHORT).show();
                String urlToShare = "This is FUCKING awesome! -Shared from Uber";
                Intent intent=new Intent();
                switch (position) {
                    case 0:
                        /*
                        Intent shareIntent = new PlusShare.Builder(getActivity())
                                .setType("text/plain")
                                .setText("Sharing on G+.")
                                .setContentUrl(Uri.parse(urlToShare))
                                .getIntent();

                        startActivityForResult(shareIntent, 0);
                        */

                        intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                        intent.setPackage("com.google.android.apps.plus");
                        break;

                    case 1:
                        intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                        intent.setPackage("com.facebook.katana");
                        break;

                    case 2:

                        intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                        intent.setPackage("com.whatsapp");
                        break;

                    case 3:

                        intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                        intent.setPackage("com.twitter.android");
                        break;
                }

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "Not installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        /*
        //Button gShare = (Button) v.findViewById(R.id.share_gplus_button);
        ImageView gShare = (ImageView) v.findViewById(R.id.gp_share_icon);
        gShare.setOnClickListener(this);
        //Button fbShare = (Button) v.findViewById(R.id.share_fb_button);
        ImageView fbShare = (ImageView) v.findViewById(R.id.fb_share_icon);
        fbShare.setOnClickListener(this);
        //Button waShare = (Button) v.findViewById(R.id.share_wa_button);
        ImageView waShare = (ImageView) v.findViewById(R.id.whatsapp_share_icon);
        waShare.setOnClickListener(this);
        //Button twitterShare = (Button) v.findViewById(R.id.share_twitter_button);
        ImageView twitterShare = (ImageView) v.findViewById(R.id.twitter_share_icon);
        twitterShare.setOnClickListener(this);
        */
        return v;

    }


    @Override
    public void onClick(View v)
    {
        /*
        String urlToShare = "UberClone.test";
        Intent intent;
        switch (v.getId()) {
            case R.id.gp_share_icon:
                /*
                Intent shareIntent = new PlusShare.Builder(getActivity())
                        .setType("text/plain")
                        .setText("Sharing on G+.")
                        .setContentUrl(Uri.parse(urlToShare))
                        .getIntent();

                startActivityForResult(shareIntent, 0);
                */
                /*
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                intent.setPackage("com.google.android.apps.plus");

                startActivity(intent);
                break;

            case R.id.fb_share_icon:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                intent.setPackage("com.facebook.katana");

                startActivity(intent);
                break;

            case R.id.whatsapp_share_icon:

                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                intent.setPackage("com.whatsapp");

                startActivity(intent);
                break;

            case R.id.twitter_share_icon:

                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                intent.setPackage("com.twitter.android");

                startActivity(intent);
                break;
        }
        */
    }
}