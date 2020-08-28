/*
 * Copyright 2017 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.study.springboot.validate;


import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

/**
 * 校验是否是纯英文
 *
 * @author guonan
 */
public class OnlyEnValidator implements ConstraintValidator<OnlyEn, String> {

    private static Pattern EN_PATTERN = Pattern.compile("[\\x00-\\xff]*");

    /**
     * 只能填写英文包含特殊符号
     */
    private static Pattern EN_PATTERN_WITH_SPECIAL_SIGNAL =
            Pattern.compile("[\\x00-\\x9f\\xa1-\\xff\\u0000-\\u009f\\u00a1-\\u00ff\\u0021-\\u002c\\u002e\\u002f\\u003a-\\u0040\\u0043\\u0046\\u005b-\\u0060\\u007b-\\u007d\\u00a1-\\u00ac\\u00ae-\\u0113\\u0116-\\u0122\\u0124-\\u012b\\u012e-\\u014d\\u0150-\\u017e\\u0192\\u01b5\\u01f5\\u0237\\u02c6\\u02c7\\u02d8-\\u02dd\\u0311\\u0391-\\u03a1\\u03a3-\\u03a9\\u03b1-\\u03c9\\u03d1\\u03d2\\u03d5\\u03d6\\u03dc\\u03dd\\u03f0\\u03f1\\u03f5\\u03f6\\u0401-\\u040c\\u040e-\\u044f\\u0451-\\u045c\\u045e\\u045f\\u2010\\u2013\\u2015\\u2016\\u2018-\\u201a\\u201c-\\u201e\\u2020-\\u2022\\u2025\\u2026\\u2030-\\u2035\\u2039\\u203a\\u203e\\u2041\\u2043\\u2044\\u20ac\\u20db\\u20dc\\u2102\\u2105\\u210a-\\u2113\\u2115-\\u211e\\u2122\\u2124\\u2127-\\u2129\\u212c\\u212d\\u212f-\\u2131\\u2133-\\u2138\\u2153-\\u215e\\u2190-\\u219b\\u219d-\\u21a7\\u21a9-\\u21ae\\u21b0-\\u21b3\\u21b5-\\u21b7\\u21ba-\\u21db\\u21dd\\u21e4\\u21e5\\u2200-\\u2205\\u2207-\\u2209\\u220b\\u220c\\u220f-\\u2214\\u2216-\\u2218\\u221a\\u221d-\\u2238\\u223a-\\u2257\\u2259\\u225a\\u225c\\u225f-\\u2262\\u2264-\\u228b\\u228d-\\u229b\\u229d-\\u22a5\\u22a7-\\u22b0\\u22b2-\\u22bb\\u22bd-\\u22db\\u22de-\\u22e3\\u22e6-\\u22f1\\u2305\\u2306\\u2308-\\u2310\\u2312\\u2313\\u2315\\u2316\\u231c-\\u231f\\u2322\\u2323\\u232d\\u232e\\u2336\\u233d\\u233f\\u2423\\u24c8\\u2500\\u2502\\u250c\\u2510\\u2514\\u2518\\u251c\\u2524\\u252c\\u2534\\u253c\\u2550-\\u256c\\u2580\\u2584\\u2588\\u2591-\\u2593\\u25aa\\u25ab\\u25ad\\u25ae\\u25b1\\u25b3-\\u25b5\\u25b8\\u25b9\\u25bd-\\u25bf\\u25c2\\u25c3\\u25ca\\u25cb\\u25ec\\u25ef\\u2605\\u2606\\u260e\\u2640\\u2642\\u2660\\u2663\\u2665\\u2666\\u266a\\u266d-\\u266f\\u2713\\u2717\\u2720\\u2736\\u2758\\u2772\\u2773\\u2935\\u2985\\u2986\\u29bf\\u2a00-\\u2a02\\u2a04\\u2a06\\u2a0c\\u2a0d\\u2a10-\\u2a17\\u2a22-\\u2a27\\u2a29\\u2a2a\\u2a2d-\\u2a31\\u2a33-\\u2a3c\\u2a3f\\u2a40\\u2a42-\\u2a4d\\u2a50\\u2a53-\\u2a58\\u2a5a-\\u2a5d\\u2a5f\\u2a66\\u2a6a\\u2a6d-\\u2a75\\u2a77-\\u2a9a\\u2a9d-\\u2aa2\\u2aa4-\\u2ab0\\u2ab3-\\u2ac8\\u2acb\\u2acc\\u2acf-\\u2adb\\u2ae4\\u2ae6-\\u2ae9\\u2aeb-\\u2af3\\u2afd\\ufb00-\\ufb04]*");

    private static Pattern EN_PATTREN_OF_RICH_TEXT = Pattern.compile("[\\u2109\\u2103\\u00a0\\u2018\\u2014\\u2264\\u2265\\u03c9\\u03b1\\u03b2\\u03b3\\u03b4\\u03b7\\u03b8\\u03bb\\u03bc\\u03bd\\u03be\\u03c0\\u03c3\\u03c4\\u03c6\\u03c7\\u03a3\\u03a6\\u03a9\\u2208\\u2030\\u2260\\u03c1\\u2228\\u2227\\u2211\\u221e\\u2261\\u221a\\u0394\\u20ac\\u2122\\u2160\\u2161\\u2162\\u2248\\u222e\\u02c6\\u00ac\\u0393\\u03b9\\u03ba\\u03c8\\u222b\\u2229\\u222a\\u0394\\u2160\\u2161\\u2162\\u2163\\u2164\\u2165\\u2166\\u2167\\u2168\\u2169\\u216a\\u216b\\u2170\\u2171\\u2172\\u2173\\u2174\\u2175\\u2176\\u2177\\u2178\\u2179\\u217a\\u217b\\u0000-\\u00FF\\u00a5\\u20ac\\u00a3\\u00a2\\u00a9\\u00ae\\u2122\\u03b1\\u03b2\\u03b3\\u03b4\\u03b7\\u03b8\\u03bb\\u03bc\\u03bd\\u03be\\u03c0\\u03c3\\u03c4\\u03c1\\u03c6\\u03c7\\u03c9\\u0394\\u03a3\\u03a6\\u03a9\\u00af\\u2014\\u00b1\\u00d7\\u00f7\\u2264\\u2265\\u00a7\\u2208\\u2030\\u2260\\u2228\\u2227\\u2211\\u221e\\u2261\\u221a\\u00b7\\u2018\\u00b4\\u00b2\\u00b3\\u00bd\\u00bc\\u00be\\u00b0\\u00ba\\u00ba\\u00f8\\u003c\\u003e\\u0026\\u0022\\u00a9\\u00ae\\u2122\\u00d7\\u00f7\\u00a1\\u00a2\\u00a3\\u00a4\\u00a5\\u00a6\\u00a7\\u00a8\\u00a9\\u00aa\\u00ab\\u00ac\\u00ad\\u00ae\\u00af\\u00b0\\u00b1\\u00b2\\u00b3\\u00b4\\u00b5\\u00b6\\u00b7\\u00b8\\u00b9\\u00ba\\u00bb\\u00bc\\u00bd\\u00be\\u00bf\\u00c0\\u00c1\\u00c2\\u00c3\\u00c4\\u00c5\\u00c6\\u00c7\\u00c8\\u00c9\\u00ca\\u00cb\\u00cc\\u00cd\\u00ce\\u00cf\\u00d0\\u00d1\\u00d2\\u00d3\\u00d4\\u00d5\\u00d6\\u00d7\\u00d8\\u00d9\\u00da\\u00db\\u00dc\\u00dd\\u00de\\u00df\\u00e0\\u00e1\\u00e2\\u00e3\\u00e4\\u00e5\\u00e6\\u00e7\\u00e8\\u00e9\\u00ea\\u00eb\\u00ec\\u00ed\\u00ee\\u00ef\\u00f0\\u00f1\\u00f2\\u00f3\\u00f4\\u00f5\\u00f6\\u00f7\\u00f8\\u00f9\\u00fa\\u00fb\\u00fc\\u00fd\\u00fe\\u00ff\\u0192\\u0391\\u0392\\u0393\\u0394\\u0395\\u0396\\u0397\\u0398\\u0399\\u039a\\u039b\\u039c\\u039d\\u039e\\u039f\\u03a0\\u03a1\\u03a3\\u03a4\\u03a5\\u03a6\\u03a7\\u03a8\\u03a9\\u03b1\\u03b2\\u03b3\\u03b4\\u03b5\\u03b6\\u03b7\\u03b8\\u03b9\\u03ba\\u03bb\\u03bc\\u03bd\\u03be\\u03bf\\u03c0\\u03c1\\u03c2\\u03c3\\u03c4\\u03c5\\u03c6\\u03c7\\u03c8\\u03c9\\u003f\\u003f\\u003f\\u2022\\u2032\\u2033\\u203e\\u2044\\u2118\\u2111\\u211c\\u2122\\u2135\\u2190\\u2191\\u2192\\u2193\\u2194\\u21b5\\u21d0\\u21d1\\u21d2\\u21d3\\u21d4\\u2200\\u2202\\u2203\\u2205\\u2207\\u2208\\u2209\\u220b\\u220f\\u2211\\u2212\\u2217\\u221a\\u221d\\u221e\\u2220\\u2227\\u2228\\u2229\\u222a\\u222b\\u2234\\u223c\\u221d\\u2248\\u2260\\u2261\\u2264\\u2265\\u2282\\u2283\\u2284\\u2286\\u2287\\u2295\\u2297\\u22a5\\u22c5\\u003f\\u003f\\u003f\\u003f\\u003f\\u003f\\u25ca\\u2660\\u2663\\u2665\\u2666\\u0022\\u0026\\u003c\\u003e\\u0152\\u0153\\u0160\\u0161\\u0178\\u02c6\\u02dc\\u200c\\u200d\\u200e\\u200f\\u2013\\u2014\\u2018\\u2019\\u201a\\u201c\\u201d\\u201e\\u2020\\u2021\\u2030\\u2039\\u203a\\u20ac\\u0176\\u0174\\u0175\\u0177\\u201B\\u2026\\u25BA]*");

    @Override
    public void initialize(OnlyEn constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isOnlyEn(value);
    }

    // 单元测试
    public static void main(String[] args) {
        System.out.println(isOnlyEn("1"));
        System.out.println(isOnlyEn("你"));
        System.out.println(isOnlyEn(""));
        System.out.println(isOnlyEn("dfdfdf"));
        System.out.println(isOnlyEn("试RRRRRRRRRRRRRR"));
        System.out.println("*************************************************");
        System.out.println(isOnlyEnAndSpecialChar(" "));
        System.out.println(isOnlyEnAndSpecialChar("aa"));
        System.out.println(isOnlyEnAndSpecialChar("11"));
        System.out.println(isOnlyEnAndSpecialChar("试RRRRRRRRRRRRRR"));
        System.out.println(isOnlyEnAndSpecialChar("试"));
    }

    public static boolean isOnlyEn(String input) {
        if (StringUtils.isEmpty(input)) {
            return true;
        }
        // 表达式和前端一致 !/[^\x00-\xff]/
        return EN_PATTERN.matcher(input).matches();
    }

    /**
     * 英文字符+特殊字符
     *
     * @param input
     * @return
     */
    public static boolean isOnlyEnAndSpecialChar(String input) {
        if (StringUtils.isEmpty(input)) {
            return true;
        }
        return EN_PATTERN_WITH_SPECIAL_SIGNAL.matcher(input).matches();
    }

    public static boolean isOnlyEnRichTextChar(String input) {
        if (StringUtils.isEmpty(input)) {
            return true;
        }
        return EN_PATTREN_OF_RICH_TEXT.matcher(input).matches();
    }

}
