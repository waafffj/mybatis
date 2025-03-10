package cn.good.mybatis.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * TODO
 *
 * @Description 通过类加载器获得resource的辅助类
 * @Author wkm
 * @Date 2024/12/20
 **/
public class Resources {
    public static Reader getResourceAsReader(String resource) throws IOException {
        return new InputStreamReader(getResourceAsStream(resource));
    }
    private static InputStream getResourceAsStream(String resource) throws IOException {
        ClassLoader[] classLoaders = getClassLoaders();
        for(ClassLoader classLoader : classLoaders){
            InputStream inputStream = classLoader.getResourceAsStream(resource);
            if(null != inputStream){
                return inputStream;
            }
        }
        throw new IOException("Could not find resource " + resource);
    }
    private static ClassLoader[] getClassLoaders(){
        return new ClassLoader[]{
                ClassLoader.getSystemClassLoader(),
                Thread.currentThread().getContextClassLoader()};
        }
    public static Class<?> classForName(String className) throws ClassNotFoundException {
    return Class.forName(className);
  }
}
