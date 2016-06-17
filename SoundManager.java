package sound;

/**
 * Created by caotr on 15/06/2016.
 */
public class SoundManager {
    private WavEffect nhacNen;
    private WavEffect xoayMoNeo;
    private WavEffect nhacNen2;

    public WavEffect getNhacNen() {
        return nhacNen;
    }

    public void setNhacNen(WavEffect nhacNen) {
        this.nhacNen = nhacNen;
    }

    public WavEffect getXoayMoNeo() {
        return xoayMoNeo;
    }

    public void setXoayMoNeo(WavEffect xoayMoNeo) {
        this.xoayMoNeo = xoayMoNeo;
    }

    public SoundManager(){
        nhacNen = new WavEffect("start.wav");
        nhacNen.loop(-1);

    }


}
