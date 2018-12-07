package com.Hudic.util;

import com.Hudic.model.User;
import com.alibaba.fastjson.JSONObject;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * jiangcq
 * 2018/12/7 9:30
 */
public class Tool {
    /**
     * @param t:任意基本数据类型或引用数据类型
     * @return 符合Json格式要求的String
     * @author jiangcq
     */
    public static <T> String parseToJsonString(T t) {
        Class c = t.getClass();
        // 如果本身是String，则返回自身
        if (c.equals(java.lang.String.class)) {
            return "'" + t.toString() + "'";
        }
        // 如果是基础数据类型，则返回它的StringValue
        if (c.equals(java.lang.Integer.class) ||
                c.equals(java.lang.Byte.class) ||
                c.equals(java.lang.Long.class) ||
                c.equals(java.lang.Double.class) ||
                c.equals(java.lang.Float.class) ||
                c.equals(java.lang.Character.class) ||
                c.equals(java.lang.Short.class) ||
                c.equals(java.lang.Boolean.class)) {
            return String.valueOf(t);
        }
        /* 如果是对象，才需要利用反射进行解析 */
        // 创建一个StringBuilder进行字符串拼接组装，格式为{key:value,key2:value2,...}
        StringBuilder sb = new StringBuilder("{");
        // 通过类对象c取出t的所有声明了的字段(属性)
        Field[] fields = c.getDeclaredFields();
        // 遍历t的属性
        for (Field field : fields) {
            try {
                // 取出属性名
                String key = field.getName();
                // 属性解析器，参数为类对象和属性名，这里的c可以为t.getClass()
                PropertyDescriptor descriptor = new PropertyDescriptor(key, c);
                // 获取该属性字段的getter方法
                Method method = descriptor.getReadMethod();
                // 调用这个方法,得到属性值，类型未知，有可能是基本数据类型，也可能是引用数据类型
                Object object = method.invoke(t);
                // 所以继续对这个属性值递归调用本解析方法，如果是基本类型，会转为StringVlaue，如果是字符串,会转为加上了引号的字符串，如果是对象，会转为格式如{key:value,key2:value2,...}
                String value = parseToJsonString(object);
                /**
                 * 对此属性名和属性值进行拼接，最后一个逗号没有关系，JSON能自动识别   注:这里不需要改写为sb.append(key).append(":").append(value).append(",");因为括号内是行内拼接，并不是循环拼接，只有sb对象是在进行循环拼接，所以只需在最前面使用一个append即可
                 * 循环拼接需要使用StringBuider的append方法，因为如果是循环拼接，那么系统每次循环都会在循环体内部创建StringBUilder,这样会造成空间浪费；而用StringBuilder进行显示拼接时，可以定义在外面，减少内存的消耗
                 */
                sb.append(key + ":" + value + ",");
            } catch (Exception e) {
                e.printStackTrace();
                // 出现异常，是continue继续下一个属性，还是报错返回？->a应该报错返回null，否则会出现字段缺少的解析，会引发其他不可预知的误会，或者返回{}，不至于空指针
                return "{}";
            }
        }
        // JSON字符串最后以}结束，如果强迫症不喜欢前面拼接留下的最后一个逗号，也可在此处调用sb.delete(sb.lastIndexOf(","), sb.length());删去最后一个逗号
//        if (sb.lastIndexOf(",") != -1) {
//            sb.delete(sb.lastIndexOf(","), sb.length());
//        }
        sb.append("}");
        // 返回sb的String值
        return sb.toString();
    }


    public static <T> JSONObject buildSuccessResult(T t) {
        JSONObject ret = new JSONObject();
        ret.put("status", 1);//1操作成功
        ret.put("msg", "success");
        ret.put("data", t.toString());//操作成功就不需要再返回原参数？->也返回一下吧
        return ret;
    }

    public static <T> JSONObject buildFailureResult(T t) {
        JSONObject ret = new JSONObject();
        ret.put("status", 0);//0操作失败
        ret.put("msg", "failure");
        ret.put("data", t.toString());
        return ret;
    }

    public static <T> JSONObject buildBadRequestResult(T t) {
        JSONObject ret = new JSONObject();
        ret.put("status", -1);//-1请求有问题
        ret.put("msg", "Bad request");
        ret.put("data", t.toString());
        return ret;
    }

    /**
     * 检查必要的字段(是否有为null和空字符串的字段)
     *
     * @param t:传入对象
     * @param params：需要检查的字段名
     * @return {status:0/1,msg:"xxx"}
     */
    public static <T> JSONObject checkNecessaryParams(T t, String... params) {
        JSONObject jsonObject = JSONObject.parseObject(Tool.parseToJsonString(t));
        JSONObject ret = new JSONObject();
        List<String> nullParams = new ArrayList<>();
        for (String param : params) {
            if (jsonObject.get(param) == null || "".equals(jsonObject.get(param))) {
                nullParams.add(param);
            }
        }
        if (nullParams.size() > 0) {
            ret.put("status", 0);//0不通过
            ret.put("msg", "缺少参数:" + nullParams.toString());
        } else {
            ret.put("status", 1);//1操作成功，通过
            ret.put("msg", "参数正常");
        }
        return ret;
    }


}
