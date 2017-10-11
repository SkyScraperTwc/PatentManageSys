package com.scut.crm.constant;

public final class FilePropertyConst {
    /**存储基本目录*/
    public static final String BASE_SAVE_PATH = "/usr/twc/gitProject/PatentManageSys/src/main/resources/upload";

    /**云网盘最大体积为500mb*/
    public static final long TOTAL_SIZE = 500*1024*1024;

    /**用户上传单个文件的最大体积为20mb*/
    public static final long LIMIT_SIZE = 20*1024*1024;

    /**Mb到字节的转换因子*/
    public static final long FACTOR_MB_TO_BYTE = 1024*1024;

    /**Mb到K字节的转换因子*/
    public static final long FACTOR_MB_TO_KBYTE = 1024;
}
