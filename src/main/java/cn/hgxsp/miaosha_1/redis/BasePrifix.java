package cn.hgxsp.miaosha_1.redis;

/**
 * DESC：KeyPrefix 实现类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 12:07
 */
public abstract class BasePrifix implements KeyPrefix {

    private int expireSecondS;

    private String prefix;

    public BasePrifix(int expireSecondS, String prefix) {
        this.expireSecondS = expireSecondS;
        this.prefix = prefix;
    }
    public BasePrifix(String prefix) {
        this.expireSecondS = 0;
        this.prefix = prefix;
    }

    @Override
    public int expireSecondS() {
        return 0;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();

        return className + ":" + prefix + ":";
    }
}
