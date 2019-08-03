package ibrahim.taskmind.Library.Main.Cashe;

import android.graphics.Bitmap;

public interface ICasheImage
{
    void saveImageToCashe(Bitmap bitmap,String imageName);

    Bitmap getImageFromCashe(String imageName);
}
