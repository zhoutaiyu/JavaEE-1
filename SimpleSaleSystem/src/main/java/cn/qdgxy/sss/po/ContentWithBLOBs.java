package cn.qdgxy.sss.po;

import java.io.Serializable;

public class ContentWithBLOBs extends Content implements Serializable {

    private static final long serialVersionUID = 1L;
    private byte[] icon;
    private byte[] text;

    public ContentWithBLOBs(Integer id, Long price, String title, String digest, byte[] icon, byte[] text) {
        super(id, price, title, digest);
        this.icon = icon;
        this.text = text;
    }

    public ContentWithBLOBs() {
        super();
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
    }
}