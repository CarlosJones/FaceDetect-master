package com.facedetect.func;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

public class DetectFaces {
    private String basePath =System.getProperty("user.dir");
    private String faceConfigPath=basePath+"/src/com/facedetect/config/haarcascade_frontalface_alt2.xml";
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }


    public void detectFaces(String imagePath,  String outFile) throws Exception{
        System.out.println("\nRunning DetectFaceDemo");
        String path=basePath+"/src/com/facedetect/tmp/";

        // Create a face detector from the cascade file in the resources
        // directory.
        System.out.println(faceConfigPath);
        CascadeClassifier faceDetector = new CascadeClassifier(faceConfigPath);
        Mat image = Highgui.imread(imagePath);

        // Detect faces in the image.
        // MatOfRect is a special container class for Rect.
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s faces",
                faceDetections.toArray().length));
        int i = 0;
        // Draw a bounding box around each face.
        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
            Mat copy = new Mat(image,rect);
            Mat temp = new Mat();
            copy.copyTo(temp);
            MatOfByte mob = new MatOfByte();
            Highgui.imencode(".jpg",temp,mob);
            Highgui.imwrite(path+i+".png",temp);
            i++;
        }

        // Save the visualized detection.
        System.out.println(String.format("Writing %s", outFile));
        Highgui.imwrite(outFile, image);
    }
}
