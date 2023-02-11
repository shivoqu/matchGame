package comp208.budiakov;

import android.widget.ImageView;

public class Card {
    private final int imageId;
    private boolean isFaceUp;
    private final ImageView imageView;

    public Card(int imageId, ImageView imageView) {
        this.imageId = imageId;
        this.isFaceUp = false;
        this.imageView = imageView;

        imageView.setImageResource(R.drawable.back);
    }

    public int getImageId() {
        return imageId;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void turnFaceUp() {
        isFaceUp = true;
        imageView.setImageResource(imageId);
    }

    public void turnFaceDown() {
        isFaceUp = false;
        imageView.setImageResource(R.drawable.back);
    }
}