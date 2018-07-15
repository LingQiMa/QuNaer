package mlq.qunaer;

/**
 * Created by lenovo on 2017/12/10.
 */

class Mine_item{
    int ImageId;
    String name;

    public Mine_item(int imageId, String name) {
        ImageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return ImageId;
    }

    public String getName() {
        return name;
    }
}
