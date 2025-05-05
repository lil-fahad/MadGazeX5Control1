package com.madgaze.client

import android.content.Context
import android.view.MotionEvent
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.Color
import com.google.ar.sceneform.rendering.MaterialFactory
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class ARAnnotator(private val context: Context, private val fragment: ArFragment) {
    fun placeMarker(touch: MotionEvent) {
        val frame = fragment.arSceneView.arFrame ?: return
        val hitResult = frame.hitTest(touch).firstOrNull() ?: return
        val anchor = hitResult.createAnchor()
        val anchorNode = AnchorNode(anchor)
        anchorNode.setParent(fragment.arSceneView.scene)

        MaterialFactory.makeOpaqueWithColor(context, Color(android.graphics.Color.RED))
            .thenAccept { material ->
                val sphere = ModelRenderable.builder()
                    .setSource(context, com.google.ar.sceneform.rendering.ShapeFactory.makeSphere(0.01f, anchorNode.worldPosition, material))
                    .build()

                sphere.thenAccept {
                    val node = TransformableNode(fragment.transformationSystem)
                    node.renderable = it
                    node.setParent(anchorNode)
                }
            }
    }
}
