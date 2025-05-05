package com.madgaze.client

import android.content.Context
import android.graphics.Bitmap
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.vision.detector.ObjectDetector

class ObjectRecognizer(context: Context) {
    private val detector: ObjectDetector

    init {
        val options = ObjectDetector.ObjectDetectorOptions.builder()
            .setMaxResults(3)
            .setScoreThreshold(0.5f)
            .build()
        detector = ObjectDetector.createFromFileAndOptions(
            context,
            "model.tflite",
            options
        )
    }

    fun recognize(bitmap: Bitmap): List<String> {
        val image = TensorImage.fromBitmap(bitmap)
        val results = detector.detect(image)
        return results.map { it.categories[0].label }
    }
}
