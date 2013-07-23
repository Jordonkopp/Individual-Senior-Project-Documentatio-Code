package com.kopp.Manager;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import android.graphics.Color;

import com.kopp.Game.MainGameActivity;


public class ResourceManager
{
    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------
    
    private static final ResourceManager INSTANCE = new ResourceManager();
    
    public Engine engine;
    public MainGameActivity activity;
    public Camera camera;
    public VertexBufferObjectManager vbom;
    
    public ITextureRegion companySplashLogo, andEngineLogo;
    private BitmapTextureAtlas splashTextureAtlas;
    
    public ITextureRegion menuBackgroundRegion;
    public ITextureRegion playButton, optionsButton, 
    					  warriorButton, knightButton, 
    					  assassinButton, engineerButton, 
    					  clericButton, mageButton, 
    					  rangerButton, playGameButton, 
    					  warriorCharacter, knightCharacter, 
    					  assassinCharacter, engineerCharacter, 
    					  clericCharacter, mageCharacter,
    					  character1Portrait,character2Portrait,
    					  character3Portrait, backPack,
    					  worldMap, inventoryGid, 
    					  equipmentArea, statsArea;
    
    private BuildableBitmapTextureAtlas menuTextureAtlas, characterSelectionTextureAtlas, gameTextureAtlas;
    
    public Font font;

    //////////////////////////////////////////////////////////////////////////
    //Load Resources for Menu Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadMenuResources()
    {
    	loadMenuGraphics();
        loadMenuAudio();
        loadMenuFonts();
        loadMenuTextures();
    }
    
    private void loadMenuGraphics()
    {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
    	menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	menuBackgroundRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "Background.jpg");
    	playButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "play.png");
    	optionsButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "options.png");
    	       
    	try 
    	{
    	    this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    this.menuTextureAtlas.load();
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
    }
    private void loadMenuAudio()
    {
        
    }   
    private void loadMenuFonts()
    {
        FontFactory.setAssetBasePath("font/");
        final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

        font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Droid.ttf", 30, true, Color.WHITE, 2, Color.BLACK);
        font.load();
    }
	public void loadMenuTextures()
	{
	        menuTextureAtlas.load();
	        
	}
	//////////////////////////////////////////////////////////////////////////
    //Unload Resources for Menu Scene
    //////////////////////////////////////////////////////////////////////////    
    public void unloadMenuTextures()
    {
        menuTextureAtlas.unload();
        menuBackgroundRegion = null;
    	playButton  = null;
    	optionsButton  = null;
    }
    //////////////////////////////////////////////////////////////////////////
    //Load Resources for Character Selection Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadCharacterSelectGraphics()
    {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
    	characterSelectionTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	
    	/////////////////////////////////////////////////////////////////////////////
    	//Character Selection Buttons
    	/////////////////////////////////////////////////////////////////////////////
    	warriorButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "warriorSelection.png");
    	knightButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "knightSelection.png");
    	assassinButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "assassinSelection.png");
    	engineerButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "engineerSelection.png");
    	clericButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "clericSelection.png");
    	mageButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "mageSelection.png");
    	rangerButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "rangerSelection.png");
    
    	/////////////////////////////////////////////////////////////////////////////
    	//Character Sprites
    	/////////////////////////////////////////////////////////////////////////////
    	warriorCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "warriorCharacter.png");
    	//knightCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "knightCharacter.png");
    	//assassinCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "assassinCharacter.png");
    	//engineerCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "engineerCharacter.png");
    	//clericCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "clericCharacter.png");
    	//mageCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "mageCharacter.png");
    	
    	
    	playGameButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "playGame.png");
    	try 
    	{
    	    characterSelectionTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
    	
    	characterSelectionTextureAtlas.load();
    }

    public void unloadCharacterSelectGraphics()
    {
    	characterSelectionTextureAtlas.unload();
    	warriorButton = null;
    	knightButton  = null;
    	assassinButton  = null;
    	engineerButton = null;
    	clericButton  = null;
    	mageButton  = null;
    	rangerButton  = null;
    	warriorCharacter = null;
    }
    //////////////////////////////////////////////////////////////////////////
    //Load Resources for Game Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadGameResources()
    {
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }
    
    private void loadGameGraphics()
    {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
    	gameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	
    	
    	
    	character1Portrait = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "portrait.jpg");
    	character2Portrait = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "portrait2.jpg");
    	character3Portrait = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "portrait3.jpg");
    	
    	inventoryGid = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "inventory.png");
    	
    	backPack = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "backpack.jpg");
    	
    	worldMap = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "worldMap.jpg");
    	
    	equipmentArea = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "currentEquipmentSlots.png");
    	
    	statsArea = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "statsArea.png");
    	
    	
    	try 
    	{
    	    gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
    	
    	gameTextureAtlas.load();
    }
    
    private void loadGameFonts()
    {
        
    }
    
    private void loadGameAudio()
    {
        
    }
    //////////////////////////////////////////////////////////////////////////
    //Unload Resources for Game Scene
    //////////////////////////////////////////////////////////////////////////
    public void unloadGameTextures()
    {
    	//TODO: Unload Game Textures
    	gameTextureAtlas.unload();
    }
    
    //////////////////////////////////////////////////////////////////////////
    //load Resources for Splash Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadSplashScreen()
    {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
    	splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
    	companySplashLogo = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
    	andEngineLogo = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "AndEngineLogo.jpg", 0, 0);
    	
    	splashTextureAtlas.load();
    }
    
    public void unloadSplashScreen()
    {
    	splashTextureAtlas.unload();
    	companySplashLogo = null;
    	andEngineLogo = null;
    }
   
    
    /**
     * @param engine
     * @param activity
     * @param camera
     * @param vbom
     * We use this method at beginning of game loading, to prepare Resources Manager properly,
     * setting all needed parameters, so we can latter access them from different classes (eg. scenes)
     */
    public static void prepareManager(Engine engine, MainGameActivity activity, Camera camera, VertexBufferObjectManager vbom)
    {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }
    
    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------
    
    public static ResourceManager getInstance()
    {
        return INSTANCE;
    }
}