public class RandomPosition {
    private String horizontalPosition;
    private String verticalPosition;

    RandomPosition(String hp, String vp){
        horizontalPosition = hp;
        verticalPosition = vp;
    }

    String getHorizontalPosition() {
        return horizontalPosition;
    }

    public void setHorizontalPosition(String horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    String getVerticalPosition() {
        return verticalPosition;
    }

    public void setVerticalPosition(String verticalPosition) {
        this.verticalPosition = verticalPosition;
    }
}
