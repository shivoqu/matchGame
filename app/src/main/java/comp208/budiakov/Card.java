package comp208.budiakov;

public class Card {
    public boolean isUpwards;

    public Card(){
        isUpwards = false;
    }

    public void flip(){
        this.isUpwards = !this.isUpwards;
    }
}
