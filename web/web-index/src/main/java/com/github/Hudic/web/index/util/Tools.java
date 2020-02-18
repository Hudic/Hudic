//package com.github.Hudic.web.index.util;
//
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.InvocationTargetException;
//
//public class Tools {
//    /**
//     * 修改了BeanUtils的的属性拷贝逻辑，仅拷贝不相等的属性，并由
//     * 调用方决定是否拷贝Null属性
//     * @param dest	目标对象
//     * @param orig	来源对象
//     * @param copyNull 是否复制null属性
//     * @throws IllegalAccessException
//     * @throws java.lang.reflect.InvocationTargetException
//     */
//    public static void copyProperties(Object dest, Object orig, boolean copyNull)
//            throws IllegalAccessException, InvocationTargetException {
//        if(orig == null) return;
//
//        PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(orig);
//
//        for (int i = 0; i < origDescriptors.length; i++) {
//            String name = origDescriptors[i].getName();
//            if ("class".equals(name)) {
//                continue;
//            }
//            if (PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)) {
//                try {
//                    Object value = PropertyUtils.getSimpleProperty(orig, name);
//                    if (copyNull || value != null) {
//                        if(value == null)
//                            BeanUtils.copyProperty(dest, name, value);
//                        else {
//                            Object destValue = PropertyUtils.getSimpleProperty(dest, name);
//                            if(!value.equals(destValue))
//                                BeanUtils.copyProperty(dest, name, value);
//                        }
//                    }
//                }
//                catch (NoSuchMethodException e) {}
//            }
//        }
//    }
//}
