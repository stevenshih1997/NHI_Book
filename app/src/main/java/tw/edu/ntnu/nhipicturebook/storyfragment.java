package tw.edu.ntnu.nhipicturebook;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.content.Context;


public class storyfragment extends Fragment {

    private Context context;

    public storyfragment()
    {

    }

    public static storyfragment newInstance(int index) {
        storyfragment f = new storyfragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;

    }

    public int getShownIndex() {
        return getArguments().getInt("index",0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.story1_playfragment, container,
                false);


        String uri = "@drawable/"+"button"+getShownIndex()+"_default";
        //String uri = "@drawable/"+"page"+getShownIndex();
        context = getActivity().getApplicationContext();
        int imageResource = getResources().getIdentifier(uri,null,context.getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        ImageView image = (ImageView) view.findViewById(R.id.txtDateTime);
        image.setImageDrawable(res);
        return view;
    }
}
