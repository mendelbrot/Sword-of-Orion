package max.greg.com.gregsapp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    Context context;
    int imageIDs[];
    LayoutInflater inflater;

    public ImageAdapter(Context context, int[] imageIDs) {
        this.context = context;
        this.imageIDs = imageIDs;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageIDs.length;
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
        view = inflater.inflate(R.layout.activity_imageview, null);
        ImageView image = view.findViewById(R.id.image);
        image.setImageResource(imageIDs[i]);
        return view;
    }

}
