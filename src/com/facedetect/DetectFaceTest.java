package com.facedetect;

//import com.facedetect.func.DetectFace;
import com.facedetect.func.DetectFaces;

public class DetectFaceTest {

    public static void main(String[] args) throws Exception {
        DetectFaces df = new DetectFaces();
         String basePath =System.getProperty("user.dir");
        String s1= basePath+ "/src/com/facedetect/image/test1.jpg";
        String s2= basePath+ "/src/com/facedetect/image/test2.jpg";
        String s3= basePath+ "/src/com/facedetect/image/test3.jpg";
        String s4= basePath+ "/src/com/facedetect/image/test4.jpg";
//        String e1= basePath+ "/src/com/facedetect/image/1.png";
        String faceTemp = basePath+"/src/com/facedetect/tmp/faceTemp.png";
//        String eyeTemp = basePath+"/src/com/facedetect/tmp/eyeTemp.png";
        //人脸识别
        df.detectFaces(s3, faceTemp);
//==================================================================================================

    }
}