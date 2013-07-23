package com.kopp.Scene;


import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.AutoWrap;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.util.GLState;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import com.kopp.BaseScene.BaseScene;
import com.kopp.Manager.SceneManager;
import com.kopp.Manager.SceneManager.SceneType;


public class GameScene extends BaseScene implements IOnMenuItemClickListener
{
	

	
	private HUD gameHUD;
	
	private int health;
	private int mana;
	private int xp;
	private final int GAME_BACKPACK = 0;
	private final int GAME_MAP = 1;
	private final int INV_EXIT = 2;


	private MenuScene gameChildScene, inventoryChildScene;
	private ScaleMenuItemDecorator backpackHUDItem, mapHUDItem, exitButtonItem;
	private Sprite character1Portrait,character2Portrait,character3Portrait, inventoryGrid, equipmentArea, statsArea;
	private Rectangle charatcet1HealthBar, charatcet1ManaBar, charatcet1XpBar, 
					  charatcet2HealthBar, charatcet2ManaBar, charatcet2XpBar,
					  charatcet3HealthBar, charatcet3ManaBar, charatcet3XpBar;
	
	
	private void createGameChildScene()
	{
		health = 100;
		mana = 100;
		xp = 25;
		////////////////////////////////////////////////////////////////////////////////////
		//Set up Child Scene
		////////////////////////////////////////////////////////////////////////////////////
		gameChildScene = new MenuScene(camera);
		gameChildScene.setPosition(0, 0);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Create Menu Items
		////////////////////////////////////////////////////////////////////////////////////
		backpackHUDItem = new ScaleMenuItemDecorator(new SpriteMenuItem(GAME_BACKPACK, resourcesManager.backPack, vbom), 1.2f, 1);
		mapHUDItem = new ScaleMenuItemDecorator(new SpriteMenuItem(GAME_MAP, resourcesManager.worldMap, vbom), 1.2f, 1);
		
		
		////////////////////////////////////////////////////////////////////////////////////
		//Create Sprites
		////////////////////////////////////////////////////////////////////////////////////

		

		

        
        
		////////////////////////////////////////////////////////////////////////////////////
		//Attach entities
		////////////////////////////////////////////////////////////////////////////////////
		gameChildScene.addMenuItem(backpackHUDItem);
		gameChildScene.addMenuItem(mapHUDItem);		

		
		////////////////////////////////////////////////////////////////////////////////////
		//Set Positions
		////////////////////////////////////////////////////////////////////////////////////
		backpackHUDItem.setPosition(730, 410);
		mapHUDItem.setPosition(730, 5);

		
		
		gameChildScene.setBackgroundEnabled(false);
	    
		gameChildScene.setOnMenuItemClickListener(this);
		setChildScene(gameChildScene);
		
	}
	private void createInventoryChildScene()
	{
		////////////////////////////////////////////////////////////////////////////////////
		//Set up Child Scene
		////////////////////////////////////////////////////////////////////////////////////
		inventoryChildScene = new MenuScene(camera);
		inventoryChildScene.setPosition(0, 0);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Create Menu Items
		////////////////////////////////////////////////////////////////////////////////////

		
		
		////////////////////////////////////////////////////////////////////////////////////
		//Create Sprites
		////////////////////////////////////////////////////////////////////////////////////
		character1Portrait = new Sprite(0, 0, resourcesManager.character1Portrait, this.engine.getVertexBufferObjectManager());
		character2Portrait = new Sprite(0, 0, resourcesManager.character2Portrait, this.engine.getVertexBufferObjectManager());
		character3Portrait = new Sprite(0, 0, resourcesManager.character3Portrait, this.engine.getVertexBufferObjectManager());
		
		inventoryGrid = new Sprite(0, 0, resourcesManager.inventoryGid, this.engine.getVertexBufferObjectManager());
		equipmentArea = new Sprite(0, 0, resourcesManager.equipmentArea, this.engine.getVertexBufferObjectManager()); 
		statsArea = new Sprite(0, 0, resourcesManager.statsArea, this.engine.getVertexBufferObjectManager());
		
		
		////////////////////////////////////////////////////////////////////////////////////
		//Resource Bars
		////////////////////////////////////////////////////////////////////////////////////
		charatcet1HealthBar = new Rectangle(0,0,health * 1,20,this.engine.getVertexBufferObjectManager());
        charatcet1HealthBar.setColor(1.0f, 0, 0);
        charatcet1ManaBar = new Rectangle(0,0,mana * 1,20,this.engine.getVertexBufferObjectManager());
        charatcet1ManaBar.setColor(0, 0, 1.0f);
        charatcet1XpBar = new Rectangle(0,0,xp * 1,20,this.engine.getVertexBufferObjectManager());
        charatcet1XpBar.setColor(0, 1.0f, 1.0f);
        
        charatcet2HealthBar = new Rectangle(0,0,health * 1,20,this.engine.getVertexBufferObjectManager());
        charatcet2HealthBar.setColor(1.0f, 0, 0);
        charatcet2ManaBar = new Rectangle(0,0,mana * 1,20,this.engine.getVertexBufferObjectManager());
        charatcet2ManaBar.setColor(0, 0, 1.0f);
        charatcet2XpBar = new Rectangle(0,0,xp * 1,20,this.engine.getVertexBufferObjectManager());
        charatcet2XpBar.setColor(0, 1.0f, 1.0f);
        
        charatcet3HealthBar = new Rectangle(0,0,health * 1,20,this.engine.getVertexBufferObjectManager());
        charatcet3HealthBar.setColor(1.0f, 0, 0);
        charatcet3ManaBar = new Rectangle(0,0,mana * 1,20,this.engine.getVertexBufferObjectManager());
        charatcet3ManaBar.setColor(0, 0, 1.0f);
        charatcet3XpBar = new Rectangle(0,0,xp * 1,20,this.engine.getVertexBufferObjectManager());
        charatcet3XpBar.setColor(0, 1.0f, 1.0f);
        
        
		////////////////////////////////////////////////////////////////////////////////////
		//Attach entities
		////////////////////////////////////////////////////////////////////////////////////
		inventoryChildScene.attachChild(character1Portrait);
		inventoryChildScene.attachChild(character2Portrait);
		inventoryChildScene.attachChild(character3Portrait);
		
		inventoryChildScene.attachChild(inventoryGrid);
		
		inventoryChildScene.attachChild(charatcet1HealthBar);
		inventoryChildScene.attachChild(charatcet1ManaBar);
		inventoryChildScene.attachChild(charatcet1XpBar);
		
		inventoryChildScene.attachChild(charatcet2HealthBar);
		inventoryChildScene.attachChild(charatcet2ManaBar);
		inventoryChildScene.attachChild(charatcet2XpBar);
		
		inventoryChildScene.attachChild(charatcet3HealthBar);
		inventoryChildScene.attachChild(charatcet3ManaBar);
		inventoryChildScene.attachChild(charatcet3XpBar);
		
		inventoryChildScene.attachChild(equipmentArea);
		inventoryChildScene.attachChild(statsArea);
		
		
		inventoryChildScene.setBackgroundEnabled(false);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Set Positions
		////////////////////////////////////////////////////////////////////////////////////
		character1Portrait.setPosition(0, 50);
		character2Portrait.setPosition(250, 50);
		character3Portrait.setPosition(500, 50);
		
		inventoryGrid.setPosition(420, 140);
		
		charatcet1HealthBar.setPosition(60, 50);
		charatcet1ManaBar.setPosition(60, 70);
		charatcet1XpBar.setPosition(60, 90);
		
		charatcet2HealthBar.setPosition(310, 50);
		charatcet2ManaBar.setPosition(310, 70);
		charatcet2XpBar.setPosition(310, 90);
		
		charatcet3HealthBar.setPosition(560, 50);
		charatcet3ManaBar.setPosition(560, 70);
		charatcet3XpBar.setPosition(560, 90);
		
		equipmentArea.setPosition(210, 140);
		statsArea.setPosition(0, 140);
		
		
		setChildScene(inventoryChildScene);
		inventoryChildScene.setOnMenuItemClickListener(this);
		
	}
	private void createHUD()
	{
		gameHUD = new HUD();
		
	    camera.setHUD(gameHUD);
	}
	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
	{
		switch(pMenuItem.getID())
		{
	        case GAME_BACKPACK:
	        	createInventoryChildScene();
	            return true;
	        case GAME_MAP:
	        	return true;
	        default:
	            return false;
		}
	
	}
	private void addHealth(int newHealth)
	{
        health += newHealth;
        if (health >= 100)
                health = 100;
        charatcet1HealthBar.setWidth(health * 2);
	}
	private void subtractHealth(int newHealth)
	{
        health -= newHealth;
        if (health < 0)
                health = 0;
        charatcet1HealthBar.setWidth(health * 2);
	}
    @Override
    public void createScene()
    {
    	setBackground(new Background(Color.BLACK));
    	//createHUD();
    	createGameChildScene();
    }

    @Override
    public void onBackKeyPressed()
    {
    	setChildScene(gameChildScene);
    }

    @Override
    public SceneType getSceneType()
    {
    	return SceneType.SCENE_GAME;
    }

    @Override
    public void disposeScene()
    {
        this.detachSelf();
        this.dispose();
        
    }
    //TODO: Create onPause(), onResume(), 
}
