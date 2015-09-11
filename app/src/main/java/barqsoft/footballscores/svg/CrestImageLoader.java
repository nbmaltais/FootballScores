package barqsoft.footballscores.svg;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;

import java.io.InputStream;

import barqsoft.footballscores.R;

/**
 * Created by Nicolas on 2015-08-28.
 */
public class CrestImageLoader
{
    static private GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;

    static public void initSvgRequestBuilder(Context ctx)
    {
        if(requestBuilder==null)
        {
            requestBuilder = Glide.with(ctx.getApplicationContext())
                    .using(Glide.buildStreamModelLoader(Uri.class, ctx), InputStream.class)
                    .from(Uri.class)
                    .as(SVG.class)
                    .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                    .sourceEncoder(new StreamEncoder())
                    .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
                    .decoder(new SvgDecoder())
                    .placeholder(R.drawable.no_icon)
                    .error(R.drawable.no_icon)
                    .animate(android.R.anim.fade_in)
                    .listener(new SvgSoftwareLayerSetter<Uri>());
        }
    }

    static public GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> getSvgRequestBuilder()
    {
        return requestBuilder;
    }

    static public void loadCrestIntoImageView(Context ctx, Uri svgUri, ImageView view)
    {

        String path = svgUri.getPath();
        if(path.endsWith(".svg"))
        {
            getSvgRequestBuilder()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .load(svgUri)
                    .into(view);
        }
        else
        {
            Glide.with(ctx)
                    .load(svgUri)
                    .centerCrop()
                    .placeholder(R.drawable.no_icon)
                    .error(R.drawable.no_icon)
                    .into(view);
        }
    }

    /*static public void loadSvgIntoRemoteViews(Context ctx, Uri svgUri, RemoteViews views, int viewid, int[] ids )
    {

        AppWidgetTarget target = new AppWidgetTarget(ctx,views,viewid,ids);
        String path = svgUri.getPath();
        if(path.endsWith(".svg"))
        {
            getSvgRequestBuilder()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .load(svgUri)
                    .into(target);
        }
        else
        {
            Glide.with(ctx)
                    .load(svgUri)
                    .asBitmap()
                    .centerCrop()
                    .placeholder(R.drawable.no_icon)
                    .error(R.drawable.no_icon)
                    .into(target);
        }
    }*/


}
