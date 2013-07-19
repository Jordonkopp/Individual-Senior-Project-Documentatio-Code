package com.kopp.Scene;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.color.Color;


import com.kopp.BaseScene.BaseScene;
import com.kopp.Manager.SceneManager.SceneType;



public class LoadingScene extends BaseScene
{
    @Override
    public void createScene()
    {
    	setBackground(new Background(Color.WHITE));
        attachChild(new Text(400, 240, resourcesManager.font, "Loading...", vbom));
        
    }

    @Override
    public void onBackKeyPressed()
    {
        return;
    }

    @Override
    public SceneType getSceneType()
    {
        return SceneType.SCENE_LOADING;
    }

    @Override
    public void disposeScene()
    {

    }
}