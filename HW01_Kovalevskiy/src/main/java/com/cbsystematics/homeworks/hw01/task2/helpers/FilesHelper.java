package com.cbsystematics.homeworks.hw01.task2.helpers;

import lombok.SneakyThrows;

import java.net.URLDecoder;

/**
 * FilesHelper Class is a helper class for different work with files
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
public final class FilesHelper {
    
    /**
     * The method determines sub project file path
     *
     * @param currClass calling class
     * @param resourceName name of the resource
     * @param fileName name of the file
     * @return path to file
     */
    @SneakyThrows
    public static String getSourcePackageFilePathMaven(Class<?> currClass, String resourceName, String fileName) {
        return URLDecoder.decode(currClass.getResource(resourceName).getFile(), "UTF-8")
                .replace(System.getProperty("user.dir").replace("\\", "/"), "")
                .replace(resourceName, "")
                .replace("target/classes", "src/main/java")
                .replace("//", "")
                .concat(fileName);
    }
    
    /**
     * The method determines sub project file path
     *
     * @param currClass calling class
     * @param resourceName name of the resource
     * @param fileName name of the file
     * @return path to file
     */
    @SneakyThrows
    public static String getSourcePackageFilePathGradle(Class<?> currClass, String resourceName, String fileName) {
        return URLDecoder.decode(currClass.getResource(resourceName).getFile(), "UTF-8")
                .replace(System.getProperty("user.dir").replace("\\", "/"), "")
                .replace(resourceName, "")
                .replace("build/classes/java/main", "src/main/java")
                .replace("//", "")
                .concat(fileName);
    }
    
    /**
     * The method determines sub project resource file path
     *
     * @param currClass calling class
     * @param resourceName name of the resource
     * @param fileName name of the file
     * @return path to resource file
     */
    @SneakyThrows
    public static String getResourcePackageFilePathMaven(Class<?> currClass, String resourceName, String fileName) {
        return URLDecoder.decode(currClass.getResource(resourceName).getFile(), "UTF-8")
                .replace(System.getProperty("user.dir").replace("\\", "/"), "")
                .replace(resourceName, "")
                .replace("target/classes", "src/main/resources")
                .replace("//", "")
                .concat(fileName);
    }
    
    /**
     * The method determines sub project resource file path
     *
     * @param currClass calling class
     * @param resourceName name of the resource
     * @param fileName name of the file
     * @return path to resource file
     */
    @SneakyThrows
    public static String getResourcePackageFilePathGradle(Class<?> currClass, String resourceName, String fileName) {
        return URLDecoder.decode(currClass.getResource(resourceName).getFile(), "UTF-8")
                .replace(System.getProperty("user.dir").replace("\\", "/"), "")
                .replace(resourceName, "")
                .replace("build/classes/java/main", "src/main/resources")
                .replace("//", "")
                .concat(fileName);
    }
    
    /**
     * The method determines sub project resource root directory + file path
     *
     * @param currClass calling class
     * @param resourceName name of the resource
     * @param fileName name of the file
     * @return path to resource file
     */
    @SneakyThrows
    public static String getResourceRootFilePathMaven(Class<?> currClass, String resourceName, String fileName) {
        return URLDecoder.decode(currClass.getResource(resourceName).getFile(), "UTF-8")
                .replace(System.getProperty("user.dir").replace("\\", "/"), "")
                .replace(resourceName, "")
                .replace("target/classes", "src/main/resources")
                .replace("//", "")
                .replace(currClass.getPackage().getName().replace(".", "/") + "/", "")
                .concat(fileName);
    }
    
    /**
     * The method determines sub project resource root directory + file path
     *
     * @param currClass calling class
     * @param resourceName name of the resource
     * @param fileName name of the file
     * @return path to resource file
     */
    @SneakyThrows
    public static String getResourceRootFilePathGradle(Class<?> currClass, String resourceName, String fileName) {
        return URLDecoder.decode(currClass.getResource(resourceName).getFile(), "UTF-8")
                .replace(System.getProperty("user.dir").replace("\\", "/"), "")
                .replace(resourceName, "")
                .replace("build/classes/java/main", "src/main/resources")
                .replace("//", "")
                .replace(currClass.getPackage().getName().replace(".", "/") + "/", "")
                .concat(fileName);
    }
}
