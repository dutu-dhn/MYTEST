package test;

import lombok.Getter;

/**
 * @author dutu
 * @date 2021-05-03 10:01
 */
public enum CountryEnum {
    ONE(1,"春"),TWO(2,"夏"),THREE(3,"秋"),FOUR(4,"冬");
    @Getter private Integer retCode;
    @Getter private String retValue;

    CountryEnum(Integer retCode, String retValue) {
        this.retCode = retCode;
        this.retValue = retValue;
    }

    public static CountryEnum foreach_CountryEnum(int index){
        CountryEnum[] enums = CountryEnum.values();
        for (CountryEnum anEnum : enums) {
            if (index == anEnum.getRetCode()){
                return anEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.foreach_CountryEnum(1).retValue);
    }
}
